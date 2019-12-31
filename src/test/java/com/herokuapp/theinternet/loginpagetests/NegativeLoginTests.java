package com.herokuapp.theinternet.loginpagetests;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DynamicControlPage;
import com.herokuapp.theinternet.pages.DynamicLoadingExample1Page;
import com.herokuapp.theinternet.pages.DynamicLoadingPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class NegativeLoginTests extends TestUtilities {
	
	@Test(groups = { "explicit-wait" } )
	public void negativeTestExplicitWait() {
		log.info("Starting Negative Tests: ");
		
		//Opening the Web App Home Page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();
		
		//Clicking on Dynamic Loading Link
		DynamicLoadingPage dynamicLoadingPage = welcomePage.clickDynamicLoadingLink();
		
		//Clicking on Dynamic Loading Example 1 Link
		DynamicLoadingExample1Page dynamicLoadingExample1Page = dynamicLoadingPage.clickDynamicLoadingExample1();
		
		//Clicking on Start button
		dynamicLoadingExample1Page.clickStart();
		
		//Waiting for the hidden element to be visible
		dynamicLoadingExample1Page.waitForText();
		
		//Getting the hidden element text
		dynamicLoadingExample1Page.getElementText();
		
		Assert.assertEquals(dynamicLoadingExample1Page.getElementText(), "Hello World!");
	}
	
	@Test(groups = { "stale-element-test" }) 
	public void negativeTestStaleElement() {
		log.info("Starting Negative Test for Stale Element Test");
		
		//Opening the Web App Home Page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();
		
		//Clicking on the Dynamic Control Link
		DynamicControlPage dynamicControlPage = welcomePage.clickDynamicControlLink();
		
		//Selecting the CheckBox Element
		dynamicControlPage.clickCheckbox();
		
		//Clicking on the Remove Button
		dynamicControlPage.removeCheckbox();
		
		//Waiting for Checkbox to be removed
		dynamicControlPage.checkboxRemoved();
		
		//Verifying the Checkbox Element is not visible
		Assert.assertTrue(dynamicControlPage.isCheckedBoxVisible(), "Checkbox is visible");
		
		//Verifying the Text Returned from Removing Checkbox
	}
	

	@Test(groups = { "exception-stale-element-test" })
	public void stale_Element_Test_Exception() {

		// Navigating to Dynamic Control Page
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/dynamic_controls']")).click();
		pageTitle();	// Calling Test Utilities Function

		// Locator for Checkbox
		WebElement checkboxElement = driver.findElement(By.id("checkbox"));
		pageTitle();	// Calling Test Utilities Function
		checkboxElement.click();

		// Locator for Button
		driver.findElement(By.xpath("//form[@id='checkbox-example']/button[@type='button']")).click();
		pageTitle();	// Calling Test Utilities Function

		// Explicit Wait - Using invisibilityof for which test will continue when the
		// element becomes invisible within given time
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			// wait.until(ExpectedConditions.invisibilityOf(checkboxElement));
			// Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(checkboxElement)));
			Assert.assertTrue(wait.until(ExpectedConditions.stalenessOf(checkboxElement)));
		} catch (TimeoutException exception) {
			log.info("Timeout Exception captured: " + exception.getMessage());
		}

		WebElement addElement = driver.findElement(By.xpath("//form[@id='checkbox-example']/button[@type='button']"));
		addElement.click();

		Assert.assertTrue(wait.until(ExpectedConditions.invisibilityOf(checkboxElement)));
		
		closeUp();

	}

	@Test(groups = { "exception-disabled-test" })
	public void disabled_Element_Exception() {

		// Navigating to Dynamic Control Page
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/dynamic_controls']")).click();

		// Calling Test Utilities Function
		pageTitle();

		// Define the web elements
		WebElement enableButton = driver.findElement(By.xpath("//button[contains(text(), 'Enable')]"));
		WebElement textField = driver.findElement(By.xpath("(//input)[2]"));

		// Click on Enable button
		enableButton.click();

		// Wait for the text field to be enabled
		WebDriverWait wait = new WebDriverWait(driver, 10);

		// Verify the text field is enabled
		wait.until(ExpectedConditions.elementToBeClickable(textField));

		// Input text into enabled text field
		textField.sendKeys("Text field is enabled");

		// Verify the text by getText() against the entered text
		Assert.assertEquals(textField.getAttribute("value"), "Text field is enabled");
		
		closeUp();

	}

}
