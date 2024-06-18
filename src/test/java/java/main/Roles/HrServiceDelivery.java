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

public class HrServiceDelivery extends BaseTest {
    RolesandPermissionHelper RP;
    private final LocalHelper localHelper = new LocalHelper();
    Properties prop = new TestUtil().init_Properties("common/CommonProp");

    public String[] NegativeURLsQA = {

            "https://core-qa.atlasbyelements.com/#/settings/country-setup",
            "https://core-qa.atlasbyelements.com/#/settings/paygroup-setup"
    };
    public String[] NegativeURLsUAT = {

            "https://core-uat.atlasbyelements.com/#/settings/country-setup",
            "https://core-uat.atlasbyelements.com/#/settings/paygroup-setup"
    };

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        RP = new RolesandPermissionHelper(driver);
        new LoginPage(driver).loginAs("HR SERVICE");
    }

    @Description("Verifies Tab present")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Regression"})
    public void AssertHrServiceDeliveryRole(){
        //Verifying Tab Present
        Assert.assertTrue(RP.DashBoardTab_IsPresent(), "DashBoardTab is not present in the UI");
        Assert.assertTrue(RP.PeopleTab_IsPresent(), "PeopleTab is not present in the UI");
        Assert.assertTrue(RP.PayTab_IsPresent(), "PayTab is not present in the UI");
        Assert.assertTrue(RP.ReportsTab_IsPresent(), "ReportsTab is not present in the UI");
        Assert.assertTrue(RP.InsightsTab_IsPresent(), "InsightsTab is not present in the UI");
        Assert.assertTrue(RP.SettingsTab_IsPresent(), "SettingsTab is not present in the UI");
        logger.info("All Tabs are Present");
        //Verifying Elements present inside settings
        RP.clickSettingsTab();
        Assert.assertTrue(RP.accountsUsers_IsPresent(), "accountUsers is not present in the UI");
        Assert.assertTrue(RP.expansionHub_IsPresent(), "expansionHub is not present in the UI");
        Assert.assertTrue(RP.implementations_IsPresent(), "implementations is not present in the UI");
        Assert.assertTrue(RP.manageBenefits_IsPresent(), "manageBenefits is not present in the UI");
        Assert.assertTrue(RP.manageTimeOff_IsPresent(), "manageTimeOff is not present in the UI");
        Assert.assertTrue(RP.systemFiles_IsPresent(), "systemFiles is not present in the UI");
        Assert.assertTrue(RP.timeTracking_IsPresent(), "manageTimeTracking is not present in the UI");
        logger.info("All Fields in Settings Tab are Verified");

    }

    @Description("Verifies Each Tab")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Regression"})
    public void verifyingEachTab() throws InterruptedException {

        RP.dashBoard_verification();

        localHelper.clickElement(RP.people,driver);
        Assert.assertEquals(RP.insidePeople(),prop.getProperty("PEOPLE_TAB_MSG"),"Message not found ");
        logger.info("People Tab is Enabled");

        localHelper.clickElement(RP.pay,driver);
        Assert.assertEquals(RP.insidePay(),prop.getProperty("PAY_TAB_MSG"),"Message not found ");
        logger.info("Pay Tab is Enabled");

        localHelper.clickElement(RP.reports,driver);
        Assert.assertEquals(RP.insideReports(),prop.getProperty("REPORTS_MSG"),"Message not found ");
        logger.info("Report Tab is Enabled");

        localHelper.clickElement(RP.Insights,driver);
        Assert.assertTrue(RP.noInsight(), "Permission is Present");

    }
    @Description("Verifies Not Present Tab")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Regression"})
    public void verifyingTabsNotPresent(){

        RP.clickSettingsTab();
        Assert.assertFalse(RP.countrySetup_IsPresent(), "countrySetup is not present in the UI");
        Assert.assertFalse(RP.payGroupSetup_IsPresent(), "payGroupSetup is not present in the UI");

    }

    @Description("Assert Invalid URL Permission")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority =3)
    public void invalidURLPermissions() throws Exception{
        if(appURL.contains("qa")) {
            RP.checkpermissionswithinvalidURLS(NegativeURLsQA);
        }else{
            RP.checkpermissionswithinvalidURLS(NegativeURLsUAT);

        }
    }
}
