package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramePage extends BasePageObject {

	private By iFrameLinkLocator = By.xpath("//a[@href='/iframe']");
	private By nestedFrameLinkLocator = By.xpath("//a[@href='/nested_frames']");

	private By iFrameFileLocator = By.id("mceu_15-open");
	private By iFrame = By.tagName("iframe");
	private By iFrameTextAreaLocator = By.id("tinymce");

	public FramePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	// Clicking on iFrames Link
	public FramePage clickiFramesLink() {
		log.info("Clicking on iFrames Link");
		click(iFrameLinkLocator);
		return new FramePage(driver, log);
	}

	// Clicking on Nested Frames Link
	public FramePage clickNestedFramesLink() {
		log.info("Clicking on Nested Frames Link");
		click(nestedFrameLinkLocator);
		return new FramePage(driver, log);
	}

	// Activating iFrame content
	public String activateIFrame(String text) {
		log.info("Activating the IFrame content");
		waitForVisibilityOf(iFrame, 5);
		click(iFrame);
		return text;
	}

	// Method for clearing the pre-populated text
	public void clearIFrameTextContent() {
		log.info("Clearning the text from IFrame Text Content");
		switchToIFrame(iFrame);
		find(iFrameTextAreaLocator).clear();
	}

	// Method for entering text into Text Area within iFrame
	public FramePage enterIFrameTextContent(String textForIFrame) {
		log.info("Entering Text onto Text Area [" + textForIFrame + "]");
		type(textForIFrame, iFrameTextAreaLocator);
		log.info("Text is entered onto the field");
		return new FramePage(driver, log);
	}

	public String getEnteredTextIFrame() {
		return find(iFrameTextAreaLocator).getText();
	}

	// Clicking on File within IFrame
	public void clickIFrameFileButton() {
		switchOutOfIFrame();
		log.info("Clicking on File within IFrame content");
		click(iFrameFileLocator);
		log.info("File link was opened");
	}
}
