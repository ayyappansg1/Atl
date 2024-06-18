package objectRepo.employeeViewRepo;

import org.openqa.selenium.By;

public class EmployeeAssert_Repo {
	
	public By profile = By.xpath("//*[@data-testid='sidebar__item_Profile']");
	public By personalInfo = By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/div/div/div/div/div/div/div[2]/div/div/div[2]/div/form/div[1]/span");
	public By employeeName = By.className("name");
	public By firstName = By.xpath("//*[@data-testid='fname']");
	public By surname = By.xpath("//*[@data-testid='lname']");
	public By dashboard = By.xpath("//*[@data-testid='sidebar__item_Dashboard']");
	public By learning = By.xpath("//*[@data-testid='sidebar__item_Learning']");
	public By timeTracker = By.className("widget-heading");
	public By clockIn = By.xpath("//*[@data-testid='clock-in-out-btn']");
}
