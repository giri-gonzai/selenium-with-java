package com.herokuapp.theinternet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_Tests {

	private WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	private void setUp() {

		// Create Browser Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();

		// Open Main URL
		System.out.println("Starting test method: login_Test");
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		// Implicit Wait
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	private void closeUp() {

		// Closer Browser Instance
		driver.quit();
	}

	@Parameters({ "username", "password" })
	@Test(priority = 1, groups = { "positiveTest", "smokeTest" })
	public void positive_LoginTest(String username, String password) {

		// Open the Form Authentication URL
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/login']")).click();
		System.out.println("Opening the Form Authentication Page");
		// Thread.sleep(3000);

		// Enter Username
		System.out.println("Entering Username");
		driver.findElement(By.id("username")).sendKeys(username);

		// Enter Password
		System.out.println("Entering Password");
		driver.findElement(By.id("password")).sendKeys(password);

		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Click Login
		System.out.println("Click Login Button");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']")));
		driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']")).click();

		// Verification Steps
		// Verify the 'secure' URL
		var urlAssertion = driver.getCurrentUrl();
		System.out.println("Verifying the URL");
		Assert.assertEquals("https://the-internet.herokuapp.com/secure", urlAssertion);

		// Verify the successful login button
		System.out.println("Verifying the login div");
		driver.findElement(By.xpath("//div[@id='flash']")).isDisplayed();

		// Verify the 'Logout' button
		System.out.println("Verifying the logout button");
		driver.findElement(By.xpath("//a[@class='button secondary radius']")).isDisplayed();

		// Advanced Verification
		// Check the HTTP Response of the Successful login page
		// Check the API Response
	}

	@Parameters({ "username", "password" })
	@Test(priority = 2, groups = { "negativeTest", "smokeTest" })
	public void negative_LoginTest_Incorrect_Username(String username, String password) {

		// Create Browser Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();

		// Open Main URL
		System.out.println("Starting test method: login_Test");
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		// Open the Form Authentication URL
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/login']")).click();
		System.out.println("Opening the Form Authentication Page");
		// Thread.sleep(3000);

		// Enter Username
		System.out.println("Entering Username");
		driver.findElement(By.id("username")).sendKeys(username);

		// Enter Password
		System.out.println("Entering Password");
		driver.findElement(By.id("password")).sendKeys(password);

		// Click Login
		System.out.println("Click Login Button");
		driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']")).click();

		// Verification Steps
		// Verify the 'secure' URL
		var urlAssertion = driver.getCurrentUrl();
		System.out.println("Verifying the URL");
		Assert.assertEquals("https://the-internet.herokuapp.com/login", urlAssertion);

		// Verifying the message
		System.out.println("Verifying the incorrect login message");
		driver.findElement(By.xpath("//div[@class='flash error']")).isDisplayed();

	}

	@Parameters({ "username", "password" })
	@Test(priority = 3, groups = { "negativeTest", "smokeTest" })
	public void negative_LoginTest_Incorrect_Password(String username, String password) {

		// Create Browser Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();

		// Open Main URL
		System.out.println("Starting test method: login_Test");
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		// Open the Form Authentication URL
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/login']")).click();
		System.out.println("Opening the Form Authentication Page");
		// Thread.sleep(3000);

		// Enter Username
		System.out.println("Entering Username");
		driver.findElement(By.id("username")).sendKeys(username);

		// Enter Password
		System.out.println("Entering Password");
		driver.findElement(By.id("password")).sendKeys(password);

		// Click Login
		System.out.println("Click Login Button");
		driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']")).click();

		// Verification Steps
		// Verify the 'secure' URL
		var urlAssertion = driver.getCurrentUrl();
		System.out.println("Verifying the URL");
		Assert.assertEquals("https://the-internet.herokuapp.com/login", urlAssertion);

		// Verifying the message
		System.out.println("Verifying the incorrect login message");
		driver.findElement(By.xpath("//div[@class='flash error']")).isDisplayed();

	}

}
