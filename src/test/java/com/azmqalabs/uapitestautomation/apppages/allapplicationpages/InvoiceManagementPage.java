/**
 * Test Script Name                      : InvoiceManagementPage.
 * Objective                             : Verify Invoice Management Functionality.
 * Version                               : 1.0
 * Author                                : Arun Kumar M S
 * Created Date                          : 19/06/2024
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvoiceManagementPage extends BasePage {

    public InvoiceManagementPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Admin_InvoiceManagement_Page)
    public WebElement invoiceManagementText;

    public boolean Exists() {
        return super.Exists(invoiceManagementText);
    }

    // Method to validate invoice management Page
    public void verifyInvoiceManagementPageIsDisplayed(Log Log) {
        try {
            Thread.sleep(1000);
            verifyElementIsPresent(UapiOR.Admin_InvoiceManagement_Button);
            this.takeScreenShot();
            test.log(Status.PASS, "Verify invoice management page" + driver.getTitle() + "Verify invoice management page is Pass");
            Log.ReportEvent("PASS", "User Navigated to invoice Management page");
            this.takeScreenShot();

        } catch (Exception e) {
            this.takeScreenShot();
            test.log(Status.FAIL, "Verify invoice management page" + driver.getTitle() + "Verify invoice management page is Fail");


        }
    }

    //Method to click on Invoice Management button
    public void clickOnInvoiceManagementButton(Log Log) throws InterruptedException {
        WebClick(UapiOR.Admin_InvoiceManagement_Button);
        Thread.sleep(1000);
        Log.ReportEvent("PASS", " Click on 'Invoice Management' menu is Successful");
    }

    // Method to click on clear button in Invoice Management Search Test Field
    public void clickOnClearButton() {
        WebClick(UapiOR.Admin_InvoiceManagement_Page_Search_TestField_ClearButton);
    }

    // Method to verify search text field is Cleared in Account Management Search Test Field
    public void verifySearchTextFieldIsCleared(Map<Object, Object> testdatamap, Log log) {
        try {
            enterAccountName(testdatamap);
            Thread.sleep(500);
            VerifyValue1(getAttributeValue(UapiOR.Admin_InvoiceManagement_Page_SearchTextField, "value"), testdatamap.get("Account Name").toString());
            this.takeScreenShot();
            Thread.sleep(500);
            clickOnClearButton();
            VerifyValue1(getAttributeValue(UapiOR.Admin_InvoiceManagement_Page_SearchTextField, "value"), "");
            test.log(Status.PASS, "verify search text field is Cleared in Invoice Management Screen" + driver.getTitle() + " *verify search text field is Cleared Pass * ");
            log.ReportEvent("PASS", "verify search text field is Cleared in Invoice Management Screen is successful");
            this.takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "verify search text field is Cleared in Invoice Management Screen" + driver.getTitle() + " *verify search text field is Cleared Fail * ");
            this.takeScreenShot();
        }
    }

    //Method to enter Account Name
    public void enterAccountName(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(2000);
        WebEdit(UapiOR.Admin_InvoiceManagement_Page_SearchTextField, testdatamap.get("Account Name").toString());
    }

    // Method to verify grid data is displayed
    public void verifyGridData(Log Log) throws Exception {
        try {
            Thread.sleep(2000);
            verifyElementIsPresent(UapiOR.Admin_InvoiceManagement_Page_GridData, "Invoice Management Grid Data");
            Log.ReportEvent("PASS", " verify Grid data In Invoice Management Screen is Successful");
            Thread.sleep(2000);
        } catch (Exception e) {
            Log.ReportEvent("FAIL", " verify Grid data In Invoice Management Screen is UnSuccessful");
        }
    }

    // Method to click on pegination
    public void clickOnPegination() {
        WebClick(UapiOR.Admin_InvoiceManagement_Page_RowPerPage);
    }

    // Method to click on pegination
    public void selectPeginationValueFive(Log Log) {
        WebClick(UapiOR.Admin_InvoiceManagement_Page_FiveRowPerPage);
        Log.ReportEvent("PASS", " Select 'Rows per Page' = 5 In Invoice Management is Successful");
        this.takeScreenShot();

    }

    // Method to verify Selected row per page data
    public void verifySelectedRowPerPageData(Log Log) throws InterruptedException {
        try {
            List<WebElement> rowsPerPage = driver.findElements(By.xpath("//div[@role='row' and contains(@class,'MuiDataGrid-row')]"));
            int SecondPageRowCount = 0;
            if (CheckElementExists(UapiOR.Admin_InvoiceManagement_Page_NextPage_Disabled) == false) {
                Thread.sleep(2000);
                WebClick(UapiOR.Admin_InvoiceManagement_GoToNextPage);
                rowsPerPage = driver.findElements(By.xpath("//div[@role='row' and contains(@class,'MuiDataGrid-row')]"));
                SecondPageRowCount = rowsPerPage.size();
                this.takeScreenShot();
            }
            Thread.sleep(1000);
            WebClick(UapiOR.Admin_InvoiceManagement_GoToPreviousPage);
            int firstPageRowCount = rowsPerPage.size();
            Assert.assertEquals(SecondPageRowCount, firstPageRowCount);
            test.log(Status.PASS, "verify rows per page count retrieve correctly In Invoice Management" + driver.getTitle() + " * verify rows per page count retrieve correctly PASS * ");
            Log.ReportEvent("PASS", " verify rows per page count retrieve correctly In Invoice Management is Successful");
            this.takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "verify rows per page count retrieve correctly In Invoice Management" + driver.getTitle() + " * verify rows per page count retrieve correctly FAIL * ");
            this.takeScreenShot();
        }
    }

    // Method to click on Export to Excel
    public void clickOnExportToExcel(Log Log) throws InterruptedException {
        WebClick(UapiOR.Admin_InvoiceManagement_Page_ExportExcel);
        Log.ReportEvent("PASS", " Click on 'Export excel' button In Invoice Management Screen is Successful");
        this.takeScreenShot();
        Thread.sleep(2000);
    }

    // Method to click on Export to Pdf
    public void clickOnExportToPdf(Log Log) throws InterruptedException {
        WebClick(UapiOR.Admin_InvoiceManagement_Page_ExportPdf);
        this.takeScreenShot();
        Log.ReportEvent("PASS", " Click on 'Export PDF' button In Invoice Management Screen is Successful");
        this.takeScreenShot();
        Thread.sleep(4000);

    }

    //Used to store Invoice management grid data
    public List<Map<String, Object>> invoiceManagementGridData = new ArrayList<>();

    /**
     * Method to parse account management grid data
     *
     * @throws IOException
     */
    public void parseInvoiceManagementGridData() throws IOException {
        Map<String, Object> record;
        List<WebElement> invoiceManagementGridRecordsElement = driver.findElements(By.xpath("//div[@role='row']"));
        List<WebElement> invoiceManagementGridDataElement = driver.findElements(By.xpath("//div[@role='gridcell']"));
        int count = 0;
        for (int i = 0; i < invoiceManagementGridDataElement.size(); i += 8) {
            record = new HashMap<>();
            record.put("Invoice No", invoiceManagementGridDataElement.get(i).getText());
            record.put("Sadad Invoice", invoiceManagementGridDataElement.get(i + 1).getText());
            record.put("Invoice Type", invoiceManagementGridDataElement.get(i + 2).getText());
            record.put("Account Name", invoiceManagementGridDataElement.get(i + 3).getText());
            record.put("Package Name", invoiceManagementGridDataElement.get(i + 4).getText());
            record.put("Amount", invoiceManagementGridDataElement.get(i + 5).getText());
            record.put("Due Date", invoiceManagementGridDataElement.get(i + 6).getText());
            record.put("Status", invoiceManagementGridDataElement.get(i + 7).getText());
            record.put("record", invoiceManagementGridRecordsElement.get(count));
            count++;
            invoiceManagementGridData.add(record);
        }
        System.out.println("InvoiceManagement table" + invoiceManagementGridData);
    }

    // Method to click on Invoice status
    public void clickOnInvoiceStatus() {
        WebClick(UapiOR.Admin_InvoiceManagement_Page_InvoiceStatus);
    }

    // Method to click on Invoice type
    public void clickOnInvoiceType() {
        WebClick(UapiOR.Admin_InvoiceManagement_Page_InvoiceType);
    }

    // Method to select invoice status from dropdown
    public void selectInvoiceStatusFromDropdown(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(1000);
        clickOnInvoiceStatus();
        Thread.sleep(1000);
        WebClickUsingJS("//li[text()='" + testdatamap.get("InvoiceStatus").toString() + "']");
        Thread.sleep(1000);
    }

    // Method to select invoice Type from dropdown
    public void selectInvoiceTypeFromDropdown(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(1000);
        clickOnInvoiceType();
        Thread.sleep(1000);
        WebClickUsingJS("//li[text()='" + testdatamap.get("InvoiceType").toString() + "']");
        Thread.sleep(1000);
    }

    // Method to click on Search button
    public void clickOnSearchButton() {
        WebClick(UapiOR.Admin_InvoiceManagement_Page_SearchBtn);
        this.takeScreenShot();
    }

    //Method to Search By Account Name
    public void searchByAccountName(Map<Object, Object> testdatamap) throws InterruptedException {
        enterAccountName(testdatamap);
        clickOnSearchButton();
    }

    //Method to enter correct account name in search account name option and verify valid data
    public void enterCorrectAccountNameInSearchAccountNameSearchOption(Map<Object, Object> testdatamap, Log Log) throws IOException, InterruptedException {
        searchByAccountName(testdatamap);
        Thread.sleep(3000);
        parseInvoiceManagementGridData();
        VerifyValue1(invoiceManagementGridData.get(0).get("Account Name").toString(), testdatamap.get("Account Name").toString());
        Log.ReportEvent("PASS", " Verify results is displays based on search keyword In Invoice Management is Successful");
        this.takeScreenShot();
    }

    // Method to verify No rows in Invoice Management Screen
    public void verifyNoRowsInInvoiceManagementScreen(Map<Object, Object> testdatamap, Log Log) throws Exception {
        VerifyValue1(getText(UapiOR.Admin_InvoiceManagement_Page_NoRows), testdatamap.get("SystemMessage").toString());
        Log.ReportEvent("PASS", " verify system message No rows In Invoice Management is Successful");
        this.takeScreenShot();
    }

    // Method to enter Incorrect data in search account name search option and verify system message
    public void enterIncorrectDataInSearchAccountNameSearchOption(Map<Object, Object> testdatamap, Log Log) throws Exception {
        searchByAccountName(testdatamap);
        verifyNoRowsInInvoiceManagementScreen(testdatamap, Log);
        Thread.sleep(2000);
        this.takeScreenShot();

    }

    //Method to enter Invoice status in search Invoice Status option and verify valid data
    public void enterInvoiceStatusInSearchInvoiceStatusSearchOption(Map<Object, Object> testdatamap, Log Log) throws IOException, InterruptedException {
        selectInvoiceStatusFromDropdown(testdatamap);
        Thread.sleep(3000);
        parseInvoiceManagementGridData();
        VerifyValue1(invoiceManagementGridData.get(0).get("Status").toString(), testdatamap.get("InvoiceStatus").toString());
        Log.ReportEvent("PASS", " Verify results is displays based on search keyword In Invoice Management is Successful");
        this.takeScreenShot();
    }

    // Method to enter Status Which is Not present in Invoice Management grid status
    public void enterInvoiceStatusNotDisplayedInInvoiceManagementGridStatus(Map<Object, Object> testdatamap, Log Log) throws Exception {
        selectInvoiceStatusFromDropdown(testdatamap);
        verifyNoRowsInInvoiceManagementScreen(testdatamap, Log);
        Thread.sleep(2000);
        this.takeScreenShot();

    }

    //Method to enter Invoice Type in search Invoice Type option and verify valid data
    public void enterInvoiceTypeInSearchInvoiceTypeSearchOption(Map<Object, Object> testdatamap, Log Log) throws IOException, InterruptedException {
        selectInvoiceTypeFromDropdown(testdatamap);
        Thread.sleep(3000);
        parseInvoiceManagementGridData();
        VerifyValue1(invoiceManagementGridData.get(0).get("Invoice Type").toString(), testdatamap.get("InvoiceType").toString());
        Log.ReportEvent("PASS", " Verify results is displays based on search keyword In Invoice Management is Successful");
        this.takeScreenShot();
    }

    // Method to enter Invoice Type Which is Not present in Invoice Management grid Type
    public void enterInvoiceTypeNotDisplayedInInvoiceManagementGridType(Map<Object, Object> testdatamap, Log Log) throws Exception {
        selectInvoiceTypeFromDropdown(testdatamap);
        verifyNoRowsInInvoiceManagementScreen(testdatamap, Log);
        Thread.sleep(2000);
        this.takeScreenShot();

    }
    /**
     * Method to verify downloaded file format
     * @param expectedFileStartingName <String> - Expected file starting name
     * @param expectedFileFormat <String> - Expected file format
     */
    public void verifyDownloadedFileFormat(String expectedFileStartingName,String expectedFileFormat) {
        validateDownloadedFileFormat(expectedFileStartingName,expectedFileFormat);
    }
    /**
     * Used to store my invoices grid data
     */
    public List<Map<String, Object>> myInvoicesGridData = new ArrayList<>();
    /**
     * Method to parse my invoices grid data
     */
    public void parseMyInvoicesGridData1() throws InterruptedException {
        int totalCount = 0; // Total count of records processed across all pages
        // Process each page
        while (true) {
            waitForTwoSec();
            List<WebElement> myInvoicesGridRecordsElement = driver.findElements(By.xpath("//div[@role='row']"));
            List<WebElement> myInvoicesGridDataElement = driver.findElements(By.xpath("//div[@role='gridcell']"));
            // Process each row on the current page
            for (int i = 0; i < myInvoicesGridDataElement.size(); i += 8) {
                Map<String, Object> record = new HashMap<>(); // Create a new map for each row
                // Populate record with data for the current row
                record.put("Invoice No", myInvoicesGridDataElement.get(i).getText());
                record.put("Sadad Invoice", myInvoicesGridDataElement.get(i + 1).getText());
                record.put("Invoice Type", myInvoicesGridDataElement.get(i + 2).getText());
                record.put("Account Name", myInvoicesGridDataElement.get(i + 3).getText());
                record.put("Package Name", myInvoicesGridDataElement.get(i + 4).getText());
                record.put("Amount", myInvoicesGridDataElement.get(i + 5).getText());
                record.put("Invoice Issue Date", myInvoicesGridDataElement.get(i + 6).getText());
                record.put("Status", myInvoicesGridDataElement.get(i + 7).getText());
                record.put("record", myInvoicesGridRecordsElement.get(i / 8));
                myInvoicesGridData.add(record);

                totalCount++; // Increment the total count
            }
            // Check if there's a next page
            if (!IsDispalyed(UapiOR.Admin_InvoiceManagement_GoToNextPage)) {
                takeScreenShot();
                break; // Exit the loop if there's no next page
            }
            // Click the next page button
            WebClick(UapiOR.Admin_InvoiceManagement_GoToNextPage);
            takeScreenShot();
        }
        System.out.println("Total records processed: " + totalCount);
        System.out.println("Invoice Management table: " + myInvoicesGridData);
    }
    /**
     * Method to verify application added new invoice for added package
     * @param generatePackageDate <String> - generate Package Date
     * @param testDataMap <Map> - Test data map
     */
    public void  verifyApplicationAddedNewInvoiceForAddedPackage(String generatePackageDate,Map<Object,Object> testDataMap) {
        try {
            parseMyInvoicesGridData1();
            for (Map<String, Object> myInvoicesGridDate : myInvoicesGridData) {
                if (myInvoicesGridDate.get("Invoice Issue Date").toString().equals(generatePackageDate)) {
                    VerifyValue1(myInvoicesGridDate.get("Invoice Issue Date").toString(), generatePackageDate);
                    VerifyValue1(myInvoicesGridDate.get("Package Name").toString(), testDataMap.get("PackageName").toString());
                    VerifyValue1(myInvoicesGridDate.get("Account Name").toString(), testDataMap.get("Account Name").toString());

                }
            }
        }
        catch(Exception e){
            test.log(Status.FAIL, "Verify Application added new invoice for each added package " + " *  Application added new invoice for each added package is Fail * ");
            takeScreenShot();

        }
    }

}
