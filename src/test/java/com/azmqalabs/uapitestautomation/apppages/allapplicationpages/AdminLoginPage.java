/**
 * Test Script Name                      : AdminLogin.
 * Objective                             : Verify the Admin Login Functionality.
 * Version                               : 1.0
 * Author                                : Basavaraj Mudnur
 * Created Date                          : 06/06/2024
 * Last Updated on                       : N/A
 * Updated By                            : Basavaraj Mudnur
 * Epic Details                          : N/A
 * User Story Details                    : N/A
 * Defects affecting this test script    : None
 * Work Around/Known Issues              : None
 */
package com.azmqalabs.uapitestautomation.apppages.allapplicationpages;

import com.azmqalabs.uapitestautomation.common.ReadData;
import com.codoid.products.fillo.Recordset;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.uapitestautomation.apppages.GlobalConstant;
import com.azmqalabs.uapitestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.uapitestautomation.common.Log;
import com.azmqalabs.uapitestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.uapitestautomation.objectrepository.UapiOR;
import java.util.Map;

public class AdminLoginPage extends BasePage {

	public AdminLoginPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

		PageFactory.initElements(new fieldDecorator(driver, test), this);
	}

	@FindBy(xpath = UapiOR.Admin_LoginPage_UAPILogo)
	public WebElement loginPageLogo;

	public boolean Exists() {
		return super.Exists(loginPageLogo);
	}

	/**
	 * Login to application
	 * @param log <Log> - Log
	 */
	public void loginToApplication(Log log){
		try {
			this.Exists();
			if (IsDispalyed(UapiOR.Admin_LoginPage_Username)) {
				WebEdit(UapiOR.Admin_LoginPage_Username,  GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebEdit(UapiOR.Admin_LoginPage_Password,  GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginPassword"));
				WebClick(UapiOR.Admin_LoginPage_LogIn);
				Thread.sleep(5000);
			} else {
				WebEdit(UapiOR.Admin_LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(UapiOR.Admin_LoginPage_LogIn);
			}
			test.log(Status.PASS, "#FUNC - Login To Application " + driver.getTitle() + " * Login To Application PASS * ");
			log.ReportEvent("PASS", " Verify Admin Login is Successful");
			this.takeScreenShot();

		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC - LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}

	/**
	 * Login to application
	 * @param testdatamap <Map> - TestDataMap
	 * @param log <Log> - Log
	 */
	public void loginToApplication(Map<Object,Object> testdatamap, Log log) throws Exception {

		Recordset login= ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
		login.next();
		this.Exists();
		try {
			if (IsDispalyed(UapiOR.Admin_LoginPage_Username)) {
				WebEdit(UapiOR.Admin_LoginPage_Username,  login.getField("LoginUserName"));
				WebEdit(UapiOR.Admin_LoginPage_Password,  login.getField("LoginPassword"));
				WebClick(UapiOR.Admin_LoginPage_LogIn);
				Thread.sleep(5000);
			} else {
				WebEdit(UapiOR.Admin_LoginPage_Username, login.getField("LoginUserName"));
				WebClick(UapiOR.Admin_LoginPage_LogIn);
			}
			test.log(Status.PASS, "#FUNC - Login To " + login.getField("LoginCategory") + "Application * Login To Application PASS * ");
			log.ReportEvent("PASS", " Verify "+ login.getField("LoginCategory") +" Login is Successful");
			this.takeScreenShot();
		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC - Login To " + login.getField("LoginCategory") + "Application * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}

	public void loginToApplication(String username, String password,Log log) {
		try {
			this.Exists();
			if (IsDispalyed(UapiOR.Admin_LoginPage_Username)) {
				WebEdit(UapiOR.Admin_LoginPage_Username, username);
				WebEdit(UapiOR.Admin_LoginPage_Password, password);
				WebClick(UapiOR.Admin_LoginPage_LogIn);
				Thread.sleep(5000);
			} else {
				WebEdit(UapiOR.Admin_LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
				WebClick(UapiOR.Admin_LoginPage_LogIn);

			}
			test.log(Status.PASS, "#FUNC - Login To Application " + driver.getTitle() + " * Login To Application PASS * ");
			log.ReportEvent("PASS", " Verify Admin Login is Successful");
			this.takeScreenShot();
		} catch (Exception e) {
			test.log(Status.FAIL, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
			this.takeScreenShot();
		}
	}

	/**
	 * Method to click on Logout
	 * @param Log <Log> - Log
	 */
	public void logout(Log Log) {
		try {
			WebClick(UapiOR.Admin_HomePage_Profile);
			WebClick(UapiOR.Admin_SignOut);
			test.log(Status.PASS, "#FUNC - Logout Successful " + driver.getTitle() + " * Logout * ");
			Log.ReportEvent("PASS", "Logout  Successful ");
			Thread.sleep(1000);
			this.takeScreenShot();

		} catch (Exception e) {
			this.takeScreenShot();
			test.log(Status.FAIL, "#FUNC - Logout Not Successful" + driver.getTitle() + " * Not Logout * ");
			throw new NoSuchElementException("Logout - Logout Failed");

		}
	}
}
