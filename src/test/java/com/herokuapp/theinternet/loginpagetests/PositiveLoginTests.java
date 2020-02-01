package com.herokuapp.theinternet.loginpagetests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import com.herokuapp.theinternet.pages.DropDownPage;
import com.herokuapp.theinternet.pages.FileUploadPage;
import com.herokuapp.theinternet.pages.FramePage;
import com.herokuapp.theinternet.pages.JavaScriptAlertPage;
import com.herokuapp.theinternet.pages.KeyPressPage;
import com.herokuapp.theinternet.pages.LoginPage;
import com.herokuapp.theinternet.pages.MultipleWindowsPage;
import com.herokuapp.theinternet.pages.SecureAreaPage;
import com.herokuapp.theinternet.pages.WelcomePageObject;

public class PositiveLoginTests extends TestUtilities {

	// Test for Positive Login Authentication
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

	// Test for Handling Checkbox
	@Test(groups = { "checkboxes-test" })
	public void checkboxesTest() {
		log.info("Starting Postive Test: Checkboxes Page");

		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();

		// Get page title
		pageTitle();

		// Click on Checkboxes Link
		welcomePage.clickCheckboxesLink();
		pageTitle();

		// Clicking all the checkboxes
		CheckboxesPage checkboxesPage = new CheckboxesPage(driver, log);
		checkboxesPage.clickAllCheckboxes();

		// Verifying all the checkboxes are selected
		checkboxesPage.isAllCheckboxesSelected();

		// Assertion
		Assert.assertTrue(checkboxesPage.isAllCheckboxesSelected(), "All checkboxes are not selected");
		// Terminating the browser instance
		closeUp();
	}

	// Test for Handling Dropdown Menu
	@Test(groups = { "dropdown-menu-test" })
	public void dropdownTest() {
		log.info("Starting Positive Test: DropDown Page");

		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();

		// Click on Dropdown Link
		welcomePage.clickDropDownLink();

		// Get Page Title
		pageTitle();

		// Select Option 2 from Dropdown menu
		DropDownPage dropdownPage = new DropDownPage(driver, log);
		dropdownPage.selectDropDownOption(2);

		// Returning the option selected previously
		dropdownPage.getSelectedDropDownOption();

		// Terminating Browser Instance
		closeUp();
	}

	// Test for Handling JavaScript Alert
	@Test(groups = { "javascript-alert-test" })
	public void jsAlertTest() {
		log.info("Starting Positive Test: JavaScript Alert");

		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();

		// Opening the JS Alert Link
		welcomePage.clickJavaScriptLink();

		// Clicking on JS Alert
		JavaScriptAlertPage javascriptAlertPage = new JavaScriptAlertPage(driver, log);
		javascriptAlertPage.clickJSAlert();

		// Getting the text from the Alert
		javascriptAlertPage.getAlertText();
		// sleep(1000);

		// Clicking the JS Accept Alert
		javascriptAlertPage.acceptJSAlert();

		// Getting the Text Result
		javascriptAlertPage.getResultText();

		// Terminating browser instance
		closeUp();
	}

	// Test for Handling JavaScript Confirm Alert Type
	@Test(groups = { "javascript-confirm-alert-test" })
	public void jsConfirmAlertTest() {
		log.info("Starting Positive Test: JavaScript Alert");

		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();

		// Opening the JS Alert Link
		welcomePage.clickJavaScriptLink();

		// Clicking on JS Alert
		JavaScriptAlertPage javascriptAlertPage = new JavaScriptAlertPage(driver, log);
		javascriptAlertPage.clickJSConfirm();

		// Getting the text from the Alert
		javascriptAlertPage.getAlertText();

		// Clicking on Cancel/Dismiss the JS Confirm Alert
		// javascriptAlertPage.dismissJSConfirm();

		// Clicking the JS Accept Alert
		javascriptAlertPage.acceptJSAlert();

		// Getting the Text Result
		javascriptAlertPage.getResultText();

		// Terminating browser instance
		closeUp();
	}

	// Test for Handling JavaScript Prompt Alert Type
	@Test(groups = { "javascript-prompt-alert-test" })
	public void jsPromptAlertTest() {
		log.info("Starting Positive Test: JavaScript Alert");

		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();

		// Opening the JS Alert Link
		welcomePage.clickJavaScriptLink();

		// Clicking on JS Alert
		JavaScriptAlertPage javascriptAlertPage = new JavaScriptAlertPage(driver, log);
		javascriptAlertPage.clickJSPrompt();

		// Getting the text from the Alert
		javascriptAlertPage.getAlertText();

		// Entering text onto JS Prompt Alert Textbox
		javascriptAlertPage.enterJSPromptText("Text is entered");

		// Clicking on Cancel/Dismiss the JS Confirm Alert
		javascriptAlertPage.dismissJSConfirm();

		// Clicking the JS Accept Alert
		// javascriptAlertPage.acceptJSAlert();

		// Getting the Text Result
		javascriptAlertPage.getResultText();

		// Terminating browser instance
		closeUp();
	}

	// Test for Handling Multiple Windows
	@Test(groups = { "multiple-window-test" })
	public void multipleWindowTest() {
		log.info("Starting Positive Test: Multiple Window");

		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();

		// Opening the JS Alert Link
		welcomePage.clickMultipleWindowsLink();

		// Get Page Title & URL
		pageTitle();

		// Clicking on JS Alert
		MultipleWindowsPage multipleWindowPage = new MultipleWindowsPage(driver, log);
		multipleWindowPage.openNewWindowButton();

		// Switch to new window
		multipleWindowPage.switchToNewWindow();

		// Get Page title of the new window
		pageTitle();

		// Terminating browser instance
		closeUp();
	}

	// Test for Frames
	@Test(groups = { "iframe-test" })
	public void iFrameTest() {
		log.info("Starting Positive Test: Frames");

		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();

		// Opening the Frames Link
		welcomePage.clickFrameLink();

		// Get Page Title & URL
		pageTitle();

		// Clicking on iFrames Link
		FramePage framePage = new FramePage(driver, log);
		framePage.clickiFramesLink();

		// Clicking on Nested Frames Link
		// framePage.clickNestedFramesLink();

		// Get Page Title
		pageTitle();

		// Activating the IFrame Content
		framePage.activateIFrame("IFrame is activated");

		// Clearing the pre-populated text onto iFrame Content
		framePage.clearIFrameTextContent();
		// Assert.assertThat(framePage.clearIFrameTextContent().getAttribute(), "The
		// content area is not cleared");

		// Enter text onto IFrame Text Field
		framePage.enterIFrameTextContent("Selenium Test for text onto iFrame");

		// Getting the text entered from iFrame text field
		framePage.getEnteredTextIFrame();
		String expectedEnteredText = "Selenium Test for text onto iFrame";
		String actualEnteredText = framePage.getEnteredTextIFrame();
		Assert.assertTrue(actualEnteredText.contains(expectedEnteredText),
				"The actual entered text is different than expected text");

		// Clicking on File within IFrame
		framePage.checkIFrameMenu();

		// Terminating the browser instance
		closeUp();
	}

	// Test for Returning Key Press Events
	@Test( groups = { "keypress-test" })
	public void keyPressTest() {
		log.info("Starting Positive Test: Key Presses");

		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();
		
		//Clicking on the Key Presses Link
		welcomePage.clickKeyPressLink();
		
		//Getting the Page Title
		pageTitle();
		
		//Initializing page object for to invoke the key press event
		KeyPressPage keyPressPage = new KeyPressPage(driver, log);
		keyPressPage.sendKeyPressInput(Keys.RETURN);
		
		//Assigning variables to capture the Expected & Actual Test Result
		String actualText = keyPressPage.sentKeyPressResult();
		String expectedText = "You entered: ENTER";
		
		//Validating the Expected & Actual Test Result by comparing the variables via Assertions
		Assert.assertTrue(actualText.contains(expectedText), "The result text does not match the expected key press result");
		
		//Terminating the browser instance
		closeUp();
	}	
	
	//Test for Returning Key Press Events using Action Class
	@Test( groups = { "keypress-action-test" })
	public void keyPressActionTest() {
		log.info("Starting Positive Test: Key Presses using Action Class");

		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();
		
		//Clicking on the Key Presses Link
		welcomePage.clickKeyPressLink();
		
		//Getting the Page Title
		pageTitle();
		
		KeyPressPage keyPressPage = new KeyPressPage(driver, log);
		keyPressPage.keyPressActionInput(Keys.SPACE);
		
		//Assigning variables to capture the Expected & Actual Test Result
		String actualText = keyPressPage.sentKeyPressResult();
		String expectedText = "You entered: SPACE";
		
		//Validating the Expected & Actual Test Result by comparing the variables via Assertions
		Assert.assertTrue(actualText.contains(expectedText), "The result text does not match the expected key press result");
				
		//Terminating the browser instance
		closeUp();
	}

	//Test for File Upload
	@Test( groups = { "file-upload-test" })
	public void fileUploadTest() {
		log.info("Starting Positive Test: Key Presses using Action Class");

		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();
		
		//Clicking on the Key Presses Link
		welcomePage.clickFileUploadLink();
		
		//Getting the Page Title
		pageTitle();
		
		FileUploadPage fileUploadPage = new FileUploadPage(driver, log);
		//fileUploadPage.chooseFileLink();
		
		//Selecting the File
		String fileName = "The_Great_Wave_Hokusai.jpg";
		fileUploadPage.selectFile(fileName);
		
		//Uploading the file
		fileUploadPage.uploadFileLink();
		
		//Getting the name of the uploaded file
		String uploadedFileNameObject = fileUploadPage.getUploadedFileName();
		
		//Adding assertion for the uploaded file
		Assert.assertTrue(uploadedFileNameObject.contains(fileName), "Our file: (" + uploadedFileNameObject + ") is not the one uploaded (" + uploadedFileNameObject + ") ");
	}
	
	//Test for JSExecutor Functions
	@Test( groups = { "javaScript-executor-test" })
	public void jsExecutorTest() {
		log.info("Starting Positive Test: JavaScript Executor Test");

		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();
		
		//Using JS Executor BasePageObject to scroll
		sleep(5000);
		welcomePage.performJSExecutionMethods();
		
		log.info("Executed Scrolling using JSExecutor via Selenium WebDriver");
	}
	
	//Test for Drag and Drop
	@Test( groups = { "drag-and-drop-test" })
	public void dragAndDropTest() {
		log.info("Starting Positive Test: Drag and Drop Test");

		WelcomePageObject welcomePage = new WelcomePageObject(driver, log);
		welcomePage.OpenPage();
		
		welcomePage.clickDragAndDropLink();
		
		DragAndDropPage dragAndDropPage = new DragAndDropPage(driver, log);
		
		dragAndDropPage.DragAndDropFunction();
		
		String ColumnAText = dragAndDropPage.getColumnAText();
		Assert.assertTrue(ColumnAText.equals("B"), "Column A header should be B, but it is: " + ColumnAText);
	
		
		String ColumnBText = dragAndDropPage.getColumnBText();
		Assert.assertTrue(ColumnBText.equals("A"), "Column B header should be A, but it is: " + ColumnBText);
		
		
		//sleep(2000);
	}
}
