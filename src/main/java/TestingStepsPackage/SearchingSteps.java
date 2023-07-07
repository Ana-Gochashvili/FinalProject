package TestingStepsPackage;

import WebElementsPackage.SearchElementsObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SearchingSteps extends SearchElementsObject{
    WebDriver driver;
    public SearchingSteps(WebDriver myDriver){
        driver = myDriver;
    }
    @Step("cookie-ს 'გასაგებია' ღილაკზე დაჭერა")
    public void closeCookie(){
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(cookie));
        driver.findElement(cookie).click();
    }
    @Step("ძებნის ველში მობილურის დასახელების ჩაწერა")
    public void searchPhone(String phone){
        driver.findElement(searchField).sendKeys(phone);
    }
    @Step("'ყველას ნახვა' ღილაკზე დაჭერა")
    public void seeAllResult(){
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(seeAllResultButton));
        driver.findElement(seeAllResultButton).click();
    }


    @Step("'ძებნა' ღილაკზე დაჭერა")
    public void searchButtonClick(){
        driver.findElement(searchButton).click();
    }



    @Step("მობილურის დასახელების ლინკზე დაჭერა და დეტალების ფეიჯის გახსნა")
    public void openPhoneDetails(){
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(phoneDetails));
        driver.findElement(phoneDetails).click();
    }
    @Step("მობილურის დეტალების ფეიჯში 'შედარება' ღილაკზე დაჭერა")
    public void compareButtonClick(){
        driver.findElement(compareButton).click();
    }
    @Step("'შედარების დაწყება' ღილაკზე დაჭერა")
    public void compareProductsStart(){
        WebElement wait = new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(compareStartButton));
        driver.findElement(compareStartButton).click();
    }
    @Step("შედარების ფეიჯზე 'განსხვავებები' ღილაკზე დაჭერა")
    public void showDifference(){ driver.findElement(differenceButton).click(); }












}
