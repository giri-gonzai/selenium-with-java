package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePageObject { 

	private String pageUrl = "https://the-internet.herokuapp.com/secure";
	private By logOutButtonLocator = By.xpath("//a[@href='/logout']");
	private By successMessageLocator = By.id("flash-message");
	
	public SecureAreaPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public String getPageUrl() {
		return pageUrl;
	}
	
	public boolean isLogOutVisible() {
		return find(logOutButtonLocator).isDisplayed();
	}
	
	public String getSuccessMessage() {
		return find(successMessageLocator).getText();
	}

}
