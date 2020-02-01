package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {

	private By objectALinkLocator = By.id("column-a");
	private By objectBLinkLocator = By.id("column-b");

	public DragAndDropPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void DragAndDropFunction() {
		log.info("Performing Drag A to B");
		performDragAndDrop(objectALinkLocator, objectBLinkLocator);
	}

	/** Getting Column A Text */
	public String getColumnAText() {
		String text = find(objectALinkLocator).getText();
		log.info("Column A Text: " + text);
		return text;
	}

	/** Getting Column B Text */
	public String getColumnBText() {
		String text = find(objectBLinkLocator).getText();
		log.info("Column B Text: " + text);
		return text;
	}
}
