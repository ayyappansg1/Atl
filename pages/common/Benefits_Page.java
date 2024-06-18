package pages.common;

import common.TestUtil;
import helper.LocalHelper;
import objectRepo.commonRepo.BenefitsPage_Repo;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.Properties;

public class Benefits_Page extends BenefitsPage_Repo {

    protected static final Logger logger = LoggerFactory.getLogger(Benefits_Page.class);
    private final LocalHelper localHelper = new LocalHelper();
    Properties prop = new TestUtil().init_Properties("common/URL");
    private final String appURL= System.getProperty("APP_URL");
    private final WebDriver driver;

    public Benefits_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCompensationUrl(String role){

       if (role.equals("INTERNAL HR")) {
            new LocalHelper().waitForPageURL(prop.getProperty("COMPENSATION_PAGE_URL_INTERNAL"), driver);
            Assert.assertEquals(appURL + prop.getProperty("COMPENSATION_PAGE_URL_INTERNAL")+prop.getProperty("EMPLOYEE_ID"), driver.getCurrentUrl(), "Mismatch found in URL of the page loaded");
            logger.info("Internal JobDetails URL is verified");
        }else {
            logger.info("URL Verification is not required");
        }
    }


    public void clickNextButton(String role) {
        if(role.equalsIgnoreCase("CLIENT HR")){
            localHelper.scrollIntoView(save_btn,driver);
            localHelper.clickElement(save_btn,driver);
        }else{
            localHelper.scrollIntoView(next_btn,driver);
            localHelper.clickElement(next_btn,driver);
            verifyCompensationUrl("INTERNAL");
        }
    }
}
