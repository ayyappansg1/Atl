package pages.benefitsModule;

import com.github.javafaker.Faker;
import helper.LocalHelper;
import objectRepo.benefitsRepo.PlanDetails_Repo;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlanDetailsBenefits extends PlanDetails_Repo {
    protected static final Logger logger = LoggerFactory.getLogger(PlanDetailsBenefits.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;
    public PlanDetailsBenefits(WebDriver driver) {
        this.driver = driver;
    }
    public void enterPlanName(String value) {localHelper.sendKeys(planName_txt, value, driver);}
    public void enterProviderUrl(String value) {localHelper.sendKeys(providerUrl, value, driver);}
    public void enterPlanStartDate(String value) {
        localHelper.dropDownSelectByText(planStartDate_txt, value, driver);
    }
    public void enterPlanEndDate(String value) {
        localHelper.dropDownSelectByText(planEndDate_txt, value, driver);
    }
    public void enterPlanEffectiveDate(String value) {
        localHelper.scrollIntoView(planEffectiveDate_txt, driver);
        localHelper.dropDownSelectByText(planEffectiveDate_txt, value, driver);
    }
    public void enterServiceFeeCurrency(String value) {
        localHelper.scrollIntoView(serviceFeeCurrency_txt, driver);
        localHelper.dropDownSelectByText(serviceFeeCurrency_txt, value, driver);
    }
    public void enterServiceFeeAmount(String value) {
        localHelper.scrollIntoView(serviceFeeAmount_txt, driver);
        localHelper.dropDownSelectByText(serviceFeeAmount_txt, value, driver);
    }
    public void enterInternalUseComments(String value) {
        localHelper.scrollIntoView(customersComment_txt, driver);
        localHelper.sendKeys(internalUseComment_txt, value, driver);
    }
    public void enterCustomersComments(String value) {
        localHelper.scrollIntoView(customersComment_txt, driver);
        localHelper.sendKeys(customersComment_txt, value, driver);
    }

    public void clickSavePlanDetails() {
        localHelper.scrollIntoView(savePlanDetailsButton, driver);
        localHelper.clickElement(savePlanDetailsButton, driver);
    }

    public void createNewPlan() {
        Faker faker = new Faker();
        enterPlanName(faker.name().lastName());
    }
}
