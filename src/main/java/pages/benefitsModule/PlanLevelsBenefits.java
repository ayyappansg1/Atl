package pages.benefitsModule;

import helper.LocalHelper;
import objectRepo.benefitsRepo.PlanLevels_Repo;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlanLevelsBenefits extends PlanLevels_Repo {
    protected static final Logger logger = LoggerFactory.getLogger(PlanDetailsBenefits.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;
    public PlanLevelsBenefits(WebDriver driver) {
        this.driver = driver;
    }
    public void openMedicalPlan() {localHelper.clickElement(medicalPlan, driver);}

    public void detailsSubmit() {
        localHelper.scrollIntoView(levelsSubmitButton, driver);
        localHelper.clickElement(levelsSubmitButton, driver);
    }
    public void addressInputError() {localHelper.clickElement(inputErrorButton, driver);}
    public String getPlanLevelNameMandatoryErrorMessage() {
        return localHelper.getText(planLevelNameMandatoryError, driver);
    }

    public void enterPlanLevelName(String value) {localHelper.sendKeys(planLevelName_txt, value, driver);}
    public void enterProviderUrl(String value) {localHelper.sendKeys(providerUrl_txt, value, driver);}
    public String getPlanLevelNameValidationErrorMessage() {
        return localHelper.getText(planLevelNameValidationErrorMessage, driver);
    }
    public String getPlanUrlNameValidationErrorMessage() {
        return localHelper.getText(PlanUrlNameValidationErrorMessage, driver);
    }

}
