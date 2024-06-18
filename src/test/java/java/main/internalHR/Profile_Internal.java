package main.internalHR;

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

public class Profile_Internal extends BaseTest {

    Properties prop = new TestUtil().init_Properties("common/URL");
    Profile_Page profilePage;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        profilePage = new Profile_Page(driver);
        new LoginPage(driver).loginAs("INTERNAL HR");
        //new ListingPageClientHR(driver).switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickAddEmployeeButton();
        new AddEmployee_Page(driver).createEmployee("INTERNAL HR");
    }

    @Description("Verify the navigation to Job details page after filling the fields")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void navigateToJobDetails() {

        logger.info("### Running navigateToJobDetails method ###");

        Faker faker = new Faker();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");

        // Personal Information section
        profilePage.verifyProfileStepper();
        Properties prop1 = new TestUtil().init_Properties("employeeView/Employee");
        profilePage.enterGender();
        profilePage.enterPersonalPronoun();
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
        profilePage.enterState(faker.address().state());
        profilePage.enterAddressLine1(faker.address().streetAddress());
        profilePage.enterAddressLine2(faker.address().streetName());
        profilePage.enterCity(faker.address().city());
        profilePage.enterPostalCode(faker.address().zipCode());

        // Contact details
        profilePage.enterHomePhone(faker.numerify("#######"));
        profilePage.enterMobilePhone(faker.numerify("#######"));
        profilePage.enterWorkPhone(faker.numerify("#######"));

        profilePage.clickNextButton("INTERNAL HR");

        new LocalHelper().waitForPageURL(prop.getProperty("JOB_DETAILS_URL_INTERNAL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("JOB_DETAILS_URL_INTERNAL")+prop1.getProperty("EMPLOYEE_ID"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }

}

