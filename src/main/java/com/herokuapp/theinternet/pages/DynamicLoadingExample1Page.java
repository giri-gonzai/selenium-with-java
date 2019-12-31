package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingExample1Page extends BasePageObject {

	private By dynamicLoadingExample1StartLocator = By.tagName("button");
	private By dynamicLoadingExample1HiddenElementLocator = By.xpath("//div[@id='finish']");

	public DynamicLoadingExample1Page(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public DynamicLoadingExample1Page clickStart() {
		click(dynamicLoadingExample1StartLocator);
		log.info("Clicking on Start button for Example 1");
		return new DynamicLoadingExample1Page(driver, log);
	}

	public void waitForText() {
		log.info("Waiting for hidden element to be visible");
		waitForVisibilityOf(dynamicLoadingExample1HiddenElementLocator, 7);
		log.info("Hidden element loaded");
	}

	public String getElementText() {
		log.info("Hidden element found");
		return find(dynamicLoadingExample1HiddenElementLocator).getText();
	}

}
