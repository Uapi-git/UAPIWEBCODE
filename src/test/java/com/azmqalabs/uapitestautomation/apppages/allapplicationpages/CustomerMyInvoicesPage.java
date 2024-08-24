/**
 * Test Script Name                      : CustomerMyInvoicesPage.
 * Objective                             : Verify my invoices page functionality.
 * Version                               : 1.0
 * Author                                : Basavaraj Mudnur
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
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerMyInvoicesPage extends BasePage {

    public CustomerMyInvoicesPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    /**
     * Click on my invoices menu
     * @param log<log> - Log
     */
    public void clickOnMyInvoicesMenu(Log log) {
        try {
            WebClick(UapiOR.Customer_MyInvoicesMenu);
            VerifyValue1(getText(UapiOR.Customer_MyInvoicesPage_Header), "My Invoices");
            test.log(Status.PASS, "#FUNC - Click on My Invoices menu  " + " * Click on My Invoices menu is Pass * ");
            log.ReportEvent("PASS", "Click on My Invoices menu is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on My Invoices menu " + " *Click on My Invoices menu is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to verify data field in table
     * @param log <Log> - Log
     */
    public void verifyDataFieldsInTable(Log log){
        try{
            verifyElementIsPresent(UapiOR.Customer_MyInvoicesPage_Grid);
            String[] expectedColumnNames = {"Invoice No","Sadad Invoice","Invoice Type","Package Name","Amount","Invoice Issue Date","Status"};
            for (int i=0; i<getElements(UapiOR.Customer_MyInvoicesPage_GridColumnNames).size(); i++){
                VerifyValue1(getElements(UapiOR.Customer_MyInvoicesPage_GridColumnNames).get(i).getText(),expectedColumnNames[i]);
            }
            test.log(Status.PASS, "#FUNC - Verify data filed in table   " + " * Verify data filed in table is Pass * ");
            log.ReportEvent("PASS", "Verify data filed in table is successful");
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL, "Verify data filed in table menu " + " * Verify data filed in table is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Used to store my invoices grid data
     */
    public List<Map<String, Object>> myInvoicesGridData = new ArrayList<>();

    /**
     * Method to parse my invoices grid data
     */
    public void parseMyInvoicesGridData() throws InterruptedException {
        int totalCount = 0; // Total count of records processed across all pages
        // Process each page
        while (true) {
            waitForTwoSec();
            List<WebElement> myInvoicesGridRecordsElement = driver.findElements(By.xpath("//div[@role='row']"));
            List<WebElement> myInvoicesGridDataElement = driver.findElements(By.xpath("//div[@role='gridcell']"));
            // Process each row on the current page
            for (int i = 0; i < myInvoicesGridDataElement.size(); i += 7) {
                Map<String, Object> record = new HashMap<>(); // Create a new map for each row
                // Populate record with data for the current row
                record.put("Invoice No", myInvoicesGridDataElement.get(i).getText());
                record.put("Sadad Invoice", myInvoicesGridDataElement.get(i + 1).getText());
                record.put("Invoice Type", myInvoicesGridDataElement.get(i + 2).getText());
                record.put("Package Name", myInvoicesGridDataElement.get(i + 3).getText());
                record.put("Amount", myInvoicesGridDataElement.get(i + 4).getText());
                record.put("Invoice Issue Date", myInvoicesGridDataElement.get(i + 5).getText());
                record.put("Status", myInvoicesGridDataElement.get(i + 6).getText());
                record.put("record", myInvoicesGridRecordsElement.get(i / 7));
                myInvoicesGridData.add(record);

                totalCount++; // Increment the total count
            }
            // Check if there's a next page
            if (!IsDispalyed(UapiOR.Admin_PackageManagement_GoToNextPage)) {
                break; // Exit the loop if there's no next page
            }
            // Click the next page button
            WebClick(UapiOR.Admin_PackageManagement_GoToNextPage);
        }
        System.out.println("Total records processed: " + totalCount);
        System.out.println("Package Management table: " + myInvoicesGridData);
    }

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
            for (int i = 0; i < myInvoicesGridDataElement.size(); i += 7) {
                Map<String, Object> record = new HashMap<>(); // Create a new map for each row
                // Populate record with data for the current row
                record.put("Invoice No", myInvoicesGridDataElement.get(i).getText());
                record.put("Sadad Invoice", myInvoicesGridDataElement.get(i + 1).getText());
                record.put("Invoice Type", myInvoicesGridDataElement.get(i + 2).getText());
                record.put("Package Name", myInvoicesGridDataElement.get(i + 3).getText());
                record.put("Amount", myInvoicesGridDataElement.get(i + 4).getText());
                record.put("Invoice Issue Date", myInvoicesGridDataElement.get(i + 5).getText());
                record.put("Status", myInvoicesGridDataElement.get(i + 6).getText());
                record.put("record", myInvoicesGridRecordsElement.get(i / 7));
                myInvoicesGridData.add(record);

                totalCount++; // Increment the total count
            }
            // Check if there's a next page
            if (!IsDispalyed(UapiOR.Admin_PackageManagement_GoToNextPage)) {
                takeScreenShot();
                break; // Exit the loop if there's no next page
            }
            // Click the next page button
            WebClick(UapiOR.Admin_PackageManagement_GoToNextPage);
            takeScreenShot();
        }
        System.out.println("Total records processed: " + totalCount);
        System.out.println("Package Management table: " + myInvoicesGridData);
    }

    /**
     * Method to back to first page after parse
     * @throws InterruptedException
     */
    public void backToFirstPageAfterParse() throws InterruptedException {
        int pageCount = Integer.parseInt(getText("//div[@role='grid']/following-sibling::div//p").replaceFirst(".*of (\\d+).*", "$1"));
        int pages = pageCount / 10;
        if (1 <= pages) {
            for (int n = 1; n <= pages; n++) {
                if (!getElement(UapiOR.Admin_PackageManagement_GoToPreviousPage).getAttribute("class").contains("Mui-disabled"))
                    WebClick(UapiOR.Admin_PackageManagement_GoToPreviousPage);
                waitForTwoSec();
            }
        }
    }

    /**
     * Method to search package name
     * @param testDataMap <Map> - Test data map
     * @param log         <Log> - Log
     */
    public void searchPackageName(Map<Object, Object> testDataMap, Log log) {
        try {
            WebEdit(UapiOR.Customer_MyInvoicesPage_PackageNameSearchField, testDataMap.get("SearchFieldInput").toString());
            WebClick(UapiOR.Customer_MyInvoicesPage_PackageNameSearchBtn);
            test.log(Status.PASS, "#FUNC -  Enter search keyword in Search Package Name " + " *  Enter search keyword in Search Package Name is Pass * ");
            log.ReportEvent("PASS", " Enter search keyword in Search Package Name is successful");
            waitForTwoSec();
            takeScreenShot();
            Thread.sleep(1000);
        } catch (Exception e) {
            test.log(Status.FAIL, " Enter search keyword in Search Package Name " + " *   Enter search keyword in Search Package Name is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to Click on search field clear Button
     * @param log <log> - Log
     */
    public void clickOnSearchFieldClearBtn(Log log) {
        try {
            WebClick(UapiOR.Customer_MyInvoicesPage_PackageNameClearBtn);
            waitForTwoSec();
            test.log(Status.PASS, "#FUNC - Click on 'X' clear button " + " * Click on 'X' clear button is Pass * ");
            log.ReportEvent("PASS", "Click on 'X' clear button is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'X' clear button " + " * Click on 'X' clear button is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to verify cleared value of package name search field
     * @param log <log> - Log
     */
    public void VerifyClearedValueOfPackageNameSearchField(Log log) {
        try {
            VerifyValue1(driver.findElement(By.xpath(UapiOR.Customer_MyInvoicesPage_PackageNameSearchField)).getAttribute("value"), "");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify retrieved data is cleared " + " * Verify retrieved data is cleared is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to verify application added new invoice for added package
     * @param generatePackageDate <String> - generate Package Date
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - Log
     */
    public void  verifyApplicationAddedNewInvoiceForAddedPackage(String generatePackageDate,Map<Object,Object> testDataMap, Log log) {
        try {
            parseMyInvoicesGridData1();
            for (Map<String, Object> myInvoicesGridDate : myInvoicesGridData) {
                if (myInvoicesGridDate.get("Invoice Issue Date").toString().equals(generatePackageDate)) {
                    VerifyValue1(myInvoicesGridDate.get("Invoice Issue Date").toString(), generatePackageDate);
                    VerifyValue1(myInvoicesGridDate.get("Package Name").toString(), testDataMap.get("PackageName").toString());
                }
            }
        }
        catch(Exception e){
            test.log(Status.FAIL, "#FUNC -  Application added new invoice for each added package " + " *  Application added new invoice for each added package. is Fail * ");
            takeScreenShot();

        }
    }

    /**
     * Method to verify filter data for package name displayed as search
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - Log
     */
    public void verifyFilterDataForPackageNameDisplayedAsSearch(Map<Object, Object> testDataMap, Log log) {
        try {
            for (Map<String, Object> myInvoicesGridDate : myInvoicesGridData) {
                VerifyValue1(myInvoicesGridDate.get("Package Name").toString(), testDataMap.get("PackageName").toString());
            }
            test.log(Status.PASS, "#FUNC - Verify filtered data " + " * Verify filtered data is Pass * ");
            log.ReportEvent("PASS", "Verify filtered data is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify filtered data " + " * Verify filtered data is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to verify no rows message
     * @param log <Log> - Log
     */
    public void verifyNoRowsMessage(Log log) {
        try {
            Assert.assertEquals(getText(UapiOR.Customer_MyInvoicesPage_GridRecordNoRowsMessage),"No rows");
            test.log(Status.PASS, "#FUNC - verify system message " + " * verify system message is Pass * ");
            log.ReportEvent("PASS", "verify system message is successful");
            takeScreenShot();
        } catch (Exception e) {
            takeScreenShot();
            test.log(Status.FAIL, "verify system message " + " * verify system message is Fail * ");
        }
    }

    /**
     * Method to search with select invoice status
     * @param testdatamap <Map> - Test data map
     * @param log         <Log> - Log
     */
    public void searchWithSelectInvoiceStatus(Map<Object, Object> testdatamap,Log log) {
        try {
            WebClick(UapiOR.Customer_MyInvoicesPage_SelectInvoiceStatusBtn);
            WebClick("//li[@data-value='" + testdatamap.get("SelectInvoiceStatusOption").toString() + "']");
            test.log(Status.PASS, "#FUNC - Select option from dropdown list  in 'Select Invoice Status'  " + " * Select option from dropdown list  in 'Select Invoice Status' is Pass * ");
            log.ReportEvent("PASS", "Select option from dropdown list  in 'Select Invoice Status' is successful");
            waitForTwoSec();
            takeScreenShot();
            Thread.sleep(1000);
        } catch (Exception e) {
            test.log(Status.PASS, "Select option from dropdown list  in 'Select Invoice Status' " + " * Select option from dropdown list  in 'Select Invoice Status' is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to verify filter data for invoice status displayed as selected
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - Log
     */
    public void verifyFilterDataForInvoiceStatusDisplayedAsSelected(Map<Object, Object> testDataMap, Log log) {
        try {
            for (Map<String, Object> myInvoicesGridDate : myInvoicesGridData) {
                VerifyValue1(myInvoicesGridDate.get("Status").toString(), testDataMap.get("Status").toString());
            }
            test.log(Status.PASS, "#FUNC - Verify filtered data " + " * Verify filtered data is Pass * ");
            log.ReportEvent("PASS", "Verify filtered data is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify filtered data " + " * Verify filtered data is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to search with select invoice type
     * @param testdatamap <Map> - Test data map
     * @param log         <Log> - Log
     */
    public void searchWithSelectInvoiceType(Map<Object, Object> testdatamap,Log log) {
        try {
            WebClick(UapiOR.Customer_MyInvoicesPage_SelectInvoiceTypeBtn);
            WebClick("//li[@data-value='" + testdatamap.get("SelectInvoiceTypeOption").toString() + "']");
            test.log(Status.PASS, "#FUNC - Select option from dropdown list  in 'Select Invoice Type'  " + " * Select option from dropdown list  in 'Select Invoice Type' is Pass * ");
            log.ReportEvent("PASS", "Select option from dropdown list  in 'Select Invoice Type' is successful");
            waitForTwoSec();
            takeScreenShot();
            Thread.sleep(1000);
        } catch (Exception e) {
            test.log(Status.PASS, "Select option from dropdown list  in 'Select Invoice Type' " + " * Select option from dropdown list  in 'Select Invoice Type' is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to verify filter data for invoice type displayed as selected
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - Log
     */
    public void verifyFilterDataForInvoiceTypeDisplayedAsSelected(Map<Object, Object> testDataMap, Log log) {
        try {
            for (Map<String, Object> myInvoicesGridDate : myInvoicesGridData) {
                VerifyValue1(myInvoicesGridDate.get("Invoice Type").toString(), testDataMap.get("InvoiceType").toString());
            }
            test.log(Status.PASS, "#FUNC - Verify filtered data " + " * Verify filtered data is Pass * ");
            log.ReportEvent("PASS", "Verify filtered data is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify filtered data " + " * Verify filtered data is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to Click on export pdf Button
     * @param log <log> - Log
     */
    public void clickOnExportPDFButton(Log log) {
        try {
            WebClick(UapiOR.Customer_MyInvoicesPage_ExportPDFBtn);
            waitForTwoSec();
            test.log(Status.PASS, "#FUNC - Click on 'Export PDF' button " + " * Click on 'Export PDF' button is Pass * ");
            log.ReportEvent("PASS", "Click on 'Export PDF' button is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Export PDF' button " + " * Click on 'Export PDF' button is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to Click on export excel Button
     * @param log <log> - Log
     */
    public void clickOnExportExcelButton(Log log) {
        try {
            WebClick(UapiOR.Customer_MyInvoicesPage_ExportExcelBtn);
            waitForTwoSec();
            test.log(Status.PASS, "#FUNC - Click on 'Export Excel' button " + " * Click on 'Export Excel' button is Pass * ");
            log.ReportEvent("PASS", "Click on 'Export Excel' button is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Export Excel' button " + " * Click on 'Export Excel' button is Fail * ");
            this.takeScreenShot();
        }
    }
}
