package objectRepo.postOnboardingRepo;

import org.openqa.selenium.By;

public class ProfilePage_Repo {

    // By locators -
    public By employeeId = By.xpath("//div[@class='prof-id']/span");
    public By jobTitle = By.xpath("//div[@class='designation']");
    public By contactEmail = By.xpath("//div[@class='contact']");
    public By fullName = By.xpath("//div[@class='name']");

    // By locators - Personal Information
    public By firstName = By.xpath("//input[@name='firstName']");
    public By additionalGivenName = By.xpath("//input[@name='additionalGivenName']");
    public By lastName = By.xpath("//input[@name='lastName']");
    public By preferredName = By.xpath("//input[@name='preferredName']");
    public By birthday = By.xpath("//input[@name='birthday']");
    public By maritalStatus = By.xpath("//div[@class='form-label'][contains(text(),'Marital Status')]/following-sibling::div/div/div/div");
    public By gender = By.xpath("//div[@class='form-label'][contains(text(),'Gender')]/following-sibling::div/div/div/div");
    public By countryOfCitizenship = By.xpath("//div[@class='profile-forms mb-5']/div/div/div/div[@class='form-label'][contains(text(),'Country of Citizenship')]/following-sibling::div/div/div[1]/div[1]");
    public By nationalId = By.xpath("//input[@name='citizenship[0].nationalId']");

    // By locators - Home Address
    public By country = By.xpath("//div[@class='profile-forms profile-form-gutter']/div/div/div[@class='form-label'][contains(text(),'Country')]/following-sibling::div/div/div[1]/div[1]");
    public By street1 = By.xpath("//input[@name='street1']");
    public By street2 = By.xpath("//input[@name='street2']");
    public By city = By.xpath("//input[@name='city']");
    public By postalCode = By.xpath("//input[@name='postalCode']");
    public By state = By.xpath("//input[@name='state']");

    // By locators - Contact Details
    public By workPhone = By.xpath("//input[@name='workPhone']");
    public By mobile = By.xpath("//input[@name='mobile']");
    public By homePhone = By.xpath("//input[@name='homePhone']");
    public By officeEmail = By.xpath("//input[@name='officeEmail']");
    public By homeEmail = By.xpath("//input[@name='homeEmail']");

    // By locators - Social Media Links
    public By linkedinUrl = By.xpath("//input[@name='linkedinUrl']");
    public By website = By.xpath("//input[@name='website']");

    // By locators - Work Experience

    public By jobDetailsStepper = By.xpath("//div[@data-testid='left-panel-2']");


}
