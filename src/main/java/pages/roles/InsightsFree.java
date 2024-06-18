package pages.roles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import objectRepo.Roles.SuperAdminRepo;

public class InsightsFree extends SuperAdminRepo{
    protected static final Logger logger = LoggerFactory.getLogger(InsightsFree.class);
    private final WebDriver driver;
    
    public InsightsFree(WebDriver driver){
        this.driver = driver;
    }
    
    public void asserttabs()
    {
    	WebDriverWait wait= new WebDriverWait(driver,20);
        WebElement element = driver.findElement(insightfreecountriestab);
        wait.until(ExpectedConditions.visibilityOfElementLocated(insightfreecountriestab));
        
    	WebElement countriestab = driver.findElement(insightfreecountriestab);
		Assert.assertTrue(countriestab.isDisplayed());
    	
    	WebElement articlestab = driver.findElement(insightfreearticlestab);
		Assert.assertTrue(articlestab.isDisplayed());
    	
    	WebElement docshoptab = driver.findElement(insightfreedocshoptab);
		Assert.assertTrue(docshoptab.isDisplayed());
    	
    	WebElement queriestab = driver.findElement(insightfreequeriestab);
		Assert.assertTrue(queriestab.isDisplayed());
    }
    
    public void assertbuttons()
    {
    	WebDriverWait wait= new WebDriverWait(driver,20);
        WebElement element = driver.findElement(askanquestion);
        wait.until(ExpectedConditions.visibilityOfElementLocated(askanquestion));
        
        WebElement askanquestionbutton = driver.findElement(askanquestion);
		Assert.assertTrue(askanquestionbutton.isDisplayed());
    	
    	WebElement comparecountriesbutton = driver.findElement(comparecountries);
		Assert.assertTrue(comparecountriesbutton.isDisplayed());
    }
    
    public void assertinsighttab()
    {
    	WebDriverWait wait= new WebDriverWait(driver,50);
        WebElement element = driver.findElement(insighttab);
        wait.until(ExpectedConditions.visibilityOfElementLocated(insighttab));
        
        driver.findElement(insighttab).click();
        WebElement insighttabvisible = driver.findElement(insighttab);
		Assert.assertTrue(insighttabvisible.isDisplayed());
    }
    
    public void askanexpertheading()
    {
    	driver.findElement(insighttab).click();
    	driver.findElement(askanquestion).click();
    	WebElement heading = driver.findElement(askanexpertheading);
		Assert.assertTrue(heading.isDisplayed());
    	
    }
    
    public void getallcountriescountofamericas(String actualcount)
    {
    	WebDriverWait wait= new WebDriverWait(driver,20);
        WebElement element = driver.findElement(Americas);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Americas));
    	driver.findElement(Americas).click();
    
    	List<WebElement> c = element.findElements(cardwrapper);
    	int size = c.size();
    	Assert.assertEquals(actualcount,size);
    }
    public void getallcountriescountofeastasiapacific(String actualcount)
    {
    	driver.findElement(EastAsiaPacific).click();
    	List<WebElement> count = (List<WebElement>) driver.findElement(cardwrapper);
    	int size = count.size();
    	Assert.assertEquals(actualcount,size);
    }
    public void getallcountriescountofeuropecentralasia(String actualcount)
    {
    	driver.findElement(EuropeCentralAsia).click();
    	List<WebElement> count = (List<WebElement>) driver.findElement(cardwrapper);
    	int size = count.size();
    	Assert.assertEquals(actualcount,size);
    }
    public void getallcountriescountofmiddleeastnorthafrica(String actualcount)
    {
    	driver.findElement(MiddleEastNorthAfrica).click();
    	List<WebElement> count = (List<WebElement>) driver.findElement(cardwrapper);
    	int size = count.size();
    	Assert.assertEquals(actualcount,size);
    }
    public void getallcountriescountofsouthasia(String actualcount)
    {
    	driver.findElement(SouthAsia).click();
    	List<WebElement> count = (List<WebElement>) driver.findElement(cardwrapper);
    	int size = count.size();
    	Assert.assertEquals(actualcount,size);
    }
    public void getallcountriescountofsubsaharanafrica(String actualcount)
    {
    	driver.findElement(SubSaharanAfrica).click();
    	List<WebElement> count = (List<WebElement>) driver.findElement(cardwrapper);
    	int size = count.size();
    	Assert.assertEquals(actualcount,size);
    }
    
    public void clickonsettingsaccountusers()
    {
    	driver.findElement(settings).click();
    	
    	 WebElement insighttabvisible = driver.findElement(	By.xpath("//*[@data-testid='accounts-&-users-test-id']"));
		Assert.assertTrue(insighttabvisible.isDisplayed());
    
    }
    
    public void assertallregions()
    {
    	WebDriverWait wait= new WebDriverWait(driver,40);
        WebElement element = driver.findElement(Americas);
        wait.until(ExpectedConditions.visibilityOfElementLocated(Americas));
        
    	 WebElement America= driver.findElement(Americas);
		Assert.assertTrue(America.isDisplayed());
      	
      	 WebElement EastAsiaPacifictab = driver.findElement(EastAsiaPacific);
		Assert.assertTrue(EastAsiaPacifictab.isDisplayed());
      	
      	 WebElement EuropeCentralAsiatab = driver.findElement(EuropeCentralAsia);
		Assert.assertTrue(EuropeCentralAsiatab.isDisplayed());
      	
      	 WebElement MiddleEastNorthAfricatab = driver.findElement(MiddleEastNorthAfrica);
		Assert.assertTrue(MiddleEastNorthAfricatab.isDisplayed());
      	
      	 WebElement SouthAsiatab = driver.findElement(SouthAsia);
		Assert.assertTrue(SouthAsiatab.isDisplayed());
      	
      	 WebElement SubSaharanAfricatab = driver.findElement(SubSaharanAfrica);
		Assert.assertTrue(SubSaharanAfricatab.isDisplayed());
      	
      	 
    	
    }


}
