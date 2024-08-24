/**
 * Test Script Name                      : CustomerServicesPage.
 * Objective                             : Verify the Customer Services page Functionality.
 * Version                               : 1.0
 * Author                                : Arun Kumar MS
 * Created Date                          : 03/07/2024
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
import java.util.Map;

public class CustomerServicesPage extends BasePage {

    public CustomerServicesPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Customer_CustomerServices_Page_ServicesText)
    public WebElement customerServicesPage;

    public boolean Exists() {
        return super.Exists(customerServicesPage);
    }

    // Method to validate Customer Profile Page
    public void verifyServicesPageIsDisplayed(Log Log) {
        try {
            Thread.sleep(1000);
            verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_ServicesText);
            this.takeScreenShot();
            test.log(Status.PASS, "Verify 'Services' screen is displayed" + driver.getTitle() + "Verify 'Services' screen is displayed is Pass");
            Log.ReportEvent("PASS", "User Navigated to Customer Services page");
            this.takeScreenShot();

        } catch (Exception e) {
            this.takeScreenShot();
            test.log(Status.FAIL, "Verify 'Services' screen is displayed" + driver.getTitle() + "Verify 'Services' screen is displayed is Fail");

        }
    }

    // Method to click on Customer Services Tab
    public void clickOnCustomerServicesTab() {
        WebClick(UapiOR.Customer_CustomerServices_Page_Services);
    }

    //Function Summary  : Method to verify All Original service Provider List in Customer Service Screen
    public void verifyAllOriginalServiceProviderList(String[] expectedServiceProviderName, Log Log) {
        try {
            List<WebElement> activeServiceProviderList = getElements(UapiOR.Customer_CustomerServices_Page_AllServiceHeadOptions);
            if (activeServiceProviderList.size() == 12) {

                for (int i = 0; i < activeServiceProviderList.size(); i++) {
                    String actualServiceProvider = activeServiceProviderList.get(i).getText();
                    System.out.println("---" + actualServiceProvider);
                    String expectedServiceProvider = expectedServiceProviderName[i];
                    Assert.assertEquals(actualServiceProvider, expectedServiceProvider);
                }
            }
            this.takeScreenShot();
            test.log(Status.PASS, "verify All Original Service Provider List In Customer Services Screen" + driver.getTitle() + " *  verify All Original Service Provider List In Customer Services Screen PASS * ");
            Log.ReportEvent("PASS", " Verify Original Service Providers list is displayed according to Application_account management setup is Successful");
        } catch (Exception e) {
            test.log(Status.FAIL, "verify All Original Service Provider List In Customer Services Screen" + driver.getTitle() + " * verify All Original Service Provider List In Customer Services Screen FAIL * ");
        }

    }

    // Method to click on Original Service Provider Name
    public void clickOnServiceHeadName(Map<Object, Object> testdatamap, Log Log) {
        WebClick("//h2[text()='" + testdatamap.get("OriginalServiceProviderName").toString() + "']");
        Log.ReportEvent("PASS", " Click on any Original Service Providers is Successful");
        this.takeScreenShot();
    }

    // Method to verify Service Heads
    public void verifySelectedServiceHeads(Map<Object, Object> testdatamap, Log Log) throws Exception {
        String serviceHeadsName = testdatamap.get("ServicesHeads").toString();
        String[] serviceHeads = serviceHeadsName.split(",");
        for (String serviceHead : serviceHeads) {
            verifyElementIsPresent("//div[text()='" + serviceHead + "']");
        }
        Log.ReportEvent("PASS", " Verify Services Heads is displayed is Successful");
        this.takeScreenShot();
    }

    // Method to click on Explore Api based on Service Head Name
    public void clickOnExploreApi(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
        WebClick("//div[normalize-space(text())='" + testdatamap.get("ServiceHeadName").toString() + "']/parent::div//button//p");
        Log.ReportEvent("PASS", " Click on 'Explore API' button is Successful");
        this.takeScreenShot();
        Thread.sleep(5000);
    }

    // Method to verify Services Screen is Displayed, on clicking Explore Api
    public void verifyServicesScreenIsDisplayed(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
        try {
            String serviceHeadName = testdatamap.get("ServiceHeadName").toString();
            switch (serviceHeadName) {
                case "Simah":
                    verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_SimahServices);
                    break;
                case "Real Estates Deeds":
                    verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_RealEstatesDeedsServices);
                    break;
                case "Power Of Attorney":
                    verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_PowerOfAttorneyServicesServices);
                    break;
                case "Mobile number verification":
                    verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_MobileNumberVerificationServiceServices);
                    break;
                case "Address By ID":
                    verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_AddressByIDServiceServices);
                    break;
                case "Nafath":
                    verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_NafathServicesServices);
                    break;
            }
            test.log(Status.PASS, "Verify Service/API list Page is Displayed" + driver.getTitle() + " *Verify Service/API list Page is Displayed PASS * ");
            Log.ReportEvent("PASS", "Verify Service/API list Page is Displayed in  swagger is successful");
            this.takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Verify Service/API list Page is Displayed" + driver.getTitle() + " *Verify Service/API list Page is Displayed Fail * ");
            this.takeScreenShot();
        }
    }

    // Method to verify List Of Services for Service Head Simah
    public void verifyListOfServicesForServiceHeadSimah(Log Log) throws Exception {
        Thread.sleep(2000);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_ConsumerEnquiryService);
        Log.ReportEvent("PASS", "Verify Services displayed for Simah Service Head is successful");
        this.takeScreenShot();
    }

    // Method to verify List Of Services for Service Head Real Estates Deeds
    public void verifyListOfServicesForServiceHeadRealEstatesDeeds(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_RealEstatesDeedsService);
        Log.ReportEvent("PASS", "Verify Services displayed for Real Estates Deeds Service Head is successful");
        this.takeScreenShot();
    }

    // Method to verify List Of Services for Service Head Real Estates Deeds
    public void verifyListOfServicesForServiceHeadPowerOfAttorney(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_RetrieveAttorneyTextsService);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_VerifyAttorneyInformationDetailsService);
        Log.ReportEvent("PASS", "Verify Services displayed for Power Of Attorney Service Head is successful");
        this.takeScreenShot();
    }

    // Method to verify List Of Services for Service Head Nafath
    public void verifyListOfServicesForServiceHeadNafath(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_NafathService);
        Log.ReportEvent("PASS", "Verify Services displayed for Nafath Service Head is successful");
        this.takeScreenShot();
    }

    // Method to verify List Of Services for Service Head Fingerprint verification
    public void verifyListOfServicesForServiceHeadFingerprintVerification(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_FingerprintVerificationService);
        Log.ReportEvent("PASS", "Verify Services displayed for Fingerprint verification Service Head is successful");
        this.takeScreenShot();
    }

    // Method to verify List Of Services for Service Head Mobile Number verification
    public void verifyListOfServicesForServiceHeadMobileNumberVerification(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_MobileNumberVerificationService);
        Log.ReportEvent("PASS", "Verify Services displayed for Mobile Number verification Service Head is successful");
        this.takeScreenShot();
    }

    // Method to verify List Of Services for Service Head Address by id
    public void verifyListOfServicesForServiceHeadAddressById(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_AddressByIdService);
        Log.ReportEvent("PASS", "Verify Services displayed for Address by Id Service Head is successful");
        this.takeScreenShot();
    }

    // Method to verify List Of Services for Service Head Commercial Registration
    public void verifyListOfServicesForServiceHeadCommercialRegistration(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_CommercialRegistrationTreeService);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_CommercialRegistrationStatusService);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_CommercialRegistrationRelatedService);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_CommercialRegistrationOwnsService);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_CommercialRegistrationOwnsCountryService);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_CommercialRegistrationOwnersService);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_CommercialRegistrationManagerService);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_CommercialRegistrationInfoService);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_CommercialRegistrationFullInfoService);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_CommercialRegistrationAddressService);
        Log.ReportEvent("PASS", "Verify Services displayed for Commercial Registration Service Head is successful");
        this.takeScreenShot();
    }

    // Method to verify List Of Services for Service Head Article of Association
    public void verifyListOfServicesForServiceHeadArticleOfAssociation(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_ArticleOfAssociationCompanyContractsManagerService);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_ArticleOfAssociationCompanyContractsManagementService);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_ArticleOfAssociationCompanyContractsLookupService);
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_ArticleOfAssociationCompanyContractsInfoService);
        Log.ReportEvent("PASS", "Verify Services displayed for Article of Association Service Head is successful");
        this.takeScreenShot();
    }

    // Method to verify List Of Services for Service Head National Address
    public void verifyListOfServicesForServiceHeadNationalAddress(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerServices_Page_NationalAddressInfoService);
        Log.ReportEvent("PASS", "Verify Services displayed for National Address Service Head is successful");
        this.takeScreenShot();
    }
    // Method to Click on Service
    public void clickOnService(Map<Object, Object> testdatamap, Log Log)
    {
        WebClick("//span[@data-path='" + testdatamap.get("ServiceUri").toString() + "']");
        Log.ReportEvent("PASS", " Click on Service in Swagger is Successful");
        this.takeScreenShot();
    }
    // Method to click on Authorize Button
    public void clickOnAuthorizeButton() {
        WebClick(UapiOR.Customer_CustomerServices_Page_AuthorizeButton);
    }

    // Method to enter Api Key
    public void enterApiKey(String apiKey,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_ApiKey,apiKey);
        Log.ReportEvent("PASS", " Enter API key under 'Authorize' form is Successful");
        this.takeScreenShot();
    }
    // Method to click on Authorize Button in Popup
    public void clickOnPopupAuthorizeButton(Log Log) {
        WebClick(UapiOR.Customer_CustomerServices_Page_PopupAuthorizeButton);
        Log.ReportEvent("PASS", " Click on 'Authorize' button is Successful");
        this.takeScreenShot();
    }

    // Method to click on Close button
    public void clickOnCloseButton() {
        WebClick(UapiOR.Customer_CustomerServices_Page_PopupCloseButton);
    }
    //Method to Authorize Api key in Swagger
    public void authorizeApiKey(String apiKeyValue,Log Log)
    {
        clickOnAuthorizeButton();
        enterApiKey(apiKeyValue,Log);
        clickOnPopupAuthorizeButton(Log);
        clickOnCloseButton();
    }
    // Method to Click on Try it out
    public void clickOnTryItOut(Log Log)
    {
        WebClick(UapiOR.Customer_CustomerServices_Page_TryItOut);
        Log.ReportEvent("PASS", " Click on 'Try it out' button is Successful");
        this.takeScreenShot();
    }
    // Method to enter Request Body
    public void enterRequestBody(Map<Object, Object> testdatamap, Log Log) throws InterruptedException {
        webClear(driver,UapiOR.Customer_CustomerServices_Page_RequestBody);
        WebEdit(UapiOR.Customer_CustomerServices_Page_RequestBody,testdatamap.get("RequestBody").toString());
        Log.ReportEvent("PASS", " Enter Parameter : fill the required details is Successful");
        this.takeScreenShot();
    }
    // Method to Click on Execute
    public void clickOnExecute(Log Log)
    {
        WebClick(UapiOR.Customer_CustomerServices_Page_Execute);
        Log.ReportEvent("PASS", " Click on 'Execute' button is Successful");
        this.takeScreenShot();
    }
    // Method to Click on Execute
    public void verifyApiResponseStatusCode(Map<Object, Object> testdatamap,Log Log){
        try {
            WebElement responseStatus=driver.findElement(By.xpath("//h4[text()='Server response']/parent::div//td[@class='response-col_status']"));
            mouseOver(driver,responseStatus);
            Thread.sleep(2000);
            VerifyValue1(getText(UapiOR.Customer_CustomerServices_Page_ServerResponse), testdatamap.get("StatusCode").toString());
            System.out.println(driver.findElement(By.xpath(UapiOR.Customer_CustomerServices_Page_ServerResponse)).getText());
            Log.ReportEvent("PASS", " Verify Response for Service is Successful");
            this.takeScreenShot();
        }catch (Exception e)
        {
            test.log(Status.FAIL, "Verify Response for Service" + driver.getTitle() + " *Verify Response for Service is Fail * ");
            this.takeScreenShot();
        }

    }
    // Method to enter Code
    public void enterCode(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_Code,testdatamap.get("Code").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Attorney Number is Successful");
        this.takeScreenShot();
    }
    // Method to enter principal Id
    public void enterPrincipalId(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_PrincipalId,testdatamap.get("PrincipalId").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Principal ID is Successful");
        this.takeScreenShot();
    }
    // Method to enter agent Id
    public void enterAgentId(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_AgentId,testdatamap.get("AgentId").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Agent Id is Successful");
        this.takeScreenShot();
    }
    // Method to enter Cr Number
    public void enterCrNumber(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_CrNumber,testdatamap.get("CrNumber").toString());
        Log.ReportEvent("PASS", " Enter Parameter : crNumber is Successful");
        this.takeScreenShot();
    }
    // Method to enter Usage Code
    public void enterUsageCode(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_UsageCode,testdatamap.get("UsageCode").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Usage Code is Successful");
        this.takeScreenShot();
    }
    // Method to enter Nin Number
    public void enterNinNumber(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_NinNumber,testdatamap.get("NinNumber").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Nin is Successful");
        this.takeScreenShot();
    }
    // Method to enter Nin Number
    public void enterDate(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_Date,testdatamap.get("Date").toString());
        Log.ReportEvent("PASS", " Enter Parameter : DateString is Successful");
        this.takeScreenShot();
    }
    // Method to enter Visa Number
    public void enterVisaNumber(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_VisaNumber,testdatamap.get("VisaNumber").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Visa Number is Successful");
        this.takeScreenShot();
    }
    // Method to enter Visa Number
    public void enterBirthDate(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_BirthDate,testdatamap.get("BirthDate").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Birth Date is Successful");
        this.takeScreenShot();
    }
    // Method to enter Sender Id
    public void enterSenderId(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_SenderId,testdatamap.get("SenderId").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Sender Id is Successful");
        this.takeScreenShot();
    }
    // Method to enter Recipient
    public void enterRecipient(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_Recipient,testdatamap.get("Recipient").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Recipient is Successful");
        this.takeScreenShot();
    }
    // Method to enter Body
    public void enterBody(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_Body,testdatamap.get("Body").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Body is Successful");
        this.takeScreenShot();
    }
    // Method to enter Iqama Number
    public void enterIqamaNumber(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_IqamaNumber,testdatamap.get("IqamaNumber").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Iqama Number is Successful");
        this.takeScreenShot();
    }
    // Method to enter Birth DateG
    public void enterBirthDateG(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_BirthDateG,testdatamap.get("Date").toString());
        Log.ReportEvent("PASS", " Enter Parameter : BirthDataG is Successful");
        this.takeScreenShot();
    }
    // Method to enter Nin Or Iqama Number
    public void enterNinOrIqamaNumber(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_NinOrIqamaNumber,testdatamap.get("NinOrIqama").toString());
        Log.ReportEvent("PASS", " Enter Parameter : NinOrIqama Number is Successful");
        this.takeScreenShot();
    }
    // Method to enter molEstID
    public void enterMolEstID(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_molEstID,testdatamap.get("molEstID").toString());
        Log.ReportEvent("PASS", " Enter Parameter : molEstID is Successful");
        this.takeScreenShot();
    }
    // Method to enter molEstOfficeID
    public void enterMolEstOfficeID(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_molEstOfficeID,testdatamap.get("molEstOfficeID").toString());
        Log.ReportEvent("PASS", " Enter Parameter : molEstOfficeID is Successful");
        this.takeScreenShot();
    }
    // Method to enter Unified ID
    public void enterUnifiedID(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_UnifiedId,testdatamap.get("UnifiedID").toString());
        Log.ReportEvent("PASS", " Enter Parameter : UnifiedID is Successful");
        this.takeScreenShot();
    }
    // Method to enter url
    public void enterUrl(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_Url,testdatamap.get("Url").toString());
        Log.ReportEvent("PASS", " Enter Parameter : url is Successful");
        this.takeScreenShot();
    }
    // Method to enter Id
    public void enterId(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_Id,testdatamap.get("Id").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Id is Successful");
        this.takeScreenShot();
    }
    // Method to enter Country code
    public void enterCountryCode(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_CountryCode,testdatamap.get("CountryCode").toString());
        Log.ReportEvent("PASS", " Enter Parameter : CountryCode is Successful");
        this.takeScreenShot();
    }
    // Method to enter Deed Number
    public void enterDeedNumber(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_DeedNumber,testdatamap.get("DeedNumber").toString());
        Log.ReportEvent("PASS", " Enter Parameter : DeedNumber is Successful");
        this.takeScreenShot();
    }
    // Method to enter Id Number
    public void enterIdNumber(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_IdNumber,testdatamap.get("IdNumber").toString());
        Log.ReportEvent("PASS", " Enter Parameter : IdNumber is Successful");
        this.takeScreenShot();
    }
    // Method to enter X Signature
    public void enterXSignature(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_XSignature,testdatamap.get("XSignature").toString());
        Log.ReportEvent("PASS", " Enter Parameter : X Signature is Successful");
        this.takeScreenShot();
    }
    // Method to enter X Contracts Signature
    public void enterXContractsSignature(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_XContractsSignature,testdatamap.get("XContractsSignature").toString());
        Log.ReportEvent("PASS", " Enter Parameter : X Contracts Signature is Successful");
        this.takeScreenShot();
    }
    // Method to enter X Contracts Time Stamp
    public void enterXContractsTimeStamp(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_XContractsTimestamp,testdatamap.get("XContractsTimeStamp").toString());
        Log.ReportEvent("PASS", " Enter Parameter : X Contracts Timestamp is Successful");
        this.takeScreenShot();
    }
    // Method to enter Contract Number
    public void enterContractNumber(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_ContractNumber,testdatamap.get("ContractNumber").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Contract Number Timestamp is Successful");
        this.takeScreenShot();
    }
    // Method to enter National Number
    public void enterNationalNumber(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_NationalNumber,testdatamap.get("NationalNumber").toString());
        Log.ReportEvent("PASS", " Enter Parameter : nationalNumber is Successful");
        this.takeScreenShot();
    }
    // Method to enter National Number
    public void selectDateType(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
        WebClick(UapiOR.Customer_CustomerServices_Page_SelectDateType);
        Thread.sleep(500);
        WebClick("//option[text()='" + testdatamap.get("DateType").toString() + "']");
        Log.ReportEvent("PASS", " Enter Parameter : DateType is Successful");
        this.takeScreenShot();
    }
    // Method to Select Card Type
    public void selectCards(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
        WebClick(UapiOR.Customer_CustomerServices_Page_Cards);
        Thread.sleep(500);
        WebClick("//option[text()='" + testdatamap.get("Cards").toString() + "']");
        Log.ReportEvent("PASS", " Enter Parameter : Cards is Successful");
        this.takeScreenShot();
    }
    // Method to enter Id Value
    public void enterIdValue(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_IDValue,testdatamap.get("idValue").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Id Value is Successful");
        this.takeScreenShot();
    }
    // Method to enter CR
    public void selectCR(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
        WebClick(UapiOR.Customer_CustomerServices_Page_CR);
        Thread.sleep(500);
        WebClick("//option[text()='" + testdatamap.get("Identification Type").toString() + "']");
        Log.ReportEvent("PASS", " Enter Parameter : Cards is Successful");
        this.takeScreenShot();
    }
    // Method to enter Contract Number
    public void enterContractNumbers(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_contractNumber,testdatamap.get("contractNumber").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Contract Number is Successful");
        this.takeScreenShot();
    }
    // Method to enter Contract Number
    public void enterPersonalIdNumber(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_PersonalIdNumber,testdatamap.get("personalIdNumber").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Personal Id Number is Successful");
        this.takeScreenShot();
    }
    // Method to Select ID Type
    public void selectIdType(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
        WebClick(UapiOR.Customer_CustomerServices_Page_IdType);
        Thread.sleep(500);
        WebClick("//option[text()='" + testdatamap.get("IdType").toString() + "']");
        Log.ReportEvent("PASS", " Enter Parameter : Id Type is Successful");
        this.takeScreenShot();
    }
    // Method to enter Pay Month
    public void enterPayMonth(Map<Object, Object> testdatamap,Log Log) {
        WebEdit(UapiOR.Customer_CustomerServices_Page_PayMonth,testdatamap.get("payMonth").toString());
        Log.ReportEvent("PASS", " Enter Parameter : Pay Month is Successful");
        this.takeScreenShot();
    }
}
