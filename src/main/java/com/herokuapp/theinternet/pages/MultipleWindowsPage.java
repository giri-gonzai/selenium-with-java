package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MultipleWindowsPage extends BasePageObject{

	private By newWindowButtonLocator = By.xpath("//a[@href='/windows/new']");
	
	public MultipleWindowsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	//Method of clicking on New Window Button
	public void openNewWindowButton() {
		log.info("Clicking on new window button");
		click(newWindowButtonLocator);
	}
	
	public MultipleWindowsPage switchToNewWindow() {
		log.info("Switching the control onto the new window titled 'New Window'");
		switchToWindowWithTitle("New Window");
		return new MultipleWindowsPage(driver, log);
	}
}
