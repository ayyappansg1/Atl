package objectRepo.commonRepo;

import org.openqa.selenium.By;

public class Compensation_Repo {
    public By payItem_Dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Pay Item')]/following-sibling::span/input");
    public By dropdown_Values = By.xpath("//ul[@class='option-list']/li");
    public By frequency_Dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Frequency')]/following-sibling::span/input");
    public By effective_date = By.xpath("(//input[@class='a-input'])[1]");
    public By amount_btn = By.xpath("//input[@data-testId='amount']");
    public By adjustment_checkbox = By.xpath("//input[@data-testid='is-adjustment-check']");
    public By nontaxable_checkbox = By.xpath("//input[@data-testid='is-not-taxable-check']");
    public By savePayItem_btn = By.xpath("//button[@data-testid='submit-button']");
    public By comments_btn = By.xpath("");
    public By next_btn = By.xpath("//button[@data-testid='next_btn']/span");
    public By compensation_Stepper = By.xpath("//div[@data-testId='progress-step-7']/span[2]");
    public By atlas_Loader = By.xpath("//div[@class='loaderContainer']");
}
