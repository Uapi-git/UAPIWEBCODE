/**
 * Test Script Name                      : ReportsPage.
 * Objective                             : Verify the user management Functionality.
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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.*;

public class UserManagementPage extends BasePage {

    public UserManagementPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    /**
     * Click on user management menu
     *
     * @param log<log> - Log
     */
    public void clickOnUserManagementMenu(Log log) {
        try {
            scrollToElement(driver, driver.findElement(By.xpath(UapiOR.Admin_UserManagementMenu)));
            WebClick(UapiOR.Admin_UserManagementMenu);
            waitForTwoSec();
            waitForTwoSec();
            VerifyValue1(getText(UapiOR.Admin_UserManagementPage), "User Management");
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
    public List<Map<String, Object>> userManagementGridDataInAscendingOrder = new ArrayList<>();
    public List<Map<String, Object>> userManagementGridDataInDescendingOrder = new ArrayList<>();

    /**
     * Method to parse user management grid data
     *
     * @param order <String> Pass the order according to your need Ascending, Descending and if you are parsing in normal then pass any string
     */
    public void parseUserManagementGridData(String order) throws InterruptedException {
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
                record.put("Company", consumptionDetailsGridDataElement.get(i + 3).getText());
                record.put("Email", consumptionDetailsGridDataElement.get(i + 4).getText());
                record.put("Mobile Number", consumptionDetailsGridDataElement.get(i + 5).getText());
                record.put("Status", consumptionDetailsGridDataElement.get(i + 6).getText());
                record.put("Role", consumptionDetailsGridDataElement.get(i + 7).getText());
                record.put("record", consumptionDetailsRecordsElement.get(i / 9));
                if (order.equalsIgnoreCase("Ascending")) {
                    userManagementGridDataInAscendingOrder.add(record);
                } else if (order.equalsIgnoreCase("Descending")) {
                    userManagementGridDataInDescendingOrder.add(record);
                } else {
                    userManagementGridData.add(record);
                }
                totalCount++; // Increment the total count
            }
            // Check if there's a next page
            if (!IsDispalyed(UapiOR.Admin_GoToNextPage)) {
                break; // Exit the loop if there's no next page
            }
            // Click the next page button
            WebClick(UapiOR.Admin_GoToNextPage);
        }
        if (order.equalsIgnoreCase("Ascending")) {
            System.out.println("Total records processed: " + totalCount);
            System.out.println("Package Management table: " + userManagementGridDataInAscendingOrder);
        } else if (order.equalsIgnoreCase("Descending")) {
            System.out.println("Total records processed: " + totalCount);
            System.out.println("Package Management table: " + userManagementGridDataInDescendingOrder);
        } else {
            System.out.println("Total records processed: " + totalCount);
            System.out.println("Package Management table: " + userManagementGridData);
        }

        int pageCount = Integer.parseInt(getText(UapiOR.Admin_PackageManagement_Pages).replaceFirst(".*of (\\d+).*", "$1"));
        int pages = pageCount / 10;
        if (1 <= pages) {
            for (int n = 1; n <= pages; n++) {
                WebClick(UapiOR.Admin_GoToPreviousPage);
                waitForTwoSec();
            }
        }

    }

    /**
     * Method to verify grid record data
     *
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
     * Method to verify grid record data
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
     *
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
     *
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
            waitForTwoSec();
            test.log(Status.PASS, "#FUNC - Verify retrieved data is cleared  " + " * Verify retrieved data is cleared is Pass * ");
            log.ReportEvent("PASS", "Verify retrieved data is cleared is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify retrieved data is cleared " + " * Verify retrieved data is cleared is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to verify user management grid data
     *
     * @param log <Log> - Log
     * @throws IOException
     */
    public void verifyUserManagementGridData(Log log) {
        try {
            verifyElementIsPresent(UapiOR.Admin_UserManagement_GridDataTable);
            test.log(Status.PASS, "#FUNC - Verify the data fields displays under User Management table   " + " * Verify the data fields displays under User Management table is Pass * ");
            log.ReportEvent("PASS", "Verify the data fields displays under User Management table is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify the data fields displays under User Management table " + driver.getTitle() + " * Verify the data fields displays under User Management table is fail * ");
        }
    }

    /**
     * Method to click on first record action button
     *
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
     * Method to click on first record action button
     *
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
     *
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
     * Method to verify Package Deleted Successful Msg
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
     *
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
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on Edit " + " *  Click on Edit is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to select rows per page
     *
     * @param rowsPerPage <int> - Row per page
     * @param log         <Log> - Log
     */
    public void selectRowsPerPage(int rowsPerPage, Log log) {
        try {
            WebClick(UapiOR.Admin_UserManagement_TableRowsPerPage);
            WebElement option = driver.findElement(By.xpath("//li[@role='option' and text()='" + rowsPerPage + "']"));
            WebClick(option);
            test.log(Status.PASS, "#FUNC -  Select 'Rows per Page' = " + rowsPerPage + " " + " *  Select 'Rows per Page' = " + rowsPerPage + " is Pass * ");
            log.ReportEvent("PASS", " Select 'Rows per Page' = " + rowsPerPage + " is successful");
            takeScreenShot();
            waitForTwoSec();
        } catch (Exception e) {
            test.log(Status.FAIL, " Select 'Rows per Page' = " + rowsPerPage + " " + " *  Select 'Rows per Page' = " + rowsPerPage + " is fail * ");
            takeScreenShot();
        }
    }


    /**
     * Method to click on next page icon in table
     *
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
     *
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
     * Method to get row count in per page
     *
     * @return Row count
     */
    public int getRowCountInPerPage() {
        int rowSize = driver.findElements(By.xpath("//div[@role='row']")).size();
        return rowSize - 1;
    }

    /**
     * Method to verify application retrieve data selected rows per page
     *
     * @param expectedRowCount <int> Expected row count
     * @param log              <Log> - Log
     */
    public void VerifyApplicationRetrievesDataSelectedRowsPerPage(int expectedRowCount, Log log) {
        try {
            Assert.assertEquals(getRowCountInPerPage(), expectedRowCount, "Row Counts are matching");
            test.log(Status.PASS, "#FUNC - Verify application retrieves the data " + " *  Verify application retrieves the data is Pass * ");
            log.ReportEvent("PASS", " Verify application retrieves the data is successful");
            takeScreenShot();
            waitForTwoSec();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify application retrieves the data " + " *  Verify application retrieves the data is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on create user
     *
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
     * Method to click on filter operator dropdown button
     *
     * @throws InterruptedException
     */
    public void clickOnFilterOperatorDropdownButton() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath(UapiOR.Admin_UserManagement_OperatorDropdown));
        actions.moveToElement(ele).perform();
        WebClickUsingActions(UapiOR.Admin_UserManagement_OperatorDropdown);
        waitForTwoSec();
        takeScreenShot();
    }

    /**
     * Method to validate First Record Data As Same As Admin User Info
     *
     * @param testDataMap <Map> - Test data map
     * @param log         <Log> - Log
     */
    public void validateFirstRecordDataAsSameAsAdminUserInfo(Map<Object, Object> testDataMap, Log log) {
        try {
            Assert.assertEquals(getText(UapiOR.Admin_UserManagementPage_FirstRecordFirstName), testDataMap.get("FirstName").toString());
            Assert.assertEquals(getText(UapiOR.Admin_UserManagementPage_FirstRecordLastName), testDataMap.get("LastName").toString());
            Assert.assertEquals(getText(UapiOR.Admin_UserManagementPage_FirstRecordCompany), testDataMap.get("CompanyName").toString());
            Assert.assertEquals(getText(UapiOR.Admin_UserManagementPage_FirstRecordEmail), testDataMap.get("AdminInfoEmail").toString());
            Assert.assertEquals(getText(UapiOR.Admin_UserManagementPage_FirstRecordMobileNo), testDataMap.get("MobileNumber").toString());
            test.log(Status.PASS, "#FUNC - Verify admin user information from Account management screen is showing under User Management screen " + " * Verify admin user information from Account management screen is showing under User Management screen is Pass * ");
            log.ReportEvent("PASS", "Verify admin user information from Account management screen is showing under User Management screen is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify admin user information from Account management screen is showing under User Management screen  " + " * Verify admin user information from Account management screen is showing under User Management screen is fail * ");
        }
    }

}
