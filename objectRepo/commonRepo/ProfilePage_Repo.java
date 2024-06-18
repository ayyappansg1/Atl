package objectRepo.commonRepo;

import org.openqa.selenium.By;

public class ProfilePage_Repo {

    // By locators - Personal Information
    public By firstName_txt = By.xpath("//input[@name='firstName']");
    public By surname_txt = By.xpath("//input[@name='lastName']");
    public By additionalName_txt = By.xpath("//input[@name='middleName']");
    public By atlas_Loader = By.xpath("//div[@class='loaderContainer']");
    public By dob_txt = By.xpath("//input[@name='birthday']");
    																																											
    public By gender_dropdown = By.xpath("//div[@data-testid='predictive-search-Gender']");
    public By gender_text = By.xpath("//span[text()='Gender']");

    public By gender_dropdown_for_value = By.xpath("//div[@data-testid='predictive-search-Gender']//input");

    public By pronoun_dropdown =By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Personal Pronoun')]/following-sibling::span/input");
    public By timeOffPolicy_dropdown = By.xpath("//div[@class=' css-1wy0on6']");
    public By timeOff_Values = By.xpath("//div[@class=' css-1nmdiq5-menu']");
    public By maritalStatus_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Marital Status')]/following-sibling::span/input");
    public By taxNumber_txt = By.xpath("//input[@name='taxId']");
    public static By changeStatus=By.xpath("//span[text()='Change Status']");
    public By wseClassification_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'WSE Classification')]/following-sibling::span/input");
  
    // By locators - Citizenship
    public By citizenshipYes_radio= By.xpath("//input[@id='inlineRadio1']");
    public By citizenshipNo_radio= By.xpath("//input[@id='inlineRadio2']");
    public By homeAddress= By.xpath("//span[text()='Home Address']");
    public By citizenshipCountry1_dropdown= By.xpath("//span[@class='a-predictivesearch__title'][text()='Country of Citizenship']/following-sibling::span/input");
    public By citizenshipID1_txt= By.xpath("//input[@name='citizenship[0].nationalIds[0]']");
    public By citizenshipCountry2_dropdown= By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Country of Citizenship2')]/following-sibling::span/input");
    public By citizenshipID2_txt= By.xpath("//input[@name='citizenship[1].nationalIds[0]']");
    public By citizenshipCountry3_dropdown= By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Country of Citizenship3')]/following-sibling::span/input");
    public By citizenshipID3_txt= By.xpath("//input[@name='citizenship[2].nationalIds[0]']");
    public By citizenshipAdd_btn= By.xpath("//button[@data-testId='add-citizenship']");
    public By verifyEmpDetails_txt=By.xpath("//span[text()='Employment Details']");
    public By retirementAge_txt = By.xpath("//input[@data-testId='retage']");

    // By locators - Home Address
    public By state_txt= By.xpath("//input[@data-testId='province']");
    public By addressLine1_txt= By.xpath("//input[@data-testId='address1']");
    public By addressLine2_txt= By.xpath("//input[@data-testId='address2']");
    public By city_txt= By.xpath("//input[@data-testId='city']");
    public By postalCode_txt= By.xpath("//input[@data-testId='postal']");

    // By locators - Contact Details
    public By workPhone_txt= By.xpath("//input[@name='workPhone']");
    public By mobilePhone_txt= By.xpath("//input[@data-testId='mobile']");
    public By homePhone_txt= By.xpath("//input[@name='homePhone']");
    public By workEmail_txt= By.xpath("//input[@name='officeEmail']");
    public By personalEmail_txt= By.xpath("//input[@name='homeEmail']");

    // Predictive search dropdown
    public By dropdown_gender_one = By.xpath("(//ul[@class='option-list']/li)[1]");
    public By dropdown_Values = By.xpath("//ul[@class='option-list']/li");


    public By save_btn= By.xpath("//button[@data-testId='save_btn']");
    public By next_btn= By.xpath("//button[@data-testId='next_btn']");

    // Employee View
    public By edit_btn = By.xpath("//button[@data-testId='edit-profile']");
    public By cancelEdit_btn = By.xpath("//button[@class='a-button secondary small']");

    // By locators - Personal Information
    public By title_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Title')]/following-sibling::span/input");
    public By suffix_txt = By.xpath("//input[@name='suffix']");
    public By preferredName_txt = By.xpath("//input[@name='preferredName']");
    public By dateOfBirth = By.xpath("//span[text()='Date of Birth']//following-sibling::div/div/input");
    public By taxId_txt = By.xpath("//input[@name='taxId']");

    // By locators - Citizenship
    public By moreThanOneCitizenshipYes_radioBtn = By.xpath("//input[@name='isDualCitizen'][@value='yes']");
    public By moreThanOneCitizenshipNo_radioBtn = By.xpath("//input[@name='isDualCitizen'][@value='no']");
    public By legallyAuthorizedYes_radioBtn = By.xpath("//input[@name='isLegallyAuthorized'][@value='yes']");

    // By locators - Home Address
    public By countryOfResidence_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Country of Residence')]/following-sibling::span/input");

    // By locators - Contact Details
    public By workPhoneCountryCode_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Work Phone')]/following-sibling::span/input");
    public By workPhoneNumber_txt = By.xpath("//input[@name='workPhone']");
    public By mobileCountryCode_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Mobile')]/following-sibling::span/input");
    public By mobileNumber_txt = By.xpath("//input[@name='mobile']");
    public By homePhoneCountryCode_dropdown = By.xpath("//span[@class='a-predictivesearch__title'][contains(text(),'Home Phone')]/following-sibling::span/input");
    public By homePhoneNumber_txt = By.xpath("//input[@name='homePhone']");

    public By prev_btn = By.xpath("//button[@data-testId='back-button']");
    public By save_btn_emp = By.xpath("//button[@data-testId='save-epd']");
    public By next_btn_emp = By.xpath("//button[@data-testId='next-epd']");

    public By closeIcon_popup = By.xpath("//div[@class='a-modal__body']/span[@class='close']");
    public By gotItBtn_popup = By.xpath("//button[@class='a-button primary-blue small missing-got-it']");

    public By profile_Stepper = By.xpath("//div[@data-testId='progress-step-1']/span[2]");
    public By employeeID = By.xpath("//div[@class='inner_header_section']/span[2]/h5");
}

