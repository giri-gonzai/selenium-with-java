package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicControlPage extends BasePageObject{

	private By removeCheckboxButtonLocator = By.tagName("button");	
	private By checkboxButtonLocator = By.xpath("//input[@type='checkbox']");
	private By checkboxRemovedMessageLocator = By.xpath("//p[@id='message']");
	
	private By textboxMessageLocator = By.xpath("//form[@id='input-example']/input[@type='text']");
	private By enableButtonLocator = By.xpath("//form[@id='input-example']/button[@type='button']");
	private By disableButtonLocator = By.xpath("/html//p[@id='message']");
	private By textboxLocator = By.xpath("//form[@id='input-example']/input[@type='text']");
	
	public DynamicControlPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	//Methods for Stale Element Test
	
	//Method for clicking on Checkbox
	public boolean clickCheckbox() {
		log.info("Clicking on Checkbox Tick");
		click(checkboxButtonLocator);
		log.info("Checkbox ticked");
		return find(checkboxButtonLocator).isSelected();
	}
	
	//Method for clicking on Remove Button
	public DynamicControlPage removeCheckbox() {
		log.info("Clicking on Remove Button");
		click(removeCheckboxButtonLocator);
		log.info("Remove button clicked");
		return new DynamicControlPage(driver, log);
	}
	
	//Method for wait for Removing checkbox
	public void checkboxRemoved() {
		log.info("Waiting for the checkbox to be removed");
		waitForVisibilityOf(checkboxRemovedMessageLocator, 5);
		log.info("Checkbox Removed");
	}
	
	//Method for checking whether checkbox is visible
	public boolean isCheckedBoxVisible() {
		log.info("Verifying if the checkbox is visible");
		List<WebElement> checkboxes = findAll(checkboxButtonLocator);
		for (WebElement checkboxLocator : checkboxes) {
			if (!checkboxLocator.isDisplayed()) {
				log.info("Checkbix is visible");
				return false;
			}
		}
		log.info("Checkbox is not visible");
		return true;
	}
	
	//Method for Getting Success Message
	public String getSuccessMessage() {
		return find(checkboxRemovedMessageLocator).getText();
	}
	
	//Methods for Disabled Element Test
	public boolean isTextboxEnabled() {
		log.info("Checking whether the textbox is disabled");
		List<WebElement> textboxes = findAll(textboxMessageLocator);
		for (WebElement textboxMessageLocator : textboxes) {
			if(textboxMessageLocator.isEnabled()) {
				log.info("Textbox is enabled");
				return true;
			}
		}
		log.info("Textbox is not enabled");
		return false;
	}
	
	//Method for clicking on Enable Button
	public boolean clickEnableButton() {
		log.info("Clicking on the Enable button");
		click(enableButtonLocator);
		log.info("Enable button is clicked");
		return find(enableButtonLocator).isSelected();
	}

	//Method for waiting for the Enalbe Success Message to be visible
	public boolean isDisableButtonVisible() {
		log.info("Waiting for the Disable Button to be visible");
		waitForVisibilityOf(disableButtonLocator, 7);
		List<WebElement> disableButton = findAll(disableButtonLocator);
		for (WebElement disableButtonLocator : disableButton) {
			if (disableButtonLocator.isEnabled()) {
				log.info("Disable Button is enabled");
				return true;
			}
		}
		log.info("Disable Button is not enabled");
		return false;
	}
	
	//Method for entering text onto Textbox
	public DynamicControlPage inputText(String text) {
		log.info("Entering text onto textbox [" + text + "]");
		type(text, textboxLocator);
		log.info("Text is entered onto Textbox");
		return new DynamicControlPage(driver, log);
	}
	
	//Method for getting the entered text
	public String getEnteredMessage() {
		return find(textboxLocator).getText();
	}
}
