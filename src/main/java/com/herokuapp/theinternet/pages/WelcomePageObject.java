package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject {

	private String pageUrl = "https://the-internet.herokuapp.com/";	
	private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
	private By dyanmicLoadingLinkLocator = By.xpath("//a[@href='/dynamic_loading']");
	private By dynamicControlLinkLocator = By.xpath("//a[@href='/dynamic_controls']");
	private By checkboxesLinkLocator = By.xpath("//a[@href='/checkboxes']");
	private By dropdownLinkLocator = By.xpath("//a[@href='/dropdown']");
	private By javascriptAlertLinkLocator = By.xpath("//a[@href='/javascript_alerts']");
	private By multipleWindowsLinkLocator = By.xpath("//a[@href='/windows']");
	private By frameLinkLocator = By.xpath("//a[@href='/frames']");
	private By keyPressLinkLocator = By.xpath("//a[@href='/key_presses']");
	private By fileUploadLinkLocator = By.xpath("//a[@href='/upload']");
	
	//Setting Constructor for the POM Class
	public WelcomePageObject(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	//Opening the URL method
	public void OpenPage() {
		
		log.info("Opening page: " + pageUrl);		//Opening The Internet Heroku Page
		openUrl(pageUrl);							//Commanding the browser to open the URL
		log.info("Page successfully opened.");
		
	}
	
	//Clicking on the Form Authentication Link
	public LoginPage clickAuthenticationFormLink() {
		
		log.info("Clicking on Form Authentication Link");
		click(formAuthenticationLinkLocator);	
		return new LoginPage(driver, log);
	}
	
	//Click on the Dynamic Loading Link
	public DynamicLoadingPage clickDynamicLoadingLink() {
		
		log.info("Clicking on Dynamic Loading Link");
		click(dyanmicLoadingLinkLocator);
		return new DynamicLoadingPage(driver, log);
	}
	
	//Click on the Dynamic Control Link
	public DynamicControlPage clickDynamicControlLink() {
		log.info("Clicking on Dynamic Control Link");
		click(dynamicControlLinkLocator);
		return new DynamicControlPage(driver, log);
	}
	
	//Click on Checkboxes Link
	public CheckboxesPage clickCheckboxesLink() {
		log.info("Clicking on Checkboxes Link");
		click(checkboxesLinkLocator);
		return new CheckboxesPage(driver, log);
	}
	
	//Click on Dropdown Link
	public DropDownPage clickDropDownLink() {
		log.info("Clicking on Dropdown Link");
		click(dropdownLinkLocator);
		return new DropDownPage(driver, log);
	}
	
	//Click on JavaScript Alert Link
	public JavaScriptAlertPage clickJavaScriptLink() {
		log.info("Clicking on JavaScript Alert Link");
		click(javascriptAlertLinkLocator);
		return new JavaScriptAlertPage(driver, log);
	}
	
	//Clicking on Multiple Windows Link
	public MultipleWindowsPage clickMultipleWindowsLink() {
		log.info("Clicking on Multiple Windows Link");
		click(multipleWindowsLinkLocator);
		return new MultipleWindowsPage(driver, log);
	}
	
	//Clicking on Frame Link
	public FramePage clickFrameLink() {
		log.info("Clicking on Frames Link");
		click(frameLinkLocator);
		return new FramePage(driver, log);
	}

	//Clicking on Key Press Link
	public KeyPressPage clickKeyPressLink() {
		log.info("Clicking on Key Press Link");
		click(keyPressLinkLocator);
		return new KeyPressPage(driver, log);
	}

	//Clicking on File Upload Link
	public FileUploadPage clickFileUploadLink() {
		log.info("Clicking on File Upload Link");
		click(fileUploadLinkLocator);
		return new FileUploadPage(driver, log);
	}
}
