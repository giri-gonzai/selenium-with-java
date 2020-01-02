package com.herokuapp.theinternet.loginpagetests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
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

}
