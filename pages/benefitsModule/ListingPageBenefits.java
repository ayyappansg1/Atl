package pages.benefitsModule;

import helper.LocalHelper;
import objectRepo.benefitsRepo.ListingPage_Repo;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class ListingPageBenefits extends ListingPage_Repo {
    protected static final Logger logger = LoggerFactory.getLogger(ListingPageBenefits.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;

    public ListingPageBenefits(WebDriver driver) {
        this.driver = driver;
    }

    public boolean searchInput_IsPresent() throws InterruptedException {
        return localHelper.verifyElement(search_input,driver);
    }

    public boolean providerDropdown_IsPresent() throws InterruptedException { return localHelper.verifyElement(providerDropdown,driver);}

    public String getProviderLabelText(){ return localHelper.getText(providerLabel,driver);}

    public String getProviderPlaceholderText() {return localHelper.getText(providerPlaceholderText,driver);}

    public void performSearchBy(String value){
        localHelper.sendKeys(search_input,value,driver);
    }

    public String searchByPlanIsSuccessful(String value) {
        return verifySearchResults(listPlanNames,value,driver);
    }

    public void openProviderDropdown() {
        localHelper.clickElement(providerDropdown,driver);
    }

    public void selectProvider(String providerName){
        if(providerName.equalsIgnoreCase("Test Medical")){
            localHelper.jsExecutorClick(providerTest, driver);
        }
    }

    public void closeProviderDropdown(){
        localHelper.clickElement(DropdownOpen,driver);
    }

    public void closeTypeDropdown(){
        localHelper.clickElement(DropdownOpen,driver);
    }

    public void openTypeDropdown() {
        localHelper.clickElement(typeDropdown, driver);
    }

    public void selectType(String typeName) {
        if(typeName.equals("Medical")){
            localHelper.jsExecutorClick(typeTest, driver);
        }
    }

    public String searchByProviderIsSuccessful(String providerName) throws InterruptedException {
        return this.verifyFilteredResults(listProviders, providerName, driver);
    }

    public String searchByTypeIsSuccessful(String typeName) throws InterruptedException {
        return this.verifyFilteredResults(listType, typeName, driver);
    }

    public boolean typeDropdown_IsPresent() throws InterruptedException {return localHelper.verifyElement(typeDropdown,driver);}

    public String getTypeLabelText() {return localHelper.getText(typeLabel, driver);}

    public String getTypePlaceholderText() {return localHelper.getText(typePlaceholderText, driver);}

    public boolean statusDropdown_IsPresent() throws InterruptedException {return localHelper.verifyElement(statusDropdown, driver);}

    public String getStatusLabelText() {return localHelper.getText(statusLabel, driver);}

    public String getStatusPlaceholderText() {return localHelper.getText(statusPlaceholderText, driver);}

    public void openStatusDropdown() {localHelper.clickElement(statusDropdown, driver);}

    public void selectStatus(String statusName) {
        if(statusName.equalsIgnoreCase("Draft")) {
            localHelper.jsExecutorClick(statusTest, driver);
        }
    }

    public void closeStatusDropdown(){
        localHelper.clickElement(DropdownOpen,driver);
    }

    public String searchByStatusIsSuccessful(String statusName) throws InterruptedException {
        return this.verifyFilteredResults(listStatus, statusName, driver);
    }

    public String getUnsuccessfulSearchMessage(){
        return localHelper.getText(unsuccessfulSearchMessage,driver);
    }
    public void clearSearch(){
        localHelper.clearElement(search_input,driver);
    }

    public String verifySearchResults(By element_by, String containedValue, WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver,20);
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                .equals("complete"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));

            List<WebElement> results = driver.findElements(element_by);
            for (WebElement res:results) {
                for(int i=0;i<results.size();i++) {
                    if (!res.getText().toLowerCase().contains(containedValue.toLowerCase())) {
                        logger.info("Found a different value "+res.getText());
                        return res.getText();
                    }
                    else {
                        logger.info(res.getText());
                    }
                }
            }
        return containedValue;
    }

    public String verifyFilteredResults(By element_by, String checkValue, WebDriver driver) throws InterruptedException {
        Thread.sleep(3000); // Loader is not implemented
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(driver1 -> String.
                valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState")).
                equals("complete"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));

        try{
            List<WebElement> results = driver.findElements(element_by);
            for(WebElement res:results){
                for(int i=0;i<results.size();i++){
                    if(!res.getText().equals(checkValue)){
                        logger.info(res.getText());
                        return res.getText();
                    }
                }
            }
        }
        catch(StaleElementReferenceException e) {
            logger.info("Stale Element Reference Exception");
            logger.info(String.valueOf(e));
        }
        return checkValue;
    }

    public boolean customizationButton_IsPresent() throws InterruptedException {
        return localHelper.verifyElement(customizationButton, driver);
    }

    public void clickOnCustomizationButton() {
        localHelper.clickElement(customizationButton, driver);
    }

    public void unClickOnTypeCustomization() {
        localHelper.clickElement(typeCustomization, driver);
    }

    public void saveViewInCustomization() {
        localHelper.clickElement(saveViewCustomization, driver);
    }

    public boolean typeIsPresentInGrid() throws InterruptedException {
        return localHelper.verifyElement(typeInGrid, driver);
    }


    public void clickResetInCustomization() {
        localHelper.clickElement(clickReset, driver);
    }

    public boolean verifyDefaultGridIsPresent() throws InterruptedException {
        return tableHeaderType_IsPresent() && tableHeaderEmployeesEnrolled_IsPresent() && tableHeaderStartDate_IsPresent()
                && tableHeaderEndDate_IsPresent() && tableHeaderStatus_IsPresent();
    }

    public boolean tableHeaderType_IsPresent() throws InterruptedException {
        return localHelper.verifyElement(typeInGrid, driver);
    }

    public boolean tableHeaderEmployeesEnrolled_IsPresent() throws InterruptedException {return localHelper.verifyElement(EmployeesEnrolled, driver);}
    public boolean tableHeaderStartDate_IsPresent() throws InterruptedException {return localHelper.verifyElement(StartDate, driver);}
    public boolean tableHeaderEndDate_IsPresent() throws InterruptedException {return localHelper.verifyElement(EndDate, driver);}
    public boolean tableHeaderStatus_IsPresent() throws InterruptedException {return localHelper.verifyElement(Status, driver);}
    public boolean tableHeaderPlanName_IsPresent() throws InterruptedException {return localHelper.verifyElement(PlanName, driver);}
    public boolean tableHeaderAction_IsPresent() throws InterruptedException {return localHelper.verifyElement(Action, driver);}

    public boolean paginationPrev_IsPresent() throws InterruptedException {return localHelper.verifyElement(paginationPrev, driver);}
    public boolean paginationNext_IsPresent() throws InterruptedException {return localHelper.verifyElement(paginationNext, driver);}
    public boolean paginationJumpTo_IsPresent() throws InterruptedException {return localHelper.verifyElement(paginationJumpTo, driver);}
    public boolean paginationGo_IsPresent() throws InterruptedException {return localHelper.verifyElement(paginationGo, driver);}
    public boolean paginationShowing_IsPresent() throws InterruptedException {return localHelper.verifyElement(paginationShowing, driver);}

    public boolean verifyNextButtonEnabled() {return localHelper.verifyEnabledElement(nextButtonEnabled, driver);}
    public void clickOnNextButton() {
        localHelper.scrollIntoView(paginationNextButton, driver);
        localHelper.clickElement(paginationNextButton, driver);
    }
    public boolean verifyNextPageIsOpened() throws InterruptedException {return localHelper.verifyElement(paginationPage_2, driver);}

    public boolean verifyPrevButtonEnabled() {return localHelper.verifyEnabledElement(prevButtonEnabled, driver);}
    public void clickOnPrevButton() {
        localHelper.scrollIntoView(paginationNextButton, driver);
        localHelper.clickElement(paginationPrevButton, driver);
    }
    public boolean verifyPrevPageIsOpened() throws InterruptedException {return localHelper.verifyElement(paginationPage_1, driver);}

    public boolean verifyJumpToEnabled() {return localHelper.verifyEnabledElement(paginationJumpTo_Input, driver);}
    public void sendValueToJumpTo(String pageNo) {localHelper.jsExecutorSendValue(paginationJumpTo_Input,pageNo,driver);}
    public void clickOnGoButton() {
        localHelper.scrollIntoView(paginationNextButton, driver);
        localHelper.clickElement(goButton, driver);
    }
    public boolean verifyJumpPageIsOpened() throws InterruptedException {return localHelper.verifyElement(paginationPage_3, driver);}

    public void selectPaginationCount(String showingBy) {
        localHelper.scrollIntoView(paginationShowingPage, driver);
        localHelper.selectDropdownByVisibleText(paginationShowingPage,showingBy,driver);
    }
    public boolean showingByThirtyIsDisplayed(String showingBy) {
        return verifyTableRows(listingTable, showingBy, driver);
    }

    public void verifyPaginationEnd() throws InterruptedException { localHelper.verifyElement(paginationEnd, driver); }
    public void clickPaginationEnd() {
        localHelper.scrollIntoView(paginationEnd, driver);
        localHelper.clickElement(paginationEnd, driver);
    }
    public String getCurrentPage(){
        return localHelper.getText(paginationCurrentPage,driver);
    }
    public String getTotalPages(){
        return localHelper.getText(paginationTotalPages,driver);
    }

    public void verifyPaginationStart() throws InterruptedException { localHelper.verifyElement(paginationStart, driver); }
    public void clickPaginationStart() {
        localHelper.scrollIntoView(paginationStart, driver);
        localHelper.clickElement(paginationStart, driver);
    }

    public void clickAddNewPlanButton() {
        localHelper.clickElement(addNewPlan, driver);
    }

    public void clickAddMedicalOption() {localHelper.clickElement(addMedicalPlan, driver);}

    public boolean AddMedical_IsDisplayed() throws InterruptedException {return localHelper.verifyElement(medicalPlanPage, driver);}

    public void selectAllProvider() {
        localHelper.clickElement(providerAll, driver);
    }

    public void selectAllType() {
        localHelper.clickElement(typeAll, driver);
    }

    public boolean verifySelectAllProviderDropdown() {
        String beforeSelectAll = localHelper.getText(getProviderOneData, driver);
        String afterSelectAll = localHelper.getText(getRowOneData, driver);
        return beforeSelectAll.equals(afterSelectAll);
    }

    public boolean verifySelectAllTypeDropdown() {
        String beforeSelectAll = localHelper.getText(getTypeOneData, driver);
        String afterSelectAll = localHelper.getText(getRowTwoData, driver);
        return beforeSelectAll.equals(afterSelectAll);
    }

    public void searchProvider(String providerName) {
        localHelper.sendKeys(searchProvider_txt, providerName, driver);
        localHelper.jsExecutorClick(providerTest, driver);
    }

    public void searchType(String typeName) {
        localHelper.sendKeys(searchType_txt, typeName, driver);
        localHelper.jsExecutorClick(typeTest, driver);
    }

    public void launchBenefits()  {
        localHelper.clickElement(settings_tab,driver);
        localHelper.clickElement(manageBenefits_tab,driver);
        if(localHelper.checkLoader(atlas_loader,driver)){
            logger.info("Loader disappeared");
        }
    }

    public boolean verifyTableRows(By element_by, String verify, WebDriver driver) {
        List<WebElement> rows = driver.findElements(element_by);
        int count = rows.size();
        int verifyCount = Integer.parseInt(verify);
        return count == verifyCount;
    }


}
