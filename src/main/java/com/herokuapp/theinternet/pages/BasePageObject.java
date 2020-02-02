package com.herokuapp.theinternet.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import okio.Timeout;

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
	
	//JSExecutor Method
	protected void scrollToBottom() {
		log.info("Scrolling to bottom of page");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	//Method for Drag and Drop
	protected void performDragAndDrop(By from, By to) {
		//Actions action = new Actions(driver);
		//action.dragAndDrop(find(from) , find(to)).build().perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
				                    + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
				                    + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
				                    + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
				                    + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
				                    + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
				                    + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
				                    + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
				                    + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
				                    + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
				                    + "var dropEvent = createEvent('drop');\n"
				                    + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
				                    + "var dragEndEvent = createEvent('dragend');\n"
				                    + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
				                    + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
				                    + "simulateHTML5DragAndDrop(source,destination);", find(from), find(to));
	}
	
	//Method for Hover Over Function
	protected void hoverOverElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
}
