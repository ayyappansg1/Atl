package objectRepo.commonRepo;

import org.openqa.selenium.By;

public class BankingPage_Repo {
    public By Scroll_Start = By.xpath("//span[text()='Bank Country']");
    public By bank_country = By.xpath("(//input[@id='input-text'])[1]");
    public By ibanNumber = By.xpath("//input[@data-testid='accountNumber']");
    public By warningButton = By.xpath("//button[contains(@class,'missing-got-it')]");

    public By iachNumber = By.xpath("//input[@data-testid='accountNumber']");
    public By localRoutingCode = By.xpath("//input[@data-testid='routingCode']");


    public By accountHolder_name = By.xpath("//input[@data-testid='acholder']");
    public By work_Phone1 = By.xpath("(//input[@class='input-box'])[2]");
    public By work_Phone2 = By.xpath("(//input[@class='input-box'])[3]");
    public By check_box = By.xpath("//input[@type='checkbox']");
    public By state_txt= By.xpath("//input[@data-testId='state']");
    public By addressLine1_txt= By.xpath("//input[@data-testId='address1']");
    public By addressLine2_txt= By.xpath("//input[@data-testId='address2']");
    public By city_txt= By.xpath("//input[@data-testId='city']");
    public By postalCode_txt= By.xpath("//input[@data-testId='postalCode']");
    public By bank_Name = By.xpath("//input[@data-testid='mainBankName']");
    public By bank_account_number = By.xpath("//input[@data-testid='accountNumber']");
    public By dropdown_Values = By.xpath("//ul[@class='option-list']/li");
    public By Banking_Stepper = By.xpath("//div[@data-testId='progress-step-3']/span[2]");
    public By Finish_Stepper = By.xpath("(//div[@data-testId='progress-step-8']/span[2]");
    public By atlas_Loader = By.xpath("//div[@class='loaderContainer']");

    public By next_btn = By.xpath("//button[@data-testId='next-bank']");
    public By saveAndContinue_btn = By.xpath("//button[@data-testId='save-bank']");


}
