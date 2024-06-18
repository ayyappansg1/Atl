package pages.employeeView;

import com.github.javafaker.Faker;
import common.TestUtil;
import helper.LocalHelper;
import objectRepo.employeeViewRepo.Emergency_Repo;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class EmergencyStepper extends Emergency_Repo {
    protected static final Logger logger = LoggerFactory.getLogger(EmergencyStepper.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;
    Properties prop = new TestUtil().init_Properties("employeeView/Employee");

    String getRandomValue;
    public EmergencyStepper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean emergencyFirstNameIsPresent(){ return localHelper.verifyEnabledElement(emergencyFirstName_txt,driver);     }
    public boolean emergencyLastNameIsPresent(){ return localHelper.verifyEnabledElement(emergencyLastName_txt,driver); }
    public boolean relationshipDropDownIsPresent(){ return localHelper.verifyEnabledElement(relationship_dropdown,driver); }
    public boolean homePhoneIsPresent(){ return localHelper.verifyEnabledElement(homePhone_txt,driver); }
    public boolean mobileIsPresent(){ return localHelper.verifyEnabledElement(mobile_txt,driver); }
    public boolean workPhoneIsPresent(){ return localHelper.verifyEnabledElement(workPhone_txt,driver); }
    public boolean countryDropDownIsPresent(){ return localHelper.verifyEnabledElement(country_dropdown,driver); }
    public boolean stateIsPresent(){ return localHelper.verifyEnabledElement(state_txt,driver); }
    public boolean addressLine1IsPresent(){ return localHelper.verifyEnabledElement(addressLine1_txt,driver); }
    public boolean addressLine2IsPresent(){ return localHelper.verifyEnabledElement(addressLine2_txt,driver); }
    public boolean cityIsPresent(){ return localHelper.verifyEnabledElement(city_txt,driver); }
    public boolean postalCodeIsPresent(){ return localHelper.verifyEnabledElement(postalCode_txt,driver); }

    public void enterEmergencyFirstName(String text){ localHelper.sendKeys(emergencyFirstName_txt,text,driver);}
    public void enterEmergencyLastName(String text){ localHelper.sendKeys(emergencyLastName_txt,text,driver);}

    public void selectRelationshipFromDropdown() {
        try {
            localHelper.scrollIntoView(relationship_dropdown, driver);
            localHelper.clickElement(relationship_dropdown, driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values, driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(relationship_dropdown, getRandomValue, driver);
            localHelper.clickElement(dropdown_Values, driver);
        }catch (TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(relationship_dropdown, driver);
            localHelper.clickElement(relationship_dropdown, driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values, driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(relationship_dropdown, getRandomValue, driver);
            localHelper.clickElement(dropdown_Values, driver);
        }
    }

    public void enterHomePhone(String text){ localHelper.sendKeys(homePhone_txt,text,driver);}
    public void enterMobile(String text){ localHelper.sendKeys(mobile_txt,text,driver);}
    public void enterWorkPhone(String text){ localHelper.sendKeys(workPhone_txt,text,driver);}
    public void enterEmail(String text){ localHelper.sendKeys(email_txt,text,driver);}

    public void selectCountryFromDropdown() {
        try {
            localHelper.scrollIntoView(postalCode_txt,driver);
            localHelper.clickElement(country_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(country_dropdown, getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }catch (TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(country_dropdown,driver);
            localHelper.clickElement(country_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(country_dropdown, getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }
    }
    public void enterMobileCode() {
        try {
            localHelper.scrollIntoView(mobile_code_dropdown, driver);
            localHelper.clickElement(mobile_code_dropdown, driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values, driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(mobile_code_dropdown, getRandomValue, driver);
            localHelper.clickElement(dropdown_Values, driver);
        }catch (TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(mobile_code_dropdown, driver);
            localHelper.clickElement(mobile_code_dropdown, driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values, driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(mobile_code_dropdown, getRandomValue, driver);
            localHelper.clickElement(dropdown_Values, driver);
        }
    }

    public void enterState(String text){ localHelper.sendKeys(state_txt,text,driver);}
    public void enterAddressLine1(String text){ localHelper.sendKeys(addressLine1_txt,text,driver);}
    public void enterCity(String text){ localHelper.sendKeys(city_txt,text,driver);}
    public void enterPostalCode(String text){ localHelper.sendKeys(postalCode_txt,text,driver);}


    public void clickNextButton() {
        if(driver.getCurrentUrl().contains(prop.getProperty("EMERGENCY_PAGE_URL"))) {
            localHelper.jsExecutorClick(next_btn, driver);
        }
    }

    public void navigateToDocumentsStepper()  {
        Faker faker = new Faker();
        logger.info("#### Running navigateToDocumentsStepper method ####");
        EmergencyStepper emergencyStepper=new EmergencyStepper(driver);
        emergencyStepper.enterEmergencyFirstName(faker.name().firstName());
        emergencyStepper.enterEmergencyLastName(faker.name().lastName());
        emergencyStepper.selectRelationshipFromDropdown();

        // emergencyStepper.enterHomePhone(faker.numerify("#######"));
        emergencyStepper.enterMobileCode();
        emergencyStepper.enterMobile(faker.numerify("#########"));
        //emergencyStepper.enterWorkPhone(faker.numerify("#######"));

        emergencyStepper.enterEmail(faker.internet().emailAddress());

        /*emergencyStepper.selectCountryFromDropdown();
        emergencyStepper.enterState(faker.address().state());
        emergencyStepper.enterAddressLine1(faker.address().streetAddress());
        emergencyStepper.enterCity(faker.address().city());
        emergencyStepper.enterPostalCode(faker.address().zipCode());*/

        emergencyStepper.clickNextButton();
    }
}
