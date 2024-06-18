package main.Timeandattendance;

import common.BaseTest;
import common.TestUtil;
import common.WSECreation;
import helper.LocalHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Timeandattendance.Requesttimeoffclass;
import objectRepo.Timeandattendance.Requesttimeoff;
import pages.common.ListingPage;
import pages.common.LoginPage;

import java.io.IOException;
import java.util.Properties;

public class EmployeeRequestTimeoff extends BaseTest {
    private final LocalHelper localHelper = new LocalHelper();
    Requesttimeoffclass rc ;
    Requesttimeoff rtf;
    Properties prop;
    Properties uatProp;


    @BeforeMethod(enabled = true)
    public void setUpBeforeClass() throws IOException, InterruptedException {
        WSECreation wseCreation=new WSECreation();
        wseCreation.createWSEthroughAPI(appURL.contains("qa"),"manager");
        prop = new TestUtil().init_Properties("common/Login");
        uatProp = new TestUtil().init_Properties("common/uatLogin");
    }
    @Description("Decline Request Time Off from Super Admin")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority = 1)
    public void DeclineRequestTimeoffforSuperAdmin() throws InterruptedException, IOException {
        new LoginPage(driver).loginAs("WSE_Through_API");
        rc = new Requesttimeoffclass(driver);
        rc.clickontimeoffstepper();
        rc.requesttimeofffunction(1,40);
        new ListingPage(driver).signOutApplication();
        new LoginPage(driver).loginAs("SUPER ADMIN");
        new ListingPage(driver).clickPeopleTab();
        if(appURL.contains("qa")) {
            new ListingPage(driver).performSearchBy(prop.getProperty("WSE_Through_API_ID"));
        }else{
            new ListingPage(driver).performSearchBy(uatProp.getProperty("WSE_Through_API_ID"));
        }        rc.openemployeeforaction();
        rc.clickontimeoffstepper();
        rc.declinetimeoffrequest(appURL.contains("qa"),appURL);
    }

    @Description("Decline Request Time Off From Manager Side")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority = 2)
    public void DeclineRequestTimeoffforManager() throws InterruptedException {
        new LoginPage(driver).loginAs("WSE_Through_API");
        rc = new Requesttimeoffclass(driver);
        rc.clickontimeoffstepper();
        rc.requesttimeofffunction(1,45);
        new ListingPage(driver).signOutApplication();
        new LoginPage(driver).loginAs("Manager_For_New_WSE");
        new ListingPage(driver).clickPeopleTab();
        if(appURL.contains("qa")) {
            new ListingPage(driver).performSearchBy(prop.getProperty("WSE_Through_API_ID"));
        }else{
            new ListingPage(driver).performSearchBy(uatProp.getProperty("WSE_Through_API_ID"));
        }        rc.openemployeeforaction();
        rc.clickontimeoffstepper();
        rc.declinetimeoffrequest(appURL.contains("qa"),appURL);
    }
//
    @Description("Decline Request Time Off From HR Admin WSE Side")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority = 3)
    public void DeclineRequestTimeoffforHRAdminWSE() throws InterruptedException {
        new LoginPage(driver).loginAs("WSE_Through_API");
        rc = new Requesttimeoffclass(driver);
        rc.clickontimeoffstepper();
        rc.requesttimeofffunction(1,55);
        new ListingPage(driver).signOutApplication();
        new LoginPage(driver).loginAs("HR_ADMIN_WSE");
        new ListingPage(driver).clickPeopleTab();
        if(appURL.contains("qa")) {
            new ListingPage(driver).performSearchBy(prop.getProperty("WSE_Through_API_ID"));
        }else{
            new ListingPage(driver).performSearchBy(uatProp.getProperty("WSE_Through_API_ID"));
        }
        rc.openemployeeforaction();
        rc.clickontimeoffstepper();
        rc.declinetimeoffrequest(appURL.contains("qa"),appURL);
    }
//
    @Description("Decline Request Time Off From Manager WSE Side")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority = 4)
    @BeforeMethod(enabled = false)
    public void DeclineRequestTimeoffforManagerWSE() throws InterruptedException, IOException {
        WSECreation wseCreation=new WSECreation();
        wseCreation.createWSEthroughAPI(appURL.contains("qa"),"managerWSe");
        prop = new TestUtil().init_Properties("common/Login");
        uatProp = new TestUtil().init_Properties("common/uatLogin");
        new LoginPage(driver).loginAs("WSE_Through_API");
        rc = new Requesttimeoffclass(driver);
        rc.clickontimeoffstepper();
        rc.requesttimeofffunction(1, 50);
        new ListingPage(driver).signOutApplication();
        new LoginPage(driver).loginAs("ManagerWSE");
        new ListingPage(driver).clickPeopleTab();
        if(appURL.contains("qa")) {
            new ListingPage(driver).performSearchBy(prop.getProperty("WSE_Through_API_ID"));
        }else{
            new ListingPage(driver).performSearchBy(uatProp.getProperty("WSE_Through_API_ID"));
        }
        rc.openemployeeforaction();
        rc.clickontimeoffstepper();
        rc.declinetimeoffrequest(appURL.contains("qa"),appURL);
    }
//
    @Description("Decline Request Time Off From HR Admin")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority = 5)
    public void DeclineRequestTimeoffforHRAdmin() throws InterruptedException {
        new LoginPage(driver).loginAs("WSE_Through_API");
        rc = new Requesttimeoffclass(driver);
        rc.clickontimeoffstepper();
        rc.requesttimeofffunction(1,60);
        new ListingPage(driver).signOutApplication();
        new LoginPage(driver).loginAs("CLIENT HR");
        new ListingPage(driver).clickPeopleTab();
        if(appURL.contains("qa")) {
            new ListingPage(driver).performSearchBy(prop.getProperty("WSE_Through_API_ID"));
        }else{
            new ListingPage(driver).performSearchBy(uatProp.getProperty("WSE_Through_API_ID"));
        }
        rc.openemployeeforaction();
        rc.clickontimeoffstepper();
        rc.declinetimeoffrequest(appURL.contains("qa"),appURL);
    }

    @Description("Approve Request Time Off from Super Admin")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority = 10)
    public void ApproveRequestTimeoffforSuperAdmin() throws InterruptedException {
        new LoginPage(driver).loginAs("WSE_Through_API");
        rc = new Requesttimeoffclass(driver);
        rc.clickontimeoffstepper();
        rc.requesttimeofffunctionforapprove(1,20);
        new ListingPage(driver).signOutApplication();
        new LoginPage(driver).loginAs("SUPER ADMIN");
        new ListingPage(driver).clickPeopleTab();
        if(appURL.contains("qa")) {
            new ListingPage(driver).performSearchBy(prop.getProperty("WSE_Through_API_ID"));
        }else{
            new ListingPage(driver).performSearchBy(uatProp.getProperty("WSE_Through_API_ID"));
        }        rc.openemployeeforaction();
        rc.clickontimeoffstepper();
        rc.approvetimeoffrequest(appURL.contains("qa"),appURL);
//        rc.cancelapprovedtimeoffrequest();
//        rc.cancelapprovedtimeoffrequest();
//        rc.cancelapprovedtimeoffrequest();
//        rc.cancelapprovedtimeoffrequest();
//        rc.cancelapprovedtimeoffrequest();
    }
    @Description("Approve Request Time Off from Manager")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority = 6)
    public void ApproveRequestTimeoffforManager() throws InterruptedException {
        new LoginPage(driver).loginAs("WSE_Through_API");
        rc = new Requesttimeoffclass(driver);
        rc.clickontimeoffstepper();
        rc.requesttimeofffunctionforapprove(1,30);
        new ListingPage(driver).signOutApplication();
        new LoginPage(driver).loginAs("Manager_For_New_WSE");
        new ListingPage(driver).clickPeopleTab();
        if(appURL.contains("qa")) {
            new ListingPage(driver).performSearchBy(prop.getProperty("WSE_Through_API_ID"));
        }else{
            new ListingPage(driver).performSearchBy(uatProp.getProperty("WSE_Through_API_ID"));
        }
        rc.openemployeeforaction();
        rc.clickontimeoffstepper();
        rc.approvetimeoffrequest(appURL.contains("qa"),appURL);

    }

    @Description("Approve Request Time Off From HR Admin")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority = 7)
    public void ApproveRequestTimeoffforHRAdmin() throws InterruptedException {
        new LoginPage(driver).loginAs("WSE_Through_API");
        rc = new Requesttimeoffclass(driver);
        rc.clickontimeoffstepper();
        rc.requesttimeofffunctionforapprove(1,60);
        new ListingPage(driver).signOutApplication();
        new LoginPage(driver).loginAs("CLIENT HR");
        new ListingPage(driver).clickPeopleTab();
        if(appURL.contains("qa")) {
            new ListingPage(driver).performSearchBy(prop.getProperty("WSE_Through_API_ID"));
        }else{
            new ListingPage(driver).performSearchBy(uatProp.getProperty("WSE_Through_API_ID"));
        }
        rc.openemployeeforaction();
        rc.clickontimeoffstepper();
        rc.approvetimeoffrequest(appURL.contains("qa"),appURL);
        rc.verifySuccessMessage();
    }

    @Description("Approve Request Time Off From HR Admin WSE Side")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority = 8)
    public void ApproveRequestTimeoffforHRAdminWSE() throws InterruptedException {
        new LoginPage(driver).loginAs("WSE_Through_API");
        rc = new Requesttimeoffclass(driver);
        rc.clickontimeoffstepper();
        rc.requesttimeofffunctionforapprove(1,65);
        new ListingPage(driver).signOutApplication();
        new LoginPage(driver).loginAs("HR_ADMIN_WSE");
        new ListingPage(driver).clickPeopleTab();
        if(appURL.contains("qa")) {
            new ListingPage(driver).performSearchBy(prop.getProperty("WSE_Through_API_ID"));
        }else{
            new ListingPage(driver).performSearchBy(uatProp.getProperty("WSE_Through_API_ID"));
        }
        rc.openemployeeforaction();
        rc.clickontimeoffstepper();
        rc.approvetimeoffrequest(appURL.contains("qa"),appURL);
    }

    @Description("Edit and timeoff request")
    @Owner("shahzaiba.contractor@elementsgs.com")
    @Test(groups = {"Regression"}, priority = 9)
    public void Edittimeoffrequestandapprove() throws InterruptedException {
        new LoginPage(driver).loginAs("WSE_Through_API");
        rc = new Requesttimeoffclass(driver);
        rc.clickontimeoffstepper();
        rc.requesttimeofffunctionforapprove(1,70);
        rc.edittimeoffrequest(1,75);
        new ListingPage(driver).signOutApplication();
        new LoginPage(driver).loginAs("HR_ADMIN_WSE");
        new ListingPage(driver).clickPeopleTab();
        if(appURL.contains("qa")) {
            new ListingPage(driver).performSearchBy(prop.getProperty("WSE_Through_API_ID"));
        }else{
            new ListingPage(driver).performSearchBy(uatProp.getProperty("WSE_Through_API_ID"));
        }
        rc.openemployeeforaction();
        rc.clickontimeoffstepper();
        rc.approvetimeoffrequest(appURL.contains("qa"),appURL);
    }

}
