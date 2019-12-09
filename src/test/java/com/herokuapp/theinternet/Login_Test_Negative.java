package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Login_Test_Negative {

	@Test(groups = { "smokeTest" })
	public void incorrect_username_test() {

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
		driver.findElement(By.id("username")).sendKeys("incorrect");

		// Enter Password
		System.out.println("Entering Password");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

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

		// Closer Browser Instance
		driver.quit();
	}

	@Test(enabled = false)
	public void incorrect_password_test() {

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
		driver.findElement(By.id("username")).sendKeys("incorrect");

		// Enter Password
		System.out.println("Entering Password");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");

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

		// Closer Browser Instance
		driver.quit();
	}
}
