package com.herokuapp.theinternet;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Login_Exceptions_Tests {

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

	/*
	 * @Test public void dynamic_Loading() {
	 * 
	 * // Navigate to Dynamic Loading page driver.findElement(By.xpath(
	 * "//div[@id='content']/ul//a[@href='/dynamic_loading']")).click();
	 * 
	 * // Navigate to Locator Page driver.findElement(By.xpath(
	 * "//div[@id='content']//a[@href='/dynamic_loading/1']")).click();
	 * 
	 * // Locate the Start button
	 * driver.findElement(By.xpath("//div[@id='start']/button[.='Start']")).click();
	 * 
	 * // Verify the 'Hello World' WebElement finishElement =
	 * driver.findElement(By.id("finish"));
	 * 
	 * // Explicit Wait WebDriverWait wait = new WebDriverWait(driver, 10);
	 * wait.until(ExpectedConditions.visibilityOf(finishElement)); String finishText
	 * = finishElement.getText(); Assert.assertEquals(finishText, "Hello World!" ,
	 * "Exception: The actual value is not as the expected value"); }
	 */
	
	@Test
	public void dynamic_Loading_Timeout() {

		// Navigate to Dynamic Loading page
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/dynamic_loading']")).click();

		// Navigate to Locator Page
		driver.findElement(By.xpath("//div[@id='content']//a[@href='/dynamic_loading/1']")).click();

		// Locate the Start button
		driver.findElement(By.xpath("//div[@id='start']/button[.='Start']")).click();

		// Verify the 'Hello World'
		WebElement finishElement = driver.findElement(By.id("finish"));

		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 2);
		try {
			wait.until(ExpectedConditions.visibilityOf(finishElement));
		} catch (TimeoutException exception) {
			System.out.println("Timeout Exception captured: " + exception.getMessage());
		}
		String finishText = finishElement.getText();
		Assert.assertEquals(finishText, "Hello World!" , "Exception: The actual value is not as the expected value");
	}

	@AfterMethod(alwaysRun = true)
	private void closeUp() {

		// Closer Browser Instance
		driver.quit();
	}

}
