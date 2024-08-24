/**
 * Test Script Name                      : PackageManagementPage.
 * Objective                             : Verify the Package Management Functionality.
 * Version                               : 1.0
 * Author                                : Basavaraj Mudnur
 * Created Date                          : 09/07/2024
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

public class CustomerPackageManagementPage extends BasePage {

    public CustomerPackageManagementPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Customer_PackageManagementPage_AddPackageButton)
    public WebElement addPackageButton;

    public boolean Exists() {
        return super.Exists(addPackageButton);
    }

    /**
     * Click on package management menu
     * @param log<log> - Log
     */
    public void clickOnPackageManagementMenu(Log log) {
        try {
            WebClick(UapiOR.Customer_PackageManagement_Menu);
            VerifyValue1(getText(UapiOR.Customer_PackageManagementPage_Header), "Package Management");
            test.log(Status.PASS, "#FUNC - Click on Package Management menu  " + " * Click on Package Management menu is Pass * ");
            log.ReportEvent("PASS", "Click on Package Management menu is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on Package Management menu " + " *Click on Package Management menu is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to search annual package name
     * @param testDataMap <Map> - Test data map
     * @param log         <Log> - Log
     */
    public void searchAnnualPackageName(Map<Object, Object> testDataMap, Log log) {
        try {
            WebEdit(UapiOR.Customer_PackageManagementPage_PackageNameSearchField, testDataMap.get("SearchFieldInput").toString());
            WebClick(UapiOR.Customer_PackageManagementPage_PackageNameSearchBtn);
            test.log(Status.PASS, "#FUNC -  Enter search keyword in Search Package Name " + " *  Enter search keyword in Search Package Name is Pass * ");
            log.ReportEvent("PASS", " Enter search keyword in Search Package Name is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.PASS, " Enter search keyword in Search Package Name " + " *   Enter search keyword in Search Package Name is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to search Service package name
     * @param testDataMap <Map> - Test data map
     * @param log         <Log> - Log
     */
    public void searchServicePackageName(Map<Object, Object> testDataMap, Log log) {
        try {
            WebEdit(UapiOR.Customer_PackageManagementPage_ServiceBundlePackageNameSearchField, testDataMap.get("SearchFieldInput").toString());
            WebClick(UapiOR.Customer_PackageManagementPage_ServiceBundlePackageNameSearchBtn);
            test.log(Status.PASS, "#FUNC -  Enter search keyword in Search Package Name " + " *  Enter search keyword in Search Package Name is Pass * ");
            log.ReportEvent("PASS", " Enter search keyword in Search Package Name is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.PASS, " Enter search keyword in Search Package Name " + " *   Enter search keyword in Search Package Name is Fail * ");
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
            WebClick(UapiOR.Customer_PackageManagementPage_SelectPackageStatusBtn);
            WebClick("//li[@data-value='" + testdatamap.get("SelectPackageStatusOption").toString() + "']");
            test.log(Status.PASS, "#FUNC - Select Package Status " + " * Select Package Status is Pass * ");
            log.ReportEvent("PASS", "Select Package Status' is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.PASS, "Select Package Status' " + " * Select Package Status is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to Click on search field clear Button
     * @param log <log> - Log
     */
    public void clickOnSearchFieldClearBtn(Log log) {
        try {
            WebClick(UapiOR.Customer_PackageManagementPage_PackageNameClearBtn);
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
     * Method to verify cleared value of package name search field
     * @param log <log> - Log
     */
    public void VerifyClearedValueOfPackageNameSearchField(Log log) {
        try {
            VerifyValue1(driver.findElement(By.xpath(UapiOR.Customer_PackageManagementPage_PackageNameSearchField)).getAttribute("value"), "");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify retrieved data is cleared " + " * Verify retrieved data is cleared is Fail * ");
            this.takeScreenShot();
        }
    }

    /**
     * Used to store package management grid data
     */
    public List<Map<String, Object>> packageManagementGridData = new ArrayList<>();

    /**
     * Method to parse package management grid data
     */
    public void parseAnnualPackageManagementGridData() throws InterruptedException {
        int totalCount = 0; // Total count of records processed across all pages
        // Process each page
        while (true) {
            waitForTwoSec();
            List<WebElement> annualSubscriptionGridRecordsElement = driver.findElements(By.xpath("//input/preceding::div[@role='row']"));
            List<WebElement> annualSubscriptionGridDataElement = driver.findElements(By.xpath("//input/preceding::div[@role='gridcell']"));
            // Process each row on the current page
            for (int i = 0; i < annualSubscriptionGridDataElement.size(); i += 8) {
                Map<String, Object> record = new HashMap<>(); // Create a new map for each row
                // Populate record with data for the current row
                record.put("Package Name", annualSubscriptionGridDataElement.get(i).getText());
                record.put("Price", annualSubscriptionGridDataElement.get(i + 1).getText());
                record.put("Transaction Limit", annualSubscriptionGridDataElement.get(i + 2).getText());
                record.put("Transaction Consumption", annualSubscriptionGridDataElement.get(i + 3).getText());
                record.put("Status", annualSubscriptionGridDataElement.get(i + 4).getText());
                record.put("Activation Date", annualSubscriptionGridDataElement.get(i + 5).getText());
                record.put("Validity", annualSubscriptionGridDataElement.get(i + 6).getText());
                record.put("record", annualSubscriptionGridRecordsElement.get(i / 8));
                packageManagementGridData.add(record);

                totalCount++; // Increment the total count
            }
            // Check if there's a next page
            if (!IsDispalyed(UapiOR.Customer_PackageManagementPage_AnnualPackageGridGoToNextIcon)) {
                break; // Exit the loop if there's no next page
            }
            // Click the next page button
            WebClick(UapiOR.Customer_PackageManagementPage_AnnualPackageGridGoToNextIcon);
        }
        System.out.println("Total records processed: " + totalCount);
        System.out.println("Package Management table: " + packageManagementGridData);
    }

    /**
     * Method to parse package management grid data
     */
    public void parseServiceBundlePackageManagementGridData() throws InterruptedException {
        int totalCount = 0; // Total count of records processed across all pages
        // Process each page
        while (true) {
            waitForTwoSec();
            List<WebElement> annualSubscriptionGridRecordsElement = driver.findElements(By.xpath("//input/following::div[@role='row']"));
            List<WebElement> annualSubscriptionGridDataElement = driver.findElements(By.xpath("//input/following::div[@role='gridcell']"));
            // Process each row on the current page
            for (int i = 0; i < annualSubscriptionGridDataElement.size(); i += 8) {
                Map<String, Object> record = new HashMap<>(); // Create a new map for each row
                // Populate record with data for the current row
                record.put("Package Name", annualSubscriptionGridDataElement.get(i).getText());
                record.put("Price", annualSubscriptionGridDataElement.get(i + 1).getText());
                record.put("Available Amount", annualSubscriptionGridDataElement.get(i + 2).getText());
                record.put("Price Consumption", annualSubscriptionGridDataElement.get(i + 3).getText());
                record.put("Status", annualSubscriptionGridDataElement.get(i + 4).getText());
                record.put("Activation Date", annualSubscriptionGridDataElement.get(i + 5).getText());
                record.put("Validity", annualSubscriptionGridDataElement.get(i + 6).getText());
                record.put("record", annualSubscriptionGridRecordsElement.get(i / 8));
                packageManagementGridData.add(record);

                totalCount++; // Increment the total count
            }
            // Check if there's a next page
            if (!IsDispalyed(UapiOR.Customer_PackageManagementPage_ServiceBundlePackageGridGoToNextIcon)) {
                break; // Exit the loop if there's no next page
            }
            // Click the next page button
            WebClick(UapiOR.Customer_PackageManagementPage_ServiceBundlePackageGridGoToNextIcon);
        }
        System.out.println("Total records processed: " + totalCount);
        System.out.println("Package Management table: " + packageManagementGridData);
    }

    /**
     * Method to back to first page after parse
     * @throws InterruptedException
     */
    public void backToFirstPageAfterParse() throws InterruptedException {
        int pageCount = Integer.parseInt(getText("//input/preceding::div[@role='grid']/following-sibling::div//p").replaceFirst(".*of (\\d+).*", "$1"));
        int pages = pageCount / 5;
        if (1 <= pages) {
            for (int n = 1; n <= pages; n++) {
                if (!getElement(UapiOR.Customer_PackageManagementPage_AnnualPackageGridGoToPreviousIcon).getAttribute("class").contains("Mui-disabled"))
                WebClick(UapiOR.Customer_PackageManagementPage_AnnualPackageGridGoToPreviousIcon);
                waitForTwoSec();
            }
        }
    }

    /**
     * Method to verify package management grid record data
     * @param testDataMap <Map> - Test data map
     * @param rowNumber   <int> - Row number
     * @param log         <Log> - Log
     */
    public void verifyPackageManagementGridRecordData(int rowNumber, Map<Object, Object> testDataMap, Log log) {
        try {
            Assert.assertEquals(packageManagementGridData.get(rowNumber - 1).get(testDataMap.get("ColumnName").toString()).toString(), testDataMap.get("SearchedData").toString());
            test.log(Status.PASS, "#FUNC - Verify filtered data  " + " * Verify filtered data is Pass * ");
            log.ReportEvent("PASS", "Verify filtered data is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.PASS, "Verify filtered data  " + " * Verify filtered data is Fail * ");
        }
    }

    /**
     * Method to verify no rows message
     *@param log <Log> - Log
     */
    public void verifyNoRowsMessage(Log log) {
        try {
            Assert.assertEquals(getText(UapiOR.Customer_GridRecordNoRowsMessage),"No rows");
            test.log(Status.PASS, "#FUNC - verify system message " + " * verify system message is Pass * ");
            log.ReportEvent("PASS", "verify system message is successful");
            takeScreenShot();
        } catch (Exception e) {
            takeScreenShot();
            test.log(Status.FAIL, "verify system message " + " * verify system message is Fail * ");
        }
    }

    /**
     * Method to click on first record action button
     * @param log <Log> - log
     */
    public void clickOnFirstRecordActionButton(Log log) {
        try {
            scrollUptillstarting(driver);
            WebClick(UapiOR.Customer_FirstRecordActionBtn);
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
            WebClick(UapiOR.Customer_ViewBtn);
            test.log(Status.PASS, "#FUNC - Click on View " + " *  Click on View is Pass * ");
            log.ReportEvent("PASS", "Click on View is successful");
            waitForTwoSec();
            takeScreenShot();
            Assert.assertEquals(getElement(UapiOR.Customer_PackageManagementPage_PackageDetail).getText(),"Package Detail");
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on View " + " *  Click on View is Fail * ");
            takeScreenShot();
        }
    }
    /**
     * Method to click on package details close button
     * @param log <Log> - Log
     */
    public void clickOnPackageDetailsCloseBtn(Log log){
        try {
            WebClick(UapiOR.Customer_PackageManagementPage_PackageDetails_CloseBtn);
            waitForTwoSec();
            takeScreenShot();
            Thread.sleep(1000);
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on package details popup close button " + " *  Click on package details popup close button is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify package details after click on view
     * @param rowNo <int> Row no
     * @param log <Log> - Log
     * @throws Exception
     */
    public void verifyPackageDetailsAfterClickOnView(int rowNo,Log log) throws Exception {
        try {
            String expectedPackageName = packageManagementGridData.get(rowNo - 1).get("Package Name").toString();
            String expectedPrice = packageManagementGridData.get(rowNo - 1).get("Price").toString().replace(",", "").replace(".0", "");
            String expectedTransactionLimit = packageManagementGridData.get(rowNo - 1).get("Transaction Limit").toString();
            String expectedTransactionConsumption = packageManagementGridData.get(rowNo - 1).get("Transaction Consumption").toString();
            String expectedActivationDate = packageManagementGridData.get(rowNo - 1).get("Activation Date").toString();
            String expectedStatus = packageManagementGridData.get(rowNo - 1).get("Status").toString();
            Assert.assertEquals(getText(UapiOR.Customer_PackageManagementPage_PackageDetails_PackageNameValue), expectedPackageName);
            Assert.assertEquals(getText(UapiOR.Customer_PackageManagementPage_PackageDetails_PriceValue), expectedPrice);
            Assert.assertEquals(getText(UapiOR.Customer_PackageManagementPage_PackageDetails_TransactionLimitValue), expectedTransactionLimit);
            Assert.assertEquals(getText(UapiOR.Customer_PackageManagementPage_PackageDetails_TransactionConsumptionValue), expectedTransactionConsumption);
            Assert.assertEquals(getText(UapiOR.Customer_PackageManagementPage_PackageDetails_ActivationDateValue), expectedActivationDate);
            Assert.assertEquals(getText(UapiOR.Customer_PackageManagementPage_PackageDetails_StatusValue), expectedStatus);
            VerifyValue1(getText(UapiOR.Customer_PackageManagementPage_PackageDetails_PackageNameValue), expectedPackageName);
            VerifyValue1(getText(UapiOR.Customer_PackageManagementPage_PackageDetails_PriceValue), expectedPrice);
            VerifyValue1(getText(UapiOR.Customer_PackageManagementPage_PackageDetails_TransactionLimitValue), expectedTransactionLimit);
            VerifyValue1(getText(UapiOR.Customer_PackageManagementPage_PackageDetails_TransactionConsumptionValue), expectedTransactionConsumption);
            VerifyValue1(getText(UapiOR.Customer_PackageManagementPage_PackageDetails_ActivationDateValue), expectedActivationDate);
            VerifyValue1(getText(UapiOR.Customer_PackageManagementPage_PackageDetails_StatusValue), expectedStatus);
            test.log(Status.PASS, "#FUNC - Verify Package Details " + " *  Verify Package Details is Pass * ");
            log.ReportEvent("PASS", "Verify Package Details is successful");
        }
        catch (Exception e){
            test.log(Status.FAIL, "Verify Package Details " + " *  Verify Package Details is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on add package button
     * @param log <Log> - Log
     */
    public void clickOnAddPackageButton(Log log) {
        try {
            WebClick(UapiOR.Customer_PackageManagementPage_AddPackageButton);
            test.log(Status.PASS, "#FUNC - Click on Add Package" + " * Click on Add Package is Pass * ");
            log.ReportEvent("PASS", "Click on Add Package is successful");
            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_Header), "Add package");
            takeScreenShot();
            waitForTwoSec();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on Add Package " + " *Click on Add Package is Fail* ");
            takeScreenShot();
        }
    }

    /**
     * Method verify user redirected to package management page
     * @throws IOException
     */
    public void verifyUserRedirectedToPackageManagementPage() throws IOException {
        Assert.assertEquals(getText(UapiOR.Customer_PackageManagementPage_Header), "Package Management");
        VerifyValue1(getText(UapiOR.Customer_PackageManagementPage_Header), "Package Management");

    }

    /**
     * Variable to store the subscribed package name
     */
    public String subscribedName = "";

    /**
     * Method to get subscribed package name
     * @return subscribedName <String> - Subscribed name
     */
    public String getSubscribedPackageName() {
        return subscribedName = getText(UapiOR.Customer_AddPackagePage_SubscribedPackageName);
    }

    /**
     * Method to set generated invoice package name
     * @param testDataMap <Map> - Test data map
     * @return subscribedName <String> - Subscribed name
     */
    public String setGeneratedInvoicePackageName(Map<Object,Object> testDataMap) {
        return subscribedName = testDataMap.get("PackageToGenerateInvoice").toString();
    }

    /**
     * Method to verify record is saved after renew or generate invoice for the package
     * @param log <Log> - Log
     */
    public void VerifyRecordIsSavedAfterRenewOrGenerateInvoiceForThePackage(Log log) {
        try {
            waitForTwoSec();
            parseAnnualPackageManagementGridData();
            int latestPackageNo = packageManagementGridData.size() - 1;
            String actualPackageName = packageManagementGridData.get(latestPackageNo).get("Package Name").toString();
            VerifyValue1(actualPackageName, subscribedName);
            Assert.assertEquals(actualPackageName, subscribedName);
            test.log(Status.PASS, "#FUNC -Verify record is saved " + " *  Verify record is saved is Pass * ");
            log.ReportEvent("PASS", "Verify record is saved is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify record is saved " + " * Verify record is saved is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify record status after renew or generate invoice for the package
     * @param log <Log> - Log
     */
    public void VerifyRecordStatusAfterRenewOrGenerateInvoiceForThePackageForServicesBundle(String status,Log log) {
        try {
            mouseOver(driver,getElement("//div[@role='grid']/following-sibling::div//p"));
            parseServiceBundlePackageManagementGridData();
            int latestPackageNo = packageManagementGridData.size() - 1;
            String actualPackageName = packageManagementGridData.get(latestPackageNo).get("Status").toString();
            VerifyValue1(actualPackageName, status);
            Assert.assertEquals(actualPackageName, status);
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify record status " + status + " * Verify record status"+status+" is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify record status after renew or generate invoice for the package
     * @param log <Log> - Log
     */
    public void VerifyRecordStatusAfterRenewOrGenerateInvoiceForThePackage(String status,Log log) {
        try {
            mouseOver(driver,getElement("//div[@role='grid']/following-sibling::div//p"));
            parseAnnualPackageManagementGridData();
            int latestPackageNo = packageManagementGridData.size() - 1;
            String actualPackageName = packageManagementGridData.get(latestPackageNo).get("Status").toString();
            VerifyValue1(actualPackageName, status);
            Assert.assertEquals(actualPackageName, status);
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify record status " + status + " * Verify record status"+status+" is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to get subscribed service bundle name
     * @return subscribedName <String> - Subscribed name
     */
    public String getSubscribedServiceBundleName() {
        return subscribedName = getText(UapiOR.Customer_AddPackagePage_SubscribedServiceBundleName);
    }

    /**
     * Method to verify record is saved after renew or generate invoice for the package
     * @param log <Log> - Log
     */
    public void VerifyRecordIsSavedAfterRenewOrGenerateInvoiceForTheServiceBundlePackage(Map<Object,Object>testDataMap,Log log) {
        try {
            mouseOver(driver,getElement(UapiOR.Customer_PackageManagementPage_ServiceBundlePackageGridGoToNextIcon));
            parseServiceBundlePackageManagementGridData();
            int latestPackageNo = packageManagementGridData.size() - 1;
            String actualPackagePrice = packageManagementGridData.get(latestPackageNo).get("Price").toString().replace(",","").replace(".0","");
            String actualPackageName = packageManagementGridData.get(latestPackageNo).get("Package Name").toString();
            VerifyValue1(actualPackagePrice, subscribedName);
            VerifyValue1(actualPackageName, testDataMap.get("PackageName").toString());
            Assert.assertEquals(actualPackagePrice, subscribedName);
            Assert.assertEquals(actualPackageName, testDataMap.get("PackageName").toString());
            test.log(Status.PASS, "#FUNC -Verify record is saved " + " *  Verify record is saved is Pass * ");
            log.ReportEvent("PASS", "Verify record is saved is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify record is saved " + " * Verify record is saved is Fail * ");
            takeScreenShot();
        }
    }

    // Method to Search Annual Package Name with Respective to Status
    public void searchAnnualPackageNameWithRespectiveStatus(Map<Object, Object> testdatamap, Log log) {
        try {
            WebEdit(UapiOR.Customer_PackageManagementPage_AnnualPackageNameSearchField, testdatamap.get("AnnualSearchFieldInput").toString());
            WebClick(UapiOR.Customer_PackageManagementPage_SelectAnnualPackageStatusBtn);
            WebClick("//li[@data-value='" + testdatamap.get("SelectPackageStatusOption").toString() + "']");
            WebClick(UapiOR.Customer_PackageManagementPage_AnnualPackageNameSearchBtn);
            test.log(Status.PASS, "Enter Annual package in Search keyword" + " *  Enter Annual package in Search keyword and Select Status is Pass * ");
            log.ReportEvent("PASS", " Enter Annual package in Search keyword and Select Status is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.PASS, " Enter Annual package in Search keyword " + " *   Enter Annual package in Search keyword and Select Status is Fail * ");
            this.takeScreenShot();
        }
    }

    // Method to Search Service Bundle Package Name with Respective to Status
    public void searchServiceBundlePackageNameWithRespectiveStatus(Map<Object, Object> testdatamap, Log log) {
        try {
            WebEdit(UapiOR.Customer_PackageManagementPage_ServiceBundlePackageNameSearchField, testdatamap.get("ServiceSearchFieldInput").toString());
            WebClick(UapiOR.Customer_PackageManagementPage_SelectServiceBundlePackageStatusBtn);
            WebClick("//li[@data-value='" + testdatamap.get("SelectPackageStatusOption").toString() + "']");
            WebClick(UapiOR.Customer_PackageManagementPage_ServiceBundlePackageNameSearchBtn);
            test.log(Status.PASS, "Enter Service Bundle package in Search keyword" + " *  Enter Service Bundle package in Search keyword and Select Status is Pass * ");
            log.ReportEvent("PASS", " Enter Service Bundle package in Search keyword and Select Status is successful");
            waitForTwoSec();
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.PASS, " Enter Service Bundle package in Search keyword " + " *   Enter Service Bundle package in Search keyword and Select Status is Fail * ");
            this.takeScreenShot();
        }
    }

    // Method to get price Consumption Value
    public String getPriceConsumptionValue() {
        String priceConsumptionValue = driver.findElement(By.xpath(UapiOR.Customer_PackageManagementPage_PriceConsumptionValue)).getText();
        return priceConsumptionValue;
    }

    // Method to verify Price Consumption for Service Bundle package
    public void verifyPriceConsumptionDataWhenUseMyCredentialsIsEnabled(String priceConsumptionValueBeforeExecuting,Log Log)
    {
        String priceConsumptionValueAfterExecutingService = driver.findElement(By.xpath(UapiOR.Customer_PackageManagementPage_PriceConsumptionValue)).getText();
        Assert.assertEquals(priceConsumptionValueAfterExecutingService,priceConsumptionValueBeforeExecuting);
        Log.ReportEvent("PASS", "Verify Application not consume price from service bundles when 'Use my credential' is enabled");

    }

    // Method to get Transaction Consumption Value
    public String getTransactionConsumption() {
        String transactionConsumptionValue = driver.findElement(By.xpath(UapiOR.Customer_PackageManagementPage_TransactionConsumptionValue)).getText();
        return transactionConsumptionValue;
    }

    // Method to verify transaction Consumption from Annual Tier package
    public void verifyTransactionConsumptionDataWhenUseMyCredentialsIsEnabled(String transactionConsumptionValueAfterExecutingService,Log Log)
    {
        String transactionConsumptionValue = driver.findElement(By.xpath(UapiOR.Customer_PackageManagementPage_TransactionConsumptionValue)).getText();
        Assert.assertEquals(transactionConsumptionValue,transactionConsumptionValueAfterExecutingService);
        Log.ReportEvent("PASS", "Verify whether the Application consume transaction from annual tier when 'Use my credential' is enabled.");

    }

    /**
     * Method to verify active annual package should not present in service bundle
     * @param testDataMap <Map> - Test data map
     * @param log         <Log> - Log
     */
   public void verifyActiveAnnualPackageShouldNotPresentInServiceBundle(Map<Object, Object> testDataMap,Log log){
    if (getElement(UapiOR.Customer_AddPackagePage_PostpaidDetails).isDisplayed()){
        test.log(Status.PASS, "#FUNC - Verify the available package list" + " * Verify the available package list is Pass * ");
        log.ReportEvent("PASS", "Verify the available package list is successful");
        }
    else if (!driver.findElement(By.xpath("//button[@type='submit' and text()='Renew Package']/parent::div/following-sibling::div//h1[text()='"+testDataMap.get("AnnualActivePackage").toString()+"']")).isEnabled()) {
        test.log(Status.FAIL, "Verify the available package list" + " * Verify the available package list is Fail * ");
        takeScreenShot();
        }
    }

}