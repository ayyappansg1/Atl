package main.clientHR;

import common.BaseTest;
import common.TestUtil;
import helper.LocalHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.ListingPage;
import pages.common.*;
import java.util.Properties;

public class Benefits_Client extends BaseTest {

    Properties prop = new TestUtil().init_Properties("common/URL");
    Benefits_Page benefits_page;

    Profile_Page profilePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        benefits_page = new Benefits_Page(driver);
        profilePage = new Profile_Page(driver);
        new LoginPage(driver).loginAs("CLIENT HR");
        new ListingPage(driver).switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickAddEmployeeButton();
        new ListingPage(driver).clickAddSingleEmployeeOption();
        new AddEmployee_Page(driver).createEmployee("CLIENT HR");
        profilePage.navigateToJobDetails("CLIENT HR");
        profilePage.clickNextButton("CLIENT HR");
        new JobDetails_Page(driver).navigateToNextPage("CLIENT HR");
    }

    @Description("Verify the navigation to listing page from finish page after filling the fields")
    @Owner("nayana.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void navigateToListingPage() {
        logger.info("### Running navigateToListingPage method ###");

        //benefits_page.clickNextButton("CLIENT HR");
        new LocalHelper().waitForPageURL(prop.getProperty("SUBMIT_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("SUBMIT_PAGE_URL")+prop.getProperty("EMPLOYEE_ID"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }
}
