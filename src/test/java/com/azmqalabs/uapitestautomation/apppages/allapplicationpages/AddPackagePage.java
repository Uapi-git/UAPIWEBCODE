/**
 * Test Script Name                      : AddPackagePage.
 * Objective                             : Verify the add package page Functionality.
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

public class AddPackagePage extends BasePage {

    public AddPackagePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Admin_AddPackage_Page)
    public WebElement addPackagePage;

    public boolean Exists() {
        return super.Exists(addPackagePage);
    }

    /**
     * Method to enter package name
     * @param testDataMap <Map> - Test data map
     */
    public void enterPackageName(Map<Object, Object> testDataMap) {
        if (Exists()) {
            WebEdit(UapiOR.Admin_PackageManagement_PackageNameTextField, testDataMap.get("PackageName").toString());
        }
    }

    /**
     * Method to enter package arabic name
     * @param testDataMap <Map> - Test data map
     */
    public void  enterPackageArabicName(Map<Object, Object> testDataMap){
        WebEdit(UapiOR.Admin_PackageManagement_PackageArabicNameTextField,testDataMap.get("PackageArabicName").toString());
    }

    /**
     * Method to enter price per period
     * @param testDataMap <Map> - Test data map
     */
    public void  enterPricePerPeriod (Map<Object, Object> testDataMap){
        WebEdit(UapiOR.Admin_PackageManagement_PricePerPeriodTextField,testDataMap.get("PricePerPeriod").toString());
    }

    /**
     * Method to select package period dropdown
     * @param testDataMap <Map> - Test data map
     */
    public void  selectPackagePeriodDropdown(Map<Object,Object>testDataMap){
        WebClick(UapiOR.Admin_PackageManagement_PackagePeriodDropdown);
        String option = testDataMap.get("PackagePeriod").toString().toUpperCase();
        driver.findElement(By.xpath("//li[@data-value='"+ option +"']")).click();
    }

    /**
     * Method to enter transaction limit
     * @param testDataMap <Map> Test data map
     */
    public void  enterTransactionLimit (Map<Object, Object> testDataMap){
        WebEdit(UapiOR.Admin_PackageManagement_TransactionLimit,testDataMap.get("TransactionLimit").toString());
    }

    /**
     * Method to select package period dropdown
     * @param testDataMap <Map> - Test data map
     */
    public void  selectStatusDropdown(Map<Object,Object>testDataMap){
        WebClick(UapiOR.Admin_PackageManagement_StatusDropdown);
        String option = testDataMap.get("Status").toString().toLowerCase();
        driver.findElement(By.xpath("//li[@data-value='"+ option +"']")).click();
    }

    /**
     * Method to click on save button
     * @param log <Log> - Log
     */
    public void clickOnSaveButton(Log log){
        try {
            WebClick(UapiOR.Admin_PackageManagement_AddOrEditFormSaveButton);
            test.log(Status.PASS, "#FUNC -  Click on 'Save' button " + " * Click on 'Save' button is Pass * ");
            log.ReportEvent("PASS", " Click on 'Save' button is successful");
            takeScreenShot();
            waitForTwoSec();
        }
        catch (Exception e){
            test.log(Status.PASS, "Click on 'Save' button " + " * Click on 'Save' button is fail * ");
        }
    }

    /**
     * Method to add new Package details
     * @param testDataMap <Map> - Test data map
     */
    public void addNewPackageDetails(Map<Object,Object> testDataMap){
        enterPackageName(testDataMap);
        enterPackageArabicName(testDataMap);
        enterPricePerPeriod(testDataMap);
        selectPackagePeriodDropdown(testDataMap);
        enterTransactionLimit(testDataMap);
        selectStatusDropdown(testDataMap);
    }

    /**
     * Precondition to add package
     * @param testDataMap <Map> - Test data map
     */
    public void preconditionToAddPackage(Map<Object,Object> testDataMap){
        enterPackageName(testDataMap);
        enterPackageArabicName(testDataMap);
        enterPricePerPeriod(testDataMap);
        selectPackagePeriodDropdown(testDataMap);
        enterTransactionLimit(testDataMap);
        selectStatusDropdown(testDataMap);
        WebClick(UapiOR.Admin_PackageManagement_AddOrEditFormSaveButton);
    }


    /**
     * Method to add new service bundles package details
     * @param testDataMap <Map> - Test data map
     */
    public void addNewServiceBundlesPackageDetails(Map<Object,Object> testDataMap){
        enterPackageName(testDataMap);
        enterPackageArabicName(testDataMap);
        enterPricePerPeriod(testDataMap);
        selectPackagePeriodDropdown(testDataMap);
        selectStatusDropdown(testDataMap);
    }

    /**
     * Precondition to add services bundles package
     * @param testDataMap <Map> - Test data map
     */
    public void preconditionToAddServicesBundlesPackage(Map<Object,Object> testDataMap){
        enterPackageName(testDataMap);
        enterPackageArabicName(testDataMap);
        enterPricePerPeriod(testDataMap);
        selectPackagePeriodDropdown(testDataMap);
        selectStatusDropdown(testDataMap);
        WebClick(UapiOR.Admin_PackageManagement_AddOrEditFormSaveButton);
    }

    /**
     * Method to enter invalid data in annual subscription tier bundle add page and verify error MSG
     * @param testDataMap <Map> - Test data  map
     * @param log <Log> - Log
     */
    public void enterInvalidDataInAnnualSubscriptionTiersAddPageAndVerifyErrorMSG(Map<Object, Object> testDataMap, Log log) {
        final String BLANK_ERROR_MSG = "This field cannot be left blank";
        final String Package_Name_LENGTH_ERROR_MSG = "Package name should be less than 20 characters";
        final String PRICE_PER_PERIOD_LENGTH_ERROR_MSG = "Price per period should contains exact 20 digit number";
        final String Transaction_Limit_LENGTH_ERROR_MSG = "Transaction Limit should contains exact 10 digit number";
        final String PRICE_PER_PERIOD_BLANK_ERROR_MSG = "Price per period should only contains numbers";
        final String Transaction_Limit_BLANK_ERROR_MSG = "Transaction Limit should only contains numbers";

        try {
            WebEdit(UapiOR.Admin_PackageManagement_PackageNameTextField, testDataMap.get("InvalidPackageName").toString());
            WebEdit(UapiOR.Admin_PackageManagement_PricePerPeriodTextField, testDataMap.get("InvalidPricePerPeriod").toString());
            WebEdit(UapiOR.Admin_PackageManagement_TransactionLimit, testDataMap.get("InvalidTransactionLimit").toString());
            WebClick(UapiOR.Admin_PackageManagement_AddOrEditFormSaveButton);
            WebClick(UapiOR.Admin_PackageManagement_AddOrEditFormSaveButton);

            String packageNameValue = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackageNameTextField)).getAttribute("value");
            String pricePerPeriodValue = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PricePerPeriodTextField)).getAttribute("value");
            String packagePeriodDropdownValue  = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackagePeriodDropdown)).getText();
            String transactionLimitValue  = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_TransactionLimit)).getAttribute("value");
            int packageNameValueLength = packageNameValue.length();
            int pricePerPeriodLength = pricePerPeriodValue.length();
            int transactionLimitLength = transactionLimitValue.length();
            int packagePeriodDLength = packagePeriodDropdownValue.length();

            // Verify error messages based on conditions
            if (packageNameValueLength == 0 && pricePerPeriodLength == 0 && packagePeriodDLength == 0 && transactionLimitLength == 0) {
                Assert.assertEquals(getText(UapiOR.Admin_EditPackagePage_PackageName_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_PackagePage_PricePerPeriod_Error), PRICE_PER_PERIOD_BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_PackagePage_PackagePeriod_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_Transaction_Limit_Error), Transaction_Limit_BLANK_ERROR_MSG);

            }
            else if (packageNameValueLength >= 21 && pricePerPeriodLength >= 21 && transactionLimitLength >= 11) {
                Assert.assertEquals(getText(UapiOR.Admin_EditPackagePage_PackageName_Error), Package_Name_LENGTH_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_PackagePage_PricePerPeriod_Error), PRICE_PER_PERIOD_LENGTH_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_PackagePage_PackagePeriod_Error),BLANK_ERROR_MSG );
                Assert.assertEquals(getText(UapiOR.Admin_Transaction_Limit_Error), Transaction_Limit_LENGTH_ERROR_MSG);
            }

            // Log success
            test.log(Status.PASS, "#FUNC - Verify error message * Verify error message is Pass *");
            log.ReportEvent("PASS", "Verify error message is successful");
            takeScreenShot();

        } catch (Exception e) {
            test.log(Status.FAIL, "Verify error message * Verify error message is fail *");
            log.ReportEvent("FAIL", "Verify error message failed: " + e.getMessage());
            takeScreenShot();
        }
    }

    /**
     * Method to enter invalid data in service bundle add page and verify error MSG
     * @param testDataMap <Map> - Test data  map
     * @param log <Log> - Log
     */
    public void enterInvalidDataInServiceBundleAddPageAndVerifyErrorMSG(Map<Object, Object> testDataMap, Log log) {
        final String BLANK_ERROR_MSG = "This field cannot be left blank";
        final String Package_Name_LENGTH_ERROR_MSG = "Package name should be less than 20 characters";
        final String PRICE_PER_PERIOD_LENGTH_ERROR_MSG = "Price per period should contains exact 20 digit number";
        final String PRICE_PER_PERIOD_BLANK_ERROR_MSG = "Price per period should only contains numbers";

        try {
            WebEdit(UapiOR.Admin_PackageManagement_PackageNameTextField, testDataMap.get("InvalidPackageName").toString());
            WebEdit(UapiOR.Admin_PackageManagement_PricePerPeriodTextField, testDataMap.get("InvalidPricePerPeriod").toString());
            WebClick(UapiOR.Admin_PackageManagement_AddOrEditFormSaveButton);
            WebClick(UapiOR.Admin_PackageManagement_AddOrEditFormSaveButton);

            String packageNameValue = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackageNameTextField)).getAttribute("value");
            String pricePerPeriodValue = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PricePerPeriodTextField)).getAttribute("value");
            String packagePeriodDropdownValue  = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackagePeriodDropdown)).getText();
            int packageNameValueLength = packageNameValue.length();
            int pricePerPeriodLength = pricePerPeriodValue.length();
            int packagePeriodDLength = packagePeriodDropdownValue.length();

            // Verify error messages based on conditions
            if (packageNameValueLength == 0 && pricePerPeriodLength == 0 && packagePeriodDLength == 0) {
                Assert.assertEquals(getText(UapiOR.Admin_EditPackagePage_PackageName_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_PackagePage_PricePerPeriod_Error), PRICE_PER_PERIOD_BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_PackagePage_PackagePeriod_Error), BLANK_ERROR_MSG);
            }
            else if (packageNameValueLength >= 21 && pricePerPeriodLength >= 21) {
                Assert.assertEquals(getText(UapiOR.Admin_EditPackagePage_PackageName_Error), Package_Name_LENGTH_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_PackagePage_PricePerPeriod_Error), PRICE_PER_PERIOD_LENGTH_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_PackagePage_PackagePeriod_Error), BLANK_ERROR_MSG);
            }
            test.log(Status.PASS, "#FUNC - Verify error message * Verify error message is Pass *");
            log.ReportEvent("PASS", "Verify error message is successful");
            takeScreenShot();

        } catch (Exception e) {
            test.log(Status.FAIL, "Verify error message * Verify error message is fail *");
            log.ReportEvent("FAIL", "Verify error message failed: " + e.getMessage());
            takeScreenShot();
        }
    }


}
