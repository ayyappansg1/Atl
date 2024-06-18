package objectRepo.employeeViewRepo;

import org.openqa.selenium.By;

public class Emergency_Repo {

    public By emergencyFirstName_txt = By.xpath("//input[@name='emergencyFirstName']");
    public By emergencyLastName_txt = By.xpath("//input[@name='emergencyLastName']");
    public By relationship_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Relationship')]/following-sibling::span/input");
    public By mobile_code_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Mobile')]/following-sibling::span/input");

    public By homePhone_txt  = By.xpath("//input[@data-testId='home']");
    public By mobile_txt  = By.xpath("//input[@name='mobile']");
    public By workPhone_txt  = By.xpath("//input[@name='workPhone']");
    public By email_txt = By.xpath("//input[@name='email']");

    public By country_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Country')]/following-sibling::span/input");
    public By state_txt = By.xpath("//input[@name='state']");
    public By addressLine1_txt = By.xpath("//input[@name='street1']");
    public By addressLine2_txt = By.xpath("//input[@name='street2']");
    public By city_txt = By.xpath("//input[@name='city']");
    public By postalCode_txt = By.xpath("//input[@name='postalCode']");

    public By previous_btn = By.xpath("//button[@class='a-button primary-blue medium']/span[contains(text(),'Previous')]");
    public By save_btn = By.xpath("//button[@class='a-button secondary-btn small button-save']/span[contains(text(),'Save')]");
    public By next_btn = By.xpath("//button[@data-testId='next-emergency']");

    // Predictive search dropdown
    public By dropdown_Values = By.xpath("//ul[@class='option-list']/li");
    public By atlas_Loader = By.xpath("//div[@class='loaderContainer']");


}
