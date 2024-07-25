/**
 * Test Script Name                      : ServiceManagementServicesListPage.
 * Objective                             : Verify Service Management Services List Functionality.
 * Version                               : 1.0
 * Author                                : Arun Kumar M S
 * Created Date                          : 28/06/2024
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

import java.util.List;

public class ServiceManagementServicesListPage extends BasePage {

    public ServiceManagementServicesListPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Admin_ServiceManagement_ServicesList_Page)
    public WebElement servicesListText;

    public boolean Exists() {
        return super.Exists(servicesListText);
    }

    // Method to click on Services List
    public void clickOnServicesList(Log Log) {
        WebClick(UapiOR.Admin_ServiceManagement_ServicesListButton);
        Log.ReportEvent("PASS", " Click on 'Services List' sub menu is Successful");
        this.takeScreenShot();
    }

    // Method to validate services list Page
    public void verifyServicesListPageIsDisplayed(Log Log) {
        try {
            Thread.sleep(1000);
            verifyElementIsPresent(UapiOR.Admin_ServiceManagement_ServicesList_Page);
            this.takeScreenShot();
            test.log(Status.PASS, "Verify Services List page" + driver.getTitle() + "Verify Services List page is Pass");
            Log.ReportEvent("PASS", "User Navigated to Services List page");
            this.takeScreenShot();

        } catch (Exception e) {
            this.takeScreenShot();
            test.log(Status.FAIL, "Verify Services List page" + driver.getTitle() + "Verify Services List page is Fail");


        }
    }

    // Method to verify grid data is displayed
    public void verifyGridData(Log Log) throws Exception {
        try {
            Thread.sleep(2000);
            verifyElementIsPresent(UapiOR.Admin_ServiceManagement_ServicesList_Page_GridData, "Services List Grid Data");
            Log.ReportEvent("PASS", " verify Grid data In Services List Screen is Successful");
            Thread.sleep(2000);
        } catch (Exception e) {
            Log.ReportEvent("FAIL", " verify Grid data In Services List Screen is UnSuccessful");
        }
    }

    // Method to click on pegination
    public void clickOnPegination() {
        WebClick(UapiOR.Admin_ServiceManagement_ServicesList_Page_RowPerPage);
    }

    // Method to click on pegination
    public void selectPeginationValueFive(Log Log) {
        WebClick(UapiOR.Admin_ServiceManagement_ServicesList_Page_FiveRowPerPage);
        Log.ReportEvent("PASS", " Select 'Rows per Page' = 5 In Services List is Successful");
        this.takeScreenShot();

    }

    // Method to verify Selected row per page data
    public void verifySelectedRowPerPageData(Log Log) throws InterruptedException {
        try {
            List<WebElement> rowsPerPage = driver.findElements(By.xpath("//div[@role='row' and contains(@class,'MuiDataGrid-row')]"));
            int SecondPageRowCount = 0;
            if (CheckElementExists(UapiOR.Admin_ServiceManagement_ServicesList_Page_NextPage_Disabled) == false) {
                Thread.sleep(2000);
                WebClick(UapiOR.Admin_ServiceManagement_ServiceList_GoToNextPage);
                rowsPerPage = driver.findElements(By.xpath("//div[@role='row' and contains(@class,'MuiDataGrid-row')]"));
                SecondPageRowCount = rowsPerPage.size();
                this.takeScreenShot();
            }
            Thread.sleep(1000);
            WebClick(UapiOR.Admin_ServiceManagement_ServicesList_GoToPreviousPage);
            int firstPageRowCount = rowsPerPage.size();
            Assert.assertEquals(SecondPageRowCount, firstPageRowCount);
            test.log(Status.PASS, "verify rows per page count retrieve correctly In Service Heads List Page" + driver.getTitle() + " * verify rows per page count retrieve correctly PASS * ");
            Log.ReportEvent("PASS", " verify rows per page count retrieve correctly In Service Heads List is Successful");
            this.takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "verify rows per page count retrieve correctly In Service Heads List Page" + driver.getTitle() + " * verify rows per page count retrieve correctly FAIL * ");
            this.takeScreenShot();
        }
    }

    // Method to click on Action Button
    public void clickOnActionButton(Log Log) throws InterruptedException {
        Thread.sleep(1000);
        WebClick(UapiOR.Admin_ServiceManagement_ServicesList_Page_FirstRecordActionBtn);
        Log.ReportEvent("PASS", " Click on 'Action' option In Services List is Successful");
        this.takeScreenShot();

    }

    // Method to click on View
    public void clickOnView(Log Log) {
        WebClick(UapiOR.Admin_ServiceManagement_ServicesList_Page_View);
        Log.ReportEvent("PASS", "Click on View in Services List Screen is successful");
        this.takeScreenShot();
    }

    // Method to click on Edit
    public void clickOnEdit(Log Log) {
        WebClick(UapiOR.Admin_ServiceManagement_ServicesList_Page_Edit);
        Log.ReportEvent("PASS", "Click on Edit in Services List Screen is successful");
        this.takeScreenShot();
    }

    /**
     * Method to verify view Mode after click on view from action list
     */
    public void verifyViewModeAfterClickOnViewFromActionList() {
        boolean isServiceIdDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagement_ServicesList_Page_ServiceId)).getAttribute("class").contains("Mui-disabled");
        boolean isServiceNameDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagement_ServicesList_Page_ServiceName)).getAttribute("class").contains("Mui-disabled");
        boolean isServiceNameInArabicDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagement_ServicesList_Page_ServiceNameInArabic)).getAttribute("class").contains("Mui-disabled");
        boolean isServiceProviderNameDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagement_ServicesList_Page_ServiceProviderName)).getAttribute("class").contains("Mui-disabled");
        boolean isOriginalServiceProviderNameDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagement_ServicesList_Page_OriginalServiceProvider)).getAttribute("class").contains("Mui-disabled");
        boolean isOriginalServiceProviderSectorDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagement_ServicesList_Page_OriginalServiceProviderSector)).getAttribute("class").contains("Mui-disabled");
        boolean isStatusDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagement_ServicesList_Page_Status)).getAttribute("class").contains("Mui-disabled");
        boolean isServiceHeadNameDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagement_ServicesList_Page_ServiceHeadName)).getAttribute("class").contains("Mui-disabled");

        Assert.assertTrue(isServiceIdDisabled, "Service Id TextField is enabled");
        Assert.assertTrue(isServiceNameDisabled, "Service Name TextField is enabled");
        Assert.assertTrue(isServiceNameInArabicDisabled, "Service Arabic Name TextField is enabled");
        Assert.assertTrue(isServiceProviderNameDisabled, "Service Provider Name dropdown is enabled");
        Assert.assertTrue(isOriginalServiceProviderNameDisabled, "Original Service Provider Name TextField is enabled");
        Assert.assertTrue(isOriginalServiceProviderSectorDisabled, "Original Service Provider Sector dropdown is enabled");
        Assert.assertTrue(isStatusDisabled, "Status dropdown is enabled");
        Assert.assertTrue(isServiceHeadNameDisabled, "Service Name dropdown is enabled");

    }

}



