package main.Roles;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import pages.common.LoginPage;
import pages.employeeView.EmployeeAssert;
import pages.roles.RolesandPermissionHelper;

public class EmployeeRole extends BaseTest {
	
	LoginPage loginPage;
	RolesandPermissionHelper RP;

	public String[] NegativeURLs = {
			"https://core-qa.atlasbyelements.com/#/people/internal-dashboard",
			"https://core-qa.atlasbyelements.com/#/pay",
			"https://core-qa.atlasbyelements.com/#/reports",
			"https://core-qa.atlasbyelements.com/#/insights",
			"https://core-qa.atlasbyelements.com/#/settings/accounts-users",
			"https://core-qa.atlasbyelements.com/#/settings/id-verification",
			"https://core-qa.atlasbyelements.com/#/settings/expansion_hub",
			"https://core-qa.atlasbyelements.com/#/settings/implementations",
			"https://core-qa.atlasbyelements.com/#/settings/manage-benefits",
			"https://core-qa.atlasbyelements.com/#/settings/manage-time-off",
			"https://core-qa.atlasbyelements.com/#/settings/systems_fm",
			"https://core-qa.atlasbyelements.com/#/settings/roles-permission",
			"https://core-qa.atlasbyelements.com/#/settings/manage-time-tracking",
			"https://core-qa.atlasbyelements.com/#/settings/country-setup",
			"https://core-qa.atlasbyelements.com/#/settings/paygroup-setup"
	};
	public String[] NegativeURLsUAT = {
			"https://core-uat.atlasbyelements.com/#/people/internal-dashboard",
			"https://core-uat.atlasbyelements.com/#/pay",
			"https://core-uat.atlasbyelements.com/#/reports",
			"https://core-uat.atlasbyelements.com/#/insights",
			"https://core-uat.atlasbyelements.com/#/settings/accounts-users",
			"https://core-uat.atlasbyelements.com/#/settings/id-verification",
			"https://core-uat.atlasbyelements.com/#/settings/expansion_hub",
			"https://core-uat.atlasbyelements.com/#/settings/implementations",
			"https://core-uat.atlasbyelements.com/#/settings/manage-benefits",
			"https://core-uat.atlasbyelements.com/#/settings/manage-time-off",
			"https://core-uat.atlasbyelements.com/#/settings/systems_fm",
			"https://core-uat.atlasbyelements.com/#/settings/roles-permission",
			"https://core-uat.atlasbyelements.com/#/settings/manage-time-tracking",
			"https://core-uat.atlasbyelements.com/#/settings/country-setup",
			"https://core-uat.atlasbyelements.com/#/settings/paygroup-setup"
	};
	private EmployeeAssert employeeassert;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException {
		RP = new RolesandPermissionHelper(driver);
		employeeassert = new EmployeeAssert(driver);
	    loginPage = new LoginPage(driver);
	    loginPage.loginAs("EMPLOYEE_FOR_TIME_OFF");
	}
	
	 @Description("Verifies that Dashboard Tab present")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Regression"}, priority =1 )
	 public void AssertEmployeeRole() {
		 employeeassert.assertEmpDashboard();
		 employeeassert.assertProfileName();
		 employeeassert.assertemplearningmodule();

	 }
	@Description("Verifies Not Present Tab")
	@Owner("pavithrab.contractor@atlashxm.com")
	@Test(groups = {"Regression"},priority =2 )
	public void verifyingTabsNotPresent(){
		Assert.assertFalse(RP.PeopleTab_IsPresent(), "PeopleTab is present in the UI");
		Assert.assertFalse(RP.PayTab_IsPresent(), "PayTab is present in the UI");
		Assert.assertFalse(RP.ReportsTab_IsPresent(), "ReportsTab is present in the UI");
		Assert.assertFalse(RP.SettingsTab_IsPresent(), "SettingsTab is present in the UI");
		logger.info("Tabs are Not Present");
	}
	@Description("Invalid URL")
	@Owner("shahzaiba.contractor@elementsgs.com")
	@Test(groups = {"Regression"}, priority =3 )
	public void invalidURLValidation() {
		if(appURL.contains("qa")) {
			RP.checkpermissionswithinvalidURLS(NegativeURLs);
		}else{
			RP.checkpermissionswithinvalidURLS(NegativeURLsUAT);

		}

	}
}
