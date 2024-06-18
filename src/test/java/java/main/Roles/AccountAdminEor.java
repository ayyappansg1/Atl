package main.Roles;

import common.BaseTest;
import common.TestUtil;
import helper.LocalHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.common.LoginPage;
import pages.roles.RolesandPermissionHelper;
import pages.roles.SuperAdminHelper;

import java.util.Properties;

public class AccountAdminEor extends BaseTest {

    SuperAdminHelper superAdminHelper;
    RolesandPermissionHelper RP;
    private final LocalHelper localHelper = new LocalHelper();

    Properties prop = new TestUtil().init_Properties("common/CommonProp");

    public String[] NegativeURLs = {
            "https://core-qa.atlasbyelements.com/#/reports",
            "https://core-qa.atlasbyelements.com/#/insights",
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
        superAdminHelper = new SuperAdminHelper(driver);
        RP = new RolesandPermissionHelper(driver);
        new LoginPage(driver).loginAs("ACCOUNT ADMIN EOR");
    }
    @Description("Verifies Tab present")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Regression"})
    public void AssertAccountAdminEOR() {
        Assert.assertTrue(RP.PeopleTab_IsPresent(), "PeopleTab is not present in the UI");
        Assert.assertTrue(RP.PayTab_IsPresent(), "PayTab is not present in the UI");
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
    public void verifyingEachTab() {
        localHelper.clickElement(RP.people,driver);
        Assert.assertEquals(RP.insidePeople(),prop.getProperty("PEOPLE_TAB_MSG"),"Message not found ");
        logger.info("People Tab is Enabled");

        localHelper.clickElement(RP.pay,driver);
        Assert.assertEquals(RP.insidePay(),prop.getProperty("PAY_TAB_MSG"),"Message not found ");
        logger.info("Pay Tab is Enabled");

    }

    @Description("Verifies Not Present Tab")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Regression"})
    public void verifyingTabsNotPresent(){

        Assert.assertFalse(RP.ReportsTab_IsPresent(), "ReportsTab is present in the UI");
        Assert.assertFalse(RP.InsightsTab_IsPresent(), "InsightsTab is present in the UI");

        //Settings Not Present Tabs
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
