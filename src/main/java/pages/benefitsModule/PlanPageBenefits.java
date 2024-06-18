package pages.benefitsModule;

import helper.LocalHelper;
import objectRepo.benefitsRepo.addPlanPage_Repo;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlanPageBenefits extends addPlanPage_Repo {

    protected static final Logger logger = LoggerFactory.getLogger(PlanPageBenefits.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;
    public PlanPageBenefits(WebDriver driver) {this.driver = driver;}

    public boolean planNameField_IsPresent() {return localHelper.verifyEnabledElement(planName_txt, driver);}
    public boolean planStartDateField_IsPresent() {return localHelper.verifyEnabledElement(planStartDate_txt, driver);}
    public boolean effectiveDate_IsPresent() {return localHelper.verifyEnabledElement(effectiveDate_txt, driver);}
    public void tabThroughField() throws InterruptedException {
        localHelper.pressTabKey(planName_txt, driver);
    }
    public String getPlanNameMandatoryErrorMessage() {return localHelper.getText(planNameMandatoryErrorMessage, driver);}
    public void detailsSubmit() {
        localHelper.scrollIntoView(detailsSubmitButton, driver);
        localHelper.clickElement(detailsSubmitButton, driver);
    }
    public void inputErrorSubmit() {
        localHelper.scrollIntoView(inputErrorOkButton, driver);
        localHelper.clickElement(inputErrorOkButton, driver);
    }
    public String getPlanStartDateValidationErrorMessage() {return localHelper.getText(planStartDateValidationErrorMessage, driver);}
    public String getEffectiveDateErrorMessage() {return localHelper.getText(effectiveDateValidationErrorMessage, driver);}
    public void enterPlanName(String value) {localHelper.sendKeys(planName_txt, value, driver);}
    public void enterProviderUrl(String value) {localHelper.sendKeys(providerUrl_txt, value, driver);}
    public String getPlanNameValidationErrorMessage() {return localHelper.getText(planNameValidationErrorMessage, driver);}
    public String getProviderUrlValidationErrorMessage() {return localHelper.getText(providerUrlValidationErrorMessage, driver);}


}
