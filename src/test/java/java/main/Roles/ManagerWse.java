package main.Roles;
import helper.LocalHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import pages.common.LoginPage;
import pages.roles.RolesandPermissionHelper;
public class ManagerWse extends BaseTest{
    LoginPage loginPage;
    private final LocalHelper localHelper = new LocalHelper();
    RolesandPermissionHelper RP;
    public String[] NegativeURLs = {
            "https://core-qa.atlasbyelements.com/#/reports",
            "https://core-qa.atlasbyelements.com/#/pay",
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
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        RP = new RolesandPermissionHelper(driver);
        loginPage = new LoginPage(driver);
        loginPage.loginAs("ManagerWSE");
    }

    @Description("Verifies Tab present")
    @Owner("shahzaiba.contractor@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 1)
    public void AssertManagerWsePermissions(){
        //Verifying Tab Present
        Assert.assertTrue(RP.DashBoardTab_IsPresent(), "DashBoardTab is not present in the UI");
        Assert.assertTrue(RP.PeopleTab_IsPresent(), "PeopleTab is not present in the UI");
        Assert.assertTrue(RP.Profile_IsPresent(), "Profile is not present in the UI");
        Assert.assertTrue(RP.HrAdminWSE_Learning(), "Learning is not present in the UI");
        Assert.assertTrue(RP.SettingsTab_IsPresent(), "SettingsTab is not present in the UI");
        logger.info("All Tabs are Present");
        //Verifying Elements present inside settings
        RP.clickSettingsTab();
        Assert.assertTrue(RP.accountsUsers_IsPresent(), "accountUsers is not present in the UI");
        logger.info("All Fields in Settings Tab are Verified");

    }

    @Description("Verifies that Dashboard Tab present")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority = 2)
    public void AssertManagerWseRole() {
        RP.dashBoard_verification();

        localHelper.clickElement(RP.people,driver);
        logger.info("People Tab is Enabled");

        localHelper.clickElement(RP.profile,driver);
        logger.info("Profile Tab is Enabled");

        localHelper.clickElement(RP.learning,driver);
        logger.info("Learning Tab is Enabled");
    }

    @Description("Negative Scenarios")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority = 3)
    public void negativeScenario() {
        Assert.assertFalse(RP.ReportsTab_IsPresent(), "ReportsTab is present in the UI");
        Assert.assertFalse(RP.InsightsTab_IsPresent(), "InsightsTab is present in the UI");
        Assert.assertFalse(RP.PayTab_IsPresent(), "PayTab is present in the UI");
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
    @Test(groups = {"Regression"}, priority =4)
    public void invalidURLPermissions() throws Exception{
        RP.checkpermissionswithinvalidURLS(NegativeURLs);
    }
}
