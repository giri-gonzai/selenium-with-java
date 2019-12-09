package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Login_Test_Positive {
	
	@Test(priority = 1)
	public void login_Test() {
		
		//Create Browser Driver
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		//Open Main URL
		System.out.println("Starting test method: login_Test");
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		//Open the Form Authentication URL
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/login']")).click();
		System.out.println("Opening the Form Authentication Page");
		//Thread.sleep(3000);
		
		//Enter Username
		System.out.println("Entering Username");
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		
		//Enter Password
		System.out.println("Entering Password");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		
		//Click Login
		System.out.println("Click Login Button");
		driver.findElement(By.xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']")).click();
		
		//Verification Steps
		//Verify the 'secure' URL
		var urlAssertion = driver.getCurrentUrl();
		System.out.println("Verifying the URL");
		Assert.assertEquals("https://the-internet.herokuapp.com/secure", urlAssertion);
		
		
		//Verify the successful login button
		System.out.println("Verifying the login div");
		driver.findElement(By.xpath("//div[@id='flash']")).isDisplayed();
		
		//Verify the 'Logout' button
		System.out.println("Verifying the logout button");
		driver.findElement(By.xpath("//a[@class='button secondary radius']")).isDisplayed();
		
		//Close Browser
		driver.quit();
		
		//Advanced Verification
		//Check the HTTP Response of the Successful login page
		//Check the API Response
	}

}
