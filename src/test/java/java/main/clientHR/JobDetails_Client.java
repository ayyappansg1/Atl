package main.clientHR;

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
import pages.common.AddEmployee_Page;
import pages.common.JobDetails_Page;
import pages.common.LoginPage;
import pages.common.Profile_Page;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class JobDetails_Client extends BaseTest {

    Properties prop = new TestUtil().init_Properties("common/URL");
    JobDetails_Page jobDetailsPage;
    Profile_Page profilePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        jobDetailsPage = new JobDetails_Page(driver);
        profilePage = new Profile_Page(driver);

        new LoginPage(driver).loginAs("CLIENT HR");
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickAddEmployeeButton();
        new ListingPage(driver).clickAddSingleEmployeeOption();
        new AddEmployee_Page(driver).createEmployee("CLIENT HR");
        profilePage.navigateToJobDetails("CLIENT HR");
        profilePage.clickNextButton("CLIENT HR");
    }

    @Description("Verify the navigation to next page from Job details page after filling the fields")
    @Owner("nayana.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void navigateToNextPageFromJobDetails() {
        Properties prop1 = new TestUtil().init_Properties("employeeView/Employee");
        logger.info("### Running navigateToNextPageFromJobDetails method ###");

        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

        jobDetailsPage.verifyJobDetailStepper();
        String employeeId=profilePage.getEmployee_ID();

        //Employment Details section
        jobDetailsPage.enterTargetStartDate(sdf.format(faker.date().past(30,TimeUnit.DAYS)));
        jobDetailsPage.enterSeniorityDate(sdf.format(faker.date().past(30,TimeUnit.DAYS)));
        jobDetailsPage.enterJobTitle(faker.job().position());
        jobDetailsPage.selectEmploymentType();
        jobDetailsPage.enterWorkingHours(String.valueOf(faker.number().randomDigitNotZero()));
        // jobDetailsPage.selectEmploymentTerm(); As default indefinite
        jobDetailsPage.selectManagerName(null);
        jobDetailsPage.enterJobDescription(faker.lorem().paragraph());

        //Probation Period
        jobDetailsPage.selectProbation();

        //Compensation
        jobDetailsPage.enterCompensationAmount(faker.number().digits(3));
        //jobDetailsPage.enterCompensationStatutoryInstallments(faker.number().digits(2));
        jobDetailsPage.selectFrequency();
      /*  if(faker.bool().bool()){
            jobDetailsPage.clickAdditionalPaymentCheckbox();
            jobDetailsPage.enterAdditionalPayment(faker.number().digits(3));
        }*/

        //Work Location
        jobDetailsPage.enterState(faker.address().state());
        jobDetailsPage.enterAddressLine1(faker.address().streetAddress());
        jobDetailsPage.enterAddressLine2(faker.address().streetName());
        jobDetailsPage.enterCity(faker.address().city());
        jobDetailsPage.enterPostalCode(faker.address().zipCode());

        //Off-boarding Details
        jobDetailsPage.enterEmployerNumberOfDaysWeeksMonths(faker.number().digit());
        jobDetailsPage.selectEmployerNoticePeriodUnit_dropdown();
        jobDetailsPage.enterEmployeeNumberOfDaysWeeksMonths(faker.number().digit());
        jobDetailsPage.selectEmployeeNoticePeriodUnit_dropdown();

        //Retirement Details
        jobDetailsPage.enterRetirementAge(faker.numerify("##"));
      //  jobDetailsPage.selectNonCompete(faker.bool().bool());

        // Click the next button
        jobDetailsPage.clickNextButton("CLIENT HR");
        jobDetailsPage.verifySubmitStepper();
        // Verify the URL
        new LocalHelper().waitForPageURL(prop.getProperty("Finish_PAGE_URL_CLIENT"),driver);
        Assert.assertEquals(appURL+prop.getProperty("Finish_PAGE_URL_CLIENT")+employeeId,driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }
}
