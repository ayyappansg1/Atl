package main.employeeView;

import com.github.javafaker.Faker;
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
import pages.employeeView.*;

import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class FinishStepper_Employee extends BaseTest {
    private EmergencyStepper emergencyStepper;
    Profile_Page profilePage;

    Properties prop = new TestUtil().init_Properties("employeeView/Employee");
    Faker faker;
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {

        Properties mailSac = new TestUtil().init_Properties("email/MailSac");
        Properties auth = new TestUtil().init_Properties("common/Login");

        faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        profilePage = new Profile_Page(driver);

        emergencyStepper = new EmergencyStepper(driver);
        new LoginPage(driver).loginAs("INTERNAL HR");
        // new ListingPageClientHR(driver).switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickAddEmployeeButton();
        new AddEmployee_Page(driver).createEmployeeView("INTERNAL HR");
        new Profile_Page(driver).clickNextButton("INTERNAL HR");
        new JobDetails_Page(driver).enterTargetStartDate(sdf.format(faker.date().past(10, TimeUnit.DAYS)));
        new JobDetails_Page(driver).selectEmploymentType();
        new JobDetails_Page(driver).enterAtlasStartDate(sdf.format(faker.date().past(20,TimeUnit.DAYS)));
        new JobDetails_Page(driver).selectPayGroup();
        new JobDetails_Page(driver).enterCompensationAmount(faker.number().digits(3));
       /* new JobDetails_Page(driver).enterCompensationStatutoryInstallments(faker.number().digits(2));
        if(faker.bool().bool()){
            new JobDetails_Page(driver).clickAdditionalPaymentCheckbox();
            new JobDetails_Page(driver).enterAdditionalPayment(faker.number().digits(3));
        }*/
        new JobDetails_Page(driver).selectFrequency();
        new JobDetails_Page(driver).clickNextButton("INTERNAL HR");
        new Banking_Page(driver).clickNextButton();
        new Documents_Page(driver).navigateToSubmitPage("INTERNAL HR");
        // new Benefits_Page(driver).clickNextButton("INTERNAL HR");
        new Compensation_Page(driver).clickNextButton();
        new TimeOff_Page(driver).clickNextButton();
        new Finish_Page(driver).clickInviteEmployeeToOnboardButton();
        new ListingPage(driver).signOutApplication();
        new MailSacPage(driver).openMailSacPage(mailSac.getProperty("WEB_URL")+AddEmployee_Page.email);
        new MailSacPage(driver).clickEmailInbox();
        new MailSacPage(driver).clickUnblockLink();
        new MailSacPage(driver).loginToMailSac(mailSac.getProperty("USERNAME"),mailSac.getProperty("PASSWORD"));
        new MailSacPage(driver).clickGetStartedBtn();
        new SetPassword_Page(driver).setPassword(auth.getProperty("LOGIN_PWD"));
        new LoginPage(driver).loginAfterReset(AddEmployee_Page.email,auth.getProperty("LOGIN_PWD"));
        new WelcomePage(driver).goToProfileStepper();
        new ProfileStepper(driver).navigateToBankingStepper();
        new Banking_Page(driver).navigateToNextStep();
        new EmergencyStepper(driver).navigateToDocumentsStepper();
        new Documents_Page(driver).clickNextButton("EMPLOYEE");
       // new Benefits_Page(driver).clickNextButton("EMPLOYEE");
    }

    @Description("The test verifies the employee view finish page url")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void verifyEmployeeFinishPageURL(){
        logger.info("#### Running verifyEmployeeFinishPageURL method ####");
        new LocalHelper().waitForPageURL(prop.getProperty("FINISH_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("FINISH_PAGE_URL"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }

    @Description("The test verifies the employee view finish page url")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void navigateToListingPage() {
        logger.info("#### Running navigateToListingPage method ####");

        new Finish_Page(driver).clickSubmitProfileButton();

        // Verify the message

        // Verify the URL
        new LocalHelper().waitForPageURL(prop.getProperty("FINISH_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("FINISH_PAGE_URL"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }

}
