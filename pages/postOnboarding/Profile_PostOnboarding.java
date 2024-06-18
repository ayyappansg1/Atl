package pages.postOnboarding;

import common.RestClient;
import common.TestUtil;
import helper.LocalHelper;
import io.restassured.response.Response;
import objectRepo.postOnboardingRepo.ProfilePage_Repo;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;


public class Profile_PostOnboarding extends ProfilePage_Repo {
    protected static final Logger logger = LoggerFactory.getLogger(Profile_PostOnboarding.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;

    public Profile_PostOnboarding(WebDriver driver) {
        this.driver = driver;
    }
    public String dateTimeFormatter(String dateTime){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateTime, inputFormatter);
        return outputFormatter.format(date);
    }

    public String getEmployeeId(){ return localHelper.getText(employeeId,driver);}
    public String getJobTitle(){ if(localHelper.getText(jobTitle,driver).isEmpty()) return null; else return localHelper.getText(jobTitle,driver);}
    public String getFullName(){ if(localHelper.getText(fullName,driver).isEmpty()) return null; else return localHelper.getText(fullName,driver);}
    public String getEmail(){ if(localHelper.getText(contactEmail,driver).isEmpty()) return null; else if(localHelper.getText(contactEmail,driver).equals("+")) return "+null";
    else return localHelper.getText(contactEmail,driver); }

    public String getFirstName(){ return localHelper.getAttributeValue(firstName,driver);}
    public String getAdditionalGivenName(){
        if(localHelper.getAttributeValue(additionalGivenName, driver).isEmpty()) return null;
        return localHelper.getAttributeValue(additionalGivenName,driver);
    }
    public String getLastName(){ if(localHelper.getAttributeValue(lastName,driver).isEmpty()) return null; else return localHelper.getAttributeValue(lastName,driver);}
    public String getPreferredName(){ if(localHelper.getAttributeValue(preferredName,driver).isEmpty()) return null; else return localHelper.getAttributeValue(preferredName,driver);}
    public String getBirthday(){ if(localHelper.getAttributeValue(birthday,driver).isEmpty()) return ""; else return localHelper.getAttributeValue(birthday,driver);}
    public int getMaritalStatus(){
        if(localHelper.getText(maritalStatus,driver).equals("Married")) return 1;
        else if(localHelper.getText(maritalStatus,driver).equals("Single")) return 2;
        else if(localHelper.getText(maritalStatus,driver).equals("Common Law")) return 3;
        else if(localHelper.getText(maritalStatus,driver).equals("Domestic Partnership")) return 3;
        return 0;
    }
    public int getGender(){
        if(localHelper.getText(gender,driver).equals("Male")) return 1;
        else if(localHelper.getText(gender,driver).equals("Female")) return 2;
        else if(localHelper.getText(gender,driver).equals("Non-Binary")) return 3;
        return 0;
    }
    public String getCountryOfResidence(){ if(localHelper.getText(countryOfCitizenship,driver).isEmpty()) return ""; return localHelper.getText(countryOfCitizenship,driver); }
    public String getNationalId(){ if(localHelper.getAttributeValue(nationalId,driver).isEmpty()) return ""; return localHelper.getAttributeValue(nationalId,driver); }


    public String getCountry(){ if(localHelper.getText(country,driver).equals("null")) return ""; else return localHelper.getText(country,driver);}
    public String getStreet1(){ if(localHelper.getAttributeValue(street1,driver).isEmpty()) return null; else return localHelper.getAttributeValue(street1,driver);}
    public String getStreet2(){ if(localHelper.getAttributeValue(street2,driver).isEmpty()) return null; else return localHelper.getAttributeValue(street2,driver);}
    public String getCity(){ if(localHelper.getAttributeValue(city,driver).isEmpty()) return null; else return localHelper.getAttributeValue(city,driver);}
    public String getPostalCode(){ if(localHelper.getAttributeValue(postalCode,driver).isEmpty()) return null; else return localHelper.getAttributeValue(postalCode,driver);}
    public String getState(){ if(localHelper.getAttributeValue(state,driver).isEmpty()) return null; else return localHelper.getAttributeValue(state,driver);}

    public String getWorkPhone(){ if(localHelper.getAttributeValue(workPhone,driver).isEmpty()) return ""; else return localHelper.getAttributeValue(workPhone,driver);}
    public String getMobile(){ if(localHelper.getAttributeValue(mobile,driver).isEmpty()) return ""; else return localHelper.getAttributeValue(mobile,driver);}
    public String getHomePhone(){ if(localHelper.getAttributeValue(homePhone,driver).isEmpty()) return ""; else return localHelper.getAttributeValue(homePhone,driver);}
    public String getOfficeEmail(){ if(localHelper.getAttributeValue(officeEmail,driver).isEmpty()) return ""; else return localHelper.getAttributeValue(officeEmail,driver);}
    public String getHomeEmail(){ if(localHelper.getAttributeValue(homeEmail,driver).isEmpty()) return ""; else return localHelper.getAttributeValue(homeEmail,driver);}

    public String getLinkedinUrl(){ if(localHelper.getAttributeValue(linkedinUrl,driver).isEmpty()) return null; else return localHelper.getAttributeValue(linkedinUrl,driver);}
    public String getWebsite(){ if(localHelper.getAttributeValue(website,driver).isEmpty()) return null; else return localHelper.getAttributeValue(website,driver);}

    public void clickJobDetailsStepper(){
        localHelper.clickElement(jobDetailsStepper,driver);
    }

    public Response getResponse(String base,String employeeId) throws IOException {
        TestUtil testUtil = new TestUtil();
        Properties prop = testUtil.init_Properties("restAssured/Base");

        String basePathPostOnBoardingInternal = prop.getProperty("BASE-PATH_POST_ON-BOARDING_INTERNAL");

        // Get the employee ID
        Map<String, String> paramMapsEmpId = new HashMap<>();
        paramMapsEmpId.put("employeeId", employeeId);

        // authorization Token
        Map<String, String> authToken = new HashMap<>();
        authToken.put("Authorization", RestClient.getAccessToken(base,"EMPLOYEE"));
        authToken.put("customerId", prop.getProperty("CUSTOMER_ID"));

        return RestClient.doGet(base, "JSON", authToken, paramMapsEmpId, basePathPostOnBoardingInternal, true);
    }

}
