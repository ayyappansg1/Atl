package pages.roles;

import helper.LocalHelper;
import objectRepo.Roles.SuperAdminRepo;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class RolesandPermissionHelper extends SuperAdminRepo {
    protected static final Logger logger = LoggerFactory.getLogger(SuperAdminHelper.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;

//    public static String welcome_Msg = "";

    public RolesandPermissionHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickDashboard() {
        verifyOopsErrPage();
            WebDriverWait wait = new WebDriverWait(driver, 40);
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
            driver.findElement(dashboard).click();
            driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
            String text = driver.findElement(By.className("dashboard-min__title")).getText();
            System.out.println(text);
            assertTrue(text.contains("Welcome to Atlas"));
            logger.info("Dashboard is verified");
    }
    public void verifyOopsErrPage(){
        if(localHelper.verifyElement(oops_err,3,driver)){
            logger.error("We are getting the error on our DashBoard page.");
            localHelper.hardRefresh(driver);
            localHelper.jsExecutorClick(dashboard,driver);
        }else {
            logger.info("DashBoard page has launched successfully");
        }
    }

    public void clickPeople() throws InterruptedException {
        localHelper.clickElement(people,driver);
        Assert.assertTrue(localHelper.verifyElement(people,driver));
        logger.info("People Tab is Verified");
    }
    public void clickmanagerPeople()  {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(people));
        driver.findElement(people).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        WebElement EmployeeTab = driver.findElement(employeeTab);
//        Assert.assertTrue(EmployeeTab.isDisplayed());
        logger.info("People Tab is Verified");
    }

    public void checkManagerActiveEmployeeStatus() {
        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='table__row__header column-status']")));
        WebElement statusColumn = driver.findElement(By.xpath("//*[@class='table__row__header column-status']"));
        Assert.assertTrue(statusColumn.isDisplayed());
        logger.info("Manager Active Employee status is verified");
    }

    public void taskWidgetVisible() {
        WebDriverWait wait = new WebDriverWait(driver, 40);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='task-header']")));

        WebElement taskwidget = driver.findElement(By.xpath("//*[@class='task-header']"));
        Assert.assertTrue(taskwidget.isDisplayed());
        logger.info("Task widget is verified");

    }

    public void clickPay()  {
        driver.findElement(pay).click();
        WebDriverWait wait = new WebDriverWait(driver, 40);

        wait.until(ExpectedConditions.visibilityOfElementLocated(employee_pay));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement EmployeePay = driver.findElement(employee_pay);
        Assert.assertTrue(EmployeePay.isDisplayed());
        logger.info("Pay Tab is Verified");
    }

    public void clickReports() {

        driver.findElement(reports).click();
        WebDriverWait wait = new WebDriverWait(driver, 40);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("reports-list__heading")));
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        String text = driver.findElement(By.className("reports-list__heading")).getText();
        assertTrue(text.contains("Reports"));
        logger.info("Report Tab is verified");
    }

    public void clickInsights() {

        driver.findElement(Insights).click();
        logger.info("Insights Tab is verified");

    }

    public void clickSettings() {
        driver.findElement(settings).click();
        driver.findElement(accountUsers).click();
        logger.info("Account users is clicked");
        driver.findElement(settings).click();
        driver.findElement(expansionHub).click();
        logger.info("ExpansionHub is clicked");
        driver.findElement(settings).click();
        driver.findElement(implementations).click();
        logger.info("Implementation is clicked");
        driver.findElement(settings).click();
        driver.findElement(manageBenefits).click();
        logger.info("ManageBenefits is clicked");
        driver.findElement(settings).click();
        driver.findElement(manageTimeOff).click();
        logger.info("Manage Time off is clicked");
        driver.findElement(settings).click();
        driver.findElement(systemFiles).click();
        logger.info("SystemFiles is clicked");
        driver.findElement(settings).click();
        driver.findElement(rolesnperm).click();
        logger.info("Roles and Permission is clicked");
        driver.findElement(settings).click();
        driver.findElement(timeTracking).click();
        logger.info("TimeTracking is clicked");
        driver.findElement(countrySetup).click();
        logger.info("TimeTracking is clicked");
        driver.findElement(payGroupSetup).click();
        logger.info("TimeTracking is clicked");

    }

    public void clickEmployeeBtn() {

        driver.findElement(people).click();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        driver.findElement(add_employee).click();
        String actualTitle = "Add Employee";
        String expectedTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div[3]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[1]/div/div[2]/div/div[1]")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println("Assert Passed");
    }
    public void checkpermissionswithinvalidURLS(String[] Array) {
        for (String s : Array) {
            driver.navigate().to(s);
            String text = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/span")).getText();
            Assert.assertEquals(text, "Your Atlas role does not have permission to access this page.\n" +
                    "Please contact your site administrator.");
        }
    }

    public boolean DashBoardTab_IsPresent() {
        return localHelper.verifyElement(dashboard,10, driver);
    }
    public boolean PeopleTab_IsPresent() {
        return localHelper.verifyElement(people,10, driver);
    }

    public boolean Profile_IsPresent() {
        return localHelper.verifyElement(profile,10, driver);
    }
    public boolean PayTab_IsPresent() {
        return localHelper.verifyElement(pay,10, driver);
    }
    public boolean ReportsTab_IsPresent() {
        return localHelper.verifyElement(reports,10, driver);
    }
    public boolean HrAdminWSE_Learning() {
        return localHelper.verifyElement(learning,10, driver);
    }

    public boolean InsightsTab_IsPresent() {
        return localHelper.verifyElement(Insights,10, driver);
    }
    public boolean SettingsTab_IsPresent() {
        return localHelper.verifyElement(settings,10, driver);
    }

    public void clickSettingsTab() {
        localHelper.scrollIntoView(settings,driver);
        localHelper.clickElement(settings,driver);
    }
    public boolean accountsUsers_IsPresent() {
        return localHelper.verifyElement(accountUsers,10, driver);
    }
    public boolean expansionHub_IsPresent() {
        return localHelper.verifyElement(expansionHub,10, driver);
    }
    public boolean implementations_IsPresent() {
        return localHelper.verifyElement(implementations,10, driver);
    }
    public boolean manageBenefits_IsPresent() {
        return localHelper.verifyElement(manageBenefits,10, driver);
    }
    public boolean manageTimeOff_IsPresent() {
        return localHelper.verifyElement(manageTimeOff,10, driver);
    }
    public boolean systemFiles_IsPresent() {
        return localHelper.verifyElement(systemFiles,10, driver);
    }
    public boolean timeTracking_IsPresent() {
        return localHelper.verifyElement(timeTracking,10, driver);
    }
    public boolean countrySetup_IsPresent() {
        return localHelper.verifyElement(countrySetup,10, driver);
    }
    public boolean payGroupSetup_IsPresent() {
        return localHelper.verifyElement(payGroupSetup,10, driver);
    }
    public boolean rolesAndPerm_IsPresent() {
        return localHelper.verifyElement(rolesnperm,10, driver);
    }

 /*   public String getWelcome_Msg() {
        localHelper.verifyEnabledElement(welcomeMsg,driver);
        welcome_Msg = localHelper.getText(welcomeMsg,driver);
        new TestUtil().update_Properties("common/CommonProp","DASHBOARD_MSG",welcome_Msg);
        return welcome_Msg;
    }

  */

    public void dashBoard_verification(){
        String text = localHelper.getText(welcomeMsg,driver);
        assertTrue(text.contains("Welcome to Atlas"));
        logger.info("Dashboard is verified");
    }


    public String insideDashBoard(){
        return localHelper.getText(welcomeMsg,driver); }

    public String insidePeople(){
        return localHelper.getText(peopleMsg,driver); }

    public String insidePay(){
        return localHelper.getText(payMsg,driver); }

    public String insideReports(){
        return localHelper.getText(reportsMsg,driver); }

    public String insideInsight(){
        return localHelper.getText(insightMsg,driver); }

    public boolean noInsight() throws InterruptedException {
        return localHelper.verifyElement(insight_Disabledtxt,driver); }

    public String insideAccountsUsers(){
        return localHelper.getText(accountsUsersMsg,driver); }

}

