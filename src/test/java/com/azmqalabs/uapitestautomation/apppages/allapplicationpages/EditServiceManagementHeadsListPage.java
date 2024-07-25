/**
 * Test Script Name                      : EditServiceHeadsListPagePage.
 * Objective                             : Verify the Edit Service Heads List Functionality.
 * Version                               : 1.0
 * Author                                : Arun Kumar M S
 * Created Date                          : 26/06/2024
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

public class EditServiceManagementHeadsListPage extends BasePage {

    public EditServiceManagementHeadsListPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Admin_EditServiceManagementHeadsList_Page)
    public WebElement editServiceHeadsListText;

    public boolean Exists() {
        return super.Exists(editServiceHeadsListText);
    }

    // Method to validate edit Service Heads List Page
    public void verifyEditServiceHeadsListPageIsDisplayed(Log Log) {
        try {
            Thread.sleep(1000);
            verifyElementIsPresent(UapiOR.Admin_EditServiceManagementProviderList_Page);
            this.takeScreenShot();
            test.log(Status.PASS, "Verify edit Service Heads List page" + driver.getTitle() + "Verify edit Service Heads List page is Pass");
            Log.ReportEvent("PASS", "User Navigated to edit Service Heads List page");
            this.takeScreenShot();

        } catch (Exception e) {
            this.takeScreenShot();
            test.log(Status.FAIL, "Verify edit edit Service Heads List page" + driver.getTitle() + "Verify edit Service Heads List page is Fail");
        }
    }

    // Method to Upload File
    public void uploadFile(Log Log) throws Exception {
        Thread.sleep(2000);
        uploadFile(UapiOR.Admin_EditServiceManagementHeadsList_Page_Upload, "SamplePNGImage.png");
        Log.ReportEvent("PASS", "Click on 'Upload' button and Upload in Edit Service Heads List Screen is successful");
        this.takeScreenShot();
    }

    // Method to verify file uploaded Successfully
    public void verifyFileUploadedSuccessfully(Map<Object, Object> testdatamap) throws Exception {
        Thread.sleep(1000);
        VerifyValue1(getText(UapiOR.Admin_EditServiceManagementHeadsList_Page_UploadFileText), testdatamap.get("FileName").toString());
    }

    // Method to verify File Upload Error Message, When file size greater than 1 MB.
    public void verifyFileUploadErrorMessage(Map<Object, Object> testdatamap, Log Log) throws Exception {
        Thread.sleep(1000);
        uploadFile(UapiOR.Admin_EditServiceManagementHeadsList_Page_Upload, "SamplePNGImage_3mb.png");
        Thread.sleep(500);
        VerifyValue1(getText(UapiOR.Admin_EditServiceManagementProviderList_Page_UploadFileErrorMsg), testdatamap.get("InvalidFileUpload").toString());
        Log.ReportEvent("PASS", "Click on 'Upload' button and upload,verify Error Message in Edit Service Heads List Screen is successful");
        this.takeScreenShot();
    }

    //Method to enter Service Head Name Arabic
    public void enterServiceHeadNameArabic(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
        Thread.sleep(2000);
        webClear(driver, UapiOR.Admin_EditServiceManagementHeadsList_Page_ServiceHeadNameInArabic);
        WebEdit(UapiOR.Admin_EditServiceManagementHeadsList_Page_ServiceHeadNameInArabic, testdatamap.get("ServiceHeadArabicName").toString());
        this.takeScreenShot();
        Log.ReportEvent("PASS", " Put incorrect data in some fields In Edit Service Head List is Successful");
    }

    // Method to verify Error Message In Service Provider Name Arabic
    public void verifyErrorMessageForServiceHeadNameArabic(Map<Object, Object> testdatamap, Log Log) throws IOException {
        clickOnSave(Log);
        VerifyValue1(getText(UapiOR.Admin_EditServiceManagementHeadsList_Page_ServiceHeadArabicNameErrorMsg), testdatamap.get("ServiceHeadArabicNameErrorMsg").toString());
        this.takeScreenShot();
        Log.ReportEvent("PASS", " Verify error message In Edit Service Heads List is Successful");
    }

    // Method to click on Save Button
    public void clickOnSave(Log Log) {
        WebClick(UapiOR.Admin_EditServiceManagementHeadsList_Page_Save);
        Log.ReportEvent("PASS", " Click on 'Save' button In Edit Service Heads List is Successful");
    }

    // Method to click on Save Button
    public void clickOnCancel() throws InterruptedException {

        WebClick(UapiOR.Admin_EditServiceManagementHeadsList_Page_Cancel);
        Thread.sleep(1000);
    }

    // Method to enter Description
    public void enterDescription(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(2000);
        webClear(driver, UapiOR.Admin_EditServiceManagementHeadsList_Page_Description);
        WebEdit(UapiOR.Admin_EditServiceManagementHeadsList_Page_Description, testdatamap.get("Description").toString());
        this.takeScreenShot();
    }

    // Method to verify Error Message In Edit Service Head List Description
    public void verifyErrorMessageForDescription(Map<Object, Object> testdatamap, Log Log) throws IOException {
        clickOnSave(Log);
        VerifyValue1(getText(UapiOR.Admin_EditServiceManagementHeadsList_Page_DescriptionErrorMsg), testdatamap.get("DescriptionErrorMsg").toString());
        this.takeScreenShot();
        Log.ReportEvent("PASS", " Verify error message In Edit Service Heads List is Successful");
    }

    // Method to get text form Description
    public String getDescriptionText() {
        String descriptionValue = driver.findElement(By.xpath(UapiOR.Admin_EditServiceManagementHeadsList_Page_Description)).getText();
        return descriptionValue;
    }

    // Method to verify Service Heads Updated Successfully Conformation Message
    public void verifyServiceHeadsUpdatedSuccessfullyConformationMessage(Map<Object, Object> testdatamap, Log Log) throws Exception {
        VerifyValue1(getText(UapiOR.Admin_EditServiceManagementProviderList_ServiceHeadsUpdatedSuccessfullyMsg), testdatamap.get("UpdatedConformationMsg").toString());
        Log.ReportEvent("PASS", " Verify the editable fields In Edit Service Heads List is Successful");
        this.takeScreenShot();

    }

    // Method to select Service Head Name value from dropdown
    public void selectServiceHeadNameFromDropdown(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(1000);
        WebClick(UapiOR.Admin_EditServiceManagementHeadsList_Page_OriginalServiceHeadName);
        Thread.sleep(1000);
        WebClickUsingJS("//li[text()='" + testdatamap.get("ServiceHeadName").toString() + "']");
    }

    // Method to select Service Head Name value from dropdown
    public void selectServiceSectorNameFromDropdown(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(1000);
        WebClick(UapiOR.Admin_EditServiceManagementHeadsList_Page_OriginalServiceHeadSector);
        Thread.sleep(1000);
        WebClickUsingJS("//li[text()='" + testdatamap.get("ServiceSectorName").toString() + "']");
    }

    // Method to verify editable fields in Edit Service Head List Screen
    public void verifyEditableFieldsInEditServiceHeadListScreen(Map<Object, Object> testdatamap, Log Log) throws Exception {
        try {
            boolean isServiceHeadNameInArabicEditable = !driver.findElement(By.xpath(UapiOR.Admin_ServiceManagementHeadsList_Page_ServiceHeadNameInArabic)).getAttribute("class").contains("Mui-disabled");
            boolean isDescriptionEditable = !driver.findElement(By.xpath(UapiOR.Admin_ServiceManagementHeadsList_Page_Description)).getAttribute("class").contains("Mui-disabled");
            Assert.assertTrue(isServiceHeadNameInArabicEditable, "Service Head Arabic Name TextField is disabled");
            Assert.assertTrue(isDescriptionEditable, "Description TextField is disabled");
            uploadFile(Log);
            verifyFileUploadedSuccessfully(testdatamap);
            selectServiceHeadNameFromDropdown(testdatamap);
            selectServiceSectorNameFromDropdown(testdatamap);
            this.takeScreenShot();
            test.log(Status.PASS, "Verify the editable fields In Edit Service Head List Screen" + driver.getTitle() + " *  Verify the editable fields PASS * ");
            Log.ReportEvent("PASS", " Verify the editable fields In Edit Service Head List is Successful");
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify the editable fields in search criteria In Edit Service Head List Screen" + driver.getTitle() + " *  Verify the editable fields FAIL * ");
            this.takeScreenShot();

        }


    }

    // Method to verify Save and View Credentials button is enabled
    public void verifyConnectivityTypeSaveAndViewCredentialsButtonIsDisplayed(Log Log) throws Exception {
        Thread.sleep(1000);
        boolean isConnectivityTypeEnabled = !driver.findElement(By.xpath(UapiOR.Admin_EditServiceManagementHeadsList_Page_ConnectivityType)).getAttribute("class").contains("Mui-disabled");
        Assert.assertTrue(isConnectivityTypeEnabled, "Connectivity Type is disabled");
        this.takeScreenShot();
        Log.ReportEvent("PASS", "Verify Connectivity Type' button is enabled in edit Service Heads List page is Successful");
        this.takeScreenShot();
    }
}

