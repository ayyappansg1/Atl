package main.internalHR;

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

public class Benefits_Internal extends BaseTest {

    Properties prop = new TestUtil().init_Properties("common/URL");
    Benefits_Page benefits_page;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        benefits_page = new Benefits_Page(driver);
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
    }

    @Description("Verify navigate to compensation page from benefits page")
    @Owner("nayana.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void navigateToCompensationPage()  {
        logger.info("### Running navigateToCompensationPage method ###");

       // benefits_page.clickNextButton("INTERNAL HR");
        new LocalHelper().waitForPageURL(prop.getProperty("COMPENSATION_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("COMPENSATION_PAGE_URL")+prop.getProperty("EMPLOYEE_ID"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }
}
