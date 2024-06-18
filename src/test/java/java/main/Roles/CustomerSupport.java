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

public class CustomerSupport extends BaseTest {

    RolesandPermissionHelper RP;
    private final LocalHelper localHelper = new LocalHelper();
    Properties prop = new TestUtil().init_Properties("common/CommonProp");

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        RP = new RolesandPermissionHelper(driver);
        new LoginPage(driver).loginAs("CUSTOMER SUPPORT");
    }

    @Description("Verifies Tab present")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Regression"})
    public void AssertCustomerSupportRole() {
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
        Assert.assertTrue(RP.rolesAndPerm_IsPresent(), "rolesAndPerm is not present in the UI");
        Assert.assertTrue(RP.timeTracking_IsPresent(), "manageTimeTracking is not present in the UI");
        Assert.assertTrue(RP.countrySetup_IsPresent(), "countrySetup is not present in the UI");
        Assert.assertTrue(RP.payGroupSetup_IsPresent(), "payGroupSetup is not present in the UI");
        logger.info("All Fields in Settings Tab are Verified");

    }
    @Description("Verifies Each Tab")
    @Owner("pavithrab.contractor@atlashxm.com")
    @Test(groups = {"Regression"})
    public void verifyingEachTab() {
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
        Assert.assertEquals(RP.insideInsight(),prop.getProperty("INSIGHT_MSG"),"Message not found ");
        logger.info("Insight Tab is Enabled");

    }

}

