package com.herokuapp.theinternet.base;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;
	private Logger log;

	public BrowserDriverFactory(String browser, Logger log) {
		this.browser = browser.toLowerCase();
		this.log = log;								//Adding the log4J method inside BrowserDriverFactory
	}
	
	public WebDriver createBrowser() {
		
	log.info("Creating browser instance:  " + browser);
	
	switch(browser){
	
	case "chrome":
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver.set(new ChromeDriver());
		break;
	}
	
	return driver.get();
		
	}

}
