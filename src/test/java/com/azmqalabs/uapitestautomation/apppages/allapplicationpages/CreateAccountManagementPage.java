/**
 * Test Script Name                      : CreateAccountManagementPage.
 * Objective                             : Verify the create Account Management Functionality.
 * Version                               : 1.0
 * Author                                : Arun Kumar M S
 * Created Date                          : 11/06/2024
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

public class CreateAccountManagementPage extends BasePage {

	public CreateAccountManagementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = UapiOR.Admin_CreateAccountManagement_Page_CreateAccountText)
	public WebElement createAccountManagementText;

	public boolean Exists() {
		return super.Exists(createAccountManagementText);
	}


	// Method to select sector value from dropdown
	public void selectSectorValueFromDropdown(Map<Object, Object> testdatamap) throws InterruptedException {
		Thread.sleep(1000);
		WebClick(UapiOR.Admin_CreateAccountManagement_Page_GeneralInfoSelectorDropdown);
		Thread.sleep(1000);
		WebClickUsingJS("//li[text()='" + testdatamap.get("Sector").toString() + "']");
		Thread.sleep(1000);
	}

	// Method to select Issue Date
	public void selectIssueDate(Map<Object, Object> testdatamap) throws InterruptedException {
		WebClick(UapiOR.Admin_CreateAccountManagement_Page_IssueDate);
		Thread.sleep(200);
		WebClick(UapiOR.Admin_CreateAccountManagement_Page_Year);
		Thread.sleep(200);
		WebClick("//button[text()='" + testdatamap.get("FromYear").toString() + "']");
		Thread.sleep(200);
		WebClick("//button[text()='" + testdatamap.get("FromMonth").toString() + "']");
		Thread.sleep(200);
		WebClick("//button[text()='" + testdatamap.get("FromDay").toString() + "']");
	}
	// Method to select expiry Date
	public void selectExpiryDate(Map<Object, Object> testdatamap) throws InterruptedException {
		WebClick(UapiOR.Admin_CreateAccountManagement_Page_ExpireDate);
		Thread.sleep(200);
		WebClick(UapiOR.Admin_CreateAccountManagement_Page_Year);
		Thread.sleep(200);
		WebClick("//button[text()='" + testdatamap.get("ToYear").toString() + "']");
		Thread.sleep(200);
		WebClick("//button[text()='" + testdatamap.get("ToMonth").toString() + "']");
		Thread.sleep(200);
		WebClick("//button[text()='" + testdatamap.get("ToDay").toString() + "']");
	}


	// Method to enter Company Name
	public void enterCompanyName(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_GeneralInfoCompanyName, testdatamap.get("CompanyName").toString());
	}
	// Method to enter Commercial Registry Number
	public void enterCommercialRegistryNumber(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_GeneralInfoCommercialRegistry, testdatamap.get("RegistryNumber").toString());
	}
	// Method to enter Commercial Registry Number
	public void enterNationalNumber(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_GeneralInfoNationalNumber, testdatamap.get("NationalNumber").toString());
	}
	// Method to enter Email
	public void enterEmail(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_GeneralInfoCompanyEmail, testdatamap.get("Email").toString());
	}
	// Method to enter Tax Number
	public void enterTaxNumber(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_GeneralInfoTaxNumber, testdatamap.get("TaxNumber").toString());
	}
	// Method to enter Web Site Url
	public void enterWebSiteUrl(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_GeneralInfoWebSiteUrl, testdatamap.get("WebSiteUrl").toString());
	}
	// Method to click on Next button
	public void clickOnNext() {
		WebClick(UapiOR.Admin_CreateAccountManagement_Page_NextButton);
	}

	// Method to enter General Info
	public void enterGeneralInfo(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			enterCompanyName(testdatamap);
			enterCommercialRegistryNumber(testdatamap);
			enterNationalNumber(testdatamap);
			enterEmail(testdatamap);
			enterTaxNumber(testdatamap);
			enterWebSiteUrl(testdatamap);
			selectIssueDate(testdatamap);
			selectExpiryDate(testdatamap);
			selectSectorValueFromDropdown(testdatamap);
			clickOnNext();
			test.log(Status.PASS, "click on 'General Information' tab and fill details In Create Account Management" + driver.getTitle() + " * click on 'General Information' tab and fill details  PASS * ");
			Log.ReportEvent("PASS", " click on 'General Information' tab and fill details In Create Account Management is Successful");
			this.takeScreenShot();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "verify rows per page count retrieve correctly In Account Management" + driver.getTitle() + " * click on 'General Information' tab and fill details  Fail * ");

		}


	}

	// Method to click on Settings button
	public void clickOnSettings(Log Log) {
		WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_Settings);
		Log.ReportEvent("PASS", " click on 'Settings' tab In Create Account Management is Successful");

	}
	// Method to click on Allow post pay access
	public void clickOnAllowPostPayAccess() throws Exception {

		WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllowPostPayAccess);

	}
	// Method to verify Allow post pay access is displayed
	public void verifyAllowPostPayAccessDisplayed(Map<Object, Object> testdatamap,Log Log) throws Exception {
		VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllowPostPayAccess), testdatamap.get("AllowPostPaidText").toString());
		Log.ReportEvent("PASS", " Verify 'Allow Postpaid Packages' checkbox is available on screen In Create Account Management is Successful");

	}
	// Method to verify Allow post pay access is checked
	public void verifyAllowPostPayAccessChecked() throws Exception {
		verifyElementIsPresent(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllowPostPayAccessChecked);

	}
	// Method to verify Allow post pay access is Unchecked
	public void verifyAllowPostPayAccessUnChecked() throws Exception {
		verifyElementIsPresent(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllowPostPayAccessUnChecked);

	}
	//Function Summary  : Method to verify all Active Services for Settings Tab
	public void verifyAllActiveServicesInSettingsTab(Log Log) {
		try {
			WebElement element = driver.findElement(By.xpath(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllServices));
			scrollToElement(driver,element);
			Thread.sleep(2000);
			this.takeScreenShot();
			String expectedServices[] = {"SIMAH", "WATHQ", "TCC", "YAKEEN", "ETIMAD", "MASDR", "UNIFONIC","MSEGAT","FINTECH","LEAN TECH","DEEWAN"};
			List<WebElement> activeServices = getElements(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllServicesOptions);
			if (activeServices.size() == 11) {

				for (int i = 0; i < activeServices.size(); i++) {
					String actualService = activeServices.get(i).getText();
					System.out.println("----actual dropdown values--- " + actualService);
					String expectedService = expectedServices[i];
					Assert.assertEquals(actualService, expectedService);
				}
			}
			this.takeScreenShot();
			test.log(Status.PASS, "verify All Services List In Account Management Settings Screen" + driver.getTitle() + " *  verify All Services List in Settings tab PASS * ");
			Log.ReportEvent("PASS", " verify All Services List In Account Management Settings Screen is Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "verify All Services List In Account Management Settings Screen" + driver.getTitle() + " * verify All Services List in Settings tab FAIL * ");
		}

	}
	// Method to select services From All Services
	public void selectServicesFromAllServices(String... services) {
		for (String service : services)
		{
			WebClick("//button[contains(@class,'MuiIconButton-sizeMedium')]//following-sibling::div//following-sibling::div//span[text()='" + service + "']");
		}
	}
	// Method to Deselect services
	public void DeselectServicesFromAllServices(String... services) {
		for (String service : services)
		{
			WebClick("//span[text()='Selected Service']//ancestor::div[contains(@class,'MuiCardHeader-root')]/following-sibling::div//button[contains(@class,'MuiIconButton-sizeMedium')]//following-sibling::div//following-sibling::div//span[text()='" + service + "']");
		}
	}
	// Method to move selected Services
	public void moveSelectedServices(Log Log)
	{
		WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllServicesToSelect);
		Log.ReportEvent("PASS", " verify User able to select Services In Create Account Management Settings Screen is Successful");
		this.takeScreenShot();


	}
	// Method to remove selected Services
	public void removeSelectedServices(Log Log)
	{
		WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllServicesToDeSelect);
		Log.ReportEvent("PASS", " verify User able to deselect Services In Create Account Management Settings Screen is Successful");
		this.takeScreenShot();


	}

	// Method to verify Selected Services
	public void verifySelectedServices(String... services) throws Exception {
		for (String service : services) {
			verifyElementIsPresent("//span[text()='Selected Service']//ancestor::div[contains(@class,'MuiCardHeader-root')]/following-sibling::div//button[contains(@class,'MuiIconButton-sizeMedium')]//following-sibling::div//following-sibling::div//span[text()='" + service + "']");
		}
	}
	// Method to verify deselected Services
	public void verifyDeSelectedServicesAreNotDisplayed(String... services) throws Exception {
		for (String service : services) {
			verifyElementIsNotPresent("//span[text()='Selected Service']//ancestor::div[contains(@class,'MuiCardHeader-root')]/following-sibling::div//button[contains(@class,'MuiIconButton-sizeMedium')]//following-sibling::div//following-sibling::div//span[text()='" + service + "']");
		}
	}

	//Method to verify WebSiteUrl error Message
	public void verifyWebSiteUrlErrorMessage(Map<Object, Object> testdatamap) throws Exception {
		enterWebSiteUrl(testdatamap);
		clickOnNext();
		VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_WebSiteUrlErrorMessage), testdatamap.get("BlankWebSiteUrlError").toString());
		this.takeScreenShot();
	}
	//Method to verify Email error Message
	public void verifyEmailErrorMessage(Map<Object, Object> testdatamap) throws Exception {
		enterEmail(testdatamap);
		clickOnNext();
		VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_EmailErrorMessage), testdatamap.get("InvalidEmailError").toString());
	}
	// Method to verify Error message in General Info tab
	public void verifyErrorMessageInEnterGeneralInfoTab(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			enterCompanyName(testdatamap);
			enterCommercialRegistryNumber(testdatamap);
			enterNationalNumber(testdatamap);
			enterTaxNumber(testdatamap);
			selectIssueDate(testdatamap);
			selectExpiryDate(testdatamap);
			selectSectorValueFromDropdown(testdatamap);
			verifyWebSiteUrlErrorMessage(testdatamap);
			verifyEmailErrorMessage(testdatamap);
			test.log(Status.PASS, "verify system displays error message on blank data or incorrect data in fields In Create Account Management" + driver.getTitle() + " * Verify Error message in General Info Tab PASS * ");
			Log.ReportEvent("PASS", " verify system displays error message on blank data or incorrect data in fields In Create Account Management is Successful");
			this.takeScreenShot();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "verify system displays error message on blank data or incorrect data in fields In Account Management" + driver.getTitle() + " * Verify Error message in General Info Tab  Fail * ");

		}


	}
	// Method to click on Next button
	public void clickOnAuthorizedPersonInformation() {
		WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_AuthorizedPersonInformation);
	}
	// Method to enter Full Name
	public void enterFullName(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AuthorizedPersonInfoFirstName, testdatamap.get("FirstName").toString());
	}
	// Method to enter Last Name
	public void enterLastName(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AuthorizedPersonInfoLastName, testdatamap.get("LastName").toString());
	}
	// Method to enter National Id
	public void enterNationalId(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AuthorizedPersonInfoNationalId, testdatamap.get("NationalId").toString());
	}
	// Method to enter Person Info Email
	public void enterPersonInfoEmail(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AuthorizedPersonInfoEmail, testdatamap.get("PersonInfoEmail").toString());
	}
	// Method to enter Mobile Number
	public void enterMobileNumber(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AuthorizedPersonInfoMobileNumber, testdatamap.get("MobileNumber").toString());
	}
	// Method to select sector value from dropdown
	public void selectCityFromDropdown(Map<Object, Object> testdatamap) throws InterruptedException {
		Thread.sleep(1000);
		WebClick(UapiOR.Admin_CreateAccountManagement_Page_AuthorizedPersonInfoCityDropdown);
		Thread.sleep(1000);
		WebClickUsingJS("//span[text()='" + testdatamap.get("CityName").toString() + "']");
	}

	// Method to enter Authorized Person Info
	public void enterAuthorizedPersonInfo(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			enterFullName(testdatamap);
			this.takeScreenShot();
			enterLastName(testdatamap);
			enterNationalId(testdatamap);
			this.takeScreenShot();
			enterPersonInfoEmail(testdatamap);
			enterMobileNumber(testdatamap);
			selectCityFromDropdown(testdatamap);
			uploadPDFFile(UapiOR.Admin_CreateAccountManagement_Page_AuthorizedPersonInfoLetterStampedField,"AuthorizedLetterStamped.pdf");
			Thread.sleep(1000);
			clickOnNext();
			test.log(Status.PASS, "click on 'Authorized Personal Information' tab and fill details In Create Account Management" + driver.getTitle() + " * click on 'Authorized Personal Information' tab and fill details  PASS * ");
			Log.ReportEvent("PASS", " click on 'Authorized Personal Information' tab and fill details In Create Account Management is Successful");
			this.takeScreenShot();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "click on 'Authorized Personal Information' tab and fill details In Create Account Management" + driver.getTitle() + " * click on 'Authorized Personal Information' tab and fill details  Fail * ");

		}
	}
	//Method to verify Authorized Person Email error Message
	public void verifyAuthorizedPersonEmailErrorMessage(Map<Object, Object> testdatamap) throws Exception {
		enterPersonInfoEmail(testdatamap);
		clickOnNext();
		VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_AuthorizedPersonInfoEmailErrorMessage), testdatamap.get("InvalidEmailError").toString());
		this.takeScreenShot();
	}
	//Method to verify Mobile Number error Message
	public void verifyAuthorizedPersonMobileNumberErrorMessage(Map<Object, Object> testdatamap) throws Exception {
		enterMobileNumber(testdatamap);
		clickOnNext();
		VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_AuthorizedPersonInfoMobileNumberErrorMessage), testdatamap.get("InvalidMobileNumberError").toString());
	}

	// Method to verify Authorized Person Info Error Message
	public void verifyAuthorizedPersonInfoErrorMessage(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			clickOnAuthorizedPersonInformation();
			enterFullName(testdatamap);
			this.takeScreenShot();
			enterLastName(testdatamap);
			enterNationalId(testdatamap);
			this.takeScreenShot();
			selectCityFromDropdown(testdatamap);
			uploadPDFFile(UapiOR.Admin_CreateAccountManagement_Page_AuthorizedPersonInfoLetterStampedField,"AuthorizedLetterStamped.pdf");
			verifyAuthorizedPersonEmailErrorMessage(testdatamap);
			verifyAuthorizedPersonMobileNumberErrorMessage(testdatamap);
			test.log(Status.PASS, "verify system displays error message on blank data or incorrect data in fields In Create Account Management" + driver.getTitle() + " * verify system displays error message on blank data or incorrect data  PASS * ");
			Log.ReportEvent("PASS", " verify system displays error message on blank data or incorrect data in fields In Create Account Management is Successful");
			this.takeScreenShot();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "verify system displays error message on blank data or incorrect data in fields In Create Account Management" + driver.getTitle() + " * verify system displays error message on blank data or incorrect data  Fail * ");

		}
	}
	/**
	 * Method verify account management screen display
	 *
	 * @param testdatamap <Map> - Test data map
	 * @param log         <Log> -Log
	 * @throws IOException
	 */
	public void verifyCreateAccountManagementScreenDisplayed(Map<Object, Object> testdatamap, Log log) throws IOException {
		try {
			this.Exists();
			VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_CreateAccountText), testdatamap.get("CreateAccountText").toString());
			this.takeScreenShot();
			test.log(Status.PASS, "#FUNC-Verify Create Account Management screen " + driver.getTitle() + " * Create Account Management screen is Pass * ");
			log.ReportEvent("PASS", "Verify Create Account Management screen displayed");
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Verify Create Account Management screen " + driver.getTitle() + " *Verify Create Account Management screen is Fail * ");
			this.takeScreenShot();
		}

	}
	// Method to enter Admin Info First Name
	public void enterAdminInfoFirstName(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoFirstName, testdatamap.get("AdminInfoFirstName").toString());
	}
	// Method to enter Admin Info Last Name
	public void enterAdminInfoLastName(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoLastName, testdatamap.get("AdminInfoLastName").toString());
	}
	// Method to enter Admin Info Email
	public void enterAdminInfoEmail(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoUserEmail, testdatamap.get("AdminInfoEmail").toString());
	}
	// Method to enter Admin Info Mobile Number
	public void enterAdminInfoMobileNumber(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoMobileNumber, testdatamap.get("AdminInfoMobileNumber").toString());
	}
	// Method to enter Admin Info National ID
	public void enterAdminInfoNationalID(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoNationalID, testdatamap.get("AdminInfoNationalId").toString());
	}
	// Method to Click on Admin Information Tab
	public void clickOnAdminInformationTab() throws InterruptedException {
		WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_AdminInfo);
		Thread.sleep(1000);
	}
	// Method to enter Admin Info UserName
	public void enterAdminInfoUserName(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoUserName, testdatamap.get("UserName").toString());
	}

	// Method to enter Admin Information
	public void enterAdminInformation(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			enterAdminInfoFirstName(testdatamap);
			enterAdminInfoLastName(testdatamap);
			this.takeScreenShot();
			enterAdminInfoEmail(testdatamap);
			enterAdminInfoUserName(testdatamap);
			this.takeScreenShot();
			enterAdminInfoMobileNumber(testdatamap);
			enterAdminInfoNationalID(testdatamap);
			clickOnNext();
			test.log(Status.PASS, "click on 'Admin Information' tab and fill details In Create Account Management" + driver.getTitle() + " * click on 'Admin Information' tab and fill details  PASS * ");
			Log.ReportEvent("PASS", " click on 'Admin Information' tab and fill details In Create Account Management is Successful");
			this.takeScreenShot();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "click on 'Admin Information' tab and fill details In Create Account Management" + driver.getTitle() + " * click on 'Admin Information' tab and fill details  Fail * ");

		}
	}
	//Method to verify Email error Message
	public void verifyAdminInfoEmailErrorMessage(Map<Object, Object> testdatamap) throws Exception {
		enterAdminInfoEmail(testdatamap);
		clickOnNext();
		VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoEmailErrorMessage), testdatamap.get("BlankEmailError").toString());
	}
	//Method to verify National ID error Message
	public void verifyAdminInfoNationalIDErrorMessage(Map<Object, Object> testdatamap) throws Exception {
		enterAdminInfoNationalID(testdatamap);
		clickOnNext();
		VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoNationalIDMessage), testdatamap.get("InvalidNationalIdError").toString());
	}
	// Method to verify Admin Information Error Message
	public void verifyAdminInformationErrorMessage(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			clickOnAdminInformationTab();
			enterAdminInfoFirstName(testdatamap);
			this.takeScreenShot();
			enterAdminInfoLastName(testdatamap);
			this.takeScreenShot();
			enterAdminInfoMobileNumber(testdatamap);
			enterAdminInfoUserName(testdatamap);
			verifyAdminInfoEmailErrorMessage(testdatamap);
			verifyAdminInfoNationalIDErrorMessage(testdatamap);
			test.log(Status.PASS, "verify system displays error message on blank data or incorrect data in fields In Create Account Management" + driver.getTitle() + " * verify 'Admin Information' tab error Message  PASS * ");
			Log.ReportEvent("PASS", " verify system displays error message on blank data or incorrect data in fields In Create Account Management is Successful");
			this.takeScreenShot();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "verify system displays error message on blank data or incorrect data in fields In Create Account Management" + driver.getTitle() + " * verify Admin Information tab error Message  Fail * ");

		}
	}
	// Method to enter National Address Building No
	public void enterBuildingNumber(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_NationalAddressBuildingNo, testdatamap.get("BuildingNo").toString());
	}

	// Method to enter National Address Secondary No
	public void enterSecondaryNumber(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_NationalAddressSecondaryNo, testdatamap.get("SecondaryNo").toString());
	}
	// Method to enter National Address District Name
	public void enterDistrictName(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_NationalAddressDistrictNo, testdatamap.get("DistrictName").toString());
	}
	// Method to enter National Address Postal Code No
	public void enterPostalCodeNumber(Map<Object, Object> testdatamap) {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_NationalAddressPostalCode, testdatamap.get("PostalCode").toString());
	}
	// Method to Click on National Address Tab
	public void clickOnNationalAddressTab() {
		WebClick(UapiOR.Admin_CreateAccountManagement_Page_NationalAddress);
	}
	// Method to select City Value from dropdown
	public void selectCityValueFromDropdown(Map<Object, Object> testdatamap) throws InterruptedException {
		Thread.sleep(1000);
		WebClick(UapiOR.Admin_CreateAccountManagement_Page_NationalAddressCityDropdown);
		Thread.sleep(1000);
		WebClickUsingJS("//span[text()='" + testdatamap.get("NationalAddressCityName").toString() + "']");
	}
	// Method to enter National Address Info
	public void enterNationalAddressInfo(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			enterBuildingNumber(testdatamap);
			this.takeScreenShot();
			enterSecondaryNumber(testdatamap);
			enterDistrictName(testdatamap);
			this.takeScreenShot();
			enterPostalCodeNumber(testdatamap);
			selectCityValueFromDropdown(testdatamap);
			clickOnNext();
			test.log(Status.PASS, "click on 'National Address' tab and fill details In Create Account Management" + driver.getTitle() + " * click on 'National Address' tab and fill details  PASS * ");
			Log.ReportEvent("PASS", " click on 'National Address' tab and fill details In Create Account Management is Successful");
			this.takeScreenShot();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "click on 'National Address' tab and fill details In Create Account Management" + driver.getTitle() + " * click on 'National Address' tab and fill details  Fail * ");

		}
	}
	// Method to verify National Address District Name Error Message
	public void verifyDistrictNameErrorMessage(Map<Object, Object> testdatamap) throws IOException {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_NationalAddressDistrictNo, testdatamap.get("DistrictName").toString());
		clickOnNext();
		VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_NationalAddressDistrictNameErrorMsg), testdatamap.get("BlankDistrictNameError").toString());

	}

	// Method to verify National Address Postal Code No Error Message
	public void verifyPostalCodeNumberErrorMessage(Map<Object, Object> testdatamap) throws IOException {
		WebEdit(UapiOR.Admin_CreateAccountManagement_Page_NationalAddressPostalCode, testdatamap.get("PostalCode").toString());
		clickOnNext();
		VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_NationalAddressPostalCodeErrorMsg), testdatamap.get("InvalidPostalCodeError").toString());

	}
	// Method to verify enter National Address Info
	public void verifyNationalAddressInfoErrorMessage(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			clickOnNationalAddressTab();
			enterBuildingNumber(testdatamap);
			this.takeScreenShot();
			enterSecondaryNumber(testdatamap);
			this.takeScreenShot();
			selectCityValueFromDropdown(testdatamap);
			verifyPostalCodeNumberErrorMessage(testdatamap);
			verifyDistrictNameErrorMessage(testdatamap);
			test.log(Status.PASS, "verify system displays error message on blank data or incorrect data in fields In Create Account Management" + driver.getTitle() + " * verify 'National Address' tab error Message  PASS * ");
			Log.ReportEvent("PASS", " verify system displays error message on blank data or incorrect data in fields In Create Account Management is Successful");
			this.takeScreenShot();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "verify system displays error message on blank data or incorrect data in fields In Create Account Management" + driver.getTitle() + " * verify 'National Address' tab error Message Fail * ");

		}
	}
	// Method to attach Attachments
	public void attachAttachments(Log Log) throws InterruptedException {
		try {
			uploadPDFFile(UapiOR.Admin_CreateAccountManagement_Page_Attachments_ArticlesOfAssociation,"AuthorizedLetterStamped.pdf");
			Thread.sleep(1000);
			this.takeScreenShot();
			uploadPDFFile(UapiOR.Admin_CreateAccountManagement_Page_Attachments_VatRegistrationCertificate,"AuthorizedLetterStamped.pdf");
			Thread.sleep(1000);
			this.takeScreenShot();
			uploadPDFFile(UapiOR.Admin_CreateAccountManagement_Page_Attachments_ZakatCertificate,"AuthorizedLetterStamped.pdf");
			this.takeScreenShot();
			Thread.sleep(1000);
			clickOnNext();
			test.log(Status.PASS, " click on 'Attachments' tab and fill details In Create Account Management" + driver.getTitle() + " *  click on 'Attachments' tab and fill details  PASS * ");
			Log.ReportEvent("PASS", "  click on 'Attachments' tab and fill details In Create Account Management is Successful");
			this.takeScreenShot();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, " click on 'Attachments' tab and fill details In Create Account Management" + driver.getTitle() + " *  click on 'Attachments' tab and fill details  Fail * ");

		}
	}
	// Method to click on Attachments Tab
	public void clickOnAttachmentTab() {
		WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_Attachments);
	}
	// Method to verify attach Attachments error message
	public void verifyAttachAttachmentsErrorMessage(Log Log) throws InterruptedException {
		try {
			clickOnAttachmentTab();
			uploadPDFFile(UapiOR.Admin_CreateAccountManagement_Page_Attachments_ArticlesOfAssociation,"word.docx");
			verifyElementIsPresent(UapiOR.Admin_CreateAccountManagement_Page_AttachmentsArticlesOfAssociationErrorMessage);
			Thread.sleep(1000);
			this.takeScreenShot();
			uploadPDFFile(UapiOR.Admin_CreateAccountManagement_Page_Attachments_ArticlesOfAssociation,"AuthorizedLetterStamped.pdf");
			Thread.sleep(1000);
			this.takeScreenShot();
			uploadPDFFile(UapiOR.Admin_CreateAccountManagement_Page_Attachments_VatRegistrationCertificate,"AuthorizedLetterStamped.pdf");
			Thread.sleep(1000);
			this.takeScreenShot();
			uploadPDFFile(UapiOR.Admin_CreateAccountManagement_Page_Attachments_ZakatCertificate,"");
			clickOnNext();
			verifyElementIsPresent(UapiOR.Admin_CreateAccountManagement_Page_AttachmentsZakatErrorMessage);
			this.takeScreenShot();
			Thread.sleep(1000);
			test.log(Status.PASS, " verify system displays error message on blank data or incorrect data in fields In Create Account Management" + driver.getTitle() + " *  verify system displays error message on blank data or incorrect data in fields  PASS * ");
			Log.ReportEvent("PASS", "  verify system displays error message on blank data or incorrect data in fields In Create Account Management is Successful");
			this.takeScreenShot();
		}
		catch(Exception e)
		{
			test.log(Status.FAIL, " verify system displays error message on blank data or incorrect data in fields In Create Account Management" + driver.getTitle() + " *  verify system displays error message on blank data or incorrect data in fields  Fail * ");

		}
	}
	// Method to select Status Dropdown value
	public void selectStatusDropdownValue(Map<Object, Object> testdatamap) throws InterruptedException {
		Thread.sleep(1000);
		WebClick(UapiOR.Admin_CreateAccountManagement_Page_SettingsStatus);
		WebClickUsingJS("//li[text()='" + testdatamap.get("Status").toString() + "']");
	}
	// Method to select Annual Subscription tiers
	public void selectAnnualSubscriptionTiers(String... annualPackages) throws InterruptedException {
		for (String annualPackage  : annualPackages)
		{
			WebClick("//li[text()='" + annualPackage + "']");
			Thread.sleep(1000);
		}
	}
	// Method to verify selected Annual Subscription Tiers
	public void verifySelectedAnnualSubscriptionTiers(String... annualPackages) throws Exception {
		for (String annualPackage : annualPackages)
		{
			verifyElementIsPresent("//span[text()='" + annualPackage + "']");
		}
		this.takeScreenShot();
	}
	// Method to select service bundles
	public void selectServiceBundles(String... servicePackages) throws InterruptedException {
		for (String servicePackage : servicePackages)
		{
			WebClick("//li[text()='" + servicePackage + "']");
			Thread.sleep(1000);
		}
	}
	// Method to verify selected service bundles
	public void verifySelectServiceBundles(String... servicePackages) throws Exception {
		for (String servicePackage : servicePackages)
		{
			verifyElementIsPresent("//span[text()='" + servicePackage + "']");
		}
		this.takeScreenShot();
	}
	// Method to select service providers
	public void selectServiceProviders(String... serviceProviders) {
		for (String serviceProvider : serviceProviders)
		{
			WebClick("//span[text()='All Service Providers']/ancestor::div[contains(@class,'MuiCardHeader-root')]//following-sibling::div//span[text()='" + serviceProvider + "']");
		}
	}
	// Method to verify Selected Service Providers
	public void verifySelectedServiceProviders(String... serviceProviders) throws Exception {
		for (String serviceProvider : serviceProviders) {
			verifyElementIsPresent("//span[text()='Logging Enabled Service Providers']/ancestor::div[contains(@class,'MuiCardHeader-root')]//following-sibling::div//span[text()='" + serviceProvider + "']");
		}
	}
	// Method to Deselect services providers
	public void deselectServiceProviders(String... serviceProviders) {
		for (String serviceProvider : serviceProviders)
		{
			WebClick("//span[text()='Logging Enabled Service Providers']/ancestor::div[contains(@class,'MuiCardHeader-root')]//following-sibling::div//span[text()='" + serviceProvider + "']");
		}
	}
	// Method to move selected Service providers
	public void moveSelectedServiceProviders(Log Log)
	{
		WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllServiceProvidersToSelect);
		Log.ReportEvent("PASS", " verify User able to select Service Providers In Create Account Management Settings Screen is Successful");
		this.takeScreenShot();
	}
	// Method to remove selected Service providers
	public void removeSelectedServiceProviders(Log Log)
	{
		WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllServiceProvidersToDeSelect);
		Log.ReportEvent("PASS", " verify User able to deselect Service Providers In Create Account Management Settings Screen is Successful");
		this.takeScreenShot();
	}
	// Method to click on Annual Subscription Tier
	public void clickOnAnnualSubscriptionDropdown(Log Log)
	{
		WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_SettingsAnnualSubscriptionTiers);
		Log.ReportEvent("PASS", " click on Annual Subscription dropdown and verify 'Annual Subscription Tier' dropdown list allows to select one or many items In Create Account Management is Successful");
		this.takeScreenShot();
	}
	// Method to click on Service Bundles
	public void clickOnServiceBundles(Log Log)
	{
		WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_SettingsServicesBundles);
		Log.ReportEvent("PASS", " click on Service Bundle dropdown and verify 'Service Bundles' dropdown list allows to select one or many items In Create Account Management is Successful");
		this.takeScreenShot();

	}
	// Method to click on Service Bundles
	public void verifySettingDetailsFilledSuccessful(Log Log)	{
		Log.ReportEvent("PASS", "  click on 'Settings' tab and fill details In Create Account Management is Successful");
		this.takeScreenShot();
	}
	// Method to click on Save Button
	public void clickOnSaveButton()
	{
		WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_SettingsSave);
		this.takeScreenShot();
	}
	// Method to verify Setting Tab Error Message
	public void verifySettingsTabErrorMessage(Map<Object, Object> testdatamap,Log Log) throws Exception {
		try{
			clickOnSaveButton();
			this.takeScreenShot();
			VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_SettingsAnnualSubscriptionErrorMsg), testdatamap.get("AnnualSubscriptionErrorMessage").toString());
			VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_SettingsServicesBundlesErrorMsg), testdatamap.get("ServiceBundlesErrorMessage").toString());
			VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_SettingsServicesErrorMsg), testdatamap.get("ServicesErrorMessage").toString());
			test.log(Status.PASS, "  *  verify system displays error message on blank data or incorrect data in fields  Pass * ");
			Log.ReportEvent("PASS", "  verify system displays error message on blank data or incorrect data in fields In Create Account Management is Successful");
			this.takeScreenShot();

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, " *  verify system displays error message on blank data or incorrect data in fields  Fail * ");
			this.takeScreenShot();

		}
	}
	//Function Summary  : Method to verify all Active Service Providers for Settings Tab
	public void verifyAllActiveServiceProvidersInSettingsTab(Log Log) {
		try {
			WebElement element = driver.findElement(By.xpath(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllServiceProviders));
			scrollToElement(driver,element);
			Thread.sleep(2000);
			this.takeScreenShot();
			String expectedServiceProviders[] = {"SIMAH", "WATHQ", "TCC", "YAKEEN", "ETIMAD", "MASDR", "UNIFONIC","MSEGAT","FINTECH","LEAN TECH","DEEWAN","CONTRACTS"};
			List<WebElement> activeServiceProviders = getElements(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllServiceProvidersOptions);
			if (activeServiceProviders.size() == 12) {

				for (int i = 0; i < activeServiceProviders.size(); i++) {
					String actualServiceProvider = activeServiceProviders.get(i).getText();
					String expectedServiceProvider = expectedServiceProviders[i];
					Assert.assertEquals(actualServiceProvider, expectedServiceProvider);
				}
			}
			this.takeScreenShot();
			test.log(Status.PASS, "verify All Service Providers List In Account Management Settings Screen" + driver.getTitle() + " *  verify All Services Providers List in Settings tab PASS * ");
			Log.ReportEvent("PASS", " verify All Services Providers List In Account Management Settings Screen is Successful");
		} catch (Exception e) {
			test.log(Status.FAIL, "verify All Services Providers List In Account Management Settings Screen" + driver.getTitle() + " * verify All Services Providers List in Settings tab FAIL * ");
		}

	}
	// Method to deSelect service providers
	public void deSelectServiceProviders(String... serviceProviders) {
		for (String serviceProvider : serviceProviders)
		{
			WebClick("//span[text()='Logging Enabled Service Providers']/ancestor::div[contains(@class,'MuiCardHeader-root')]//following-sibling::div//span[text()='" + serviceProvider + "']");
		}
	}
	// Method to verify deselected Services
	public void verifyDeSelectedServiceProvidersAreNotDisplayed(String... serviceProviders) throws Exception {
		for (String serviceProvider : serviceProviders) {
			verifyElementIsNotPresent("//span[text()='Logging Enabled Service Providers']/ancestor::div[contains(@class,'MuiCardHeader-root')]//following-sibling::div//span[text()='" + serviceProvider + "']");
		}
	}
	// Method to verify user able to click on any tab in create account Screen and user redirect to particular tab
	public void verifyUserCanRedirectsToAnyTabInCreateAccountManagementScreen(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			enterGeneralInfo(testdatamap, Log);
			clickOnAttachmentTab();
			attachAttachments(Log);
			clickOnNationalAddressTab();
			enterNationalAddressInfo(testdatamap, Log);
			clickOnAdminInformationTab();
			enterAdminInformation(testdatamap, Log);
			clickOnAuthorizedPersonInformation();
			enterAuthorizedPersonInfo(testdatamap, Log);
			Log.ReportEvent("PASS", " Click on any form name and verify application redirects to the selected form page In Account Management Settings Screen is Successful");
			test.log(Status.PASS, "Click on any form name and verify application redirects to the selected form page In Account Management Settings Screen" + driver.getTitle() + " * Click on any form name and verify application redirects to the selected form page PASS * ");
			this.takeScreenShot();

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, "Click on any form name and verify application redirects to the selected form page In Account Management Settings Screen" + driver.getTitle() + " * Click on any form name and verify application redirects to the selected form page FAIL * ");
			this.takeScreenShot();

		}

	}
	// Method to enter invalid data in one page and click on save button in other page verify error message.
	public void verifyErrorMessageInCreateAccountManagementScreen(Map<Object, Object> testdatamap,Log Log) throws InterruptedException {
		try {
			enterGeneralInfo(testdatamap, Log);
			enterAuthorizedPersonInfo(testdatamap, Log);
			clickOnAdminInformationTab();
			enterAdminInformation(testdatamap, Log);
			enterNationalAddressInfo(testdatamap, Log);
			attachAttachments(Log);
			clickOnAnnualSubscriptionDropdown(Log);
			selectAnnualSubscriptionTiers("test","ABC");
			clickOnServiceBundles(Log);
			selectServiceBundles("test package","super");
			selectServicesFromAllServices("SIMAH","WATHQ");
			moveSelectedServices(Log);
			clickOnSaveButton();
			VerifyValue1(getText(UapiOR.Admin_CreateAccountManagement_Page_FillAllDetailsErrorMsg), testdatamap.get("FillAllDetailsErrorMessage").toString());
			Log.ReportEvent("PASS", " verify application displays error message In create Account Management Screen is Successful");
			test.log(Status.PASS, " * verify application displays error message In create Account Management Screen PASS * ");
			this.takeScreenShot();

		}
		catch(Exception e)
		{
			test.log(Status.FAIL, " * verify application displays error message In create Account Management Screen FAIL * ");
			this.takeScreenShot();

		}

	}

	/**
	 * Method to create account
	 * @param testDataMap <Map> - Test data
	 * @param log <Log> - Log
	 */
	public void createAccount(Map<Object,Object> testDataMap, Log log) {
		try {
			waitForTwoSec();
			//General Information
			WebClickUsingActions(UapiOR.Admin_AccountManagement_Page_CreateAccountButton);
			enterCompanyName(testDataMap);
			enterCommercialRegistryNumber(testDataMap);
			enterNationalNumber(testDataMap);
			enterEmail(testDataMap);
			enterTaxNumber(testDataMap);
			enterWebSiteUrl(testDataMap);
			selectIssueDate(testDataMap);
			waitForTwoSec();
			selectExpiryDate(testDataMap);
			selectSectorValueFromDropdown(testDataMap);
			this.takeScreenShot();
			clickOnNext();

			//Authorized Person Information
			enterFullName(testDataMap);
			enterLastName(testDataMap);
			enterNationalId(testDataMap);
			enterPersonInfoEmail(testDataMap);
			enterMobileNumber(testDataMap);
			selectCityFromDropdown(testDataMap);
			uploadPDFFile(UapiOR.Admin_CreateAccountManagement_Page_AuthorizedPersonInfoLetterStampedField, "AuthorizedLetterStamped.pdf");
			this.takeScreenShot();
			waitForTwoSec();
			clickOnNext();

			//Admin Information
			WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoFirstName, testDataMap.get("FirstName").toString());
			WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoLastName, testDataMap.get("LastName").toString());
			WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoNationalID, testDataMap.get("NationalId").toString());
			WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoUserName, testDataMap.get("UserName").toString());
			WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoUserEmail, testDataMap.get("AdminInfoEmail").toString());
			WebEdit(UapiOR.Admin_CreateAccountManagement_Page_AdminInfoMobileNumber, testDataMap.get("MobileNumber").toString());
			this.takeScreenShot();
			waitForTwoSec();
			clickOnNext();

			//National Address
			enterBuildingNumber(testDataMap);
			enterSecondaryNumber(testDataMap);
			enterDistrictName(testDataMap);
			enterPostalCodeNumber(testDataMap);
//			selectCityValueFromDropdown(testDataMap);
			Thread.sleep(1000);
			WebClick(UapiOR.Admin_CreateAccountManagement_Page_NationalAddressCityDropdown);
			Thread.sleep(1000);
			WebClickUsingJS("//span[text()='" + testDataMap.get("CityName").toString() + "']");
			this.takeScreenShot();
			clickOnNext();

			//Attachments
			uploadPDFFile(UapiOR.Admin_ArticlesOfAssociation, "AuthorizedLetterStamped.pdf");
			waitForTwoSec();
			uploadPDFFile(UapiOR.Admin_VatRegistrationCertificate, "AuthorizedLetterStamped.pdf");
			waitForTwoSec();
			uploadPDFFile(UapiOR.Admin_ZakatCertificate, "AuthorizedLetterStamped.pdf");
			this.takeScreenShot();
			waitForTwoSec();
			clickOnNext();

			//Settings
			WebClick(UapiOR.Admin_AccountManagementPage_SettingsAnnualSubscriptionDropdown);
			String annual = testDataMap.get("AnnualSubscription").toString();
			String[] annualServices = annual.split(",");
			for (String option : annualServices) {
				WebClick("//li[@value='" + option + "']");
			}
			WebClick(UapiOR.Admin_AccountManagementPage_SettingsDropdownCloseBtn);

			WebClick(UapiOR.Admin_AccountManagementPage_SettingsServicesBundleDropdown);
			String bundle = testDataMap.get("ServicesBundle").toString();
			String[] bundleServices = bundle.split(",");
			for (String option : bundleServices) {
				WebClick("//li[@value='" + option + "']");
			}
			WebClick(UapiOR.Admin_AccountManagementPage_SettingsDropdownCloseBtn);

			String allServices = testDataMap.get("AllServices").toString();
			String[] services = allServices.split(",");
			selectServicesFromAllServices(services);

			WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllServicesToSelect);

			String allServicesLog = testDataMap.get("ServicesLogs").toString();
			String[] servicesLogs = allServicesLog.split(",");
			for (String serviceLog : servicesLogs)
			{
				WebClick("//h2[text()='Service(s) Logging']/following::div[@id='left']//span[text()='"+ serviceLog + "']");
				Thread.sleep(500);
			}
			WebClickUsingJS(UapiOR.Admin_CreateAccountManagement_Page_SettingsAllServicesLogsToSelect);

			WebClick(UapiOR.Admin_AccountManagementPage_CreateAccountButton);
			this.takeScreenShot();
			Thread.sleep(10000);
			this.takeScreenShot();
			test.log(Status.PASS, "Create new account in account management screen and add Admin user information " + " * Create new account in account management screen and add Admin user information  is PASS * ");
			log.ReportEvent("PASS", "Create new account in account management screen and add Admin user information is Successful");
			this.takeScreenShot();
		}
		catch (Exception e){
			test.log(Status.FAIL, " " +" * Create new account in account management screen and add Admin user information  is Fail * ");

		}
	}
}
