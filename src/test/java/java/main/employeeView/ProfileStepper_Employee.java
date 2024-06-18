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
import pages.employeeView.ProfileStepper;
import pages.employeeView.WelcomePage;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ProfileStepper_Employee extends BaseTest {

    private ProfileStepper profileStepper;
    Properties mailSac = new TestUtil().init_Properties("email/MailSac");
    Properties prop = new TestUtil().init_Properties("employeeView/Employee");

    Profile_Page profilePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
        Properties auth = new TestUtil().init_Properties("common/Login");
        profileStepper = new ProfileStepper(driver);
        profilePage = new Profile_Page(driver);
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
      //  new JobDetails_Page(driver).enterCompensationStatutoryInstallments(faker.number().digits(2));
      /*  if(faker.bool().bool()){
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
    }

//    @Description("The test verifies the employee view profile page url")
//    @Owner("sundara.p@thinkpalm.com")
//    @Test(groups = {"Regression"})
//    public void verifyEmployeeProfilePageURL() {
//        logger.info("#### Running verifyEmployeeProfilePageURL method ####");
//        profileStepper.getProfileStepper();
//        new LocalHelper().waitForPageURL(prop.getProperty("PROFILE_PAGE_URL"),driver);
//        Assert.assertEquals(appURL+prop.getProperty("PROFILE_PAGE_URL"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
//    }

    @Description("The test verifies the employee view profile page fields enabled")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void verifyEnabledFieldInProfileStepper() {
        logger.info("#### Running verifyEnabledFieldInProfileStepper method ####");

        // Verify the disabled fields
        Assert.assertFalse(profileStepper.firstNameInputIsPresent(),"First Name field is should not be enabled");
        Assert.assertFalse(profileStepper.surNameInputIsPresent(),"Sur Name field is should not be enabled");
        Assert.assertFalse(profileStepper.personalEmailInputIsPresent(),"Personal email field should not be enabled");

        // Verify the enabled fields
        Assert.assertTrue(profileStepper.titleDropdownIsPresent(),"Title dropdown field is missing");
       // Assert.assertTrue(profileStepper.additionalGivenNameInputIsPresent(),"Additional Given Name(s) field is missing");
        Assert.assertTrue(profileStepper.genderDropdownIsPresent(),"Gender dropdown is missing");
        Assert.assertTrue(profileStepper.maritalStatusDropDownIsPresent(),"Marital Status dropdown is missing");
        Assert.assertTrue(profileStepper.dateOfBirthInputIsPresent(),"Date of birth field is missing");
        Assert.assertTrue(profileStepper.taxIdInputIsPresent(),"Tax Id field is missing");
        Assert.assertTrue(profileStepper.preferredNameInputIsPresent(),"Preferred name field is missing");

        Assert.assertTrue(profileStepper.countryOfCitizenshipDropdownIsPresent(),"Country of citizenship dropdown is missing");
        Assert.assertTrue(profileStepper.nationalIdInputIsPresent(),"National Id field is missing");

        Assert.assertTrue(profileStepper.countryOfResidenceDropdownIsPresent(),"Country Of Residence Dropdown is missing");
        Assert.assertTrue(profileStepper.stateInputIsPresent(),"State field is missing");
        Assert.assertTrue(profileStepper.addressLine1InputIsPresent(),"Address Line 1 field is missing");
        Assert.assertTrue(profileStepper.addressLine2InputIsPresent(),"Address Line 2 field is missing");
        Assert.assertTrue(profileStepper.cityInputIsPresent(),"City field is missing");
        Assert.assertTrue(profileStepper.postalCodeIsPresent(),"Postal Code field is missing");

        Assert.assertTrue(profileStepper.workPhoneCountryCodeDropdownIsPresent(),"Work Phone CountryCode Dropdown is missing");
        Assert.assertTrue(profileStepper.workPhoneNumberInputIsPresent(),"Work Phone Number field is missing");
        Assert.assertTrue(profileStepper.mobileCountryCodeDropdownIsPresent(),"Mobile CountryCode Dropdown is missing");
        Assert.assertTrue(profileStepper.mobileNumberInputIsPresent(),"Mobile Number field is missing");
        Assert.assertTrue(profileStepper.homePhoneCountryCodeDropdownIsPresent(),"Home Phone CountryCode field is missing");
        Assert.assertTrue(profileStepper.homePhoneNumberInputIsPresent(),"Home Phone Number field is missing");
       // Assert.assertFalse(profileStepper.workEmailInputIsPresent(),"Work Email field is missing");

    }

    @Description("The test verifies the navigation to Job details page after filling the fields")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void navigateToBankingStepper() {

        logger.info("#### Running navigateToBankingStepper method ####");

        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

        // Personal Information
        profileStepper.selectTitleFromDropdown();
        //profileStepper.enterAdditionalGivenName(faker.name().suffix().replaceAll("[-+.^:,`' =]",""));
        profileStepper.enterPreferredName(faker.name().username());
        profileStepper.enterSuffix(faker.name().suffix());
        profileStepper.selectGenderFromDropdown();
        profileStepper.selectMaritalStatusFromDropdown();
        profileStepper.selectDOB(sdf.format(faker.date().birthday()));
        profileStepper.enterTaxId(faker.finance().bic());

        // Citizenship
        profileStepper.selectCountryOfCitizenshipFromDropdown();
        profileStepper.enterNationalId(faker.idNumber().valid());
        profileStepper.clickNoButtonInMoreThanOneCitizenship();
        profileStepper.clickYesButtonInLegallyAuthorized();

        // Home Address
        profileStepper.enterAddressLine1(faker.address().streetAddress());
        profileStepper.enterCity(faker.address().city());
        profileStepper.enterPostalCode(faker.address().zipCode());

        // Contact Details
        profileStepper.enterHomeNumber(faker.numerify("#######"));
        profileStepper.enterMobileNumber(faker.numerify("#######"));
        profileStepper.enterWorkNumber(faker.numerify("#######"));
        //profileStepper.enterWorkEmail(faker.internet().safeEmailAddress());

        // Click Next button
        profileStepper.clickNextButton();

        // Verify Go to the next stepper
        new LocalHelper().waitForPageURL(prop.getProperty("BANKING_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("BANKING_PAGE_URL"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");

    }
}
