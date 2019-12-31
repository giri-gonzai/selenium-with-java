package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicControlPage extends BasePageObject{

	private By removeCheckboxButtonLocator = By.tagName("button");	
	private By checkboxLocator = By.xpath("//input[@type='checkbox']");
	private By checkboxRemovedMessageLocator = By.xpath("//p[@id='message']");
	
	public DynamicControlPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public DynamicControlPage removeCheckbox() {
		log.info("Clicking on Remove Button");
		click(removeCheckboxButtonLocator);
		log.info("Remove button clicked");
		return new DynamicControlPage(driver, log);
	}
	
	public boolean clickCheckbox() {
		log.info("Clicking on Checkbox Tick");
		click(checkboxLocator);
		log.info("Checkbox ticked");
		return find(checkboxLocator).isSelected();
	}
	
	public void checkboxRemoved() {
		log.info("Waiting for the checkbox to be removed");
		waitForVisibilityOf(checkboxRemovedMessageLocator, 5);
		log.info("Checkbox Removed");
	}

}
