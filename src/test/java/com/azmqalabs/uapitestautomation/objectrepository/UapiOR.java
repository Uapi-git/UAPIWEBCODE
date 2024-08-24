package com.azmqalabs.uapitestautomation.objectrepository;

public class UapiOR {

    //Admin Login Page
    public final static String Admin_LoginPage_UAPILogo = "//img[@loading='lazy' and @src='/_next/static/media/Uapi_logo_big.10f540e2.svg']";
    public final static String Admin_LoginPage_Username = "//input[@id='email']";
    public final static String Admin_LoginPage_Password = "//input[@id='password']";
    public final static String Admin_LoginPage_LogIn = "//button[@id='signin']";

    //Admin Logout Page
    public final static String Admin_HomePage_Profile = "//img[@loading='lazy']/parent::div//h2/following-sibling::div/div";
    public final static String Admin_SignOut = "//h5[contains(@class,'MuiTypography-root') and text()='Signout']";


    //Admin Package Management
    public final static String Admin_PackageManagementButton = "//div[@id='Packages Management']";
    public final static String Admin_PackageManagement_AnnualSubscriptionButton = "//div[@id='Annual Subscription Tiers']";
    public final static String Admin_PackageManagement_AnnualSubscriptionORServicesBundlesPage = "//button[text()='Add Package']/preceding-sibling::div//p/following-sibling::p";

    public final static String Admin_PackageManagement_GoToNextPage = "//button[@title='Go to next page']";
    public final static String Admin_PackageManagement_GoToPreviousPage = "//button[@title='Go to previous page']";
    public final static String Admin_PackageManagement_Pages = "//*[local-name()='svg' and @data-testid='ArrowDropDownIcon']/parent::div/following-sibling::p";
    public final static String Admin_PackageManagement_GridTable = "//div[@role='grid']";
    public final static String Admin_PackageManagement_PageNo = "//div[@role='grid']/following-sibling::div//p";
    public final static String Admin_PackageManagement_TableRowsPerPage = "//div[@aria-haspopup='listbox']";
    public final static String Admin_PackageManagement_FirstRecordActionBtn = "(//*[local-name()='svg' and @data-testid='MoreHorizIcon'])[1]";
    public final static String Admin_PackageManagement_ActionListViewOption = "//h5[text()='View']/ancestor::div[@role='button']";
    public final static String Admin_PackageManagement_ActionListEditOption = "//h5[text()='Edit']/ancestor::div[@role='button']";
    public final static String Admin_PackageManagement_ActionListDeleteOption = "//h5[text()='Delete']/ancestor::div[@role='button']";
    public final static String Admin_PackageManagement_DeleteConfirmationPopUp = "//div[@aria-labelledby='customized-dialog-title']";
    public final static String Admin_PackageManagement_DeleteConfirmationYesButton = "//button[@type='button' and text()='Yes']";
    public final static String Admin_PackageManagement_PackageDeleteMsg = "//div[@role='alert']";
    public final static String Admin_PackageManagement_ServicesBundlesButton = "//div[@id='Services Bundles']";
    public final static String Admin_PackageManagement_ServicesBundlesPage = "//button/preceding-sibling::div//p/following-sibling::p";

    //Add Package Page
    public final static String Admin_AddPackage_Page = "//div/child::p[text()='Add Package']";
    public final static String Admin_PackageManagement_PackageCodeTextField = "//input[@id='packageCode']";
    public final static String Admin_PackageManagement_PackageNameTextField = "//input[@id='name']";
    public final static String Admin_PackageManagement_PackageArabicNameTextField = "//input[@id='arabicName']";
    public final static String Admin_PackageManagement_PricePerPeriodTextField = "//input[@id='pricePerPeriod']";
    public final static String Admin_PackageManagement_PackagePeriodDropdown = "//div[@id='packagePeriod']";
    public final static String Admin_PackageManagement_TransactionLimit = "//input[@id='transactionLimit']";
    public final static String Admin_PackageManagement_StatusDropdown = "//div[@id='active']";
    public final static String Admin_PackageManagement_StatusDropdownInactiveOption = "//li[@data-value='inactive']";
    public final static String Admin_PackageManagement_StatusDropdownActiveOption = "//li[@data-value='active']";
    public final static String Admin_PackageManagement_AddOrEditFormCancelButton = "//button[text()='Cancel']";
    public final static String Admin_PackageManagement_AddOrEditFormSaveButton = "//button[text()='Save']";
    public final static String Admin_PackageManagement_ActivationDateCalender = "//input[@id='activationDate']";
    public final static String Admin_PackageManagement_AddPackageButton = "//button[@type='button' and text()='Add Package']";
    public final static String Admin_PackageManagement_GridPackageNames = "//div[@role='gridcell'  and @data-field='name']";
    public final static String Admin_EditPackage_Page = "//div/child::p[text()='Edit Package']";
    public final static String Admin_EditPackagePage_PackageName_Error = "//h5[@id='nameerror']";
    public final static String Admin_PackagePage_PricePerPeriod_Error = "//h5[@id='pricePerPerioderror']";
    public final static String Admin_PackagePage_PackagePeriod_Error = "//h5[@id='packagePerioderror']";
    public final static String Admin_Transaction_Limit_Error = "//h5[@id='transactionLimiterror']";
    public final static String Admin_EditPackagePage_ArabicPackageName_Error = "//h5[@id='arabicNameerror']";




    //Reports
    public final static String Admin_ReportsMenu = "//div[@id='Reports']";
    public final static String Admin_Reports_ConsumptionDetailsMenu = "//div[@id='Consumption Details']";
    public final static String Admin_Reports_ConsumptionDetailsPage = "//h2/ancestor::div/preceding-sibling::div//p";
    public final static String Admin_GoToNextPage = "//button[@title='Go to next page']";
    public final static String Admin_GoToPreviousPage = "//button[@title='Go to previous page']";
    public final static String Admin_Reports_AccountNameSortButton = "//div[@data-field='accountName']//button[@title='Sort']";
    public final static String Admin_Reports_GridTable = "//div[@role='grid']";
    public final static String Admin_Reports_TableRowsPerPage = "//div[@aria-haspopup='listbox']";
    public final static String Admin_Reports_GoToNextPage = "//button[@title='Go to next page']";
    public final static String Admin_Reports_GoToPreviousPage = "//button[@title='Go to previous page']";
    public final static String Admin_Reports_ClientSubscriptionTableRowsPerPage = "//p[text()='Rows per page:']/following::div[@aria-haspopup='listbox']";
    public final static String Admin_Reports_ClientSubscription_PackageDetailDetails = "//h1/parent::div/following::h1";
    public final static String Admin_Reports_ClientSubscription_PackageDetailDetailsCloseBtn = "//button[@aria-label='close']";
    public final static String Admin_Reports_ClientSubscription_PackageDetailDetailsBackBtn = "//h1/parent::div/following::button";
    public final static String Admin_Reports_FirstRecordActionBtn = "(//*[local-name()='svg' and @data-testid='MoreHorizIcon'])[1]";
    public final static String Admin_Reports_ActionListViewOption = "//h5[text()='View']/ancestor::div[@role='button']";
    public final static String Admin_ReportsConsumptionDetails_ViewExportPDFButton = "//button[text()='Export PDF']";
    public final static String Admin_ReportsConsumptionDetails_ViewExportExcelButton = "//button[text()='Export Excel']";
    public final static String Admin_ReportsConsumptionDetails_ViewPage = "//*[@data-testid='KeyboardArrowRightIcon']/parent::div/following-sibling::p";
    public final static String Admin_ReportsConsumptionDetailsViewPage_AccountCodeField = "//input[@id='Account Code']";
    public final static String Admin_ReportsConsumptionDetailsViewPage_AccountNameField = "//input[@id='Account Name']";
    public final static String Admin_ReportsConsumptionDetailsViewPage_ActivePackageNameField = "//input[@id='Active Package Name']";
    public final static String Admin_ReportsConsumptionDetailsViewPage_PackageRemainingField = "//input[@id='Package Remaining']";
    public final static String Admin_ReportsConsumptionDetailsViewPage_DueMonthField = "//input[@id='Due Month']";
    public final static String Admin_ReportsConsumptionDetailsViewPage_GridColumnNames = "//div[@role='columnheader']";

    public final static String Admin_ReportsConsumptionDetails_SearchByMonthCalender = "//input[@id='month']/parent::div//button";
    public final static String Admin_ReportsConsumptionDetails_SearchByYearCalender = "//input[@id='year']/parent::div//button";
    public final static String Admin_ReportsConsumptionDetails_SearchByYearCalenderClearBtn = "//button[text()='Clear']";
    public final static String Admin_ReportsConsumptionDetails_GridRecordsDueMonths = "//div[@data-field='month']/h2";
    public final static String Admin_ReportsConsumptionDetails_GridRecordNoRowsMessage = "//div[contains(text(),'No row')]";
    public final static String Admin_Reports_ClientSubscriptionMenu = "//div[@id='Client Subscriptions']";
    public final static String Admin_Reports_ConsumptionDetailsGoToNextPage = "//button[@aria-label='Go to next page']";
    public final static String Admin_Reports_ConsumptionDetailsGoToPreviousPage = "//button[@aria-label='Go to previous page']";
    public final static String Admin_Reports_ClientSubscriptionsPage_ClientNameSearchField = "//input[@id='search' and @placeholder='Search Client Name']";
    public final static String Admin_Reports_ClientSubscriptionsPage_PackageNameSearchField = "//input[@id='search' and @placeholder='Search Package Name']";
    public final static String Admin_Reports_ClientSubscriptionsPage_ClientNameSearchBtn = "//input[@id='search' and @placeholder='Search Client Name']/preceding::button";
    public final static String Admin_Reports_ClientSubscriptionsPage_PackageNameSearchBtn = "//input[@id='search' and @placeholder='Search Package Name']/preceding-sibling::div//button";
    public final static String Admin_Reports_ClientSubscriptionsPage_ClientNameClearBtn = "//input[@id='search' and @placeholder='Search Package Name']/preceding::button//*[@data-testid='CloseIcon']";
    public final static String Admin_Reports_ClientSubscriptionsPage_SelectPackageStatusBtn = "//div[@aria-haspopup='listbox']/span";
    public final static String Admin_Pages_Header = "//h2/ancestor::div/preceding-sibling::div//p";



    //User Management
    public final static String Admin_UserManagementMenu = "//div[@id='User Management']";
    public final static String Admin_UserManagementPage = "//h2/ancestor::div/preceding-sibling::div//p";
    public final static String Admin_UserManagementPage_SearchField = "//input[@id='search']";
    public final static String Admin_UserManagementPage_SearchBtn = "//*[local-name()='svg' and @data-testid='SearchIcon']";
    public final static String Admin_UserManagementPage_SearchField_ClearButton = "//*[local-name()='svg' and @data-testid='CloseIcon']";
    public final static String Admin_UserManagementPage_NoRowGrid = "//div[contains(@class,'MuiDataGrid-overlayWrapper')]/div/div";
    public final static String Admin_UserManagement_GridDataTable = "//div[@role='grid']";
    public final static String Admin_UserManagement_FirstRecordActionBtn = "(//*[local-name()='svg' and @data-testid='MoreHorizIcon'])[1]";
    public final static String Admin_UserManagement_ActionListEditOption = "//h5[text()='Edit']/ancestor::div[@role='button']";
    public final static String Admin_UserManagement_TableRowsPerPage = "//div[@aria-haspopup='listbox']";
    public final static String Admin_UserManagement_CreateUserBtn = "//button[@id='Create User']";

    public final static String Admin_UserManagement_OperatorDropdown = "//label[text()='Operator']//parent::div//*[local-name()='svg' and @data-testid='ArrowDropDownIcon']";

    public final static String Admin_ActionListDeleteOption = "//h5[text()='Delete']/ancestor::div[@role='button']";
    public final static String Admin_DeleteConfirmationYesButton = "//button[@type='button' and text()='Yes']";
    public final static String Admin_ErrorMsg = "//div[@role='alert']";
    public final static String Admin_UserManagementPage_FirstRecordFirstName = "//div[@data-rowindex='0']/div[@data-field='firstName']";
    public final static String Admin_UserManagementPage_FirstRecordLastName = "//div[@data-rowindex='0']/div[@data-field='lastName']";
    public final static String Admin_UserManagementPage_FirstRecordCompany = "//div[@data-rowindex='0']/div[@data-field='company']";
    public final static String Admin_UserManagementPage_FirstRecordEmail = "//div[@data-rowindex='0']/div[@data-field='email']";
    public final static String Admin_UserManagementPage_FirstRecordMobileNo = "//div[@data-rowindex='0']/div[@data-field='contactNo']";


    //Edit user page
    public final static String Admin_EditUser_Page = "//div/child::p[text()='Edit User']";
    public final static String Admin_AddOrEditUserPage_UserName = "//input[@id='username']";
    public final static String Admin_AddOrEditUserPage_Email = "//input[@id='email']";
    public final static String Admin_AddOrEditUserPage_FirstNameTextField = "//input[@id='firstName']";
    public final static String Admin_AddOrEditUserPage_LastNameTextField = "//input[@id='lastName']";
    public final static String Admin_AddOrEditUserPage_NationalIdTextField = "//input[@id='nationalId']";
    public final static String Admin_AddOrEditUserPage_MobileNoTextField = "//input[@id='contactNo']";
    public final static String Admin_AddOrEditUserPage_SaveButton = "//button[@id='saveUser']";
    public final static String Admin_AddOrEditUserPage_firstName_Error = "//h5[@id='firstNameerror']";
    public final static String Admin_AddOrEditUserPage_lastName_Error = "//h5[@id='lastNameerror']";
    public final static String Admin_AddOrEditUserPage_nationalId_Error = "//h5[@id='nationalIderror']";
    public final static String Admin_AddOrEditUserPage_mobileNo_Error = "//h5[@id='contactNoerror']";
    public final static String Admin_AddOrEditUserPage_UserName_Error = "//h5[@id='usernameerror']";
    public final static String Admin_AddOrEditUserPage_Email_Error = "//h5[@id='emailerror']";
    public final static String Admin_AddOrEditUserPage_Company_Error = "//h5[@id='companyIderror']";
    public final static String Admin_AddOrEditUserPage_UserType_Error = "//h5[@id='userTypeerror']";


    //Create user page
    public final static String Admin_CreateUser_Page = "//div/child::p[text()='Create User']";
    public final static String Admin_CreateUserPage_UserTypeDropdown = "//div[@id='userType']";
    public final static String Admin_AddOrEditUserPage_CompanyTextField = "//input[@id='companyId']";


    //Customer Login Page
    public final static String Customer_LoginPage_UAPILogo = "//img[@loading='lazy' and @src='/_next/static/media/Uapi_logo.401faa74.svg']";
    public final static String Customer_LoginPage_Username = "//input[@type='text']";
    public final static String Customer_LoginPage_Password = "//input[@type='password']";
    public final static String Customer_LoginPage_LogIn = "//button[@id='signin']";
    public final static String Customer_Profile_DownArrowIcon = "//*[@data-testid='KeyboardArrowDownOutlinedIcon']";
    public final static String Customer_SignOut = "//*[@data-testid='LogoutOutlinedIcon']";


    //Admin Account Management Page
    public final static String Admin_AccountManagement_Page = "//button[@id='Create Account']/preceding-sibling::div//p";
    public final static String Admin_AccountManagement_Page_CreateAccountButton = "//button[@id='Create Account']";
    public final static String Admin_CreateAccountManagement_Page_CreateAccountText = "//div/p/following-sibling::p";
    public final static String Admin_ArticlesOfAssociation = "//button[@id='VAT Registration Certificate *']/preceding::input[@id='fileInput']";
    public final static String Admin_VatRegistrationCertificate = "(//button[@id='VAT Registration Certificate *']/following::input[@id='fileInput'])[1]";
    public final static String Admin_ZakatCertificate = "//button[@id='Zakat Certificate *']/following::input[@id='fileInput']";
    public final static String Admin_AccountManagementPage_SettingsAnnualSubscriptionDropdown = "//h2[text()='Annual Subscription Tier(s) *']/parent::div//button";
    public final static String Admin_AccountManagementPage_SettingsServicesBundleDropdown = "//h2[text()='Services Bundle(s) *']/parent::div//button";
    public final static String Admin_AccountManagementPage_SettingsDropdownCloseBtn = "//button[@title='Close']";
    public final static String Admin_AccountManagementPage_CreateAccountButton = "//button[@id='submitCompany']";
    public final static String Admin_AccountManagement_Page_SearchTextbox = "//input[@id='search']";
    public final static String Admin_AccountManagement_Page_SearchBtn = "//div[contains(@class,'MuiInputAdornment-root MuiInputAdornment-positionStart MuiInputAdornment-outlined MuiInputAdornment-sizeSmall')]//button";
    public final static String Admin_AccountManagement_Page_Search_TestField_ClearButton = "//input[@id='search']/parent::div//following-sibling::div//button";
    public final static String Admin_AccountManagement_Page_ActionIcon = "//div[@data-field='actions' and contains(@class,'textLeft')]";
    public final static String Admin_AccountManagement_Page_EditButton = "//h5[text()='Edit']";
    public final static String Admin_AccountManagement_Page_NextPage_Disabled = "//button[@title='Go to next page' and @disabled]";
    public final static String Admin_AccountManagement_Page_NextPage = "//button[@title='Go to next page']";
    public final static String Admin_AccountManagement_Page_GridData = "//div[@role='grid']";
    public final static String Admin_AccountManagement_Page_RowPerPage = "//div[text()='10']";
    public final static String Admin_AccountManagement_Page_FiveRowPerPage = "//li[@data-value='5']";
    public final static String Admin_AccountManagement_Page_GoToPreviousPage = "//button[@title='Go to previous page']";
    public final static String Admin_AccountManagement_Page_DeleteButton = "//h5[text()='Delete']";
    public final static String Admin_AccountManagement_Page_DeleteYes = "//button[text()='Yes']";
    public final static String Admin_AccountManagement_Page_SuccessfulToastMessage = "//div[contains(@class,'MuiAlert-message')]";


    // Create Account Management text
    public final static String Admin_CreateAccountManagement_Page_GeneralInfoSelectorDropdown = "//div[@id='sectorId']";
    public final static String Admin_CreateAccountManagement_Page_IssueDate = "(//button[contains(@aria-label,'Choose date')])[1]";
    public final static String Admin_CreateAccountManagement_Page_ExpireDate = "(//button[contains(@aria-label,'Choose date')])[2]";
    public final static String Admin_CreateAccountManagement_Page_Year = "//button[@aria-label='calendar view is open, switch to year view']";
    public final static String Admin_CreateAccountManagement_Page_GeneralInfoCompanyName = "//input[@id='companyName']";
    public final static String Admin_CreateAccountManagement_Page_GeneralInfoCommercialRegistry = "//input[@id='commercialRegistry']";
    public final static String Admin_CreateAccountManagement_Page_GeneralInfoNationalNumber = "//input[@id='unifiedNationalNumber']";
    public final static String Admin_CreateAccountManagement_Page_GeneralInfoCompanyEmail = "//input[@id='companyEmail']";
    public final static String Admin_CreateAccountManagement_Page_GeneralInfoTaxNumber = "//input[@id='taxNumber']";
    public final static String Admin_CreateAccountManagement_Page_GeneralInfoWebSiteUrl = "//input[@id='companyWebsite']";
    public final static String Admin_CreateAccountManagement_Page_NextButton = "//button[@id='submitCompany']";
    public final static String Admin_CreateAccountManagement_Page_AuthorizedPersonInfoCityDropdown = "//input[@id='companyRep.cityId']";
    public final static String Admin_CreateAccountManagement_Page_SettingsAllowPostPayAccessChecked = "//span[contains(@class,'Mui-checked')]";
    public final static String Admin_CreateAccountManagement_Page_SettingsAllowPostPayAccessUnChecked = "//span[text()='Allow Postpaid Packages']/parent::label/child::span[(contains(@class,'MuiCheckbox-root')) and not(contains(@class,'Mui-checked'))]";
    public final static String Admin_CreateAccountManagement_Page_SettingsAllServices = "//span[text()='All Services']";
    public final static String Admin_CreateAccountManagement_Page_SettingsAllServicesOptions = "//button[contains(@class,'MuiIconButton-sizeMedium')]//following-sibling::div//following-sibling::div//span";
    public final static String Admin_CreateAccountManagement_Page_SettingsAllServicesToSelect = "//button[@aria-label='move selected right' and not(contains(@id,'serviceLoggingRight'))]";
    public final static String Admin_CreateAccountManagement_Page_SettingsAllServicesLogsToSelect = "//button[@aria-label='move selected right']/following::button[@aria-label='move selected right']";
    public final static String Admin_CreateAccountManagement_Page_SettingsAllServicesToDeSelect = "//button[@aria-label='move selected left' and not(contains(@id,'serviceLoggingLeft'))]";
    public final static String Admin_CreateAccountManagement_Page_WebSiteUrlErrorMessage = "//h5[@id='companyWebsiteerror']";
    public final static String Admin_CreateAccountManagement_Page_EmailErrorMessage = "//h5[@id='companyEmailerror']";
    public final static String Admin_CreateAccountManagement_Page_AuthorizedPersonInformation = "//span[text()='Authorized Person Information']";
    public final static String Admin_CreateAccountManagement_Page_AuthorizedPersonInfoFirstName = "//input[@id='companyRep.firstName']";
    public final static String Admin_CreateAccountManagement_Page_AuthorizedPersonInfoLastName = "//input[@id='companyRep.lastName']";
    public final static String Admin_CreateAccountManagement_Page_AuthorizedPersonInfoNationalId = "//input[@id='companyRep.nationalId']";
    public final static String Admin_CreateAccountManagement_Page_AuthorizedPersonInfoEmail = "//input[@id='companyRep.email']";
    public final static String Admin_CreateAccountManagement_Page_AuthorizedPersonInfoMobileNumber = "//input[@id='companyRep.mobile']";
    public final static String Admin_CreateAccountManagement_Page_AuthorizedPersonInfoLetterStampedField = "//input[@id='fileInput']";
    public final static String Admin_CreateAccountManagement_Page_AuthorizedPersonInfoMobileNumberErrorMessage = "//h5[@id='companyRep.mobileerror']";

    public final static String Admin_CreateAccountManagement_Page_AuthorizedPersonInfoEmailErrorMessage = "//h5[@id='companyRep.emailerror']";
    public final static String Admin_CreateAccountManagement_Page_AdminInfoFirstName = "//input[@id='user.firstName']";
    public final static String Admin_CreateAccountManagement_Page_AdminInfoLastName = "//input[@id='user.lastName']";
    public final static String Admin_CreateAccountManagement_Page_AdminInfoNationalID = "//input[@id='user.nationalId']";
    public final static String Admin_CreateAccountManagement_Page_AdminInfoUserName = "//input[@id='user.username']";

    public final static String Admin_CreateAccountManagement_Page_AdminInfo = "//span[text()='Admin Information']";

    public final static String Admin_CreateAccountManagement_Page_AdminInfoUserEmail = "//input[@id='user.email']";

    public final static String Admin_CreateAccountManagement_Page_AdminInfoMobileNumber = "//input[@id='user.contactNo']";

    public final static String Admin_CreateAccountManagement_Page_AdminInfoEmailErrorMessage = "//h5[@id='user.emailerror']";
    public final static String Admin_CreateAccountManagement_Page_AdminInfoNationalIDMessage = "//h5[@id='user.nationalIderror']";
    public final static String Admin_CreateAccountManagement_Page_NationalAddress = "//span[text()='National Address']";
    public final static String Admin_CreateAccountManagement_Page_NationalAddressBuildingNo = "//input[@id='address.buildingNumber']";
    public final static String Admin_CreateAccountManagement_Page_NationalAddressSecondaryNo = "//input[@id='address.secondaryNumber']";
    public final static String Admin_CreateAccountManagement_Page_NationalAddressDistrictNo = "//input[@id='address.district']";
    public final static String Admin_CreateAccountManagement_Page_NationalAddressPostalCode = "//input[@id='address.postalCode']";
    public final static String Admin_CreateAccountManagement_Page_NationalAddressCityDropdown = "//input[@id='address.cityId']";

    public final static String Admin_CreateAccountManagement_Page_NationalAddressDistrictNameErrorMsg = "//h5[@id='address.districterror']";
    public final static String Admin_CreateAccountManagement_Page_NationalAddressPostalCodeErrorMsg = "//h5[@id='address.postalCodeerror']";
    public final static String Admin_CreateAccountManagement_Page_Settings = "//span[text()='Settings']";
    public final static String Admin_CreateAccountManagement_Page_SettingsAllowPostPayAccess = "//span[text()='Allow Postpaid Packages']";
    public final static String Admin_CreateAccountManagement_Page_Attachments = "//span[text()='Attachments']";
    public final static String Admin_CreateAccountManagement_Page_Attachments_ArticlesOfAssociation = "//h2[text()='Articles of Association *']/parent::div/following-sibling::div//input";

    public final static String Admin_CreateAccountManagement_Page_Attachments_VatRegistrationCertificate = "//h2[text()='VAT Registration Certificate *']/parent::div/following-sibling::div//input";
    public final static String Admin_CreateAccountManagement_Page_Attachments_ZakatCertificate = "//h2[text()='Zakat Certificate *']/parent::div/following-sibling::div//input";
    public final static String Admin_CreateAccountManagement_Page_AttachmentsArticlesOfAssociationErrorMessage = "//div[text()='The selected file must be a PDF with max size 1 MB']";
    public final static String Admin_CreateAccountManagement_Page_AttachmentsZakatErrorMessage = "//div[text()='Please upload atleast one Zakat CertificateFile file!']";

    public final static String Admin_CreateAccountManagement_Page_SettingsAnnualSubscriptionTiers = "//h2[text()='Annual Subscription Tier(s) *']/parent::div//button";
    public final static String Admin_CreateAccountManagement_Page_SettingsServicesBundles = "//h2[text()='Services Bundle(s) *']/parent::div//button";
    public final static String Admin_CreateAccountManagement_Page_SettingsStatus = "//h2[text()='Status *']/parent::div//following-sibling::div";
    public final static String Admin_CreateAccountManagement_Page_SettingsAllServiceProvidersToSelect = "//button[@aria-label='move selected right' and contains(@id,'serviceLoggingRight')]";

    public final static String Admin_CreateAccountManagement_Page_SettingsAllServiceProvidersToDeSelect = "//button[@aria-label='move selected left' and contains(@id,'serviceLoggingLeft')]";
    public final static String Admin_CreateAccountManagement_Page_SettingsSave = "//button[@id='submitCompany']";
    public final static String Admin_CreateAccountManagement_Page_SettingsAnnualSubscriptionErrorMsg = "//h5[@id='allowedAnnualPackageserror']";
    public final static String Admin_CreateAccountManagement_Page_SettingsServicesBundlesErrorMsg = "//h5[@id='allowedServicesPackageserror']";
    public final static String Admin_CreateAccountManagement_Page_SettingsServicesErrorMsg = "//h5[text()='Please select atleast one service']";
    public final static String Admin_CreateAccountManagement_Page_SettingsAllServiceProviders = "//span[text()='All Service Providers']";
    public final static String Admin_CreateAccountManagement_Page_SettingsAllServiceProvidersOptions = "//span[text()='All Service Providers']/ancestor::div[contains(@class,'MuiCardHeader-root')]//following-sibling::div//span[contains(@class,'MuiTypography-body')]";
    public final static String Admin_CreateAccountManagement_Page_FillAllDetailsErrorMsg = "//div[text()='Please complete all onboarding steps in order to save the account']";

    // Admin Edit Account Management Page

    public final static String Admin_Edit_AccountManagement_Page = "//p[text()='Edit Account']/parent::div";
    public final static String Admin_Edit_AccountManagement_Page_UnifiedNationalNumber = "//input[@id='unifiedNationalNumber']";
    public final static String Admin_Edit_AccountManagement_Page_SaveButton = "//button[@id='submitCompany']";
    public final static String Admin_Edit_AccountManagement_Page_UpdateSuccessfulToast = "//div[contains(@class,'MuiAlert-message')]";
    public final static String Admin_Edit_AccountManagement_Page_RightArrowIcon = "//*[@data-testid='KeyboardArrowRightIcon' and contains(@class,'MuiSvgIcon-fontSizeSmall')]/parent::div";
    public final static String Admin_Edit_AccountManagement_Page_AuthorizedPersonInformation = "//button[text()='Authorized Person Information']";
    public final static String Admin_Edit_AccountManagement_Page_NationalID = "//input[@id='companyRep.nationalId']";
    public final static String Admin_Edit_AccountManagement_Page_LastName = "//input[@id='user.lastName']";
    public final static String Admin_Edit_AccountManagement_Page_NationalAddress = "//button[text()='National Address']";
    public final static String Admin_Edit_AccountManagement_Page_UnifiedNationalNumberErrorMessage = "//h5[@id='unifiedNationalNumbererror']";
    public final static String Admin_Edit_AccountManagement_Page_LastNameBlankErrorMessage = "//h5[@id='user.lastNameerror']";
    public final static String Admin_Edit_AccountManagement_Page_NationalIdBlankErrorMessage = "//h5[@id='companyRep.nationalIderror']";

    public final static String Admin_Edit_AccountManagement_Page_AdminInformation = "//button[text()='Admin Information']";
    public final static String Admin_Edit_AccountManagement_Page_PostalCode = "//input[@id='address.postalCode']";
    public final static String Admin_Edit_AccountManagement_Page_PostalCodeErrorMessage = "//h5[@id='address.postalCodeerror']";
    public final static String Admin_Edit_AccountManagement_Page_Attachments = "//button[text()='Attachments']";
    public final static String Admin_Edit_AccountManagement_Page_ArticlesOfAssociationAttachments = "//input[@id='fileInput']";
    public final static String Admin_Edit_AccountManagement_Page_ArticlesOfAssociationAttachmentsClear = "//button[@id='Articles of Association *']/parent::div/following-sibling::div//button";
    public final static String Admin_Edit_AccountManagement_Page_ArticlesOfAssociationAttachmentsErrorMessage = "//div[text()='The selected file must be a PDF with max size 1 MB']";
    public final static String Admin_Edit_AccountManagement_Page_Cancel = "//button[text()='cancel']";


    //Invoice Management
    public final static String Admin_InvoiceManagement_Page = "//p[text()='My Invoices']";
    public final static String Admin_InvoiceManagement_Button = "//h2[text()='Invoice Management']";
    public final static String Admin_InvoiceManagement_Page_SearchTextField = "//input[@id='search']";
    public final static String Admin_InvoiceManagement_Page_GridData = "//div[@role='grid']";
    public final static String Admin_InvoiceManagement_GoToNextPage = "//button[@title='Go to next page']";
    public final static String Admin_InvoiceManagement_GoToPreviousPage = "//button[@title='Go to previous page']";
    public final static String Admin_InvoiceManagement_Page_RowPerPage = "//div[text()='10']";
    public final static String Admin_InvoiceManagement_Page_FiveRowPerPage = "//li[@data-value='5']";
    public final static String Admin_InvoiceManagement_Page_NextPage_Disabled = "//button[@title='Go to next page' and @disabled]";
    public final static String Admin_InvoiceManagement_Page_ExportPdf = "//button[@id='exportPDF']";
    public final static String Admin_InvoiceManagement_Page_ExportExcel = "//button[@id='exportExcel']";
    public final static String Admin_InvoiceManagement_Page_Search_TestField_ClearButton = "//input[@id='search']/parent::div//following-sibling::div//button";
    public final static String Admin_InvoiceManagement_Page_InvoiceStatus = "//div[@id='invoiceStatus']";
    public final static String Admin_InvoiceManagement_Page_InvoiceType = "//div[@id='invoiceType']";
    public final static String Admin_InvoiceManagement_Page_SearchBtn = "//div[contains(@class,'MuiInputAdornment-root MuiInputAdornment-positionStart')]//button";
    public final static String Admin_InvoiceManagement_Page_NoRows = "//div[text()='No rows']";

    //Service Management Providers List Page

    public final static String Admin_ServiceManagementProviderList_Page = "//p[text()='Service Provider List']";
    public final static String Admin_ServiceManagement_Button = "//div[@id='Service Management']";
    public final static String Admin_ServiceManagement_ProviderListButton = "//div[@id='Service Providers List']";
    public final static String Admin_ServiceManagementProviderList_GoToNextPage = "//button[@title='Go to next page']";
    public final static String Admin_ServiceManagementProviderList_Pages = "//*[local-name()='svg' and @data-testid='ArrowDropDownIcon']/parent::div/following-sibling::p";
    public final static String Admin_ServiceManagementProviderList_GoToPreviousPage = "//button[@title='Go to previous page']";
    public final static String Admin_ServiceManagementProviderList_Page_NextPage_Disabled = "//button[@title='Go to next page' and @disabled]";
    public final static String Admin_ServiceManagementProviderList_Page_RowPerPage = "//div[text()='10']";
    public final static String Admin_ServiceManagementProviderList_Page_FiveRowPerPage = "//li[@data-value='5']";
    public final static String Admin_ServiceManagementProviderList_Page_View = "//h5[text()='View']";
    public final static String Admin_ServiceManagementProviderList_Page_ServiceProviderId = "//input[@id='serviceProviderCode']";
    public final static String Admin_ServiceManagementProviderList_Page_ServiceProviderName = "//input[@id='name']";
    public final static String Admin_ServiceManagementProviderList_Page_ServiceProviderArabicName = "//input[@id='arabicName']";
    public final static String Admin_ServiceManagementProviderList_Page_Description = "//textarea[@id='description']";
    public final static String Admin_ServiceManagementProviderList_Page_FirstRecordActionBtn = "(//*[local-name()='svg' and @data-testid='MoreHorizIcon'])[1]";
    public final static String Admin_EditServiceManagementProviderList_Page_Upload = "//button[text()='Upload']";
    public final static String Admin_ServiceManagementProviderList_Page_Edit = "//h5[text()='Edit']";
    public final static String Admin_ServiceManagementProviderList_Page_GridData = "//div[@role='grid']";

    //Edit Service Management Providers List Page
    public final static String Admin_EditServiceManagementProviderList_Page_UploadFileText = "//h2[text()='Agreement Attachment']/parent::div//p";
    public final static String Admin_EditServiceManagementProviderList_Page_UploadFileErrorMsg = "//div[text()='Error! Max File Size Should Be 1MB']";
    public final static String Admin_EditServiceManagementProviderList_Page_ConnectivityType = "//h2[text()='Connectivity Type']/parent::div//span[contains(@class,'MuiSwitch-switchBase')]";
    public final static String Admin_EditServiceManagementProviderList_Page_SaveAndViewCredentials = "//button[text()='Save and view credentials']";
    public final static String Admin_EditServiceManagementProviderList_Page_ConnectivityTypeToggle = "//h2[text()='Connectivity Type']/parent::div//input";
    public final static String Admin_EditServiceManagementProviderList_Page_SaveAndViewCredentialsCancel = "//h2[text()='Service provider connectivity credentials']//parent::div/following::form//button[@id='serviceProviderCancel']";
    public final static String Admin_EditServiceManagementProviderList_Page_SaveAndViewCredentialsSave = "//h2[text()='Service provider connectivity credentials']//parent::div/following::form//button[@id='serviceProviderSave']";
    public final static String Admin_EditServiceManagementProviderList_Page_SaveAndViewCredentialsPopup = "//h2[text()='Service provider connectivity credentials']";
    public final static String Admin_EditServiceManagementProviderList_Page_ClientCredentialsToggle = "//h2[text()='Client credentials']/parent::div//input";
    public final static String Admin_EditServiceManagementProviderList_Page_ClientCredentials = "//h2[text()='Client credentials']/parent::div//span[contains(@class,'MuiSwitch-switchBase')]";
    public final static String Admin_EditServiceManagementProviderList_Page_ServiceProviderArabicNameErrorMsg = "//h5[@id='arabicNameerror']";
    public final static String Admin_EditServiceManagementProviderList_Page_Save = "//div[contains(@class,'MuiStack-root')]//button[@id='serviceProviderSave']";
    public final static String Admin_EditServiceManagementProviderList_Page_Cancel = "//div[contains(@class,'MuiStack-root')]//button[text()='Cancel']";
    public final static String Admin_EditServiceManagementProviderList_Page = "//p[text()='Edit Service Provider']/parent::div";
    public final static String Admin_EditServiceManagementProviderList_Page_Description = "//textarea[@id='description']";
    public final static String Admin_EditServiceManagementProviderList_Page_ServiceProviderArabicName = "//input[@id='arabicName']";
    public final static String Admin_EditServiceManagementProviderList_SaveAndViewCredentialsApiKey = "//input[@id='apikey']";

    public final static String Admin_EditServiceManagementProviderList_ServiceProviderUpdatedSuccessfullyMsg = "//div[text()='Service credentials saved successfully!']";
    public final static String Admin_EditServiceManagementProviderList_SaveAndViewCredentialsApiId = "//input[@id='appId']";
    public final static String Admin_EditServiceManagementProviderList_SaveAndViewCredentialsUserName = "//input[@id='username']";

    public final static String Admin_EditServiceManagementProviderList_SaveAndViewCredentialsPasswordEyeIcon = "//button[contains(@class,'MuiIconButton-edgeEnd')]";
    public final static String Admin_EditServiceManagementProviderList_SaveAndViewCredentialsPassword = "//input[@id='password']";


    // Services List
    public final static String Admin_ServiceManagement_ServicesListButton = "//div[@id='Services List']";
    public final static String Admin_ServiceManagement_ServicesList_Page = "//p[text()='Services List']";
    public final static String Admin_ServiceManagement_ServicesList_Page_GridData = "//div[@role='grid']";
    public final static String Admin_ServiceManagement_ServicesList_Page_RowPerPage = "//div[text()='10']";
    public final static String Admin_ServiceManagement_ServicesList_Page_FiveRowPerPage = "//li[@data-value='5']";
    public final static String Admin_ServiceManagement_ServicesList_Page_NextPage_Disabled = "//button[@title='Go to next page' and @disabled]";
    public final static String Admin_ServiceManagement_ServiceList_GoToNextPage = "//button[@title='Go to next page']";
    public final static String Admin_ServiceManagement_ServicesList_GoToPreviousPage = "//button[@title='Go to previous page']";
    public final static String Admin_ServiceManagement_ServicesList_Page_FirstRecordActionBtn = "(//*[local-name()='svg' and @data-testid='MoreHorizIcon'])[1]";
    public final static String Admin_ServiceManagement_ServicesList_Page_View = "//h5[text()='View']";
    public final static String Admin_ServiceManagement_ServicesList_Page_Edit = "//h5[text()='Edit']";
    public final static String Admin_ServiceManagement_ServicesList_Page_ServiceId = "//input[@id='serviceCode']";
    public final static String Admin_ServiceManagement_ServicesList_Page_ServiceName = "//input[@id='name']";
    public final static String Admin_ServiceManagement_ServicesList_Page_ServiceNameInArabic = "//input[@id='arabicName']";
    public final static String Admin_ServiceManagement_ServicesList_Page_ServiceProviderName = "//input[@id='serviceProviderName']";
    public final static String Admin_ServiceManagement_ServicesList_Page_OriginalServiceProvider = "//input[@id='originalServiceProvider']";
    public final static String Admin_ServiceManagement_ServicesList_Page_OriginalServiceProviderSector = "//div[@id='originalServiceProviderSector']";
    public final static String Admin_ServiceManagement_ServicesList_Page_Status = "//div[@id='active']";
    public final static String Admin_ServiceManagement_ServicesList_Page_ServiceHeadName = "//div[@id='serviceHeadId']";

    // Edit Service Heads List Page

    public final static String Admin_EditServiceManagementHeadsList_Page = "//p[text()='Edit Service Head']/parent::div";
    public final static String Admin_EditServiceManagementHeadsList_Page_Upload = "//button[text()='Upload']";
    public final static String Admin_EditServiceManagementHeadsList_Page_UploadFileText = "//h2[text()='Original Service Head Logo']/parent::div//p";
    public final static String Admin_EditServiceManagementHeadsList_Page_ServiceHeadNameInArabic = "//input[@id='arabicName']";
    public final static String Admin_EditServiceManagementHeadsList_Page_ServiceHeadArabicNameErrorMsg = "//h5[@id='arabicNameerror']";
    public final static String Admin_EditServiceManagementHeadsList_Page_Save = "//div[contains(@class,'MuiStack-root')]//button[@id='serviceHeadSave']";
    public final static String Admin_EditServiceManagementHeadsList_Page_Cancel = "//div[contains(@class,'MuiStack-root')]//button[@id='serviceHeadCancel']";
    public final static String Admin_EditServiceManagementHeadsList_Page_Description = "//input[@id='description']";
    public final static String Admin_EditServiceManagementProviderList_ServiceHeadsUpdatedSuccessfullyMsg = "//div[text()='Service Head updated successfully!']";
    public final static String Admin_EditServiceManagementHeadsList_Page_OriginalServiceHeadName = "//div[@id='originalServiceHeadName']";
    public final static String Admin_EditServiceManagementHeadsList_Page_OriginalServiceHeadSector = "//div[@id='originalServiceHeadSector']";
    public final static String Admin_EditServiceManagementHeadsList_Page_ConnectivityType = "//button[@id='serviceProviderCancel']";
    public final static String Admin_EditServiceManagementHeadsList_Page_DescriptionErrorMsg = "//h5[@id='descriptionerror']";

    //Service Management Heads List Page

    public final static String Admin_ServiceManagementHeadsList_Page = "//p[text()='Service Heads List']";
    public final static String Admin_ServiceManagement_HeadsListButton = "//div[@id='Service Heads List']";
    public final static String Admin_ServiceManagementHeadsList_GoToNextPage = "//button[@title='Go to next page']";
    public final static String Admin_ServiceManagementHeadsList_Pages = "//*[local-name()='svg' and @data-testid='ArrowDropDownIcon']/parent::div/following-sibling::p";
    public final static String Admin_ServiceManagementHeadsList_GoToPreviousPage = "//button[@title='Go to previous page']";
    public final static String Admin_ServiceManagementHeadsList_Page_NextPage_Disabled = "//button[@title='Go to next page' and @disabled]";
    public final static String Admin_ServiceManagementHeadsList_Page_RowPerPage = "//div[text()='10']";
    public final static String Admin_ServiceManagementHeadsList_Page_FiveRowPerPage = "//li[@data-value='5']";
    public final static String Admin_ServiceManagementHeadsList_Page_FirstRecordActionBtn = "(//*[local-name()='svg' and @data-testid='MoreHorizIcon'])[1]";
    public final static String Admin_ServiceManagementHeadsList_Page_Edit = "//h5[text()='Edit']";
    public final static String Admin_ServiceManagementHeadsList_Page_GridData = "//div[@role='grid']";
    public final static String Admin_ServiceManagementHeadsList_Page_View = "//h5[text()='View']";
    public final static String Admin_ServiceManagementHeadsList_Page_ServiceHeadId = "//input[@id='serviceHeadCode']";
    public final static String Admin_ServiceManagementHeadsList_Page_ServiceHeadName = "//input[@id='name']";
    public final static String Admin_ServiceManagementHeadsList_Page_ServiceHeadNameInArabic = "//input[@id='arabicName']";
    public final static String Admin_ServiceManagementHeadsList_Page_ServiceProviderName = "//div[@id='serviceProviderName']";
    public final static String Admin_ServiceManagementHeadsList_Page_OriginalServiceHeadSector = "//div[@id='originalServiceHeadSector']";
    public final static String Admin_ServiceManagementHeadsList_Page_Description = "//input[@id='description']";
    public final static String Admin_ServiceManagementHeadsList_Page_OriginalServiceHeadNameInArabic = "//input[@id='originalServiceHeadArabicName']";
    public final static String Admin_ServiceManagementHeadsList_Page_OriginalServiceHeadName = "//div[@id='originalServiceHeadName']";

    //Customer Profile Page
    public final static String Customer_CustomerProfile_Page = "//h1";
    public final static String Customer_CustomerProfile_Icon = "//div[contains(@class,'MuiAvatar-root')]";
    public final static String Customer_CustomerProfile_Button = "//p[text()='Profile']";
    public final static String Customer_CustomerProfile_ConnectivityButton = "//button[@id='simple-tab-2']";
    public final static String Customer_CustomerProfile_Connectivity_SimhaServiceProvider = "//h1[text()='simah']";
    public final static String Customer_CustomerProfile_ProfileName = "//h2[text()='Rajesh Narayan']";
    public final static String Customer_CustomerProfile_Address = "//h2[text()='Address']";
    public final static String Customer_CustomerProfile_Company = "//h2[text()='AZMQALabs']";
    public final static String Customer_CustomerProfile_Role = "//h2[text()='Company User']";
    public final static String Customer_CustomerProfile_Email = "//h2[text()='rajesh@azm.sa']";
    public final static String Customer_CustomerProfile_Status = "//h2[text()='active']";
    public final static String Customer_CustomerProfile_ContactNo = "//h2[text()='0514141414']";
    public final static String Customer_CustomerProfile_ApiKeyTab = "//button[@id='simple-tab-1']";
    public final static String Customer_CustomerProfile_ApiKey = "//h1[text()='API Key']";
    public final static String Customer_CustomerProfile_ApiKeyCopyIcon = "//div[contains(@class,'MuiChip-filled')]/following-sibling::div";
    public final static String Customer_CustomerProfile_ApiKeyCopiedToast = "//div[text()='API key copied to  clipboard! successfully!']";
    public final static String Customer_CustomerProfile_RegenerateApiKey = "//button[text()='Regenerate API Key']";
    public final static String Customer_CustomerProfile_RegenerateApiKeyYes = "//button[text()='Yes']";
    public final static String Customer_CustomerProfile_RegenerateApiKeyNo = "//button[text()='No']";
    public final static String Customer_CustomerProfile_RegenerateApiKeyConformationText = "//h3";
    public final static String Customer_CustomerProfile_ApiKeyText = "//span[contains(@class,'MuiChip-label')]/child::h5";
    public final static String Customer_CustomerProfile_Page_ConnectivityUseMyCredentialsToggle = "//h2[text()='Use my credentials.']/parent::div//span[contains(@class,'MuiSwitch-switchBase') and 'checked'] ";
    public final static String Customer_CustomerProfile_Page_ConnectivityApiKeyEyeIcon = "(//button[contains(@class,'MuiIconButton-edgeEnd')])[1]";
    public final static String Customer_CustomerProfile_Page_ConnectivityEnterApiKey = "(//h5[text()='API Key']//parent::div//following-sibling::div//child::div[contains(@class,'MuiInputBase-adornedEnd')]//input)[1]";
    public final static String Customer_CustomerProfile_Page_ConnectivitySave = "//button[text()='Save']";
    public final static String Customer_CustomerProfile_Page_ConnectivityApiKeySavedSuccessfully = "//div[text()='Service credentials saved successfully!']";

    //Customer Services Page
    public final static String Customer_CustomerServices_Page_Services = "//button[text()='Services']";
    public final static String Customer_CustomerServices_Page_ServicesText = "//span[text()='Integration Services']";
    public final static String Customer_CustomerServices_Page_AllServiceHeadOptions = "//div[contains(@class,'MuiListItemText-root')]//h2";
    public final static String Customer_CustomerServices_Page_SimahServices = "//span[text()='Simah Services']";
    public final static String Customer_CustomerServices_Page_RealEstatesDeedsServices = "//span[text()='Real Estates Deeds Services']";
    public final static String Customer_CustomerServices_Page_PowerOfAttorneyServicesServices = "//span[text()='Power Of Attorney Services']";
    public final static String Customer_CustomerServices_Page_MobileNumberVerificationServiceServices = "//span[text()='Mobile number verification service']";
    public final static String Customer_CustomerServices_Page_AddressByIDServiceServices = "//span[text()='Address By ID Service']";
    public final static String Customer_CustomerServices_Page_NafathServicesServices = "//span[text()='Nafath services']";
    public final static String Customer_CustomerServices_Page_ConsumerEnquiryService = "//span[@data-path='/v1/simah/consumer-enquiry']";
    public final static String Customer_CustomerServices_Page_RealEstatesDeedsService = "//span[@data-path='/v1/ministry-of-justice/deed/{deedNumber}/{idNumber}/{idType}']";
    public final static String Customer_CustomerServices_Page_RetrieveAttorneyTextsService = "//span[@data-path='/v1/ministry-of-justice/power-of-attorney-lookup']";
    public final static String Customer_CustomerServices_Page_VerifyAttorneyInformationDetailsService = "//span[@data-path='/v1/ministry-of-justice/power-of-attorney-lookup']";
    public final static String Customer_CustomerServices_Page_NafathService = "//span[@data-path='/v1/sdaia/nafath-login']";
    public final static String Customer_CustomerServices_Page_FingerprintVerificationService = "//span[@data-path='/v1/sdaia/fingerprint-verification']";
    public final static String Customer_CustomerServices_Page_MobileNumberVerificationService = "//span[@data-path='/v1/sdaia/mobile-number-verification']";
    public final static String Customer_CustomerServices_Page_AddressByIdService = "//span[@data-path='/v1/sdaia/address-by-id']";
    public final static String Customer_CustomerServices_Page_CommercialRegistrationTreeService = "//span[@data-path='/v1/ministry-of-commerce/commercial-registration-tree/{id}']";
    public final static String Customer_CustomerServices_Page_CommercialRegistrationStatusService = "//span[@data-path='/v1/ministry-of-commerce/commercial-registration-status/{id}']";
    public final static String Customer_CustomerServices_Page_CommercialRegistrationRelatedService = "//span[@data-path='/v1/ministry-of-commerce/commercial-registration-related/{id}/{idType}']";
    public final static String Customer_CustomerServices_Page_CommercialRegistrationOwnsService = "//span[@data-path='/v1/ministry-of-commerce/commercial-registration-owns/{id}/{idType}']";
    public final static String Customer_CustomerServices_Page_CommercialRegistrationOwnsCountryService = "//span[@data-path='/v1/ministry-of-commerce/commercial-registration-owns-country/{id}/{idType}/{countryCode}']";
    public final static String Customer_CustomerServices_Page_CommercialRegistrationOwnersService = "//span[@data-path='/v1/ministry-of-commerce/commercial-registration-owners/{id}']";
    public final static String Customer_CustomerServices_Page_CommercialRegistrationManagerService = "//span[@data-path='/v1/ministry-of-commerce/commercial-registration-managers/{id}']";
    public final static String Customer_CustomerServices_Page_CommercialRegistrationInfoService = "//span[@data-path='/v1/ministry-of-commerce/commercial-registration-info/{id}']";
    public final static String Customer_CustomerServices_Page_CommercialRegistrationFullInfoService = "//span[@data-path='/v1/ministry-of-commerce/commercial-registration-full-info/{id}']";
    public final static String Customer_CustomerServices_Page_CommercialRegistrationAddressService = "//span[@data-path='/v1/ministry-of-commerce/commercial-registration-address/{id}']";
    public final static String Customer_CustomerServices_Page_ArticleOfAssociationCompanyContractsManagerService = "//span[@data-path='/v1/ministry-of-commerce/company-contracts-manager/{crNumber}/{id}/{idType}']";
    public final static String Customer_CustomerServices_Page_ArticleOfAssociationCompanyContractsManagementService = "//span[@data-path='/v1/ministry-of-commerce/company-contracts-management/{crNumber}']";
    public final static String Customer_CustomerServices_Page_ArticleOfAssociationCompanyContractsLookupService = "//span[@data-path='/v1/ministry-of-commerce/company-contracts-lookup']";
    public final static String Customer_CustomerServices_Page_ArticleOfAssociationCompanyContractsInfoService = "//span[@data-path='/v1/ministry-of-commerce/company-contracts-info/{crNumber}']";
    public final static String Customer_CustomerServices_Page_NationalAddressInfoService = "//span[@data-path='/v1/saudi-post/national-address-info/{crNumber}']";
    public final static String Customer_CustomerServices_Page_AuthorizeButton = "//button[@class='btn authorize unlocked']";
    public final static String Customer_CustomerServices_Page_ApiKey = "//input[@type='text']";
    public final static String Customer_CustomerServices_Page_PopupAuthorizeButton = "//button[@type='submit']";
    public final static String Customer_CustomerServices_Page_PopupCloseButton = "//button[text()='Close']";
    public final static String Customer_CustomerServices_Page_TryItOut = "//button[text()='Try it out ']";
    public final static String Customer_CustomerServices_Page_RequestBody = "//textarea[contains(@class,'body-param')]";
    public final static String Customer_CustomerServices_Page_Execute = "//button[text()='Execute']";
    public final static String Customer_CustomerServices_Page_ServerResponse = "//h4[text()='Server response']/parent::div//td[contains(text(),'200')]";
    public final static String Customer_CustomerServices_Page_Code = "//input[@placeholder='code']";
    public final static String Customer_CustomerServices_Page_PrincipalId = "//input[@placeholder='principalId']";
    public final static String Customer_CustomerServices_Page_AgentId = "//input[@placeholder='agentId']";
    public final static String Customer_CustomerServices_Page_CrNumber = "//input[@placeholder='crNumber']";
    public final static String Customer_CustomerServices_Page_UsageCode = "//input[@placeholder='usage-code']";
    public final static String Customer_CustomerServices_Page_NinNumber = "//input[@placeholder='nin']";
    public final static String Customer_CustomerServices_Page_Date = "//input[@placeholder='dateString']";
    public final static String Customer_CustomerServices_Page_BirthDate = "//input[@placeholder='birthDate']";
    public final static String Customer_CustomerServices_Page_VisaNumber = "//input[@placeholder='visaNo']";
    public final static String Customer_CustomerServices_Page_SenderId = "//input[@placeholder='SenderID']";
    public final static String Customer_CustomerServices_Page_Recipient = "//input[@placeholder='Recipient']";
    public final static String Customer_CustomerServices_Page_IqamaNumber = "//input[@placeholder='iqama']";
    public final static String Customer_CustomerServices_Page_BirthDateG = "//input[@placeholder='birthDateG']";
    public final static String Customer_CustomerServices_Page_NinOrIqamaNumber = "//input[@placeholder='ninOrIqama']";
    public final static String Customer_CustomerServices_Page_molEstID = "//input[@placeholder='molEstID']";
    public final static String Customer_CustomerServices_Page_molEstOfficeID = "//input[@placeholder='molEstOfficeID']";
    public final static String Customer_CustomerServices_Page_UnifiedId = "//input[@placeholder='unifiedId']";
    public final static String Customer_CustomerServices_Page_XSignature = "//input[@placeholder='X-Signature']";
    public final static String Customer_CustomerServices_Page_Url = "//input[@placeholder='url']";
    public final static String Customer_CustomerServices_Page_Id = "//input[@placeholder='id']";
    public final static String Customer_CustomerServices_Page_CountryCode = "//input[@placeholder='countryCode']";
    public final static String Customer_CustomerServices_Page_DeedNumber = "//input[@placeholder='deedNumber']";
    public final static String Customer_CustomerServices_Page_IdNumber = "//input[@placeholder='idNumber']";
    public final static String Customer_CustomerServices_Page_XContractsTimestamp = "//input[@placeholder='X-Contracts-Timestamp']";
    public final static String Customer_CustomerServices_Page_XContractsSignature = "//input[@placeholder='X-Contracts-Signature']";
    public final static String Customer_CustomerServices_Page_ContractNumber = "//input[@placeholder='contractNo']";
    public final static String Customer_CustomerServices_Page_Body = "//input[@placeholder='Body']";
    public final static String Customer_CustomerServices_Page_NationalNumber = "//input[@placeholder='nationalNumber']";
    public final static String Customer_CustomerServices_Page_SelectDateType = "//p[text()='Date Type (Hijri / Gregorian)']/parent::div/following-sibling::select";
    public final static String Customer_CustomerServices_Page_Cards = "//div[text()='requestReason']/parent::td/following-sibling::td//select";
    public final static String Customer_CustomerServices_Page_CR = "//p[text()='Vendor Identification Type']/parent::div/following-sibling::select";
    public final static String Customer_CustomerServices_Page_IDValue = "//input[@placeholder='idValue']";
    public final static String Customer_CustomerServices_Page_contractNumber = "//input[@placeholder='contractNumber']";
    public final static String Customer_CustomerServices_Page_PersonalIdNumber = "//input[@placeholder='personalIdNum']";
    public final static String Customer_CustomerServices_Page_IdType = "//p[text()='Id Type These are the id types:  1 - Citizen 2 - Resident 3 - Other']/parent::div/parent::td//select";
    public final static String Customer_CustomerServices_Page_PayMonth = "//input[@placeholder='payMonth']";

    // Customer Roles and Permissions
    public final static String Customer_CustomerRolesAndPermissions_Page_RolesAndPermissionBtn = "//h2[text()='Roles and Permissions']";
    public final static String Customer_CustomerRolesAndPermissions_Page_RolesAndPermissionText = "//p[text()='Roles and Permissions']";
    public final static String Customer_CustomerRolesAndPermissions_Page_Edit = "//h5[text()='Edit']";
    public final static String Customer_CustomerRolesAndPermissions_Page_View = "//h5[text()='View']";
    public final static String Customer_CustomerRolesAndPermissions_Page_FirstRecordActionBtn = "(//*[local-name()='svg' and @data-testid='MoreHorizIcon'])[1]";
    public final static String Customer_CustomerRolesAndPermissions_Page_ViewRoleId = "//input[@id='id']";
    public final static String Customer_CustomerRolesAndPermissions_Page_ViewRoleName = "//input[@id='name']";
    public final static String Customer_CustomerRolesAndPermissions_Page_ViewRoleStatusDropdown = "//div[text()='Active']";
    public final static String Customer_CustomerRolesAndPermissions_Page_ViewRolePermissionRatioBtn = "//label/child::span[contains(@class,'MuiRadio-root')]";
    public final static String Customer_CustomerRolesAndPermissions_Page_AddRole = "//button[text()='Add Role']";
    public final static String Customer_CustomerRolesAndPermissions_Page_Cancel = "//button[@id='cancel']";
    public final static String Customer_CustomerRolesAndPermissions_Page_Save = "//button[@id='save']";
    public final static String Customer_CustomerRolesAndPermissions_Page_RoleName = "//input[@id='name']";
    public final static String Customer_CustomerRolesAndPermissions_Page_StatusDropdown = "//div[text()='Active']";
    public final static String Customer_CustomerRolesAndPermissions_Page_PermissionDropDown = "//button[contains(@class,'MuiAutocomplete-popupIndicator')]//*[contains(@class,'MuiSvgIcon-root')]";
    public final static String Customer_CustomerRolesAndPermissions_Page_BlankRoleNameErrorMessage = "//p[text()='This field cannot be left blank']";
    public final static String Customer_CustomerRolesAndPermissions_Page_BlankPermissionErrorMessage = "//p[text()='Please select atleast one role']";
    public final static String Customer_CustomerRolesAndPermissions_Page_InvalidRoleNameErrorMessage = "//p[text()='Role name max comprise 20 characters']";
    public final static String Customer_CustomerRolesAndPermissions_Page_RoleCreatedSuccessfulMsg = "//div[contains(@class,'MuiAlert-message')]";
    public final static String Customer_CustomerRolesAndPermissions_Page_SearchField = "//input[@id='search']";
    public final static String Customer_CustomerRolesAndPermissions_Page_SearchBtn = "//*[local-name()='svg' and @data-testid='SearchIcon']";
    public final static String Customer_CustomerRolesAndPermissions_Page_AddRolesAndPermissionText = "//p[text()='Add Role']";
    public final static String Customer_CustomerRolesAndPermissions_Page_YesButton = "//button[text()='Yes']";
    public final static String Customer_CustomerRolesAndPermissions_Page_Delete = "//h5[text()='Delete']";
    public final static String Customer_CustomerRolesAndPermissions_Page_DeleteConformationPopup = "//h3";
    public final static String Customer_CustomerRolesAndPermissions_Page_DeleteConformationPopupYes = "//button[text()='Yes']";
    public final static String Customer_CustomerRolesAndPermissions_Page_DeleteConformationPopupNo = "//button[text()='No']";
    public final static String Customer_CustomerRolesAndPermissions_Page_DeletedConformationMsg = "//div[contains(@class,'MuiAlert-message')]";
    public final static String Customer_CustomerRolesAndPermissions_Page_DeletedSuccessfully = "//div[text()='No rows']";
    public final static String Customer_CustomerRolesAndPermissions_Page_ClearButton = "//input[@id='search']/parent::div//following-sibling::div//button";

    // Customer Edit Roles and Permission
    public final static String Customer_CustomerEditRolesAndPermissions_Page_EditRolesAndPermissionText = "//p[text()='Edit Role']";
    public final static String Customer_CustomerEditRolesAndPermissions_Page_EnableAllRadioButton = "//input[@name='permissionOptions']";
    public final static String Customer_CustomerEditRolesAndPermissions_Page_PermissionDropDown = "//button[contains(@class,'MuiAutocomplete-popupIndicator')]//*[contains(@class,'MuiSvgIcon-root')]";
    public final static String Customer_CustomerEditRolesAndPermissions_Page_PermissionDropDownClear = "//button[@aria-label='Clear']";
    public final static String Customer_CustomerEditRolesAndPermissions_Page_YesButton = "//button[text()='Yes']";
    public final static String Customer_CustomerEditRolesAndPermissions_Page_Save = "//button[@id='save']";
    public final static String Customer_CustomerEditRolesAndPermissions_Page_InvalidRoleNameErrorMessage = "//p[text()='Role name max comprise 20 characters']";

    //Customer Package Management
    public final static String Customer_PackageManagementPage_AddPackageButton = "//button[text()='Add Package']";
    public final static String Customer_PackageManagement_Menu = "//div[@id='Package Management']";
    public final static String Customer_PackageManagementPage_Header = "//button[text()='Add Package']/preceding-sibling::div//p";
    public final static String Customer_PackageManagementPage_PackageNameSearchField = "//input[@id='search' and @placeholder='Search Annual Package Name']";
    public final static String Customer_PackageManagementPage_PackageNameSearchBtn = "//input[@id='search' and @placeholder='Search Annual Package Name']/parent::div//*[@data-testid='SearchIcon']";
    public final static String Customer_PackageManagementPage_PackageNameClearBtn = "//input[@id='search' and @placeholder='Search Annual Package Name']/parent::div//*[@data-testid='CloseIcon']";
    public final static String Customer_GridRecordNoRowsMessage = "//input/preceding::div[contains(text(),'No row')]";
    public final static String Customer_PackageManagementPage_SelectPackageStatusBtn = "//div[@aria-haspopup='listbox']/span";
    public final static String Customer_FirstRecordActionBtn = "(//*[local-name()='svg' and @data-testid='MoreHorizIcon'])[1]";
    public final static String Customer_ViewBtn = "//h5[text()='View']/ancestor::div[@role='button']";
    public final static String Customer_PackageManagementPage_PackageDetail = "//hr/preceding-sibling::div/h1";
    public final static String Customer_PackageManagementPage_PackageDetails_PackageNameValue = "//h1[text()='Package Name']/following-sibling::h4";
    public final static String Customer_PackageManagementPage_PackageDetails_PriceValue = "//h1[text()='Price']/following-sibling::h4";
    public final static String Customer_PackageManagementPage_PackageDetails_TransactionLimitValue = "//h1[text()='Transaction Limit']/following-sibling::h4";
    public final static String Customer_PackageManagementPage_PackageDetails_TransactionConsumptionValue = "//h1[text()='Transaction Consumption']/following-sibling::h4";
    public final static String Customer_PackageManagementPage_PackageDetails_ActivationDateValue = "//h1[text()='Activation date']/following-sibling::h4";
    public final static String Customer_PackageManagementPage_PackageDetails_StatusValue = "//h1[text()='Status']/parent::div//span";
    public final static String Customer_PackageManagementPage_PackageDetails_CloseBtn = "//button[@aria-label='close']";
    public final static String Customer_PackageManagementPage_AnnualPackageGridGoToNextIcon = "//input/preceding::button[@aria-label='Go to next page']";
    public final static String Customer_PackageManagementPage_AnnualPackageGridGoToPreviousIcon = "//input/preceding::button[@aria-label='Go to previous page']";
    public final static String Customer_PackageManagementPage_ServiceBundlePackageGridGoToNextIcon = "//input[@placeholder='Search Services Package Name']/following::button[@aria-label='Go to next page']";
    public final static String Customer_PackageManagementPage_ServiceBundlePackageNameSearchField = "//input[@id='search' and @placeholder='Search Services Package Name']";
    public final static String Customer_PackageManagementPage_ServiceBundlePackageNameSearchBtn = "//input[@id='search' and @placeholder='Search Services Package Name']/parent::div//*[@data-testid='SearchIcon']";
    public final static String Customer_PackageManagementPage_ServiceBundlePackageNameClearBtn = "//input[@id='search' and @placeholder='Search Services Package Name']/parent::div//*[@data-testid='CloseIcon']";
    public final static String Customer_PackageManagementPage_AnnualPackageNameSearchField = "//input[@id='search' and @placeholder='Search Annual Package Name']";
    public final static String Customer_PackageManagementPage_SelectAnnualPackageStatusBtn = "//div[@aria-label='Select Annual Package Status']//div//span";
    public final static String Customer_PackageManagementPage_AnnualPackageNameSearchBtn = "//input[@id='search' and @placeholder='Search Annual Package Name']/parent::div//*[@data-testid='SearchIcon']";
    public final static String Customer_PackageManagementPage_SelectServiceBundlePackageStatusBtn = "//div[@aria-label='Select Services Package Status']//div//span";
    public final static String Customer_PackageManagementPage_PriceConsumptionValue = "//div[text()='AzmServiceBundle']/parent::div//div[@data-field='priceConsumption']//h2";
    public final static String Customer_PackageManagementPage_TransactionConsumptionValue = "//div[text()='AzmAnnualTier']/parent::div//div[@data-field='transactionConsumption']//h2";

    //Customer Add Package Management
    public final static String Customer_AddPackagePage_Header = "//*[@data-testid='KeyboardArrowRightIcon']/parent::div/following-sibling::p";
    public final static String Customer_AddPackagePage_AnnualSubscriptionTiersTab = "//h5/following-sibling::div//button[@role='tab']/preceding-sibling::button";
    public final static String Customer_AddPackagePage_AnnualSubscriptionTiersTabIsSelected = "//h5/following-sibling::div//button[@role='tab']/preceding-sibling::button[@aria-selected='true']";
    public final static String Customer_AddPackagePage_ServicesBundlesTab = "//h5/following-sibling::div//button[@role='tab']/following-sibling::button";
    public final static String Customer_AddPackagePage_SubscribedPackagesTxt = "//button[@type='submit' and text()='Renew Package']/preceding::hr/preceding-sibling::h1";
    public final static String Customer_AddPackagePage_SubscribedPackageName = "//button[@type='submit' and text()='Renew Package']/preceding::div/h1/preceding-sibling::h1";
    public final static String Customer_AddPackagePage_SubscribedPackagePrice = "//button[@type='submit' and text()='Renew Package']/preceding::div/h1/following-sibling::h1";
    public final static String Customer_AddPackagePage_SubscribedPackageStatus = "//button[@type='submit' and text()='Renew Package']/preceding::div/h5/following-sibling::h5";
    public final static String Customer_AddPackagePage_RenewPackageBtn = "//button[@type='submit' and text()='Renew Package']";
    public final static String Customer_AddPackagePage_AreYouSureYouWantToSelectThisPackagePopUpTxt = "//div[@aria-labelledby='customized-dialog-title']//h3";
    public final static String Customer_AddPackagePage_AreYouSureYouWantToSelectThisPackagePopUpCloseBtn = "//button[@aria-label='close']";
    public final static String Customer_AddPackagePage_AreYouSureYouWantToSelectThisPackagePopUpYesBtn = "//div[@aria-labelledby='customized-dialog-title']//button/preceding-sibling::button";
    public final static String Customer_AddPackagePage_AreYouSureYouWantToSelectThisPackagePopUpNoBtn = "//div[@aria-labelledby='customized-dialog-title']//button/following-sibling::button";
    public final static String Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpHeader = "//div[@aria-labelledby='customized-dialog-title']//h2";
    public final static String Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpCloseBtn = "//div[@aria-labelledby='customized-dialog-title']/button[@aria-label='close']";
    public final static String Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpSaveBtn = "//input[@id='activationDate']/ancestor::div/following::button/preceding-sibling::button";
    public final static String Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpCancelBtn = "//input[@id='activationDate']/ancestor::div/following::button/following-sibling::button";
    public final static String Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpActivationDateError = "//input[@id='activationDate']/following::p";
    public final static String Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpActivationDate = "//button[@aria-label='Choose date']";
    public final static String Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpActivationDateYearDownArrow = "//button[@aria-label='calendar view is open, switch to year view']";
    public final static String Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpTodayDateActivationDate = "//button[@aria-current='date']";
    public final static String Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUp = "//div/h3/preceding-sibling::h3";
    public final static String Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpContent = "//div/h3/following-sibling::h3";
    public final static String Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpNoBtn = "//img/parent::div/following-sibling::div/button/following-sibling::button";
    public final static String Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpYesBtn = "//img/parent::div/following-sibling::div/button/preceding-sibling::button";
    public final static String Customer_AddPackagePage_AnnualPackageWillBeActivatedOnTheActivationDatePopUpCloseBtn = "//img/ancestor::div/button";
    public final static String Customer_AddPackagePage_AvailablePackages = "//button[@type='submit' and text()='Renew Package']/following::div/h1/preceding-sibling::h1";
    public final static String Customer_ErrorMsg = "//div[@role='alert']";
    public final static String Customer_AddPackagePage_GenerateInvoiceBtn = "//button[@type='submit']/following::button[@type='submit']";
    public final static String Customer_AddPackagePage_AvailableToAddTxt = "//button[@type='submit']/parent::div/following-sibling::h1";
    public final static String Customer_AddPackagePage_AddNewAnnualSubscriptionTierPopUpPackageDetails = "//form//li/descendant::div/div";
    public final static String Customer_AddPackagePage_SubscribedPrepaidBundlesTxt = "//h1[text()='Subscribed Prepaid Bundles']";
    public final static String Customer_AddPackagePage_SubscribedServiceBundlePrice = "//button[@type='submit' and text()='Renew Package']/preceding::ul/preceding-sibling::h1";
    public final static String Customer_AddPackagePage_SubscribedServiceBundleName = "//button[@type='submit' and text()='Renew Package']/preceding::div/ul/preceding-sibling::h1";
    public final static String Customer_AddPackagePage_AddNewServiceBundlePopUpPackagePrice = "//form//ul/preceding-sibling::h1";
    public final static String Customer_AddPackagePage_AddNewServiceBundlePopUpPackagePeriod = "//form//li/preceding-sibling::li/preceding-sibling::li/preceding-sibling::li/preceding-sibling::li";
    public final static String Customer_AddPackagePage_PostpaidDetails = "//h1[text()='Postpaid Bundle']/parent::div//ul";

    //Customer My Invoices
    public final static String Customer_MyInvoicesMenu = "//div[@id='My Invoices']";
    public final static String Customer_MyInvoicesPage_Header = "//button[@id='exportPDF']/preceding::div//p";
    public final static String Customer_MyInvoicesPage_GridColumnNames = "//div[@role='columnheader']";
    public final static String Customer_MyInvoicesPage_Grid = "//div[@role='grid']";
    public final static String Customer_MyInvoicesPage_PackageNameSearchField = "//input[@id='search' and @placeholder='Search Package Name']";
    public final static String Customer_MyInvoicesPage_PackageNameSearchBtn = "//input[@id='search' and @placeholder='Search Package Name']/parent::div//*[@data-testid='SearchIcon']";
    public final static String Customer_MyInvoicesPage_PackageNameClearBtn = "//input[@id='search' and @placeholder='Search Package Name']/parent::div//*[@data-testid='CloseIcon']";
    public final static String Customer_MyInvoicesPage_SelectInvoiceStatusBtn = "//div/span/preceding::div[@aria-haspopup='listbox']/span";
    public final static String Customer_MyInvoicesPage_SelectInvoiceTypeBtn = "//div[@aria-haspopup='listbox']/span/following::div/span";
    public final static String Customer_MyInvoicesPage_ExportPDFBtn = "//button[@id='exportPDF']";
    public final static String Customer_MyInvoicesPage_ExportExcelBtn = "//button[@id='exportExcel']";
    public final static String Customer_MyInvoicesPage_GridRecordNoRowsMessage = "//div[contains(@class,'MuiDataGrid-overlayWrapperInner')]/div";
    public final static String Customer_ViewUserPage_Header = "//*[@data-testid='KeyboardArrowRightIcon']/parent::div/following-sibling::p";
    public final static String Admin_Customer_AddOrEditUserPage_IDField = "//input[@id='id']";
    public final static String Admin_Customer_AddOrEditUserPage_Role = "//h2[text()='Role *']/parent::div/div/div";
    public final static String Admin_Customer_AddOrEditUserPage_Status = "//h2[text()='status *']/parent::div/div/div";
    public final static String Customer_CustomerProfile_Page_HomeTab = "//button[text()='Home']";

    //Customer User Management
    public final static String Customer_UserManagementMenu = "//div[@id='User Management']";
    public final static String Customer_UserManagementPage = "//h2/ancestor::div/preceding-sibling::div//p";
    public final static String Customer_CreateUserPage_RoleDropdown = "//div[@role='combobox']//span";
    public final static String Customer_CreateUserPage_StatusDropdown = "//div[@aria-label='Select Status' ]";
    public final static String Customer_UserManagementPage_DeleteUserConfirmationPopupMsg = "//button[@aria-label='close']/following::div//h3";
    public final static String Customer_UserManagement_RoleDropdown = "//div[@aria-label='Select Role']//*[@data-testid='ArrowDropDownIcon']";
    public final static String Customer_EditUserManagement_SaveButton = "//button[@id='save']";

    //Customer Add or edit user page
    public final static String Customer_UserManagementPage_Save = "//button[@id='save']";
    public final static String Customer_AddOrEditUserPage_firstName_Error = "//input[@id='firstName']/ancestor::div/following-sibling::div/div/p";
    public final static String Customer_AddOrEditUserPage_lastName_Error = "//input[@id='lastName']/ancestor::div/following-sibling::div/div/p";
    public final static String Customer_AddOrEditUserPage_nationalId_Error = "//input[@id='nationalId']/ancestor::div/following-sibling::div/div/p";
    public final static String Customer_AddOrEditUserPage_mobileNo_Error = "//input[@id='contactNo']/ancestor::div/following-sibling::div/div/p";
    public final static String Customer_AddOrEditUserPage_UserName_Error = "//input[@id='username']/ancestor::div/following-sibling::div/div/p";
    public final static String Customer_AddOrEditUserPage_Email_Error = "//input[@id='email']/ancestor::div/following-sibling::div/div/p";
    public final static String Customer_AddOrEditUserPage_Role_Error = "//div[@aria-label='Select Role']/following-sibling::div//p";
    public final static String Customer_AddOrEditUserPage_RoleDropdown = "//div[@aria-label='Select Role']";
    public final static String Customer_AreYouSureYOuWantToCancelPopup_CancelBtn = "//button[text()='Yes']";
    public final static String Customer_AddOrEditUserPage_CancelBtn = "//button[@id='cancel']";
    public final static String Customer_AddOrEditUserPage_SaveButton = "//button[@id='save']";
}


	

