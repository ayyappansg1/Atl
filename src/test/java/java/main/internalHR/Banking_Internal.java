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
import pages.common.*;

import java.util.Properties;

public class Banking_Internal extends BaseTest {
    Properties prop = new TestUtil().init_Properties("common/URL");

    Banking_Page banking_page;

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        banking_page = new Banking_Page(driver);
        new LoginPage(driver).loginAs("INTERNAL HR");
        //new ListingPageClientHR(driver).switchToTravelMateOrganization();
        new ListingPage(driver).clickPeopleTab();
        new ListingPage(driver).clickAddEmployeeButton();
        new AddEmployee_Page(driver).createEmployee("INTERNAL HR");
        new Profile_Page(driver).navigateToJobDetails("INTERNAL HR");
        new Profile_Page(driver).clickNextButton("INTERNAL HR");
        new JobDetails_Page(driver).navigateToNextPage("INTERNAL HR");
    }

    @Description("Verify Bank Stepper Page")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Regression"})
    public void bankStepperValidate() {

        Faker faker = new Faker();

        banking_page.verifyBankingStepper();
        //banking_page.scroll_Up();
        banking_page.click_BankCountry();
        banking_page.Enter_AccountHolder_Name(faker.name().firstName());
        banking_page.Enter_WorkPhone1(faker.number().digits(1));
        banking_page.Enter_WorkPhone2(faker.numerify("##"));
       // banking_page.click_CheckBox();
        banking_page.enterAddressLine1(faker.address().streetAddress());
        banking_page.enterAddressLine2(faker.address().streetName());
        banking_page.enterState(faker.address().state());
        banking_page.enterCity(faker.address().city());
        banking_page.enterPostalCode(faker.address().zipCode());
        banking_page.Enter_BankName(faker.name().firstName());
//       banking_page.Enter_AccountNumber(faker.numerify("######"));banking_page.clickSaveButton();
        banking_page.clickNextButton();

    }


    @Description("Verify the navigation to next page from Job details page after filling the fields")
    @Owner("sundara.p@thinkpalm.com")
    @Test(groups = {"Regression"})
    public void navigateToDocumentsPage()  {
        Properties prop1 = new TestUtil().init_Properties("employeeView/Employee");
        banking_page.clickNextButton();
        // Verify the URL
        new LocalHelper().waitForPageURL(prop.getProperty("DOCUMENTS_PAGE_URL"),driver);
        Assert.assertEquals(appURL+prop.getProperty("DOCUMENTS_PAGE_URL")+prop1.getProperty("EMPLOYEE_ID"),driver.getCurrentUrl(),"Mismatch found in URL of the page loaded");
    }

    }

