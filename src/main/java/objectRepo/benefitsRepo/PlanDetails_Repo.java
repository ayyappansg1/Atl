package objectRepo.benefitsRepo;

import org.openqa.selenium.By;

public class PlanDetails_Repo {

    public By planName_txt = By.xpath("//input[@name='name']");
    public By providerUrl = By.xpath("//input[@name='providerUrl']");
    public By planStartDate_txt = By.xpath("//input[@name='startDate']");
    public By planEndDate_txt = By.xpath("//input[@name='endDate']");
    public By planEffectiveDate_txt = By.xpath("//input[@name='fees.0.effectiveDate']");
    public By serviceFeeCurrency_txt = By.xpath("//div[@class='benefit-container']//div//div[3]//div[1]//div[2]");
    public By serviceFeeAmount_txt = By.xpath("//input[@name='fees.0.feesList.0.amount']");
    public By internalUseComment_txt = By.xpath("//textarea[@name='internalComments']");
    public By customersComment_txt = By.xpath("//textarea[@name='customerComments']");
//    public By employeesComment_txt = By.xpath("//textarea[@name='employeeComments']");
    public By savePlanDetailsButton = By.xpath("//button[@data-testId='submit-btn']");
    public By mandatoryErrorMessage_modal = By.xpath("//button[@data-testId='input-error-modal-ok-btn']/span");

}
