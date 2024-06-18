package pages.common;

import com.github.javafaker.Faker;
import common.TestUtil;
import helper.LocalHelper;
import objectRepo.commonRepo.Compensation_Repo;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Compensation_Page extends Compensation_Repo {
    protected static final Logger logger = LoggerFactory.getLogger(Compensation_Page.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;
    String getRandomValue;

    Faker faker = new Faker();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

    public Compensation_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCompensationStepper() {
        if(localHelper.checkLoader(atlas_Loader,driver)){
        if(localHelper.getText(compensation_Stepper,driver).equalsIgnoreCase("Compensation")){
            logger.info("We are in Compensation stepper");
        }else{
            logger.info("Not redirecting to the Compensation stepper");
        }
    }}
    public void selectPayItem() {
        try{
            localHelper.scrollIntoView(payItem_Dropdown,driver);
            localHelper.clickElement(payItem_Dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(payItem_Dropdown,getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }catch (TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(payItem_Dropdown,driver);
            localHelper.clickElement(payItem_Dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(payItem_Dropdown,getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }
    }

    public void selectFrequency() {
        localHelper.scrollIntoView(frequency_Dropdown,driver);
        localHelper.clickElement(frequency_Dropdown,driver);
        getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
        localHelper.jsExecutorSendValue(frequency_Dropdown,getRandomValue,driver);
        localHelper.clickElement(dropdown_Values,driver);
    }
    public void clickAdjustmentCheckbox() {
        localHelper.scrollIntoView(adjustment_checkbox,driver);
        localHelper.clickElement(adjustment_checkbox,driver);
    }
    public void clickNonTaxableCheckbox() {
        localHelper.scrollIntoView(nontaxable_checkbox,driver);
        localHelper.clickElement(nontaxable_checkbox,driver);
    }
    public void enterEffectiveDate(String value){
        localHelper.scrollIntoView(effective_date,driver);
        if(value==null){
            localHelper.sendKeys(effective_date, sdf.format(faker.date().future(30, TimeUnit.DAYS)),driver);
        }else{
            localHelper.sendKeys(effective_date,value,driver);
        }
    }

    public void enterAmount(String value){
        localHelper.sendKeys(amount_btn,value,driver);
    }
    public void clickSavePayItemButton() {
        localHelper.scrollIntoView(savePayItem_btn,driver);
        localHelper.clickElement(savePayItem_btn,driver);
    }


    public void clickNextButton() {
        localHelper.scrollIntoView(next_btn,driver);
        localHelper.clickElement(next_btn,driver);
    }

    public void navigateToFinishPage() {
        Properties prop1 = new TestUtil().init_Properties("employeeView/Employee");
        logger.info("### Running navigateToFinishPageFromCompensationPage method ###");

        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        verifyCompensationStepper();
        selectPayItem();
        selectFrequency();
        clickAdjustmentCheckbox();
        enterEffectiveDate(sdf.format(faker.date().past(20, TimeUnit.DAYS)));
        enterAmount(faker.number().digits(3));
        clickSavePayItemButton();
        clickNextButton();
    }
    }
