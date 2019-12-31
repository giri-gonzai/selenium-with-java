package com.herokuapp.theinternet.base;

public class TestUtilities extends BaseTest{

	//Test Utility Method
	
	protected void pageTitle() {
		String Title = driver.getTitle();
		log.info("The title of the page is: " + Title);
		}

}
