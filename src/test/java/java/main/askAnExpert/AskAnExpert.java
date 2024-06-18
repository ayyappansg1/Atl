package main.askAnExpert;

import common.BaseTest;
import common.TestUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.benefitsModule.ListingPageBenefits;
import pages.benefitsModule.PlanPageBenefits;
import pages.common.ListingPage;
import pages.common.LoginPage;

import java.util.Properties;

public class AskAnExpert extends BaseTest{
    PlanPageBenefits planPageBenefits;
    TestUtil testUtil = new TestUtil();
    Properties prop = testUtil.init_Properties("benefits/AddPlan");
    Properties messages = testUtil.init_Properties("benefits/CommonMessages");

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        planPageBenefits = new PlanPageBenefits(driver);
        new LoginPage(driver).loginAs("INTERNAL HR");
        new ListingPage(driver).switchToTravelMateOrganization();
        new ListingPageBenefits(driver).launchBenefits();
        new ListingPageBenefits(driver).clickAddNewPlanButton();
        new ListingPageBenefits(driver).clickAddMedicalOption();
    }

    @Description("The test verifies the navigation to the medical plan page")
    @Owner("ankita.h@thinkpalm.com")
    @Test(enabled = true, groups = {"Smoke"})
    public void verifyAddNewPlanNavigation() throws InterruptedException {
        logger.info("### Running verifyAddNewPlanNavigation method ###");
        Assert.assertTrue(new ListingPageBenefits(driver).AddMedical_IsDisplayed(),
                "Add New Medical Plan is not opened as expected");
    }

    @Description("The test verifies the mandatory error messages")
    @Owner("ankita.h@thinkpalm.com")
    @Test(enabled = true, groups = {"Smoke"})
    public void verifyMandatoryErrorMessages() throws InterruptedException {
        logger.info("### Running verifyMandatoryErrorMessages method ###");

        Assert.assertTrue(planPageBenefits.planNameField_IsPresent(), "Plan/Provider Name field is not present");
        Assert.assertTrue(planPageBenefits.planStartDateField_IsPresent(), "Plan Start Date field is not present");
        Assert.assertTrue(planPageBenefits.effectiveDate_IsPresent(),"Effective Date field is not present");

        planPageBenefits.tabThroughField();
        Assert.assertEquals(planPageBenefits.getPlanNameMandatoryErrorMessage(), messages.getProperty("MANDATORY_ERROR_MESSAGE"),
                "Plan/Provider Name - Mandatory message is changed or the message is not displayed");
        planPageBenefits.detailsSubmit();
        planPageBenefits.inputErrorSubmit();
        Assert.assertEquals(planPageBenefits.getPlanStartDateValidationErrorMessage(), messages.getProperty("MANDATORY_ERROR_MESSAGE"));
        Assert.assertEquals(planPageBenefits.getEffectiveDateErrorMessage(), messages.getProperty("MANDATORY_ERROR_MESSAGE"));

    }

    @Description("Verify the validation error messages")
    @Owner("ankita.h@thinkpalm.com")
    @Test(enabled = true,groups = {"Regression"})
    public void verifyValidationErrorMessages() {
        logger.info("### Running verifyValidationErrorMessages method ###");

        planPageBenefits.enterPlanName(prop.getProperty("INVALID_INPUT"));
        planPageBenefits.enterProviderUrl(prop.getProperty("INVALID_INPUT"));
        Assert.assertEquals(planPageBenefits.getPlanNameValidationErrorMessage(), messages.getProperty("NAME_VALIDATION_ERR_MSG"));
        Assert.assertEquals(planPageBenefits.getProviderUrlValidationErrorMessage(), messages.getProperty("URL_VALIDATION_ERR_MSG"));

    }
}
