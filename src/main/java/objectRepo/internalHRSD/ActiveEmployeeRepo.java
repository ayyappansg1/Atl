package objectRepo.internalHRSD;

import org.openqa.selenium.By;

public class ActiveEmployeeRepo {
	
	public By people = By.xpath("//*[@data-testid='sidebar__item_People']");
	public By add_employee_btn = By.xpath("//*[@data-testid='add-employee-button']"); 
	public By searchInput = By.xpath("//*[@data-testid='search-input']");
	public By searchedName = By.xpath("//*[@class='table__row__data column-clickable'][1]");
	
}
