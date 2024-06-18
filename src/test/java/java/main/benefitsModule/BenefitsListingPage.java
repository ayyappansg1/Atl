//package main.benefitsModule;
//
//import common.BaseTest;
//import common.TestUtil;
//import helper.LocalHelper;
//import io.qameta.allure.Description;
//import io.qameta.allure.Owner;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pages.benefitsModule.ListingPageBenefits;
//import pages.common.LoginPage;
//import java.util.Properties;
//
//public class BenefitsListingPage extends BaseTest {
//
//    ListingPageBenefits listingPageBenefits;
//    Properties prop = new TestUtil().init_Properties("benefits/ListingPage");
//
//    @BeforeMethod(alwaysRun = true)
//    public void setUp() throws InterruptedException {
//        listingPageBenefits = new ListingPageBenefits(driver);
//        new LoginPage(driver).loginAs("INTERNAL HR");
//        new ListingPageBenefits(driver).launchBenefits();
//    }
//
//    @Description("The test verifies the benefits listing page url")
//    @Owner("sundara.p@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifyBenefitsListingPageURL(){
//        logger.info("#### Verify verifyBenefitsListingPageURL method ####");
//        new LocalHelper().waitForPageURL(prop.getProperty("LISTING_PAGE_URL"),driver);
//        Assert.assertEquals(appURL+prop.getProperty("LISTING_PAGE_URL"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
//    }
//
//    @Description("The test verifies the benefits listing page url")
//    @Owner("sundara.p@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifySearchByPlanFunctionality() throws InterruptedException {
//        logger.info("#### Verify verifySearchByPlanFunctionality method ####");
//
//        // Verifying Search Input Element
//        Assert.assertTrue(listingPageBenefits.searchInput_IsPresent(),"Search input is not present");
//
//        // Perform Search with valid plan name
//        listingPageBenefits.performSearchBy(prop.getProperty("PLAN_NAME"));
//
//        // Verifying the search results
//        Assert.assertEquals(listingPageBenefits.searchByPlanIsSuccessful(prop.getProperty("PLAN_NAME")),prop.getProperty("PLAN_NAME"),"Plan name search is not working");
//        listingPageBenefits.clearSearch();
//
//        // Perform Search with invalid plan name
//        listingPageBenefits.performSearchBy(prop.getProperty("PLAN_NAME_INVALID"));
//
//        // Verifying the search results
//        Assert.assertEquals(listingPageBenefits.getUnsuccessfulSearchMessage(),prop.getProperty("UNSUCCESSFUL_ERR_MSG"),"Plan name search is not working");
//        listingPageBenefits.clearSearch();
//    }
//
//    @Description("The test verifies the Provider dropdown")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifyProviderDropdownFunctionality() throws InterruptedException {
//        logger.info("### Running verifyProviderDropdownFunctionality method ###");
//
//        //Verifying Provider dropdown elements
//        Assert.assertTrue(listingPageBenefits.providerDropdown_IsPresent(), "Provider input is not displayed in  the UI");
//        Assert.assertEquals(listingPageBenefits.getProviderLabelText(),prop.getProperty("PROVIDER_LABEL"),"Mismatch with the provider label text");
//        Assert.assertEquals(listingPageBenefits.getProviderPlaceholderText(),prop.getProperty("DROPDOWN_PLACEHOLDER_TEXT"), "Mismatch with the Provider placeholder text");
//
//        //Perform select the provider
//        listingPageBenefits.openProviderDropdown();
//        listingPageBenefits.selectProvider(prop.getProperty("PROVIDER"));
//        listingPageBenefits.closeProviderDropdown();
//
//        //Verifying the search results
//        Assert.assertEquals(listingPageBenefits.searchByProviderIsSuccessful(prop.getProperty("PROVIDER")),prop.getProperty("PROVIDER"),"Provider search is not working");
//    }
//
//    @Description("The test verifies the Type dropdown")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifyTypeDropdownFunctionality() throws InterruptedException {
//        logger.info("### Running verifyTypeDropdownFunctionality method ###");
//
//        //Verifying Type dropdown elements
//        Assert.assertTrue(listingPageBenefits.typeDropdown_IsPresent(), "Type input is not displayed in the UI");
//        Assert.assertEquals(listingPageBenefits.getTypeLabelText(), prop.getProperty("TYPE_LABEL"), "Mismatch with the type label text");
//        Assert.assertEquals(listingPageBenefits.getTypePlaceholderText(), prop.getProperty("DROPDOWN_PLACEHOLDER_TEXT"), "Mismatch with the Type placeholder text");
//
//        //Perform select the Type
//        listingPageBenefits.openTypeDropdown();
//        listingPageBenefits.selectType(prop.getProperty("TYPE"));
//        listingPageBenefits.performSearchBy(prop.getProperty("PLAN_NAME"));
//
//        //Verifying the search results
//        Assert.assertEquals(listingPageBenefits.searchByTypeIsSuccessful(prop.getProperty("TYPE")), prop.getProperty("TYPE"), "Type search is not working");
//    }
//
//    @Description("The test verifies the Status dropdown")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifyStatusDropdownFunctionality() throws InterruptedException {
//        logger.info("### Running verifyStatusDropdownFunctionality method ###");
//
//        //Verifying Status dropdown elements
//        Assert.assertTrue(listingPageBenefits.statusDropdown_IsPresent(), "Status input is not displayed in the UI");
//        Assert.assertEquals(listingPageBenefits.getStatusLabelText(), prop.getProperty("STATUS_LABEL"), "Mismatch with the status label text");
//        Assert.assertEquals(listingPageBenefits.getStatusPlaceholderText(), prop.getProperty("DROPDOWN_PLACEHOLDER_TEXT"), "Mismatch with the Status placeholder text");
//
//        //Perform select  the Status
//        listingPageBenefits.openStatusDropdown();
//        listingPageBenefits.selectStatus(prop.getProperty("STATUS"));
//        listingPageBenefits.closeStatusDropdown();
//        listingPageBenefits.performSearchBy(prop.getProperty("PLAN_NAME"));
//
//        //Verifying the search results
//        Assert.assertEquals(listingPageBenefits.searchByStatusIsSuccessful(prop.getProperty("STATUS")), prop.getProperty("STATUS"), "Status search is not working");
//    }
//
//    @Description("The test verifies the customization button")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifyCustomizationButtonFunctionality() throws InterruptedException {
//        logger.info(" ### Running verifyCustomizationButtonFunctionality method  ####");
//
//        // Verifying Customization Button Elements
//        Assert.assertTrue(listingPageBenefits.customizationButton_IsPresent(), "Customization button is not displayed in the UI");
//
//        //Clicking on customization button
//        listingPageBenefits.clickOnCustomizationButton();
//
//        //Verifying customization checkbox
//        listingPageBenefits.unClickOnTypeCustomization();
//        listingPageBenefits.saveViewInCustomization();
//        Assert.assertFalse(listingPageBenefits.typeIsPresentInGrid(), "Type column is not removed in the table grid");
//
//        //Reset the customization
//        listingPageBenefits.clickOnCustomizationButton();
//        listingPageBenefits.clickResetInCustomization();
//        Assert.assertTrue(listingPageBenefits.verifyDefaultGridIsPresent(),"Reset is not working");
//    }
//
//    @Description("The test verifies the Listing Page table header elements")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifyTableHeaderElements() throws InterruptedException {
//        logger.info("#### Running VerifyTableHeaderElements method  ####");
//
//        //Verifying table header elements
//        Assert.assertTrue(listingPageBenefits.tableHeaderPlanName_IsPresent(), "Plan/Provider Name is not found or mismatch");
//        Assert.assertTrue(listingPageBenefits.tableHeaderType_IsPresent(), "Type is not found or mismatch");
//        Assert.assertTrue(listingPageBenefits.tableHeaderEmployeesEnrolled_IsPresent(), "Employees Enrolled is not found or mismatch");
//        Assert.assertTrue(listingPageBenefits.tableHeaderStartDate_IsPresent(), "Start Date is not found or mismatch");
//        Assert.assertTrue(listingPageBenefits.tableHeaderEndDate_IsPresent(), "End Date is not found or mismatch");
//        Assert.assertTrue(listingPageBenefits.tableHeaderStatus_IsPresent(), "Status is not found or mismatch");
//        Assert.assertTrue(listingPageBenefits.tableHeaderAction_IsPresent(), "Action is not found or mismatch");
//    }
//
//    @Description("The test verifies the pagination elements")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifyPaginationFunctionality() throws InterruptedException {
//        logger.info("#### Running verifyPaginationFunctionality method #### ");
//
//        // Verifying the Pagination functionality elements
//        Assert.assertTrue(listingPageBenefits.paginationPrev_IsPresent(), "Prev is not present in UI");
//        Assert.assertTrue(listingPageBenefits.paginationNext_IsPresent(), "Next is not present in UI");
//        Assert.assertTrue(listingPageBenefits.paginationJumpTo_IsPresent(), "Jump To is not present in UI");
//        Assert.assertTrue(listingPageBenefits.paginationGo_IsPresent(), "Go is not present in UI");
//        Assert.assertTrue(listingPageBenefits.paginationShowing_IsPresent(), "Showing is not present in UI");
//
//        //Verifying next page
//        Assert.assertTrue(listingPageBenefits.verifyNextButtonEnabled(), "Next button is not enabled");
//        listingPageBenefits.clickOnNextButton();
//        Assert.assertTrue(listingPageBenefits.verifyNextPageIsOpened(), "Next page did not open, next button is not working");
//
//        //Verifying prev page
//        Assert.assertTrue(listingPageBenefits.verifyPrevButtonEnabled(), "Prev button is not enabled");
//        listingPageBenefits.clickOnPrevButton();
//        Assert.assertTrue(listingPageBenefits.verifyPrevPageIsOpened(), "Prev page did not open, prev button is not working");
//
//        //Verifying JumpTo page
//        Assert.assertTrue(listingPageBenefits.verifyJumpToEnabled(), "JumpTo is not enabled");
//        listingPageBenefits.sendValueToJumpTo(prop.getProperty("PAGE_NO_3"));
//        listingPageBenefits.clickOnGoButton();
//        Assert.assertTrue(listingPageBenefits.verifyJumpPageIsOpened(), "Jump page did not open, JumpTo is not working");
//
//        //Verifying Showing Count
//        listingPageBenefits.selectPaginationCount(prop.getProperty("SHOWING_BY_30"));
//        Assert.assertTrue(listingPageBenefits.showingByThirtyIsDisplayed(prop.getProperty("SHOWING_BY_30")),"Pagination showing list is not properly working ");
//
//        // Verifying go to last page
//        listingPageBenefits.verifyPaginationEnd();
//        listingPageBenefits.clickPaginationEnd();
//        Assert.assertEquals(listingPageBenefits.getCurrentPage(),listingPageBenefits.getTotalPages(),"Not working forward");
//
//        // Verifying go to the first page
//        listingPageBenefits.verifyPaginationStart();
//        listingPageBenefits.clickPaginationStart();
//        Assert.assertEquals(listingPageBenefits.getCurrentPage(),prop.getProperty("PAGE_NO_1"),"Not working backward");
//    }
//
//    @Description("Verify the Add New Plan button functionality")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifyAddNewPlanButton() throws InterruptedException {
//        logger.info("#### Running verifyAddNewPlanButton method  ####");
//
//        listingPageBenefits.clickAddNewPlanButton();
//        listingPageBenefits.clickAddMedicalOption();
//        Assert.assertTrue(listingPageBenefits.AddMedical_IsDisplayed(),"Add New Plan is not displayed");
//    }
//
//    @Description("Verify Select All option functionality in provider dropdown")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(enabled = false, groups = {"Smoke"})
//    public void verifySelectAllOptionInProviderDropdown() {
//        logger.info("### Running verifySelectAllOptionInProviderDropdown method ###");
//
//        listingPageBenefits.openProviderDropdown();
//        listingPageBenefits.selectAllProvider();
//
//        Assert.assertTrue(listingPageBenefits.verifySelectAllProviderDropdown(), "Select All option is not working as expected for Provider dropdown");
//    }
//
//    @Description("Verify Select All option functionality in type dropdown")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifySelectAllOptionInTypeDropdown() {
//        logger.info("### Running verifySelectAllOptionInTypeDropdown method ###");
//
//        listingPageBenefits.openTypeDropdown();
//        listingPageBenefits.selectAllType();
//
//        Assert.assertTrue(listingPageBenefits.verifySelectAllTypeDropdown(), "Select All option is not working as expected for Type dropdown");
//
//    }
//
//    @Description("Verify Search option functionality in provider dropdown")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifySearchOptionInProviderDropdown() throws InterruptedException {
//        logger.info("### Running verifySearchOptionInProviderDropdown method");
//
//        //Perform search the provider
//        listingPageBenefits.openProviderDropdown();
//        listingPageBenefits.searchProvider(prop.getProperty("PROVIDER"));
//        listingPageBenefits.closeProviderDropdown();
//
//        //Verifying the search results
//        Assert.assertEquals(listingPageBenefits.searchByProviderIsSuccessful(prop.getProperty("PROVIDER")), prop.getProperty("PROVIDER"),"Provider search is not working");
//
//    }
//
//    @Description("Verify Search option functionality in type dropdown")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifySearchOptionInTypeDropdown() throws InterruptedException {
//        logger.info("### Running verifySearchOptionInTypeDropdown method");
//
//        //Perform search the Type
//        listingPageBenefits.openTypeDropdown();
//        listingPageBenefits.searchType(prop.getProperty("TYPE"));
//        listingPageBenefits.performSearchBy(prop.getProperty("PLAN_NAME"));
//
//        //Verifying the search results
//        Assert.assertEquals(listingPageBenefits.searchByTypeIsSuccessful(prop.getProperty("TYPE")), prop.getProperty("TYPE"), "Type search is not working");
//    }
//}
