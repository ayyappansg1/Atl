package main.postOnboarding.internalHR;

import common.BaseTest;
import common.TestUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.ListingPage;
import pages.common.LoginPage;
import pages.postOnboarding.JobDetails_PostOnboarding;
import pages.postOnboarding.Profile_PostOnboarding;

import java.io.IOException;
import java.text.ParseException;
import java.util.Properties;

public class JobDetails_PostOnboardingInternal extends BaseTest {

    JobDetails_PostOnboarding jobDetails_postOnboarding;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException, IOException, ParseException {
        TestUtil testUtil=new TestUtil();
        Properties prop = testUtil.init_Properties("restAssured/Base");
        jobDetails_postOnboarding = new JobDetails_PostOnboarding(driver);
        new LoginPage(driver).loginAs("INTERNAL HR");
        new ListingPage(driver).switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickClearFilter();
        new ListingPage(driver).selectActiveStatus();
        new ListingPage(driver).performSearchBy(prop.getProperty("EMPLOYEE_ID"));
        new ListingPage(driver).clickFirstEmployee(prop.getProperty("EMPLOYEE_ID"));
        jsonPathEvaluator = new Profile_PostOnboarding(driver).getResponse(baseURI,prop.getProperty("EMPLOYEE_ID")).jsonPath();
        new Profile_PostOnboarding(driver).clickJobDetailsStepper();
    }

    @Description("Verify the Active employee Job detail stepper values")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void verifyJobDetailStepper() {
        logger.info("### Running verifyJobDetailStepper method ###");

        //Assert.assertEquals(jobDetails_postOnboarding.getSeniorityDate(), jobDetails_postOnboarding.dateTimeFormatter(jsonPathEvaluator.get("jobDetails.seniorityDate")));
        Assert.assertEquals(jobDetails_postOnboarding.getEmploymentTypeField(),jsonPathEvaluator.getInt("jobDetails.employmentType"));
        Assert.assertEquals(jobDetails_postOnboarding.getEmploymentTermField(),jsonPathEvaluator.getInt("jobDetails.employmentTerm"), "Mismatch found in the employmentTerm");
        Assert.assertEquals(jobDetails_postOnboarding.getTermEndDate(), jobDetails_postOnboarding.dateTimeFormatter(jsonPathEvaluator.get("jobDetails.termEndDate")));
        Assert.assertEquals(jobDetails_postOnboarding.getProbationPeriod(), jsonPathEvaluator.getInt("jobDetails.probationPeriod"));
        Assert.assertEquals(jobDetails_postOnboarding.getProbationPeriodType(), jsonPathEvaluator.getInt("jobDetails.probationPeriodType"));

        Assert.assertEquals(jobDetails_postOnboarding.getEmployerNoticePeriod(), jsonPathEvaluator.getInt("jobDetails.employerNoticePeriod"));
        Assert.assertEquals(jobDetails_postOnboarding.getEmployeeNoticePeriod(), jsonPathEvaluator.getInt("jobDetails.employeeNoticePeriod"));
        Assert.assertEquals(jobDetails_postOnboarding.getRetirementAge(), jsonPathEvaluator.getInt("jobDetails.retirementAge"));
    }

}
