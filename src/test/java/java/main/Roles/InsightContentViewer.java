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
import java.util.Properties;

public class InsightContentViewer extends BaseTest {

    RolesandPermissionHelper RP;
    private final LocalHelper localHelper = new LocalHelper();
    Properties prop = new TestUtil().init_Properties("common/CommonProp");
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
        RP = new RolesandPermissionHelper(driver);
        new LoginPage(driver).loginAs("INSIGHT CONTENT VIEWER");
    }

    @Description("Verifies Tab present")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Regression"})
    public void AssertInsightContentViewerRole() {
        Assert.assertTrue(RP.InsightsTab_IsPresent(), "InsightsTab is not present in the UI");
        logger.info("All Tabs are Present");

    }

    @Description("Verifies Each Tab")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Regression"})
    public void verifyingEachTab()  {
        localHelper.clickElement(RP.Insights, driver);
        Assert.assertEquals(RP.insideInsight(), prop.getProperty("INSIGHT_MSG"), "Message not found ");
        logger.info("Insight Tab is Enabled");
    }

    @Description("Verifies Not Present Tab")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Regression"})
    public void verifyingTabsNotPresent(){
        Assert.assertFalse(RP.PeopleTab_IsPresent(), "PeopleTab is present in the UI");
        Assert.assertFalse(RP.PayTab_IsPresent(), "PayTab is present in the UI");
        Assert.assertFalse(RP.ReportsTab_IsPresent(), "ReportsTab is present in the UI");
        Assert.assertFalse(RP.SettingsTab_IsPresent(), "SettingsTab is present in the UI");
        logger.info("Tabs are Not Present");
    }

    @Description("Assert Invalid URL Permission")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority =3)
    public void invalidURLPermissions() {
        RP.checkpermissionswithinvalidURLS(NegativeURLs);
    }
}