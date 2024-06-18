package objectRepo.commonRepo;

import org.openqa.selenium.By;

public class JobDetails_Repo {

    // By locators - Employment Details
    public By targetStartDate_datePicker = By.xpath("//div[@class='dob-date-format'][1]//input");
    public By atlasStartDate_datePicker = By.xpath("//div[@class='dob-date-format'][2]//input");
    public By seniorityDate_datePicker = By.xpath("//div[@class='dob-date-format position-relative']//input");
    public By jobTitle_txt = By.xpath("//input[@name='jobTitle']");
    public By employmentType_dropdown_direct = By.xpath("//div[@data-testid='predictive-search-Employment Type']");

    public By employmentType_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Employment Type')]/following-sibling::span/input");
    public By workingHours_txt = By.xpath("//input[@name='workingHours']");
    public By employmentTerm_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Employment Term')]/following-sibling::span/input");
    public By termEndDate_txt = By.xpath("//div[@class='profile-forms profile-form-gutter'][1]/div[3]//input");
    public By managerName_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Manager Name')]/following-sibling::span/input");
    public By jobDescription_txt = By.xpath("//textarea[@name='jobDescription']");

    //Probation Period
    public By probationYes_radio = By.xpath("//input[@data-testId='jobdetails-radio1']");
    public By installmentYes_radio = By.xpath("//input[@data-testid='jobinfo-radio3']");
    public By probationNo_radio = By.xpath("//input[@data-testId='jobdetails-radio2']");
    public By probationPeriodUnit_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Probation Period Unit')]/following-sibling::span/input");
    public By installment_dropdown = By.xpath("//div[@data-testid='predictive-search-Installment Type']");
    public By installment_dropdown_values = By.xpath("//div[@data-testid='predictive-search-Installment Type']//input");

    public By Requisition_dropdown = By.xpath("//div[@data-testid='predictive-search-Requisition Type']");
    public By Requisition_dropdown_values = By.xpath("//div[@data-testid='predictive-search-Requisition Type']//input");
    public By payGroup_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Pay Group')]/following-sibling::span/input");
    public By probationNumber_txt = By.xpath("//input[@data-testId='prob-days']");

    //Compensation
    public By compensationPayType_dropdown = By.xpath("//div[@class='form-label'][contains(text(),'Pay Type')]/following-sibling::div/div/div/div/input");
    public By compensationCurrency_dropdown = By.xpath("//div[@class='form-label'][contains(text(),'Currency')]/following-sibling::div/div/div/div/input");
    public By compensationAmount_txt = By.xpath("//input[@data-testId='amount']");
    public By compensationStatutoryInstallments_txt = By.xpath("//input[@data-testId='installments']");
    public By compensationAdditionalPayment_chkbx = By.xpath("//input[@data-testId='additional-check']");
    public By compensationAdditionalPayment_txt= By.xpath("//input[@data-testId='additional']");
    public By overtime_dropDown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Overtime')]/following-sibling::span/input");
    public By frequency_dropDown = By.xpath("//span[text()='Frequency']//following-sibling::span//input[@id='input-text']");
    public By currency_dropdown = By.xpath("//span[text()='Currency']//following-sibling::span/input");

    //Work Location
    public By sameAsHomeAddress_checkBox = By.xpath("//input[@data-testId='home-address-check']");
    public By workCountry_dropdown = By.xpath("//div[@class='form-label'][contains(text(),'Work Country')]/following-sibling::div/div/div/div[2]/input");
    public By state_txt = By.xpath("//input[@data-testId='province']");
    public By addressLine1_txt = By.xpath("//input[@data-testId='address1']");
    public By addressLine2_txt = By.xpath("//input[@data-testId='address2']");
    public By city_txt = By.xpath("//input[@data-testId='city']");
    public By postalCode_txt = By.xpath("//input[@data-testId='postal']");

    //Off-boarding Details
    public By numberOfDaysWeeksMonths_txt = By.xpath("//input[@data-testId='empr-off-days']");
    public By employerNoticePeriodUnit_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Employer Notice Period unit')]/following-sibling::span/input");
    public By numberOfDaysWeeksMonths2_txt = By.xpath("//input[@data-testId='emp-off-days']");
    public By employeeNoticePeriodUnit_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Employee Notice Period unit')]/following-sibling::span/input");

    //Retirement Details
    public By retirementAge_txt = By.xpath("//input[@data-testId='retage']");
    public By lppid = By.xpath("//input[@data-testId='lpp-id']");
    public By nonCompeteYes_radio = By.xpath("//input[@data-testId='jobinfo-radio5']");
    public By nonCompeteNo_radio = By.xpath("//input[@data-testId='jobinfo-radio6']");
    public By collectiveAgreementYes_radio = By.xpath("//input[@data-testId='jobinfo-radio7']");
    public By collectiveAgreementNo_radio = By.xpath("//input[@data-testId='jobinfo-radio8']");

    // Footer
    public By previous_btn = By.xpath("//button[@data-testId='previous-btn']");
    public By scrolll=By.xpath("(//div[@class='title-payment'])[3]");
    public By atlas_Loader = By.xpath("//div[@class='loaderContainer']");
    public By next_btn = By.xpath("//button[@data-testid='next_btn']");
    public By save_btn = By.xpath("//button[@data-testId='save_btn']");

    // Predictive search dropdown
    public By dropdown_Values = By.xpath("//ul[@class='option-list']/li");
    public By dropdown_First_Values = By.xpath("//ul[@class='option-list']/li");
    public By dropdown_First_First_Values = By.xpath("(//ul[@class='option-list']/li)[1]");


    public By dropDownActiveElement = By.xpath("//ul[@class='option-list']/li[@class='active]");
    public By noOptions_popupDropdownTxt = By.xpath("//ul[@class='option-list']/div[@class='no-option-text']");

    public By search_txt = By.xpath("//input[@name='search']");
    public By jobDetail_Stepper = By.xpath("//div[@data-testId='progress-step-2']/span[2]");
    public By submitStepper=By.xpath("//span[text()='SUBMIT']");
}
