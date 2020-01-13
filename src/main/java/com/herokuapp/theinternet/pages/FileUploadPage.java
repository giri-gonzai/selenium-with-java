package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FileUploadPage extends BasePageObject{

	private By fileChooseButtonLocator = By.id("file-upload");
	private By fileUploadButtonLocator = By.id("file-submit");
	private By successfulFileUploadLocator = By.id("uploaded-files");
	
	public FileUploadPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	//Method for clicking on button to choose File
	/*
	 * public void chooseFileLink() {
	 * log.info("Choosing the 'Choose' to select file for upload");
	 * click(fileChooseButtonLocator); }
	 */
	
	//Method to Upload the selected file
	public void uploadFileLink() {
		log.info("Clicking on Upload button");
		click(fileUploadButtonLocator);
	}
	
	//Method for selecting the File from File Browser
	public void selectFile(String fileName) {
		log.info("Selecting " + fileName + " from the File Folder");
		String filePath = System.getProperty("user.dir") + "//src//main/resources//Files" + fileName;
		type(filePath, fileChooseButtonLocator);
		log.info("File Selected: " + fileName);
	}
	
	//Method for getting the file name of uploaded file
	public String getUploadedFileName() {
		String uploadedFileName = find(successfulFileUploadLocator).getText();
		log.info("The name of the selected file name is: " +uploadedFileName);
		return uploadedFileName;
	}
}
