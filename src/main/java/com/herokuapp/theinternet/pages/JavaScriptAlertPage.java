package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage extends BasePageObject{

	private By javascriptAlertButtonLocator = By.xpath("//button[text()='Click for JS Alert']");
	private By javascriptConfirmButtonLocator = By.xpath("//button[text()='Click for JS Confirm']");
	private By javascriptPromptButtonLocator = By.xpath("//button[text()='Click for JS Prompt']");
	private By javascriptResultLocator = By.id("id");
	
	public JavaScriptAlertPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	//--------------------------------------------------------------//
	//Method for JS Alert
	public void clickJSAlert() {
		log.info("Clicking on button for JS Alert");
		click(javascriptAlertButtonLocator);
	}	
	
	//Get the text from the Alert
	//Click on OK
	//Get the text from Result Tag (Verify using 'contains' assertion)
	//--------------------------------------------------------------//

	
	//--------------------------------------------------------------//
	//Method for JS Confirm
	public void clickJSConfirm() {
		log.info("Clicking on button for JS Confirm");
		click(javascriptConfirmButtonLocator);
	}
	//Get the text from the JS Confirm
	//Click Cancel
	//Get the Text from Result Tag (Verify using 'contains' assertion)
	//Click on JS Confirm Again
	//Click OK
	//Get the Text from Result Tag (Verify using 'contains' assertion)
	//--------------------------------------------------------------//
	
	
	//--------------------------------------------------------------//
	//Method for JS Prompt
	public void clickJSPrompt() {
		log.info("Clicking on button for JS Prompt");
		click(javascriptPromptButtonLocator);
	}
	//Get the text from JS Prompt
	//Sendkeys to the textbox to the Prompt
	//Click OK
	//Get the Text from Result Tag (Verify using 'contains' assertion)
	//--------------------------------------------------------------//
	
	//Method for getting the Result Text
	public String getResultText() {
		String text = find(javascriptResultLocator).getText();
		log.info("The result for JS Action is: " + text);
		return text;
	}
	
	
	//--------------------------------------------------------------//
	//Click on JS Prompt again
	//Get the text from JS Prompt
	//Sendkeys to the textbox to the Prompt
	//Click Cancel
	//Get the Text from Result Tag (Verify using 'contains' assertion)
	//--------------------------------------------------------------//
	
	
	//--------------------------------------------------------------//
	//Click on JS Prompt again
	//Get the text from JS Prompt
	//Sendkeys to the textbox to the Prompt
	//Click Cancel
	//Get the Text from Result Tag (Verify using 'contains' assertion)
	//--------------------------------------------------------------//
}
