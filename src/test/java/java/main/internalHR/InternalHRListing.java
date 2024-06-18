package main.internalHR;

import common.BaseTest;
import common.TestUtil;
import helper.LocalHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.LoginPage;
import pages.common.ListingPage;

import java.util.Properties;

public class  InternalHRListing extends BaseTest {

    LoginPage loginPage;
    private ListingPage listingPage;

    Properties prop = new TestUtil().init_Properties("clientHR/ListingPageClientHR");


    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        listingPage = new ListingPage(driver);
        loginPage = new LoginPage(driver);
        loginPage.loginAs("INTERNAL HR");
        //listingPageInternalHR.switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
    }

    @Description("The test verifies the Internal page url")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Smoke"})
    public void verifyInternalListingPageURL() {
        logger.info("#### Verify Internal HR listing Page URL ####");
        new LocalHelper().waitForPageURL(prop.getProperty("INTERNAL_LIST_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("INTERNAL_LIST_PAGE_URL"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }

    @Description("The test verifies the search employees By Name")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Smoke"})
    public void verifySearchByNameFunctionality() throws InterruptedException {
        logger.info("#### Running verifySearchByNameFunctionality method ####");

        // Verifying Search Input Elements
        Assert.assertTrue(listingPage.searchInput_IsPresent(),"Search Input is not displayed in the UI");


        // Perform Search with valid employee name
        listingPage.clickSearchInput();
        listingPage.performSearchBy(prop.getProperty("EMPLOYEE_NAME"));
        Assert.assertTrue(listingPage.searchCloseButton_IsPresent(),"Search Close Button is not visible");

        // Verifying the search results
        Assert.assertEquals(listingPage.searchByNameIsSuccessful(prop.getProperty("EMPLOYEE_NAME")),prop.getProperty("EMPLOYEE_NAME"),"Name search is not working");

        // Perform clear filter to clear the search
        listingPage.clickSearchCloseButton();

        // Perform Search with invalid employee name
        listingPage.performSearchBy(prop.getProperty("EMPLOYEE_NAME_WRONG"));
        Assert.assertTrue(listingPage.clearAll_IsPresent(),"Clear All is not visible");

        // Verifying the unsuccessful search message
        Assert.assertEquals(listingPage.unsuccessfulSearchMessage(),prop.getProperty("UNSUCCESSFUL_SEARCH_MESSAGE"),"Employee not found ");

        // Perform clear filter to clear the results
        listingPage.clickSearchCloseButton();
    }

    @Description("The test verifies the search employees By Id")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Smoke"})
    public void verifySearchByIdFunctionality() throws InterruptedException {
        logger.info("#### Running verifySearchByIDFunctionality method ####");

        // Perform Search with valid employee id
        listingPage.clickSearchInput();
        listingPage.performSearchBy(prop.getProperty("EMPLOYEE_ID"));
        Assert.assertTrue(listingPage.searchCloseButton_IsPresent(),"Clear filter is not visible");
        // Verifying the search results
        Assert.assertEquals(listingPage.searchByIdIsSuccessful(prop.getProperty("EMPLOYEE_ID")),prop.getProperty("EMPLOYEE_ID"),"Id search is not working");

        // Perform clear filter to clear the search
        listingPage.clickSearchCloseButton();

        // Perform Search with invalid employee id
        listingPage.performSearchBy(prop.getProperty("EMPLOYEE_ID_WRONG"));
        Assert.assertTrue(listingPage.clearAll_IsPresent(),"Clear All is not visible");

        // Verifying the unsuccessful search message
        Assert.assertEquals(listingPage.unsuccessfulSearchMessage(),prop.getProperty("UNSUCCESSFUL_SEARCH_MESSAGE"),"Employee id not found ");
        listingPage.clickSearchCloseButton();
    }


    @Description("The test verifies the customer dropdown")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Smoke"})
    public void verifyCustomerDropdownFunctionality() throws InterruptedException {
        logger.info("#### Running verifyCustomerDropdownFunctionality method ####");
        listingPage.clickFilterButton();

        // Verifying Country dropdown elements
        Assert.assertTrue(listingPage.customerDropdown_IsPresent(), "Customer input is not displayed in the UI");
        Assert.assertEquals(listingPage.getCustomerLabelText(),prop.getProperty("CUSTOMER_LABEL"),  "Mismatch with the customer label Text");
        Assert.assertEquals(listingPage.getCustomerPlaceholderText(),prop.getProperty("COUNTRY_DROPDOWN_PLACEHOLDER_TEXT"),  "Mismatch with the Customer placeholder text");

        // Perform select the customer
        listingPage.openCustomerDropdown();
        listingPage.selectTravelMate();
        listingPage.clickApplyFilterButton();

        // Verifying the search results
        Assert.assertEquals(listingPage.searchByCustomerIsSuccessful(prop.getProperty("CUSTOMER_TRAVEL")),prop.getProperty("CUSTOMER_TRAVEL"),"Customer search is not working");

        // Perform clear filter to clear the search
        listingPage.clickFilterButton();
        Assert.assertTrue(listingPage.clearFilter_IsPresent(),"Clear filter is not visible");
        listingPage.clickClearFilter();

    }

    @Description("The test verifies the country dropdown")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Smoke"})
    public void verifyCountryDropdownFunctionality() throws InterruptedException {
        logger.info("#### Running verifyCountryDropdownFunctionality method ####");
        listingPage.clickFilterButton();

        // Verifying Country dropdown elements
        Assert.assertTrue(listingPage.countryDropdown_IsPresent(), "Country input is not displayed in the UI");
        Assert.assertEquals(listingPage.getCountryLabelText(),prop.getProperty("COUNTRY_LABEL"),  "Mismatch with the country label Text");
        Assert.assertEquals(listingPage.getCountryPlaceholderText(),prop.getProperty("COUNTRY_DROPDOWN_PLACEHOLDER_TEXT"),  "Mismatch with the Country placeholder text");

        // Perform select the country
        listingPage.openCountryDropdown();
        listingPage.selectCountry();
        listingPage.clickApplyFilterButton();


        // Verifying the search results
        Assert.assertEquals(listingPage.internalSearchByCountryIsSuccessful(prop.getProperty("COUNTRY_INDIA")),prop.getProperty("COUNTRY_INDIA"),"Country search is not working");

        // Perform clear filter to clear the search
        listingPage.clickFilterButton();
        Assert.assertTrue(listingPage.clearFilter_IsPresent(),"Clear filter is not visible");
        listingPage.clickClearFilter();

    }

    @Description("The test verifies the status selection")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Smoke"})
    public void verifyStatusDropdownFunctionality() throws InterruptedException {
        logger.info("#### Running verifyStatusDropdownFunctionality method ####");
        listingPage.clickFilterButton();

        // Verifying Status Dropdown Elements
        Assert.assertTrue(listingPage.statusDropdown_IsPresent(),"Status is not displayed in the UI");
        Assert.assertEquals(listingPage.getStatusLabelText(),prop.getProperty("STATUS_LABEL"), "Mismatch with the status label text");
        Assert.assertEquals(listingPage.getStatusPlaceholderText(),prop.getProperty("INTERNAL_STATUS_DROPDOWN_PLACEHOLDER_TEXT"), "Mismatch with the status placeholder text");

        // Verifying Active Status selection
        listingPage.selectActiveStatus();
        Assert.assertTrue(listingPage.checkActiveStatusSelected(),"Status dropdown is not selecting the option");
        listingPage.clickApplyFilterButton();

       // Assert.assertTrue(listingPage.clearFilter_IsPresent(),"Clear Filter is not present");
        Assert.assertEquals(listingPage.internalCheckActiveStatus(prop.getProperty("STATUS_ACTIVE")),prop.getProperty("STATUS_ACTIVE"),"Status selected option is not displayed ");

        // Perform clear filter to clear the results

        listingPage.clickFilterButton();
        Assert.assertTrue(listingPage.clearFilter_IsPresent(),"Clear filter is not visible");
        listingPage.clickClearFilter();

        // Verifying Active Status deselection
        listingPage.selectActiveStatus();
        listingPage.deSelectStatus();
        Assert.assertEquals(listingPage.getStatusPlaceholderText(),prop.getProperty("STATUS_DROPDOWN_PLACEHOLDER_TEXT"),"Status selected option is not toggled");

    }

    @Description("The test verifies the customization button")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Smoke"})
    public void verifyCustomizationButtonFunctionality() throws InterruptedException {
        logger.info(" ### Running verifyCustomizationButtonFunctionality method  ####");

        // Verifying Customization Button Elements
        Assert.assertTrue(listingPage.customizationButton_IsPresent(),"Customization button is not displayed in the UI");

        listingPage.clickCustomizationButton();

        // Verifying Customization checkbox
        listingPage.clickDateCreatedInCustomization();
        listingPage.saveViewInCustomization();
        Assert.assertEquals(listingPage.dateCreatedIsPresentInGrid(),prop.getProperty("DATE_CREATED"),"Date Created is not present in the table grid ");

        // Reset the customization
        listingPage.clickCustomizationButton();
        listingPage.clickResetInCustomization();
        Assert.assertTrue(listingPage.verifyInternalDefaultGridIsPresent(),"Reset is not working");
    }

    @Description("The test verifies the Listing Page table header elements")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Smoke"})
    public void verifyTableHeaderElements() throws InterruptedException {
        logger.info("#### Running VerifyTableHeaderElements method  ####");

        // Verifying Table Header Elements
        Assert.assertTrue(listingPage.tableHeaderName_IsPresent(),"Name is not found or mismatch");
        Assert.assertTrue(listingPage.tableHeaderEmpId_IsPresent(),"Employee Id is not found or mismatch");
        Assert.assertTrue(listingPage.tableHeaderInternalJobTitle_IsPresent(),"Job Title is not found or mismatch");
        Assert.assertTrue(listingPage.tableHeaderCustomer_IsPresent(),"Customer is not found or mismatch");
        Assert.assertTrue(listingPage.tableHeaderCountry_IsPresent(),"Country is not found or mismatch");
        Assert.assertTrue(listingPage.tableHeaderStatus_IsPresent(),"Status is not found or mismatch");
        Assert.assertTrue(listingPage.tableHeaderTimesheet_IsPresent(),"TimeSheet is not found or mismatch");
    }

    @Description("The test verifies the pagination elements")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Smoke"})
    public void verifyPaginationFunctionality() throws InterruptedException {
        logger.info("#### Running verifyPaginationFunctionality method #### ");

        // Verifying the Pagination functionality elements
        Assert.assertTrue(listingPage.paginationPrev_IsPresent(),"Prev is not present in UI ");
        Assert.assertTrue(listingPage.paginationNext_IsPresent(),"Next is not present in UI ");
        Assert.assertTrue(listingPage.paginationJumpTo_IsPresent(),"JumpTo is not present in UI ");
        Assert.assertTrue(listingPage.paginationGo_IsPresent(),"Go is not present in UI ");
        Assert.assertTrue(listingPage.paginationShowing_IsPresent(),"Showing is not present in UI");

        // Verifying next page
        Assert.assertTrue(listingPage.verifyNextButtonEnabled(),"Next button is not enabled");
        listingPage.clickNextPageButton();
        Assert.assertTrue(listingPage.verifyNextPageIsOpened(),"Next button is not working ");

        // Verifying prev page
        Assert.assertTrue(listingPage.clickPrevButtonEnabled(),"Prev button is not enabled");
        listingPage.clickPrevPageButton();
        Assert.assertTrue(listingPage.verifyPrevPageIsOpened(),"Prev button is not working");

        // Verifying JumpTo page
        Assert.assertTrue(listingPage.verifyJumpToEnabled(),"JumpTo have only one page");
        listingPage.sendValueJumpTo(prop.getProperty("PAGE_NO_5"));
        listingPage.clickGoToPage();
        Assert.assertTrue(listingPage.checkJumpPageIsDisplayed(),"JumpTo is not working ");

        // Verifying Showing By
        listingPage.selectPaginationCount(prop.getProperty("SHOWING_BY_30"));
        Assert.assertTrue(listingPage.showingByThirtyIsDisplayed(prop.getProperty("SHOWING_BY_30")),"Pagination showing list is not properly working ");

        // Verifying go to last page
        listingPage.verifyPaginationEnd();
        listingPage.clickPaginationEnd();
        Assert.assertEquals(listingPage.getCurrentPage(),listingPage.getTotalPages(),"Not working forward");

        // Verifying go to the first page
        listingPage.verifyPaginationStart();
        listingPage.clickPaginationStart();
        Assert.assertEquals(listingPage.getCurrentPage(),prop.getProperty("PAGE_NO_1"),"Not working backward");
    }

    @Description("Verify the Add Employee button functionality")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Regression"})
    public void verifyAddEmployeeButton() {
        logger.info("#### Running verifyAddEmployeeButton method  ####");
        listingPage.clickAddEmployeeButton();
        Assert.assertTrue(listingPage.AddEmployeePopUp_IsDisplayed(),"Add Employee is not displayed");
    }
}
