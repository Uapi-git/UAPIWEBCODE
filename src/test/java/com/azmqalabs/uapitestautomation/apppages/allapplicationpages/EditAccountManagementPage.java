/**
 * Test Script Name                      : EditAccountManagementPage.
 * Objective                             : Verify the Edit Account Management Functionality.
 * Version                               : 1.0
 * Author                                : Arun Kumar M S
 * Created Date                          : 11/06/2024
 * Last Updated on                       : N/A
 * Updated By                            :
 * Epic Details                          : N/A
 * User Story Details                    : N/A
 * Defects affecting this test script    : None
 * Work Around/Known Issues              : None
 **/
package com.azmqalabs.uapitestautomation.apppages.allapplicationpages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.uapitestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.uapitestautomation.common.Log;
import com.azmqalabs.uapitestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.uapitestautomation.objectrepository.UapiOR;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Map;

public class EditAccountManagementPage extends BasePage {

	public EditAccountManagementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = UapiOR.Admin_Edit_AccountManagement_Page)
	public WebElement editAccountManagementText;

	public boolean Exists() {
		return super.Exists(editAccountManagementText);
	}

	// Method to validate edit account management Page
	public void verifyEditAccountManagementPageIsDisplayed(Log Log) {
		try {
			Thread.sleep(1000);
			verifyElementIsPresent(UapiOR.Admin_Edit_AccountManagement_Page);
			this.takeScreenShot();
			test.log(Status.PASS, "Verify edit account management page" + driver.getTitle() + "Verify edit account management page is Pass");
			Log.ReportEvent("PASS", "User Navigated to edit account Management page");
			this.takeScreenShot();

		} catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "Verify edit account management page" + driver.getTitle() + "Verify edit account management page is Fail");


		}
	}

	//Method to enter Unified National Number
	public void enterUnifiedNationalNumber(Map<Object, Object> testdatamap)
	{
		webClear(driver,UapiOR.Admin_Edit_AccountManagement_Page_UnifiedNationalNumber);
		WebEdit(UapiOR.Admin_Edit_AccountManagement_Page_UnifiedNationalNumber,testdatamap.get("National Number").toString());
	}
	//Method to verify UnifiedNationalNumber error Message
	public void verifyUnifiedNationalNumberErrorMessage(Map<Object, Object> testdatamap) throws Exception {
		enterUnifiedNationalNumber(testdatamap);
		clickOnSaveButton();
		verifyElementIsPresent(UapiOR.Admin_Edit_AccountManagement_Page_UnifiedNationalNumberErrorMessage);
		this.takeScreenShot();
	}
	//Method to enter National ID
	public void enterNationalID(Map<Object, Object> testdatamap)
	{
		webClear(driver,UapiOR.Admin_Edit_AccountManagement_Page_NationalID);
		WebEdit(UapiOR.Admin_Edit_AccountManagement_Page_NationalID,testdatamap.get("National Id").toString());
	}
	//Method to verify UnifiedNationalNumber error Message
	public void verifyNationalIdErrorMessage(Map<Object, Object> testdatamap) throws Exception {
		enterNationalID(testdatamap);
		clickOnSaveButton();
		verifyElementIsPresent(UapiOR.Admin_Edit_AccountManagement_Page_NationalIdBlankErrorMessage);
		this.takeScreenShot();
	}
	//Method to click on save button
	public void clickOnSaveButton() throws InterruptedException {
		Thread.sleep(1000);
		WebClick(UapiOR.Admin_Edit_AccountManagement_Page_SaveButton);

	}
	//Method to verify account details updated successful Toast message
	public void verifyAccountDetailsUpdatedToastMessage(Map<Object, Object> testdatamap,Log Log) throws Exception {
		VerifyValue1(getText(UapiOR.Admin_Edit_AccountManagement_Page_UpdateSuccessfulToast), testdatamap.get("Success Toast").toString());
		Thread.sleep(1000);
		Log.ReportEvent("PASS", "User Account details Updated Successfully in edit account Management page");
	}
	//Method to click on Right arrow icon
	public void clickOnRightArrowIcon() throws InterruptedException {
		Thread.sleep(1000);
		WebClickUsingJS(UapiOR.Admin_Edit_AccountManagement_Page_RightArrowIcon);
	}
	//Method to click on Authorized Person Information
	public void clickOnAuthorizedPersonInformation() throws InterruptedException {
		Thread.sleep(1000);
		WebClickUsingJS(UapiOR.Admin_Edit_AccountManagement_Page_AuthorizedPersonInformation);
	}

	//Method to click on National Address
	public void clickOnNationalAddress()
	{
		WebClickUsingJS(UapiOR.Admin_Edit_AccountManagement_Page_NationalAddress);
	}

	//Method to click on Attachments
	public void clickOnAttachments()
	{
		WebClickUsingJS(UapiOR.Admin_Edit_AccountManagement_Page_Attachments);
	}

	//Method to click on Admin Information
	public void clickOnAdminInformation()
	{
		WebClickUsingJS(UapiOR.Admin_Edit_AccountManagement_Page_AdminInformation);
	}
	//Method to enter Last Name In Admin Information
	public void enterLastNameInAdminInformation(Map<Object, Object> testdatamap)
	{
		webClear(driver,UapiOR.Admin_Edit_AccountManagement_Page_LastName);
		WebEdit(UapiOR.Admin_Edit_AccountManagement_Page_LastName,testdatamap.get("Last Name").toString());
	}
	//Method to verify LastName error Message
	public void verifyLastNameErrorMessage(Map<Object, Object> testdatamap) throws Exception {
		enterLastNameInAdminInformation(testdatamap);
		clickOnSaveButton();
		verifyElementIsPresent(UapiOR.Admin_Edit_AccountManagement_Page_LastNameBlankErrorMessage);
		this.takeScreenShot();
	}
	//Method to enter Postal Code
	public void enterPostalCode(Map<Object, Object> testdatamap)
	{
		webClear(driver,UapiOR.Admin_Edit_AccountManagement_Page_PostalCode);
		WebEdit(UapiOR.Admin_Edit_AccountManagement_Page_PostalCode,testdatamap.get("Postal Code").toString());
	}
	//Method to verify Postal Code error Message
	public void verifyPostalCodeErrorMessage(Map<Object, Object> testdatamap) throws Exception {
		enterPostalCode(testdatamap);
		clickOnSaveButton();
		verifyElementIsPresent(UapiOR.Admin_Edit_AccountManagement_Page_PostalCodeErrorMessage);
		this.takeScreenShot();
	}

// Method to verify Error Message in Edit Account Management Screen
	public void verifyErrorMessagesInEditAccountManagementScreen(Map<Object, Object> testdatamap,Log Log)
	{
		try{
			verifyUnifiedNationalNumberErrorMessage(testdatamap);
			clickOnAuthorizedPersonInformation();
			verifyNationalIdErrorMessage(testdatamap);
			clickOnRightArrowIcon();
			clickOnAdminInformation();
			verifyLastNameErrorMessage(testdatamap);
			clickOnNationalAddress();
			verifyPostalCodeErrorMessage(testdatamap);
			clickOnAttachments();
			clickOnAttachmentsArticlesOFAssociationClear();
			uploadPDFFile(UapiOR.Admin_Edit_AccountManagement_Page_ArticlesOfAssociationAttachments,"word.docx");
			verifyElementIsPresent(UapiOR.Admin_Edit_AccountManagement_Page_ArticlesOfAssociationAttachmentsErrorMessage);
			Thread.sleep(1000);
			test.log(Status.PASS, "Verify Error message in edit account management page" + driver.getTitle() + "Verify Error message in edit account management page is Pass");
			Log.ReportEvent("PASS", "Verify Error message in edit account Management page is Successful");
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Verify Error message in edit account management page" + driver.getTitle() + "Verify Error message in edit account management page is Fail");

		}
	}
	//Method to click on Attachments
	public void clickOnAttachmentsArticlesOFAssociationClear() throws InterruptedException {
		Thread.sleep(1000);
		WebClickUsingJS(UapiOR.Admin_Edit_AccountManagement_Page_ArticlesOfAssociationAttachmentsClear);
	}

	//Method to click on cancel
	public void clickOnCancel(Log Log) throws InterruptedException {
		Thread.sleep(1000);
		this.takeScreenShot();
		WebClick(UapiOR.Admin_Edit_AccountManagement_Page_Cancel);
		Log.ReportEvent("PASS", "Modify some details and Click on 'Cancel button' button in edit account Management page is Successful");

	}
	// Method to get Unified National Number
	public String getUnifiedNationalNumber() {
		String getUnifiedNationalNumber = driver.findElement(By.xpath(UapiOR.Admin_Edit_AccountManagement_Page_UnifiedNationalNumber)).getText();
		return getUnifiedNationalNumber;
	}
	// Method to verify Unified Nation Number text field is Not Updated
	public void verifyUnifiedNationalNumberAfterClickingCancelInEditAccountManagementScreen(String unifiedNationalNumberBeforeCancel,Log Log)
	{
		String unifiedNationalNumberAfterCancel = driver.findElement(By.xpath(UapiOR.Admin_Edit_AccountManagement_Page_UnifiedNationalNumber)).getText();
		Assert.assertEquals(unifiedNationalNumberAfterCancel,unifiedNationalNumberBeforeCancel);
		Log.ReportEvent("PASS", "verify application discard the changes and close the 'Edit Account' screen is Successful");

	}

}
