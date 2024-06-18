package objectRepo.commonRepo;

import org.openqa.selenium.By;

public class AddEmployee_Repo {

    // By locators
    public By modalTitle = By.xpath("//div[@class='modal-header p-0']/span");
    public By firstName_txt = By.xpath("//input[@data-testid='fname-input']");
    public By surname_txt = By.xpath("//input[@data-testid='lname-input']");
    public By personalEmail_txt = By.xpath("//input[@data-testid='email-input']");
    public By workCountry_dropdown = By.xpath("//div[@data-testid='country-input']//input");
    public By residenceCountry_dropdown = By.xpath("//div[@data-testid='residence-input']//input");
    public By customer_dropdown = By.xpath("//div[@data-testid='customer-input']//input");
    public By continueToProfile_btn = By.xpath("//button[@data-testid='continue-profile']");
    public By personalInfoHeader_Profile = By.xpath("//div[@class='profile_container']");
    public By closeIcon = By.xpath("//div[@class='a-modal__body']/span");

    public By firstName_lbl = By.xpath("//div[@class='col-md-6'][1]//div[@class='form-label']");
    public By surname_lbl= By.xpath("//div[@class='col-md-6'][2]//div[@class='form-label']");
    public By personalEmail_lbl= By.xpath("//div[@class='col-md-6'][3]//div[@class='form-label']");
    public By firstName_asterisk = By.xpath("//div[@class='col-md-6'][1]//span");
    public By surname_asterisk = By.xpath("//div[@class='col-md-6'][2]//span");
    public By personalEmail_asterisk= By.xpath("//div[@class='col-md-6'][3]//span");
    public By workCountry_asterisk = By.xpath("//div[@class='col-md-6'][4]//span");
    public By residenceCountry_asterisk = By.xpath("//div[@class='col-md-6'][5]//span");

    public By firstNameValidationErrorMsg= By.xpath("//div[text()='First Name']//ancestor::div/div[@class='validation-error']");
    public By surnameValidationErrorMsg = By.xpath("//div[text()='Full Surname']//ancestor::div/div[@class='validation-error']");
    public By personalEmailValidationErrorMsg = By.xpath("//div[text()='Email']//ancestor::div/div[@class='validation-error']");
    public By workCountryValidationErrorMsg = By.xpath("//div[@class='col-md-6'][4]//div[@class='validation-error']");
    public By residenceCountryValidationErrorMsg = By.xpath("//div[@class='col-md-6'][5]//div[@class='validation-error']");

    public By residenceCountryDropdown_placeholder = By.xpath("//div[@data-testid='residence-input']//div/div/div/div[1]/div[1]");
    public By WorkCountryDropdown_placeholder = By.xpath("//div[@data-testid='country-input']//div/div/div/div[1]/div[1]");
    public By customerDropdown_placeholder = By.xpath("//div[@data-testid='customer-input']//div/div/div/div[1]/div[1]");
    public By workCountryDropdown_loader = By.xpath("//div[@class='custom-select-box__indicator custom-select-box__loading-indicator css-at12u2-loadingIndicator']/span");
    public By predictiveSearch_DropDownValues = By.xpath("//ul[@class='option-list']/li");
    public By residenceCountryDropdown_Select = By.xpath("//ul[@class='option-list']/li[@class='active']");
    public By countryDropdown_Select = By.xpath("//ul[@class='option-list']/li[@class='options-list']");
    public By noOptions_popupDropdownTxt = By.xpath("//ul[@class='option-list']/div[@class='no-option-text']");
    public By loadingTxt_Dropdown = By.xpath("//div[@class='custom-select-box__menu-notice custom-select-box__menu-notice--loading css-1gl4k7y']");
    public By dropDown_selectElement = By.xpath("//li[@class='active']");
    public By customerDropdownFocus_Select = By.xpath("//ul[@class='option-list']/li[@class='active']/span");
    public By countryDropdownFocus_select = By.xpath("//ul[@class='option-list']/li[@class='active']/span");

    // no search result on dropdown - //div[@class='drop-no-content']
}
