/**
 * Test Script Name                      : CustomerRolesAndPermissions.
 * Objective                             : Verify the Customer Roles and Permissions page Functionality.
 * Version                               : 1.0
 * Author                                : Arun Kumar MS
 * Created Date                          : 05/07/2024
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

import java.util.Map;

public class CustomerRolesAndPermissionsPage extends BasePage {

    public CustomerRolesAndPermissionsPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Customer_CustomerRolesAndPermissions_Page_RolesAndPermissionText)
    public WebElement customerRolesAndServicePage;

    public boolean Exists() {
        return super.Exists(customerRolesAndServicePage);
    }

    // Method to validate Customer Roles and Permission Page
    public void verifyRolesAndPermissionPageIsDisplayed(Log Log) {
        try {
            Thread.sleep(1000);
            verifyElementIsPresent(UapiOR.Customer_CustomerRolesAndPermissions_Page_RolesAndPermissionText);
            test.log(Status.PASS, "Verify Roles and permission screen is displayed" + driver.getTitle() + "Verify Roles and permission screen is displayed is Pass");
            Log.ReportEvent("PASS", "User Navigated to Customer Roles and permission page");
            this.takeScreenShot();

        } catch (Exception e) {
            this.takeScreenShot();
            test.log(Status.FAIL, "Verify Roles and permission screen is displayed" + driver.getTitle() + "Verify Roles and permission screen is displayed is Fail");

        }
    }

    // Method to click on Customer Roles and Permission button
    public void clickOnCustomerRolesAndPermission() {
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_RolesAndPermissionBtn);
    }

    // Method to click on View
    public void clickOnView(Log Log) {
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_View);
        Log.ReportEvent("PASS", "Click on View in Roles And Permission Screen is successful");
        this.takeScreenShot();
    }

    // Method to click on Edit
    public void clickOnEdit(Log Log) {
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_Edit);
        Log.ReportEvent("PASS", "Click on Edit in Roles And Permission Screen is successful");
        this.takeScreenShot();
    }

    // Method to click on Action Button
    public void clickOnActionButton(Log Log) throws InterruptedException {
        Thread.sleep(1000);
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_FirstRecordActionBtn);
        Log.ReportEvent("PASS", " Click on 'Action' option In Roles And Permission is Successful");
        this.takeScreenShot();

    }

    /**
     * Method to verify view Mode after click on view from action list
     */
    public void verifyViewModeAfterClickOnViewFromActionList() {
        boolean isRoleIdDisabled = driver.findElement(By.xpath(UapiOR.Customer_CustomerRolesAndPermissions_Page_ViewRoleId)).getAttribute("class").contains("Mui-disabled");
        boolean isRoleNameDisabled = driver.findElement(By.xpath(UapiOR.Customer_CustomerRolesAndPermissions_Page_ViewRoleName)).getAttribute("class").contains("Mui-disabled");
        boolean isRoleStatusDisabled = driver.findElement(By.xpath(UapiOR.Customer_CustomerRolesAndPermissions_Page_ViewRoleStatusDropdown)).getAttribute("class").contains("Mui-disabled");
        boolean isPermissionRadioBtnDisabled = driver.findElement(By.xpath(UapiOR.Customer_CustomerRolesAndPermissions_Page_ViewRolePermissionRatioBtn)).getAttribute("class").contains("Mui-disabled");

        Assert.assertTrue(isRoleIdDisabled, "Role Id TextField is enabled");
        Assert.assertTrue(isRoleNameDisabled, "Role Name TextField is enabled");
        Assert.assertTrue(isRoleStatusDisabled, "Role Status Dropdown TextField is enabled");
        Assert.assertTrue(isPermissionRadioBtnDisabled, "Role permission Radio button is enabled");
    }

    // Method to click on Add Role
    public void clickOnAddRole(Log Log) throws InterruptedException {
        Thread.sleep(1000);
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_AddRole);
        Log.ReportEvent("PASS", "Click on 'Add Role' option in Roles And Permission Screen is successful");
        this.takeScreenShot();
    }

    // Method to click on Cancel
    public void clickOnCancel(Log Log) {
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_Cancel);
        Log.ReportEvent("PASS", "Click on 'Cancel' option in Add Roles And Permission Screen is successful");
        this.takeScreenShot();
    }

    // Method to click on yes button in Cancel conformation popup
    public void clickOnYesInCancelConformationPopup() {
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_YesButton);
    }

    // Method to click on Save
    public void clickOnSave(Log Log) throws InterruptedException {
        Thread.sleep(2000);
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_Save);
        Log.ReportEvent("PASS", "Click on 'Save' option in Add Roles And Permission Screen is successful");
        this.takeScreenShot();
    }

    // Method to click on Enable All Radio Button
    public void clickOnPermissionDropDown() {
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_PermissionDropDown);
    }

    // Method to enter role name
    public void enterRoleName(Map<Object, Object> testdatamap) {
        WebEdit(UapiOR.Customer_CustomerRolesAndPermissions_Page_RoleName, testdatamap.get("RoleName").toString());
    }

    // Method to select status
    public void selectStatus(Map<Object, Object> testdatamap) throws InterruptedException {
        Thread.sleep(1000);
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_StatusDropdown);
        WebClick("//li[text()='" + testdatamap.get("Status").toString() + "']");
    }

    // Method to select and deselect any Permissions in Add Roles And Permission Screen
    public void selectAndDeselectPermissionsForPermissionDropdown(Map<Object, Object> testdatamap, Log Log) {
        String selectAndDeSelectPermissionsNames = testdatamap.get("SelectAndDeselectPermissionNames").toString();
        String[] permissionNames = selectAndDeSelectPermissionsNames.split(",");
        for (String permissionName : permissionNames) {
            WebClick("//li[text()='" + permissionName + "']");
        }
        Log.ReportEvent("PASS", " select and deselect permissions in Add Roles and Permission Screen is Successful");
        this.takeScreenShot();
    }

    // Method to verify Selected permission is Displayed In Selected Permission Box in Edit Roles And Permission Screen
    public void verifySelectedPermissionIsDisplayedInSelectedPermissionBox(Map<Object, Object> testdatamap, Log Log) throws Exception {
        String selectedPermissionsNames = testdatamap.get("SelectedPermissionNames").toString();
        String[] permissionNames = selectedPermissionsNames.split(",");
        for (String permissionName : permissionNames) {
            verifyElementIsPresent("//span[text()='" + permissionName + "']");
        }
        Log.ReportEvent("PASS", " verify Selected permission is displayed in Selected permission Box is Successful");
        this.takeScreenShot();
    }

    // Method to verify Error Message in Add Role and Permission Screen
    public void verifyErrorMessageInAddRoleAndPermissionScreen(Map<Object, Object> testdatamap, Log Log) {
        try {
            clickOnSave(Log);
            Thread.sleep(2000);
            verifyElementIsPresent(UapiOR.Customer_CustomerRolesAndPermissions_Page_BlankRoleNameErrorMessage);
            verifyElementIsPresent(UapiOR.Customer_CustomerRolesAndPermissions_Page_BlankPermissionErrorMessage);
            enterRoleName(testdatamap);
            clickOnSave(Log);
            Thread.sleep(2000);
            verifyElementIsPresent(UapiOR.Customer_CustomerRolesAndPermissions_Page_InvalidRoleNameErrorMessage);
            Log.ReportEvent("PASS", " Enter incorrect details and click Save button is Successful");
            this.takeScreenShot();
        } catch (Exception e) {
            Log.ReportEvent("Fail", " Enter incorrect details and click Save button is UnSuccessful");
            this.takeScreenShot();
        }
    }

    // Method to create new role
    public void createNewRole(Map<Object, Object> testdatamap, Log Log) {
        try {
            selectStatus(testdatamap);
            enterRoleName(testdatamap);
            clickOnPermissionDropDown();
            selectAndDeselectPermissionsForPermissionDropdown(testdatamap, Log);
            verifySelectedPermissionIsDisplayedInSelectedPermissionBox(testdatamap, Log);
            clickOnPermissionDropDown();
            clickOnSave(Log);
            Thread.sleep(1000);
            verifyElementIsPresent(UapiOR.Customer_CustomerRolesAndPermissions_Page_RoleCreatedSuccessfulMsg);
            test.log(Status.PASS, "Enter valid details and click Save button" + driver.getTitle() + "Enter valid details and click Save button is Pass");
            Log.ReportEvent("PASS", "Enter valid details and click Save button is Successful");
            this.takeScreenShot();
        } catch (Exception e) {
            test.log(Status.FAIL, "Enter valid details and click Save button" + driver.getTitle() + "Enter valid details and click Save button is Fail");
            this.takeScreenShot();
        }
    }

    // Method to search role in roles and permission screen
    public void searchRole(Map<Object, Object> testdatamap, Log log) {
        try {
            webClear(driver,UapiOR.Customer_CustomerRolesAndPermissions_Page_SearchField);
            WebEdit(UapiOR.Customer_CustomerRolesAndPermissions_Page_SearchField, testdatamap.get("RoleName").toString());
            WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_SearchBtn);

            test.log(Status.PASS, "#FUNC - Enter keyword in search textbox and Enter " + " *  Enter keyword in search textbox and Enter is Pass * ");
            log.ReportEvent("PASS", " Enter keyword in search textbox and Enter is successful");
            takeScreenShot();

        } catch (Exception e) {
            test.log(Status.PASS, " Enter keyword in search textbox and Enter " + " *  Enter keyword in search textbox and Enter is Fail * ");
            this.takeScreenShot();
        }
    }

    // Method to verify role Name in roles and permission Screen
    public void verifyRoleName(Map<Object, Object> testdatamap, Log log) throws Exception {
        waitForTwoSec();
        verifyElementIsPresent("//h2[text()='" + testdatamap.get("RoleName").toString() + "']");
        log.ReportEvent("PASS", " verify role Name in roles and permission grid is successful");
        takeScreenShot();
    }

    // Method to validate Customer Add Roles and Permission Page
    public void verifyAddRolesAndPermissionPageIsDisplayed(Log Log) {
        try {
            Thread.sleep(2000);
            verifyElementIsPresent(UapiOR.Customer_CustomerRolesAndPermissions_Page_AddRolesAndPermissionText);
            test.log(Status.PASS, "Verify Add Roles and permission screen is displayed" + driver.getTitle() + "Verify Add Roles and permission screen is displayed is Pass");
            Log.ReportEvent("PASS", "User Navigated to Customer Add Roles and permission page");
            this.takeScreenShot();

        } catch (Exception e) {
            this.takeScreenShot();
            test.log(Status.FAIL, "Verify Add Roles and permission screen is displayed" + driver.getTitle() + "Verify Add Roles and permission screen is displayed is Fail");

        }
    }
    // Method to click on Delete
    public void clickOnDelete(Log Log) {
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_Delete);
        Log.ReportEvent("PASS", "Click on Delete in Roles And Permission Screen is successful");
        this.takeScreenShot();
    }
    // Method to verify Delete popup
    public void verifyDeleteConformationPopup() throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerRolesAndPermissions_Page_DeleteConformationPopup);
        verifyElementIsPresent(UapiOR.Customer_CustomerRolesAndPermissions_Page_DeleteConformationPopupYes);
        verifyElementIsPresent(UapiOR.Customer_CustomerRolesAndPermissions_Page_DeleteConformationPopupNo);
    }
    // Method to click on yes button
    public void clickOnYesInDeleteConformationPopup() {
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_DeleteConformationPopupYes);
    }
    // Method to verify Role Delete Successfully Conformation Message
    public void verifyRoleDeleteSuccessfullyConformationMessage(Map<Object, Object> testdatamap,Log Log) throws Exception {
        Thread.sleep(2000);
        VerifyValue1(getText(UapiOR.Customer_CustomerRolesAndPermissions_Page_DeletedConformationMsg), testdatamap.get("DeletedConformationMessage").toString());
        Log.ReportEvent("PASS", "Role Deleted Successfully in Roles And Permission Screen is successful");
        this.takeScreenShot();
    }
    // Method to verify Role Deleted Successfully
    public void verifyRoleDeletedSuccessfully() throws Exception {
        Thread.sleep(2000);
        verifyElementIsPresent(UapiOR.Customer_CustomerRolesAndPermissions_Page_DeletedSuccessfully);
        this.takeScreenShot();
    }
    // Method to verify Role Delete Successfully Conformation Message
    public void verifyUserNotAbleToDeleteRoleIfRoleIsAttachedToUser(Map<Object, Object> testdatamap,Log Log) throws Exception {
        Thread.sleep(2000);
        VerifyValue1(getText(UapiOR.Customer_CustomerRolesAndPermissions_Page_DeletedConformationMsg), testdatamap.get("UnDeleteConformationMessage").toString());
        Log.ReportEvent("PASS", "user can not be deleted the role Conformation Message in Roles And Permission Screen is successful");
        this.takeScreenShot();
    }
    // Method to click on clear button in Account Management Search Test Field
    public void clickOnClearButton() {
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_ClearButton);
    }
}
