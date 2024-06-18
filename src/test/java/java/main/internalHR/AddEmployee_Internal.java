package main.internalHR;

import com.github.javafaker.Faker;
import common.BaseTest;
import common.TestUtil;
import helper.LocalHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import objectRepo.commonRepo.AddEmployee_Repo;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.ListingPage;
import pages.common.AddEmployee_Page;
import pages.common.LoginPage;
import java.util.Properties;

public class AddEmployee_Internal extends BaseTest {

    Properties messages = new TestUtil().init_Properties("common/CommonProp");
    AddEmployee_Page addEmployeePage;
    Faker faker;
    LocalHelper localHelper = new LocalHelper();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        addEmployeePage = new AddEmployee_Page(driver);
        faker = new Faker();
        new LoginPage(driver).loginAs("INTERNAL HR");
        //new ListingPageClientHR(driver).switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickAddEmployeeButton();
    }

    @Description("Verify the mandatory error messages")
    @Owner("nayana.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void verifyMandatoryErrorMessages() throws InterruptedException {
        logger.info("### Running verifyMandatoryErrorMessages method ###");
        addEmployeePage.enterCustomer(messages.getProperty("CUSTOMER"));
        addEmployeePage.enterWorkCountry(messages.getProperty("COUNTRY"));
        Assert.assertTrue(addEmployeePage.firstNameField_isPresent(),"First Name field is missing");
        Assert.assertTrue(addEmployeePage.surnameField_isPresent(),"Surname field is missing");
        Assert.assertTrue(addEmployeePage.personalEmailField_isPresent(),"personal email field is missing");
        Assert.assertTrue(addEmployeePage.workCountryField_isPresent(),"Work country field is missing");
        Assert.assertTrue(addEmployeePage.residenceCountryField_isPresent(),"Residence country field is missing");

        addEmployeePage.tabThroughFields();
        Assert.assertTrue(addEmployeePage.getFirstNameValidationErrorMsg().contains(messages.getProperty("MANDATORY_ERROR_MESSAGE")),"First Name - Mandatory message is changed or the message is not displayed");
        Assert.assertTrue(addEmployeePage.getSurnameValidationErrorMsg().contains(messages.getProperty("MANDATORY_ERROR_MESSAGE")),"Surname - Mandatory message is changed or the message is not displayed");
        Assert.assertTrue(addEmployeePage.getPersonalMailValidationErrorMsg().contains(messages.getProperty("MANDATORY_ERROR_MESSAGE")),"Personal Mail - Mandatory message is changed or the message is not displayed");
    }

    @Description("Verify the navigation to Profile page")
    @Owner("nayana.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void addNewEmployee() {
        logger.info("### Running addNewEmployee method ###");

        localHelper.clickElement(new AddEmployee_Repo().closeIcon,driver);
        new ListingPage(driver).clickAddEmployeeButton();

        addEmployeePage.enterFirstName(faker.name().firstName());
        addEmployeePage.enterSurname(faker.name().lastName());
        addEmployeePage.enterCustomer(messages.getProperty("CUSTOMER"));
        addEmployeePage.enterPersonalMail(faker.internet().emailAddress());
        addEmployeePage.enterWorkCountry(messages.getProperty("COUNTRY"));
        addEmployeePage.enterResidenceCountry();

        addEmployeePage.clickContinueToProfile();
        Assert.assertTrue(addEmployeePage.profilePageContainerIsPresent(),"Profile page did not get loaded");
    }

    @Description("Verify the validation error messages")
    @Owner("nayana.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void verifyValidationErrorMessages() throws InterruptedException {
        logger.info("### Running verifyValidationErrorMessages method ###");
        addEmployeePage.enterCustomer(messages.getProperty("CUSTOMER"));
        addEmployeePage.enterWorkCountry(messages.getProperty("COUNTRY"));
        addEmployeePage.enterFirstName(messages.getProperty("INVALID_INPUT"));
        addEmployeePage.enterSurname(messages.getProperty("INVALID_INPUT"));
        addEmployeePage.enterPersonalMail(messages.getProperty("INVALID_INPUT"));
        addEmployeePage.tabThroughFields();

        Assert.assertEquals(addEmployeePage.getFirstNameValidationErrorMsg(),messages.getProperty("VALIDATION_ERROR_MESSAGE"),"Mismatch in validation error message");
        Assert.assertEquals(addEmployeePage.getSurnameValidationErrorMsg(),messages.getProperty("VALIDATION_ERROR_MESSAGE"),"Mismatch in validation error message");
        Assert.assertTrue(addEmployeePage.getPersonalMailValidationErrorMsg().contains(messages.getProperty("EMAIL_VALIDATION_ERROR_MESSAGE")),"Mismatch in validation error message");
    }
}
