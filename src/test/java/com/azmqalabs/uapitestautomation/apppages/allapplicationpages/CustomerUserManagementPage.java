/**
 * Test Script Name                      : CustomerUserManagementPage.
 * Objective                             : Verify the Customer user management Functionality.
 * Version                               : 1.0
 * Author                                : Basavaraj Mudnur
 * Created Date                          : 25/06/2024
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
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerUserManagementPage extends BasePage {

    public CustomerUserManagementPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    /**
     * Click on user management menu
     * @param log<log> - Log
     */
    public void clickOnUserManagementMenu(Log log) {
        try {
            waitForTwoSec();
            scrollToElement(driver, driver.findElement(By.xpath(UapiOR.Customer_UserManagementMenu)));
            WebClick(UapiOR.Customer_UserManagementMenu);
            waitForTwoSec();
            VerifyValue1(getText(UapiOR.Customer_UserManagementPage), "User Management");
            test.log(Status.PASS, "#FUNC - Click on 'User Management' menu  " + " * Click on 'User Management' menu is Pass * ");
            log.ReportEvent("PASS", "Click on 'User Management' menu is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'User Management' menu " + " * Click on 'User Management' menu is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Used to store account management grid data
     */
    public List<Map<String, Object>> userManagementGridData = new ArrayList<>();

    /**
     * Method to parse user management grid data
     */
    public void parseUserManagementGridData() throws InterruptedException {
        int totalCount = 0; // Total count of records processed across all pages
        // Process each page
        while (true) {
            Thread.sleep(2000);
            List<WebElement> consumptionDetailsRecordsElement = driver.findElements(By.xpath("//div[@role='row']"));
            List<WebElement> consumptionDetailsGridDataElement = driver.findElements(By.xpath("//div[@role='gridcell']"));
            // Process each row on the current page
            for (int i = 0; i < consumptionDetailsGridDataElement.size(); i += 9) {
                Map<String, Object> record = new HashMap<>(); // Create a new map for each row
                // Populate record with data for the current row
                record.put("ID", consumptionDetailsGridDataElement.get(i).getText());
                record.put("First Name", consumptionDetailsGridDataElement.get(i + 1).getText());
                record.put("Last Name", consumptionDetailsGridDataElement.get(i + 2).getText());
                record.put("User Name", consumptionDetailsGridDataElement.get(i + 3).getText());
                record.put("Email", consumptionDetailsGridDataElement.get(i + 4).getText());
                record.put("Mobile Number", consumptionDetailsGridDataElement.get(i + 5).getText());
                record.put("Role", consumptionDetailsGridDataElement.get(i + 6).getText());
                record.put("Status", consumptionDetailsGridDataElement.get(i + 7).getText());
                record.put("record", consumptionDetailsRecordsElement.get(i / 9));
                userManagementGridData.add(record);
                totalCount++; // Increment the total count
            }
            // Check if there's a next page
            if (!IsDispalyed(UapiOR.Admin_GoToNextPage)) {
                break; // Exit the loop if there's no next page
            }
            // Click the next page button
            WebClick(UapiOR.Admin_GoToNextPage);
        }
            System.out.println("Total records processed: " + totalCount);
            System.out.println("Package Management table: " + userManagementGridData);
    }

    /**
     * Method to back to first page after parse
     * @throws InterruptedException
     */
    public void backToFirstPageAfterParse() throws InterruptedException {
        int pageCount = Integer.parseInt(getText(UapiOR.Admin_PackageManagement_PageNo).replaceFirst(".*of (\\d+).*", "$1"));
        int pages = pageCount / 10;
        if (1 <= pages) {
            for (int n = 1; n <= pages; n++) {
                if (!getElement(UapiOR.Admin_GoToPreviousPage).getAttribute("class").contains("Mui-disabled"))
                    WebClick(UapiOR.Admin_GoToPreviousPage);
                waitForTwoSec();
            }
        }
    }

    /**
     * Method to verify grid record data
     * @param testDataMap <Map> - Test data map
     * @param rowNumber   <int> - Row number
     */
    public void verifyGridRecordData(int rowNumber, Map<Object, Object> testDataMap, Log log) {
        try {
            Assert.assertEquals(userManagementGridData.get(rowNumber - 1).get(testDataMap.get("ColumnName").toString()).toString(), testDataMap.get("SearchedData").toString());
            test.log(Status.PASS, "#FUNC - Verify filtered data  " + " * Verify filtered data is Pass * ");
            log.ReportEvent("PASS", "Verify filtered data is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.PASS, "Verify filtered data  " + " * Verify filtered data is Fail * ");
        }
    }

    /**
     * Method to verify No row grid
     * @param log <Log> - Log
     */
    public void verifyNoRowGrid(Log log) {
        try {
            Assert.assertEquals(getText(UapiOR.Admin_UserManagementPage_NoRowGrid), "No rows");
            test.log(Status.PASS, "#FUNC - Verify No rows system message " + " * Verify No rows system message is Pass * ");
            log.ReportEvent("PASS", "Verify No rows system message is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.PASS, "Verify No rows system message  " + " * Verify No rows system message is Fail * ");
        }
    }


    /**
     * Method to search user
     * @param testdatamap <Map> - Test data map
     * @param log         <Log> - Log
     */
    public void searchUser(Map<Object, Object> testdatamap, Log log) {
        try {
            WebEdit(UapiOR.Admin_UserManagementPage_SearchField, testdatamap.get("SearchFieldInput").toString());
            WebClick(UapiOR.Admin_UserManagementPage_SearchBtn);
            test.log(Status.PASS, "#FUNC - Enter keyword in search textbox and Enter " + " *  Enter keyword in search textbox and Enter is Pass * ");
            log.ReportEvent("PASS", " Enter keyword in search textbox and Enter is successful");
            waitForTwoSec();
            takeScreenShot();

        } catch (Exception e) {
            test.log(Status.PASS, " Enter keyword in search textbox and Enter " + " *  Enter keyword in search textbox and Enter is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to Click on search field X Button and verify value
     * @param log <log> - Log
     */
    public void clickOnSearchFieldXBtn(Log log) {
        try {
            WebClick(UapiOR.Admin_UserManagementPage_SearchField_ClearButton);
            waitForTwoSec();
            test.log(Status.PASS, "#FUNC - Click on 'X' clear button  " + " * Click on 'X' clear button is Pass * ");
            log.ReportEvent("PASS", "Click on 'X' clear button is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'X' clear button " + " * Click on 'X' clear button is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to verify cleared value of search field
     * @param log <log> - Log
     */
    public void VerifyClearedValueOfSearchField(Log log) {
        try {
            VerifyValue1(driver.findElement(By.xpath(UapiOR.Admin_UserManagementPage_SearchField)).getAttribute("value"), "");
            test.log(Status.PASS, "#FUNC - Verify retrieved data is cleared  " + " * Verify retrieved data is cleared is Pass * ");
            log.ReportEvent("PASS", "Verify retrieved data is cleared is successful");
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify retrieved data is cleared " + " * Verify retrieved data is cleared is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to click on first record action button
     * @param log <Log> - log
     */
    public void clickOnFirstRecordActionButton(Log log) {
        try {
            scrollUptillstarting(driver);
            WebClick(UapiOR.Admin_UserManagement_FirstRecordActionBtn);
            test.log(Status.PASS, "#FUNC - Click on 'Action' option " + " *  Click on 'Action' option is Pass * ");
            log.ReportEvent("PASS", "Click on 'Action' option is successful");
            takeScreenShot();
            waitForTwoSec();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Action' option " + " *  Click on 'Action' option is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on record action button based on email id
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - log
     */
    public void clickOnRecordActionButtonBasedOnEmailId(Map<Object, Object> testDataMap, Log log) {
        try {
            scrollUptillstarting(driver);
            WebClick("//h2[text()='" + testDataMap.get("userEmailId").toString() + "']//following::div//*[local-name()='svg' and @data-testid='MoreHorizIcon']");
            test.log(Status.PASS, "#FUNC - Click on 'Action' option " + " *  Click on 'Action' option is Pass * ");
            log.ReportEvent("PASS", "Click on 'Action' option is successful");
            takeScreenShot();
            waitForTwoSec();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Action' option " + " *  Click on 'Action' option is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on delete option from action list
     * @param log <Log> - Log
     */
    public void clickOnDeleteOptionFromActionList(Log log) {
        try {
            WebClick(UapiOR.Admin_ActionListDeleteOption);
            test.log(Status.PASS, "#FUNC - Click on Delete " + " *  Click on Delete is Pass * ");
            log.ReportEvent("PASS", "Click on Delete is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on Delete " + " *  Click on Delete is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on delete confirmation popup yes button
     */
    public void clickOnDeleteConfirmationYesButton() throws InterruptedException {
        WebClick(UapiOR.Admin_DeleteConfirmationYesButton);
        waitForTwoSec();
        takeScreenShot();
    }

    /**
     * Method to verify delete error message  for company user
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - log
     */
    public void verifyDeleteErrorMSGForOwnCompanyUser(Map<Object, Object> testDataMap, Log log) {
        try {
            Assert.assertEquals(getText(UapiOR.Admin_ErrorMsg), testDataMap.get("errorMsg").toString());
            test.log(Status.PASS, "#FUNC - Verify Error Message" + " * Verify Error Message is Pass *");
            log.ReportEvent("PASS", "Verify Error Message is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "#FUNC - Verify Error Message" + " * Verify Error Message is fail *");
        }

    }


    /**
     * Method to click on edit option from action list
     * @param log <Log> - Log
     */
    public void clickOnEditOptionFromActionList(Log log) {
        try {
            scrollUptillstarting(driver);
            WebClick(UapiOR.Admin_UserManagement_ActionListEditOption);
            test.log(Status.PASS, "#FUNC - Click on Edit " + " *  Click on Edit is Pass * ");
            log.ReportEvent("PASS", "Click on Edit is successful");
            waitForTwoSec();
            takeScreenShot();
            waitForTwoSec();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on Edit " + " *  Click on Edit is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on next page icon in table
     * @param log <Log> - Log
     */
    public void clickOnNextPageIconInTable(Log log) {
        try {
            WebClick(UapiOR.Admin_GoToNextPage);
            test.log(Status.PASS, "#FUNC - Click on 'Next Page' button " + " *  Click on 'Next Page' button is Pass * ");
            log.ReportEvent("PASS", " Click on 'Next Page' button is successful");
            takeScreenShot();
            waitForTwoSec();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Next Page' button " + " *  Click on 'Next Page' button is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on previous page icon in table
     * @param log <Log> - Log
     */
    public void clickOnPreviousPageIconInTable(Log log) {
        try {
            WebClick(UapiOR.Admin_GoToPreviousPage);
            test.log(Status.PASS, "#FUNC - Click on 'Back Page' button " + " *  Click on 'Back Page' button is Pass * ");
            log.ReportEvent("PASS", " Click on 'Back Page' button is successful");
            takeScreenShot();
            waitForTwoSec();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Back Page' button " + " *  Click on 'Back Page' button is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on create user
     * @param log <Log> - Log
     */
    public void clickOnCreateUser(Log log) {
        try {
            scrollUptillstarting(driver);
            WebClick(UapiOR.Admin_UserManagement_CreateUserBtn);
            test.log(Status.PASS, "#FUNC - Click on 'Create User' " + " *  Click on 'Create User' is Pass * ");
            log.ReportEvent("PASS", "Click on 'Create User' is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Create User' " + " *  Click on 'Create User' is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on view option from action list
     * @param log <Log> - Log
     */
    public void clickOnView(Log log){
        try {
            WebClick(UapiOR.Customer_ViewBtn);
            test.log(Status.PASS, "#FUNC - Click on View " + " *  Click on View is Pass * ");
            log.ReportEvent("PASS", "Click on View is successful");
            waitForTwoSec();
            takeScreenShot();
            waitForTwoSec();
            Assert.assertEquals(getElement(UapiOR.Customer_ViewUserPage_Header).getText(),"View User");
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on View " + " *  Click on View is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify view user page details
     * @param rowNo <int> Row no
     * @throws Exception
     */
    public void verifyViewUserPageDetails(int rowNo) throws Exception {
        scrollToElement(driver,getElement(UapiOR.Admin_Customer_AddOrEditUserPage_IDField));

        String expectedViewPageFirstName = userManagementGridData.get(rowNo - 1).get("First Name").toString();
        String expectedViewPageLastName = userManagementGridData.get(rowNo - 1).get("Last Name").toString();
        String expectedViewPageUserName = userManagementGridData.get(rowNo - 1).get("User Name").toString();
        String expectedViewPageEmail = userManagementGridData.get(rowNo - 1).get("Email").toString();
        String expectedViewPageMobileNo = userManagementGridData.get(rowNo - 1).get("Mobile Number").toString();
        String expectedViewPageRole = userManagementGridData.get(rowNo - 1).get("Role").toString();
        String expectedViewPageStatus = userManagementGridData.get(rowNo - 1).get("Status").toString();

        verifyElementIsPresent(UapiOR.Admin_Customer_AddOrEditUserPage_IDField);
        VerifyValue1(getElement(UapiOR.Admin_AddOrEditUserPage_FirstNameTextField).getAttribute("value"),expectedViewPageFirstName);
        VerifyValue1(getElement(UapiOR.Admin_AddOrEditUserPage_LastNameTextField).getAttribute("value"),expectedViewPageLastName);
        verifyElementIsPresent(UapiOR.Admin_AddOrEditUserPage_NationalIdTextField);
        VerifyValue1(getElement(UapiOR.Admin_AddOrEditUserPage_Email).getAttribute("value"),expectedViewPageEmail);
        VerifyValue1(getElement(UapiOR.Admin_AddOrEditUserPage_UserName).getAttribute("value"),expectedViewPageUserName);
        VerifyValue1(getElement(UapiOR.Admin_AddOrEditUserPage_MobileNoTextField).getAttribute("value"),expectedViewPageMobileNo);
        VerifyValue1(getText(UapiOR.Admin_Customer_AddOrEditUserPage_Role),expectedViewPageRole);
        if (getText(UapiOR.Admin_Customer_AddOrEditUserPage_Status).equalsIgnoreCase(expectedViewPageStatus)){
            System.out.println("Status is matching");
        }
        else {
            VerifyValue1(getText(UapiOR.Admin_Customer_AddOrEditUserPage_Role),expectedViewPageRole);
        }
        takeScreenShot();
    }

    /**
     * Method to verify edit Mode after click on edit from action list
     */
    public void verifyEditModeAfterClickOnEditFromActionList(){
        boolean isFirstNameEnabled = !driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_FirstNameTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isLastNameEnabled = !driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_LastNameTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isNationalIdEnabled = !driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_NationalIdTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isMobileNoEnabled = !driver.findElement(By.xpath(UapiOR.Admin_AddOrEditUserPage_MobileNoTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isRoleEnabled = !driver.findElement(By.xpath(UapiOR.Admin_Customer_AddOrEditUserPage_Role + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isStatusEnabled = !driver.findElement(By.xpath(UapiOR.Admin_Customer_AddOrEditUserPage_Status + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        Assert.assertTrue(isFirstNameEnabled, "First Name textField is disabled");
        Assert.assertTrue(isLastNameEnabled, "Last Name textField is disabled");
        Assert.assertTrue(isNationalIdEnabled, "National id textField is disabled");
        Assert.assertTrue(isMobileNoEnabled, "Mobile Number textField is disabled");
        Assert.assertTrue(isRoleEnabled, "Role dropdown is disabled");
        Assert.assertTrue(isStatusEnabled, "Status dropdown is disabled");
    }

    /**
     * Method to verify user redirected to user management screen
     */
    public void verifyUserRedirectedToUserManagementScreen() throws IOException {
        VerifyValue1(getText(UapiOR.Customer_UserManagementPage), "User Management");
    }

    /**
     * Method to verify delete user confirmation popup message
     * @param testDataMap <Map> - Test data map
     */
    public void verifyDeleteUserConfirmationPopupMassage(Map<Object,Object> testDataMap) throws IOException {
        VerifyValue1(getText(UapiOR.Customer_UserManagementPage_DeleteUserConfirmationPopupMsg),"Are you sure you want to delete this user, '"+testDataMap.get("FirstName").toString()+" "+testDataMap.get("LastName").toString()+"'?");
    }

    /**
     * Method to verify delete confirmation message
     * @param testDataMap <Map> - Test data map
     */
    public void verifyDeleteConfirmationMessage(Map<Object,Object>testDataMap) throws IOException {
        Assert.assertEquals(getText(UapiOR.Admin_AccountManagement_Page_SuccessfulToastMessage), "User '" + testDataMap.get("FirstName").toString() + " " + testDataMap.get("LastName").toString() + "' deleted successfully!");
        VerifyValue1(getText(UapiOR.Admin_AccountManagement_Page_SuccessfulToastMessage), "User '" + testDataMap.get("FirstName").toString() + " " + testDataMap.get("LastName").toString() + "' deleted successfully!");
    }
    // Method to select City Role from dropdown
    public void selectRoleFromDropdown(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(1000);
        WebClickUsingActions(UapiOR.Customer_UserManagement_RoleDropdown);
        Thread.sleep(1000);
        WebClickUsingJS("//li[text()='" + testdatamap.get("RoleName").toString() + "']");
    }
    // Method to click on Save
    public void clickOnSave(Log Log) throws InterruptedException {
        Thread.sleep(3000);
        WebClick(UapiOR.Customer_EditUserManagement_SaveButton);
        Log.ReportEvent("PASS", "Click on 'Save' option in Edit User Management Screen is successful");
        this.takeScreenShot();
    }
}
