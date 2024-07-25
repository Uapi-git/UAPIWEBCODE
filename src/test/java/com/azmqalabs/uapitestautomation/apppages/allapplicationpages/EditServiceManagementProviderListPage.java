/**
 * Test Script Name                      : EditServiceProviderListPagePage.
 * Objective                             : Verify the Edit Service Provider List Functionality.
 * Version                               : 1.0
 * Author                                : Arun Kumar M S
 * Created Date                          : 24/06/2024
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

import java.io.IOException;
import java.util.Map;

public class EditServiceManagementProviderListPage extends BasePage {

    public EditServiceManagementProviderListPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Admin_EditServiceManagementProviderList_Page)
    public WebElement editServiceProviderListText;

    public boolean Exists() {
        return super.Exists(editServiceProviderListText);
    }

    // Method to validate edit Service Provider List Page
    public void verifyEditServiceProviderListPageIsDisplayed(Log Log) {
        try {
            Thread.sleep(1000);
            verifyElementIsPresent(UapiOR.Admin_EditServiceManagementProviderList_Page);
            this.takeScreenShot();
            test.log(Status.PASS, "Verify edit Service Provider List page" + driver.getTitle() + "Verify edit Service Provider List page is Pass");
            Log.ReportEvent("PASS", "User Navigated to edit Service Provider List page");
            this.takeScreenShot();

        } catch (Exception e) {
            this.takeScreenShot();
            test.log(Status.FAIL, "Verify edit edit Service Provider List page" + driver.getTitle() + "Verify edit Service Provider List page is Fail");


        }
    }

    // Method to Upload File
    public void uploadFile(Log Log) throws Exception {
        Thread.sleep(2000);
        uploadFile(UapiOR.Admin_EditServiceManagementProviderList_Page_Upload, "AuthorizedLetterStamped.pdf");
        Log.ReportEvent("PASS", "Click on 'Upload' button and Upload in Edit Service Provider List Screen is successful");
        this.takeScreenShot();
    }

    // Method to verify file uploaded Successfully
    public void verifyFileUploadedSuccessfully(Map<Object, Object> testdatamap) throws Exception {
        Thread.sleep(1000);
        VerifyValue1(getText(UapiOR.Admin_EditServiceManagementProviderList_Page_UploadFileText), testdatamap.get("FileName").toString());
    }    // Method to verify File Upload Error Message, When file size greater than 1 MB.

    public void verifyFileUploadErrorMessage(Map<Object, Object> testdatamap, Log Log) throws Exception {
        Thread.sleep(1000);
        uploadFile(UapiOR.Admin_EditServiceManagementProviderList_Page_Upload, "PdfFile1.5MB.pdf");
        VerifyValue1(getText(UapiOR.Admin_EditServiceManagementProviderList_Page_UploadFileErrorMsg), testdatamap.get("InvalidFileUpload").toString());
        Log.ReportEvent("PASS", "Click on 'Upload' button and upload,verify Error Message in Edit Service Provider List Screen is successful");
        this.takeScreenShot();
    }

    // Method to click on Connectivity Type Toggle
    public void clickOnConnectivityTypeToggle() throws InterruptedException {
        Thread.sleep(2000);
        WebClick(UapiOR.Admin_EditServiceManagementProviderList_Page_ConnectivityTypeToggle);
        this.takeScreenShot();
    }

    //Method to verify Connectivity Type Toggle is OFF
    public void verifyConnectivityToggleOFF(Log Log) throws Exception {
        boolean isConnectivityToggleIsOFF = !driver.findElement(By.xpath(UapiOR.Admin_EditServiceManagementProviderList_Page_ConnectivityType)).getAttribute("class").contains("Mui-checked");
        Assert.assertTrue(isConnectivityToggleIsOFF, "Connectivity Type toggle is ON");
        verifyElementIsNotPresent(UapiOR.Admin_EditServiceManagementProviderList_Page_SaveAndViewCredentials);
        Log.ReportEvent("PASS", "Verify Service provider level' option is OFF in Edit Service Provider List Screen is successful");
        this.takeScreenShot();

    }

    //Method to verify Connectivity Type Toggle is ON
    public void verifyConnectivityToggleON(Log Log) throws Exception {
        boolean isConnectivityToggleIsON = driver.findElement(By.xpath(UapiOR.Admin_EditServiceManagementProviderList_Page_ConnectivityType)).getAttribute("class").contains("Mui-checked");
        Assert.assertTrue(isConnectivityToggleIsON, "Connectivity Type toggle is OFF");
        verifyElementIsPresent(UapiOR.Admin_EditServiceManagementProviderList_Page_SaveAndViewCredentials);
        Log.ReportEvent("PASS", "Verify Service provider level' option is ON in Edit Service Provider List Screen is successful");
        this.takeScreenShot();

    }

    // Method to click on Save and View Credentials
    public void clickOnSaveAndViewCredentials(Log Log) {
        WebClick(UapiOR.Admin_EditServiceManagementProviderList_Page_SaveAndViewCredentials);
        Log.ReportEvent("PASS", "Click on 'Save and View Credentials' button in Edit Service Provider List Screen is successful");
        this.takeScreenShot();
    }

    // Method to verify Save and Cancel button
    public void verifySaveAndCancelInSaveAndViewCredentialsPopup() throws Exception {
        Thread.sleep(2000);
        verifyElementIsPresent(UapiOR.Admin_EditServiceManagementProviderList_Page_SaveAndViewCredentialsPopup);
        verifyElementIsPresent(UapiOR.Admin_EditServiceManagementProviderList_Page_SaveAndViewCredentialsCancel);
        verifyElementIsPresent(UapiOR.Admin_EditServiceManagementProviderList_Page_SaveAndViewCredentialsSave);
        this.takeScreenShot();
    }

    // Method to click on Cancel In Save and View Credentials Popup
    public void clickOnCancelInSaveAndViewCredentialsPopup() {

        WebClick(UapiOR.Admin_EditServiceManagementProviderList_Page_SaveAndViewCredentialsCancel);

    }

    // Method to click on Client Credentials Toggle
    public void clickOnClientCredentialsToggle() throws InterruptedException {
        Thread.sleep(2000);
        WebClick(UapiOR.Admin_EditServiceManagementProviderList_Page_ClientCredentialsToggle);
        this.takeScreenShot();
    }

    //Method to verify Client Credentials Toggle is OFF
    public void verifyClientCredentialsToggleOFF(Log Log) {
        boolean isClientCredentialsToggleIsOFF = !driver.findElement(By.xpath(UapiOR.Admin_EditServiceManagementProviderList_Page_ClientCredentials)).getAttribute("class").contains("Mui-checked");
        Assert.assertTrue(isClientCredentialsToggleIsOFF, "Client Credentials toggle is ON");
        Log.ReportEvent("PASS", "Verify Client Credentials option is OFF in Edit Service Provider List Screen is successful");
        this.takeScreenShot();

    }

    //Method to verify Client Credentials Toggle is ON
    public void verifyClientCredentialsToggleON(Log Log) {
        boolean isClientCredentialsToggleIsON = driver.findElement(By.xpath(UapiOR.Admin_EditServiceManagementProviderList_Page_ClientCredentials)).getAttribute("class").contains("Mui-checked");
        Assert.assertTrue(isClientCredentialsToggleIsON, "Client Credentials toggle is OFF");
        Log.ReportEvent("PASS", "Verify Client Credentials option is ON in Edit Service Provider List Screen is successful");
        this.takeScreenShot();

    }

    // Method to verify editable fields in Edit Service providers List Screen
    public void verifyEditableFieldsInEditServiceProvidersListScreen(Map<Object, Object> testdatamap, Log Log) throws Exception {
        try {
            boolean isServiceProviderNameInArabicEditable = !driver.findElement(By.xpath(UapiOR.Admin_EditServiceManagementProviderList_Page_ServiceProviderArabicName)).getAttribute("class").contains("Mui-disabled");
            boolean isDescriptionEditable = !driver.findElement(By.xpath(UapiOR.Admin_EditServiceManagementProviderList_Page_Description)).getAttribute("class").contains("Mui-disabled");
            Assert.assertTrue(isServiceProviderNameInArabicEditable, "Service Provider Arabic Name TextField is disabled");
            Assert.assertTrue(isDescriptionEditable, "Description TextField is disabled");
            uploadFile(Log);
            verifyFileUploadedSuccessfully(testdatamap);
            clickOnClientCredentialsToggleIfTheToggleIsON(Log);
            Thread.sleep(3000);
            clickOnClientCredentialsToggleIfTheToggleIsOFF(Log);
            Thread.sleep(3000);
            clickOnConnectivityTypeToggleIfTheToggleIsON(Log);
            Thread.sleep(3000);
            clickOnConnectivityTypeToggleIfTheToggleIsOFF(Log);
            Thread.sleep(3000);
            this.takeScreenShot();
            test.log(Status.PASS, "Verify the editable fields In Edit Service Provider List Screen" + driver.getTitle() + " *  Verify the editable fields PASS * ");
            Log.ReportEvent("PASS", " Verify the editable fields In Edit Service Provider List is Successful");
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify the editable fields in search criteria In Edit Service Provider List Screen" + driver.getTitle() + " *  Verify the editable fields FAIL * ");
            this.takeScreenShot();

        }


    }

    //Method to enter Service Provider Name Arabic
    public void enterServiceProviderNameArabic(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
        Thread.sleep(2000);
        webClear(driver, UapiOR.Admin_EditServiceManagementProviderList_Page_ServiceProviderArabicName);
        WebEdit(UapiOR.Admin_EditServiceManagementProviderList_Page_ServiceProviderArabicName, testdatamap.get("ServiceProviderArabicName").toString());
        this.takeScreenShot();
        Log.ReportEvent("PASS", " Put incorrect data in some fields In Edit Service Provider List is Successful");
    }

    // Method to verify Error Message In Service Provider Name Arabic
    public void verifyErrorMessageForServiceProviderNameArabic(Map<Object, Object> testdatamap, Log Log) throws IOException, InterruptedException {
        clickOnSave(Log);
        VerifyValue1(getText(UapiOR.Admin_EditServiceManagementProviderList_Page_ServiceProviderArabicNameErrorMsg), testdatamap.get("ServiceProviderArabicNameErrorMsg").toString());
        this.takeScreenShot();
        Log.ReportEvent("PASS", " Verify error message In Edit Service Provider List is Successful");
    }

    // Method to click on Save Button
    public void clickOnSave(Log Log) throws InterruptedException {
        WebClick(UapiOR.Admin_EditServiceManagementProviderList_Page_Save);
        Thread.sleep(1000);
        Log.ReportEvent("PASS", " Click on 'Save' button In Edit Service Provider List is Successful");
    }

    // Method to click on Save Button
    public void clickOnCancel() throws InterruptedException {

        WebClick(UapiOR.Admin_EditServiceManagementProviderList_Page_Cancel);
        Thread.sleep(1000);
    }

    //Method to enter Description
    public void enterDescription(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(2000);
        webClear(driver, UapiOR.Admin_EditServiceManagementProviderList_Page_Description);
        WebEdit(UapiOR.Admin_EditServiceManagementProviderList_Page_Description, testdatamap.get("Description").toString());
        this.takeScreenShot();
    }

    // Method to get text form Description
    public String getDescriptionText() {
        String descriptionValue = driver.findElement(By.xpath(UapiOR.Admin_EditServiceManagementProviderList_Page_Description)).getText();
        return descriptionValue;
    }

    //Method to enter ApiKey in Save and View Credentials popup
    public void enterApiKey(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(2000);
        webClear(driver, UapiOR.Admin_EditServiceManagementProviderList_SaveAndViewCredentialsApiKey);
        WebEdit(UapiOR.Admin_EditServiceManagementProviderList_SaveAndViewCredentialsApiKey, testdatamap.get("ApiKey").toString());
        this.takeScreenShot();
    }

    // Method to click on Save In Save and View Credentials Popup
    public void clickOnSaveInSaveAndViewCredentialsPopup() {

        WebClick(UapiOR.Admin_EditServiceManagementProviderList_Page_SaveAndViewCredentialsSave);

    }

    // Method to verify Service Provider Updated Successfully Conformation Message
    public void verifyServiceProviderUpdatedSuccessfullyConformationMessage(Map<Object, Object> testdatamap, Log Log) throws Exception {
        VerifyValue1(getText(UapiOR.Admin_EditServiceManagementProviderList_ServiceProviderUpdatedSuccessfullyMsg), testdatamap.get("SavedConformationMsg").toString());
        Log.ReportEvent("PASS", " User should be able to modify details that displays on 'Service provider connectivity credentials' popup In Edit Service Provider List is Successful");
        this.takeScreenShot();

    }

    // Method to Password Eye Icon In Save and View Credentials Popup
    public void clickOnPasswordEyeIconInSaveAndViewCredentialsPopup() throws InterruptedException {

        WebClick(UapiOR.Admin_EditServiceManagementProviderList_SaveAndViewCredentialsPasswordEyeIcon);
        Thread.sleep(1000);

    }

    //Method to enter UserName in Save and View Credentials popup
    public void enterUserName(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(2000);
        webClear(driver, UapiOR.Admin_EditServiceManagementProviderList_SaveAndViewCredentialsUserName);
        WebEdit(UapiOR.Admin_EditServiceManagementProviderList_SaveAndViewCredentialsUserName, testdatamap.get("UserName").toString());
        this.takeScreenShot();
    }

    //Method to enter ApiId in Save and View Credentials popup
    public void enterApiId(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(2000);
        webClear(driver, UapiOR.Admin_EditServiceManagementProviderList_SaveAndViewCredentialsApiId);
        WebEdit(UapiOR.Admin_EditServiceManagementProviderList_SaveAndViewCredentialsApiId, testdatamap.get("ApiId").toString());
        this.takeScreenShot();
    }

    //Method to enter Password in Save and View Credentials popup
    public void enterPassword(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(2000);
        webClear(driver, UapiOR.Admin_EditServiceManagementProviderList_SaveAndViewCredentialsPassword);
        WebEdit(UapiOR.Admin_EditServiceManagementProviderList_SaveAndViewCredentialsPassword, testdatamap.get("Password").toString());
        this.takeScreenShot();
    }

    // Method to verify Service provider connectivity credentials popup data editable For (SIMAH, WATHQ, TCC, UNIFONIC, MSEGAT)
    public void verifyServiceProviderConnectivityPopupEditableForSimah(Map<Object, Object> testdatamap, Log Log) {
        try {
            enterApiKey(testdatamap);
            clickOnSaveInSaveAndViewCredentialsPopup();
            verifyServiceProviderUpdatedSuccessfullyConformationMessage(testdatamap, Log);
            Log.ReportEvent("PASS", "Verify options according to service providers In Edit Service Provider List is Successful");
            test.log(Status.PASS, "Verify options according to service providers In Edit Service Provider List Screen" + driver.getTitle() + " *  Verify the editable fields PASS * ");

            this.takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify options according to service providers In Edit Service Provider List Screen" + driver.getTitle() + " *  Verify the editable fields FAIL * ");
            this.takeScreenShot();
        }
    }

    // Method to verify Service provider connectivity credentials popup data editable For (Yakeen)
    public void verifyServiceProviderConnectivityPopupEditableForYakeen(Map<Object, Object> testdatamap, Log Log) {
        try {
            enterApiKey(testdatamap);
            enterApiId(testdatamap);
            enterUserName(testdatamap);
            clickOnPasswordEyeIconInSaveAndViewCredentialsPopup();
            enterPassword(testdatamap);
            clickOnPasswordEyeIconInSaveAndViewCredentialsPopup();
            clickOnSaveInSaveAndViewCredentialsPopup();
            verifyServiceProviderUpdatedSuccessfullyConformationMessage(testdatamap, Log);
            Log.ReportEvent("PASS", "Verify options according to service providers In Edit Service Provider List is Successful");
            test.log(Status.PASS, "Verify options according to service providers In Edit Service Provider List Screen" + driver.getTitle() + " *  Verify the editable fields PASS * ");

            this.takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify options according to service providers In Edit Service Provider List Screen" + driver.getTitle() + " *  Verify the editable fields FAIL * ");
            this.takeScreenShot();
        }
    }

    // Method to verify Service provider connectivity credentials popup data editable For (ETIMAD, MASDR, FINTECH, LEAN TECH)
    public void verifyServiceProviderConnectivityPopupEditableForMasdr(Map<Object, Object> testdatamap, Log Log) {
        try {
            enterUserName(testdatamap);
            enterPassword(testdatamap);
            clickOnSaveInSaveAndViewCredentialsPopup();
            verifyServiceProviderUpdatedSuccessfullyConformationMessage(testdatamap, Log);
            Log.ReportEvent("PASS", "Verify options according to service providers In Edit Service Provider List is Successful");
            test.log(Status.PASS, "Verify options according to service providers In Edit Service Provider List Screen" + driver.getTitle() + " *  Verify the editable fields PASS * ");

            this.takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify options according to service providers In Edit Service Provider List Screen" + driver.getTitle() + " *  Verify the editable fields FAIL * ");
            this.takeScreenShot();
        }
    }

    //Method to click on Connectivity Type Toggle if the Toggle is ON
    public void clickOnConnectivityTypeToggleIfTheToggleIsON(Log Log) throws Exception {
        boolean isConnectivityToggleIsON = driver.findElement(By.xpath(UapiOR.Admin_EditServiceManagementProviderList_Page_ConnectivityType)).getAttribute("class").contains("Mui-checked");
        if (isConnectivityToggleIsON == true) {
            clickOnConnectivityTypeToggle();
            verifyConnectivityToggleOFF(Log);
        } else {
            Log.ReportEvent("PASS", "Verify Service provider Connectivity Type Toggle is OFF in Edit Service Provider List Screen is successful");
        }

    }

    //Method to click on Connectivity Type Toggle if the Toggle is OFF
    public void clickOnConnectivityTypeToggleIfTheToggleIsOFF(Log Log) throws Exception {
        boolean isConnectivityToggleIsOFF = !driver.findElement(By.xpath(UapiOR.Admin_EditServiceManagementProviderList_Page_ConnectivityType)).getAttribute("class").contains("Mui-checked");
        if (isConnectivityToggleIsOFF == true) {
            clickOnConnectivityTypeToggle();
            clickOnSave(Log);
            verifyConnectivityToggleON(Log);
        } else {
            Log.ReportEvent("PASS", "Verify Service provider Connectivity Type Toggle is ON in Edit Service Provider List Screen is successful");

        }
    }

    //Method to click on Client Credentials Toggle if the Toggle is OFF
    public void clickOnClientCredentialsToggleIfTheToggleIsOFF(Log Log) throws Exception {
        boolean isClientCredentialsToggleIsOFF = !driver.findElement(By.xpath(UapiOR.Admin_EditServiceManagementProviderList_Page_ClientCredentials)).getAttribute("class").contains("Mui-checked");
        if (isClientCredentialsToggleIsOFF == true) {
            clickOnClientCredentialsToggle();
            clickOnSave(Log);
            verifyClientCredentialsToggleON(Log);
        } else {
            Log.ReportEvent("PASS", "Verify Service provider Client Credentials Toggle is ON in Edit Service Provider List Screen is successful");

        }
    }
    //Method to click on Client Credentials Toggle if the Toggle is ON
    public void clickOnClientCredentialsToggleIfTheToggleIsON(Log Log) throws Exception {
        boolean isClientCredentialsToggleIsON = driver.findElement(By.xpath(UapiOR.Admin_EditServiceManagementProviderList_Page_ClientCredentials)).getAttribute("class").contains("Mui-checked");
        if (isClientCredentialsToggleIsON == true) {
            clickOnClientCredentialsToggle();
            clickOnSave(Log);
            verifyClientCredentialsToggleOFF(Log);
        } else {
            Log.ReportEvent("PASS", "Verify Service provider Client Credentials Toggle is OFF in Edit Service Provider List Screen is successful");

        }
    }
}
