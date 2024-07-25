/**
 * Test Script Name                      : AccountManagementPage.
 * Objective                             : Verify the Account Management Functionality.
 * Version                               : 1.0
 * Author                                : Arun Kumar MS
 * Created Date                          : 06/06/2024
 * Last Updated on                       : N/A
 * Updated By                            :
 * Epic Details                          : N/A
 * User Story Details                    : N/A
 * Defects affecting this test script    : None
 * Work Around/Known Issues              : None
 **/
package com.azmqalabs.uapitestautomation.apppages.allapplicationpages;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountManagementPage extends BasePage {

    public AccountManagementPage(WebDriver driver, com.aventstack.extentreports.ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Admin_AccountManagement_Page)
    public WebElement accountManagementPage;

    public boolean Exists() {
        return super.Exists(accountManagementPage);
    }

    /**
     * Method verify account management screen display
     *
     * @param testdatamap <Map> - Test data map
     * @param log         <Log> -Log
     * @throws IOException
     */
    public void verifyAccountManagementScreenDisplayed(Map<Object, Object> testdatamap, Log log) throws IOException {
        try {
            this.Exists();
            VerifyValue1(getText(UapiOR.Admin_AccountManagement_Page), testdatamap.get("AccountManagementText").toString());
            this.takeScreenShot();
            test.log(Status.PASS, "Verify Account Management screen " + driver.getTitle() + " * Account Management screen is Pass * ");
            log.ReportEvent("PASS", "Verify Account Management screen displayed");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Verify Account Management screen " + driver.getTitle() + " *Verify Account Management screen is Fail * ");
            this.takeScreenShot();
        }

    }

    // Method to click on clear button in Account Management Search Test Field
    public void clickOnClearButton() {
        WebClick(UapiOR.Admin_AccountManagement_Page_Search_TestField_ClearButton);
    }

    // Method to verify search text field is Cleared in Account Management Screen
    public void verifySearchTextFieldIsCleared(Map<Object, Object> testdatamap, Log log) {
        try {
            WebEdit(UapiOR.Admin_AccountManagement_Page_SearchTextbox, testdatamap.get("CompanyName").toString());
            Thread.sleep(500);
            VerifyValue1(getAttributeValue(UapiOR.Admin_AccountManagement_Page_SearchTextbox, "value"), testdatamap.get("CompanyName").toString());
            Thread.sleep(500);
            clickOnClearButton();
            VerifyValue1(getAttributeValue(UapiOR.Admin_AccountManagement_Page_SearchTextbox, "value"), "");
            log.ReportEvent("PASS", "verify search text field is Cleared in Account Management Screen is successful");
            this.takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "verify search text field is Cleared in Account Management Screen" + driver.getTitle() + " *verify search text field is Cleared Fail * ");
            this.takeScreenShot();
        }
    }

    // Method to click on action Icon
    public void clickOnActionIcon() {
        WebClick(UapiOR.Admin_AccountManagement_Page_ActionIcon);
    }


    // Method to verify grid data is displayed
    public void verifyGridData(Log Log) throws Exception {
        try {
            Thread.sleep(2000);
            verifyElementIsPresent(UapiOR.Admin_AccountManagement_Page_GridData, "Account Management Grid Data");
            Log.ReportEvent("PASS", " verify Grid data In Account Management is Successful");
            Thread.sleep(2000);
        } catch (Exception e) {
            Log.ReportEvent("FAIL", " verify Grid data In Account Management is UnSuccessful");
        }
    }

    // Method to click on pegination
    public void clickOnPegination() throws InterruptedException {
        Thread.sleep(2000);
        WebClick(UapiOR.Admin_AccountManagement_Page_RowPerPage);
    }

    // Method to click on pegination
    public void selectPeginationValueFive(Log Log) {
        WebClick(UapiOR.Admin_AccountManagement_Page_FiveRowPerPage);
        Log.ReportEvent("PASS", " Select 'Rows per Page' = 5 In Account Management is Successful");
        this.takeScreenShot();

    }

    // Method to verify Selected row per page data
    public void verifySelectedRowPerPageData(Log Log) throws InterruptedException {
        try {
            List<WebElement> rowsPerPage = driver.findElements(By.xpath("//div[@role='row' and contains(@class,'MuiDataGrid-row')]"));
            int SecondPageRowCount = 0;
            if (CheckElementExists(UapiOR.Admin_AccountManagement_Page_NextPage_Disabled) == false) {
                Thread.sleep(2000);
                WebClick(UapiOR.Admin_AccountManagement_Page_NextPage);
                rowsPerPage = driver.findElements(By.xpath("//div[@role='row' and contains(@class,'MuiDataGrid-row')]"));
                SecondPageRowCount = rowsPerPage.size();
                this.takeScreenShot();
            }
            Thread.sleep(1000);
            WebClick(UapiOR.Admin_AccountManagement_Page_GoToPreviousPage);
            int firstPageRowCount = rowsPerPage.size();
            Assert.assertEquals(SecondPageRowCount, firstPageRowCount);
            Log.ReportEvent("PASS", " verify rows per page count retrieve correctly In Account Management is Successful");
            this.takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "verify rows per page count retrieve correctly In Account Management" + driver.getTitle() + " * verify rows per page count retrieve correctly FAIL * ");
            this.takeScreenShot();
        }
    }
    // Method to Search with Company Name
    public void searchCompanyName(Map<Object, Object> testdatamap) {
        WebEdit(UapiOR.Admin_AccountManagement_Page_SearchTextbox, testdatamap.get("CompanyName").toString());
        WebClick(UapiOR.Admin_AccountManagement_Page_SearchBtn);
    }

    // Method to click on Edit button
    public void clickOnEditButton(Log Log) {
        WebClick(UapiOR.Admin_AccountManagement_Page_EditButton);
        Log.ReportEvent("PASS", " Click on 'Edit' option from 'Action' data field In Account Management is Successful");
    }

    // Method to click on Delete button
    public void clickOnDeleteButton(Log Log) {
        WebClick(UapiOR.Admin_AccountManagement_Page_DeleteButton);
        Log.ReportEvent("PASS", " Click on 'Delete' option from 'Action' data filed In Account Management is Successful");
        this.takeScreenShot();
    }

    // Method to click on Delete yes on Pop up.
    public void clickOnDeleteYes() {
        WebClickUsingJS(UapiOR.Admin_AccountManagement_Page_DeleteYes);
    }

    // Method to verify account deleted successful Toast message
    public void verifyAccountDeletedToastMessage(Map<Object, Object> testdatamap, Log Log) throws Exception {
        clickOnDeleteYes();
        VerifyValue1(getText(UapiOR.Admin_AccountManagement_Page_SuccessfulToastMessage), testdatamap.get("Success Toast").toString());
        Thread.sleep(1000);
        Log.ReportEvent("PASS", "User Account deleted Successfully in account Management page");
        this.takeScreenShot();
    }

    // Method to click on Create Account
    public void clickOnCreateAccount(Log Log) throws InterruptedException {
        WebClickUsingJS(UapiOR.Admin_AccountManagement_Page_CreateAccountButton);
        Thread.sleep(1000);
        Log.ReportEvent("PASS", " Click on 'Create Account' button In Account Management is Successful");
        this.takeScreenShot();
    }

    //Method to verify Search Functionality in Account Management Screen
    public void verifySearchFunctionality(Map<Object, Object> testdatamap, Log Log) throws IOException, InterruptedException {
        Thread.sleep(2000);
        parseAccountManagementGridData();
        VerifyValue1(accountManagementGridData.get(0).get("Name").toString(), testdatamap.get("Company Name").toString());
        Log.ReportEvent("PASS", " Verify results is displays based on search keyword In Account Management is Successful");
        this.takeScreenShot();

    }

    /**
     * Used to store account management grid data
     */
    public List<Map<String, Object>> accountManagementGridData = new ArrayList<>();

    /**
     * Method to parse account Management grid data
     */
    public void parseAccountManagementGridData() {
        int totalCount = 0; // Total count of records processed across all pages
        // Process each page
        List<WebElement> AccountManagementGridRecordsElement = driver.findElements(By.xpath("//div[@role='row']"));
        List<WebElement> AccountManagementGridDataElement = driver.findElements(By.xpath("//div[@role='gridcell']"));
        // Process each row on the current page
        for (int i = 0; i < AccountManagementGridDataElement.size(); i += 7) {
            Map<String, Object> record = new HashMap<>(); // Create a new map for each row
            // Populate record with data for the current row
            record.put("Account Code", AccountManagementGridDataElement.get(i).getText());
            record.put("Name", AccountManagementGridDataElement.get(i + 1).getText());
            record.put("Website Url", AccountManagementGridDataElement.get(i + 2).getText());
            record.put("Email", AccountManagementGridDataElement.get(i + 3).getText());
            record.put("Postpaid Subscribed", AccountManagementGridDataElement.get(i + 4).getText());
            record.put("Status", AccountManagementGridDataElement.get(i + 5).getText());
            record.put("record", AccountManagementGridRecordsElement.get(i / 7));
            accountManagementGridData.add(record);
            totalCount++;
        }
    }

}





