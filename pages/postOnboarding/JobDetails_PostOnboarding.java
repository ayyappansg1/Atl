package pages.postOnboarding;

import helper.LocalHelper;
import objectRepo.postOnboardingRepo.JobDetailsPage_Repo;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class JobDetails_PostOnboarding extends JobDetailsPage_Repo {
    protected static final Logger logger = LoggerFactory.getLogger(Profile_PostOnboarding.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;

    public JobDetails_PostOnboarding(WebDriver driver) {
        this.driver = driver;
    }

    public String dateTimeFormatter(String dateTime){
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(dateTime, inputFormatter);
        return outputFormatter.format(date);
    }

    public String getSeniorityDate(){ if(localHelper.getAttributeValue(seniorityDate,driver).isEmpty()) return null;
        else return localHelper.getAttributeValue(seniorityDate,driver);}
    public int getEmploymentTypeField()  {
        localHelper.scrollIntoView(employmentTermField,driver);
        if(localHelper.getAttributeValue(employmentTypeField,driver).equalsIgnoreCase("Full Time")) return 1;
        else if(localHelper.getAttributeValue(employmentTypeField,driver).equalsIgnoreCase("Part Time")) return 2;
        return 0;
    }
    public int getEmploymentTermField(){
        if(localHelper.getAttributeValue(employmentTermField,driver).equals("Fixed")) return 1;
        else if(localHelper.getAttributeValue(employmentTermField,driver).equals("Indefinite")) return 2;
        return 0;
    }
    public String getTermEndDate(){ if(localHelper.getAttributeValue(termEndDate,driver).isEmpty()) return null; else return localHelper.getAttributeValue(termEndDate,driver);}

    public int getProbationPeriodType(){
        if(localHelper.getAttributeValue(probationPeriodUnit,driver).isEmpty()) {
            return 0;
        }

         else{

            switch (localHelper.getAttributeValue(probationPeriodUnit, driver).replaceAll("[0-9\\s]", "")) {
                case "BusinessDays":
                    return 1;
                case "Weeks":
                    return 2;
                case "Months":
                    return 3;
            }
        }
        return 0;
        }

    public int getProbationPeriod(){ if(localHelper.getAttributeValue(number,driver).isEmpty()) return 0;
        else return Integer.parseInt(localHelper.getAttributeValue(number,driver)); }

    public String getProbationEndDate(){ if(localHelper.getAttributeValue(probationEndDate,driver).isEmpty()) return null; else return localHelper.getAttributeValue(probationEndDate,driver);}

    public int getEmployerNoticePeriod(){
        if(localHelper.getAttributeValue(employerNoticePeriod,driver).isEmpty()) return 0;
        else return Integer.parseInt(localHelper.getAttributeValue(employerNoticePeriod,driver));
    }
    public int getEmployeeNoticePeriod(){
        if(localHelper.getAttributeValue(employeeNoticePeriod,driver).isEmpty()) return 0;
        else return Integer.parseInt(localHelper.getAttributeValue(employeeNoticePeriod,driver));
    }
    public int getRetirementAge(){
        if(localHelper.getAttributeValue(retirementAge,driver).isEmpty()) return 0;
        else return Integer.parseInt(localHelper.getAttributeValue(retirementAge,driver));
    }

}
