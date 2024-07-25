/**
 * Test Script Name                      : ReportsConsumptionDetailsPage.
 * Objective                             : Verify the Reports consumption  details pageFunctionality.
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
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportsConsumptionDetailsPage extends BasePage {

    public ReportsConsumptionDetailsPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    /**
     * Method to Verify data fields under consumption details
     * @param log <Log> - Log
     * @throws IOException
     */
    public void verifyDataFieldsUnderConsumptionDetails(Log log) {
        try {
            mouseOver(driver,getElement(UapiOR.Admin_Reports_GridTable));
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
     * Method to click on next page icon in table
     * @param log <Log> - Log
     */
    public void clickOnNextPageIconInTable(Log log) {
        try {
            WebClick(UapiOR.Admin_Reports_ConsumptionDetailsGoToNextPage);
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
            WebClick(UapiOR.Admin_Reports_ConsumptionDetailsGoToPreviousPage);
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
     * Method to click on export pdf button
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
     * Method to verify consumption details page grid column names
     */
    public void verifyConsumptionDetailsPageGridColumnNames() {
        scrollToElement(driver,getElement(UapiOR.Admin_ReportsConsumptionDetails_ViewExportExcelButton));
        String[] expectedColumnNames = {"Service", "Success Transactions", "Failure Transactions", "Total Transactions", "Total Price"};
        for (int i = 0; i < getElements(UapiOR.Admin_ReportsConsumptionDetailsViewPage_GridColumnNames).size(); i++) {
            String columnNames = getElements(UapiOR.Admin_ReportsConsumptionDetailsViewPage_GridColumnNames).get(i).getText();
            Assert.assertEquals(columnNames, expectedColumnNames[i]);
        }
        takeScreenShot();
    }

}
