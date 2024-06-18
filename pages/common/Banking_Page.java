package pages.common;

import com.github.javafaker.Faker;
import common.TestUtil;
import helper.LocalHelper;
import objectRepo.commonRepo.BankingPage_Repo;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Banking_Page extends BankingPage_Repo {

    protected static final Logger logger = LoggerFactory.getLogger(Banking_Page.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;


    String getRandomValue;

    Properties prop = new TestUtil().init_Properties("employeeView/employee");

    public Banking_Page(WebDriver driver) {
        this.driver = driver;
    }


    public void verifyBankingStepper() {
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.presenceOfElementLocated(Banking_Stepper));
        try {
            if(localHelper.getText(Banking_Stepper,driver).equalsIgnoreCase("Banking")){
                logger.info("We are in Banking stepper");
            }else{
                logger.info("Banking page has not opened");
            }
        }catch (NoSuchElementException | TimeoutException e){
            logger.error("Banking stepper is not appearing ");
            if(localHelper.getText(Banking_Stepper,driver).equalsIgnoreCase("Banking")){
                logger.info("We are in Banking stepper");
            }
        }

    }

    public void scroll_Up(){
        localHelper.scrollIntoView(Scroll_Start,driver);
    }

    public  void click_BankCountry() {
        try {
            localHelper.scrollIntoView(bank_country,driver);
            localHelper.clickElement(bank_country,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(bank_country, getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }
        catch (TimeoutException | ElementNotVisibleException | StaleElementReferenceException e){
            logger.info("Error Occured in Bank Country Click");
            localHelper.scrollIntoView(bank_country,driver);
            localHelper.clickElement(bank_country,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(bank_country, getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
            logger.info("Bank Country is clicked using Catch");
        }
    }


    public  void Enter_AccountHolder_Name(String value) {
        localHelper.scrollIntoView(accountHolder_name,driver);
        localHelper.clickElement(accountHolder_name,driver);
        localHelper.sendKeys(accountHolder_name,value,driver);
    }

    public void Enter_WorkPhone1(String value){
        localHelper.scrollIntoView(work_Phone1,driver);
        localHelper.clickElement(work_Phone1,driver);
        localHelper.sendKeys(work_Phone1,value,driver);

    }
    public void Enter_WorkPhone2(String value){
        localHelper.scrollIntoView(work_Phone2,driver);
        localHelper.clickElement(work_Phone2,driver);
        localHelper.sendKeys(work_Phone2,value,driver);

    }

    public  void click_CheckBox() {

        localHelper.scrollIntoView(check_box, driver);
        localHelper.jsExecutorClick(check_box, driver);
    }
    public void enterAddressLine1(String value) {
        localHelper.scrollIntoView(city_txt,driver);
        localHelper.sendKeys(addressLine1_txt,value,driver);
    }

    public void enterAddressLine2(String value){
        localHelper.sendKeys(addressLine2_txt,value,driver);
    }

    public void enterCity(String value){
        localHelper.scrollIntoView(city_txt,driver);
        localHelper.sendKeys(city_txt,value,driver);
    }

    public void enterState(String value){
        localHelper.scrollIntoView(state_txt,driver);
        localHelper.sendKeys(state_txt,value,driver);
    }
    public void enterPostalCode(String value){
        localHelper.sendKeys(postalCode_txt,value,driver);
    }

    public  void Enter_BankName(String value) {
        try{localHelper.scrollIntoView(bank_Name, driver);
            localHelper.jsExecutorClick(bank_Name, driver);
            localHelper.sendKeys(bank_Name,value,driver);
        }catch(TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(bank_Name, driver);
            localHelper.jsExecutorClick(bank_Name, driver);
            localHelper.sendKeys(bank_Name,value,driver);
        }
    }

    public  void Enter_AccountNumber(String value) {
        localHelper.scrollIntoView(bank_account_number, driver);
        localHelper.jsExecutorClick(bank_account_number, driver);
        localHelper.sendKeys(work_Phone2,value,driver);
    }

    public  void clickSaveButton() {
        localHelper.scrollIntoView(saveAndContinue_btn, driver);
        localHelper.jsExecutorClick(saveAndContinue_btn, driver);
    }

    public void scroll_Finish(){
        localHelper.scrollIntoView(Finish_Stepper,driver);
    }

    public void fillBankingDetails(){
        localHelper.checkLoader(atlas_Loader,driver);
        //verifyBankingStepper();
        click_BankCountry();

    }

    public  void clickNextButton() {
        localHelper.checkLoader(atlas_Loader,driver);
        verifyBankingStepper();
        try {
            localHelper.scrollIntoView(next_btn, driver);
            localHelper.clickElement(next_btn, driver);
        }catch (TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(next_btn, driver);
            localHelper.clickElement(next_btn, driver);
        }

    }

        public void clickSaveAndContinueButton () {
            if (driver.getCurrentUrl().contains(prop.getProperty("BANKING_PAGE_URL"))) {
                localHelper.jsExecutorClick(saveAndContinue_btn, driver);
            }
        }

    public void navigateToNextStep() {

        Faker faker = new Faker();

        verifyBankingStepper();
        click_BankCountry_Another();
        Enter_AccountHolder_Name(faker.name().firstName());
        //Enter_WorkPhone1(faker.number().digits(2));
        Enter_WorkPhone2(faker.number().digits(2));
        click_CheckBox();
        Enter_BankName("UniCredit Bank Austria AG");
      //  banking_page.Enter_AccountNumber(faker.numerify("######"));
        enterIBANNumber();
        clickSaveButton();
        clickNextButton();
        checkWarningForMissedFields();
        //enterIACHNumber();
        //enterLocalRoutingNumber();


    }
    public  void click_BankCountry_Another() {
        try {
            //localHelper.scrollIntoView(bank_country,driver);
            localHelper.checkLoader(atlas_Loader,driver);
            localHelper.clickElement(bank_country,driver);
            localHelper.simpleSendKeysAnother(bank_country,"Austria",driver);
         //   getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
          //  localHelper.jsExecutorSendValue(bank_country, "Austria",driver);
            localHelper.getParticularTextFromDropdown(dropdown_Values,"Austria",driver);
        }
        catch (TimeoutException | ElementNotVisibleException | StaleElementReferenceException e){
            localHelper.clickElement(bank_country,driver);
            localHelper.simpleSendKeysAnother(bank_country,"Austria",driver);
            //   getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            //  localHelper.jsExecutorSendValue(bank_country, "Austria",driver);
            localHelper.getParticularTextFromDropdown(dropdown_Values,"Austria",driver);
        }
    }
    public void enterIBANNumber(){
        try{localHelper.scrollIntoView(ibanNumber, driver);
            localHelper.jsExecutorClick(ibanNumber, driver);
            localHelper.sendKeys(ibanNumber,"AT301997002312510981",driver);
        }catch(TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(ibanNumber, driver);
            localHelper.jsExecutorClick(ibanNumber, driver);
            localHelper.sendKeys(ibanNumber,"AT301997002312510981",driver);
        }

    }
    public void checkWarningForMissedFields(){
        if(localHelper.checkElement(warningButton,driver)){
            localHelper.clickElement(warningButton,driver);
        }
    }
    public void enterIACHNumber(){
        try {
            localHelper.scrollIntoView(iachNumber,driver);
            localHelper.simpleSendKeys(iachNumber,"12121212121212",driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
           // localHelper.jsExecutorSendValue(iachNumber, "DK0616890000000003",driver);
            //localHelper.clickElement(dropdown_Values,driver);
        }
        catch (TimeoutException | ElementNotVisibleException | StaleElementReferenceException e){
            localHelper.scrollIntoView(iachNumber,driver);
            localHelper.simpleSendKeys(iachNumber,"12121212121212",driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
           // localHelper.jsExecutorSendValue(iachNumber, "DK0616890000000003",driver);
            //localHelper.clickElement(dropdown_Values,driver);
        }
    }
    public void enterLocalRoutingNumber(){
        try {
            localHelper.scrollIntoView(localRoutingCode,driver);
            localHelper.simpleSendKeys(localRoutingCode,"1212",driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            // localHelper.jsExecutorSendValue(iachNumber, "DK0616890000000003",driver);
            //localHelper.clickElement(dropdown_Values,driver);
        }
        catch (TimeoutException | ElementNotVisibleException | StaleElementReferenceException e){
            localHelper.scrollIntoView(localRoutingCode,driver);
            localHelper.simpleSendKeys(localRoutingCode,"1212",driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            // localHelper.jsExecutorSendValue(iachNumber, "DK0616890000000003",driver);
            //localHelper.clickElement(dropdown_Values,driver);
        }
    }

}

