package main.postOnboarding.clietHR;

import common.BaseTest;
import common.TestUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.ListingPage;
import pages.common.LoginPage;
import pages.postOnboarding.Profile_PostOnboarding;

import java.io.IOException;
import java.util.Properties;


public class Profile_PostOnboardingClient extends BaseTest {

    Profile_PostOnboarding profile_postOnboarding;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException, IOException {
        TestUtil testUtil=new TestUtil();
        Properties prop = testUtil.init_Properties("restAssured/Base");
        profile_postOnboarding = new Profile_PostOnboarding(driver);
        new LoginPage(driver).loginAs("CLIENT HR");
        new ListingPage(driver).switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickClearFilter();
        new ListingPage(driver).selectActiveStatus();
        new ListingPage(driver).performSearchBy(prop.getProperty("EMPLOYEE_ID_CLI"));
        new ListingPage(driver).clickFirstEmployee(prop.getProperty("EMPLOYEE_ID_CLI"));
        jsonPathEvaluator = profile_postOnboarding.getResponse(baseURI,prop.getProperty("EMPLOYEE_ID_CLI")).jsonPath();
    }

    @Description("")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void verifyProfileStepper() {
        logger.info("### Running verifyProfileStepper method ###");

        Assert.assertEquals(profile_postOnboarding.getEmployeeId(),jsonPathEvaluator.get("employeeID"));
        Assert.assertEquals(profile_postOnboarding.getFullName(),jsonPathEvaluator.get("fullName"));
        Assert.assertEquals(profile_postOnboarding.getJobTitle(),jsonPathEvaluator.get("jobTitle"),"Mismatch found in the ");
        Assert.assertEquals(profile_postOnboarding.getEmail(),"+"+jsonPathEvaluator.get("phone.number"));

        Assert.assertEquals(profile_postOnboarding.getFirstName(),jsonPathEvaluator.get("personalDetails.firstName"),"Mismatch found in the firstName");
        Assert.assertEquals(profile_postOnboarding.getAdditionalGivenName(),jsonPathEvaluator.get("personalDetails.additionalGivenName"),"Mismatch found in the additionalGivenName");
        Assert.assertEquals(profile_postOnboarding.getLastName(),jsonPathEvaluator.get("personalDetails.lastName"),"Mismatch found in the lastName");
        Assert.assertEquals(profile_postOnboarding.getPreferredName(),jsonPathEvaluator.get("personalDetails.preferredName"),"Mismatch found in the preferredName");
        Assert.assertEquals(profile_postOnboarding.getGender(),jsonPathEvaluator.getInt("personalDetails.gender"),"Mismatch found in the gender");

        Assert.assertEquals(profile_postOnboarding.getBirthday(),profile_postOnboarding.dateTimeFormatter(jsonPathEvaluator.get("personalDetails.birthday")),"Mismatch found in the birthday");
        Assert.assertEquals(profile_postOnboarding.getMaritalStatus(),jsonPathEvaluator.getInt("personalDetails.maritalStatus"),"Mismatch found in the maritalStatus");
        //Assert.assertEquals(profile_postOnboarding.getCountryOfResidence(),jsonPathEvaluator.get("personalDetails.workAddress.country"),"Mismatch found in the country");
        Assert.assertEquals(profile_postOnboarding.getNationalId(),jsonPathEvaluator.get("personalDetails.citizenship[0].nationalId"),"Mismatch found in the country");

        Assert.assertEquals(profile_postOnboarding.getCountry(),jsonPathEvaluator.get("personalDetails.homeAddress.country"),"Mismatch found in the country");
        Assert.assertEquals(profile_postOnboarding.getStreet1(),jsonPathEvaluator.get("personalDetails.homeAddress.street1"),"Mismatch found in the street1");
        Assert.assertEquals(profile_postOnboarding.getStreet2(),jsonPathEvaluator.get("personalDetails.homeAddress.street2"),"Mismatch found in the street2");
        Assert.assertEquals(profile_postOnboarding.getCity(),jsonPathEvaluator.get("personalDetails.homeAddress.city"),"Mismatch found in the city");
        Assert.assertEquals(profile_postOnboarding.getState(),jsonPathEvaluator.get("personalDetails.homeAddress.state"),"Mismatch found in the state");
        //Assert.assertEquals(profile_postOnboarding.getPostalCode(),jsonPathEvaluator.get("personalDetails.homeAddress.postalCode"),"Mismatch found in the postalCode");

        Assert.assertEquals(profile_postOnboarding.getWorkPhone(),jsonPathEvaluator.get("contactDetails.officeLandline.number"),"Mismatch found in the officeLandline");
        Assert.assertEquals(profile_postOnboarding.getHomePhone(),jsonPathEvaluator.get("contactDetails.homeLandline.number"),"Mismatch found in the homeLandline");
        Assert.assertEquals(profile_postOnboarding.getMobile(),jsonPathEvaluator.get("contactDetails.homeMobile.number"),"Mismatch found in the homeMobile");
        Assert.assertEquals(profile_postOnboarding.getHomeEmail(),jsonPathEvaluator.get("contactDetails.homeEmail"),"Mismatch found in the homeEmail");
        Assert.assertEquals(profile_postOnboarding.getOfficeEmail(),jsonPathEvaluator.get("contactDetails.officeEmail"),"Mismatch found in the officeEmail");

        Assert.assertEquals(profile_postOnboarding.getLinkedinUrl(),jsonPathEvaluator.get("contactDetails.linkedinUrl"),"Mismatch found in the linkedinUrl");
        Assert.assertEquals(profile_postOnboarding.getWebsite(),jsonPathEvaluator.get("contactDetails.website"),"Mismatch found in the website");

    }
}
