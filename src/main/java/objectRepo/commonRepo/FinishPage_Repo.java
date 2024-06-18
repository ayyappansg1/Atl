package objectRepo.commonRepo;

import org.openqa.selenium.By;

public class FinishPage_Repo {

    public By comment_txt = By.xpath("//textarea[@data-testId='finish-text']");
    public By submit_btn = By.xpath("//button[@data-testId='modal-btn']");

    public By yesContinue_btn = By.xpath("//button[@class='a-button btn-alt-button']");
    public By cancel_btn = By.xpath("//button[@data-testId='withdrawModal']");

    public By inviteEmployee_btn = By.xpath("//button[@data-testId='finish-btn']");
    public By profileComplete_msg = By.xpath("//div[@class='done-title d-flex align-items-center']/span");

    // emp view
    public By submitProfile_button = By.xpath("//button[@data-testId='fin-btn']");
    public By changeStatus_button = By.xpath("//button[@data-testid='change-status-btn']");
    public By effectiveDate_datePicker = By.xpath("//input[@name='effectiveStartDate']");
    public By atlasStartDate_datePicker = By.xpath("//input[@name='atlasStartDate']");
    public By newStatus_DropDown = By.xpath("//div[@class='a-dropdown']");
    public By active_status = By.xpath("//span[@data-testid='status-drop-4']");
    public By saveStatusChange_button = By.xpath("//button[@data-testid='update-status-button']");
    public By atlas_Loader = By.xpath("//div[@class='loaderContainer']");

    public By completeMessage=By.xpath("//div[text()='Your profile is being reviewed to finalize your onboarding.']");
}
