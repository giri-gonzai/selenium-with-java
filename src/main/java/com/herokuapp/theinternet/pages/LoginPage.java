package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

	private By usernameLocator = By.id("username");
	private By passwordLocator = By.id("password");
	private By loginButtonLocator = By.tagName("button");
	
	public LoginPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public SecureAreaPage logIn(String username, String password) {
		
		log.info("Entering login credentials");
		log.info("Entering Username [" + username + "] and password [" + password + "]");
		type(username, usernameLocator);	//Invoking custom method for type input
		type(password, passwordLocator);
		click(loginButtonLocator);			//Invoking custom method for click for locator
		return new SecureAreaPage(driver, log);
		
	}

}
