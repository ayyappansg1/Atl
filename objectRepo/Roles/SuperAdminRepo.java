package objectRepo.Roles;

import org.openqa.selenium.By;

public class SuperAdminRepo {
		
		// get all locators
	
		public By dashboard = By.xpath("//div[@data-testid='sidebar__item_Dashboard']");
	public By oops_err = By.xpath("//span[@class='module-not-loaded body-message']");

	public By people = By.xpath("//div[@data-testid='sidebar__item_People']");
		public By pay = By.xpath("//div[@data-testid='sidebar__item_Pay']");
		public By profile = By.xpath("//div[@data-testid='sidebar__item_Profile']");
		public By reports = By.xpath("//div[@data-testid='sidebar__item_Reports']");
		public By learning = By.xpath("//div[@data-testid='sidebar__item_Learning']");
		public By Insights = By.xpath("//div[@data-testid='sidebar__item_Insights']");
		public By settings = By.xpath("//div[@data-testid='sidebar__item_Settings']");
		public By employeeTab = By.xpath("//*[@data-testid='tab-button-test-key-employees']");
		public By add_employee = By.xpath("//*[@data-testid='add-employee-button']"); 
		public By employee_pay = By.xpath("//*[@data-testid='tab-button-test-key-employees_pay']");
		public By accountUsers = By.xpath("//div[@class='list-items']/p[@data-testid='accounts-&-users-test-id']");
		public By expansionHub = By.xpath("//div[@class='list-items']/p[@data-testid='expansion-hub-test-id']");
		public By implementations =By.xpath("//div[@class='list-items']/p[@data-testid='implementations-test-id']");
		public By manageBenefits = By.xpath("//div[@class='list-items']/p[@data-testid='manage-benefits-test-id']");
		public By manageTimeOff = By.xpath("//div[@class='list-items']/p[@data-testid='manage-time-off-test-id']");
		public By systemFiles = By.xpath("//div[@class='list-items']/p[@data-testid='system-files-test-id']");
		public By rolesnperm = By.xpath("//div[@class='list-items']/p[@data-testid='roles-&-permissions-test-id']");
		public By timeTracking = By.xpath("//div[@class='list-items']/p[@data-testid='manage-time-tracking-test-id']");
		public By countrySetup = By.xpath("//div[@class='list-items']/p[@data-testid='country-setup-test-id']");
		public By payGroupSetup = By.xpath("//div[@class='list-items']/p[@data-testid='pay-group-setup-test-id']");
		public By insightfreecountriestab = By.xpath("//*[@data-testid='Countries']");
		public By insightfreearticlestab = By.xpath("//*[@data-testid='Articles']");
		public By insightfreedocshoptab = By.xpath("//*[@data-testid='Doc Shop']");
		public By insightfreequeriestab = By.xpath("//*[@data-testid='Queries']");
		public By insighttab = By.xpath("//*[@data-testid='sidebar__item_Insights']");
		public By askanquestion = By.xpath("//*[@data-testid='ask-an-expert-button']");
		public By comparecountries = By.xpath("//*[@data-testid='compare-btn']");
		public By askanexpertheading = By.xpath("//*[@class='ask-an-expert-label']");
		 public By Americas = By.xpath("(//*[@class='nav-item active'])[1]");
		 public By EastAsiaPacific = By.xpath("(//*[@class='nav-item active'])[2]");
		 public By EuropeCentralAsia = By.xpath("(//*[@class='nav-item active'])[3]");
		 public By MiddleEastNorthAfrica = By.xpath("(//*[@class='nav-item active'])[4]");
		 public By SouthAsia = By.xpath("(//*[@class='nav-item active'])[5]");
		 public By SubSaharanAfrica = By.xpath("(//*[@class='nav-item active'])[6]");
		 public By cardwrapper = By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/div/div/div[2]/div[3]/div");
		
		 public By welcomeMsg = By.className("dashboard-min__title");
		 public By peopleMsg = By.xpath("//button[text()='Employees']");
		 public By payMsg = By.xpath("//button[text()='Invoices']");
		 public By reportsMsg = By.xpath("//div[text()='Reports']");
		 public By insightMsg = By.xpath("//div[text()='Countries']");
		 public By insight_Disabledtxt = By.xpath("//div[@data-testid='no-access-div-test']");

		 //Inside settings

		public By accountsUsersMsg = By.xpath("//span[text()='Accounts & Users']");
}