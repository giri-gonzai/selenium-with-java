package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDownPage extends BasePageObject{

	private By dropdownOptionLocator = By.id("dropdown");
	
	public DropDownPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	//Method for selecting the option from Dropdown menu
	public void selectDropDownOption(int i) {
		log.info("Selecting option " + i + " from dropdown menu");
		WebElement dropdownElement = find(dropdownOptionLocator);
		Select dropdownOptionLocator = new Select(dropdownElement);
		
		//Different ways to call dropdown options
		// #1
		//dropdownOptionLocator.selectByIndex(index);
		
		// #2
		dropdownOptionLocator.selectByValue("" + i);
		
		// #3
		//dropdownOptionLocator.selectByVisibleText(text);
	}
	
	//Method returns what option is selected
		public String getSelectedDropDownOption() {
		WebElement dropdownElement = find(dropdownOptionLocator);
		Select dropdownOptionLocator = new Select(dropdownElement);
		String getSelectedOption = dropdownOptionLocator.getFirstSelectedOption().getText();
		log.info("The selected option is: " + getSelectedOption);
		return getSelectedOption;
	}
}
