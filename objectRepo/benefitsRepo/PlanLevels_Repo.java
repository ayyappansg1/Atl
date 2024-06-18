package objectRepo.benefitsRepo;

import org.openqa.selenium.By;

public class PlanLevels_Repo {
    public By medicalPlan = By.xpath("//div[1]/span[@class='table__row__data'][1]");
    public By levelsSubmitButton = By.xpath("//button[@data-testid='levels-submit-btn']");
    public By inputErrorButton = By.xpath("//button[@data-testid='input-error']");
    public By planLevelNameMandatoryError = By.xpath("//span[@class='error']");
    public By planLevelName_txt = By.xpath("//input[@name='planLevels.0.planLevelName']");
    public By providerUrl_txt = By.xpath("//input[@name='planLevels.0.providerUrl']");
    public By planLevelNameValidationErrorMessage = By.xpath("//span[@class='error'][contains(text(), 'Invalid input. Special characters detected')]");
    public By PlanUrlNameValidationErrorMessage = By.xpath("//span[@class='error'][contains(text(), 'Please enter valid URL')]");

}
