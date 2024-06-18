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

public class Documents_Internal extends BaseTest {

    Properties prop = new TestUtil().init_Properties("common/URL");
    Documents_Page documents_page;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        documents_page = new Documents_Page(driver);
        new LoginPage(driver).loginAs("INTERNAL HR");
        new ListingPage(driver).switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickAddEmployeeButton();
        new AddEmployee_Page(driver).createEmployee("INTERNAL HR");
        new Profile_Page(driver).navigateToJobDetails("INTERNAL HR");
        new Profile_Page(driver).clickNextButton("INTERNAL HR");
        new JobDetails_Page(driver).navigateToNextPage("INTERNAL HR");
        new Banking_Page(driver).clickNextButton();
    }

    @Description("Verify the navigation to finish page from banking page after filling the fields")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void navigateToCompensationPage() {
        Properties prop1 = new TestUtil().init_Properties("employeeView/Employee");
        logger.info("### Running navigateToFinishPageFromDocumentsPage method ###");

        documents_page.selectCountryProject();
     //   documents_page.selectCountryTemplate(null);
        documents_page.clickConfirmTemplateSelectionButton();
        documents_page.clickTaskCheckbox();
       // documents_page.clickOkPopup();

        documents_page.clickNextButton("INTERNAL HR");
        new LocalHelper().waitForPageURL(prop.getProperty("COMPENSATION_PAGE_URL_INTERNAL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("COMPENSATION_PAGE_URL_INTERNAL")+prop1.getProperty("EMPLOYEE_ID"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }
}
