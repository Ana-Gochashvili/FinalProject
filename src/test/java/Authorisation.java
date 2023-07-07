import Drivers.ChromeDriverObject;
import TestingStepsPackage.AuthorisationSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static DataPackage.DataObject.*;


public class Authorisation extends ChromeDriverObject{
    @Test(priority = 2)  //   test 2
    @Description("ავტორიზაცია სწორი მეილითა და პაროლით")
    @Severity(SeverityLevel.BLOCKER)
    public void authorisationTesting() throws InterruptedException {

        AuthorisationSteps SignIn = new AuthorisationSteps(driver);
        SignIn.openProfile();
        SignIn.enterYourEmail(email);
        SignIn.enterYourPassword(password);
        SignIn.logInButtonClick();
        Thread.sleep(5000);

    // assertions

        WebElement welcomeBtn = driver.findElement(By.className("logged_in_user_profile"));
        welcomeBtn.click();
        Assert.assertEquals(welcomeBtn.getText(), "გამარჯობა");

    }


    @Test (priority = 1)  //   test 3
    @Description("ავტორიზაცია არასწორი მეილით")
    @Severity(SeverityLevel.BLOCKER)
    public void authorisationWithWrongEmail() throws InterruptedException {

        AuthorisationSteps SignIn = new AuthorisationSteps(driver);
        SignIn.openProfile();
        SignIn.enterYourEmail(wrongEmail);
        SignIn.enterYourPassword(password);
        SignIn.logInButtonClick();
        Thread.sleep(5000);


        // assertions

        By loginValidationInput = By.name("EmailOrPhone");

        Assert.assertEquals(driver.findElement(loginValidationInput).getCssValue("border-color"), "rgb(255, 0, 0)");
        Assert.assertEquals(driver.findElement(By.name("Password")).getCssValue("border-color"), "rgb(255, 0, 0)");
        Assert.assertEquals(driver.findElement(By.name("Password")).getText(), "");

        boolean passwordStatus = driver.findElement(By.id("Password")).isEnabled();
        Assert.assertTrue(passwordStatus);

    }
}
