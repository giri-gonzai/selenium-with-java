package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressPage extends BasePageObject{

	private By keyPressInputLinkLocator = By.id("target");
	private By keyPressResultLinkLocator = By.id("result");
	
	public KeyPressPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	//Method for Entering Keyboard Input
	public void sendKeyPressInput(Keys value) {
		log.info("Sending Keyboard: Enter");
		keyPressInput(keyPressInputLinkLocator, value);
	}
	
	//Method for Getting the Result of the Key Press Input
	public String sentKeyPressResult() {
		waitForVisibilityOf(keyPressResultLinkLocator, 5);
		String text = find(keyPressResultLinkLocator).getText();
		log.info("The key pressed is: " + text);
		return text;
	}

}
