package pages.employeeView;

import helper.LocalHelper;
import objectRepo.employeeViewRepo.WelcomePage_Repo;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class WelcomePage extends WelcomePage_Repo {

    protected static final Logger logger = LoggerFactory.getLogger(WelcomePage.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;

    public WelcomePage(WebDriver driver) {
        this.driver = driver;
    }

   // public void clickViewProfile(){ localHelper.clickElement(profile_icon,driver); localHelper.clickElement(viewProfile_btn,driver);    }

    public void goToProfileStepper() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        try {
            if(localHelper.verifyEnabledElement(getStarted_btn,driver)){
                localHelper.jsExecutorClick(getStarted_btn,driver);
            }
        }
        catch (NoSuchElementException e){
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            try {
                if(localHelper.verifyEnabledElement(completeOnboarding_btn,driver)){
                    localHelper.jsExecutorClick(completeOnboarding_btn,driver);
                }
            }
            catch (NoSuchElementException s){
                if(localHelper.verifyEnabledElement(getStarted_btn,driver)){
                    localHelper.scrollIntoView(getStarted_btn,driver);
                    localHelper.jsExecutorClick(getStarted_btn,driver);
                }
                else{
                    logger.info("No buttons are displayed");
                }
            }
        }
    }


}
