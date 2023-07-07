package WebElementsPackage;
import org.openqa.selenium.By;


public class RegisterElementsObject {
    protected By
            profileInfo = By.className("welcome-text-desktop"),
            registerLink = By.className("registration_link"),
            emailInput = By.name("Email"),
            passwordInput = By.id("register-password"),
            confirmPasswordInput = By.id("ConfirmPassword"),
            checkBox = By.className("checkmark"),
            registerButton = By.id("register-button");

}
