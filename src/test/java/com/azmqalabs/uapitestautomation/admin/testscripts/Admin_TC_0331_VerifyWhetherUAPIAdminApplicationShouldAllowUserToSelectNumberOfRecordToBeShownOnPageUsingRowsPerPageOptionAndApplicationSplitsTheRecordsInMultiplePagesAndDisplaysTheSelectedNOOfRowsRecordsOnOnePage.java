/**
 * Test Script Name                      : Admin_TC_0331_VerifyWhetherUAPIAdminApplicationShouldAllowUserToSelectNumberOfRecordToBeShownOnPageUsingRowsPerPageOptionAndApplicationSplitsTheRecordsInMultiplePagesAndDisplaysTheSelectedNOOfRowsRecordsOnOnePage.
 * Test data sheet Name                  : Admin_TC_0331
 * Objective                             : Verify whether UAPI Admin application should allow user to select number of record to be shown on page using 'Rows per page' option and application splits the records in multiple pages and displays [the selected NO. of rows] records on one page. User should be able to click on Next and Back page, and application should retrieve data according to the user selection..
 * Version                               : 1.0
 * Author                                : Basavaraj Mudnur
 * Created Date                          : 21/06/2024
 * Last Updated on                       : N/A
 * Updated By                            :
 * Pre-Conditions                        : 1. Valid login credentials of ADMIN user is required
 * Epic Details                          : N/A
 * User Story Details                    : N/A
 * Defects affecting this test script    : None
 * Work Around/Known Issues              : None
 */
package com.azmqalabs.uapitestautomation.admin.testscripts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.azmqalabs.uapitestautomation.apppages.collectionofpages.Pages;
import com.azmqalabs.uapitestautomation.common.*;
import com.codoid.products.fillo.Recordset;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Map;

public class Admin_TC_0331_VerifyWhetherUAPIAdminApplicationShouldAllowUserToSelectNumberOfRecordToBeShownOnPageUsingRowsPerPageOptionAndApplicationSplitsTheRecordsInMultiplePagesAndDisplaysTheSelectedNOOfRowsRecordsOnOnePage {
    // DECLARATION SECTION
    static String TestDataTab = "Admin_TC_0331";

    private WebDriver driver;
    private InitializeDriver initializeDriver;
    private EventFiringWebDriver driverEvent;
    private webDriverEventListener eventListener;
    Map<Object, Object> testdatamap;
    Map<Object, Object> testresultsmap;
    private String TestScriptID = "";
    static Recordset recTestData;
    static ArrayList<String> arrListTestDataColumnNames;
    String sBrowserTestData = "";
    String browserFromXML = "";
    String className = "";
    ExtentReports extent;
    ExtentTest test;
    com.azmqalabs.uapitestautomation.apppages.collectionofpages.Pages Pages;
    com.azmqalabs.uapitestautomation.common.Log Log;
    com.azmqalabs.uapitestautomation.common.DBUtil DBUtil;

    // FACTORY - DATA PROVIDER
    @Factory(dataProvider = "TestDataProvider")
    public Admin_TC_0331_VerifyWhetherUAPIAdminApplicationShouldAllowUserToSelectNumberOfRecordToBeShownOnPageUsingRowsPerPageOptionAndApplicationSplitsTheRecordsInMultiplePagesAndDisplaysTheSelectedNOOfRowsRecordsOnOnePage(Map<Object, Object> testdatamap) {
        this.testdatamap = testdatamap;
        this.TestScriptID = testdatamap.get("TestScriptID").toString();
        this.sBrowserTestData = testdatamap.get("Browser").toString();
    }

    @Override
    public String toString() {
        return String.format("%S", TestScriptID);
    }

    // DATA PROVIDER - FOR TEST DATA
    @DataProvider
    public static Object[][] TestDataProvider() throws Exception {
        Map<String, String> TestDataColNames;
        ReadData.retrieveLoginEnvDetails();
        arrListTestDataColumnNames = ReadData.readDataTableColumns(TestDataTab);
        TestDataColNames = ReadData.mapTestDataTableColumns(arrListTestDataColumnNames);
        recTestData = ReadData.readTestData(TestDataTab);
        Object[][] testdataobj = ReadData.mapTestData(TestDataColNames, recTestData);
        return testdataobj;
    }

    // TEST METHOD
    @Test
    public void myTest() throws Exception {
        try {
            testresultsmap = testdatamap;
            testresultsmap.put("BrowserName", browserFromXML);
            testresultsmap.put("TestScriptID", TestScriptID);
            testresultsmap.put("TestDataName", TestDataTab);
            System.out.println(testdatamap.get(TestScriptID));
            Log.ReportEvent("PASS", className + " - Execution Started");

            Pages.InvokeApplicationPage.launchApplication();
            Pages.adminLoginPage.loginToApplication(Log);
            Pages.userManagementPage.clickOnUserManagementMenu(Log);
            Pages.userManagementPage.verifyUserManagementGridData(Log);
            Pages.userManagementPage.selectRowsPerPage(5,Log);
            Pages.userManagementPage.clickOnNextPageIconInTable(Log);
            Pages.userManagementPage.clickOnPreviousPageIconInTable(Log);
            Pages.userManagementPage.VerifyApplicationRetrievesDataSelectedRowsPerPage(5,Log);
            Pages.adminLoginPage.logout(Log);

            Log.PostTestStatus(TestScriptID);
            driver.quit();
        } catch (Exception e) {
            Log.takeScreenShot();
            Log.PostTestStatus(TestScriptID);
            Log.ReportEvent("INFO", "TEST EXECUTION INCOMPLETE" + e);
            DBUtil.UpdateTestResultExceptionInDB(testresultsmap);
            Log.ReportEvent("FATAL", "<< !!!!!!!!!!!!!!!!!!!!! TEST INCOMPLETE !!!!!!!!!!!!!!!!!!!!! >>" + e);
            System.out.println("<< FATAL - !!!!!!!!!!!!!!!!!!!!! TEST INCOMPLETE !!!!!!!!!!!!!!!!!!!!! >>" + e);
            driver.quit();
            throw new NullPointerException("********FATAL EXCEPTION TRIGGERED********");
        }
    }

    // BEFORE CLASS METHOD - BROWSER INITIALIZATION
    @BeforeClass
    public void beforeClass() throws Exception {
        browserFromXML = sBrowserTestData;
        // EXTENT REPORT
        extent = ExtentManager.CreateExtentReportExtent();
        className = this.getClass().getSimpleName();
        test = ExtentManager.CreateExtentReportTest(extent, className, testdatamap.get("TestDescription").toString(), browserFromXML, TestScriptID);
        // INITIALIZE DRIVER
        initializeDriver = new InitializeDriver();
        driver = initializeDriver.initDriver(browserFromXML);
        driverEvent = new EventFiringWebDriver(driver);

//        eventListener = new webDriverEventListener(test);
//        driverEvent.register(eventListener);
//        this.sBrowserTestData=browserFromXML;
//        this.driver=driverEvent;

        // INITIALIZE PAGE FACTORY OBJECT
        Pages = new Pages(driver, test);
        Log = new Log(driver, test);
        DBUtil = new DBUtil(driver, test);
        // LOG TEST MACHINE/USER DETAILS
        //Log.QAMachineInfo();
    }

    // AFTER CLASS
    @AfterClass
    public void afterClass() {
        extent.flush();
    }

    // AFTER TEST - NEED TO USE FOR LOGIN/LOGOUT HANDLING PURPOSE
    @AfterTest
    public void afterTest() {
        System.out.println("After test");
    }


}
