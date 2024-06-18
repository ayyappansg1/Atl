package objectRepo.commonRepo;

import org.openqa.selenium.By;

public class SetUpRepo {

    // By locators
    public By atlasLoginEmail_txt = By.xpath("//input[@name='email']");
    public By atlasLoginPswd_txt = By.xpath("//input[@name='password']");
    public By atlasLogin_btn = By.xpath("//button[@class='a-button primary-blue large']");
    public By people_tab = By.xpath("//span[contains(text(), 'People')]");
    public By goToDashboard_btn = By.xpath("//button[@data-testid='login-btn']");
}
