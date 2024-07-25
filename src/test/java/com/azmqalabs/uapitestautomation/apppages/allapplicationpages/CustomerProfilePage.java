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
            Thread.sleep(1000);
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

}
