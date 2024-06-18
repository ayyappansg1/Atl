package main.internalHR;

import common.BaseTest;
import common.TestUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.ListingPage;
import pages.common.*;
import pages.common.Documents_Page;
import java.util.Properties;

public class Finish_Internal extends BaseTest {

    Properties prop = new TestUtil().init_Properties("common/CommonProp");
    Finish_Page finish_page;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        finish_page = new Finish_Page(driver);
        new LoginPage(driver).loginAs("INTERNAL HR");
        new ListingPage(driver).switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickAddEmployeeButton();
        new AddEmployee_Page(driver).createEmployee("INTERNAL HR");
        new Profile_Page(driver).navigateToJobDetails("INTERNAL HR");
        new Profile_Page(driver).clickNextButton("INTERNAL HR");
        new JobDetails_Page(driver).navigateToNextPage("INTERNAL HR");
        new Banking_Page(driver).clickNextButton();
        new Documents_Page(driver).navigateToSubmitPage("INTERNAL HR");
      //  new Benefits_Page(driver).clickNextButton("INTERNAL HR");
        new Compensation_Page(driver).clickNextButton();
        new TimeOff_Page(driver).clickNextButton();
    }

    @Description("Verify profile complete message after clicking invite send button")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void verifyProfileCompleteMessage() {
        logger.info("### Running verifyProfileCompleteMessage method ###");

        finish_page.clickInviteEmployeeToOnboardButton();

        // Verify profile complete message
        Assert.assertEquals(finish_page.getProfileCompleteMessage(),prop.getProperty("PROFILE_COMPLETE_MSG"),"Mismatch found in the message");

    }
}