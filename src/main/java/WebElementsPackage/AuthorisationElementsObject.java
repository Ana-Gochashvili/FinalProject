package WebElementsPackage;
import org.openqa.selenium.By;

public class AuthorisationElementsObject {

    protected By
            profileInfo = By.className("user_profile"),
            emailField = By.name("EmailOrPhone"),
            passwordField = By.name("Password"),
            logInButton = By.id("login-btn");

}
