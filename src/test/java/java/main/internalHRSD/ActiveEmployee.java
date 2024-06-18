package main.internalHRSD;

import java.util.Properties;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import common.BaseTest;
import common.TestUtil;
import email.emailPage.MailSacPage;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import pages.common.ListingPage;
import pages.common.AddEmployee_Page;
import pages.common.Banking_Page;
import pages.common.Compensation_Page;
import pages.common.Documents_Page;
import pages.common.Finish_Page;
import pages.common.JobDetails_Page;
import pages.common.LoginPage;
import pages.common.Profile_Page;
import pages.common.SetPassword_Page;
import pages.employeeView.EmergencyStepper;
import pages.employeeView.ProfileStepper;
import pages.employeeView.WelcomePage;
import pages.internalHRSD.EmployeeHelper;

public class ActiveEmployee extends BaseTest{
	
	LoginPage loginPage;
	EmployeeHelper employeeHelper;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException {
		employeeHelper = new EmployeeHelper(driver);
	    loginPage = new LoginPage(driver);
	    loginPage.loginAs("INTERNAL HR");
	}
	
	 @Description("Verifies that searched name should be present")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Smoke"}, priority =1 )
	 public void Createemployee() throws InterruptedException {

		Properties mailSac = new TestUtil().init_Properties("email/mailSac");
		Properties auth = new TestUtil().init_Properties("common/Login");

		new ListingPage(driver).clickPeopleTab();
		new ListingPage(driver).clickAddEmployeeButton();
		new AddEmployee_Page(driver).createEmployeeView("INTERNAL HR");
		new Profile_Page(driver).clickNextButton("INTERNAL HR");
		new JobDetails_Page(driver).enterAtlasStartDate(null);
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
		new WelcomePage(driver).goToProfileStepper();
		new ProfileStepper(driver).navigateToBankingStepper();
		new Banking_Page(driver).clickNextButton();
		new EmergencyStepper(driver).navigateToDocumentsStepper();
		new Documents_Page(driver).clickNextButton("EMPLOYEE");
		// new Benefits_Page(driver).clickNextButton("EMPLOYEE");
		new ListingPage(driver).signOutApplication();

	 }
	 
	 @Description("Verifies that status should be active for the employee")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Smoke"}, priority =2 )
	 public void changestatustoactive() {
		 employeeHelper.changestatustoactive();
	 }
	 
	 @Description("Verifies that status should be active for the employee")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Smoke"}, priority =2 )
	 public void AssertEmployeeStatus() {
		 employeeHelper.activeEmployee();
	 }
}
