package TestingStepsPackage;

import WebElementsPackage.BasketElementsObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasketAddSteps extends BasketElementsObject {
    WebDriver driver;
    public BasketAddSteps(WebDriver myDriver){driver = myDriver; }
    @Step("cookie-ს შეტყობინების 'გასაგებია' ღილაკზე დაჭერა")
    public void closeCookie(){
        driver.findElement(cookie).click();
    }
    @Step("მენიუში 'მობილურები' ღილაკზე დაჭერა")
    public void chooseMobilePhones(){
        driver.findElement(mobilePhones).click();
    }
    @Step("მობილურის 'კალათა' ღილაკზე დაჭერა და პროდუქტის კალათაში დამატება")
    public void basketAdd(){
         driver.findElement(basket).click();
    }
    @Step("კალათის ფანჯრის გამოძახება")
    public void clickHeaderBasket(){
        driver.findElement(headerBasket).click();
    }
    @Step("კალათაში გადასვლა")
    public void openHeaderBasket(){
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(openHeaderBasket));
        driver.findElement(openHeaderBasket).click();
    }
    @Step("'კალათის გასუფთავება' ღილაკზე დაჭერა და კალათის გასუფთავება")
    public void clearBasket(){
        driver.findElement(clearButton).click();
    }
    @Step("კალათაში გასუფთავებაზე დათანხმება და დიახ ღილაკზე დაჭერა")
    public void clearButtonYes(){
        driver.findElement(clearButtonYes).click();
    }

}
