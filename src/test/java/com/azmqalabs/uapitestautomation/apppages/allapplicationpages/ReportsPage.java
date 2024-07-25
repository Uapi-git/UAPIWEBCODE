/**
 * Test Script Name                      : ReportsPage.
 * Objective                             : Verify the Reports Functionality.
 * Version                               : 1.0
 * Author                                : Basavaraj Mudnur
 * Created Date                          : 26/06/2024
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportsPage extends BasePage {

    public ReportsPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    /**
     * Click on reports menu
     *
     * @param log<log> - Log
     */
    public void clickOnReportsMenu(Log log) {
        try {
            waitForTwoSec();
            scrollToElement(driver, driver.findElement(By.xpath(UapiOR.Admin_ReportsMenu)));
            WebClick(UapiOR.Admin_ReportsMenu);
            VerifyValue1(getText(UapiOR.Admin_Reports_ConsumptionDetailsMenu), "Consumption Details");
            test.log(Status.PASS, "#FUNC - Click on 'Reports' menu  " + " * Click on 'Reports' menu is Pass * ");
            log.ReportEvent("PASS", "Click on 'Reports' menu is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Reports' menu " + " *Click on 'Reports' menu is Fail * ");
            this.takeScreenShot();
        }
    }


    /**
     * click on consumption details menu
     * @param log<log> - Log
     * @throws IOException
     */
    public void clickOnConsumptionDetailsMenu(Log log) {
        try {
            WebClick(UapiOR.Admin_Reports_ConsumptionDetailsMenu);
            Thread.sleep(3000);
            VerifyValue1(getText(UapiOR.Admin_Reports_ConsumptionDetailsPage), "Consumption Details");
            test.log(Status.PASS, "#FUNC - Click on 'Consumption Details' sub menu  " + " * Click on 'Consumption Details' sub menu is Pass * ");
            log.ReportEvent("PASS", " Click on 'Consumption Details' sub menu is successful");
            waitForTwoSec();
            takeScreenShot();

        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Consumption Details' sub menu " + driver.getTitle() + " *Click on 'Consumption Details' sub menu is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * click on client subscriptions menu
     * @param log<log> - Log
     */
    public void clickOnClientSubscriptionsMenu(Log log) {
        try {
            WebClick(UapiOR.Admin_Reports_ClientSubscriptionMenu);
            Thread.sleep(3000);
            VerifyValue1(getText(UapiOR.Admin_Pages_Header), "Client Subscriptions");
            test.log(Status.PASS, "#FUNC -  Click on 'Client Subscriptions' sub menu  " + " *  Click on 'Client Subscriptions' sub menu is Pass * ");
            log.ReportEvent("PASS", "  Click on 'Client Subscriptions' sub menu is successful");
            waitForTwoSec();
            takeScreenShot();

        } catch (Exception e) {
            test.log(Status.FAIL, " Click on 'Client Subscriptions' sub menu " + driver.getTitle() + " * Click on 'Client Subscriptions' sub menu is Fail * ");
            this.takeScreenShot();
        }
    }


    /**
     * Used to store reports grid data
     */
    public List<Map<String, Object>> reportsGridData = new ArrayList<>();
    public List<Map<String, Object>> reportsGridDataInAscendingOrder = new ArrayList<>();
    public List<Map<String, Object>> reportsGridDataInDescendingOrder = new ArrayList<>();

    /**
     * Method to parse reports consumption details grid data
     * @param order <String> Pass the order according to your need Ascending, Descending and if you are parsing in normal then pass any string
     */
    public void parseReportsConsumptionDetailsGridData(String order) {
        int totalCount = 0; // Total count of records processed across all pages
        // Process each page
        while (true) {
            List<WebElement> consumptionDetailsRecordsElement = driver.findElements(By.xpath("//div[@role='row']"));
            List<WebElement> consumptionDetailsGridDataElement = driver.findElements(By.xpath("//div[@role='gridcell']"));
            // Process each row on the current page
            for (int i = 0; i < consumptionDetailsGridDataElement.size(); i += 5) {
                Map<String, Object> record = new HashMap<>(); // Create a new map for each row
                // Populate record with data for the current row
                record.put("Account Code", consumptionDetailsGridDataElement.get(i).getText());
                record.put("Account Name", consumptionDetailsGridDataElement.get(i + 1).getText());
                record.put("Consumption Due Amount", consumptionDetailsGridDataElement.get(i + 2).getText());
                record.put("Due Month", consumptionDetailsGridDataElement.get(i + 3).getText());
                record.put("record", consumptionDetailsRecordsElement.get(i / 5));
                if (order.equalsIgnoreCase("Ascending")) {
                    reportsGridDataInAscendingOrder.add(record);
                } else if (order.equalsIgnoreCase("Descending")) {
                    reportsGridDataInDescendingOrder.add(record);
                } else {
                    reportsGridData.add(record);
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
        System.out.println("Total records processed: " + totalCount);
        System.out.println("Package Management table: " + reportsGridData);

        int pageCount = Integer.parseInt(getText(UapiOR.Admin_PackageManagement_Pages).replaceFirst(".*of (\\d+).*", "$1"));
        int pages = pageCount / 10;
        if (1 <= pages) {
            for (int n = 1; n <= pages; n++) {
                WebClick(UapiOR.Admin_GoToPreviousPage);
            }
        }
    }

    /**
     * Method to Verify Data Fields Under Consumption Details
     * @param log <Log> - Log
     */
    public void verifyDataFieldsUnderConsumptionDetails(Log log) {
        try {
            verifyElementIsPresent(UapiOR.Admin_Reports_GridTable);
            test.log(Status.PASS, "#FUNC - Verify the data fields displays under Consumption Details table    " + " * Verify the data fields displays under Consumption Details table is Pass * ");
            log.ReportEvent("PASS", "Verify the data fields displays under Consumption Details table is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify the data fields displays under Consumption Details table " + driver.getTitle() + " * Verify the data fields displays under Consumption Details table is Fail * ");
        }
    }

    /**
     * Method to select rows per page
     * @param rowsPerPage <int> - Row per page
     * @param log         <Log> - Log
     */
    public void selectRowsPerPage(int rowsPerPage, Log log) {
        try {
            WebClick(UapiOR.Admin_Reports_TableRowsPerPage);
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
     * Method to select rows per page in client subscription
     * @param rowsPerPage <int> - Row per page
     * @param log         <Log> - Log
     */
    public void selectRowsPerPageInClientSubscription(int rowsPerPage, Log log) {
        try {
            WebClick(UapiOR.Admin_Reports_ClientSubscriptionTableRowsPerPage);
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
     * @param log <Log> - Log
     */
    public void clickOnNextPageIconInTable(Log log) {
        try {
            WebClick(UapiOR.Admin_Reports_GoToNextPage);
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
            WebClick(UapiOR.Admin_Reports_GoToPreviousPage);
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
     * @return Row count
     */
    public int getRowCountInPerPage() {
        int rowSize = driver.findElements(By.xpath("//div[@role='row']")).size();
        return rowSize - 1;
    }

    /**
     * Method to get row count in per page in client subscription page
     * @return Row count
     */
    public int getRowCountInPerPageInClientSubscriptionPage() {
        int rowSize = driver.findElements(By.xpath("//div[@role='row']")).size();
        return rowSize - 2;
    }

    /**
     * Method to verify application retrieve data selected rows per page
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
     * Method to verify application retrieve data selected rows per page
     * @param expectedRowCount <int> Expected row count
     * @param log              <Log> - Log
     */
    public void VerifyApplicationRetrievesDataSelectedRowsPerPageInClientSubscriptionPage(int expectedRowCount, Log log) {
        try {
            Assert.assertEquals(getRowCountInPerPageInClientSubscriptionPage(), expectedRowCount, "Row Counts are matching");
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
     * Method to click on first record action button
     * @param log <Log> - log
     */
    public void clickOnFirstRecordActionButton(Log log) {
        try {
            scrollUptillstarting(driver);
            WebClick(UapiOR.Admin_Reports_FirstRecordActionBtn);
            test.log(Status.PASS, "#FUNC - Click on 'Action' option " + " *  Click on 'Action' option is Pass * ");
            log.ReportEvent("PASS", "Click on 'Action' option is successful");
            takeScreenShot();
            Thread.sleep(500);
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on 'Action' option " + " *  Click on 'Action' option is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on view option from action list
     * @param log <Log> - Log
     */
    public void clickOnView(Log log){
        try {
            WebClick(UapiOR.Admin_Reports_ActionListViewOption);
            test.log(Status.PASS, "#FUNC - Click on View " + " *  Click on View is Pass * ");
            log.ReportEvent("PASS", "Click on View is successful");
            waitForTwoSec();
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on View " + " *  Click on View is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click export pdf button
     * @param log <Log> - Log
     */
    public void clickOnExportPDFButton(Log log){
        try {
            WebClick(UapiOR.Admin_ReportsConsumptionDetails_ViewExportPDFButton);
            test.log(Status.PASS, "#FUNC - Click on 'Export PDF' button " + " *   Click on 'Export PDF' button is Pass * ");
            log.ReportEvent("PASS", " Click on 'Export PDF' button is successful");
            waitForTwoSec();
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL, " Click on 'Export PDF' button " + " *   Click on 'Export PDF' button is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on export excel button
     * @param log <Log> - Log
     */
    public void clickOnExportExcelButton(Log log){
        try {
            WebClick(UapiOR.Admin_ReportsConsumptionDetails_ViewExportExcelButton);
            test.log(Status.PASS, "#FUNC - Click on 'Export Excel' button " + " * Click on 'Export Excel' button is Pass * ");
            log.ReportEvent("PASS", " Click on 'Export Excel' button is successful");
            takeScreenShot();
            waitForTwoSec();
        }
        catch (Exception e){
            test.log(Status.FAIL, " Click on 'Export Excel' button " + " * Click on 'Export Excel' button is Fail * ");
            takeScreenShot();
        }
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
     * Method to verify selected account code and fields after click on view
     * @param rowNo <int> Row no
     * @throws Exception
     */
    public void verifySelectedAccountCodeAndFieldsAfterClickOnView(int rowNo) throws Exception {
        String expectedViewPage = reportsGridData.get(rowNo - 1).get("Account Code").toString();
        Assert.assertEquals(getText(UapiOR.Admin_ReportsConsumptionDetails_ViewPage),expectedViewPage);
        takeScreenShot();
        verifyElementIsPresent(UapiOR.Admin_ReportsConsumptionDetailsViewPage_AccountCodeField,"");
        verifyElementIsPresent(UapiOR.Admin_ReportsConsumptionDetailsViewPage_AccountNameField,"");
        verifyElementIsPresent(UapiOR.Admin_ReportsConsumptionDetailsViewPage_ActivePackageNameField,"");
        verifyElementIsPresent(UapiOR.Admin_ReportsConsumptionDetailsViewPage_PackageRemainingField,"");
        verifyElementIsPresent(UapiOR.Admin_ReportsConsumptionDetailsViewPage_DueMonthField,"");
    }

    /**
     * Method to verify client subscription package details details
     */
    public void verifyClientSubscriptionPackageDetailsDetails(){
        String [] expectedPackageDetailsHeaders={"Account ID","Account Name","Package Name","Price","Transaction Limit","Transaction Consumption","Available Amount","Price Consumption","Activation Date","Status"};
        for (int i=0; i<getElements(UapiOR.Admin_Reports_ClientSubscription_PackageDetailDetails).size(); i++) {
            Assert.assertEquals(getElements(UapiOR.Admin_Reports_ClientSubscription_PackageDetailDetails).get(i).getText(),expectedPackageDetailsHeaders[i]);
        }
    }

    /**
     * Method to parse reports client subscriptions grid data
     * @param order <String> Pass the order according to your need Ascending, Descending and if you are parsing in normal then pass any string
     */
    public void parseReportsClientSubscriptionsGridData(String order) throws InterruptedException {
        int totalCount = 0; // Total count of records processed across all pages
        // Process each page
        while (true) {
            waitForTwoSec();
            List<WebElement> consumptionDetailsRecordsElement = driver.findElements(By.xpath("//div[@role='row']"));
            List<WebElement> consumptionDetailsGridDataElement = driver.findElements(By.xpath("//div[@role='gridcell']"));
            // Process each row on the current page
            for (int i = 0; i < consumptionDetailsGridDataElement.size(); i += 11) {
                Map<String, Object> record = new HashMap<>(); // Create a new map for each row
                // Populate record with data for the current row
                record.put("Account ID", consumptionDetailsGridDataElement.get(i).getText());
                record.put("Account Name", consumptionDetailsGridDataElement.get(i + 1).getText());
                record.put("Package Name", consumptionDetailsGridDataElement.get(i + 2).getText());
                record.put("Price", consumptionDetailsGridDataElement.get(i + 3).getText());
                record.put("Transaction Limit", consumptionDetailsGridDataElement.get(i + 4).getText());
                record.put("Transaction Consumption", consumptionDetailsGridDataElement.get(i + 5).getText());
                record.put("Available Amount", consumptionDetailsGridDataElement.get(i + 6).getText());
                record.put("Price Consumption", consumptionDetailsGridDataElement.get(i + 7).getText());
                record.put("Activation Date", consumptionDetailsGridDataElement.get(i + 8).getText());
                record.put("Status", consumptionDetailsGridDataElement.get(i + 9).getText());
                record.put("record", consumptionDetailsRecordsElement.get(i / 11));
                if (order.equalsIgnoreCase("Ascending")) {
                    reportsGridDataInAscendingOrder.add(record);
                } else if (order.equalsIgnoreCase("Descending")) {
                    reportsGridDataInDescendingOrder.add(record);
                } else {
                    reportsGridData.add(record);
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
        System.out.println("Total records processed: " + totalCount);
        System.out.println("Package Management table: " + reportsGridData);

        int pageCount = Integer.parseInt(getText(UapiOR.Admin_PackageManagement_Pages).replaceFirst(".*of (\\d+).*", "$1"));
        int pages = pageCount / 10;
        if (1 <= pages) {
            for (int n = 1; n < pages; n++) {
                WebClick(UapiOR.Admin_GoToPreviousPage);
                waitForTwoSec();

            }
        }
    }

    /**
     * Method to click on action button based on the account name
     * @param accountName <String> - Account name
     * @param log <Log> - Log
     */
    public void clickOnActionButtonBasedOnTheAccountName(String accountName, Log log) {
        try {
            WebClick("(//h2[text()='" + accountName + "']/parent::div/following-sibling::div/div//*[@data-testid='MoreHorizIcon'])[1]");
            test.log(Status.PASS, "#FUNC - Click on 'Action' option " + " *  Click on 'Action' option is Pass * ");
            log.ReportEvent("PASS", "Click on 'Action' option is successful");
            takeScreenShot();
            Thread.sleep(500);
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Action' option " + " *  Click on 'Action' option is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to select search by  month value
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - Log
     */
    public void selectSearchByMonthValue(Map<Object,Object> testDataMap, Log log) {
        try {
            WebClick(UapiOR.Admin_ReportsConsumptionDetails_SearchByMonthCalender);
            Thread.sleep(500);
            mouseOver(driver,getElement("//button[text()='"+testDataMap.get("Month").toString()+"']"));
            Thread.sleep(500);
            WebClickUsingActions("//button[text()='"+testDataMap.get("Month").toString()+"']");
            test.log(Status.PASS, "#FUNC - Select 'Search by Month' value " + " *  Select 'Search by Month' value is Pass * ");
            log.ReportEvent("PASS", "Select 'Search by Month' value is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Select 'Search by Month' value " + " *  Select 'Search by Month' value is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to select search by  month value
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - Log
     */
    public void selectSearchByYearValue(Map<Object,Object> testDataMap, Log log) {
        try {
            WebClick(UapiOR.Admin_ReportsConsumptionDetails_SearchByYearCalender);
            mouseOver(driver,getElement("//button[text()='"+testDataMap.get("Year").toString()+"']"));
            WebClickUsingActions("//button[text()='"+testDataMap.get("Year").toString()+"']");
            test.log(Status.PASS, "#FUNC - Select 'Search by Year' value " + " *  Select 'Search by Year' value is Pass * ");
            log.ReportEvent("PASS", "Select 'Search by Year' value is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Select 'Search by Year' value " + " *  Select 'Search by Year' value is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to select search by  month value
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - Log
     */
    public void clearSearchByYearValue(Map<Object,Object> testDataMap, Log log) {
        try {
            WebClick(UapiOR.Admin_ReportsConsumptionDetails_SearchByYearCalender);
            WebClickUsingJS(UapiOR.Admin_ReportsConsumptionDetails_SearchByYearCalenderClearBtn);
            takeScreenShot();
        } catch (Exception e) {
            takeScreenShot();
        }
    }

    /**
     * Verify please select year error message
     */
    public void verifyPleaseSelectYearErrorMSG() {
        try {
            Assert.assertEquals(getText(UapiOR.Admin_ErrorMsg), "Please select year!");
        } catch (Exception e) {
            takeScreenShot();
        }
    }

    /**
     * Method to verify grid data sorted based on selected value
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - Log
     */
    public void verifyGridDataSortedBasedOnSelectedValue(Map<Object,Object> testDataMap, Log log) {
        try {
            for (int i=0; i<getElements(UapiOR.Admin_ReportsConsumptionDetails_GridRecordsDueMonths).size(); i++) {
                Assert.assertTrue(getElements(UapiOR.Admin_ReportsConsumptionDetails_GridRecordsDueMonths).get(i).getText().contains(testDataMap.get("Month").toString()));
            }
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Select 'Search by Year' value " + " *  Select 'Search by Year' value is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify no rows message
     */
    public void verifyNoRowsMessage(Log log) {
        try {
            Assert.assertEquals(getText(UapiOR.Admin_ReportsConsumptionDetails_GridRecordNoRowsMessage),"No rows");
            test.log(Status.PASS, "#FUNC - verify system message " + " * verify system message is Pass * ");
            log.ReportEvent("PASS", "verify system message is successful");
            takeScreenShot();
        } catch (Exception e) {
            takeScreenShot();
            test.log(Status.FAIL, "verify system message " + " * verify system message is Fail * ");
        }
    }

    /**
     * Method to Verify data fields under client subscription
     * @param log <Log> - Log
     */
    public void verifyDataFieldsUnderClientSubscription(Log log) {
        try {
            verifyElementIsPresent(UapiOR.Admin_Reports_GridTable);
            test.log(Status.PASS, "#FUNC - Verify the data fields displays under Client Subscriptions table " + " * Verify the data fields displays under Client Subscriptions table is Pass * ");
            log.ReportEvent("PASS", "Verify the data fields displays under Client Subscriptions table is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify the data fields displays under Consumption Details table " + driver.getTitle() + " * Verify the data fields displays under Consumption Details table is Fail * ");
        }
    }

    /**
     * Method to click on close button in package details popup
     */
    public void clickOnCloseBtnInPackageDetailPopup(){
        WebClick(UapiOR.Admin_Reports_ClientSubscription_PackageDetailDetailsCloseBtn);
    }

    /**
     * Method to click on back button in package detail popup
     * @param log <Log> - Log
     */
    public void clickOnBackBtnInPackageDetailPopup(Log log) {
        try {
            WebClick(UapiOR.Admin_Reports_ClientSubscription_PackageDetailDetailsBackBtn);
            Assert.assertEquals(getText(UapiOR.Admin_Pages_Header), "Client Subscriptions");
            test.log(Status.PASS, "#FUNC - Click on 'Back' button " + " * Click on 'Back' button is Pass * ");
            log.ReportEvent("PASS", "Click on 'Back' button is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Back' button " + driver.getTitle() + " * Click on 'Back' button is Fail * ");
        }
    }

    /**
     * Method to search package name
     * @param testdatamap <Map> - Test data map
     * @param log         <Log> - Log
     */
    public void searchPackageName(Map<Object, Object> testdatamap, Log log) {
        try {
            WebEdit(UapiOR.Admin_Reports_ClientSubscriptionsPage_PackageNameSearchField, testdatamap.get("SearchFieldInput").toString());
            WebClick(UapiOR.Admin_Reports_ClientSubscriptionsPage_PackageNameSearchBtn);
            test.log(Status.PASS, "#FUNC - Enter keyword in 'Search Package Name' " + " * Enter keyword in 'Search Package Name' is Pass * ");
            log.ReportEvent("PASS", "Enter keyword in 'Search Package Name' is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.PASS, "Enter keyword in 'Search Client Name' " + " *  Enter keyword in 'Search Client Name' is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to search with select package status
     * @param testdatamap <Map> - Test data map
     * @param log         <Log> - Log
     */
    public void searchWithSelectPackageStatus(Map<Object, Object> testdatamap,Log log) {
        try {
            WebClick(UapiOR.Admin_Reports_ClientSubscriptionsPage_SelectPackageStatusBtn);
            WebClick("//li[@data-value='" + testdatamap.get("SelectPackageStatusOption").toString() + "']");
            test.log(Status.PASS, "#FUNC - Select 'Select Package Status' " + " * Select 'Select Package Status' is Pass * ");
            log.ReportEvent("PASS", "Select 'Select Package Status' is successful");
            waitForTwoSec();
            takeScreenShot();
            Thread.sleep(1000);
        } catch (Exception e) {
            test.log(Status.PASS, "Select 'Select Package Status' " + " * Select 'Select Package Status is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to search client name
     * @param testdatamap <Map> - Test data map
     * @param log         <Log> - Log
     */
    public void searchClientName(Map<Object, Object> testdatamap, Log log) {
        try {
            WebEdit(UapiOR.Admin_Reports_ClientSubscriptionsPage_ClientNameSearchField, testdatamap.get("SearchFieldInput").toString());
            WebClick(UapiOR.Admin_Reports_ClientSubscriptionsPage_ClientNameSearchBtn);
            test.log(Status.PASS, "#FUNC - Enter keyword in 'Search Client Name' " + " * Enter keyword in 'Search Client Name' is Pass * ");
            log.ReportEvent("PASS", "Enter keyword in 'Search Client Name' is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.PASS, "Enter keyword in 'Search Client Name' " + " *  Enter keyword in 'Search Client Name' is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to verify client subscription grid record data
     * @param testDataMap <Map> - Test data map
     * @param rowNumber   <int> - Row number
     */
    public void verifyClientSubscriptionGridRecordData(int rowNumber, Map<Object, Object> testDataMap, Log log) {
        try {
            Assert.assertEquals(reportsGridData.get(rowNumber - 1).get(testDataMap.get("ColumnName").toString()).toString(), testDataMap.get("SearchedData").toString());
            test.log(Status.PASS, "#FUNC - Verify filtered data  " + " * Verify filtered data is Pass * ");
            log.ReportEvent("PASS", "Verify filtered data is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify filtered data  " + " * Verify filtered data is Fail * ");
        }
    }

    /**
     * Method to Click on search field clear Button
     * @param log <log> - Log
     */
    public void clickOnSearchFieldClearBtn(Log log) {
        try {
            WebClick(UapiOR.Admin_Reports_ClientSubscriptionsPage_ClientNameClearBtn);
            waitForTwoSec();
            test.log(Status.PASS, "#FUNC - Click on 'clear' icon  " + " * Click on 'clear' icon is Pass * ");
            log.ReportEvent("PASS", "Click on 'clear' icon is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'clear' icon button " + " * Click on 'clear' icon is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to Click on clear value of client name search field
     * @param log <log> - Log
     */
    public void VerifyClearedValueOfClientNameSearchField(Log log) {
        try {
            VerifyValue1(driver.findElement(By.xpath(UapiOR.Admin_Reports_ClientSubscriptionsPage_ClientNameSearchField)).getAttribute("value"), "");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify retrieved data is cleared " + " * Verify retrieved data is cleared is Fail * ");
            this.takeScreenShot();
        }
    }

}
