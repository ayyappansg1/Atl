package main.Roles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import pages.common.LoginPage;
import pages.roles.RolesandPermissionHelper;

public class superAdmin extends BaseTest {
	
	LoginPage loginPage;
	RolesandPermissionHelper RP;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException {
		RP = new RolesandPermissionHelper(driver);
	    loginPage = new LoginPage(driver);
	    loginPage.loginAs("SUPER ADMIN");
	}
	
	 @Description("Verifies that Dashboard Tab present")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Regression"}, priority =1 )
	 public void AssertSuperAdminRole() throws InterruptedException {
		 RP.clickDashboard();
		 RP.clickPeople();
		 RP.clickPay();
		 RP.clickReports();
		 RP.clickInsights();
		 RP.clickSettings();
		 RP.clickEmployeeBtn();
	 }


}
