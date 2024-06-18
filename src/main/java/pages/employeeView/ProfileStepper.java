package pages.employeeView;

import com.github.javafaker.Faker;
import common.TestUtil;
import helper.LocalHelper;
import objectRepo.commonRepo.ProfilePage_Repo;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import pages.common.ListingPage;

import java.text.SimpleDateFormat;
import java.util.NoSuchElementException;
import java.util.Properties;

public class ProfileStepper extends ProfilePage_Repo {

    protected static final Logger logger = LoggerFactory.getLogger(ListingPage.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;
    Properties prop = new TestUtil().init_Properties("employeeView/employee");

    String getRandomValue;

    public ProfileStepper(WebDriver driver) {
        this.driver = driver;
    }

    public void getProfileStepper() {
        if(!driver.getCurrentUrl().contains(prop.getProperty("PROFILE_PAGE_URL"))){
           do {
               localHelper.scrollIntoView(prev_btn,driver);
                localHelper.clickElement(prev_btn,driver);
            }while (!driver.getCurrentUrl().contains(prop.getProperty("PROFILE_PAGE_URL")));
        }
    }


    public boolean editButtonIsPresent(){
        return localHelper.verifyEnabledElement(edit_btn,driver);
    }

    // public boolean cancelEditButtonIsPresent(){  return localHelper.verifyEnabledElement(cancelEdit_btn,driver);  }

    public boolean titleDropdownIsPresent(){
        return localHelper.verifyEnabledElement(title_dropdown,driver);
    }
    public boolean firstNameInputIsPresent(){
        return localHelper.verifyEnabledElement(firstName_txt,driver);
    }
    public boolean surNameInputIsPresent(){
        return localHelper.verifyEnabledElement(surname_txt,driver);
    }
    public boolean additionalGivenNameInputIsPresent(){ return localHelper.verifyEnabledElement(additionalName_txt,driver);   }
    public boolean preferredNameInputIsPresent(){
        return localHelper.verifyEnabledElement(preferredName_txt,driver);
    }
    public boolean dateOfBirthInputIsPresent(){
        return localHelper.verifyEnabledElement(dateOfBirth,driver);
    }
    public boolean genderDropdownIsPresent(){ return localHelper.verifyEnabledElement(gender_dropdown,driver);}
    public boolean maritalStatusDropDownIsPresent(){ return localHelper.verifyEnabledElement(maritalStatus_dropdown,driver);}
    public boolean taxIdInputIsPresent(){ return localHelper.verifyEnabledElement(taxId_txt,driver);}

    public boolean countryOfCitizenshipDropdownIsPresent(){ return localHelper.verifyEnabledElement(citizenshipCountry1_dropdown,driver);}
    public boolean nationalIdInputIsPresent(){ return localHelper.verifyEnabledElement(citizenshipID1_txt,driver);}

    public boolean countryOfResidenceDropdownIsPresent(){ return localHelper.verifyEnabledElement(countryOfResidence_dropdown,driver);}
    public boolean stateInputIsPresent(){ return localHelper.verifyEnabledElement(state_txt,driver);}
    public boolean addressLine1InputIsPresent(){ return localHelper.verifyEnabledElement(addressLine1_txt,driver);}
    public boolean addressLine2InputIsPresent(){ return localHelper.verifyEnabledElement(addressLine2_txt,driver);}
    public boolean cityInputIsPresent(){ return localHelper.verifyEnabledElement(city_txt,driver);}
    public boolean postalCodeIsPresent(){ return localHelper.verifyEnabledElement(postalCode_txt,driver);}

    public boolean workPhoneCountryCodeDropdownIsPresent(){ return localHelper.verifyEnabledElement(workPhoneCountryCode_dropdown,driver);}
    public boolean workPhoneNumberInputIsPresent() { return localHelper.verifyEnabledElement(workPhoneNumber_txt,driver); }

    public boolean mobileCountryCodeDropdownIsPresent(){ return localHelper.verifyEnabledElement(mobileCountryCode_dropdown,driver);}
    public boolean mobileNumberInputIsPresent() { return localHelper.verifyEnabledElement(mobileNumber_txt,driver); }

    public boolean homePhoneCountryCodeDropdownIsPresent(){ return localHelper.verifyEnabledElement(homePhoneCountryCode_dropdown,driver);}
    public boolean homePhoneNumberInputIsPresent() { return localHelper.verifyEnabledElement(homePhoneNumber_txt,driver); }

    public boolean workEmailInputIsPresent(){ return localHelper.verifyEnabledElement(workEmail_txt,driver); }
    public boolean personalEmailInputIsPresent() { return localHelper.verifyEnabledElement(personalEmail_txt,driver); }

    public void clickEditButton(){ localHelper.jsExecutorClick(edit_btn,driver);   }

    public void selectTitleFromDropdown() {
        try {
            localHelper.scrollIntoView(additionalName_txt,driver);
            localHelper.clickElement(title_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(title_dropdown, getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }catch (TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(title_dropdown,driver);
            localHelper.clickElement(title_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(title_dropdown, getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }
    }

    public void enterAdditionalGivenName(String text) {
        localHelper.scrollIntoView(additionalName_txt,driver);
        localHelper.jsExecutorSendValue(additionalName_txt,text,driver);
    }

    public void enterPreferredName(String text){
        localHelper.jsExecutorSendValue(preferredName_txt,text,driver);
    }

    public void enterSuffix(String text){
        localHelper.jsExecutorSendValue(suffix_txt,text,driver);
    }

    public void selectDOB(String text) {
        localHelper.scrollIntoView(dateOfBirth,driver);
        localHelper.dropDownSelectByText(dateOfBirth,text,driver);
    }

    public void selectGenderFromDropdown() {
      //  JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("window.scrollBy(0,200)");
        try {
            localHelper.scrollIntoView(gender_text,driver);
            localHelper.simpleSendKeys(gender_dropdown,"female",driver);
           // getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            //localHelper.jsExecutorSendValue(gender_dropdown, getRandomValue,driver);
            localHelper.jsExecutorClick(dropdown_Values,driver);
        }
        catch (ElementNotVisibleException m){
            localHelper.scrollIntoView(gender_text,driver);
            localHelper.sendKeys(gender_dropdown,"female",driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            //localHelper.jsExecutorSendValue(gender_dropdown, getRandomValue,driver);
            localHelper.jsExecutorClick(dropdown_Values,driver);
        }
        catch (ElementNotInteractableException m){
            localHelper.scrollIntoView(gender_text,driver);
            localHelper.sendKeys(gender_dropdown,"female",driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            //localHelper.jsExecutorSendValue(gender_dropdown, getRandomValue,driver);
            localHelper.jsExecutorClick(dropdown_Values,driver);
        }
        catch (TimeoutException e){
            localHelper.scrollIntoView(gender_text,driver);
            localHelper.sendKeys(gender_dropdown,"female",driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            //localHelper.jsExecutorSendValue(gender_dropdown, getRandomValue,driver);
            localHelper.jsExecutorClick(dropdown_Values,driver);
        }
    }

    public void selectMaritalStatusFromDropdown() {
        localHelper.clickElement(maritalStatus_dropdown,driver);
        getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
        localHelper.jsExecutorSendValue(maritalStatus_dropdown,getRandomValue,driver);
        localHelper.clickElement(dropdown_Values,driver);
    }

    public void enterTaxId(String text){ localHelper.jsExecutorSendValue(taxId_txt,text,driver);    }

    public void selectCountryOfCitizenshipFromDropdown() {
    try
    {
        localHelper.scrollIntoView(citizenshipCountry1_dropdown,driver);
        localHelper.clickElement(citizenshipCountry1_dropdown,driver);
        getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
        localHelper.jsExecutorSendValue(citizenshipCountry1_dropdown, getRandomValue,driver);
        localHelper.clickElement(dropdown_Values,driver);
    }
    catch (TimeoutException | ElementNotVisibleException e){
        localHelper.scrollIntoView(citizenshipCountry1_dropdown,driver);
        localHelper.clickElement(citizenshipCountry1_dropdown,driver);
        getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
        localHelper.jsExecutorSendValue(citizenshipCountry1_dropdown, getRandomValue,driver);
        localHelper.clickElement(dropdown_Values,driver);
    }}

    public void enterNationalId(String text){ localHelper.sendKeys(citizenshipID1_txt,text,driver);    }
    public void clickNoButtonInMoreThanOneCitizenship(){ localHelper.jsExecutorClick(moreThanOneCitizenshipNo_radioBtn,driver);}
    public void clickYesButtonInLegallyAuthorized(){ localHelper.jsExecutorClick(legallyAuthorizedYes_radioBtn,driver);}

    public void enterAddressLine1(String text) { localHelper.scrollIntoView(addressLine1_txt,driver);localHelper.jsExecutorSendValue(addressLine1_txt,text,driver);    }
    public void enterCity(String text){ localHelper.jsExecutorSendValue(city_txt,text,driver);    }
    public void enterPostalCode(String value){ localHelper.jsExecutorSendValue(postalCode_txt,value,driver);    }

    public void enterWorkNumber(String value) { localHelper.scrollIntoView(workPhoneNumber_txt,driver);localHelper.jsExecutorSendValue(workPhoneNumber_txt,value,driver);    }
    public void enterHomeNumber(String value){ localHelper.jsExecutorSendValue(homePhoneNumber_txt,value,driver);    }
    public void enterMobileNumber(String value){ localHelper.jsExecutorSendValue(mobileNumber_txt,value,driver);    }
    public void enterWorkEmail(String value){ localHelper.jsExecutorSendValue(workEmail_txt,value,driver); }

    public void clickNextButton() {
        if(driver.getCurrentUrl().contains(prop.getProperty("PROFILE_PAGE_URL"))) {
            localHelper.scrollIntoView(next_btn_emp,driver);
            localHelper.clickElement(next_btn_emp, driver);
        }
    }

    public void navigateToBankingStepper() {

        logger.info("Employee - Profile stepper");
        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

        // Personal Information
        localHelper.verifyEnabledElement(title_dropdown,driver);
        selectTitleFromDropdown();
        //enterAdditionalGivenName(faker.name().fullName());
        enterPreferredName(faker.name().username());
        enterSuffix(faker.name().suffix());
        selectGenderFromDropdown();
       selectMaritalStatusFromDropdown();
        selectDOB(sdf.format(faker.date().birthday()));
        enterTaxId(faker.finance().bic());

        // Citizenship
        selectCountryOfCitizenshipFromDropdown();
        enterNationalId(faker.numerify("########"));
        clickNoButtonInMoreThanOneCitizenship();
        clickYesButtonInLegallyAuthorized();

        // Home Address
        enterAddressLine1(faker.address().streetAddress());
        enterCity(faker.address().city());
        enterPostalCode(faker.address().zipCode());

        // Contact Details
        enterWorkNumber(faker.numerify("###########"));
        enterHomeNumber(faker.numerify("###########"));
        enterMobileNumber(faker.numerify("##########"));

        // Click Next button
        clickNextButton();
    }

}
