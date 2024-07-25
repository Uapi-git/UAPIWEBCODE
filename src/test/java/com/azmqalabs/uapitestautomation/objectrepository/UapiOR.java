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

}


	

