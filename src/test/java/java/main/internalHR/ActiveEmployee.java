package main.internalHR;

import common.BaseTest;
import common.TestUtil;
import email.emailPage.MailSacPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.ListingPage;
import pages.common.*;
import pages.employeeView.EmergencyStepper;
import pages.employeeView.ProfileStepper;
import pages.employeeView.WelcomePage;

import java.sql.Time;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ActiveEmployee extends BaseTest {

    ListingPage listingPage;

    Properties prop = new TestUtil().init_Properties("employeeView/Employee");

    Properties prop1 = new TestUtil().init_Properties("clientHR/ListingPageClientHR");

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {

        new LoginPage(driver).loginAs("INTERNAL HR");
        new ListingPage(driver).switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
    }


    @Description("Adding New Employee and completing the employee profile")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test( groups = {"Regression"}, priority = 1)
    public void employeeProfile() throws InterruptedException {
        Properties mailSac = new TestUtil().init_Properties("email/MailSac");
        Properties auth = new TestUtil().init_Properties("common/Login");

        new ListingPage(driver).clickAddEmployeeButton();
        new AddEmployee_Page(driver).createEmployeeView("INTERNAL HR");
        new Profile_Page(driver).clickNextButton("INTERNAL HR");
       // new JobDetails_Page(driver).jsScroll();
        new JobDetails_Page(driver).selectPayGroup();
        new JobDetails_Page(driver).selectFrequency();
        new JobDetails_Page(driver).clickNextButton("INTERNAL HR");
        new Banking_Page(driver).clickNextButton();
        new Documents_Page(driver).navigateToSubmitPage("INTERNAL HR");
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
        new LoginPage(driver).loginAs(AddEmployee_Page.email,auth.getProperty("LOGIN_PWD"));
        new WelcomePage(driver).goToProfileStepper();
        new ProfileStepper(driver).navigateToBankingStepper();
        new Banking_Page(driver).click_BankCountry();
        new Banking_Page(driver).clickNextButton();
        new Banking_Page(driver).checkWarningForMissedFields();
        new EmergencyStepper(driver).navigateToDocumentsStepper();
        new Documents_Page(driver).clickNextButton("EMPLOYEE");
        new Finish_Page(driver).clickSubmitProfileButton();
    }

    @Description("Change status of employee to Active")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test( groups = {"Regression"}, priority = 2)
    public void changeStatus() throws InterruptedException {

        listingPage = new ListingPage(driver);
        listingPage.clickSearchInput();
        String mail = prop.getProperty("EMPLOYEE_EMAIL");
        listingPage.performSearchBy(mail);
        Assert.assertTrue(listingPage.clearAll_IsPresent(),"Clear All filter is not visible");
        // Verifying the search results
        Assert.assertEquals(listingPage.searchByIdIsSuccessful(prop.getProperty("EMPLOYEE_ID")),prop.getProperty("EMPLOYEE_ID"),"Id search is not working");
        logger.info("ID is verified");
        Assert.assertEquals(listingPage.checkActiveStatus(prop1.getProperty("STATUS_FINAL_REVIEW")),prop1.getProperty("STATUS_FINAL_REVIEW"),"Status selected option is not displayed ");
        logger.info("Status is verified");
        listingPage.clickName();
        new Profile_Page(driver).navigateToJobDetails("INTERNAL HR");
        new Profile_Page(driver).clickNextButton("INTERNAL HR");
        new JobDetails_Page(driver).navigateToNextPage("INTERNAL HR");
        new Banking_Page(driver).navigateToNextStep();
        new Documents_Page(driver).clickNextButton("INTERNAL HR");
        new Compensation_Page(driver).navigateToFinishPage();
        new Finish_Page(driver).clickChangeStatusButton();
        new Finish_Page(driver).enterEffectiveDate("sdf.format(faker.date().past(20,TimeUnit.DAYS))");
        new Finish_Page(driver).selectActive();
        new Finish_Page(driver).enterAtlasStartDate("sdf.format(faker.date().past(20,TimeUnit.DAYS))");
        new Finish_Page(driver).saveStatusChange();
    }
    }

