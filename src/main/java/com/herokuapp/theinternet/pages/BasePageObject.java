package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject {

	protected WebDriver driver;
	protected Logger log;
	
	public BasePageObject(WebDriver driver, Logger log) {
		this.driver = driver;
		this.log = log;
	}
	
	//Open URL 
	protected void openUrl(String url) {
		driver.get(url);
	}
	
	//Find Element using given locator
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	//Click on the locator
	protected void click(By locator) {
		waitForVisibilotyOf(locator, 10);
		find(locator).click();
	}
	
	//Type - Input in the text field by locator
	protected void type(String text, By locator) {
		waitForVisibilotyOf(locator, 5);
		find(locator).sendKeys(text);
	}
	
	/*
	 * //View - Method for Explicit Wait for an element to be visible protected void
	 * waitForElement(By locator) { waitForVisibilotyOf(locator, 5);
	 * find(locator).isDisplayed(); }
	 */
	
	//Method for Expected Conditions
	private void waitFor(ExpectedCondition <WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}

	//Method for waitForVisibilityOf
	private void waitForVisibilotyOf(By locator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator), 
						(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
				
			} attempts++;
		}
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
}
