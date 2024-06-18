package pages.internalHRSD;

import static org.testng.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import common.TestUtil;
import objectRepo.internalHRSD.ActiveEmployeeRepo;

public class EmployeeHelper extends ActiveEmployeeRepo{
	
	  protected static final Logger logger = LoggerFactory.getLogger(EmployeeHelper.class);
	    private WebDriver driver;
	    Properties prop1 = new TestUtil().init_Properties("employeeview/Employee");
	    
	    public EmployeeHelper(WebDriver driver){
	        this.driver = driver;
	    }
	    
	    public void changestatustoactive() {
	    	driver.findElement(people).click();
	    	// wait to load all the elements
		    	WebDriverWait wait= new WebDriverWait(driver,20);
		        WebElement element = driver.findElement(add_employee_btn);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(add_employee_btn));
		        driver.findElement(searchInput).sendKeys(prop1.getProperty("EMPLOYEE_EMAIL"));
		        driver.findElement(By.xpath("(//*[@class='table__row__data column-clickable'])[1]")).click();
		        driver.findElement(By.xpath("//*[@data-testid='change-status-btn")).click();
		        driver.findElement(By.name("effectiveStartDate")).click();
		        DateFormat dateFormat = new SimpleDateFormat("dd");
				 Date date = new Date();
				 String date1= dateFormat.format(date);
		        driver.findElement(By.name("effectiveStartDate")).sendKeys(date1);
		        driver.findElement(By.className("a-dropdown")).click();
		        driver.findElement(By.xpath("//*[@data-testid='status-drop-4")).click();		      
		        driver.findElement(By.xpath("//*[@data-testid='update-status-button")).click();

	    }
	   
	    public void activeEmployee() { 	
	    	driver.findElement(people).click();
	    	// wait to load all the elements
	    	WebDriverWait wait= new WebDriverWait(driver,20);
	        WebElement element = driver.findElement(add_employee_btn);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(add_employee_btn));
	        driver.findElement(searchInput).sendKeys("Shahzaib");
	        String searchedStatus = driver.findElement(By.xpath("(//*[@class='table__row__data column-clickable'])[6]")).getText();
			 assertTrue(searchedStatus.contains("Active"));
	    }
	   
}
