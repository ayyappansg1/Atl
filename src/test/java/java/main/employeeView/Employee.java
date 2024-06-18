package main.employeeView;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import pages.common.LoginPage;
import pages.employeeView.EmployeeAssert;

public class Employee extends BaseTest{
	
	LoginPage loginPage;
	private EmployeeAssert employeeAssert;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws InterruptedException {
		employeeAssert = new EmployeeAssert(driver);
	    loginPage = new LoginPage(driver);
	    loginPage.loginAs("EMPLOYEE");
	}
	
	 @Description("Verifies that Profile Tab present")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Smoke"}, priority =1 )
	 public void AssertProfileTab() {
		 employeeAssert.assertProfile();
	 }
	 
	 @Description("Verifies that username is correct")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Smoke"}, priority =3)
	 public void AssertProfileName() {
		 employeeAssert.assertProfileName();
	 }
	 
	 @Description("Verifies that timer & Clock-in and out widget is present")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Smoke"}, priority =2 )
	 public void AssertEmpDashboard() {
		 employeeAssert.assertEmpDashboard();
		 
	 }

}
