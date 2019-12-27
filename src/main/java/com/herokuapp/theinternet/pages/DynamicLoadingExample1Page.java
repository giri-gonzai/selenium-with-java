package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingExample1Page extends BasePageObject {

	private By dynamicLoadingExample1StartLocator = By.id("start");
	
	private By dynamicLoadingExample1HiddenElementLocator = By.id("finish");
	
	public DynamicLoadingExample1Page(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public void clickStart() {
		log.info("Clicking on Start button for Example 1");
		click(dynamicLoadingExample1StartLocator);
	}
	
	public String isElementVisible() {
		return find(dynamicLoadingExample1HiddenElementLocator).getText();
	}

}
