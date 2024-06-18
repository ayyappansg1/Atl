package objectRepo.benefitsRepo;

import org.openqa.selenium.By;

public class addPlanPage_Repo {

    //By locators
    public By planName_txt = By.xpath("//input[@name='name']");
    public By planStartDate_txt = By.xpath("//input[@name='startDate']");
    public By effectiveDate_txt = By.xpath("//input[@name='fees.0.effectiveDate']");
    public By planNameMandatoryErrorMessage = By.xpath("//span[@class='error'][contains(text(), 'This field cannot be left empty')]");
    public By planNameValidationErrorMessage = By.xpath("//span[@class='error'][contains(text(), 'Invalid input. Special characters detected')]");
    public By detailsSubmitButton = By.xpath("//button[@data-testId='submit-btn']");
    public By planStartDateValidationErrorMessage = By.xpath("//div[@class='grid-column-3 date-fields profile-form-gutter']/div/span[@class='error']");
    public By inputErrorOkButton = By.xpath("//button[@data-testId='input-error-modal-ok-btn']");
    public By effectiveDateValidationErrorMessage = By.xpath("//div[@class='mb-3']/span[@class='error']");
    public By providerUrl_txt = By.xpath("//input[@name='providerUrl']");
    public By providerUrlValidationErrorMessage = By.xpath("//span[@class='error'][contains(text(), 'Invalid URL')]");
}
