package main.clientHR;

import com.github.javafaker.Faker;
import common.BaseTest;
import common.TestUtil;
import helper.LocalHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.ListingPage;
import pages.common.AddEmployee_Page;
import pages.common.LoginPage;
import pages.common.Profile_Page;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class Profile_Client extends BaseTest {
    Properties prop = new TestUtil().init_Properties("common/URL");

    Profile_Page profilePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        profilePage = new Profile_Page(driver);
        new LoginPage(driver).loginAs("CLIENT HR");
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickAddEmployeeButton();
        new ListingPage(driver).clickAddSingleEmployeeOption();
        new AddEmployee_Page(driver).createEmployee("CLIENT HR");
    }

    @Description("Verify the navigation to Job details page after filling the fields")
    @Owner("nayana.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void navigateToJobDetails() {

        logger.info("### Running navigateToJobDetails method ###");

        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");


        profilePage.verifyProfileStepper();
        Properties prop1 = new TestUtil().init_Properties("employeeView/Employee");
        // Personal Information section
        profilePage.enterGender();
        profilePage.enterMaritalStatus();
        profilePage.enterDOB(sdf.format(faker.date().birthday()));
        profilePage.enterTaxNum(faker.finance().bic());

        // Citizenship
        profilePage.enterCitizenshipCountry1();
        profilePage.enterCitizenshipID1(faker.idNumber().valid());
        profilePage.clickCitizenshipYes();
//        profilePage.enterCitizenshipCountry2();
//        profilePage.enterCitizenshipID2(faker.idNumber().valid());
//        profilePage.clickAddCitizenship();
//        profilePage.enterCitizenshipCountry3();
//        profilePage.enterCitizenshipID3(faker.idNumber().valid());

        // Home Address section
        profilePage.enterAddressLine1(faker.address().streetAddress());
        profilePage.enterAddressLine2(faker.address().streetName());
        profilePage.enterCity(faker.address().city());
        profilePage.enterState(faker.address().state());
        profilePage.enterPostalCode(faker.address().zipCode());

        // Contact details
        profilePage.enterHomePhone(faker.numerify("#######"));
        profilePage.enterMobilePhone(faker.numerify("#######"));
        profilePage.enterWorkPhone(faker.numerify("#######"));

        profilePage.clickNextButton("CLIENT HR");

       new LocalHelper().waitForPageURL(prop.getProperty("JOB_DETAILS_URL"), driver);
       Assert.assertEquals(appURL + prop.getProperty("JOB_DETAILS_URL")+profilePage.getEmployee_ID(), driver.getCurrentUrl(), "Mismatch found in URL of the page loaded");
    }
}
