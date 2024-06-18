//package main.benefitsModule;
//
//import common.BaseTest;
//import common.TestUtil;
//import io.qameta.allure.Description;
//import io.qameta.allure.Owner;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pages.benefitsModule.ListingPageBenefits;
//import pages.benefitsModule.PlanDetailsBenefits;
//import pages.benefitsModule.PlanLevelsBenefits;
//import pages.common.LoginPage;
//import java.util.Properties;
//
//public class MedicalPlanLevel extends BaseTest {
//
//    PlanLevelsBenefits planLevelsBenefits;
//    Properties prop = new TestUtil().init_Properties("benefits/PlanLevels");
//    Properties messages = new TestUtil().init_Properties("benefits/CommonMessages");
//
//    @BeforeMethod(alwaysRun = true)
//    public void setUp() throws InterruptedException {
//        planLevelsBenefits = new PlanLevelsBenefits(driver);
//        new LoginPage(driver).loginAs("INTERNAL HR");
//        new ListingPageBenefits(driver).launchBenefits();
//        planLevelsBenefits.openMedicalPlan();
//        new ListingPageBenefits(driver).AddMedical_IsDisplayed();
//        new PlanDetailsBenefits(driver).clickSavePlanDetails();
//    }
//
//    @Description("The test verifies the navigation to the plan levels page")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifyPlanLevelNavigation()  {
//        logger.info("### Running verifyAddNewPlanNavigation method ###");
//        Assert.assertEquals(appURL+prop.getProperty("LEVELS_URL"),driver.getCurrentUrl(),
//                "Mismatch found in URL of the page loaded");
//    }
//
//    @Description("The test verifies the mandatory error messages in the plan levels page")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifyMandatoryFields() {
//        logger.info("### Running verifyMandatoryFields method ###");
//
//        planLevelsBenefits.detailsSubmit();
//        planLevelsBenefits.addressInputError();
//        Assert.assertEquals(planLevelsBenefits.getPlanLevelNameMandatoryErrorMessage(), messages.getProperty("MANDATORY_ERROR_MESSAGE"),
//                "Plan Level Name - Mandatory message is changed or the message is not displayed");
//    }
//
//    @Description("The test verifies the validation error messages in the plan levels page")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Smoke"})
//    public void verifyValidationErrors() {
//        logger.info("### Running verifyValidationErrors method");
//
//        planLevelsBenefits.enterPlanLevelName(prop.getProperty("INVALID_NAME"));
//        planLevelsBenefits.enterProviderUrl(prop.getProperty("INVALID_URL"));
//        planLevelsBenefits.detailsSubmit();
//        planLevelsBenefits.addressInputError();
//        Assert.assertEquals(planLevelsBenefits.getPlanLevelNameValidationErrorMessage(), messages.getProperty("NAME_VALIDATION_ERR_MSG"));
//        Assert.assertEquals(planLevelsBenefits.getPlanUrlNameValidationErrorMessage(), messages.getProperty("URL_ERROR_MESSAGE"));
//
//    }
//
//    @Description("The test verifies the navigation to the coverage page after filling and uploading all details")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Regression"})
//    public void verifyCoveragePageNavigation() {
//        logger.info("### Running verifyCoveragePageNavigation method");
//
//        //Plan Level Details
//        planLevelsBenefits.enterPlanLevelName(prop.getProperty("PLAN_LEVEL_NAME"));
//        planLevelsBenefits.enterProviderUrl(prop.getProperty("PLAN_PROVIDER_URL"));
//    }
//
//}
