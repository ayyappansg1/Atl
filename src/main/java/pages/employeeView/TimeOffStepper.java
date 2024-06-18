package pages.employeeView;

import helper.LocalHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import objectRepo.commonRepo.TimeOff;
import org.testng.Assert;
import pages.internalHRSD.EmployeeHelper;

public class TimeOffStepper extends TimeOff{
	 protected static final Logger logger = LoggerFactory.getLogger(EmployeeHelper.class);
	    private final WebDriver driver;
		private LocalHelper localHelper;
	    
//	    Properties prop1 = new TestUtil().init_Properties("common/Login");
	    
	    public TimeOffStepper(WebDriver driver){
	        this.driver = driver;
	    }
	    
	    public void clickontimeoff()
	    {
	    	WebDriverWait wait= new WebDriverWait(driver,20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(timeoff));
	        try {
				driver.findElement(timeoff).click();
			}catch (ElementClickInterceptedException e){
				localHelper.clickElement(timeoff,driver);
			}
	    }
	    
	    public void clickonrequesttimeoffandadddetails(boolean url)
	    {
			if(url) {
				driver.findElement(requesttimeoff).click();
				driver.findElement(timeofftype).click();
				driver.findElement(timeofftypesearch).sendKeys("Canada Time off policy");
				driver.findElement(selecttimeofftype).click();
				driver.findElement(fromdate).click();
				driver.findElement(By.xpath("//*[@class='react-datepicker__day react-datepicker__day--014']")).click();

				driver.findElement(todate).click();

				WebElement element = driver.findElement(requestsubmit);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);


				driver.findElement(By.xpath("//*[@class='react-datepicker__day react-datepicker__day--014']")).click();

				driver.findElement(requestsubmit).click();
			}
			else{
				driver.findElement(requesttimeoff).click();
				driver.findElement(timeofftype).click();
				driver.findElement(timeofftypesearch).sendKeys("Sick Leave");
				driver.findElement(selecttimeofftype).click();
				driver.findElement(fromdate).click();
				driver.findElement(By.xpath("//*[@class='react-datepicker__day react-datepicker__day--014']")).click();

				driver.findElement(todate).click();

				WebElement element = driver.findElement(requestsubmit);
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);


				driver.findElement(By.xpath("//*[@class='react-datepicker__day react-datepicker__day--014']")).click();

				driver.findElement(requestsubmit).click();


			}
	    }
	    
	    public void verifyrequestonmanagerside()
	    {
	    	WebDriverWait wait= new WebDriverWait(driver,20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(timeOffTaskLink));
	    	String text = driver.findElement(timeOffTaskLink).getText();
	    	Assert.assertEquals("Approve Time Off Request", text);
	    }
	    
	    public void editrequest()   {

	    	WebElement element = driver.findElement(cardscroll);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	    	driver.findElement(editbutton).click();
	    	driver.findElement(todate).click();

	    	WebElement element1 = driver.findElement(requestsubmit);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);

	    	
	    	driver.findElement(By.xpath("//*[@class='react-datepicker__day react-datepicker__day--019']")).click();

	        driver.findElement(requestsubmit).click();
	    	
	    }
	    
	    public void rejectrequest() 	    {
	    	WebDriverWait wait= new WebDriverWait(driver,20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(timeOffTaskLink));
	        
	    	driver.findElement(timeOffTaskLink).click();
	    	WebElement element1 = driver.findElement(declinebutton);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);

	    	driver.findElement(declinebutton).click();
	    	driver.findElement(declinebtn).click();
	    	
	    }
	    
	    public void clickontimesheet() 	    {
	    	driver.findElement(dashboard).click();
	    	WebDriverWait wait= new WebDriverWait(driver,20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(timesheet));
	        driver.findElement(timesheet).click();
	       
	    }
	    
	    public void submittimesheet()   {
	    	
	    	WebDriverWait wait= new WebDriverWait(driver,20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(submittimesheet));
	        driver.findElement(submittimesheet).click();
	        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/div/div/div[4]/div[2]/div/div[3]/button")).click();
	    }
	    
	    public void rejecttimesheet()   {
	    	WebDriverWait wait= new WebDriverWait(driver,20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(timeSheetTaskLink));
	        
	        driver.findElement(timeSheetTaskLink).click();
	        wait.until(ExpectedConditions.visibilityOfElementLocated(rejectbutton));
	        
	        driver.findElement(rejectbutton).click();
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(poprejectbutton));
	        driver.findElement(poprejectbutton).click();
	    }
	    
	    public void edittimesheet() 	    {
	    	WebDriverWait wait= new WebDriverWait(driver,20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(actionbutton));

	        driver.findElement(actionbutton).click();
	        driver.findElement(starttime).sendKeys("3");
	        driver.findElement(endtime).sendKeys("4");
	        driver.findElement(actionbutton).click();
	    }

}
