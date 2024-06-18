package main.Roles;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import pages.common.LoginPage;
import pages.roles.RolesandPermissionHelper;

public class Manager extends BaseTest {

	LoginPage loginPage;
	RolesandPermissionHelper RP;
	public String[] NegativeURLs = {
			"https://core-qa.atlasbyelements.com/#/pay",
			"https://core-qa.atlasbyelements.com/#/reports",
			"https://core-qa.atlasbyelements.com/#/insights",
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
			"https://core-uat.atlasbyelements.com/#/pay",
			"https://core-uat.atlasbyelements.com/#/reports",
			"https://core-uat.atlasbyelements.com/#/insights",
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

	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException {
		RP = new RolesandPermissionHelper(driver);
		loginPage = new LoginPage(driver);
		loginPage.loginAs("MANAGER");
	}

	@Description("Verifies that Dashboard Tab present")
	@Owner("shahzaiba.contractor@elementsgs.com")
	@Test(groups = {"Regression"}, priority = 1)
	public void AssertManagerRole() {
		RP.clickDashboard();
		RP.taskWidgetVisible();
		RP.clickmanagerPeople();
		RP.checkManagerActiveEmployeeStatus();

	}

	@Description("Assert Invalid URL Permission")
	@Owner("shahzaiba.contractor@elementsgs.com")
	@Test(groups = {"Regression"}, priority = 3)
	public void invalidURLPermissions() {
		if(appURL.contains("qa")) {
			RP.checkpermissionswithinvalidURLS(NegativeURLs);
		}else{
			RP.checkpermissionswithinvalidURLS(NegativeURLsUAT);

		}
	}

	@Description("Negative Scenarios")
	@Owner("shahzaiba.contractor@elementsgs.com")
	@Test(groups = {"Regression"}, priority = 2)
	public void negativeScenario() {
		Assert.assertFalse(RP.PayTab_IsPresent(), "PayTab is present in the UI");
		Assert.assertFalse(RP.ReportsTab_IsPresent(), "ReportsTab is present in the UI");
		Assert.assertFalse(RP.InsightsTab_IsPresent(), "InsightsTab is present in the UI");

		RP.clickSettingsTab();
		Assert.assertFalse(RP.expansionHub_IsPresent(), "expansionHub is present in the UI");
		Assert.assertFalse(RP.implementations_IsPresent(), "implementations is present in the UI");
		Assert.assertFalse(RP.manageBenefits_IsPresent(), "manageBenefits is present in the UI");
		Assert.assertFalse(RP.manageTimeOff_IsPresent(), "manageTimeOff is present in the UI");
		Assert.assertFalse(RP.systemFiles_IsPresent(), "systemFiles is present in the UI");
		Assert.assertFalse(RP.rolesAndPerm_IsPresent(), "rolesAndPerm is present in the UI");
		Assert.assertFalse(RP.timeTracking_IsPresent(), "manageTimeTracking is present in the UI");
		Assert.assertFalse(RP.countrySetup_IsPresent(), "countrySetup is present in the UI");
		Assert.assertFalse(RP.payGroupSetup_IsPresent(), "payGroupSetup is present in the UI");
		logger.info("Tabs are Not Present");
	}
}



