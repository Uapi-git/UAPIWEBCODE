/**
 * Test Script Name                      : ServiceManagementHeadsListPage.
 * Objective                             : Verify Service Management Heads List Functionality.
 * Version                               : 1.0
 * Author                                : Arun Kumar M S
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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ServiceManagementHeadsListPage extends BasePage {

    public ServiceManagementHeadsListPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Admin_ServiceManagementHeadsList_Page)
    public WebElement serviceHeadsListText;

    public boolean Exists() {
        return super.Exists(serviceHeadsListText);
    }

    // Method to click on Service Management
    public void clickOnServiceManagement(Log Log) {
        WebClick(UapiOR.Admin_ServiceManagement_Button);
        Log.ReportEvent("PASS", " Click on 'Service Management' menu is Successful");
        this.takeScreenShot();
    }

    // Method to click on Service Heads List
    public void clickOnServiceHeadList(Log Log) {
        WebClick(UapiOR.Admin_ServiceManagement_HeadsListButton);
        Log.ReportEvent("PASS", " Click on 'Service Head List' sub menu is Successful");
        this.takeScreenShot();
    }

    // Method to validate service Heads list Page
    public void verifyServiceHeadsListPageIsDisplayed(Log Log) {
        try {
            Thread.sleep(1000);
            verifyElementIsPresent(UapiOR.Admin_ServiceManagementHeadsList_Page);
            this.takeScreenShot();
            test.log(Status.PASS, "Verify Service Heads List page" + driver.getTitle() + "Verify Service Heads List page is Pass");
            Log.ReportEvent("PASS", "User Navigated to Service Heads List page");
            this.takeScreenShot();

        } catch (Exception e) {
            this.takeScreenShot();
            test.log(Status.FAIL, "Verify Service Heads List page" + driver.getTitle() + "Verify Service Heads List page is Fail");


        }
    }

    // Method to verify grid data is displayed
    public void verifyGridData(Log Log) throws Exception {
        try {
            Thread.sleep(2000);
            verifyElementIsPresent(UapiOR.Admin_ServiceManagementHeadsList_Page_GridData, "Service Heads List Grid Data");
            Log.ReportEvent("PASS", " verify Grid data In Service Heads List Screen is Successful");
        } catch (Exception e) {
            Log.ReportEvent("FAIL", " verify Grid data In Service Heads List Screen is UnSuccessful");
        }
    }

    // Method to click on pegination
    public void clickOnPegination() {
        WebClick(UapiOR.Admin_ServiceManagementHeadsList_Page_RowPerPage);
    }

    // Method to click on pegination
    public void selectPeginationValueFive(Log Log) {
        WebClick(UapiOR.Admin_ServiceManagementHeadsList_Page_FiveRowPerPage);
        Log.ReportEvent("PASS", " Select 'Rows per Page' = 5 In Service Heads List is Successful");
        this.takeScreenShot();

    }

    // Method to verify Selected row per page data
    public void verifySelectedRowPerPageData(Log Log) throws InterruptedException {
        try {
            List<WebElement> rowsPerPage = driver.findElements(By.xpath("//div[@role='row' and contains(@class,'MuiDataGrid-row')]"));
            int SecondPageRowCount = 0;
            if (CheckElementExists(UapiOR.Admin_ServiceManagementHeadsList_Page_NextPage_Disabled) == false) {
                Thread.sleep(2000);
                WebClick(UapiOR.Admin_ServiceManagementHeadsList_GoToNextPage);
                rowsPerPage = driver.findElements(By.xpath("//div[@role='row' and contains(@class,'MuiDataGrid-row')]"));
                SecondPageRowCount = rowsPerPage.size();
                this.takeScreenShot();
            }
            Thread.sleep(1000);
            WebClick(UapiOR.Admin_ServiceManagementHeadsList_GoToPreviousPage);
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
        WebClick(UapiOR.Admin_ServiceManagementHeadsList_Page_FirstRecordActionBtn);
        Log.ReportEvent("PASS", " Click on 'Action' option In Service Heads List is Successful");
        this.takeScreenShot();

    }

    // Method to click on View
    public void clickOnView(Log Log) {
        WebClick(UapiOR.Admin_ServiceManagementHeadsList_Page_View);
        Log.ReportEvent("PASS", "Click on View in Service Heads List Screen is successful");
        this.takeScreenShot();
    }

    // Method to click on Edit
    public void clickOnEdit(Log Log) {
        WebClick(UapiOR.Admin_ServiceManagementHeadsList_Page_Edit);
        Log.ReportEvent("PASS", "Click on Edit in Service Heads List Screen is successful");
        this.takeScreenShot();
    }

    //Method to verify Application discard the changes and redirect to Service Provider List Page
    public void verifyApplicationDiscardChangesAndRedirectsToServiceProviderListPage(String descriptionTest) throws IOException {

        VerifyValue1(getText(UapiOR.Admin_ServiceManagementHeadsList_Page_Description), descriptionTest);

    }

    // Method to click on Action Button
    public void clickOnActionButtonBasedOnServiceProviderName(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
        Thread.sleep(1000);
        WebClick("//h2[text()='" + testdatamap.get("ProviderName").toString() + "']/parent::div//following-sibling::div//*[@data-testid='MoreHorizIcon']");
        Log.ReportEvent("PASS", " Click on 'Action' option In Service Provider List is Successful");
        this.takeScreenShot();

    }

    /**
     * Method to verify view Mode after click on view from action list
     */
    public void verifyViewModeAfterClickOnViewFromActionList() {
        boolean isServiceHeadIdDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagementHeadsList_Page_ServiceHeadId)).getAttribute("class").contains("Mui-disabled");
        boolean isServiceHeadNameDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagementHeadsList_Page_ServiceHeadName)).getAttribute("class").contains("Mui-disabled");
        boolean isServiceHeadNameInArabicDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagementHeadsList_Page_ServiceHeadNameInArabic)).getAttribute("class").contains("Mui-disabled");
        boolean isServiceProviderNameDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagementHeadsList_Page_ServiceProviderName)).getAttribute("class").contains("Mui-disabled");
        boolean isDescriptionDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagementHeadsList_Page_Description)).getAttribute("class").contains("Mui-disabled");
        boolean isOriginalServiceHeadSectorDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagementHeadsList_Page_OriginalServiceHeadSector)).getAttribute("class").contains("Mui-disabled");
        boolean isOriginalServiceHeadNameInArabicDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagementHeadsList_Page_OriginalServiceHeadNameInArabic)).getAttribute("class").contains("Mui-disabled");
        boolean isOriginalServiceHeadNameDisabled = driver.findElement(By.xpath(UapiOR.Admin_ServiceManagementHeadsList_Page_OriginalServiceHeadName)).getAttribute("class").contains("Mui-disabled");

        Assert.assertTrue(isServiceHeadIdDisabled, "Service Head Id TextField is enabled");
        Assert.assertTrue(isServiceHeadNameDisabled, "Service Head Name TextField is enabled");
        Assert.assertTrue(isServiceHeadNameInArabicDisabled, "Service Head Arabic Name TextField is enabled");
        Assert.assertTrue(isServiceProviderNameDisabled, "Service Provider Name dropdown is enabled");
        Assert.assertTrue(isDescriptionDisabled, "Description TextField is enabled");
        Assert.assertTrue(isOriginalServiceHeadSectorDisabled, "Original Service Head Sector dropdown is enabled");
        Assert.assertTrue(isOriginalServiceHeadNameInArabicDisabled, "Original Service Head Name in Arabic TextField is enabled");
        Assert.assertTrue(isOriginalServiceHeadNameDisabled, "Original Service Head Name dropdown is enabled");


    }

}



