package pages.common;

import com.github.javafaker.Faker;
import common.TestUtil;
import helper.LocalHelper;
import objectRepo.commonRepo.JobDetails_Repo;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class JobDetails_Page extends JobDetails_Repo {

    protected static final Logger logger = LoggerFactory.getLogger(JobDetails_Page.class);
    private final LocalHelper localHelper = new LocalHelper();

    Properties prop = new TestUtil().init_Properties("common/URL");
    Properties prop1 = new TestUtil().init_Properties("employeeView/Employee");
    private final WebDriver driver;
    String getRandomValue;
    private final String appURL= System.getProperty("APP_URL");

    Faker faker = new Faker();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

    public JobDetails_Page(WebDriver driver) {
        this.driver=driver;
    }

    public void verifyJobDetailStepper() {
        if(localHelper.checkLoader(atlas_Loader,driver)) {
            if (localHelper.getText(jobDetail_Stepper, driver).equalsIgnoreCase("Job Details")) {
                logger.info("We are in job Detail stepper");
            } else {
                logger.info("Not redirecting to the job detail stepper");
            }
        }else{
            logger.info("Loader is not disappeared");

        }
    }
    public void verifySubmitStepper() {
        if(localHelper.getText(submitStepper,driver).equalsIgnoreCase("SUBMIT")){
            logger.info("We are in Submit Stepper");
        }else{
            logger.info("Not redirecting to the Submit stepper");
        }
    }

    public void enterTargetStartDate(String value) {
        //localHelper.jsExecutorSendValue(targetStartDate_datePicker,value,driver);
        if(localHelper.checkLoader(atlas_Loader,driver)){
       localHelper.scrollIntoView(targetStartDate_datePicker,driver);
       localHelper.sendKeys(targetStartDate_datePicker,value,driver);}}
    public void enterSeniorityDate(String value){
       // localHelper.scrollIntoView(seniorityDate_datePicker,driver);
        localHelper.sendKeys(seniorityDate_datePicker,value,driver);
    }

    public void enterAtlasStartDate(String value){
       // localHelper.scrollIntoView(atlasStartDate_datePicker,driver);
        if(value==null){
            localHelper.sendKeys(atlasStartDate_datePicker, sdf.format(faker.date().past(30, TimeUnit.DAYS)),driver);
        }else{
            localHelper.sendKeys(atlasStartDate_datePicker,value,driver);
        }
    }

    public void enterJobTitle(String value){
        localHelper.sendKeys(jobTitle_txt,value,driver);
    }
    public void enterWorkingHours(String value){
        localHelper.sendKeys(workingHours_txt,value,driver);
    }
    public void enterTermEndDate(String value){ localHelper.sendKeys(termEndDate_txt,value,driver);   }

    public void enterJobDescription(String value) {
        localHelper.scrollIntoView(jobDescription_txt,driver);
        localHelper.sendKeys(jobDescription_txt,value,driver);
    }

    public void selectEmploymentType(){
        try{
            localHelper.scrollIntoView(employmentType_dropdown,driver);
            localHelper.clickElement(employmentType_dropdown_direct,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(employmentType_dropdown,getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }catch(TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(employmentType_dropdown,driver);
            localHelper.jsExecutorClick(employmentType_dropdown_direct,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(employmentType_dropdown,getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }

    }

    public void selectEmploymentTerm(){
        localHelper.scrollIntoView(managerName_dropdown,driver);
        localHelper.clickElement(employmentTerm_dropdown,driver);
        getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
        localHelper.jsExecutorSendValue(employmentTerm_dropdown,getRandomValue,driver);
        localHelper.clickElement(dropdown_Values,driver);
        if(getRandomValue.equalsIgnoreCase("FIXED")){
            enterTermEndDate(sdf.format(faker.date().future(30, TimeUnit.DAYS)));
        }
    }

    public void selectManagerName(String value) {
        if(value==null){
            localHelper.scrollIntoView(managerName_dropdown,driver);
            localHelper.clickElement(managerName_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(managerName_dropdown,getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);

        }else{
            if(localHelper.verifyElement(noOptions_popupDropdownTxt,5,driver)){
                WebDriverWait wait = new WebDriverWait(driver,30);
                wait.until(ExpectedConditions.invisibilityOfElementLocated(noOptions_popupDropdownTxt));
                localHelper.jsExecutorSendValue(managerName_dropdown,value.toLowerCase(),driver);
                localHelper.clickElement(dropdown_Values,driver);
            }}
    }

    public void selectPayGroup(){

        try{
            localHelper.scrollIntoView(payGroup_dropdown,driver);
            localHelper.clickElement(payGroup_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(payGroup_dropdown,getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }catch(TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(payGroup_dropdown,driver);
            localHelper.clickElement(payGroup_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(payGroup_dropdown,getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }
    }

    public void selectProbationPeriodUnit() {
        try{
            localHelper.scrollIntoView(probationPeriodUnit_dropdown,driver);
            localHelper.clickElement(probationPeriodUnit_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(probationPeriodUnit_dropdown,getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }catch(TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(probationPeriodUnit_dropdown,driver);
            localHelper.clickElement(probationPeriodUnit_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(probationPeriodUnit_dropdown,getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }

    }

    public void selectProbation() {

        localHelper.scrollIntoView(probationYes_radio,driver);
            if(faker.bool().bool()){
                localHelper.jsExecutorClick(probationYes_radio,driver);
                selectProbationPeriodUnit();
                enterNumberOfDaysWeeksMonths(String.valueOf(faker.number().randomDigitNotZero()));
            }
            else{ localHelper.jsExecutorClick(probationNo_radio,driver); }}
    public void selectInstallments() {

        localHelper.scrollIntoView(installmentYes_radio, driver);
        // if(faker.bool().bool()){
        localHelper.jsExecutorClick(installmentYes_radio, driver);
        selectInstallmentType();
        selectRequisitionType();
        //}
        //else{ localHelper.jsExecutorClick(probationNo_radio,driver); }}
    }

    private void selectRequisitionType() {
        try{
            localHelper.scrollIntoView(Requisition_dropdown,driver);
            localHelper.clickElement(Requisition_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(Requisition_dropdown_values,getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }catch(TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(Requisition_dropdown,driver);
            localHelper.clickElement(Requisition_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(Requisition_dropdown_values,getRandomValue,driver);
            localHelper.clickElement(dropdown_Values,driver);
        }
    }

    private void selectInstallmentType() {
        try{
            localHelper.scrollIntoView(installment_dropdown,driver);
            localHelper.clickElement(installment_dropdown,driver);
            //getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            //localHelper.jsExecutorSendValue(installment_dropdown_values,getRandomValue,driver);
            localHelper.clickElement(dropdown_First_First_Values,driver);
        }catch(TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(installment_dropdown,driver);
            localHelper.clickElement(installment_dropdown,driver);
            getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(installment_dropdown_values,getRandomValue,driver);
            localHelper.clickElement(dropdown_First_First_Values,driver);
        }
    }

    public void enterNumberOfDaysWeeksMonths(String value) {
        localHelper.scrollIntoView(probationNumber_txt,driver);
        localHelper.sendKeys(probationNumber_txt,value,driver);
    }

//  public void enterProbationEndDate(String value){  localHelper.sendKeys(probationEndDate_txt,value,driver);   }

//  public void selectCompensationPayType(String value){ localHelper.jsExecutorSendValue();(compensationPayType_dropdown,value,driver);    }
    public void enterCompensationStatutoryInstallments(String value){
        localHelper.sendKeys(compensationStatutoryInstallments_txt,value,driver);
    }
    public void selectFrequency(){
         try{
             localHelper.scrollIntoView(postalCode_txt,driver);
            localHelper.clickElement(frequency_dropDown,driver);
           // getRandomValue = localHelper.getRandomElement(dropdown_First_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(frequency_dropDown,"Daily",driver);
            localHelper.clickElement(dropdown_First_Values,driver);
        }catch(TimeoutException | ElementNotVisibleException e){
             localHelper.scrollIntoView(postalCode_txt,driver);
             localHelper.clickElement(frequency_dropDown,driver);
             // getRandomValue = localHelper.getRandomElement(dropdown_First_Values,driver).getText().toLowerCase();
             localHelper.jsExecutorSendValue(frequency_dropDown,"Daily",driver);
             localHelper.clickElement(dropdown_First_Values,driver);
        }
    }
    public void selectCurrency(){
        try{
            localHelper.scrollIntoView(postalCode_txt,driver);
            localHelper.clickElement(currency_dropdown,driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_First_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(currency_dropdown,"Aud",driver);
            localHelper.clickElement(dropdown_First_Values,driver);
        }catch(TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(postalCode_txt,driver);
            localHelper.clickElement(currency_dropdown,driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_First_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(currency_dropdown,"Daily",driver);
            localHelper.clickElement(dropdown_First_Values,driver);
        }
    }
    public void enterAdditionalPayment(String value){
        localHelper.sendKeys(compensationAdditionalPayment_txt,value,driver);
    }
    public void enterCompensationAmount(String value){
        localHelper.scrollIntoView(compensationAmount_txt,driver);
        localHelper.sendKeys(compensationAmount_txt,value,driver);
    }
    public void clickAdditionalPaymentCheckbox() {
        localHelper.scrollIntoView(compensationAdditionalPayment_chkbx,driver);
        localHelper.clickElement(compensationAdditionalPayment_chkbx,driver);
    }

    public void selectOvertimeApplicable(){
        localHelper.scrollIntoView(sameAsHomeAddress_checkBox,driver);
        localHelper.clickElement(overtime_dropDown,driver);
        getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
        localHelper.jsExecutorSendValue(overtime_dropDown,getRandomValue,driver);
        localHelper.clickElement(dropdown_Values,driver);
    }

//    public void selectSameAsHomeAddress(){ localHelper.clickElement(sameAsHomeAddress_checkBox,driver);  }

//    public void selectWorkCountry(String value){ localHelper.jsExecutorSendValue();(workCountry_dropdown,value,driver);   }
    public void enterState(String value){
        localHelper.scrollIntoView(state_txt, driver); localHelper.jsExecutorSendValue(state_txt,value,driver);
    }
    public void enterAddressLine1(String value){ localHelper.scrollIntoView(addressLine1_txt, driver); localHelper.jsExecutorSendValue(addressLine1_txt,value,driver);}
    public void enterAddressLine2(String value){ localHelper.jsExecutorSendValue(addressLine2_txt,value,driver);}
    public void enterCity(String value){ localHelper.scrollIntoView(city_txt, driver);localHelper.jsExecutorSendValue(city_txt,value,driver);}
    public void enterPostalCode(String value){ localHelper.jsExecutorSendValue(postalCode_txt,value,driver);}

    public void enterEmployerNumberOfDaysWeeksMonths(String value){
        localHelper.scrollIntoView(numberOfDaysWeeksMonths2_txt,driver);
        localHelper.jsExecutorSendValue(numberOfDaysWeeksMonths_txt,value,driver);
    }

    public void selectEmployerNoticePeriodUnit_dropdown(){
       try {
           localHelper.scrollIntoView(employerNoticePeriodUnit_dropdown,driver);
           localHelper.clickElement(employerNoticePeriodUnit_dropdown,driver);
           getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
           localHelper.jsExecutorSendValue(employerNoticePeriodUnit_dropdown,getRandomValue,driver);
           localHelper.clickElement(dropdown_Values,driver);
       }
       catch (TimeoutException | ElementNotVisibleException e){
           localHelper.clickElement(employerNoticePeriodUnit_dropdown,driver);
           getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
           localHelper.jsExecutorSendValue(employerNoticePeriodUnit_dropdown,getRandomValue,driver);
           localHelper.clickElement(dropdown_Values,driver);
           logger.info("clicked using catch");
       }

    }

    public void enterEmployeeNumberOfDaysWeeksMonths(String value){ localHelper.scrollIntoView(numberOfDaysWeeksMonths2_txt,driver);localHelper.jsExecutorSendValue(numberOfDaysWeeksMonths2_txt,value,driver);}

    public void selectEmployeeNoticePeriodUnit_dropdown(){
        localHelper.scrollIntoView(employeeNoticePeriodUnit_dropdown,driver);
        localHelper.clickElement(employeeNoticePeriodUnit_dropdown,driver);
        getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
        localHelper.jsExecutorSendValue(employeeNoticePeriodUnit_dropdown,getRandomValue,driver);
        localHelper.clickElement(dropdown_Values,driver);
    }

    public void enterRetirementAge(String value){
        localHelper.scrollIntoView(retirementAge_txt,driver);
        localHelper.jsExecutorSendValue(retirementAge_txt,value,driver);}

    public void enterLPPID(String value){
        try{
            localHelper.scrollIntoView(lppid,driver);
            localHelper.jsExecutorSendValue(lppid,value,driver);
        }catch(TimeoutException | ElementNotVisibleException e){
        localHelper.scrollIntoView(lppid,driver);
        localHelper.jsExecutorSendValue(lppid,value,driver);
    }}


    public void selectNonCompete(boolean value) {
        localHelper.scrollIntoView(next_btn,driver);
        if(value)
            localHelper.clickElement(nonCompeteYes_radio,driver);
        else
            localHelper.clickElement(nonCompeteNo_radio,driver);
    }

    public void selectCollectiveAgreement(boolean value) {
        if(value)
            localHelper.clickElement(collectiveAgreementYes_radio,driver);
        else
            localHelper.clickElement(collectiveAgreementNo_radio,driver);
    }

    public void jsScroll()  {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        new JobDetails_Page(driver).enterRetirementAge(faker.numerify("##"));
        logger.info("Page scrolled Successfully");
    }

    public void clickingNextButton(){
        verifyJobDetailStepper();
        localHelper.scrollIntoView(next_btn, driver);
        localHelper.jsExecutorClick(next_btn,driver);
    }

    public void clickNextButton(String role) {
        verifyJobDetailStepper();
        localHelper.scrollIntoView(next_btn, driver);
        localHelper.jsExecutorClick(next_btn,driver);
        if(role.equals("INTERNAL HR"))   {
        try{
                if(localHelper.checkLoader(atlas_Loader,driver)){
                   try{
                       verifyBankStepURL();
                       logger.info("Bank Stepper URL is verified");
                   }catch(TimeoutException | AssertionError e){
                       localHelper.scrollIntoView(next_btn, driver);
                       localHelper.jsExecutorClick(next_btn,driver);
                       logger.info("Error occurred, Moving to Next Stepper");
                   }

                } else  {
                    localHelper.scrollIntoView(next_btn, driver);
                    localHelper.jsExecutorClick(next_btn,driver);
                    verifyBankStepURL();
                }
            }catch(TimeoutException | ElementNotVisibleException e){
                localHelper.scrollIntoView(next_btn, driver);
                localHelper.jsExecutorClick(next_btn,driver);
                logger.info("Job Details Next button is clicked using Catch");
            }}
        }


    public void navigateToNextPage(String role) {

        verifyJobDetailStepper();
        //new Profile_Page(driver).waitUntilChangeStatusButtonPresent();

        //Employment Details section
        enterTargetStartDate(sdf.format(faker.date().past(10,TimeUnit.DAYS)));
        selectEmploymentType();
        if(role.equalsIgnoreCase("INTERNAL HR")){
            enterAtlasStartDate(sdf.format(faker.date().past(20,TimeUnit.DAYS)));
        }
        enterSeniorityDate(sdf.format(faker.date().past(30,TimeUnit.DAYS)));
        enterJobTitle(faker.job().position());
        enterWorkingHours(String.valueOf(faker.number().randomDigitNotZero()));

        /*if(role.equals("INTERNAL HR")){
            localHelper.scrollIntoView(probationYes_radio,driver);
            selectManagerName(prop.getProperty("MANAGER_NAME"));
        }else {
            localHelper.scrollIntoView(jobDescription_txt,driver);
            selectManagerName(prop.getProperty("MANAGER_NAME"));
        }*/
        if(role.equals("CLIENT HR")) {
            enterJobDescription(faker.lorem().paragraph());
        }

        //Probation Period
        selectProbation();

        //Compensation
       // if(role.equals("INTERNAL HR")) {
         //   enterLPPID(faker.numerify("####"));
        if(!(role.equals("CLIENT HR"))) {
            selectPayGroup();
        }
        //}
        //selectCurrency();
        selectFrequency();
        enterCompensationAmount(faker.number().digits(3));
        selectInstallments();
      //  enterCompensationStatutoryInstallments(faker.number().digits(2));
       // if(faker.bool().bool()){
        //    clickAdditionalPaymentCheckbox();
         //   enterAdditionalPayment(faker.number().digits(3));
        //}

        //Work Location
        enterState(faker.address().state());
        enterAddressLine1(faker.address().streetAddress());
        enterAddressLine2(faker.address().streetName());
        enterCity(faker.address().city());
        enterPostalCode(faker.address().zipCode());

        //Off-boarding Details
        enterEmployerNumberOfDaysWeeksMonths(faker.number().digit());
        selectEmployerNoticePeriodUnit_dropdown();
        enterEmployeeNumberOfDaysWeeksMonths(faker.number().digit());
        selectEmployeeNoticePeriodUnit_dropdown();

        //Retirement Details
        enterRetirementAge(faker.numerify("##"));
        //selectNonCompete(faker.bool().bool());
       /* if(!role.equals("CLIENT HR")) {
            selectCollectiveAgreement(faker.bool().bool());
        }*/

        // Click the next button
        if(role.equals("CLIENT HR")){
            clickNextButton("CLIENT HR");
        }else{
            clickNextButton("INTERNAL HR");
        }

    }
    public void verifyBankStepURL(){
        new LocalHelper().waitForPageURL(prop.getProperty("BANKING_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("BANKING_PAGE_URL")+prop1.getProperty("EMPLOYEE_ID"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }

}

