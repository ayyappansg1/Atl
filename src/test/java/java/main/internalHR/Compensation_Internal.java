package main.internalHR;

import com.github.javafaker.Faker;
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

import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Compensation_Internal extends BaseTest {

    Properties prop = new TestUtil().init_Properties("common/URL");
    Compensation_Page compensation_page;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        compensation_page = new Compensation_Page(driver);

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

    @Description("Verify Compensation Stepper")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Regression"})
    public void navigateToFinishPage() {
        Properties prop1 = new TestUtil().init_Properties("employeeView/Employee");
        logger.info("### Running navigateToFinishPageFromCompensationPage method ###");

        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        compensation_page.verifyCompensationStepper();
        compensation_page.selectPayItem();
        compensation_page.selectFrequency();
        compensation_page.clickAdjustmentCheckbox();
        compensation_page.enterEffectiveDate(sdf.format(faker.date().future(30, TimeUnit.DAYS)));
        compensation_page.enterAmount(faker.number().digits(3));
        compensation_page.clickSavePayItemButton();
        compensation_page.clickNextButton();
        compensation_page.clickNextButton();

        new LocalHelper().waitForPageURL(prop.getProperty("FINISH_PAGE_URL_INTERNAL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("FINISH_PAGE_URL_INTERNAL")+prop1.getProperty("EMPLOYEE_ID"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }
}
