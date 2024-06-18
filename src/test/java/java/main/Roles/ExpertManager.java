package main.Roles;

import common.TestUtil;
import helper.LocalHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import pages.common.LoginPage;
import pages.roles.RolesandPermissionHelper;

import java.util.Properties;

public class ExpertManager extends BaseTest{
	LoginPage loginPage;
	private final LocalHelper localHelper = new LocalHelper();
	Properties prop = new TestUtil().init_Properties("common/CommonProp");
	RolesandPermissionHelper RP;

	public String[] NegativeURLs = {
			"https://core-qa.atlasbyelements.com/#/people",
			"https://core-qa.atlasbyelements.com/#/pay",
			"https://core-qa.atlasbyelements.com/#/reports",
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
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException {
	    loginPage = new LoginPage(driver);
		RP = new RolesandPermissionHelper(driver);
	    loginPage.loginAs("EXPERT_MANAGER");
	}

	@Description("Verifies Tab present")
	@Owner("shahzaiba.contractor@atlashxm.com")
	@Test(groups = {"Regression"})
	public void AssertExpertManager() {
		Assert.assertTrue(RP.InsightsTab_IsPresent(), "InsightsTab is not present in the UI");
		Assert.assertTrue(RP.SettingsTab_IsPresent(), "SettingsTab is not present in the UI");
		logger.info("All Tabs are Present");

		//Verifying Elements present inside settings
		RP.clickSettingsTab();
		Assert.assertTrue(RP.accountsUsers_IsPresent(), "accountUsers is not present in the UI");
		logger.info("All Fields in Settings Tab are Verified");

	}
	@Description("Verifies Each Tab")
	@Owner("pavithrab.contractor@atlashxm.com")
	@Test(groups = {"Regression"})
	public void verifyingEachTab()  {
		localHelper.clickElement(RP.Insights, driver);
		Assert.assertEquals(RP.insideInsight(), prop.getProperty("INSIGHT_MSG"), "Message not found ");
		logger.info("Insight Tab is Enabled");
	}

	@Description("Negative Scenarios")
	@Owner("shahzaiba.contractor@elementsgs.com")
	@Test(groups = {"Regression"}, priority = 2)
	public void negativeScenario() {
		Assert.assertFalse(RP.PeopleTab_IsPresent(), "PeopleTab is present in the UI");
		Assert.assertFalse(RP.PayTab_IsPresent(), "PayTab is present in the UI");
		Assert.assertFalse(RP.ReportsTab_IsPresent(), "ReportsTab is present in the UI");

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

	@Description("Assert Invalid URL Permission")
	@Owner("shahzaiba.contractor@elementsgs.com")
	@Test(groups = {"Regression"}, priority =3)
	public void invalidURLPermissions() {
		RP.checkpermissionswithinvalidURLS(NegativeURLs);
	}
}
