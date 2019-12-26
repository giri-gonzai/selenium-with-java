package com.herokuapp.theinternet.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class PositiveLoginTests extends TestUtilities {

	@Test
	public void logInTest() {
		log.info("Starting Positive Test: ");

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

}
