package com.azmqalabs.uapitestautomation.apppages.collectionofpages;

import com.aventstack.extentreports.ExtentTest;
import com.azmqalabs.uapitestautomation.apppages.allapplicationpages.*;
import com.azmqalabs.uapitestautomation.common.DBConnect;
import com.azmqalabs.uapitestautomation.common.uielement.fieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Pages {

    private WebDriver driver;
    private ExtentTest test;
    public AdminLoginPage adminLoginPage;
    public PackageManagementPage packageManagementPage;
    public AddPackagePage addPackagePage;
    public EditPackagePage editPackagePage;
    public CreateAccountManagementPage createAccountManagementPage;
    public UserManagementPage userManagementPage;
    public CreateUserPage createUserPage;
    public EditUserPage editUserPage;
    public ReportsPage reportsPage;
    public AccountManagementPage accountManagementPage;
    public EditAccountManagementPage editAccountManagementPage;
    public InvoiceManagementPage invoiceManagementPage;
    public ServiceManagementProvidersListPage serviceManagementProvidersListPage;
    public EditServiceManagementProviderListPage editServiceProviderListPage;
    public CustomerProfilePage customerProfilePage;
    public ServiceManagementHeadsListPage serviceManagementHeadsListPage;
    public EditServiceManagementHeadsListPage editServiceManagementHeadsListPage;
    public ServiceManagementServicesListPage serviceManagementServicesListPage;
    public CustomerLoginPage customerLoginPage;
    public ReportsConsumptionDetailsPage reportsConsumptionDetailsPage;
    public CustomerAddPackagePage customerAddPackagePage;
    public CustomerEditRolesAndPermissionsPage customerEditRolesAndPermissionsPage;
    public CustomerPackageManagementPage customerPackageManagementPage;
    public CustomerRolesAndPermissionsPage customerRolesAndPermissionsPage;
    public CustomerServicesPage customerServicesPage;
    public CustomerUserManagementPage customerUserManagementPage;
    public CustomerMyInvoicesPage customerMyInvoicesPage;
    public CustomerEditUserPage customerEditUserPage;

    public DBConnect DBConnect;
    public InvokeApplicationPage InvokeApplicationPage;

    public Pages(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(new fieldDecorator(driver, test), this);
        DBConnect = new DBConnect(driver, test);
        InvokeApplicationPage = new InvokeApplicationPage(driver, test);
        adminLoginPage = new AdminLoginPage(driver, test);
        packageManagementPage = new PackageManagementPage(driver, test);
        addPackagePage = new AddPackagePage(driver, test);
        editPackagePage = new EditPackagePage(driver, test);
        createAccountManagementPage = new CreateAccountManagementPage(driver, test);
        reportsPage = new ReportsPage(driver, test);
        userManagementPage = new UserManagementPage(driver, test);
        editUserPage = new EditUserPage(driver, test);
        createUserPage = new CreateUserPage(driver, test);
        customerLoginPage = new CustomerLoginPage(driver, test);
        reportsConsumptionDetailsPage=new ReportsConsumptionDetailsPage(driver,test);
        accountManagementPage = new AccountManagementPage(driver, test);
        editAccountManagementPage = new EditAccountManagementPage(driver, test);
        invoiceManagementPage = new InvoiceManagementPage(driver, test);
        serviceManagementProvidersListPage = new ServiceManagementProvidersListPage(driver, test);
        editServiceProviderListPage = new EditServiceManagementProviderListPage(driver, test);
        serviceManagementServicesListPage = new ServiceManagementServicesListPage(driver, test);
        customerProfilePage = new CustomerProfilePage(driver, test);
        customerAddPackagePage = new CustomerAddPackagePage(driver, test);
        customerEditRolesAndPermissionsPage = new CustomerEditRolesAndPermissionsPage(driver, test);
        customerPackageManagementPage = new CustomerPackageManagementPage(driver, test);
        customerRolesAndPermissionsPage = new CustomerRolesAndPermissionsPage(driver, test);
        customerServicesPage = new CustomerServicesPage(driver, test);
        customerUserManagementPage = new CustomerUserManagementPage(driver, test);
        customerMyInvoicesPage = new CustomerMyInvoicesPage(driver, test);
        customerEditUserPage = new CustomerEditUserPage(driver, test);

    }
}
