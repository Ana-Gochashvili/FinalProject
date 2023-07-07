package TestingStepsPackage;
import WebElementsPackage.AuthorisationElementsObject;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;



public class AuthorisationSteps extends AuthorisationElementsObject {
    WebDriver driver;
    public AuthorisationSteps(WebDriver myDriver){
        driver = myDriver;
    }
    @Step("პრიფილ ღილაკზე დაჭერა")
    public void openProfile(){
        driver.findElement(profileInfo).click();
    }
    @Step("ფეიკ მეილის შეყვანა")
    public void enterYourEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    @Step("პაროლის შეყვანა")
    public void enterYourPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }
    @Step("შესვლა ღილაკზე დაჭერა")
    public void logInButtonClick(){
        driver.findElement(logInButton).click();
    }

}
