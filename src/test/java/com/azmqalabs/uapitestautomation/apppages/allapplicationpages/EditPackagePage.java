/**
 * Test Script Name                      : EditPackagePage.
 * Objective                             : Verify the edit package page Functionality.
 * Version                               : 1.0
 * Author                                : Basavaraj Mudnur
 * Created Date                          : 12/06/2024
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

public class EditPackagePage extends BasePage {

    public EditPackagePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Admin_EditPackage_Page)
    public WebElement EditPackagePage;

    public boolean Exists() {
        return super.Exists(EditPackagePage);
    }


    /**
     * Method to verify edit Mode after click on edit from action list
     */
    public void verifyEditModeAfterClickOnEditFromActionList(){
        boolean isPackageNameEnabled = !driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackageNameTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isPackageArabicNameEnabled = !driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackageArabicNameTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isStatusDropdownEnabled = !driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_StatusDropdown + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        Assert.assertTrue(isPackageNameEnabled, "Package Name TextField is disabled");
        Assert.assertTrue(isPackageArabicNameEnabled, "Package Arabic Name TextField is disabled");
        Assert.assertTrue(isStatusDropdownEnabled, "Status Dropdown is disabled");
    }

    /**
     * Method to verify edit Mode after click on edit from action list
     */
    public void modifyChangesInEditPageAndClickOnCancelButton(Map<Object,Object>testDataMap, Log log) {
        try {
            if (Exists()) {
                webClear(driver, UapiOR.Admin_PackageManagement_PackageNameTextField);
                WebEdit(UapiOR.Admin_PackageManagement_PackageNameTextField, testDataMap.get("ModifiedPackageName").toString());
                webClear(driver, UapiOR.Admin_PackageManagement_PackageArabicNameTextField);
                WebEdit(UapiOR.Admin_PackageManagement_PackageArabicNameTextField, testDataMap.get("ModifiedArabicPackageName").toString());
                WebClick(UapiOR.Admin_PackageManagement_StatusDropdown);
                WebClick(UapiOR.Admin_PackageManagement_StatusDropdownInactiveOption);

                test.log(Status.PASS, "#FUNC -  Modify changes and click on 'Cancel' button " + " *   Modify changes and click on 'Cancel' button is Pass * ");
                log.ReportEvent("PASS", " Modify changes and click on 'Cancel' button is successful");
                takeScreenShot();
                WebClick(UapiOR.Admin_PackageManagement_AddOrEditFormCancelButton);
                waitForTwoSec();
                takeScreenShot();
            }
        } catch (Exception e) {
            test.log(Status.FAIL, " Modify changes and click on 'Cancel' button " + " *   Modify changes and click on 'Cancel' button is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify modify Changes In edit page and click on save button
     * @param testDataMap <Map> - Test data  map
     * @param log <Log> - Log
     */
    public void modifyChangesInEditPageAndClickOnSaveButton(Map<Object,Object> testDataMap,Log log){
        try {
            webClear(driver,UapiOR.Admin_PackageManagement_PackageNameTextField);
            WebEdit(UapiOR.Admin_PackageManagement_PackageNameTextField, testDataMap.get("ModifiedPackageName").toString());
            webClear(driver,UapiOR.Admin_PackageManagement_PackageArabicNameTextField);
            WebEdit(UapiOR.Admin_PackageManagement_PackageArabicNameTextField, testDataMap.get("ModifiedArabicPackageName").toString());
            WebClick(UapiOR.Admin_PackageManagement_StatusDropdown);
            WebClick(UapiOR.Admin_PackageManagement_StatusDropdownActiveOption);
            test.log(Status.PASS, "#FUNC -  Modify changes and click on 'Save' button " + " *   Modify changes and click on 'Save' button is Pass * ");
            log.ReportEvent("PASS", " Modify changes and click on 'Cancel' button is successful");
            takeScreenShot();
            WebClick(UapiOR.Admin_PackageManagement_AddOrEditFormSaveButton);
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, " Modify changes and click on 'Save' button " + " *   Modify changes and click on 'Save' button is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to enter invalid data in edit page and verify error MSG
     * @param testDataMap <Map> - Test data  map
     * @param log <Log> - Log
     */
    public void enterInvalidDataInServiceBundleEditPageAndVerifyErrorMSG(Map<Object, Object> testDataMap, Log log) {
        final String BLANK_ERROR_MSG = "This field cannot be left blank";
        final String LENGTH_ERROR_MSG = "Package name should be less than 20 characters";
        final String ARABIC_LENGTH_ERROR_MSG = "Package arabic name should not exceed more than 20 characters";
        final String ARABIC_ERROR_MSG = "Package arabic name should only contains arabic characters";

        try {
            // Clear and enter invalid package name
            webClear(driver, UapiOR.Admin_PackageManagement_PackageNameTextField);
            WebEdit(UapiOR.Admin_PackageManagement_PackageNameTextField, testDataMap.get("InvalidPackageName").toString());

            // Clear and enter invalid package Arabic name
            webClear(driver, UapiOR.Admin_PackageManagement_PackageArabicNameTextField);
            WebEdit(UapiOR.Admin_PackageManagement_PackageArabicNameTextField, testDataMap.get("InvalidArabicPackageName").toString());
            WebClick(UapiOR.Admin_PackageManagement_AddOrEditFormSaveButton);

            // Retrieve and validate package name and Arabic package name length
            String packageNameValue = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackageNameTextField)).getAttribute("value");
            String arabicPackageNameValue = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackageArabicNameTextField)).getAttribute("value");
            int packageNameValueLength = packageNameValue.length();
            int arabicPackageNameValueLength = arabicPackageNameValue.length();

            // Verify error messages based on conditions
            if (packageNameValueLength == 0) {
                Assert.assertEquals(getText(UapiOR.Admin_EditPackagePage_PackageName_Error), BLANK_ERROR_MSG);
            }
            else if (packageNameValueLength >= 21 && arabicPackageNameValueLength >= 21) {
                Assert.assertEquals(getText(UapiOR.Admin_EditPackagePage_PackageName_Error), LENGTH_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_EditPackagePage_ArabicPackageName_Error), ARABIC_LENGTH_ERROR_MSG);
            }
            else if (packageNameValueLength >= 21) {
                Assert.assertEquals(getText(UapiOR.Admin_EditPackagePage_PackageName_Error), LENGTH_ERROR_MSG);
            }
            else if (arabicPackageNameValueLength >= 21) {
                Assert.assertEquals(getText(UapiOR.Admin_EditPackagePage_ArabicPackageName_Error), ARABIC_LENGTH_ERROR_MSG);
            }
            else if (!arabicPackageNameValue.matches("[\\u0600-\\u06FF\\u0750-\\u077F\\u08A0-\\u08FF\\uFB50-\\uFDFF\\uFE70-\\uFEFF\\u1EE00-\\u1EEFF]+")) {
                Assert.assertEquals(getText(UapiOR.Admin_EditPackagePage_ArabicPackageName_Error), ARABIC_ERROR_MSG);
            }

            // Log success
            test.log(Status.PASS, "#FUNC - Verify error message * Verify error message is Pass *");
            log.ReportEvent("PASS", "Verify error message is successful");
            takeScreenShot();

        } catch (Exception e) {
            // Log failure
            test.log(Status.FAIL, "Verify error message * Verify error message is fail *");
            log.ReportEvent("FAIL", "Verify error message failed: " + e.getMessage());
            takeScreenShot();
        }
    }
}
