package pages.roles;

import static org.testng.Assert.assertTrue;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import objectRepo.Roles.SuperAdminRepo;

public class SuperAdminHelper extends SuperAdminRepo{
	
	    protected static final Logger logger = LoggerFactory.getLogger(SuperAdminHelper.class);
	    private final WebDriver driver;
	    
	    public SuperAdminHelper(WebDriver driver){
	        this.driver = driver;
	    }
	    
	    public void clickDashboard(){
	    	WebDriverWait wait= new WebDriverWait(driver,40);
	        WebElement element = driver.findElement(dashboard);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
	    	driver.findElement(dashboard).click();
	    	driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
				String text = driver.findElement(By.className("dashboard-min__title")).getText();
				System.out.println(text);				
			    assertTrue(text.contains("Welcome to Atlas"));
	    }
	    
	    public void clickPeople()  {
	    	WebDriverWait wait= new WebDriverWait(driver,40);
	        WebElement element = driver.findElement(people);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(people));
	    	driver.findElement(people).click();
	    	driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			WebElement EmployeeTab = driver.findElement(employeeTab);
			Assert.assertTrue(EmployeeTab.isDisplayed());
			System.out.println("Assert passed!!");
	    }
	    
	    public void checkmanageractiveemployeestatus()
	    {
	    	WebDriverWait wait= new WebDriverWait(driver,40);
	        WebElement element = driver.findElement(By.xpath("//*[@class='table__row__header column-status']"));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='table__row__header column-status']")));
	    	WebElement statuscolumn = driver.findElement(By.xpath("//*[@class='table__row__header column-status']"));
			Assert.assertTrue(statuscolumn.isDisplayed());
		   
	    }
	    
	    public void taskwidgetvisible()
	    {
	    	WebDriverWait wait= new WebDriverWait(driver,40);
	        WebElement element = driver.findElement(By.xpath("//*[@class='task-header']"));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='task-header']")));
	        
	    	WebElement taskwidget = driver.findElement(By.xpath("//*[@class='task-header']"));
			Assert.assertTrue(taskwidget.isDisplayed());
	    }
	    public void clickPay()  {
	    	driver.findElement(pay).click();
	    	WebDriverWait wait= new WebDriverWait(driver,40);
	        WebElement element = driver.findElement(employee_pay);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(employee_pay));

	    	driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
			WebElement EmployeePay = driver.findElement(employee_pay);
			Assert.assertTrue(EmployeePay.isDisplayed());
	    }
	    
	    public void clickReports() {
	    	
	    	driver.findElement(reports).click();
	    	WebDriverWait wait= new WebDriverWait(driver,40);
	        WebElement element = driver.findElement(By.className("reports-list__heading"));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("reports-list__heading")));
	        
	    	driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
				String text = driver.findElement(By.className("reports-list__heading")).getText();
			        assertTrue(text.contains("Reports"));
	    }
	    
	    public void clickInsights() {
	    	driver.findElement(Insights).click();
	    }
	    
	    public void clickSettings() throws Exception {
	    	driver.findElement(settings).click();
	    	driver.findElement(accountUsers).click();
	    	Thread.sleep(3000);
	    	driver.findElement(settings).click();
	    	driver.findElement(expansionHub).click();
	    	Thread.sleep(3000);
	    	driver.findElement(settings).click();
	    	driver.findElement(implementations).click();
	    	Thread.sleep(3000);
	    	driver.findElement(settings).click();
	    	driver.findElement(manageBenefits).click();
	    	Thread.sleep(3000);
	    	driver.findElement(settings).click();
	    	driver.findElement(manageTimeOff).click();
	    	Thread.sleep(3000);
	    	driver.findElement(settings).click();
	    	driver.findElement(systemFiles).click();
	    	Thread.sleep(3000);
	    	driver.findElement(settings).click();
	    	driver.findElement(rolesnperm).click();
	    	Thread.sleep(3000);
	    	driver.findElement(settings).click();
	    	driver.findElement(timeTracking).click();
	    	Thread.sleep(3000);
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
}
