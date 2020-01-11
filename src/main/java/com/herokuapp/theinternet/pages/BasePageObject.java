package com.herokuapp.theinternet.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
	
	//Method for Sending Keyboard input
	protected void keyPressInput(By locator, Keys value) {
		waitForVisibilityOf(locator, 5);
		find(locator).sendKeys(Keys.values());
	}
	
	//Method for Sending Keyboard input using Action Class
	public void keyPressActionInput(Keys value) {
		log.info("Pressing the key " + value.name() + " using Action class");
		Actions action = new Actions(driver);
		action.sendKeys(value).build().perform();
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
	protected Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert();
	}
	
	//Method to Switching to new window tab with title
	protected void switchToWindowWithTitle(String expectedTitle) {
		
		//Getting the window handle of current window
		String firstWindow = driver.getWindowHandle();
		
		//Switching to new window handle
		Set<String> allWindows = driver.getWindowHandles();
		Iterator<String> windowIterator = allWindows.iterator();
		
		while (windowIterator.hasNext()) {
			String windowHandle = windowIterator.next().toString();
			
			if(!windowHandle.equals(firstWindow)) {
				driver.switchTo().window(windowHandle);
				
				if(getCurrentUrl().contains(expectedTitle)) {
					break;
				}
			}
		}
	}

	//Method to Switch to iFrame
	protected void switchToIFrame(By frameLocator) {
		driver.switchTo().frame(find(frameLocator));
	}
	
	//Method to Switch out of iFrame
	protected void switchOutOfIFrame() {
		driver.switchTo().defaultContent();
	}
}
