package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage extends BasePageObject{

	private By example1Locator = By.xpath("//a[@href='/dynamic_loading/1']");
	//private By exmaple2Locator = By.xpath("//a[@href='/dynamic_loading/2']");
	
	public DynamicLoadingPage(WebDriver driver, Logger log) {
		super(driver, log);		
	}
	
	public DynamicLoadingExample1Page clickDynamicLoadingExample1() {
		
		log.info("Clicking on Dynamic Loading Example 1");
		click(example1Locator);
		return new DynamicLoadingExample1Page(driver, log);
	}

}
