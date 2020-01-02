package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JavaScriptAlertPage extends BasePageObject{

	private By javascriptAlertButtonLocator = By.xpath("//button[text()='Click for JS Alert']");
	
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
	//Get the text from the JS Confirm
	//Click Cancel
	//Get the Text from Result Tag (Verify using 'contains' assertion)
	//Click on JS Confirm Again
	//Click OK
	//Get the Text from Result Tag (Verify using 'contains' assertion)
	//--------------------------------------------------------------//
	
	
	//--------------------------------------------------------------//
	//Method for JS Prompt
	//Get the text from JS Prompt
	//Sendkeys to the textbox to the Prompt
	//Click OK
	//Get the Text from Result Tag (Verify using 'contains' assertion)
	//--------------------------------------------------------------//
	
	
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
