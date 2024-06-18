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

public class Submit_Client extends BaseTest {

    Properties prop = new TestUtil().init_Properties("common/URL");
    Properties com = new TestUtil().init_Properties("common/CommonProp");
    Finish_Page finish_page;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        finish_page = new Finish_Page(driver);
        new LoginPage(driver).loginAs("CLIENT HR");
       // new ListingPageClientHR(driver).switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickAddEmployeeButton();
        new ListingPage(driver).clickAddSingleEmployeeOption();
        new AddEmployee_Page(driver).createEmployee("CLIENT HR");
        new Profile_Page(driver).navigateToJobDetails("CLIENT HR");
        new Profile_Page(driver).clickNextButton("CLIENT HR");
        new JobDetails_Page(driver).navigateToNextPage("CLIENT HR");
       // new Benefits_Page(driver).clickNextButton("CLIENT HR");
    }

    @Description("Verify the profile submitted message after submitting the profile")
    @Owner("nayana.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void verifyProfileSubmit() {
        logger.info("### Running verifyProfileSubmit method ###");

        finish_page.enterComments(com.getProperty("COMMENTS"));
        finish_page.clickSubmitButton();
        finish_page.submitEmployeeProfile(com.getProperty("SUBMIT_EMPLOYEE"));
        new LocalHelper().waitForPageURL(prop.getProperty("LISTING_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("LISTING_PAGE_URL"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }
}