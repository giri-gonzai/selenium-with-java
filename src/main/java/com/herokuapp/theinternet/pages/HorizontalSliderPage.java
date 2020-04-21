package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HorizontalSliderPage extends BasePageObject{

	private By rangeLocator = By.id("range");
	private By sliderLocator = By.tagName("input");
	
	public HorizontalSliderPage(WebDriver driver, Logger log) {
		// TODO Auto-generated constructor stub
		super(driver, log);
	}
	
	//Moving the Slider
	public void moveHorizontalSliderTo(String value) {
		log.info("Moving the slider to: " + value);
		
		//Using Steps and dividing by 0.5
		int steps = (int) (Double.parseDouble(value) / 0.5);
		
		keyPressInput(sliderLocator, Keys.ENTER);
		for(int i = 0; i < steps; i++) {
			keyPressInput(sliderLocator, Keys.ARROW_RIGHT);
		}
	}
	
	//Getting the Slider Value
	public String finalHorizontalSliderValue() {
		String value = find(rangeLocator).getText();
		log.info("The slider value is at: " + value);
		return value;
	}
}
