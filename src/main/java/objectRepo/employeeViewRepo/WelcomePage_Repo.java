package objectRepo.employeeViewRepo;

import org.openqa.selenium.By;

public class WelcomePage_Repo {

    public By profile_icon = By.xpath("//button[@class='user-profile-img-button']");
    public By viewProfile_btn = By.xpath("//button[@class='profile-option']/p[contains(text(),'View Profile')]");

    public By completeOnboarding_btn = By.xpath("//button[@class='a-button primary-blue medium complete-onboard-btn']");
    public By getStarted_btn = By.xpath("//button[@class='a-button primary-blue medium'][@data-testid='navigate-btn']");

    public By welcomeBack_Text = By.xpath("//div[@class='title-1']");

}
