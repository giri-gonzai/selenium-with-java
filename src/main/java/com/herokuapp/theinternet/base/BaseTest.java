package com.herokuapp.theinternet.base;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {

	protected WebDriver driver;
	protected Logger log;

	@Parameters({ "broswer" })
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser, ITestContext ctx) {

		//Setting the Log4J for getting the test names
		String testName = ctx.getCurrentXmlTest().getName();
		log = LogManager.getLogger(testName);
		
		//Calling the Browser Driver Factory Model
		BrowserDriverFactory factory = new BrowserDriverFactory(browser, log);
		driver = factory.createBrowser();
		
		// Open Main URL
		//System.out.println("Starting test method: login_Test");
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		// Implicit Wait
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public void closeUp() {

		// Closer Browser Instance
		driver.quit();
	}
}