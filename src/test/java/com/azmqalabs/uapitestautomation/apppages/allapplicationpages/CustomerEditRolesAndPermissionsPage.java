/**
 * Test Script Name                      : CustomerEditRolesAndPermissionsPage.
 * Objective                             : Verify the Customer Edit Roles and Permissions page Functionality.
 * Version                               : 1.0
 * Author                                : Arun Kumar MS
 * Created Date                          : 08/07/2024
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
import java.util.Map;

public class CustomerEditRolesAndPermissionsPage extends BasePage {

    public CustomerEditRolesAndPermissionsPage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;

        PageFactory.initElements(new fieldDecorator(driver, test), this);
    }

    @FindBy(xpath = UapiOR.Customer_CustomerEditRolesAndPermissions_Page_EditRolesAndPermissionText)
    public WebElement customerEditRolesAndServicePage;

    public boolean Exists() {
        return super.Exists(customerEditRolesAndServicePage);
    }

    // Method to validate Customer Roles and Permission Page
    public void verifyEditRolesAndPermissionPageIsDisplayed(Log Log) {
        try {
            Thread.sleep(1000);
            verifyElementIsPresent(UapiOR.Customer_CustomerEditRolesAndPermissions_Page_EditRolesAndPermissionText);
            this.takeScreenShot();
            test.log(Status.PASS, "Verify Edit Roles and permission screen is displayed" + driver.getTitle() + "Verify Edit Roles and permission screen is displayed is Pass");
            Log.ReportEvent("PASS", "User Navigated to Customer Edit Roles and permission page");
            this.takeScreenShot();

        } catch (Exception e) {
            this.takeScreenShot();
            test.log(Status.FAIL, "Verify Edit Roles and permission screen is displayed" + driver.getTitle() + "Verify Edit Roles and permission screen is displayed is Fail");

        }
    }

    /**
     * Method to verify editable fields in Edit Roles and Permission Screen
     */
    public void verifyEditableFieldsInEditRolesAndPermissionScreen() {
        boolean isRoleNameEnabled = !driver.findElement(By.xpath(UapiOR.Customer_CustomerRolesAndPermissions_Page_ViewRoleName)).getAttribute("class").contains("Mui-disabled");
        boolean isRoleStatusEnables = !driver.findElement(By.xpath(UapiOR.Customer_CustomerRolesAndPermissions_Page_ViewRoleStatusDropdown)).getAttribute("class").contains("Mui-disabled");
        boolean isPermissionRadioBtnEnables = !driver.findElement(By.xpath(UapiOR.Customer_CustomerRolesAndPermissions_Page_ViewRolePermissionRatioBtn)).getAttribute("class").contains("Mui-disabled");

        Assert.assertTrue(isRoleNameEnabled, "Role Name TextField is Disabled");
        Assert.assertTrue(isRoleStatusEnables, "Role Status Dropdown TextField is Disabled");
        Assert.assertTrue(isPermissionRadioBtnEnables, "Role permission Radio button is Disabled");
    }

    // Method to click on Enable All Radio Button
    public void clickEnableAllRatioButton(Log Log) {
        WebClick(UapiOR.Customer_CustomerEditRolesAndPermissions_Page_EnableAllRadioButton);
        Log.ReportEvent("PASS", "Select 'Enable All' radio button option is successful");
        this.takeScreenShot();
    }

    // Method to verify All Enabled Permissions in Edit Roles And Permission Screen
    public void verifyAllEnabledPermissionsForCustomer(Map<Object, Object> testdatamap, Log Log) throws Exception {
        String permissionsNames = testdatamap.get("AllPermissionNames").toString();
        String[] permissionNames = permissionsNames.split(",");
        for (String permissionName : permissionNames) {
            verifyElementIsPresent("//span[text()='" + permissionName + "']");
        }
        Log.ReportEvent("PASS", " verify Application should displays all the selection permission for the user");
        this.takeScreenShot();
    }

    // Method to delete or deselect any Permissions in Edit Roles And Permission Screen
    public void deleteAnyPermissionsForCustomer(Map<Object, Object> testdatamap, Log Log) throws Exception {
        String deletePermissionsNames = testdatamap.get("DeletedPermissionNames").toString();
        String[] permissionNames = deletePermissionsNames.split(",");
        for (String permissionName : permissionNames) {
            WebClick("//span[text()='" + permissionName + "']/parent::div//*[@data-testid='CancelIcon']");
        }
        Log.ReportEvent("PASS", " verify Delete any permission in Edit Roles and Permission Screen is Successful");
        this.takeScreenShot();
    }

    // Method to verify deleted permission is Not Displayed In Selected Permission Box in Edit Roles And Permission Screen
    public void verifyDeletedPermissionIsNotDisplayedInSelectedPermissionBox(Map<Object, Object> testdatamap, Log Log) throws Exception {
        String deletePermissionsNames = testdatamap.get("DeletedPermissionNames").toString();
        String[] permissionNames = deletePermissionsNames.split(",");
        for (String permissionName : permissionNames) {
            verifyElementIsNotPresent("//span[text()='" + permissionName + "']");
        }
        Log.ReportEvent("PASS", " verify Deleted permission is Not displayed in Selected permission Box is Successful");
        this.takeScreenShot();
    }

    // Method to click on Enable All Radio Button
    public void clickOnPermissionDropDown(Log Log) {
        WebClick(UapiOR.Customer_CustomerEditRolesAndPermissions_Page_PermissionDropDown);
        Log.ReportEvent("PASS", "Click 'open' icon in Edit Roles and Permission is successful");
        this.takeScreenShot();
    }

    // Method to select and deselect any Permissions in Edit Roles And Permission Screen
    public void selectAndDeselectPermissionsForPermissionDropdown(Map<Object, Object> testdatamap, Log Log) throws Exception {
        String selectAndDeSelectPermissionsNames = testdatamap.get("SelectAndDeselectPermissionNames").toString();
        String[] permissionNames = selectAndDeSelectPermissionsNames.split(",");
        for (String permissionName : permissionNames) {
            WebClick("//li[text()='" + permissionName + "']");
        }
        Log.ReportEvent("PASS", " select and deselect permissions in Edit Roles and Permission Screen is Successful");
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

    // Method to click on clear
    public void clickOnClearButton(Log Log) {
        WebElement permissionDropDown = driver.findElement(By.xpath("//button[contains(@class,'MuiAutocomplete-popupIndicator')]//*[contains(@class,'MuiSvgIcon-root')]"));
        mouseOver(driver, permissionDropDown);
        WebClick(UapiOR.Customer_CustomerEditRolesAndPermissions_Page_PermissionDropDownClear);
        Log.ReportEvent("PASS", "Click on Clear icon is successful");
        this.takeScreenShot();
    }

    // Method to Modify Role Name in edit Roles and permission Screen
    public void enterRoleName(Map<Object, Object> testdatamap,Log Log)
    {
        webClear(driver,UapiOR.Customer_CustomerRolesAndPermissions_Page_RoleName);
        WebEdit(UapiOR.Customer_CustomerRolesAndPermissions_Page_RoleName, testdatamap.get("RoleName").toString());
        Log.ReportEvent("PASS", " Modify some details in Edit Roles and Permission Screen is successful");
        this.takeScreenShot();

    }
    // Method to get Role Name
    public String getRoleNameText() {
        String roleName = driver.findElement(By.xpath(UapiOR.Customer_CustomerRolesAndPermissions_Page_RoleName)).getText();
        return roleName;
    }
    //Method to verify Application discard the changes and redirect to Service Provider List Page
    public void verifyApplicationDiscardChangesInEditRolesAndPermissionScreen(String roleName) throws IOException {

        VerifyValue1(getText(UapiOR.Customer_CustomerRolesAndPermissions_Page_RoleName), roleName);

    }
    // Method to click on Cancel
    public void clickOnCancel(Log Log) {
        WebClick(UapiOR.Customer_CustomerRolesAndPermissions_Page_Cancel);
        Log.ReportEvent("PASS", "Click on 'Cancel' option in Edit Roles And Permission Screen is successful");
        this.takeScreenShot();
    }
    // Method to click on yes button in Cancel conformation popup
    public void clickOnYesInCancelConformationPopup() {
        WebClick(UapiOR.Customer_CustomerEditRolesAndPermissions_Page_YesButton);
    }
    // Method to click on Save
    public void clickOnSave(Log Log) throws InterruptedException {
        Thread.sleep(2000);
        WebClick(UapiOR.Customer_CustomerEditRolesAndPermissions_Page_Save);
        Log.ReportEvent("PASS", "Click on 'Save' option in Edit Roles And Permission Screen is successful");
        this.takeScreenShot();
    }
    // Method to verify Error Message in Edit Role Screen for Role Name text field
    public void verifyRoleNameErrorMessage(Log Log) throws Exception {
        verifyElementIsPresent(UapiOR.Customer_CustomerEditRolesAndPermissions_Page_InvalidRoleNameErrorMessage);
        Log.ReportEvent("PASS", "Verify error message in Edit Roles And Permission Screen is successful");
        this.takeScreenShot();

    }
}
