package pages.employeeView;

import java.util.concurrent.TimeUnit;

import helper.LocalHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import objectRepo.employeeViewRepo.EmployeeAssert_Repo;

public class EmployeeAssert extends EmployeeAssert_Repo{
	
	private final WebDriver driver;

	private final LocalHelper localHelper = new LocalHelper();

    public EmployeeAssert(WebDriver driver){
        this.driver = driver;
    }
    
    public void assertProfile() {
    	
    		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
	    	String actualText = driver.findElement(personalInfo).getText();
		    	String expectedText = "Personal Information";
		    	Assert.assertEquals(actualText, expectedText);
    }
    
    public void assertProfileName() {

    		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(profile).click();
			WebDriverWait wait= new WebDriverWait(driver,50);
			wait.until(ExpectedConditions.visibilityOfElementLocated(employeeName));
			localHelper.verifyEnabledElement(employeeName,driver);
	    	String headerEmployeeName = driver.findElement(employeeName).getText();
	    	String firstName = driver.findElement(By.xpath("//*[@data-testid='fname']")).getAttribute("value");
	    	String surName = driver.findElement(By.xpath("//*[@data-testid='lname']")).getAttribute("value");
	    	String username = firstName + " " + surName;
		    	Assert.assertEquals(headerEmployeeName, username);
	
    }
    
    public void assertEmpDashboard() {
    	
    	driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    	driver.findElement(dashboard).click();
		String actualText = driver.findElement(timeTracker).getText();
		String expectedText = "Time Tracker";
		WebElement clockInBtn = driver.findElement(clockIn);
		Assert.assertEquals(actualText, expectedText);
		Assert.assertTrue(clockInBtn.isDisplayed());
    }
    
    public void assertemplearningmodule() {
    	WebElement learningmodule = driver.findElement(learning);
		Assert.assertTrue(learningmodule.isDisplayed());
    }

}
