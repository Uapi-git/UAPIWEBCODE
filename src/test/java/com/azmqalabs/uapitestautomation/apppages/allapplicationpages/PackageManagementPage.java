/**
 * Test Script Name                      : PackageManagementPage.
 * Objective                             : Verify the Package Management Functionality.
 * Version                               : 1.0
 * Author                                : Basavaraj Mudnur
 * Created Date                          : 06/06/2024
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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.io.IOException;
import java.util.*;

public class PackageManagementPage extends BasePage {

    public PackageManagementPage(WebDriver driver, ExtentTest test) {
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
     * Click on package management menu
     * @param log<log> - Log
     */
    public void clickOnPackageManagementMenu(Log log) {
        try {
            WebClick(UapiOR.Admin_PackageManagementButton);
            VerifyValue1(getText(UapiOR.Admin_PackageManagement_AnnualSubscriptionButton), "Annual Subscription Tiers");
            test.log(Status.PASS, "#FUNC - Click on Package Management menu  " + " * Click on Package Management menu is Pass * ");
            log.ReportEvent("PASS", "Click on Package Management menu is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on Package Management menu " + " *Click on Package Management menu is Fail * ");
            this.takeScreenShot();
        }
    }


    /**
     * click on annual subscription tiers Menu
     * @param log<log> - Log
     * @throws IOException
     */
    public void clickOnAnnualSubscriptionTiersMenu(Log log) throws IOException, InterruptedException {
        try {
            WebClick(UapiOR.Admin_PackageManagement_AnnualSubscriptionButton);
            VerifyValue1(getText(UapiOR.Admin_PackageManagement_AnnualSubscriptionORServicesBundlesPage), "Annual Subscription Tiers");
            test.log(Status.PASS, "#FUNC - Click on 'Annual Subscription Tier' sub menu  " + " * Click on 'Annual Subscription Tier' sub menu is Pass * ");
            log.ReportEvent("PASS", "Click on 'Annual Subscription Tier' sub menu is successful");
            takeScreenShot();
            waitForTwoSec();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Annual Subscription Tier' sub menu " + driver.getTitle() + " *Click on 'Annual Subscription Tier' sub menu is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to verify Annual subscription tiers grid data
     * @param log <Log> - Log
     * @throws IOException
     */
    public void verifyAnnualSubscriptionTiersGridData(Log log) throws IOException {
        try {
            verifyElementIsPresent(UapiOR.Admin_PackageManagement_GridTable);
            test.log(Status.PASS, "#FUNC - Verify the data fields displays under Annual Subscription Tier table   " + " * Verify the data fields displays under Annual Subscription Tier table is Pass * ");
            log.ReportEvent("PASS", "Verify the data fields displays under Annual Subscription Tier table is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify the data fields displays under Annual Subscription Tier " + driver.getTitle() + " * Verify the data fields displays under Annual Subscription Tier table is fail * ");
        }
    }

    /**
     * Method to select rows per page
     * @param rowsPerPage <int> - Row per page
     * @param log <Log> - Log
     */
    public void selectRowsPerPage(int rowsPerPage,Log log) {
        try {
            WebClick(UapiOR.Admin_PackageManagement_TableRowsPerPage);
            WebElement option = driver.findElement(By.xpath("//li[@role='option' and text()='" + rowsPerPage + "']"));
            WebClick(option);
            test.log(Status.PASS, "#FUNC -  Select 'Rows per Page' = "+rowsPerPage+" " + " *  Select 'Rows per Page' = "+rowsPerPage+ " is Pass * ");
            log.ReportEvent("PASS", " Select 'Rows per Page' = " +rowsPerPage+ " is successful");
            takeScreenShot();
            waitForTwoSec();
        }
        catch (Exception e){
            test.log(Status.FAIL,  " Select 'Rows per Page' = "+rowsPerPage+" " + " *  Select 'Rows per Page' = "+rowsPerPage+ " is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on next page icon in table
     * @param log <Log> - Log
     */
    public void clickOnNextPageIconInTable(Log log) {
        try {
            WebClick(UapiOR.Admin_PackageManagement_GoToNextPage);
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
            WebClick(UapiOR.Admin_PackageManagement_GoToPreviousPage);
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
    public int getRowCountInPerPage(){
        int rowSize = driver.findElements(By.xpath("//div[@role='row']")).size();
        return rowSize - 1;
    }

    /**
     * Method to verify application retrieve data selected rows per page
     * @param expectedRowCount <int> Expected row count
     * @param log <Log> - Log
     */
    public void VerifyApplicationRetrievesDataSelectedRowsPerPage(int expectedRowCount,Log log) {
        try {
            Assert.assertEquals(getRowCountInPerPage(),expectedRowCount,"Row Counts are matching");
            test.log(Status.PASS, "#FUNC - Verify application retrieves the data " + " *  Verify application retrieves the data is Pass * ");
            log.ReportEvent("PASS", " Verify application retrieves the data is successful");
            takeScreenShot();
            waitForTwoSec();
        }
        catch (Exception e) {
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
            WebClick(UapiOR.Admin_PackageManagement_FirstRecordActionBtn);
            test.log(Status.PASS, "#FUNC - Click on 'Action' option " + " *  Click on 'Action' option is Pass * ");
            log.ReportEvent("PASS", "Click on 'Action' option is successful");
            takeScreenShot();
            waitForTwoSec();
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on 'Action' option " + " *  Click on 'Action' option is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on view option from action list
     * @param log <Log> - Log
     */
    public void clickOnViewOptionFromActionList(Log log){
        try {
            WebClick(UapiOR.Admin_PackageManagement_ActionListViewOption);
            test.log(Status.PASS, "#FUNC - Click on View " + " *  Click on View is Pass * ");
            log.ReportEvent("PASS", "Click on View is successful");
            waitForTwoSec();
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on View " + " *  Click on View is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify view Mode after click on view from action list
     */
    public void verifyViewModeAfterClickOnViewFromActionList(){
        boolean isPackageCodeDisabled = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackageCodeTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isPackageNameDisabled = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackageNameTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isPackageArabicNameDisabled = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackageArabicNameTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isPricePerPeriodDisabled = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PricePerPeriodTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isPackagePeriodDropdownDisabled = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackagePeriodDropdown + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isStatusDropdownDisabled = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_StatusDropdown + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isActivationDateCalendarDisabled = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_ActivationDateCalender + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        Assert.assertTrue(isPackageCodeDisabled, "Package Code TextField is enabled");
        Assert.assertTrue(isPackageNameDisabled, "Package Name TextField is enabled");
        Assert.assertTrue(isPackageArabicNameDisabled, "Package Arabic Name TextField is enabled");
        Assert.assertTrue(isPricePerPeriodDisabled, "Price Per Period TextField is enabled");
        Assert.assertTrue(isPackagePeriodDropdownDisabled, "Package Period Dropdown is enabled");
        Assert.assertTrue(isStatusDropdownDisabled, "Status Dropdown is enabled");
        Assert.assertTrue(isActivationDateCalendarDisabled, "Activation Date Calendar is enabled");
    }

    /**
     * Method to click on edit option from action list
     * @param log <Log> - Log
     */
    public void clickOnEditOptionFromActionList(Log log){
        try {
            scrollUptillstarting(driver);
            WebClick(UapiOR.Admin_PackageManagement_ActionListEditOption);
            test.log(Status.PASS, "#FUNC - Click on Edit " + " *  Click on Edit is Pass * ");
            log.ReportEvent("PASS", "Click on Edit is successful");
            waitForTwoSec();
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on Edit " + " *  Click on Edit is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify user redirected to annual subscription tier screen
     */
    public void verifyUserRedirectedToAnnualSubscriptionTireScreen() throws IOException {
        VerifyValue1(getText(UapiOR.Admin_PackageManagement_AnnualSubscriptionORServicesBundlesPage), "Annual Subscription Tiers");
    }

    /**
     * Method to click on add package button
     */
    public void clickOnAddPackageButton(Log log){
        try{
            WebClick(UapiOR.Admin_PackageManagement_AddPackageButton);
            test.log(Status.PASS, "#FUNC - Click on 'Add Package' " + " * Click on 'Add Package' is Pass * ");
            log.ReportEvent("PASS", "Click on 'Add Package' is successful");
            waitForTwoSec();
            takeScreenShot();
            waitForTwoSec();
        }
        catch (Exception e){
            test.log(Status.FAIL, "#FUNC - Click on 'Add Package' " + " * Click on 'Add Package' is fail * ");
        }
    }

    /**
     * Method to verify newly added package displayed in table
     */
    public void verifyNewlyAddedPackageDisplayedInTable(Map<Object, Object> testDataMap) throws InterruptedException {
        Thread.sleep(1000);
        int pageCount = Integer.parseInt(getText(UapiOR.Admin_PackageManagement_Pages).replaceFirst(".*of (\\d+).*", "$1"));
        int pages = pageCount / 10;
        if (1 <= pages) {
            for (int n = 1; n <= pages; n++) {
                WebClick(UapiOR.Admin_PackageManagement_GoToNextPage);
                Thread.sleep(1000);
            }
            takeScreenShot();
            Thread.sleep(1000);
            int latestPackagesIndex = driver.findElements(By.xpath(UapiOR.Admin_PackageManagement_GridPackageNames)).size();
            String latestPackage = driver.findElement(By.xpath("(//div[@role='gridcell' and @data-field='name'])" + "[" + latestPackagesIndex + "]")).getText();
            Assert.assertEquals(testDataMap.get("PackageName").toString(),latestPackage);
        }
        else{
            takeScreenShot();
            int latestPackagesIndex = driver.findElements(By.xpath(UapiOR.Admin_PackageManagement_GridPackageNames)).size();
            String latestPackage = driver.findElement(By.xpath("(//div[@role='gridcell' and @data-field='name'])" + "[" + latestPackagesIndex + "]")).getText();
            Assert.assertEquals(testDataMap.get("PackageName").toString(),latestPackage);

        }
    }

    /**
     * Method to verify newly added package displayed in table
     * testDataMap <Map> - Test Data Map
     */
    public void verifyEditedPackageDisplayedInTable(Map<Object, Object> testDataMap) {
        int pageCount = Integer.parseInt(getText(UapiOR.Admin_PackageManagement_Pages).replaceFirst(".*of (\\d+).*", "$1"));
        int pages = pageCount / 10;
        if (1 <= pages) {
            for (int n = 1; n <= pages; n++) {
                WebClick(UapiOR.Admin_PackageManagement_GoToNextPage);
            }
            takeScreenShot();
            int latestPackagesIndex = driver.findElements(By.xpath(UapiOR.Admin_PackageManagement_GridPackageNames)).size();
            String latestPackage = driver.findElement(By.xpath("(//div[@role='gridcell' and @data-field='name'])" + "[" + latestPackagesIndex + "]")).getText();
            Assert.assertEquals(testDataMap.get("ModifiedPackageName").toString(),latestPackage);
        }
        else{
            takeScreenShot();
            int latestPackagesIndex = driver.findElements(By.xpath(UapiOR.Admin_PackageManagement_GridPackageNames)).size();
            String latestPackage = driver.findElement(By.xpath("(//div[@role='gridcell' and @data-field='name'])" + "[" + latestPackagesIndex + "]")).getText();
            Assert.assertEquals(testDataMap.get("ModifiedPackageName").toString(),latestPackage);

        }
    }

    /**
     * Method to click on first record action button
     * @param log <Log> - log
     */
    public void clickOnActionButton(Log log) {
        try {
            int pageCount = Integer.parseInt(getText(UapiOR.Admin_PackageManagement_Pages).replaceFirst(".*of (\\d+).*", "$1"));
            int pages = pageCount / 10;
            if (1 <= pages) {
                for (int n = 1; n <= pages; n++) {
                    WebClick(UapiOR.Admin_PackageManagement_GoToNextPage);
                }
                takeScreenShot();
                int latestPackagesIndex = driver.findElements(By.xpath(UapiOR.Admin_PackageManagement_GridPackageNames)).size();
                driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='MoreHorizIcon'])" + "[" + latestPackagesIndex + "]")).click();

            }
            else{
                takeScreenShot();
                int latestPackagesIndex = driver.findElements(By.xpath(UapiOR.Admin_PackageManagement_GridPackageNames)).size();
                driver.findElement(By.xpath("(//*[local-name()='svg' and @data-testid='MoreHorizIcon'])" + "[" + latestPackagesIndex + "]")).click();
            }
            test.log(Status.PASS, "#FUNC - Click on 'Action' option " + " *  Click on 'Action' option is Pass * ");
            log.ReportEvent("PASS", "Click on 'Action' option is successful");
            takeScreenShot();
            waitForTwoSec();
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on 'Action' option " + " *  Click on 'Action' option is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on delete option from action list
     * @param log <Log> - Log
     */
    public void clickOnDeleteOptionFromActionList(Log log){
        try {
            WebClick(UapiOR.Admin_PackageManagement_ActionListDeleteOption);
            test.log(Status.PASS, "#FUNC - Click on Delete " + " *  Click on Delete is Pass * ");
            log.ReportEvent("PASS", "Click on Delete is successful");
            waitForTwoSec();
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on Delete " + " *  Click on Delete is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify delete confirmation popUp is displayed
     */
    public void verifyDeleteConfirmationPopUpIsDisplayed() throws Exception {
        verifyElementIsPresent(UapiOR.Admin_PackageManagement_DeleteConfirmationPopUp,"Delete Confirmation Popup is not displayed");
    }

    /**
     * Method to click on delete confirmation popup yes button
     */
    public void clickOnDeleteConfirmationYesButton() throws InterruptedException {
        WebClick(UapiOR.Admin_PackageManagement_DeleteConfirmationYesButton);
        waitForTwoSec();
        takeScreenShot();
    }

    /**
     * Method to verify Package Deleted Successful Msg
     */
    public void verifyPackageDeletedSuccessfulMsg() {
        Assert.assertEquals(getText(UapiOR.Admin_PackageManagement_PackageDeleteMsg),"Package deleted successfully!");
    }

    /**
     * Method to verify Package Deleted Successful Msg
     */
    public void verifyPackageDeleteErrorMSGForAlreadyUsedPackage(Log log) {
        try {
            Assert.assertEquals(getText(UapiOR.Admin_PackageManagement_PackageDeleteMsg), "Package is already used. Please disassociate this package from companies before deleting this");
            test.log(Status.PASS, "#FUNC - Verify Error Message" + " * Verify Error Message is Pass *");
            log.ReportEvent("PASS", "Verify Error Message is successful");
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL,"#FUNC - Verify Error Message" + " * Verify Error Message is fail *");
        }

    }

    /**
     * Method to Verify Cancel And Save Button Are Available
     */
    public void VerifyCancelAndSaveButtonAreAvailable(Log log) {
        try {
            WebElement cancelButton = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_AddOrEditFormCancelButton));
            scrollToElement(driver,cancelButton);
            verifyElementIsPresent(UapiOR.Admin_PackageManagement_AddOrEditFormCancelButton, "Cancel button is not available");
            verifyElementIsPresent(UapiOR.Admin_PackageManagement_AddOrEditFormSaveButton, "Save button is not available");
            test.log(Status.PASS, "#FUNC - Verify Cancel and Save button are available " + " * Verify Cancel and Save button are available is Pass * ");
            log.ReportEvent("PASS", "Verify Cancel and Save button are available is successful");
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL, "#FUNC - Verify Cancel and Save button are available " + " * Verify Cancel and Save button are available is fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on delete confirmation popup yes button option from action list
     */
    public void clickOnAddOrEditCancelButton(Log log) {
        try {
            WebElement cancelButton = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_AddOrEditFormCancelButton));
            scrollToElement(driver,cancelButton);
            WebClickUsingJS(UapiOR.Admin_PackageManagement_AddOrEditFormCancelButton);
            test.log(Status.PASS, "#FUNC - Click on 'Cancel' button " + " * Click on 'Cancel' button is Pass * ");
            log.ReportEvent("PASS", "Click on 'Cancel' button is successful");
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL, "#FUNC - Click on 'Cancel' button " + " * Click on 'Cancel' button is fail * ");
        }
    }

    /**
     * click on Services Bundles Menu
     * @param log<log> - Log
     * @throws IOException
     */
    public void clickOnServicesBundlesMenu(Log log){
        try {
            WebClick(UapiOR.Admin_PackageManagement_ServicesBundlesButton);
            VerifyValue1(getText(UapiOR.Admin_PackageManagement_ServicesBundlesPage), "Services Bundles");
            test.log(Status.PASS, "#FUNC - Click on 'Services Bundles'  " + " * Click on 'Services Bundles' is Pass * ");
            log.ReportEvent("PASS", "Click on 'Services Bundles' is successful");
            takeScreenShot();
            waitForTwoSec();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Services Bundles' " + driver.getTitle() + " *Click on 'Services Bundles' is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to verify ServicesBundlesGrid grid data
     * @param log <Log> - Log
     * @throws IOException
     */
    public void verifyServicesBundlesGridData(Log log) throws IOException {
        try {
            verifyElementIsPresent(UapiOR.Admin_PackageManagement_GridTable);
            test.log(Status.PASS, "#FUNC - Verify the data fields displays under Services Bundles table   " + " * Verify the data fields displays under Services Bundles table is Pass * ");
            log.ReportEvent("PASS", "Verify the data fields displays under Services Bundles table is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify the data fields displays under Services Bundles table " + driver.getTitle() + " * Verify the data fields displays under Services Bundles table is fail * ");
        }
    }

    /**
     * Method to verify view Mode after click on view from action list
     */
    public void verifyServicesBundlesViewModeAfterClickOnViewFromActionList(){
        boolean isPackageCodeDisabled = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackageCodeTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isPackageNameDisabled = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackageNameTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isPackageArabicNameDisabled = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackageArabicNameTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isPricePerPeriodDisabled = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PricePerPeriodTextField + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isPackagePeriodDropdownDisabled = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_PackagePeriodDropdown + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        boolean isStatusDropdownDisabled = driver.findElement(By.xpath(UapiOR.Admin_PackageManagement_StatusDropdown + "/parent::div")).getAttribute("class").contains("Mui-disabled");
        Assert.assertTrue(isPackageCodeDisabled, "Package Code TextField is enabled");
        Assert.assertTrue(isPackageNameDisabled, "Package Name TextField is enabled");
        Assert.assertTrue(isPackageArabicNameDisabled, "Package Arabic Name TextField is enabled");
        Assert.assertTrue(isPricePerPeriodDisabled, "Price Per Period TextField is enabled");
        Assert.assertTrue(isPackagePeriodDropdownDisabled, "Package Period Dropdown is enabled");
        Assert.assertTrue(isStatusDropdownDisabled, "Status Dropdown is enabled");
    }

    public void verifyAnnualSubscriptionTiersAndServiceBundlesMenu(Log log){
        try {
            Assert.assertEquals(getText(UapiOR.Admin_PackageManagement_AnnualSubscriptionButton),"Annual Subscription Tiers");
            Assert.assertEquals(getText(UapiOR.Admin_PackageManagement_ServicesBundlesButton),"Services Bundles");
            test.log(Status.PASS, "Verify sub menu options" + " * Verify sub menu options is Pass  * ");
            log.ReportEvent("PASS", "Verify sub menu options is successful");
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL, "Verify sub menu options " + " * Verify sub menu options is fail * ");
        }

    }

    /**
     * Method to verify user redirected to services bundles screen
     */
    public void verifyUserRedirectedToServicesBundlesScreen() throws IOException {
        VerifyValue1(getText(UapiOR.Admin_PackageManagement_AnnualSubscriptionORServicesBundlesPage), "Services Bundles");
    }

}
