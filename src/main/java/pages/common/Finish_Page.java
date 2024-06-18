package pages.common;

import com.github.javafaker.Faker;
import helper.LocalHelper;
import objectRepo.commonRepo.FinishPage_Repo;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class Finish_Page extends FinishPage_Repo {

    protected static final Logger logger = LoggerFactory.getLogger(Finish_Page.class);
    private final LocalHelper localHelper = new LocalHelper();
    Faker faker = new Faker();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
    private final WebDriver driver;

    public Finish_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void enterComments(String value){ localHelper.jsExecutorSendValue(comment_txt,value,driver); }
    public void clickSubmitButton() {
        try{
            localHelper.scrollIntoView(submit_btn,driver);
            localHelper.jsExecutorClick(submit_btn,driver);
        }catch(TimeoutException | ElementNotVisibleException e){
            localHelper.scrollIntoView(submit_btn,driver);
            localHelper.jsExecutorClick(submit_btn,driver);
        }
    }

    // popup
    public void submitEmployeeProfile(String value) {
        if(value.equals("YES")) {
            localHelper.jsExecutorClick(yesContinue_btn, driver);
        }
        else if (value.equals("NO")) {
            localHelper.jsExecutorClick(cancel_btn, driver);
        }
    }

    public String getProfileCompleteMessage() {
        if(localHelper.checkLoader(atlas_Loader, driver)) {
            return localHelper.getText(profileComplete_msg, driver);
        }
        else{
            return localHelper.getText(profileComplete_msg, driver);
        }
    }
    public void clickInviteEmployeeToOnboardButton() {

        // Verify snack-bar msg
        if(localHelper.checkLoader(atlas_Loader,driver)){
        try{
            localHelper.jsExecutorClick(inviteEmployee_btn,driver);
            getProfileCompleteMessage();
        }catch(NoSuchElementException m){
            m.printStackTrace();
        }
        /*catch (TimeoutException | NoSuchElementException e){
            try {
                logger.error("No Snackbar Found");
                localHelper.jsExecutorClick(inviteEmployee_btn, driver);
                getProfileCompleteMessage();
            }catch (TimeoutException | NoSuchElementException l){
                logger.error("Again No Snackbar Found");
                localHelper.jsExecutorClick(inviteEmployee_btn, driver);
                getProfileCompleteMessage();
            }
        }*/
         // verify profile complete msg
    }}
    public void clickSubmitProfileButton() { localHelper.clickElement(submitProfile_button,driver);   }

    public void clickChangeStatusButton(){
        localHelper.clickElement(changeStatus_button,driver);
    }
    public void enterEffectiveDate(String value){
        // localHelper.scrollIntoView(atlasStartDate_datePicker,driver);
        if(value==null){
            localHelper.sendKeys(effectiveDate_datePicker, sdf.format(faker.date().past(30, TimeUnit.DAYS)),driver);
        }else{
            localHelper.sendKeys(effectiveDate_datePicker,value,driver);
        }
    }
    public void enterAtlasStartDate(String value){
        // localHelper.scrollIntoView(atlasStartDate_datePicker,driver);
        if(localHelper.verifyEnabledElement(atlasStartDate_datePicker,driver)){
        if(value==null){
            localHelper.sendKeys(atlasStartDate_datePicker, sdf.format(faker.date().past(30, TimeUnit.DAYS)),driver);
        }else{
            localHelper.sendKeys(atlasStartDate_datePicker,value,driver);
        }
    }}

    public void selectActive(){
    localHelper.scrollIntoView(newStatus_DropDown,driver);
    localHelper.clickElement(newStatus_DropDown,driver);
    localHelper.clickElement(active_status,driver);
    }
    public void saveStatusChange(){
        localHelper.scrollIntoView(saveStatusChange_button,driver);
        localHelper.clickElement(saveStatusChange_button,driver);
    }
    public String getCompleteMessage(){
      return   localHelper.getText(completeMessage,driver);
    }
}
