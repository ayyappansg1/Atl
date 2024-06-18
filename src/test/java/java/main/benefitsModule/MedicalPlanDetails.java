//package main.benefitsModule;
//
//import com.github.javafaker.Faker;
//import common.BaseTest;
//import common.TestUtil;
//import io.qameta.allure.Description;
//import io.qameta.allure.Owner;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//import pages.benefitsModule.ListingPageBenefits;
//import pages.benefitsModule.PlanDetailsBenefits;
//import pages.common.LoginPage;
//import java.text.SimpleDateFormat;
//import java.util.Properties;
//import java.util.concurrent.TimeUnit;
//
//public class MedicalPlanDetails extends BaseTest {
//    PlanDetailsBenefits planDetailsBenefits;
//    TestUtil testUtil = new TestUtil();
//    Properties prop = testUtil.init_Properties("benefits/PlanDetails");
//
//    @BeforeMethod(alwaysRun = true)
//    public void setUp() throws InterruptedException {
//        planDetailsBenefits = new PlanDetailsBenefits(driver);
//        new LoginPage(driver).loginAs("INTERNAL HR");
//        new ListingPageBenefits(driver).launchBenefits();
//        new ListingPageBenefits(driver).clickAddNewPlanButton();
//        new ListingPageBenefits(driver).clickAddMedicalOption();
//        planDetailsBenefits.createNewPlan();
//    }
//
//    @Description("Verify the navigation to next page from Plan details page after filling the fields")
//    @Owner("ankita.h@thinkpalm.com")
//    @Test(groups = {"Regression"})
//    public void navigateToNextPageFromPlanDetails() {
//        logger.info("### Running navigateToNextPageFromPlanDetails method ###");
//
//        Faker faker = new Faker();
//        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
//
//        //Plan Details section
//        planDetailsBenefits.enterProviderUrl(prop.getProperty("PROVIDER_URL"));
//        planDetailsBenefits.enterPlanStartDate(sdf.format(faker.date().past(10, TimeUnit.DAYS)));
//        planDetailsBenefits.enterPlanEndDate(sdf.format(faker.date().future(30,TimeUnit.DAYS)));
//
//        //Fees section
//        planDetailsBenefits.enterPlanEffectiveDate(sdf.format(faker.date().past(10,TimeUnit.DAYS)));
//        planDetailsBenefits.enterServiceFeeCurrency(prop.getProperty("SERVICE_FEE_CURRENCY"));
//        planDetailsBenefits.enterServiceFeeAmount(prop.getProperty("SERVICE_FEE_AMOUNT"));
//
//        //Comments section
//        planDetailsBenefits.enterInternalUseComments(prop.getProperty("COMMENTS"));
//        planDetailsBenefits.enterCustomersComments(prop.getProperty("COMMENTS"));
//
//        planDetailsBenefits.clickSavePlanDetails();
//        Assert.assertEquals(appURL+prop.getProperty("LEVELS_URL"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
//    }
//
//}
