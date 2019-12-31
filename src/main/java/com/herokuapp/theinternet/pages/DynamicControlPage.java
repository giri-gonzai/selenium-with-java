package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicControlPage extends BasePageObject{

	private By removeCheckboxButtonLocator = By.tagName("button");	
	private By checkboxLocator = By.xpath("//input[@type='checkbox']");
	private By checkboxRemovedMessageLocator = By.xpath("//p[@id='message']");
	
	public DynamicControlPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public boolean clickCheckbox() {
		log.info("Clicking on Checkbox Tick");
		click(checkboxLocator);
		log.info("Checkbox ticked");
		return find(checkboxLocator).isSelected();
	}
	
	public DynamicControlPage removeCheckbox() {
		log.info("Clicking on Remove Button");
		click(removeCheckboxButtonLocator);
		log.info("Remove button clicked");
		return new DynamicControlPage(driver, log);
	}
	
	public void checkboxRemoved() {
		log.info("Waiting for the checkbox to be removed");
		waitForVisibilityOf(checkboxRemovedMessageLocator, 5);
		log.info("Checkbox Removed");
	}
	
	public boolean isCheckedBoxVisible() {
		log.info("Verifying if the checkbox is visible");
		List<WebElement> checkboxes = findAll(checkboxLocator);
		for (WebElement checkboxLocator : checkboxes) {
			if (!checkboxLocator.isDisplayed()) {
				log.info("Checkbix is visible");
				return false;
			}
		}
		log.info("Checkbox is not visible");
		return true;
	}

}
