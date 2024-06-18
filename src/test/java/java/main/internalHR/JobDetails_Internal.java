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
import pages.common.AddEmployee_Page;
import pages.common.JobDetails_Page;
import pages.common.LoginPage;
import pages.common.Profile_Page;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class JobDetails_Internal extends BaseTest {

    Properties prop = new TestUtil().init_Properties("common/URL");
    JobDetails_Page jobDetailsPage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        jobDetailsPage = new JobDetails_Page(driver);
        new LoginPage(driver).loginAs("INTERNAL HR");
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickAddEmployeeButton();
        new AddEmployee_Page(driver).createEmployee("INTERNAL HR");
        new Profile_Page(driver).navigateToJobDetails("INTERNAL HR");
        new Profile_Page(driver).clickNextButton("INTERNAL HR");
    }

    @Description("Verify the navigation to next page from Job details page after filling the fields")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void navigateToBankingStepper() {
        Properties prop1 = new TestUtil().init_Properties("employeeView/Employee");
        logger.info("### Running navigateToBankingStepper method ###");

        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

        jobDetailsPage.verifyJobDetailStepper();
        String employeeId=new Profile_Page(driver).getEmployee_ID();


        //Employment Details section
        jobDetailsPage.enterTargetStartDate(sdf.format(faker.date().past(10, TimeUnit.DAYS)));
        jobDetailsPage.selectEmploymentType();
        jobDetailsPage.enterAtlasStartDate(sdf.format(faker.date().past(20,TimeUnit.DAYS)));
        jobDetailsPage.enterSeniorityDate(sdf.format(faker.date().past(30,TimeUnit.DAYS)));
        jobDetailsPage.enterJobTitle(faker.job().position());
        jobDetailsPage.enterWorkingHours(String.valueOf(faker.number().randomDigitNotZero()));
        jobDetailsPage.selectManagerName(null);

        //Probation Period
        jobDetailsPage.selectProbation();

        //Compensation
        jobDetailsPage.enterLPPID(faker.numerify("####"));
        jobDetailsPage.selectPayGroup();
        jobDetailsPage.enterCompensationAmount(faker.number().digits(3));
       // jobDetailsPage.enterCompensationStatutoryInstallments(faker.number().digits(2));
        jobDetailsPage.selectFrequency();
       /* if(faker.bool().bool()){
            jobDetailsPage.clickAdditionalPaymentCheckbox();
            jobDetailsPage.enterAdditionalPayment(faker.number().digits(3));
        }*/
//      jobDetailsPage.selectOvertimeApplicable();
       // jobDetailsPage.selectFrequency();
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
//        jobDetailsPage.selectNonCompete(faker.bool().bool());
       // jobDetailsPage.selectCollectiveAgreement(faker.bool().bool());

        // Click the next button
        jobDetailsPage.clickingNextButton();

        new LocalHelper().waitForPageURL(prop.getProperty("BANKING_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("BANKING_PAGE_URL")+employeeId,driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
        logger.info("Bank Stepper URL is Verified");
    }
}
