package pages.common;

import com.github.javafaker.Faker;
import common.TestUtil;
import email.MailSacService;
import helper.LocalHelper;
import objectRepo.commonRepo.AddEmployee_Repo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Properties;

public class AddEmployee_Page extends AddEmployee_Repo {
    protected static final Logger logger = LoggerFactory.getLogger(AddEmployee_Page.class);
    private final LocalHelper localHelper = new LocalHelper();

    Faker faker = new Faker();

    private final WebDriver driver;
    public static String fullName = "";
    public static String domain = "";
    public static String email = "";
    public String getRandomValue;

    public AddEmployee_Page(WebDriver driver) {
        this.driver=driver;
    }

    public void tabThroughFields() throws InterruptedException {
        logger.info("Checking the Tab Fields");
        localHelper.pressTabKey(firstName_txt,driver);
        logger.info("Checking the Tab Fields");
        localHelper.pressTabKey(surname_txt,driver);
        logger.info("Checking the Tab Fields");
        localHelper.pressTabKey(personalEmail_txt,driver);
        enterResidenceCountry();
    }
    public void tabThroughFieldsForCustomerHr() throws InterruptedException {
        logger.info("Checking the Tab Fields");
        localHelper.pressTabKey(firstName_txt,driver);
        logger.info("Checking the Tab Fields");
        localHelper.pressTabKey(surname_txt,driver);
        logger.info("Checking the Tab Fields");
        localHelper.pressTabKey(personalEmail_txt,driver);
        localHelper.pressTabKey(personalEmail_txt,driver);
    }

    public String getFirstNameValidationErrorMsg(){
        return localHelper.getText(firstNameValidationErrorMsg,driver);
    }

    public String getSurnameValidationErrorMsg(){
        return localHelper.getText(surnameValidationErrorMsg,driver);
    }

    public String getPersonalMailValidationErrorMsg(){
        return localHelper.getText(personalEmailValidationErrorMsg,driver);
    }
    public boolean firstNameField_isPresent(){
        return localHelper.verifyEnabledElement(firstName_txt,driver);
    }
    public boolean surnameField_isPresent(){
        return localHelper.verifyEnabledElement(surname_txt,driver);
    }
    public boolean personalEmailField_isPresent(){
        return localHelper.verifyEnabledElement(personalEmail_txt,driver);
    }
    public boolean workCountryField_isPresent(){
        return localHelper.verifyEnabledElement(workCountry_dropdown,driver);
    }
    public boolean residenceCountryField_isPresent(){
        return localHelper.verifyEnabledElement(residenceCountry_dropdown,driver);
    }
    public void enterFirstName(String value){
        localHelper.sendKeys(firstName_txt,value,driver);
    }
    public void enterSurname(String value){
        localHelper.sendKeys(surname_txt,value,driver);
    }
    public void enterPersonalMail(String value){
        localHelper.sendKeys(personalEmail_txt,value,driver);
    }

    public void enterWorkCountry(String value) {
        localHelper.clickElement(workCountry_dropdown,driver);
        if(localHelper.verifyElement(noOptions_popupDropdownTxt,5,driver)){
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(noOptions_popupDropdownTxt));
            if(value==null) {
                getRandomValue = localHelper.getRandomElement(predictiveSearch_DropDownValues, driver).getText();
                localHelper.sendKeys(workCountry_dropdown, getRandomValue, driver);
                localHelper.clickElement(countryDropdownFocus_select, driver);
            }else{
                localHelper.dropDownSelectByText(workCountry_dropdown,value,driver);
            }}
        else{
                if(value==null) {
                    getRandomValue = localHelper.getRandomElement(predictiveSearch_DropDownValues, driver).getText();
                    localHelper.sendKeys(workCountry_dropdown, getRandomValue, driver);
                    localHelper.clickElement(countryDropdownFocus_select, driver);
                }else{
                    localHelper.dropDownSelectByText(workCountry_dropdown,value,driver);
                }
            }}

    public void enterResidenceCountry(){
        localHelper.clickElement(residenceCountry_dropdown,driver);
        getRandomValue = localHelper.getRandomElement(predictiveSearch_DropDownValues,driver).getText();
        localHelper.sendKeys(residenceCountry_dropdown,getRandomValue,driver);
        localHelper.clickElement(residenceCountryDropdown_Select,driver);
    }

    public void enterCustomer(String value) {
        // Wait for an element
        localHelper.clickElement(customer_dropdown,driver);
        if(localHelper.verifyElement(noOptions_popupDropdownTxt,5,driver)){
            WebDriverWait wait = new WebDriverWait(driver,40);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(noOptions_popupDropdownTxt));
            if(value==null){
                getRandomValue = localHelper.getRandomElement(predictiveSearch_DropDownValues,driver).getText();
                localHelper.sendKeys(customer_dropdown,getRandomValue,driver);
                localHelper.clickElement(customerDropdownFocus_Select,driver);
                logger.info("country template is chosen after wait");
            }else{
                localHelper.dropDownSelectByText(customer_dropdown,value,driver);
            }
        }else{
            if(value==null){
                getRandomValue = localHelper.getRandomElement(predictiveSearch_DropDownValues,driver).getText();
                localHelper.sendKeys(customer_dropdown,getRandomValue,driver);
                localHelper.clickElement(customerDropdownFocus_Select,driver);
                logger.info("country template is chosen without wait");
            }else{
                localHelper.dropDownSelectByText(customer_dropdown,value,driver);
            }
        }
    }

    public void clickContinueToProfile() {
        localHelper.clickElement(continueToProfile_btn,driver);

    }

    public boolean profilePageContainerIsPresent(){
        return localHelper.verifyEnabledElement(personalInfoHeader_Profile,driver);
    }

    public String getFullName(){ return localHelper.getAttributeValue(firstName_txt,driver).concat(localHelper.getAttributeValue(surname_txt,driver));}

    public void getUserName(){
        email = localHelper.getAttributeValue(personalEmail_txt,driver);
        String[] output = email.split("@");
        fullName = output[0];
        domain = output[1];
        new TestUtil().update_Properties("employeeView/Employee","EMPLOYEE_EMAIL",email);
    }

    public void createEmployee(String role){
        Properties prop = new TestUtil().init_Properties("common/CommonProp");

        enterFirstName(faker.name().firstName());
        enterSurname(faker.name().lastName());
        enterPersonalMail(faker.internet().emailAddress());
        if(role.equals("INTERNAL HR")){
            enterCustomer(prop.getProperty("CUSTOMER"));
        }
        getUserName();
        enterWorkCountry(prop.getProperty("COUNTRY"));
        enterResidenceCountry();
        clickContinueToProfile();
        logger.info("Employee created");
  }

    public void createEmployeeView(String role) {

        MailSacService mailSacService = new MailSacService();
        Properties prop = new TestUtil().init_Properties("common/CommonProp");

        enterFirstName(faker.name().firstName());
        enterSurname(faker.name().lastName());
        enterPersonalMail(mailSacService.emailGenerator(getFullName()));
        if(role.equals("INTERNAL HR")){
            enterCustomer(prop.getProperty("CUSTOMER"));
        }
        getUserName();
        enterWorkCountry(prop.getProperty("COUNTRY"));
        enterResidenceCountry();
        clickContinueToProfile();
        logger.info("Employee created");
    }
}
