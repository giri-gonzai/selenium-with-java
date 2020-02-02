package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HoverOverPage extends BasePageObject{

	private By avatarLocator = By.xpath("//div[@class='figure']");
	private By viewProfileLinkLocator = By.xpath(".//a[contains(text(), 'View profile')]");
	
	public HoverOverPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	//Method to open the user profile
	public void openUserProfile(int i) {
		List<WebElement> avatar = findAll(avatarLocator);
		WebElement specifiedAvatar = avatar.get(i -1);
		hoverOverElement(specifiedAvatar);
		specifiedAvatar.findElement(viewProfileLinkLocator).click();
	}

}
