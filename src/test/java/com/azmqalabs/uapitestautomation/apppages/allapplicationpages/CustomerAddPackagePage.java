/**
 * Test Script Name                      : CustomerAddPackagePage.
 * Objective                             : Verify the Add Package Functionality.
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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.Map;

public class CustomerAddPackagePage extends BasePage {

    public CustomerAddPackagePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Customer_AddPackagePage_AnnualSubscriptionTiersTab)
    public WebElement annualSubscriptionTiersTab;

    public boolean Exists() {
        return super.Exists(annualSubscriptionTiersTab);
    }


    /**
     * Method to verify annual subscription tiers and services bundles tabs are displayed
     * @throws Exception
     */
    public void verifyAnnualSubscriptionTiersAndServicesBundlesTabsAreDisplayed() throws Exception {
        if (Exists()) {
            verifyElementIsPresent(UapiOR.Customer_AddPackagePage_AnnualSubscriptionTiersTab);
            verifyElementIsPresent(UapiOR.Customer_AddPackagePage_ServicesBundlesTab);
            takeScreenShot();
        }
        else {
            test.log(Status.FAIL, "Verify annual subscription tiers and services bundles tabs are displayed " + " *Verify annual subscription tiers and services bundles tabs are displayed is Fail* ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify annual subscription tiers tab selected by default
     * @param log <Log> - Log
     */
    public void verifyAnnualSubscriptionTiersTabSelectedByDefault(Log log)  {
        try {
            if(getElement(UapiOR.Customer_AddPackagePage_AnnualSubscriptionTiersTabIsSelected).isDisplayed()) {
                test.log(Status.PASS, "#FUNC - Verify Default tab selection " + " *  Verify Default tab selection is Pass * ");
                log.ReportEvent("PASS", "Verify Default tab selection is successful");
                takeScreenShot();
            }
            else {
                test.log(Status.FAIL, "Verify Default tab selection " + " * Verify Default tab selection is Fail * ");
                takeScreenShot();
            }
        }
        catch (Exception e){
            test.log(Status.FAIL, "Verify Default tab selection " + " * Verify Default tab selection is Fail* ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify already subscribed package details
     * @param testDataMap <Map> -Test data map
     * @param log <Log> - Log
     */
    public void verifyAlreadySubscribedPackageDetails(Map<Object,Object> testDataMap,Log log)  {
        try {
            if (getText(UapiOR.Customer_AddPackagePage_SubscribedPackagesTxt).equals("Subscribed Packages")) {
                scrollToElement(driver,getElement(UapiOR.Customer_AddPackagePage_SubscribedPackagesTxt));
                Assert.assertEquals(getText(UapiOR.Customer_AddPackagePage_SubscribedPackageName),testDataMap.get("SubscribedPackageName").toString());
                Assert.assertEquals(getText(UapiOR.Customer_AddPackagePage_SubscribedPackagePrice).replaceAll("[^0-9]", ""),testDataMap.get("SubscribedPackagePrice").toString());
                String[] status=getText(UapiOR.Customer_AddPackagePage_SubscribedPackageStatus).split(": ");
                Assert.assertEquals(status[1].trim(),testDataMap.get("SubscribedPackageStatus").toString());
                VerifyValue1(getText(UapiOR.Customer_AddPackagePage_SubscribedPackageName),testDataMap.get("SubscribedPackageName").toString());
                VerifyValue1(getText(UapiOR.Customer_AddPackagePage_SubscribedPackagePrice).replaceAll("[^0-9]", ""),testDataMap.get("SubscribedPackagePrice").toString());
                VerifyValue1(status[1].trim(),testDataMap.get("SubscribedPackageStatus").toString());
                test.log(Status.PASS, "#FUNC - verify already subscribed package details " + " *  Verify already subscribed package details is Pass * ");
                log.ReportEvent("PASS", "verify already subscribed package details is successful");
                takeScreenShot();
            }
            else {
                test.log(Status.FAIL, "Subscribed Packages are not available ");
                takeScreenShot();
            }
        }
        catch (Exception e){
            test.log(Status.FAIL, "verify already subscribed package details " + " * verify already subscribed package details is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on subscribed package based on package name
     * @param testDataMap <Map> -Test data map
     * @param log <Log> - Log
     */
    public void clickOnSubscribedPackageBasedOnPackageName(Map<Object,Object> testDataMap, Log log) {
        try {
            scrollToElement(driver,getElement("//button[@type='submit' and text()='Renew Package']/preceding::div/h1/preceding-sibling::h1[text()='" + testDataMap.get("SubscribedPackageName").toString() + "']/parent::div"));
            WebClick("//button[@type='submit' and text()='Renew Package']/preceding::div/h1/preceding-sibling::h1[text()='" + testDataMap.get("SubscribedPackageName").toString() + "']/parent::div");

            test.log(Status.PASS, "#FUNC - Click on already subscribed package " + " *  Click on already subscribed package is Pass * ");
            log.ReportEvent("PASS", "Click on already subscribed package is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on already subscribed package " + " * Click on already subscribed package is Fail * ");
            takeScreenShot();
        }
    }

        /**
         * Method to verify renew package button is enabled
         */
        public void verifyRenewPackageButtonIsEnabled(){
            try {
                mouseOver(driver,getElement(UapiOR.Customer_AddPackagePage_RenewPackageBtn));
                if(getElement(UapiOR.Customer_AddPackagePage_RenewPackageBtn).isEnabled()) {
                    takeScreenShot();
                }
                else {
                    System.out.println("Renew Package button is not enabled");
                    test.log(Status.FAIL, "#FUNC - Verify Renew Package button is enabled " + " *  Verify Renew Package button is enabled is Fail * ");
                    takeScreenShot();
                }
            } catch (Exception e) {
                test.log(Status.FAIL, "Verify Renew Package button is enabled " + " * Verify Renew Package button is enabled is Fail * ");
                takeScreenShot();
            }
        }

    /**
     * Method to click on renew package button
     * @param log <Log> - Log
     */
    public void clickOnRenewPackageButton(Log log){
        try {
            mouseOver(driver,getElement(UapiOR.Customer_AddPackagePage_RenewPackageBtn));
            WebClick(UapiOR.Customer_AddPackagePage_RenewPackageBtn);
            Thread.sleep(1000);
//            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_AreYouSureYouWantToSelectThisPackagePopUpTxt),"Are you sure you want to select this package?");
            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpHeader),"Add New Annual Subscription Tier");
            test.log(Status.PASS, "#FUNC - Click on 'Renew Package' button " + " *  Click on 'Renew Package' button is Pass * ");
            log.ReportEvent("PASS", "Click on 'Renew Package' button is successful");
            takeScreenShot();

        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Renew Package' button is enabled " + " * Click on 'Renew Package' button is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on are you sure you want to select this package pop up close btn
     */
    public void clickOnAreYouSureYouWantToSelectThisPackagePopUpCloseBtn(){
        try {
            WebClick(UapiOR.Customer_AddPackagePage_AreYouSureYouWantToSelectThisPackagePopUpCloseBtn);
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on are you sure you want to select this package pop up close button " + " * click on are you sure you want to select this package pop up close button is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on are you sure you want to select this package pop up Yes btn
     * @param log <Log> - Log
     */
    public void clickOnAreYouSureYouWantToSelectThisPackagePopUpYesBtn(Log log) {
        try {
            WebClick(UapiOR.Customer_AddPackagePage_AreYouSureYouWantToSelectThisPackagePopUpYesBtn);
            Thread.sleep(1000);
            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpHeader),"Add New Annual Subscription Tier");
            test.log(Status.PASS, "#FUNC - Click 'Yes' button " + " *  Click 'Yes' button is Pass * ");
            log.ReportEvent("PASS", "Click 'Yes' button is successful");
            takeScreenShot();
            Thread.sleep(1000);
        } catch (Exception e) {
            test.log(Status.FAIL, "Click 'Yes' button " + " * Click 'Yes' button is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on add new annual subscription tier pop up close btn
     * @param log <Log> - Log
     */
    public void clickOnAddNewAnnualSubscriptionTierPopUpCloseBtn(Log log) {
        try {
            WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpCloseBtn);
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on add new annual subscription tier pop up close button " + " * Click on add new annual subscription tier pop up close button is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on add new annual subscription tier pop up cancel btn
     * @param log <Log> - Log
     */
    public void clickOnAddNewAnnualSubscriptionTierPopUpCancelBtn(Log log) {
        try {
            WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpCancelBtn);
            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_Header), "Add package");
            test.log(Status.PASS, "#FUNC - Click on 'Cancel' button " + " *  Click on 'Cancel' button  is Pass * ");
            log.ReportEvent("PASS", "Click on 'Cancel' button  is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Cancel' button  " + " * Click on 'Cancel' button is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to select current date as activation date in add new annual subscription tier pop up
     * @param log <Log> - Log
     */
    public void selectActivationDateInAddNewAnnualSubscriptionTierPopUp(Map<Object,Object>testDataMap, Log log) {
        try {
            WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpActivationDate);
//            WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpTodayDateActivationDate);
            WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpActivationDateYearDownArrow);
            WebClick("//button[@role='radio' and text()='"+testDataMap.get("Year").toString()+"']");
            WebClick("//button[@role='radio' and text()='"+testDataMap.get("Month").toString()+"']");
            WebClick("//button[@role='gridcell' and text()='"+testDataMap.get("Day").toString()+"']");
            test.log(Status.PASS, "#FUNC - Select valid date " + " *  Select valid date  is Pass * ");
            log.ReportEvent("PASS", "Select valid date is successful");
            Thread.sleep(1000);
            takeScreenShot();
            Thread.sleep(1000);
        } catch (Exception e) {
            test.log(Status.FAIL, "Select valid date " + " * Select valid date is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on add new annual subscription tier pop up save btn
     * @param log <Log> - Log
     */
    public void clickOnAddNewAnnualSubscriptionTierPopUpSaveBtn(Log log) {
        try {
            WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpSaveBtn);
            test.log(Status.PASS, "#FUNC - Click on 'Save' button " + " *  Click on 'Save' button  is Pass * ");
            log.ReportEvent("PASS", "Click on 'Save' button  is successful");
            Thread.sleep(1000);
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Save' button  " + " * Click on 'Save' button is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify activation date error message
     */
    public void verifyActivationDateErrorMSG(){
        try{
            Assert.assertEquals(getText(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpActivationDateError),"This field cannot be left blank");
            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpActivationDateError),"This field cannot be left blank");
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL, "Verify Activation Date Error Message  " + " * Verify Activation Date Error Message is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify Annual Package Will Be Activated On The Activation Date PopUp
     * @param log <Log> - Log
     */
    public void verifyAnnualPackageWillBeActivatedOnTheActivationDatePopUp(Log log){
        try{
            Assert.assertEquals(getText(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUp),"The Annual Package will be activated on the `Activation date`.");
            Assert.assertEquals(getText(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpContent),"The Invoice will be generated. Do you want to proceed?");
            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUp),"The Annual Package will be activated on the `Activation date`.");
            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpContent),"The Invoice will be generated. Do you want to proceed?");
            verifyElementIsPresent(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpYesBtn);
            verifyElementIsPresent(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpNoBtn);
            test.log(Status.PASS, "#FUNC - Verify confirmation message  " + " * Verify confirmation message is Pass * ");
            log.ReportEvent("PASS", "Verify confirmation message is successful");
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL, "Verify confirmation message  " + " * Verify confirmation message is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on annual package will be activated on the activation pop up close button
     */
    public void clickOnAnnualPackageWillBeActivatedOnTheActivationDatePopUpCloseBtn(){
        WebClick(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpCloseBtn);
        takeScreenShot();
    }

    /**
     * Method to click on no button in annual package will be activated on the activation date pop up
     * @param log <Log> Log
     */
    public void clickOnNoBtnInAnnualPackageWillBeActivatedOnTheActivationDatePopUp(Log log){
        try{
            WebClick(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpNoBtn);
            test.log(Status.PASS, "#FUNC - Click on 'No' " + " * Click on 'No' is Pass * ");
            log.ReportEvent("PASS", "Click on 'No' is successful");
            Thread.sleep(1000);
            takeScreenShot();
            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpHeader),"Add New Annual Subscription Tier");
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on 'No'  " + " * Click on 'No' is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on yes button in annual package will be activated on the activation date pop up
     * @param log <Log> Log
     */
    public void clickOnYesBtnInAnnualPackageWillBeActivatedOnTheActivationDatePopUp(Log log){
        try{
            WebClick(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpYesBtn);
            test.log(Status.PASS, "#FUNC - Click on 'Yes' " + " * Click on 'Yes' is Pass * ");
            log.ReportEvent("PASS", "Click on 'Yes' is successful");
            Thread.sleep(1000);
            takeScreenShot();
            VerifyPackageActivationRequestSentMsg();
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on 'Yes'  " + " * Click on 'Yes' is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify package activation request sent msg
     * @throws IOException
     */
    public void VerifyPackageActivationRequestSentMsg() throws IOException {
        Assert.assertEquals(getText(UapiOR.Customer_ErrorMsg),"Package Activation request sent! Please check the invoice section.");
        VerifyValue1(getText(UapiOR.Customer_ErrorMsg),"Package Activation request sent! Please check the invoice section.");
    }


    /**
     * Method to click on available package based on package name
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - Log
     */
    public void clickOnAvailablePackageBasedOnPackageName(Map<Object,Object> testDataMap,Log log) {
        try {
            scrollToElement(driver,getElement(UapiOR.Customer_AddPackagePage_AvailableToAddTxt));
            WebClick("//button[@type='submit' and text()='Renew Package']/following::div/h1/preceding-sibling::h1[text()='" + testDataMap.get("PackageToGenerateInvoice").toString() + "']/parent::div");

            test.log(Status.PASS, "#FUNC - Click on Package " + " *  Click on Package is Pass * ");
            log.ReportEvent("PASS", "Click on Package is successful");
            takeScreenShot();
            Thread.sleep(1000);
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on Package " + " * Click on Package is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify available packages list
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - Log
     */
    public void verifyAvailablePackagesList(Map<Object,Object> testDataMap, Log log) {
        try {
            scrollToElement(driver,getElement(UapiOR.Customer_AddPackagePage_AvailableToAddTxt));
            String[] expectedValue= testDataMap.get("AvailablePackages").toString().split(",");
            for (int i = 0; i < getElements(UapiOR.Customer_AddPackagePage_AvailablePackages).size(); i++) {
                Assert.assertTrue(getElement("//button[@type='submit' and text()='Renew Package']/following::div/h1/preceding-sibling::h1[text()='"+expectedValue[i]+"']").isDisplayed(),"available Package is not "+expectedValue[i]);
            }
            test.log(Status.PASS, "#FUNC - Verify the available package list " + " *  Verify the available package list is Pass * ");
            log.ReportEvent("PASS", "Verify the available package list is successful");
            Thread.sleep(1000);
            takeScreenShot();
            Thread.sleep(1000);
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify the available package list " + " * Verify the available package list is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify generate invoice button is enabled
     */
    public void verifyGenerateInvoiceButtonIsEnabled(){
        try {
            mouseOver(driver,getElement(UapiOR.Customer_AddPackagePage_GenerateInvoiceBtn));
            scrollDowntillend(driver);
            if(getElement(UapiOR.Customer_AddPackagePage_GenerateInvoiceBtn).isEnabled()) {
                takeScreenShot();
                Thread.sleep(1000);
            }
            else {
                System.out.println("Generate Invoice is not enabled");
                test.log(Status.FAIL, "#FUNC - Verify Generate Invoice button is enabled " + " *  Verify Generate Invoice button is enabled is Fail * ");
                takeScreenShot();
            }
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify Generate Invoice button is enabled " + " * Verify Generate Invoice button is enabled is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on generate invoice button
     */
    public void clickOnGenerateInvoiceButton(Log log){
        try {
            mouseOver(driver,getElement(UapiOR.Customer_AddPackagePage_GenerateInvoiceBtn));
            WebClick(UapiOR.Customer_AddPackagePage_GenerateInvoiceBtn);
            test.log(Status.PASS, "#FUNC - Click on Generate invoice button " + " *  Click on Generate invoice button is Pass * ");
            log.ReportEvent("PASS", "Click on Generate invoice button is successful");
            takeScreenShot();

        } catch (Exception e) {
            test.log(Status.FAIL, "Click on Generate invoice button " + " * Click on Generate invoice button is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify add new annual subscription tier pop up package details
     * @param testDataMap <Map> -Test Data Map
     * @param log <Log> - Log
     */
    public void verifyAddNewAnnualSubscriptionTierPopUpPackageDetails(Map<Object,Object> testDataMap,Log log) {
        try{
            String[] expectedPackageDetails = {testDataMap.get("PackageName").toString(),testDataMap.get("TransactionLimit").toString(),testDataMap.get("PackagePrice").toString(),testDataMap.get("Duration").toString()};
            for (int i=0; i<getElements(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpPackageDetails).size(); i++) {
                Assert.assertEquals(getElements(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpPackageDetails).get(i).getText().split(": ")[1],expectedPackageDetails[i]);
            }
        }
        catch (Exception e){
            test.log(Status.FAIL, "Verify Package Details " + " * Verify Package Details is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on services bundle tab
     */
    public void clickOnServicesBundleTab(){
        WebClick(UapiOR.Customer_AddPackagePage_ServicesBundlesTab);
        takeScreenShot();
    }

    /**
     * Method to verify already subscribed Bundle package details
     * @param testDataMap <Map> -Test data map
     * @param log <Log> - Log
     */
    public void verifyAlreadySubscribedBundlePackageDetails(Map<Object,Object> testDataMap,Log log)  {
        try {
            if (getText(UapiOR.Customer_AddPackagePage_SubscribedPrepaidBundlesTxt).equals("Subscribed Prepaid Bundles")) {
                scrollToElement(driver,getElement(UapiOR.Customer_AddPackagePage_SubscribedPrepaidBundlesTxt));
                Assert.assertEquals(getText(UapiOR.Customer_AddPackagePage_SubscribedServiceBundlePrice).replaceAll("[^0-9]", ""),testDataMap.get("SubscribedPackagePrice").toString());
                String[] status=getText(UapiOR.Customer_AddPackagePage_SubscribedPackageStatus).split(": ");
                Assert.assertEquals(status[1].trim(),testDataMap.get("SubscribedPackageStatus").toString());
                VerifyValue1(getText(UapiOR.Customer_AddPackagePage_SubscribedServiceBundlePrice).replaceAll("[^0-9]", ""),testDataMap.get("SubscribedPackagePrice").toString());
                VerifyValue1(status[1].trim(),testDataMap.get("SubscribedPackageStatus").toString());
                test.log(Status.PASS, "#FUNC - Verify already subscribed prepaid bundle details " + " *  Verify already subscribed prepaid bundle details is Pass * ");
                log.ReportEvent("PASS", "Verify already subscribed prepaid bundle details is successful");
                takeScreenShot();
            }
            else {
                test.log(Status.FAIL, "Subscribed Packages are not available ");
                takeScreenShot();
            }
        }
        catch (Exception e){
            test.log(Status.FAIL, "Verify already subscribed prepaid bundle details " + " * Verify already subscribed prepaid bundle details is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on subscribed package bundle based on package price
     * @param testDataMap <Map> -Test data map
     * @param log <Log> - Log
     */
    public void clickOnSubscribedPackageBundleBasedOnPackagePrice(Map<Object,Object> testDataMap, Log log) {
        try {
            scrollToElement(driver,getElement(UapiOR.Customer_AddPackagePage_SubscribedPrepaidBundlesTxt));
            WebClick("//button[@type='submit' and text()='Renew Package']/preceding::div/ul/preceding-sibling::h1[text()='" + testDataMap.get("SubscribedBundlePackagePrice").toString() + "']/parent::div");

            test.log(Status.PASS, "#FUNC - Click on already subscribed package " + " *  Click on already subscribed package is Pass * ");
            log.ReportEvent("PASS", "Click on already subscribed package is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on already subscribed package " + " * Click on already subscribed package is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on are you sure you want to select this package pop up Yes btn
     * @param log <Log> - Log
     */
    public void clickOnAreYouSureYouWantToSelectThisPackagePopUpYesBtnForServiceBundle(Log log) {
        try {
            WebClick(UapiOR.Customer_AddPackagePage_AreYouSureYouWantToSelectThisPackagePopUpYesBtn);
            Thread.sleep(1000);
            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpHeader),"Add New Service Bundle");
            test.log(Status.PASS, "#FUNC - Click 'Yes' button " + " *  Click 'Yes' button is Pass * ");
            log.ReportEvent("PASS", "Click 'Yes' button is successful");
            takeScreenShot();
            Thread.sleep(1000);
        } catch (Exception e) {
            test.log(Status.FAIL, "Click 'Yes' button " + " * Click 'Yes' button is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify add new service bundle pop up package details
     * @param testDataMap <Map> -Test Data Map
     * @param log <Log> - Log
     */
    public void verifyAddNewServiceBundlePopUpPackageDetails(Map<Object,Object> testDataMap,Log log) {
        try{
            VerifyValue1(getElement(UapiOR.Customer_AddPackagePage_AddNewServiceBundlePopUpPackagePrice).getText(),testDataMap.get("PackagePrice").toString());
            VerifyValue1(getElement(UapiOR.Customer_AddPackagePage_AddNewServiceBundlePopUpPackagePeriod).getText(),"Valid for "+testDataMap.get("Period").toString());
            Assert.assertEquals(getElement(UapiOR.Customer_AddPackagePage_AddNewServiceBundlePopUpPackagePrice).getText(),testDataMap.get("PackagePrice").toString());
            Assert.assertEquals(getElement(UapiOR.Customer_AddPackagePage_AddNewServiceBundlePopUpPackagePeriod).getText(),"Valid for "+testDataMap.get("Period").toString());
        }
        catch (Exception e){
            test.log(Status.FAIL, "Verify Package Details " + " * Verify Package Details is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on add new service bundle pop up cancel btn
     * @param log <Log> - Log
     */
    public void clickOnAddNewServiceBundlePopUpCancelBtn(Log log) {
        try {
            WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpCancelBtn);
            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_Header), "Add package");
            test.log(Status.PASS, "#FUNC - Click on 'Cancel' button " + " *  Click on 'Cancel' button  is Pass * ");
            log.ReportEvent("PASS", "Click on 'Cancel' button  is successful");
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Cancel' button  " + " * Click on 'Cancel' button is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to select current date as activation date in add new service bundle pop up
     * @param log <Log> - Log
     */
    public void selectCurrentDateAsActivationDateInAddNewServiceBundlePopUp(Map<Object,Object>testDataMap,Log log) {
        try {
            WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpActivationDate);
//            WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpTodayDateActivationDate);
            WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpActivationDateYearDownArrow);
            WebClick("//button[@role='radio' and text()='"+testDataMap.get("Year").toString()+"']");
            WebClick("//button[@role='radio' and text()='"+testDataMap.get("Month").toString()+"']");
            WebClick("//button[@role='gridcell' and text()='"+testDataMap.get("Day").toString()+"']");
            test.log(Status.PASS, "#FUNC - Select valid date " + " *  Select valid date  is Pass * ");
            log.ReportEvent("PASS", "Select valid date is successful");
            Thread.sleep(1000);
            takeScreenShot();
            Thread.sleep(1000);
        } catch (Exception e) {
            test.log(Status.FAIL, "Select valid date " + " * Select valid date is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on add new service bundle tier pop up save btn
     * @param log <Log> - Log
     */
    public void clickOnAddNewServiceBundlePopUpSaveBtn(Log log) {
        try {
            WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpSaveBtn);
            test.log(Status.PASS, "#FUNC - Click on 'Save' button " + " *  Click on 'Save' button  is Pass * ");
            log.ReportEvent("PASS", "Click on 'Save' button  is successful");
            Thread.sleep(1000);
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on 'Save' button  " + " * Click on 'Save' button is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on add new service bundle close btn
     * @param log <Log> - Log
     */
    public void clickOnAddNewServiceBundlePopUpCloseBtn(Log log) {
        try {
            WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpCloseBtn);
            takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on add new service bundle pop up close button " + " * Click on add new service bundle pop up close button is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify Service Bundle Will Be Activated On The Activation Date PopUp
     * @param log <Log> - Log
     */
    public void verifyServiceBundleWillBeActivatedOnTheActivationDatePopUp(Log log){
        try{
            Assert.assertEquals(getText(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUp),"The Service Bundle will be activated on the `Activation date`.");
            Assert.assertEquals(getText(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpContent),"The Invoice will be generated. Do you want to proceed?");
            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUp),"The Service Bundle will be activated on the `Activation date`.");
            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpContent),"The Invoice will be generated. Do you want to proceed?");
            verifyElementIsPresent(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpYesBtn);
            verifyElementIsPresent(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpNoBtn);
            test.log(Status.PASS, "#FUNC - Verify confirmation message  " + " * Verify confirmation message is Pass * ");
            log.ReportEvent("PASS", "Verify confirmation message is successful");
            takeScreenShot();
        }
        catch (Exception e){
            test.log(Status.FAIL, "Verify confirmation message  " + " * Verify confirmation message is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on service bundle will be activated on the activation pop up close button
     */
    public void clickOnServiceBundleWillBeActivatedOnTheActivationDatePopUpCloseBtn(){
        WebClick(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpCloseBtn);
        takeScreenShot();
    }

    /**
     * Method to click on no button in annual package will be activated on the activation date pop up
     * @param log <Log> Log
     */
    public void clickOnNoBtnInServiceBundleWillBeActivatedOnTheActivationDatePopUp(Log log){
        try{
            WebClick(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpNoBtn);
            test.log(Status.PASS, "#FUNC - Click on 'No' " + " * Click on 'No' is Pass * ");
            log.ReportEvent("PASS", "Click on 'No' is successful");
            Thread.sleep(1000);
            takeScreenShot();
            VerifyValue1(getText(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpHeader),"Add New Service Bundle");
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on 'No'  " + " * Click on 'No' is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on yes button in service bundle will be activated on the activation date pop up
     * @param log <Log> Log
     */
    public void clickOnYesBtnInServiceBundleWillBeActivatedOnTheActivationDatePopUp(Log log){
        try{
            WebClick(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpYesBtn);
            test.log(Status.PASS, "#FUNC - Click on 'Yes' " + " * Click on 'Yes' is Pass * ");
            log.ReportEvent("PASS", "Click on 'Yes' is successful");
            Thread.sleep(1000);
            takeScreenShot();
            VerifyPackageActivationRequestSentMsg();
        }
        catch (Exception e){
            test.log(Status.FAIL, "Click on 'Yes'  " + " * Click on 'Yes' is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to verify Service Bundle packages list
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - Log
     */
    public void verifyServiceBundlePackagesList(Map<Object,Object> testDataMap, Log log) {
        try {
            scrollToElement(driver,getElement(UapiOR.Customer_AddPackagePage_AvailableToAddTxt));
            String[] expectedValue= testDataMap.get("AvailablePackages").toString().split(",");
            for (int i = 0; i < expectedValue.length; i++) {
                Assert.assertTrue(getElement("//button[@type='submit' and text()='Renew Package']/following::div/ul/preceding-sibling::h1[text()='"+expectedValue[i]+"']").isDisplayed(),"available Package is not "+expectedValue[i]);
            }
            test.log(Status.PASS, "#FUNC - Verify the available package list " + " *  Verify the available package list is Pass * ");
            log.ReportEvent("PASS", "Verify the available package list is successful");
            Thread.sleep(1000);
            takeScreenShot();
            Thread.sleep(1000);
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify the available package list " + " * Verify the available package list is Fail * ");
            takeScreenShot();
        }
    }

    /**
     * Method to click on service bundle package based on package name
     * @param testDataMap <Map> - Test data map
     * @param log <Log> - Log
     */
    public void clickOnAvailableServiceBundlePackageBasedOnPackageName(Map<Object,Object> testDataMap,Log log) {
        try {
            scrollToElement(driver,getElement(UapiOR.Customer_AddPackagePage_AvailableToAddTxt));
            WebClick("//button[@type='submit' and text()='Renew Package']/following::div/ul/preceding-sibling::h1[text()='" + testDataMap.get("PackageToGenerateInvoice").toString() + "']/parent::div");

            test.log(Status.PASS, "#FUNC - Click on Package " + " *  Click on Package is Pass * ");
            log.ReportEvent("PASS", "Click on Package is successful");
            takeScreenShot();
            Thread.sleep(1000);
        } catch (Exception e) {
            test.log(Status.FAIL, "Click on Package " + " * Click on Package is Fail * ");
            takeScreenShot();
        }
    }

    public String generatedPackageDate ="";

    /**
     * Method to get selected activation date
     * @return generatePackageDate
     */
    public String getSelectedActivationDate(){
        return generatedPackageDate = getElement(UapiOR.Admin_PackageManagement_ActivationDateCalender).getAttribute("value");
    }

    public void preconditionToSubscribePackage(Map<Object,Object> testDataMap) throws IOException, InterruptedException {
        WebClick(UapiOR.Customer_PackageManagement_Menu);
        VerifyValue1(getText(UapiOR.Customer_PackageManagementPage_Header), "Package Management");
        WebClick(UapiOR.Customer_PackageManagementPage_AddPackageButton);
        VerifyValue1(getText(UapiOR.Customer_AddPackagePage_Header), "Add package");
        scrollToElement(driver,getElement(UapiOR.Customer_AddPackagePage_AvailableToAddTxt));
        WebClick("//button[@type='submit' and text()='Renew Package']/following::div/h1/preceding-sibling::h1[text()='" + testDataMap.get("PackageToGenerateInvoice").toString() + "']/parent::div");
        mouseOver(driver,getElement(UapiOR.Customer_AddPackagePage_GenerateInvoiceBtn));
        WebClick(UapiOR.Customer_AddPackagePage_GenerateInvoiceBtn);
        WebClick(UapiOR.Customer_AddPackagePage_AreYouSureYouWantToSelectThisPackagePopUpYesBtn);
        Thread.sleep(1000);
        VerifyValue1(getText(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpHeader),"Add New Annual Subscription Tier");
        WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpActivationDate);
        WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpActivationDateYearDownArrow);
        WebClick("//button[@role='radio' and text()='"+testDataMap.get("Year").toString()+"']");
        WebClick("//button[@role='radio' and text()='"+testDataMap.get("Month").toString()+"']");
        WebClick("//button[@role='gridcell' and text()='"+testDataMap.get("Day").toString()+"']");
//        WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpTodayDateActivationDate);
        getSelectedActivationDate();
        WebClick(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpSaveBtn);
        WebClick(UapiOR.Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpYesBtn);
        waitForTwoSec();
        waitForTwoSec();
    }

    /**
     * Method to verify add new annual subscription tier popup package components
     * @throws Exception
     */
    public void verifyAddNewAnnualSubscriptionTierPopUpPackageComponents() throws Exception {
        verifyElementIsPresent(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpSaveBtn);
        verifyElementIsPresent(UapiOR.Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpCancelBtn);
        verifyElementIsPresent(UapiOR.Admin_PackageManagement_ActivationDateCalender);
    }
}