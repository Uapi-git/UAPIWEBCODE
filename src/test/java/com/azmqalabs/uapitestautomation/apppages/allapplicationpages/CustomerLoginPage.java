/**
 * Test Script Name                      : CustomerLoginPage.
 * Objective                             : Verify the Customer Login Page Functionality.
 * Version                               : 1.0
 * Author                                : Basavaraj Mudnur
 * Created Date                          : 24/06/2024
 * Last Updated on                       : N/A
 * Updated By                            :
 * Epic Details                          : N/A
 * User Story Details                    : N/A
 * Defects affecting this test script    : None
 * Work Around/Known Issues              : None
 */
package com.azmqalabs.uapitestautomation.apppages.allapplicationpages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.azmqalabs.uapitestautomation.apppages.GlobalConstant;
import com.azmqalabs.uapitestautomation.apppages.masterpages.BasePage;
import com.azmqalabs.uapitestautomation.common.Log;
import com.azmqalabs.uapitestautomation.common.ReadData;
import com.azmqalabs.uapitestautomation.common.uielement.fieldDecorator;
import com.azmqalabs.uapitestautomation.objectrepository.UapiOR;
import com.codoid.products.fillo.Recordset;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class CustomerLoginPage extends BasePage {

    public CustomerLoginPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Customer_LoginPage_UAPILogo)
    public WebElement loginPageLogo;

    public boolean Exists() {
        return super.Exists(loginPageLogo);
    }

    /**
     * Login to application
     *
     * @param testdatamap <Map> - TestDataMap
     * @param log         <Log> - Log
     */
    public void loginToApplication(Map<Object, Object> testdatamap, Log log) throws Exception {

        Recordset login = ReadData.readTestDataBySpecifiedValue("Login", "LoginCategory", testdatamap.get("LoginCategory").toString());
        login.next();
        this.Exists();
        try {
            if (IsDispalyed(UapiOR.Customer_LoginPage_Username)) {
                WebEdit(UapiOR.Customer_LoginPage_Username, login.getField("LoginUserName"));
                WebEdit(UapiOR.Customer_LoginPage_Password, login.getField("LoginPassword"));
                WebClick(UapiOR.Customer_LoginPage_LogIn);
                Thread.sleep(5000);
            } else {
                WebEdit(UapiOR.Customer_LoginPage_Username, login.getField("LoginUserName"));
                WebClick(UapiOR.Customer_LoginPage_LogIn);
            }
            test.log(Status.PASS, "#FUNC - Login To " + login.getField("LoginCategory") + "Application * Login To Application PASS * ");
            log.ReportEvent("PASS", " Verify " + login.getField("LoginCategory") + " Login is Successful");
            this.takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "#FUNC - Login To " + login.getField("LoginCategory") + "Application * Login To Application FAILED * ");
            this.takeScreenShot();
        }
    }

    public void loginToApplication(String username, String password, Log log) {
        try {
            this.Exists();
            if (IsDispalyed(UapiOR.Customer_LoginPage_Username)) {
                WebEdit(UapiOR.Customer_LoginPage_Username, username);
                WebEdit(UapiOR.Customer_LoginPage_Password, password);
                WebClick(UapiOR.Customer_LoginPage_LogIn);
                Thread.sleep(5000);
            } else {
                WebEdit(UapiOR.Customer_LoginPage_Username, GlobalConstant.GLOBALTESTDATALOGINMAP.get("LoginUserName"));
                WebClick(UapiOR.Customer_LoginPage_LogIn);

            }
            test.log(Status.PASS, "#FUNC - Login To Application " + driver.getTitle() + " * Login To Application PASS * ");
            log.ReportEvent("PASS", " Verify Login is Successful");
            this.takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "#FUNC-LoginToApplication" + driver.getTitle() + " * Login To Application FAILED * ");
            this.takeScreenShot();
        }
    }

    /**
     * Method to click on Logout
     *
     * @param Log <Log> - Log
     */
    public void logout(Log Log) {
        try {
            WebClick(UapiOR.Customer_Profile_DownArrowIcon);
            WebClick(UapiOR.Customer_SignOut);
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
