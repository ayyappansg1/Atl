package pages.common;

import com.github.javafaker.Faker;
import common.TestUtil;
import helper.LocalHelper;
import objectRepo.commonRepo.ProfilePage_Repo;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Properties;

public class Profile_Page extends ProfilePage_Repo {

    protected static final Logger logger = LoggerFactory.getLogger(Profile_Page.class);
    Properties prop = new TestUtil().init_Properties("common/URL");
    private final LocalHelper localHelper = new LocalHelper();

    private final String appURL= System.getProperty("APP_URL");

    private final WebDriver driver;
    String getRandomValue;

    public Profile_Page(WebDriver driver) {
        this.driver=driver;
    }

    public void verifyProfileStepper() {
        if(localHelper.checkLoader(atlas_Loader,driver)){
        try {
            if(localHelper.getText(profile_Stepper,driver).equalsIgnoreCase("Profile")){
                logger.info("We are in profile stepper");
                getEmployee_ID();
            }else{
                logger.info("Profile page has not opened");
            }
        }catch (NoSuchElementException | TimeoutException e){
            logger.error("Profile stepper is not appearing ");
            if(localHelper.getText(profile_Stepper,driver).equalsIgnoreCase("Profile")){
                logger.info("We are in profile stepper");
                getEmployee_ID();
            }
        }
    }}

    public void enterAdditionalName(String value){
        if(localHelper.checkLoader(atlas_Loader,driver)){
        localHelper.sendKeys(additionalName_txt,value,driver);  }
    }

    public void enterDOB(String value) { localHelper.sendKeys(dob_txt,value,driver);    }

    public void enterGender() {
        localHelper.checkLoader(atlas_Loader,driver);

        try{
            localHelper.scrollIntoView(taxNumber_txt,driver);
            localHelper.clickElement(gender_dropdown,driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
          //  localHelper.sendKeys(gender_dropdown_for_value,getRandomValue,driver);
            localHelper.clickElement(dropdown_gender_one,driver);
        }catch (TimeoutException | ElementNotVisibleException e){
            logger.error("Gender dropdown");
            localHelper.scrollIntoView(taxNumber_txt,driver);
            localHelper.jsExecutorClick(gender_dropdown,driver);
           // getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            //localHelper.jsExecutorSendValue(gender_dropdown,getRandomValue,driver);
            localHelper.jsExecutorClick(dropdown_gender_one,driver);
        }
    }
    public void waitUntilChangeStatusButtonPresent(){

        localHelper.waitUntilElementPresent(changeStatus,driver);

    }
    public void enterPersonalPronoun() {
        localHelper.scrollIntoView(pronoun_dropdown,driver);
        localHelper.clickElement(pronoun_dropdown,driver);
        getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
        localHelper.jsExecutorSendValue(pronoun_dropdown, getRandomValue,driver);
        localHelper.scrollIntoView(dropdown_Values,driver);
        localHelper.clickElement(dropdown_Values,driver);
    }

    public void enterMaritalStatus(){
        localHelper.clickElement(maritalStatus_dropdown,driver);
        getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
        localHelper.jsExecutorSendValue(maritalStatus_dropdown,getRandomValue,driver);
        localHelper.clickElement(dropdown_Values,driver);
    }

    public void enterTaxNum(String value){
        localHelper.sendKeys(taxNumber_txt,value,driver);
    }

    public void selectWseClassificationFromDropdown(){
        localHelper.clickElement(wseClassification_dropdown,driver);
        String getRandomWse = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
        localHelper.jsExecutorSendValue(wseClassification_dropdown,getRandomWse,driver);
        localHelper.clickElement(dropdown_Values,driver);
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

    public void clickCitizenshipYes(){
        localHelper.clickElement(citizenshipYes_radio,driver);
    }

    public void clickAddCitizenship(){
        localHelper.scrollIntoView(citizenshipAdd_btn,driver);
        localHelper.clickElement(citizenshipAdd_btn,driver);
    }

    public void enterCitizenshipCountry1() {
        try {
            if(localHelper.verifyEnabledElement(citizenshipCountry1_dropdown,driver)) {
                localHelper.scrollIntoView(citizenshipCountry1_dropdown, driver);
                localHelper.clickElement(citizenshipCountry1_dropdown, driver);
                getRandomValue = localHelper.getRandomElement(dropdown_Values, driver).getText().toLowerCase();
                localHelper.jsExecutorSendValue(citizenshipCountry1_dropdown, getRandomValue, driver);
                localHelper.clickElement(dropdown_Values, driver);
        }}
        catch (TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(citizenshipCountry1_dropdown, driver);
            localHelper.clickElement(citizenshipCountry1_dropdown, driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values, driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(citizenshipCountry1_dropdown, getRandomValue, driver);
            localHelper.clickElement(dropdown_Values, driver);
            logger.info("Country1 Clicked using catch");
        }}

    public void enterCitizenshipCountry2() {
        try {
            if(localHelper.verifyEnabledElement(citizenshipCountry2_dropdown,driver)){
                localHelper.scrollIntoView(citizenshipCountry2_dropdown,driver);
                localHelper.clickElement(citizenshipCountry2_dropdown,driver);
                getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
                localHelper.jsExecutorSendValue(citizenshipCountry2_dropdown, getRandomValue,driver);
                localHelper.clickElement(dropdown_Values,driver);
        }}
        catch (TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(citizenshipCountry2_dropdown,driver);
            localHelper.clickElement(citizenshipCountry2_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(citizenshipCountry2_dropdown, getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
            logger.info("Country2 Clicked using catch");
        }
    }

    public void enterCitizenshipCountry3() {
        try{
            localHelper.scrollIntoView(citizenshipCountry3_dropdown,driver);
            localHelper.clickElement(citizenshipCountry3_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(citizenshipCountry3_dropdown, getRandomValue,driver);
            localHelper.scrollIntoView(dropdown_Values,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }catch(TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(citizenshipCountry3_dropdown,driver);
            localHelper.clickElement(citizenshipCountry3_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(citizenshipCountry3_dropdown, getRandomValue,driver);
            localHelper.scrollIntoView(dropdown_Values,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }

    }

    public void enterCitizenshipID1(String value){
        localHelper.sendKeys(citizenshipID1_txt,value,driver);
    }
    public void enterCitizenshipID2(String value){
        localHelper.sendKeys(citizenshipID2_txt,value,driver);
    }
    public void enterCitizenshipID3(String value){
        localHelper.sendKeys(citizenshipID3_txt,value,driver);
    }

    public void enterHomePhone(String value) {
        localHelper.scrollIntoView(homePhone_txt,driver);
        localHelper.sendKeys(homePhone_txt,value,driver);
    }

    public void enterMobilePhone(String value){
        localHelper.sendKeys(mobilePhone_txt,value,driver);
    }
    public void enterWorkPhone(String value){
        localHelper.sendKeys(workPhone_txt,value,driver);
    }
//    public void enterWorkEmail(String value){
//        localHelper.scrollIntoView(workEmail_txt,driver);
//        localHelper.sendKeys(workEmail_txt,value,driver);
//    }

//    public void jsScroll(){
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0,1000)");
//    }

    public String getPersonalEmail(){
       return localHelper.getText(personalEmail_txt,driver);
    }

    public void clickNextButton(String role) {
        verifyProfileStepper();
        try{
            if(localHelper.checkLoader(atlas_Loader,driver)){
                localHelper.scrollIntoView(next_btn,driver);
                localHelper.clickElement(next_btn,driver);
        }} catch (TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(next_btn, driver);
            localHelper.clickElement(next_btn, driver);
            logger.info("Next Button is Clicked Successfully");
        }
        }
//    public void clickNextButton() {
//           if (getPersonalEmail() != null || getPersonalEmail().equals("")) {
//               if (localHelper.verifyEnabledElement(next_btn, driver)) {
//                   localHelper.scrollIntoView(next_btn, driver);
//                   localHelper.clickElement(next_btn, driver);
//               }
//           }else{
//               logger.info("We're not getting the email field value");
//               localHelper.scrollIntoView(next_btn, driver);
//               localHelper.clickElement(next_btn, driver);
//               if(localHelper.verifyElement(gotItBtn_popup,5,driver)){
//                   logger.info("");
//                   localHelper.clickElement(gotItBtn_popup,driver);
//               }}}
    public String getEmployee_ID(){
        String empID = localHelper.getText(employeeID, driver);
    new TestUtil().update_Properties("employeeView/Employee","EMPLOYEE_ID",empID);
        System.out.println(empID);
    return empID;

    }

    public void verifyJobDetailsUrl(String role){
        if (role.equals("CLIENT HR")){
            new LocalHelper().waitForPageURL(prop.getProperty("JOB_DETAILS_URL"), driver);
            Assert.assertEquals(appURL + prop.getProperty("JOB_DETAILS_URL")+ getEmployee_ID(), driver.getCurrentUrl(), "Mismatch found in URL of the page loaded");
            logger.info("Client JobDetails URL is verified");
        } else if (role.equals("INTERNAL HR")) {
            new LocalHelper().waitForPageURL(prop.getProperty("JOB_DETAILS_URL_INTERNAL"), driver);
            Assert.assertEquals(appURL + prop.getProperty("JOB_DETAILS_URL_INTERNAL")+ getEmployee_ID(), driver.getCurrentUrl(), "Mismatch found in URL of the page loaded");
            logger.info("Internal JobDetails URL is verified");
        }else {
            logger.error("URL Verification is failed");
        }
    }

    public void navigateToJobDetails(String role) {
        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        verifyProfileStepper();
       // waitUntilChangeStatusButtonPresent();
        // Personal Information section
        enterGender();
        enterMaritalStatus();
        enterDOB(sdf.format(faker.date().birthday()));
        enterTaxNum(faker.finance().bic());
       /* if(role.equals("INTERNAL HR")){
            localHelper.scrollIntoView(wseClassification_dropdown,driver);
            selectWseClassificationFromDropdown();
        }*/

        // Citizenship
        enterCitizenshipCountry1();
        enterCitizenshipID1(faker.idNumber().valid());
        clickCitizenshipYes();
//        enterCitizenshipCountry2();
//        enterCitizenshipID2(faker.idNumber().valid());
//        clickAddCitizenship();
//        enterCitizenshipCountry3();
//        enterCitizenshipID3(faker.idNumber().valid());

        // Home Address section
        enterState(faker.address().state());
        enterAddressLine1(faker.address().streetAddress());
        enterAddressLine2(faker.address().streetName());
        enterCity(faker.address().city());
        enterPostalCode(faker.address().zipCode());

        // Contact details
        enterHomePhone(faker.numerify("#######"));
        enterMobilePhone(faker.numerify("#########"));
        enterWorkPhone(faker.numerify("########"));

    }
}
