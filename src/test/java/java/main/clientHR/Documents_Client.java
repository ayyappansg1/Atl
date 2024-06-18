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
import pages.common.Documents_Page;
import java.util.Properties;

public class Documents_Client extends BaseTest {

    Properties prop = new TestUtil().init_Properties("common/URL");
    Documents_Page documents_page;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        documents_page = new Documents_Page(driver);
        new LoginPage(driver).loginAs("CLIENT HR");
       // new ListingPageClientHR(driver).switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickAddEmployeeButton();
        new ListingPage(driver).clickAddSingleEmployeeOption();
        new AddEmployee_Page(driver).createEmployee("CLIENT HR");
        new Profile_Page(driver).navigateToJobDetails("CLIENT HR");
        new Profile_Page(driver).clickNextButton("CLIENT HR");
        new JobDetails_Page(driver).navigateToNextPage("CLIENT HR");
    }

    @Description("Verify the navigation to next page from Job details page after filling the fields")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void navigateToFinishPageFromBenefitsPage() {
        Properties prop1 = new TestUtil().init_Properties("employeeView/Employee");

        logger.info("### Running navigateToFinishPageFromDocumentsPage method ###");

        //new Benefits_Page(driver).clickNextButton("CLIENT HR");
        new LocalHelper().waitForPageURL(prop.getProperty("SUBMIT_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("SUBMIT_PAGE_URL")+prop1.getProperty("EMPLOYEE_ID"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }

}
