package main.employeeView;

import common.BaseTest;
import common.TestUtil;
import email.emailPage.MailSacPage;
import helper.LocalHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.ListingPage;
import pages.common.*;
import pages.employeeView.WelcomePage;
import java.util.Properties;

public class WelcomePage_Employee extends BaseTest {
    private WelcomePage welcomePage;
    Properties auth = new TestUtil().init_Properties("common/Login");
    Properties mailSac = new TestUtil().init_Properties("email/MailSac");
    Properties prop = new TestUtil().init_Properties("employeeView/Employee");
    Profile_Page profilePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        welcomePage = new WelcomePage(driver);
        profilePage = new Profile_Page(driver);
        new LoginPage(driver).loginAs("INTERNAL HR");
       // new ListingPageClientHR(driver).switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickAddEmployeeButton();
        new AddEmployee_Page(driver).createEmployeeView("INTERNAL HR");
        new Profile_Page(driver).clickNextButton("INTERNAL HR");
        new JobDetails_Page(driver).jsScroll();
        new JobDetails_Page(driver).clickNextButton("INTERNAL HR");
        new Banking_Page(driver).clickNextButton();
        new Documents_Page(driver).navigateToSubmitPage("INTERNAL HR");
       // new Benefits_Page(driver).clickNextButton("INTERNAL HR");
        new Compensation_Page(driver).clickNextButton();
        new Finish_Page(driver).clickInviteEmployeeToOnboardButton();
        new ListingPage(driver).signOutApplication();
        new MailSacPage(driver).openMailSacPage(mailSac.getProperty("WEB_URL")+AddEmployee_Page.email);
        new MailSacPage(driver).clickEmailInbox();
        new MailSacPage(driver).clickUnblockLink();
        new MailSacPage(driver).loginToMailSac(mailSac.getProperty("USERNAME"),mailSac.getProperty("PASSWORD"));
        new MailSacPage(driver).clickGetStartedBtn();
        new SetPassword_Page(driver).setPassword(auth.getProperty("LOGIN_PWD"));
        new LoginPage(driver).loginAs(AddEmployee_Page.email,auth.getProperty("LOGIN_PWD"));
    }

    @Description("The test verifies the employee view page url")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void verifyEmployeeWelcomePageURL(){
        logger.info("#### Running verifyEmployeeWelcomePageURL method ####");
        Assert.assertEquals(appURL+prop.getProperty("WELCOME_PAGE_URL"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }

    @Description("The test verifies go to the profile stepper")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void verifyGoToProfileStepper() {
        logger.info("#### Running verifyGoToProfileStepper method ####");


        // Verify click either Get Started or Complete On-boarding button
        welcomePage.goToProfileStepper();
        new LocalHelper().waitForPageURL(prop.getProperty("PROFILE_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("PROFILE_PAGE_URL"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }

}
