package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
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
	
	//Find All Element using the locator
	protected List<WebElement> findAll(By locator) {
		return driver.findElements(locator);
	}
	
	//Click on the locator
	protected void click(By locator) {
		waitForVisibilityOf(locator, 10);
		find(locator).click();
	}
	
	//Type - Input in the text field by locator
	protected void type(String text, By locator) {
		waitForVisibilityOf(locator, 5);
		find(locator).sendKeys(text);
	}
	
	//Method for Expected Conditions
	protected void waitFor(ExpectedCondition <WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}

	//Method for waitForVisibilityOf
	protected void waitForVisibilityOf(By locator, Integer... timeOutInSeconds) {
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
	
	//Method for Getting the Current Page URL
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	//Method for Switching to Alert
	public Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}
}
