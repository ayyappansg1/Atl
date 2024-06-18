package objectRepo.commonRepo;

import org.openqa.selenium.By;

public class BenefitsPage_Repo {

    public By healthBenefitsYes_RadioBtn = By.xpath("//input[@data-testId='benifits-radio1']");
    public By healthBenefitsNo_RadioBtn = By.xpath("//input[@data-testId='benifits-radio2']");

    public By benefitPlan_dropdown = By.xpath("//div[@class='form-label'][contains(text(),'Benefit Plan')]/following-sibling::div/div/div/div/input");
    public By effectiveDate_input = By.xpath("//div[@class='form-label'][contains(text(),'Effective Date')]/following-sibling::div/div/input");
    public By coverageLevel_dropdown = By.xpath("//div[@class='form-label'][contains(text(),'Coverage Level')]/following-sibling::div/div/div/div/input");

    // Payment Breakdown
    public By employerContribution_input = By.xpath("//div[@class='form-label'][contains(text(),'Employer Contribution')]/following::input[@class='input-box']");
    public By employeeContribution_input = By.xpath("//div[@class='form-label'][contains(text(),'Employee Contribution')]/following::input[@class='input-box']");

    public By save_btn = By.xpath("//button[@data-testId='save-btn']");
    public By next_btn = By.xpath("//button[@data-testId='next-btn']");
}
