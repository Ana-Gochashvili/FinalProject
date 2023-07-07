package TestingStepsPackage;
import WebElementsPackage.RegisterElementsObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class RegistrationSteps extends RegisterElementsObject {
    WebDriver driver;
    public RegistrationSteps(WebDriver myDriver){
        driver = myDriver;
    }
    @Step("პრიფილ ღილაკზე დაჭერა")
    public void openProfile(){
        driver.findElement(profileInfo).click();
    }
    @Step("რეგისტრაციის ფანჯრის გახსნა")
    public void openRegisterPage(){
        driver.findElement(registerLink).click();
    }
    @Step("მეილის შეყვანა")
    public void setUserEmail(String mail){
        driver.findElement(emailInput).sendKeys(mail);
    }
    @Step("პაროლის შეყვანა შეყვანა")
    public void setUserPassword(String userPassword){
        driver.findElement(passwordInput).sendKeys(userPassword);
    }
    @Step("პაროლის დადასტურება")
    public void confirmUserPassword(String userPassword){
        driver.findElement(confirmPasswordInput).sendKeys(userPassword); }
    @Step("პირობებზე დათანხმების ღილაკის მონიშვნა")
    public void checkBoxOne(){
        driver.findElement(checkBox).click();
    }
    @Step("რეგისტრაციის ღილაკზე დაჭერა")
    public void registerButtonClick(){
        driver.findElement(registerButton).click();
    }

}
