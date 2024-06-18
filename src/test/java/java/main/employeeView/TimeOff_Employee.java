package main.employeeView;

import org.testng.annotations.Test;

import common.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import pages.common.LoginPage;
import pages.employeeView.TimeOffStepper;

public class TimeOff_Employee extends BaseTest{
	
	
//	@BeforeMethod(alwaysRun = true)
//	public void setUp() {
//		
//	   
//	}
	
	 @Description("Request Time Off")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Regression"}, priority =1 )
	 public void requesttimeoff() throws InterruptedException {
		 LoginPage loginPage = new LoginPage(driver);
	     TimeOffStepper timeoffemployee = new TimeOffStepper(driver);
		 loginPage.loginAs("EMPLOYEE_FOR_TIME_OFF");
		 timeoffemployee.clickontimeoff();
		 timeoffemployee.clickonrequesttimeoffandadddetails(appURL.contains("qa"));
	 }
	 

	 @Description("Validate Time Off")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Regression"}, priority =2 )
	 public void validatetimeoff() throws InterruptedException {
		 LoginPage loginPage = new LoginPage(driver);
	     TimeOffStepper timeoffemployee = new TimeOffStepper(driver);
		 loginPage.loginAs("MANAGER_TIME_OFF");
		timeoffemployee.verifyrequestonmanagerside();
	 }
	 

	 @Description("Edit Time Off")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Regression"}, priority =3 )
	 public void edittimeoff() throws InterruptedException {
		 LoginPage loginPage = new LoginPage(driver);
	     TimeOffStepper timeoffemployee = new TimeOffStepper(driver);
		 loginPage.loginAs("EMPLOYEE_FOR_TIME_OFF");
		 timeoffemployee.clickontimeoff();
		 timeoffemployee.editrequest();
	 }

	 @Description("Reject Request Time Off")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Regression"}, priority =4 )
	 public void rejecttimeoff() throws InterruptedException {
		 LoginPage loginPage = new LoginPage(driver);
	     TimeOffStepper timeoffemployee = new TimeOffStepper(driver);
		 loginPage.loginAs("MANAGER_TIME_OFF");
		 
		timeoffemployee.rejectrequest();
	 }
	 
	 @Description("Submit Timesheet")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Regression"}, priority =5 )
	 public void submittimesheet() throws InterruptedException {
		 LoginPage loginPage = new LoginPage(driver);
	     TimeOffStepper timeoffemployee = new TimeOffStepper(driver);
		 loginPage.loginAs("EMPLOYEE_FOR_TIME_OFF");
		 
		timeoffemployee.clickontimesheet();
		timeoffemployee.submittimesheet();
	 }
	 
	 @Description("Reject Timesheet")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Regression"}, priority =6 )
	 public void rejecttimesheet() throws InterruptedException {
		 LoginPage loginPage = new LoginPage(driver);
	     TimeOffStepper timeoffemployee = new TimeOffStepper(driver);
		 loginPage.loginAs("MANAGER_TIME_OFF");
		 
		timeoffemployee.rejecttimesheet();
	 }
	 
	 
	 @Description("Edit the Timesheet")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Regression"}, priority =7 )
	 public void editremployeetimesheet() throws InterruptedException {
		 LoginPage loginPage = new LoginPage(driver);
	     TimeOffStepper timeoffemployee = new TimeOffStepper(driver);
		 loginPage.loginAs("EMPLOYEE_FOR_TIME_OFF");
		 timeoffemployee.clickontimesheet();
		 timeoffemployee.edittimesheet();
		 
	 }
	 
	
	 @Description("Resubmit the Timesheet")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Regression"}, priority =8 )
	 public void resubmittimesheet() throws InterruptedException {
		 LoginPage loginPage = new LoginPage(driver);
	     TimeOffStepper timeoffemployee = new TimeOffStepper(driver);
		 loginPage.loginAs("EMPLOYEE_FOR_TIME_OFF");
		 timeoffemployee.clickontimesheet();
		 timeoffemployee.submittimesheet();
	 }
	 
	 @Description("Reject Timesheet")
	 @Owner("shahzaiba.contractor@elementsgs.com")
	 @Test(groups = {"Regression"}, priority =9 )
	 public void rejecttimesheetagain() throws InterruptedException {
		 LoginPage loginPage = new LoginPage(driver);
	     TimeOffStepper timeoffemployee = new TimeOffStepper(driver);
		 loginPage.loginAs("MANAGER_TIME_OFF");
		 timeoffemployee.rejecttimesheet();
	 }
	 
	 

}
