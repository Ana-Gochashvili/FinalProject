import Drivers.ChromeDriverObject;
import TestingStepsPackage.RegistrationSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import static DataPackage.DataObject.*;


public class Registration extends ChromeDriverObject{
    @Test (testName = "რეგისტრაცია") //   test 1
    @Description("რეგისტრაციის მცდელობა მეილით,რომელზეც უკვე არსებობს აქტიური იუზერი")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://zoommer.ge/tsesebi-da-pirobebi")

    public void signUpWithWrongEmail() throws InterruptedException {

        RegistrationSteps SignUp = new RegistrationSteps(driver);
        SignUp.openProfile();
        SignUp.openRegisterPage();
        SignUp.setUserEmail(email);
        SignUp.setUserPassword(password);
        SignUp.confirmUserPassword(password);
        SignUp.checkBoxOne();
        SignUp.registerButtonClick();



        // assertions

        By popUpTiTle = By.className("error_title");
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(popUpTiTle));


        Assert.assertEquals(driver.findElement(popUpTiTle).getText(), "შეცდომა");
        Assert.assertEquals(driver.findElement(popUpTiTle).getCssValue("color"), "rgba(254, 95, 85, 1)");


        By popUpText = By.className("popup_text");
        Assert.assertEquals(driver.findElement(popUpText).getText(), "აღნიშნული ელ. ფოსტით მომხმარებელი უკვე დარეგისტრირებულია");
        Thread.sleep(3000);


        By popUpClose = By.className("error_btn");
        Assert.assertEquals(driver.findElement(popUpClose).getCssValue("background-color"), "rgba(10, 50, 81, 1)");
        driver.findElement(popUpClose).click();

    }

}
