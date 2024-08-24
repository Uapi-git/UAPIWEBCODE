/**
 * Test Script Name                      : EditUserPage.
 * Objective                             : Verify the edit user page Functionality.
 * Version                               : 1.0
 * Author                                : Basavaraj Mudnur
 * Created Date                          : 20/06/2024
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

public class EditUserPage extends BasePage {

    public EditUserPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Admin_EditUser_Page)
    public WebElement EditUserPage;

    public boolean Exists() {
        return super.Exists(EditUserPage);
    }


    /**
     * Method to verify username and email id for existing user in edit user page
     */
    public void verifyUserNameAndEmailIDForExistingUserInEditUserPage() {
        boolean isUserNameDisabled = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_UserName + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isEmailDisabled = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_Email + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        Assert.assertTrue(isUserNameDisabled, "User Name TextField is enabled");
        Assert.assertTrue(isEmailDisabled, "Email Period TextField is enabled");
    }

    /**
     * Method to enter invalid data in edit user page and verify error MSG
     *
     * @param testDataMap <Map> - Test data  map
     * @param log         <Log> - Log
     */
    public void enterInvalidDataInEditUserPageAndVerifyErrorMSG(Map<Object, Object> testDataMap, Log log) {
        final String BLANK_ERROR_MSG = "This field cannot be left blank";
        final String FIRSTNAME_LENGTH_ERROR_MSG = "First name should be less than 10 characters";
        final String LASTNAME_LENGTH_ERROR_MSG = "Last name should be less than 10 characters";
        final String NATIONAL_ID_LENGTH_ERROR_MSG = "National id should be exactly 10 characters";
        final String NATIONAL_ID_DIGITS_ERROR_MSG = "National ID Should contain only digits";
        final String MOBILE_NUMBER_LENGTH_ERROR_MSG = "Invalid contact number. The number should start with 05 and max 10 digit long";

        try {
            webClear(driver, UapiOR.Admin_AddOrEditUserPage_FirstNameTextField);
            WebEdit(UapiOR.Admin_AddOrEditUserPage_FirstNameTextField, testDataMap.get("InvalidFirstName").toString());

            webClear(driver, UapiOR.Admin_AddOrEditUserPage_LastNameTextField);
            WebEdit(UapiOR.Admin_AddOrEditUserPage_LastNameTextField, testDataMap.get("InvalidLastName").toString());

            webClear(driver, UapiOR.Admin_AddOrEditUserPage_NationalIdTextField);
            WebEdit(UapiOR.Admin_AddOrEditUserPage_NationalIdTextField, testDataMap.get("InvalidNationalId").toString());

            webClear(driver, UapiOR.Admin_AddOrEditUserPage_MobileNoTextField);
            WebEdit(UapiOR.Admin_AddOrEditUserPage_MobileNoTextField, testDataMap.get("InvalidMobileNo").toString());

            WebClick(UapiOR.Admin_AddOrEditUserPage_SaveButton);


            String firstNameValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_FirstNameTextField)).getAttribute("value");
            String lastNameValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_LastNameTextField)).getAttribute("value");
            String nationalIdValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_NationalIdTextField)).getAttribute("value");
            String mobileNoValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_MobileNoTextField)).getAttribute("value");
            int firstNameValueLength = firstNameValue.length();
            int lastNameValueLength = lastNameValue.length();
            int nationalIdValueLength = nationalIdValue.length();
            int mobileNoValueLength = mobileNoValue.length();

            // Verify error messages based on conditions
            if (firstNameValueLength == 0 && lastNameValueLength == 0 && nationalIdValueLength == 0 && mobileNoValueLength == 0) {
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_firstName_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_lastName_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_nationalId_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_mobileNo_Error), BLANK_ERROR_MSG);
            } else if (firstNameValueLength >= 11 && lastNameValueLength >= 11 && nationalIdValueLength >= 11 && mobileNoValueLength >= 11) {
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_firstName_Error), FIRSTNAME_LENGTH_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_lastName_Error), LASTNAME_LENGTH_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_nationalId_Error), NATIONAL_ID_LENGTH_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_mobileNo_Error), MOBILE_NUMBER_LENGTH_ERROR_MSG);
            } else if (!nationalIdValue.matches(".*\\d.*") && !mobileNoValue.matches(".*\\d.*")) {
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_nationalId_Error), NATIONAL_ID_DIGITS_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_mobileNo_Error), MOBILE_NUMBER_LENGTH_ERROR_MSG);
            } else if (nationalIdValueLength <= 9 && mobileNoValueLength <= 9) {
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_nationalId_Error), NATIONAL_ID_LENGTH_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_mobileNo_Error), MOBILE_NUMBER_LENGTH_ERROR_MSG);
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

    /**
     * Method to verify company field is inactive to select
     * @param log <Log> - Log
     */
    public void verifyCompanyFieldIsInactiveToSelect(Log log){
        try {
            mouseOver(driver,getElement(UapiOR.Admin_AddOrEditUserPage_CompanyTextField));
            boolean isCompanyDropdownEnabled = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_CompanyTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
            Assert.assertTrue(isCompanyDropdownEnabled, "Status dropdown is enabled");
            test.log(Status.PASS, "#FUNC - Verify Company field is inactive to select  * Verify Company field is inactive to select is Pass *");
            log.ReportEvent("PASS", "Verify Company field is inactive to select is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify Company field is inactive to select is fail *");
            log.ReportEvent("FAIL", "Verify Company field is inactive to select failed: " + e.getMessage());
            takeScreenShot();
        }
    }
}
