package pages.common;

import common.TestUtil;
import helper.LocalHelper;
import objectRepo.commonRepo.Documents_Repo;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.Properties;

public class Documents_Page extends Documents_Repo {

    protected static final Logger logger = LoggerFactory.getLogger(Documents_Page.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final String appURL= System.getProperty("APP_URL");
    private final WebDriver driver;

    String getRandomValue;

    Properties prop = new TestUtil().init_Properties("employeeView/employee");

    public Documents_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCountryProject() {
       // if(
        localHelper.checkLoader(atlas_Loader,driver);
        try {
            localHelper.scrollIntoView(countryProject_dropdown,driver);
            localHelper.clickElement(countryProject_dropdown,driver);
            if(localHelper.checkLoader(noOptions_popupDropdownTxt,driver,"No Options")){
                getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
                localHelper.jsExecutorSendValue(countryProject_dropdown,getRandomValue,driver);
                localHelper.clickElement(dropdown_Values,driver);
            }else{
                logger.info("No values in the dropdown - country project");
            }
        }
        catch (TimeoutException | ElementNotVisibleException | ElementClickInterceptedException e){
            //pageScroll();
            localHelper.scrollIntoView(documents_Header,driver);
            if (localHelper.verifyEnabledElement(countryProject_dropdown,driver)){
            localHelper.scrollIntoView(countryProject_dropdown,driver);
            localHelper.clickElement(countryProject_dropdown,driver);
            if(localHelper.checkLoader(noOptions_popupDropdownTxt,driver,"No Options")){
                getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
                localHelper.jsExecutorSendValue(countryProject_dropdown,getRandomValue,driver);
                localHelper.clickElement(dropdown_Values,driver);
                logger.info("Country Project is Scrolled and Clicked Using Catch");
        }
          /*  else{
                logger.info("Time Exceeded");
            }*/
    }}}

    public void pageScroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-1000)");
    }
    public void selectCountryTemplate(String value) {
        if(value==null){
            if(localHelper.verifyEnabledElement(countryTemplate_dropdown,driver)){
                    localHelper.clickElement(countryTemplate_dropdown,driver);
                if(localHelper.checkLoader(dropdown_Values_first,driver,"No Options")){
                   // getRandomValue = localHelper.getRandomElement(dropdown_Values,driver).getText().toLowerCase();
                    //localHelper.scrollIntoView(dropdown_Values,driver);
                    localHelper.clickElement(dropdown_Values_first,driver);
                }else{
                    logger.info("No values in the dropdown - country template");
                }
            }
        }else{
            localHelper.dropDownSelectByText(countryTemplate_dropdown,value,driver);
        }
    }

    public void clickConfirmTemplateSelectionButton(){
        if(localHelper.verifyEnabledElement(confirmTemplate_btn,driver)){
            localHelper.jsExecutorClick(confirmTemplate_btn,driver);
        }
    }

    public String verifyTemplateSelectionConfirmed() throws InterruptedException {
        if(localHelper.verifyElement(selectionConfirmed_text,driver)){
            return localHelper.getText(selectionConfirmed_text,driver);
        }
        return null;
    }

    public void clickTaskCheckbox(){ localHelper.clickElement(allTask_checkbox,driver);  }
    public void clickOkPopup(){ localHelper.sendKeys(popupOk,"src/test/resources/propertyFiles/common/sample.pdf",driver);  }


    public void clickNextButton(String role) {
        verifyDocumentsStepper();
           if(role.equals("INTERNAL HR")) {
               localHelper.scrollIntoView(next_btn_internal, driver);
               localHelper.clickElement(next_btn_internal, driver);
               if(localHelper.verifyElement(gotIt_btnInPopup, 5,driver)){
                   localHelper.jsExecutorClick(gotIt_btnTxtInPopup,driver);
                   if(localHelper.getText(uploadPending_text, driver).contains("document upload pending")){
                       String var = localHelper.getText(uploadPending_text, driver);
                       logger.info(var);
                       localHelper.scrollIntoView(uploadPending_checkBox,driver);
                       localHelper.multipleClicks(uploadPending_checkBox,driver);
                   }
                   localHelper.scrollIntoView(next_btn_internal,driver);
                   localHelper.jsExecutorClick(next_btn_internal,driver);
               }
           }else if(role.equalsIgnoreCase("EMPLOYEE")){
               try {
                       localHelper.scrollIntoView(next_btn_employee,driver);
                       localHelper.clickElement(next_btn_employee, driver);
                       localHelper.clickElement(yesContinue_btnInPopup, driver);
                       verifyFinishStepperURL();
               }catch (TimeoutException | ElementNotVisibleException e){
                   localHelper.scrollIntoView(next_btn_employee,driver);
                   localHelper.clickElement(next_btn_employee, driver);
                   localHelper.clickElement(yesContinue_btnInPopup,driver);
                   logger.info("Document page is clicked using Catch");
                   verifyFinishStepperURL();
               }
           }
           else{
               localHelper.scrollIntoView(next_btn, driver);
               localHelper.jsExecutorClick(next_btn, driver);
               verifyFinishStepperURL();
           }
       }

    public void navigateToSubmitPage(String role) {
        if(role.equals("INTERNAL HR")) {
            selectCountryProject();
           // if(localHelper.verifyEnabledElement(countryTemplate_dropdown,driver)) {
          //      selectCountryTemplate(null);
                clickConfirmTemplateSelectionButton();
            //}
            clickTaskCheckbox();
        }
        clickNextButton(role);
    }
    public void verifyDocumentsStepper() {
        try {
            if(localHelper.getText(documentStepper,driver).equalsIgnoreCase("Documents")){
                logger.info("We are in Documents stepper");
            }else{
                logger.info("Documents page has not opened");
            }
        }catch (NoSuchElementException | TimeoutException e){
            logger.error("Documents stepper is not appearing ");
            if(localHelper.getText(documentStepper,driver).equalsIgnoreCase("Documents")){
                logger.info("We are in Documents stepper");
            }
        }

    }

    public void verifyFinishStepperURL(){
        new LocalHelper().waitForPageURL(prop.getProperty("FINISH_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("FINISH_PAGE_URL"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }
}
