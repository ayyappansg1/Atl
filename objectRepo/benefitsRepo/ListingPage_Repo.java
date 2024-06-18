package objectRepo.benefitsRepo;

import org.openqa.selenium.By;

public class ListingPage_Repo {

    // By Locators - Search & Filters
    public By search_input = By.xpath("//input[@name='employee-list-search']");

    public By providerDropdown = By.xpath("//span[@class='a-dropdown__title'][contains(text(),'Provider Name')]");

    public By providerTest = By.xpath("//span[@class='a-dropdown__option__item multi-select'][contains(text(),'Test Medical')]");

    public By providerLabel = By.xpath("//span[@class='a-dropdown__title'][contains(text(),'Provider')]");

    public By listProviders = By.xpath("//div[@class='table__body']/div/span[2]");

    public By providerPlaceholderText = By.xpath("//span[@class='a-dropdown__label Plan/Provider Name'][contains(text(),'Please Select')]");

    public By typeDropdown = By.xpath("//span[@class='a-dropdown__title'][contains(text(),'Type')]");

    public By typeLabel = By.xpath("//span[@class='a-dropdown__title'][contains(text(),'Type')]");

    public By typePlaceholderText = By.xpath("//span[@class='a-dropdown__label Type'][contains(text(),'Please Select')]");

    public By typeTest = By.xpath("//span[@value='bcdef11b-4f3e-48cd-af8a-18ce9e487f6f'][contains(text(),'Medical')]");

    public By listType = By.xpath("//span[3][@class='table__row__data']");

    public By DropdownOpen = By.xpath("//div[@class='a-dropdown isOpen']");

    public By statusDropdown = By.xpath("//span[@class='a-dropdown__title'][contains(text(),'Status')]");

    public By statusLabel = By.xpath("//span[@class='a-dropdown__title'][contains(text(),'Status')]");

    public By statusPlaceholderText = By.xpath("//span[@class='a-dropdown__label Status'][contains(text(),'Please Select')]");

    public By statusTest = By.xpath("//span[@value='2'][contains(text(),'Draft')]");

    public By listStatus = By.xpath("//div[@class='table__body']/div/span[7]/span");

    // By Locators - Table
    public By listPlanNames = By.xpath("//span[2][@class='table__row__data'][contains(text(), 'Testing Plan')]");

    public By unsuccessfulSearchMessage = By.xpath("//div[@class='p-l-20 sidebar-inner-title']");

    public By customizationButton = By.xpath("//div[@class='three-dots']");

    public By typeCustomization = By.xpath("//span[@class='cd-checkbox-label n-h'][contains(text(), 'Type')]");

    public By saveViewCustomization = By.xpath("//button[@class='a-button primary-blue small']");



    public By clickReset = By.xpath("//div[@class='reset-option'][contains(text(),'Reset')]");

    // By locators - table grid
    public By PlanName = By.xpath("//span[@class='table__row__header column-planName']");
    public By typeInGrid = By.xpath("//span[@class='table__row__header column-type']");
    public By EmployeesEnrolled = By.xpath("//span[@class='table__row__header column-employeeEnrolled']");
    public By StartDate = By.xpath("//span[@class='table__row__header column-startDate']");
    public By EndDate = By.xpath("//span[@class='table__row__header column-endDate']");
    public By Status = By.xpath("//span[@class='table__row__header column-status']");
    public By Action = By.xpath("//span[@class='table__row__header column-action']");

    public By paginationPrev = By.xpath("//button[@id='pagination-prev']");
    public By paginationNext = By.xpath("//button[@id='pagination-next']");
    public By paginationJumpTo = By.xpath("//span[@class='nav-count']/span[contains(text(),'Jump to')]");
    public By paginationGo = By.xpath("//button[@id='pagination-go']");
    public By paginationShowing = By.xpath("//div[@class='pagination__options']/select");

    public By nextButtonEnabled = By.xpath("//button[@id='pagination-next'][@class='nav-active']");
    public By paginationNextButton = By.xpath("//button[@id='pagination-next']/span");
    public By paginationPage_2 = By.xpath("//span[@class='current-count active'][text()='2']");

    public By prevButtonEnabled = By.xpath("//button[@id='pagination-prev'][@class='nav-active']");
    public By paginationPrevButton = By.xpath("//button[@id='pagination-prev']/span");
    public By paginationPage_1 = By.xpath("//span[@class='current-count active'][text()='1']");

    public By paginationJumpTo_Input = By.xpath("//input[@id='jump-to']");
    public By goButton = By.xpath("//button[@id='pagination-go']/span");
    public By paginationPage_3 = By.xpath("//span[@class='current-count active'][text()='3']");

    public By paginationShowingPage = By.xpath("//div[@class='pagination__options']/select");
    public By listingTable = By.xpath("//div[@class='table__row ']");

    public By paginationEnd = By.xpath("//button[@class='nav-active']/following::span[@class='nav-start-end']");
    public By paginationCurrentPage = By.xpath("//span[@class='current-count active']");
    public By paginationTotalPages = By.xpath("//span[@class='total-count']");
    public By paginationStart = By.xpath("//button[@class='nav-active']/preceding::span[@class='nav-start-end']");

    public By addNewPlan = By.xpath("//button[@data-testId='add-new-button']");
    public By addMedicalPlan = By.xpath("//div[@data-testId='add-new-option-0']");
    public By medicalPlanPage = By.xpath("//div[@class='col heading'][contains(text(), 'Plan Details')]");
    public By providerAll = By.xpath("//label[@for='Plan/Provider Name_all'][contains(text(),'Select All')]");
    public By typeAll = By.xpath("//label[@for='Plan Type_all'][contains(text(),'Select All')]");
    public By getProviderOneData = By.xpath("//span[@value='3365ed24-0e9f-4036-bb0a-b9f0ce6dea22']");
    public By getRowOneData = By.xpath("//span[@class='table__row__data'][1]");
    public By getTypeOneData = By.xpath("//span[@value='03df2a8c-edac-49c6-b7e3-7a4712cd537f']");
    public By getRowTwoData = By.xpath("//span[@class='table__row__data'][2]");
    public By searchProvider_txt = By.xpath("//div[@class='a-dropdown__option open']//div//input[@placeholder='Search']");
    public By searchType_txt = By.xpath("//div[@class='a-dropdown__option open']//div//input[@placeholder='Search']");

    public By settings_tab = By.xpath("//div[@data-testId='sidebar__item_Settings']");
    public By manageBenefits_tab = By.xpath("//div[@class='list-items']/p[@id='manage-benefits-menu']");
    public By atlas_loader = By.xpath("//div[@id='atlas-loader']");

}
