package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends BasePageObject {
	
	private By checkboxesButtonLocator = By.xpath("//input[@type='checkbox']");
	
	public CheckboxesPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	//Method for Clicking on all checkboxes
	public void clickAllCheckboxes() {
		log.info("Clicking on all checkboxes");
		List<WebElement> checkboxes = findAll(checkboxesButtonLocator);
		for (WebElement checkboxesButtonLocator : checkboxes) {
			if (!checkboxesButtonLocator.isSelected()) {
				log.info("All checkboxes are selected");
				checkboxesButtonLocator.click();
			}
		}
	}
	
	//Verifying that all the checkboxes are selected
	public boolean isAllCheckboxesSelected() {
		log.info("Checking whether all the checkboxes are selected");
		List<WebElement> checkboxes = findAll(checkboxesButtonLocator);
		for (WebElement checkboxesButtonLocator : checkboxes) { 
			if (!checkboxesButtonLocator.isSelected()) {
				log.info("All Checkboxes are not selected");
				return false;
			}
		}
		log.info("All checkboxes are selected");
		return true;
	}
}
