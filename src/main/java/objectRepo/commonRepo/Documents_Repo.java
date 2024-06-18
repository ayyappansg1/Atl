package objectRepo.commonRepo;

import org.openqa.selenium.By;

public class Documents_Repo {

    public By documents_Header = By.xpath("(//span[text()='Documents'])[2]");
    public By countryProject_dropdown = By.xpath("//input[@id='input-text']");
    public By countryTemplate_dropdown = By.xpath("//div[@data-testid='predictive-search-Select Country Template']");
    public By closeDropdown = By.xpath("//*[@id='svg-icon'][1]");
    public By documentStepper=By.xpath("//div[@data-testid='progress-step-4']//span[text()='Documents']");
    
    public By confirmTemplate_btn = By.xpath("//button[@data-testId='template_btn']/span");
    public By selectionConfirmed_text = By.xpath("//div[@class='status-documents']");

    public By allTask_checkbox = By.xpath("//input[@name='allTask']");
    public By popupOk = By.xpath("//span[text()='Okay']");

    public By task_checkbox = By.xpath("//input[@type='checkbox']");
    public By next_btn_internal = By.xpath("//button[@data-testId='save-doc']");
    public By submitProfile_button = By.xpath("//button[@data-testId='fin-btn']");
    public By next_btn = By.xpath("//button[@data-testId='next_btn']");

    public By uploadPending_text = By.xpath("//div[@class='a-fhandler__label']/span/span");
    public By uploadPending_checkBox = By.xpath("//div[@class='a-fhandler__label']/span/span/ancestor::div[@class='a-fhandler']/div/input");
    public By gotIt_btnInPopup = By.xpath("//button[@class='a-button primary-blue small missing-got-it']");
    public By gotIt_btnTxtInPopup = By.xpath("//button[@class='a-button primary-blue small missing-got-it']/span");
    public By yesContinue_btnInPopup = By.xpath("//button[@data-testid='continue-btn-pending']");
    public By noOptions_popupDropdownTxt = By.xpath("//div[@class='custom-select-box__menu-notice custom-select-box__menu-notice--no-options css-1gl4k7y']");

    // Hidden dropdown element
    public By dropdown_Values = By.xpath("//div[@class='a-predictivesearch__option']/ul/li");
    public By dropdown_Values_first = By.xpath("(//div[@class='a-predictivesearch__option']/ul/li)[2]");


    // Employee
    public By next_btn_employee = By.xpath("//button[@data-testId='next-doc']");
    public By previous_btn = By.xpath("//button[@data-testId='back-button']");
    public By atlas_Loader = By.xpath("//div[@class='loaderContainer']");
}
