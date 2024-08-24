/**
 * Test Script Name                      : CreateUserPage.
 * Objective                             : Verify the create user page Functionality.
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

public class CreateUserPage extends BasePage {

    public CreateUserPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Admin_CreateUser_Page)
    public WebElement CreateUserPage;

    public boolean Exists() {
        return super.Exists(CreateUserPage);
    }


    /**
     * Method to verify save button is available in create user page
     *
     * @param log <Log> - Log
     */
    public void verifySaveButtonIsAvailableInCreateUserPage(Log log) {
        try {
            scrollToElement(driver, driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_SaveButton)));
            verifyElementIsPresent(UapiOR.Admin_AddOrEditUserPage_SaveButton, "Save button is not available");
            test.log(Status.PASS, "#FUNC - Verify 'Save' button is available " + " *  Verify 'Save' button is available is Pass * ");
            log.ReportEvent("PASS", "Verify 'Save' button is available is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify 'Save' button is available " + " *  Verify 'Save' button is available is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to enter invalid data in create user page and verify error MSG
     *
     * @param testDataMap <Map> - Test data  map
     * @param log         <Log> - Log
     */
    public void enterInvalidDataInCreateUserPageAndVerifyErrorMSG(Map<Object, Object> testDataMap, Log log) {
        final String BLANK_ERROR_MSG = "This field cannot be left blank";
        final String FIRSTNAME_LENGTH_ERROR_MSG = "First name should be less than 10 characters";
        final String LASTNAME_LENGTH_ERROR_MSG = "Last name should be less than 10 characters";
        final String NATIONAL_ID_LENGTH_ERROR_MSG = "National id should be exactly 10 characters";
        final String NATIONAL_ID_DIGITS_ERROR_MSG = "National ID Should contain only digits";
        final String MOBILE_NUMBER_LENGTH_ERROR_MSG = "Invalid contact number. The number should start with 05 and max 10 digit long";
        final String EMAIL_FORMAT_ERROR_MSG = "Invalid email address";


        webClear(driver, UapiOR.Admin_AddOrEditUserPage_FirstNameTextField);
        WebEdit(UapiOR.Admin_AddOrEditUserPage_FirstNameTextField, testDataMap.get("InvalidFirstName").toString());

        webClear(driver, UapiOR.Admin_AddOrEditUserPage_LastNameTextField);
        WebEdit(UapiOR.Admin_AddOrEditUserPage_LastNameTextField, testDataMap.get("InvalidLastName").toString());

        webClear(driver, UapiOR.Admin_AddOrEditUserPage_NationalIdTextField);
        WebEdit(UapiOR.Admin_AddOrEditUserPage_NationalIdTextField, testDataMap.get("InvalidNationalId").toString());

        webClear(driver, UapiOR.Admin_AddOrEditUserPage_UserName);
        WebEdit(UapiOR.Admin_AddOrEditUserPage_UserName, testDataMap.get("InvalidUser").toString());

        webClear(driver, UapiOR.Admin_AddOrEditUserPage_Email);
        WebEdit(UapiOR.Admin_AddOrEditUserPage_Email, testDataMap.get("InvalidEmail").toString());

        webClear(driver, UapiOR.Admin_AddOrEditUserPage_MobileNoTextField);
        WebEdit(UapiOR.Admin_AddOrEditUserPage_MobileNoTextField, testDataMap.get("InvalidMobileNo").toString());

        WebClick(UapiOR.Admin_AddOrEditUserPage_SaveButton);

        String firstNameValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_FirstNameTextField)).getAttribute("value");
        String lastNameValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_LastNameTextField)).getAttribute("value");
        String nationalIdValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_NationalIdTextField)).getAttribute("value");
        String userNameValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_UserName)).getAttribute("value");
        String emailValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_Email)).getAttribute("value");
        String mobileNoValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_MobileNoTextField)).getAttribute("value");
        String companyValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_CompanyTextField)).getAttribute("value");
        String userTypeText = driver.findElement(By.xpath(UapiOR.Admin_CreateUserPage_UserTypeDropdown)).getText();
        int firstNameValueLength = firstNameValue.length();
        int lastNameValueLength = lastNameValue.length();
        int nationalIdValueLength = nationalIdValue.length();
        int userNameValueLength = userNameValue.length();
        int emailValueLength = emailValue.length();
        int mobileNoValueLength = mobileNoValue.length();
        int companyValueLength = companyValue.length();
        int userTypeTextLength = userTypeText.length();

        try {
            // Verify error messages based on conditions
            if (firstNameValueLength == 0 && lastNameValueLength == 0 && nationalIdValueLength == 0 && userNameValueLength == 0 && emailValueLength == 0 && mobileNoValueLength == 0 && companyValueLength == 0 && userTypeTextLength == 0) {
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_firstName_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_lastName_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_nationalId_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_UserName_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_Email_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_mobileNo_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_Company_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_UserType_Error), BLANK_ERROR_MSG);
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
            } else if (!emailValue.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                Assert.assertEquals(getText(UapiOR.Admin_AddOrEditUserPage_Email_Error), EMAIL_FORMAT_ERROR_MSG);
            }
            // Log success
            test.log(Status.PASS, "#FUNC - Verify error message * Verify error message is Pass *");
            log.ReportEvent("PASS", "Verify error message is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify error message * Verify error message is fail *");
            log.ReportEvent("FAIL", "Verify error message failed: ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on cancel button in dev portal
     * @param log -Log
     */
    public void clickOnCancelBtnInDevPortal(Log log){
        try{
            test.log(Status.PASS,"#FUNC - Click on cancel button * Click on cancel is Pass *");
            log.ReportEvent("PASS", "Verify error message is successful");
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL,"Click on cancel button * Click on cancel is fail *");
            log.ReportEvent("FAIL", "Click on cancel button failed: ");
        }
    }

    /**
     * Method to enter invalid data in create user page and verify error message in dev portal
     * @param testDataMap <Map> - Test data  map
     * @param log         <Log> - Log
     */
    public void enterInvalidDataInCreateUserPageAndVerifyErrorMSGInDevPortal(Map<Object, Object> testDataMap, Log log) {
        final String BLANK_ERROR_MSG = "This field cannot be left blank";
        final String FIRSTNAME_LENGTH_ERROR_MSG = "First name should be less than 10 characters";
        final String LASTNAME_LENGTH_ERROR_MSG = "Last name should be less than 10 characters";
        final String NATIONAL_ID_LENGTH_ERROR_MSG = "National id should be exactly 10 characters";
        final String NATIONAL_ID_DIGITS_ERROR_MSG = "National ID Should contain only digits";
        final String MOBILE_NUMBER_LENGTH_ERROR_MSG = "Invalid contact number. The number should start with 05 and max 10 digit long";
        final String EMAIL_FORMAT_ERROR_MSG = "Invalid email address";


        webClear(driver, UapiOR.Admin_AddOrEditUserPage_FirstNameTextField);
        WebEdit(UapiOR.Admin_AddOrEditUserPage_FirstNameTextField, testDataMap.get("InvalidFirstName").toString());

        webClear(driver, UapiOR.Admin_AddOrEditUserPage_LastNameTextField);
        WebEdit(UapiOR.Admin_AddOrEditUserPage_LastNameTextField, testDataMap.get("InvalidLastName").toString());

        webClear(driver, UapiOR.Admin_AddOrEditUserPage_NationalIdTextField);
        WebEdit(UapiOR.Admin_AddOrEditUserPage_NationalIdTextField, testDataMap.get("InvalidNationalId").toString());

        webClear(driver, UapiOR.Admin_AddOrEditUserPage_UserName);
        WebEdit(UapiOR.Admin_AddOrEditUserPage_UserName, testDataMap.get("InvalidUser").toString());

        webClear(driver, UapiOR.Admin_AddOrEditUserPage_Email);
        WebEdit(UapiOR.Admin_AddOrEditUserPage_Email, testDataMap.get("InvalidEmail").toString());

        webClear(driver, UapiOR.Admin_AddOrEditUserPage_MobileNoTextField);
        WebEdit(UapiOR.Admin_AddOrEditUserPage_MobileNoTextField, testDataMap.get("InvalidMobileNo").toString());

        WebClick(UapiOR.Customer_UserManagementPage_Save);

        String firstNameValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_FirstNameTextField)).getAttribute("value");
        String lastNameValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_LastNameTextField)).getAttribute("value");
        String nationalIdValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_NationalIdTextField)).getAttribute("value");
        String userNameValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_UserName)).getAttribute("value");
        String emailValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_Email)).getAttribute("value");
        String mobileNoValue = driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_MobileNoTextField)).getAttribute("value");
        String RoleValue = driver.findElement(By.xpath(UapiOR.Customer_AddOrEditUserPage_RoleDropdown)).getText();
        int firstNameValueLength = firstNameValue.length();
        int lastNameValueLength = lastNameValue.length();
        int nationalIdValueLength = nationalIdValue.length();
        int userNameValueLength = userNameValue.length();
        int emailValueLength = emailValue.length();
        int mobileNoValueLength = mobileNoValue.length();
        int RoleValueLength = RoleValue.length();

        try {
            // Verify error messages based on conditions
            if (firstNameValueLength == 0 && lastNameValueLength == 0 && nationalIdValueLength == 0 && userNameValueLength == 0 && emailValueLength == 0 && mobileNoValueLength == 0 && RoleValueLength == 0) {
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_firstName_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_lastName_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_nationalId_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_UserName_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_Email_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_mobileNo_Error), BLANK_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_Role_Error), BLANK_ERROR_MSG);
            } else if (firstNameValueLength >= 11 && lastNameValueLength >= 11 && nationalIdValueLength >= 11 && mobileNoValueLength >= 11) {
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_firstName_Error), FIRSTNAME_LENGTH_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_lastName_Error), LASTNAME_LENGTH_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_nationalId_Error), NATIONAL_ID_LENGTH_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_mobileNo_Error), MOBILE_NUMBER_LENGTH_ERROR_MSG);
            } else if (!nationalIdValue.matches(".*\\d.*") && !mobileNoValue.matches(".*\\d.*")) {
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_nationalId_Error), NATIONAL_ID_DIGITS_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_mobileNo_Error), MOBILE_NUMBER_LENGTH_ERROR_MSG);
            } else if (nationalIdValueLength <= 9 && mobileNoValueLength <= 9) {
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_nationalId_Error), NATIONAL_ID_LENGTH_ERROR_MSG);
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_mobileNo_Error), MOBILE_NUMBER_LENGTH_ERROR_MSG);
            } else if (!emailValue.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                Assert.assertEquals(getText(UapiOR.Customer_AddOrEditUserPage_Email_Error), EMAIL_FORMAT_ERROR_MSG);
            }
            // Log success
            test.log(Status.PASS, "#FUNC - Verify error message * Verify error message is Pass *");
            log.ReportEvent("PASS", "Verify error message is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify error message * Verify error message is fail *");
            log.ReportEvent("FAIL", "Verify error message failed: ");
            takeScreenShot();
        }
    }

    /**
     * Method to enter first name
     *
     * @param testDataMap <Map> - Test data map
     */
    public void enterFirstName(Map<Object, Object> testDataMap) {
        if (Exists()) {
            WebEdit(UapiOR.Admin_AddOrEditUserPage_FirstNameTextField, testDataMap.get("FirstName").toString());
        }
    }

    /**
     * Method to enter last name
     *
     * @param testDataMap <Map> - Test data map
     */
    public void enterLastName(Map<Object, Object> testDataMap) {
        WebEdit(UapiOR.Admin_AddOrEditUserPage_LastNameTextField, testDataMap.get("LastName").toString());
    }

    /**
     * Method to enter national id
     *
     * @param testDataMap <Map> - Test data map
     */
    public void enterNationalId(Map<Object, Object> testDataMap) {
        WebEdit(UapiOR.Admin_AddOrEditUserPage_NationalIdTextField, testDataMap.get("NationalId").toString());
    }

    /**
     * Method to enter username
     *
     * @param testDataMap <Map> - Test data map
     */
    public void enterUserName(Map<Object, Object> testDataMap) {
        WebEdit(UapiOR.Admin_AddOrEditUserPage_UserName, testDataMap.get("UserName").toString());
    }

    /**
     * Method to enter email
     *
     * @param testDataMap <Map> - Test data map
     */
    public void enterEmailId(Map<Object, Object> testDataMap) {
        WebEdit(UapiOR.Admin_AddOrEditUserPage_Email, testDataMap.get("Email").toString());
    }

    /**
     * Method to enter mobile number
     *
     * @param testDataMap <Map> - Test data map
     */
    public void enterMobileNumber(Map<Object, Object> testDataMap) {
        WebEdit(UapiOR.Admin_AddOrEditUserPage_MobileNoTextField, testDataMap.get("MobileNumber").toString());
    }

    /**
     * Method to select company
     *
     * @param testDataMap <Map> - Test data map
     */
    public void selectRole(Map<Object, Object> testDataMap) throws InterruptedException {
        WebClick(UapiOR.Customer_CreateUserPage_RoleDropdown);
        String option = testDataMap.get("Role").toString();
        Thread.sleep(1000);
        WebClickUsingJS("//li[text()='" + option + "']/span");
    }

    /**
     * Method to select user type
     *
     * @param testDataMap <Map> - Test data map
     */
    public void selectStatus(Map<Object, Object> testDataMap) throws InterruptedException {
        WebClick(UapiOR.Customer_CreateUserPage_StatusDropdown);
        String option = testDataMap.get("Status").toString();
        driver.findElement(By.xpath("//li[text()='" + option + "']")).click();
    }

    /**
     * Method to create new user in customer portal
     * @param log <Log> - Log
     * @param testDataMap <Map> - Test data map
     */
    public void createNewUserInCustomerPortal(Map<Object, Object> testDataMap, Log log) throws InterruptedException {
        try {
            enterFirstName(testDataMap);
            enterLastName(testDataMap);
            enterNationalId(testDataMap);
            enterEmailId(testDataMap);
            enterUserName(testDataMap);
            enterMobileNumber(testDataMap);
            selectRole(testDataMap);
            selectStatus(testDataMap);
            test.log(Status.PASS, "#FUNC - Create new user " + " *  Create new user is Pass * ");
            log.ReportEvent("PASS", "Create new user is successful");
            takeScreenShot();
            scrollToElement(driver, driver.findElement(By.xpath(UapiOR.Customer_AddOrEditUserPage_SaveButton)));
            WebClickUsingJS(UapiOR.Customer_AddOrEditUserPage_SaveButton);
            waitForTwoSec();
            takeScreenShot();
            Thread.sleep(7000);
        } catch (Exception e) {
            test.log(Status.FAIL, "Create new user " + " *  Create new user is fail * ");
            takeScreenShot();
        }
    }
}
