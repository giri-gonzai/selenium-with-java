package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage extends BasePageObject{

	private By iFrameLinkLocator = By.xpath("//a[@href='/iframe']");
	private By nestedFrameLinkLocator = By.xpath("//a[@href='/nested_frames']");
	private By iFrameContentLocator = By.id("mceu_13");
	private By iFrameFileLocator = By.id("mceu_15");
	
	public FramePage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	//Clicking on iFrames Link
	public FramePage clickiFramesLink() {
		log.info("Clicking on iFrames Link");
		click(iFrameLinkLocator);
		return new FramePage(driver, log);
	}
	
	//Clicking on Nested Frames Link
	public FramePage clickNestedFramesLink() {
		log.info("Clicking on Nested Frames Link");
		click(nestedFrameLinkLocator);
		return new FramePage(driver, log);
	}

	//Activating iFrame content
	public String activateIFrame(String text) {
		log.info("Activating the IFrame content");
		waitForVisibilityOf(iFrameContentLocator, 5);
		click(iFrameContentLocator);
		return text;
	}
	
	//Clicking on File within IFrame
	public void clickIFrameFileButton() {
		log.info("Clicking on File within IFrame content");
		click(iFrameFileLocator);
	}
}
