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

public class EmergencyStepper_Employee extends BaseTest {

    private EmergencyStepper emergencyStepper;

    Faker faker;
    Profile_Page profilePage;
    Properties prop = new TestUtil().init_Properties("employeeView/Employee");
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
    }


    @Description("The test verifies the employee view emergency page url")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void verifyEmployeeEmergencyPageURL(){
        logger.info("#### Running verifyEmployeeEmergencyPageURL method ####");
        new LocalHelper().waitForPageURL(prop.getProperty("EMERGENCY_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("EMERGENCY_PAGE_URL"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }

    @Description("The test verifies the employee view required fields")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void verifyAllEmergencyFields() {
        logger.info("#### Running verifyAllEmergencyFields method ####");
        Assert.assertTrue(emergencyStepper.emergencyFirstNameIsPresent(), "Emergency First Name field is missing");
        Assert.assertTrue(emergencyStepper.emergencyLastNameIsPresent(), "Emergency Last Name field is missing");
        Assert.assertTrue(emergencyStepper.relationshipDropDownIsPresent(), "Relationship dropdown field is missing");
        //Assert.assertTrue(emergencyStepper.homePhoneIsPresent(), "Home Phone field is missing");
        Assert.assertTrue(emergencyStepper.mobileIsPresent(), "Mobile field is missing");
        //Assert.assertTrue(emergencyStepper.workPhoneIsPresent(), "Work phone field is missing");
        //Assert.assertTrue(emergencyStepper.countryDropDownIsPresent(), "Country dropdown field is missing");
        //Assert.assertTrue(emergencyStepper.addressLine1IsPresent(), "Address Line 1 field is missing");
        //Assert.assertTrue(emergencyStepper.addressLine2IsPresent(), "Address Line 2 field is missing");
        //Assert.assertTrue(emergencyStepper.stateIsPresent(), "State field is missing");
        //Assert.assertTrue(emergencyStepper.cityIsPresent(), "City field is missing");
        //Assert.assertTrue(emergencyStepper.postalCodeIsPresent(), "Postal code field is missing");
    }

    @Description("The test verifies navigates to next stepper")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void navigateToDocumentsStepper() {
        
        logger.info("#### Running navigateToDocumentsStepper method ####");

        emergencyStepper.enterEmergencyFirstName(faker.name().firstName());
        emergencyStepper.enterEmergencyLastName(faker.name().lastName());
        emergencyStepper.selectRelationshipFromDropdown();

       // emergencyStepper.enterHomePhone(faker.numerify("#######"));
        emergencyStepper.enterMobileCode();
        emergencyStepper.enterMobile(faker.numerify("#########"));
        //emergencyStepper.enterWorkPhone(faker.numerify("#######"));

        emergencyStepper.enterEmail(faker.internet().emailAddress());

        /*emergencyStepper.selectCountryFromDropdown();
        emergencyStepper.enterState(faker.address().state());
        emergencyStepper.enterAddressLine1(faker.address().streetAddress());
        emergencyStepper.enterCity(faker.address().city());
        emergencyStepper.enterPostalCode(faker.address().zipCode());*/

        emergencyStepper.clickNextButton();

        new LocalHelper().waitForPageURL(prop.getProperty("DOCUMENTS_PAGE_URL"),driver);
        Assert.assertEquals(appURL + prop.getProperty("DOCUMENTS_PAGE_URL"), driver.getCurrentUrl(), "Mismatch found in URL of the page loaded");
    }


}

