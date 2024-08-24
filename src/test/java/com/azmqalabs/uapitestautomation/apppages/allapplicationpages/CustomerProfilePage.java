/**
 * Test Script Name                      : CustomerPage.
 * Objective                             : Verify the Customer Profile page Functionality.
 * Version                               : 1.0
 * Author                                : Arun Kumar MS
 * Created Date                          : 28/06/2024
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

public class CustomerProfilePage extends BasePage {

    public CustomerProfilePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Customer_CustomerProfile_Page)
    public WebElement customerProfilePage;

    public boolean Exists() {
        return super.Exists(customerProfilePage);
    }

    // Method to validate Customer Profile Page
    public void verifyCustomerProfilePageIsDisplayed(Log Log) {
        try {
            waitForTwoSec();
            verifyElementIsPresent(UapiOR.Customer_CustomerProfile_Button);
            this.takeScreenShot();
            test.log(Status.PASS, "Verify Customer profile page is displayed" + driver.getTitle() + "Verify customer profile page is Pass");
            Log.ReportEvent("PASS", "User Navigated to Customer Profile page");
            this.takeScreenShot();

        } catch (Exception e) {
            this.takeScreenShot();
            test.log(Status.FAIL, "Verify Customer profile page is displayed" + driver.getTitle() + "Verify customer profile page is Fail");

        }
    }

    // Method to click on Customer Profile Icon
    public void clickOnCustomerProfileIcon() {
        WebClick(UapiOR.Customer_CustomerProfile_Icon);
    }

    // Method to click on Customer Profile Button
    public void clickOnCustomerProfileButton() {
        WebClick(UapiOR.Customer_CustomerProfile_Button);
    }

    // Method to click on Connectivity Tab
    public void clickOnConnectivityTab(Log Log) {
        WebClick(UapiOR.Customer_CustomerProfile_ConnectivityButton);
        Log.ReportEvent("PASS", " click on 'Connectivity' tab in Profile screen is Successful ");
        this.takeScreenShot();
    }

    //Method to verify Service Provider Name(Simha) Is Displayed
    public void verifySimhaServiceProviderNameIsDisplayed(Log Log) throws Exception {
        Thread.sleep(2000);
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_Connectivity_SimhaServiceProvider);
        Log.ReportEvent("PASS", "verify Service Name(Simha) is displayed is Successful ");
    }
    //Method to verify Service Provider Name(Simha) Is Not Displayed
    public void verifySimhaServiceProviderNameIsNotDisplayed(Log Log) throws Exception {
        Thread.sleep(2000);
        verifyElementIsNotPresent(UapiOR.Customer_CustomerProfile_Connectivity_SimhaServiceProvider);
        Log.ReportEvent("PASS", "verify Service Provider Name(Simha) is Not displayed is Successful ");
    }

    //Method to Navigate Customer Profile Screen
    public void navigateCustomerProfileScreen() {
        clickOnCustomerProfileIcon();
        clickOnCustomerProfileButton();

    }
    /**
     * Method to verify view Mode or Non-Editable in Profile tab
     */
    public void verifyViewModeInProfileTab(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_ProfileName);
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_Address);
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_Company);
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_Role);
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_Email);
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_Status);
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_ContactNo);
        Log.ReportEvent("PASS", "Verify options under Profile tab is successful ");
        this.takeScreenShot();
    }
    // Method to click on Api key tab
    public void clickOnApiKeyTab() {
        WebClick(UapiOR.Customer_CustomerProfile_ApiKeyTab);
    }

    // Method to validate Customer Profile Page
    public void verifyApiKeyPageIsDisplayed(Log Log) {
        try {
            Thread.sleep(1000);
            verifyElementIsPresent(UapiOR.Customer_CustomerProfile_ApiKey);
            this.takeScreenShot();
            test.log(Status.PASS, "Verify Customer Api Key Screen is displayed" + driver.getTitle() + "Verify Customer Api Key Screen is Pass");
            Log.ReportEvent("PASS", "User Navigated to Customer Api Key Screen");
            this.takeScreenShot();

        } catch (Exception e) {
            this.takeScreenShot();
            test.log(Status.FAIL, "Verify Customer Api Key Screen displayed" + driver.getTitle() + "Verify Customer Api Key Screen is Fail");

        }
    }
    // Method to click on Api key Copy Icon
    public void clickOnApiKeyCopyIcon() {
        WebClick(UapiOR.Customer_CustomerProfile_ApiKeyCopyIcon);
    }
    // Method to verify Api key copied Successful toast message
    public void verifyApiKeyCopiedSuccessfulToastMessage(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_ApiKeyCopiedToast);
        Log.ReportEvent("PASS", "Verify api key copied successful");
        this.takeScreenShot();
    }
    // Method to verify Api key copied Successful toast message
    public void verifyRegenerateApiKeyButton(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_RegenerateApiKey);
        Log.ReportEvent("PASS", "Verify Regenerate Api Key button is successful in Api Key Screen ");
        this.takeScreenShot();
    }
    // Method to click on Regenerate Api Key
    public void clickOnRegenerateApiKey() {
        WebClick(UapiOR.Customer_CustomerProfile_RegenerateApiKey);
    }
    // Method to verify Regenerate popup details
    public void verifyRegeneratePopupDetails(Log Log) throws Exception {
        Thread.sleep(2000);
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_RegenerateApiKeyYes);
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_RegenerateApiKeyNo);
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_RegenerateApiKeyConformationText);
        Log.ReportEvent("PASS", "Verify options in Regenerate Api Key popup is Successful");
        this.takeScreenShot();
    }
    // Method to click on No in Regenerate Api key popup
    public void clickOnNoInRegenerateApiKeyPopup() {
        WebClick(UapiOR.Customer_CustomerProfile_RegenerateApiKeyNo);
    }
    // Method to get text form Description
    public String getApiKey() {
        String apiKeyValue = driver.findElement(By.xpath(UapiOR.Customer_CustomerProfile_ApiKeyText)).getText();
        return apiKeyValue;
    }
    // Method to click on Yes in Regenerate Api key popup
    public void clickOnYesInRegenerateApiKeyPopup() {
        WebClick(UapiOR.Customer_CustomerProfile_RegenerateApiKeyYes);
    }
    //Method to verify Api Key Changed Successfully
    public void verifyApiKeyChangedSuccessfully(String apiKeyValue,Log Log)
    {
        String presentApiKeyValue = driver.findElement(By.xpath(UapiOR.Customer_CustomerProfile_ApiKeyText)).getText();
        Assert.assertNotEquals(presentApiKeyValue,apiKeyValue);
        Log.ReportEvent("PASS", "Verify Api Key Changed Successful in Api Key Tab");
    }

    // Method to click on Use my credentials toggle
    public void clickOnUseMyCredentialsToggle(Map<Object, Object> testdatamap, Log Log) {
        WebClick("//p[text()='" + testdatamap.get("ProviderNameUseMyCredentials").toString() + "']/parent::div/following-sibling::div//span[contains(@class,'MuiSwitch-switchBase')]");
        Log.ReportEvent("PASS", " Click on Use My Credentials In Connectivity Tab is Successful");
        this.takeScreenShot();
    }
    //Method to click on Use my credentials toggle
    public void clickOnUseMyCredentialsToggleInConnectivityTabIfToggleIsOff(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
        Thread.sleep(2000);
        boolean isUseMyCredentialsToggleIsOFF = !driver.findElement(By.xpath(UapiOR.Customer_CustomerProfile_Page_ConnectivityUseMyCredentialsToggle)).getAttribute("class").contains("checked");
        if (isUseMyCredentialsToggleIsOFF == true) {
            clickOnUseMyCredentialsToggle(testdatamap,Log);
            verifyUseMyCredentialsToggleON(Log);
        }
    }
    //Method to click on Use my credentials toggle
    public void clickOnUseMyCredentialsToggleInConnectivityTabIfToggleIsON(Map<Object, Object> testdatamap,Log Log){
        boolean isUseMyCredentialsToggleIsON = driver.findElement(By.xpath(UapiOR.Customer_CustomerProfile_Page_ConnectivityUseMyCredentialsToggle)).getAttribute("class").contains("checked");
        if (isUseMyCredentialsToggleIsON == true) {
            clickOnUseMyCredentialsToggle(testdatamap,Log);
            verifyUseMyCredentialsToggleOFF(Log);
        }
    }
    //Method to verify Use My Credentials Toggle is ON
    public void verifyUseMyCredentialsToggleON(Log Log) {
        boolean isUseMyCredentialsToggleIsON = driver.findElement(By.xpath(UapiOR.Customer_CustomerProfile_Page_ConnectivityUseMyCredentialsToggle)).getAttribute("class").contains("checked");
        Assert.assertTrue(isUseMyCredentialsToggleIsON, "Use My Credentials toggle is OFF");
        Log.ReportEvent("PASS", "Verify Use My Credentials toggle is ON in Connectivity Tab");
        this.takeScreenShot();

    }
    //Method to verify Use My Credentials Toggle is ON
    public void verifyUseMyCredentialsToggleOFF(Log Log) {
        boolean isUseMyCredentialsToggleIsOFF = !driver.findElement(By.xpath(UapiOR.Customer_CustomerProfile_Page_ConnectivityUseMyCredentialsToggle)).getAttribute("class").contains("checked");
        Assert.assertTrue(isUseMyCredentialsToggleIsOFF, "Use My Credentials toggle is ON");
        Log.ReportEvent("PASS", "Verify Use My Credentials toggle is OFF in Connectivity Tab");
        this.takeScreenShot();

    }
    // Method to Click on Api Key Eye Icon
    public void clickOnApiKeyEyeIcon(Log Log) throws InterruptedException {
        WebClick(UapiOR.Customer_CustomerProfile_Page_ConnectivityApiKeyEyeIcon);
        Thread.sleep(1000);
        Log.ReportEvent("PASS", "click on 'view' icon to view API key in Connectivity Tab is Successful");
        this.takeScreenShot();

    }

    //Method to enter Api Key
    public void enterApiKey(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(2000);
        webClear(driver, UapiOR.Customer_CustomerProfile_Page_ConnectivityEnterApiKey);
        WebEdit(UapiOR.Customer_CustomerProfile_Page_ConnectivityEnterApiKey, testdatamap.get("ApiKey").toString());
        this.takeScreenShot();
    }
    // Method to Click save Button
    public void clickOnSaveButton() throws InterruptedException {
        WebClick(UapiOR.Customer_CustomerProfile_Page_ConnectivitySave);
        Thread.sleep(2000);
    }
    // Method to verify Api key saved Successful toast message
    public void verifyApiKeySavedSuccessfulToastMessage(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerProfile_Page_ConnectivityApiKeySavedSuccessfully);
        Log.ReportEvent("PASS", "Verify api key Saved successful");
        this.takeScreenShot();
    }
    // Method to click on Service Provider Name In Connectivity Tab
    public void clickOnServiceProviderName(Map<Object, Object> testdatamap, Log Log) {
        WebClick("//h1[text()='" + testdatamap.get("ProviderName").toString() + "']");
        Log.ReportEvent("PASS", " Click on Service Provider In Connectivity Tab is Successful");
        this.takeScreenShot();
    }
    // Method to click on Service Provider Name In Connectivity Tab
    public void clickOnServiceProviderExpandMoreIcon(Map<Object, Object> testdatamap, Log Log) {
        WebClick("//h1[text()='" + testdatamap.get("ProviderName").toString() + "']/ancestor::li/child::button//*[@data-testid='ExpandMoreIcon']");
        Log.ReportEvent("PASS", " Click on Service Provider Expand More Icon In Connectivity Tab is Successful");
        this.takeScreenShot();
    }

    // Method to click on Service Head Name In Connectivity Tab
    public void clickOnServiceHeadName(Map<Object, Object> testdatamap, Log Log) {
        WebClick("//h2[text()='" + testdatamap.get("HeadName").toString() + "']");
        Log.ReportEvent("PASS", " Click on Service Head In Connectivity Tab is Successful");
        this.takeScreenShot();
    }

    // Method to Click on Home Tab
    public void clickOnHomeTab() throws InterruptedException {
        WebClick(UapiOR.Customer_CustomerProfile_Page_HomeTab);
        Thread.sleep(2000);
    }
}
