package com.herokuapp.theinternet.loginpagetests;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;

public class NegativeLoginTests extends TestUtilities {

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
	 * = finishElement.getText(); Assert.assertEquals(finishText, "Hello World!",
	 * "Exception: The actual value is not as the expected value"); }
	 */

	@Test(groups = { "exception-timeout" })
	public void dynamic_Loading_Timeout() {

		// Navigate to Dynamic Loading page
		driver.findElement(By.xpath("//div[@id='content']/ul//a[@href='/dynamic_loading']")).click();
		pageTitle();

		// Navigate to Locator Page
		driver.findElement(By.xpath("//div[@id='content']//a[@href='/dynamic_loading/1']")).click();
		pageTitle();

		// Locate the Start button
		driver.findElement(By.xpath("//div[@id='start']/button[.='Start']")).click();
		pageTitle();

		// Verify the 'Hello World'
		WebElement finishElement = driver.findElement(By.id("finish"));

		// Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions.visibilityOf(finishElement));
		} catch (TimeoutException exception) {
			log.info("Timeout Exception captured: " + exception.getMessage());
		}
		String finishText = finishElement.getText();
		Assert.assertEquals(finishText, "Hello World!", "Exception: The actual value is not as the expected value");
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

	}

}
