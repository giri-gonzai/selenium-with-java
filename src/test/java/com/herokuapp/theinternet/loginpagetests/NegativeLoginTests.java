package com.herokuapp.theinternet.loginpagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DynamicControlPage;
import com.herokuapp.theinternet.pages.DynamicLoadingExample1Page;
import com.herokuapp.theinternet.pages.DynamicLoadingPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class NegativeLoginTests extends TestUtilities {

	@Test(groups = { "explicit-wait" })
	public void negativeTestExplicitWait() {
		log.info("Starting Negative Tests: ");

		// Opening the Web App Home Page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();

		// Clicking on Dynamic Loading Link
		DynamicLoadingPage dynamicLoadingPage = welcomePage.clickDynamicLoadingLink();

		// Clicking on Dynamic Loading Example 1 Link
		DynamicLoadingExample1Page dynamicLoadingExample1Page = dynamicLoadingPage.clickDynamicLoadingExample1();

		//Getting Page Title
		pageTitle();
		
		// Clicking on Start button
		dynamicLoadingExample1Page.clickStart();

		// Waiting for the hidden element to be visible
		dynamicLoadingExample1Page.waitForText();

		// Getting the hidden element text
		dynamicLoadingExample1Page.getElementText();

		Assert.assertEquals(dynamicLoadingExample1Page.getElementText(), "Hello World!");
		
		//Closing the browser
		closeUp();
	}

	@Test(groups = { "stale-element-test" })
	public void negativeTestStaleElement() {
		log.info("Starting Negative Test for Stale Element Test");

		// Opening the Web App Home Page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();

		// Clicking on the Dynamic Control Link
		DynamicControlPage dynamicControlPage = welcomePage.clickDynamicControlLink();
		
		//Gettting Page Title
		pageTitle();

		// Selecting the CheckBox Element
		dynamicControlPage.clickCheckbox();

		// Clicking on the Remove Button
		dynamicControlPage.removeCheckbox();

		// Waiting for Checkbox to be removed
		dynamicControlPage.checkboxRemoved();

		// Verifying the Checkbox Element is not visible
		Assert.assertTrue(dynamicControlPage.isCheckedBoxVisible(), "Checkbox is visible");

		// Verifying the Text Returned from Removing Checkbox
		String expectedSuccessMessage = "It's gone!";
		String actualSuccessMessage = dynamicControlPage.getSuccessMessage();
		Assert.assertTrue(actualSuccessMessage.contains(expectedSuccessMessage),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedSuccessMessage + "\nactualSuccessMessage" + actualSuccessMessage);
		
		//Closing the browser
		closeUp();
	}

	@Test( groups = { "disabled-element-test" })
	public void negativeTestDisabledElement() {
		log.info("Starting Negative Test for Disabled Element Test");
		
		// Opening the Web App Home Page
		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();
		
		// Clicking on the Dynamic Control Link
		DynamicControlPage dynamicControlPage = welcomePage.clickDynamicControlLink();
		
		//Getting Page Title
		pageTitle();
		
		//Verifying Textbox is disabled
		dynamicControlPage.isTextboxEnabled();
		
		//Click on Enable
		dynamicControlPage.clickEnableButton();
		
		//Wait for the Textbox to be enabled
		dynamicControlPage.isDisableButtonVisible();
		
		//Sendkeys into enabled Textbox
		dynamicControlPage.inputText("Input Text onto Textbox");
		
		//Verify the text sent to Textbox
		String actualEnteredText = ("Input Text onto Textbox");
		String expectedEnteredText = dynamicControlPage.getEnteredMessage();
		Assert.assertTrue(actualEnteredText.contains(expectedEnteredText),
				"actualSuccessMessage does not contain expectedSuccessMessage\nexpectedSuccessMessage: "
						+ expectedEnteredText + "\nactualSucessMessage" + actualEnteredText);
		
		//Terminate the Browser Instance
		closeUp();
	}
}
