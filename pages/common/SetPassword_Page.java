package pages.common;

import helper.LocalHelper;
import objectRepo.commonRepo.SetPassword_Repo;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SetPassword_Page extends SetPassword_Repo {
    protected static final Logger logger = LoggerFactory.getLogger(SetPassword_Page.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;

    public SetPassword_Page(WebDriver driver) {
        this.driver = driver;
    }

    public String getSnackBarText(){
        if(localHelper.verifyElement(message_snackBar,15,driver)){
            return localHelper.getText(message_snackBar,driver);
        }
        return null;
    }

    public void setPassword(String pwd) {
        localHelper.sendKeys(password_input, pwd, driver);
        localHelper.sendKeys(confirmPassword_input, pwd, driver);
        new LoginPage(driver).clickAcknowledgeCheckbox();
        localHelper.clickElement(setPassword_btn, driver);
        // Verify snack bar text value
        if (getSnackBarText() != null) {
            if (getSnackBarText().equalsIgnoreCase("Password Saved Successfully!")) {
                logger.info("Password saved successfully");
            } else {
                logger.info("Text mismatched or any other error occurred");
            }
        } else if (localHelper.verifyEnabledElement(setPassword_btn,driver)){
            localHelper.clickElement(setPassword_btn, driver);
            logger.info("Password is set");
        } else  {
            logger.error("Password is not set");
        }
    }
}