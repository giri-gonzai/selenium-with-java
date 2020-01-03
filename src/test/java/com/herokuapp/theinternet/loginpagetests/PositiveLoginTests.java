package com.herokuapp.theinternet.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.DropDownPage;
import com.herokuapp.theinternet.pages.JavaScriptAlertPage;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class PositiveLoginTests extends TestUtilities {

	@Test(groups = { "login-test" })
	public void logInTest() {
		log.info("Starting Positive Test: Login Flow ");

		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();

		// Click on Form Authentication Link
		LoginPage loginPage = welcomePage.clickAuthenticationFormLink();

		// Entering Username, Password and click Login
		SecureAreaPage secureAreaPage = loginPage.logIn("tomsmith", "SuperSecretPassword!");

		// Verifying Login URL
		Assert.assertEquals(secureAreaPage.getCurrentUrl(), secureAreaPage.getPageUrl());

		// Verifying Visibility of Logout Button
		Assert.assertTrue(secureAreaPage.isLogOutVisible(), "LogOut Button is not visible.");

		// Verifying Login Success Message
		String expectedSuccessMessage = "You logged into a secure area!";
		String actualSuccessMessage = secureAreaPage.getSuccessMessage();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSucessMessage" + actualSuccessMessage);
	}
	
	@Test(groups = { "checkboxes-test" })
	public void checkboxesTest() {
		log.info("Starting Postive Test: Checkboxes Page");
		
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();
		
		//Get page title
		pageTitle();
		
		//Click on Checkboxes Link
		welcomePage.clickCheckboxesLink();
		pageTitle();
		
		//Clicking all the checkboxes
		CheckboxesPage checkboxesPage = new CheckboxesPage(driver, log);
		checkboxesPage.clickAllCheckboxes();
		
		//Verifying all the checkboxes are selected
		checkboxesPage.isAllCheckboxesSelected();
		
		//Assertion
		Assert.assertTrue(checkboxesPage.isAllCheckboxesSelected(), "All checkboxes are not selected");
		//Terminating the browser instance
		closeUp();
	}
	
	@Test( groups = { "dropdown-menu-test" })
	public void dropdownTest() {
		log.info("Starting Positive Test: DropDown Page");
		
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();
		
		//Click on Dropdown Link
		welcomePage.clickDropDownLink();
		
		//Get Page Title
		pageTitle();
		
		//Select Option 2 from Dropdown menu
		DropDownPage dropdownPage = new DropDownPage(driver, log);
		dropdownPage.selectDropDownOption(2);
		
		//Returning the option selected previously
		dropdownPage.getSelectedDropDownOption();
		
		//Terminating Browser Instance
		closeUp();
	}
	
	@Test( groups = { "javascript-alert-test" })
	public void jsAlertTest() {
		log.info("Starting Positive Test: JavaScript Alert");
		
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();
		
		//Opening the JS Alert Link
		welcomePage.clickJavaScriptLink();
		
		//Clicking on JS Alert
		JavaScriptAlertPage javascriptAlertPage = new JavaScriptAlertPage(driver, log);
		javascriptAlertPage.clickJSAlert();
		
		//Getting the text from the Alert
		javascriptAlertPage.getAlertText();
		//sleep(1000);
		
		//Clicking the JS Accept Alert
		javascriptAlertPage.acceptJSAlert();
		
		//Getting the Text Result
		javascriptAlertPage.getResultText();
		
		//Terminating browser instance
		closeUp();
	}
	
	@Test( groups = { "javascript-confirm-alert-test" })
	public void jsConfirmAlertTest() {
		log.info("Starting Positive Test: JavaScript Alert");
		
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();
		
		//Opening the JS Alert Link
		welcomePage.clickJavaScriptLink();
		
		//Clicking on JS Alert
		JavaScriptAlertPage javascriptAlertPage = new JavaScriptAlertPage(driver, log);
		javascriptAlertPage.clickJSConfirm();
		
		//Getting the text from the Alert
		javascriptAlertPage.getAlertText();
		
		//Clicking on Cancel/Dismiss the JS Confirm Alert
		//javascriptAlertPage.dismissJSConfirm();
		
		//Clicking the JS Accept Alert
		javascriptAlertPage.acceptJSAlert();
		
		//Getting the Text Result
		javascriptAlertPage.getResultText();
		
		//Terminating browser instance
		closeUp();
	}

}
