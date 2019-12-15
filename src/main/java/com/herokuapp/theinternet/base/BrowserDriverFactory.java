package com.herokuapp.theinternet.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;

	public BrowserDriverFactory(String browser) {
		this.browser = browser.toLowerCase();
	}
	
	public WebDriver createBrowser() {
		
	System.out.println("Creating browser instance:  " + browser);
	
	switch(browser){
	
	case "chrome":
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver.set(new ChromeDriver());
		break;
	}
	
	return driver.get();
		
	}

}
