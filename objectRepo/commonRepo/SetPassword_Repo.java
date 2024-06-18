package objectRepo.commonRepo;

import org.openqa.selenium.By;

public class SetPassword_Repo {

    public By password_input = By.xpath("//input[@name='password']");
    public By confirmPassword_input = By.xpath("//input[@name='confirmPassword']");
    public By setPassword_btn = By.xpath("//button[@data-testId='submit-button']");

    public By message_snackBar = By.xpath("//div[@class='Toastify__toast-body']/div");
}
