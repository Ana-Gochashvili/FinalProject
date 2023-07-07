package TestingStepsPackage;

import WebElementsPackage.FilterElementsObject;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


public class FilterSteps extends FilterElementsObject {
    WebDriver driver;
    public FilterSteps(WebDriver myDriver){
        driver = myDriver;
    }
    @Step("ძირითადი მენიუს გახსნა და თითოეულ ლინკზე გადასვლა")
    public void launchMainMenu(){

        List<WebElement> filterList = driver.findElements(mainFilter);
        for(WebElement filter : filterList){

          //  for each
            driver.findElements(mainFilter).get(filterList.indexOf(filter)).click();
            driver.findElement(Navigation).click();
        }
    }



    @Step("მენიუში 'მობილურები' ღილაკზე დაჭერა და მობილურების ფეიჯზე გადასვლა")
    public void openMobilePhones(){
        driver.findElement(mobilePhones).click();
    }
    @Step("ფილტრის გახსნა")
    public void openFilter(){
        driver.findElement(filter).click();
    }
    @Step("ფასდაკლების ლინკზე დაჭერა")
    public void filterByDiscount(){
        driver.findElement(discountButton).click();
    }



    @Step("რაოდენობის ფილტრის ღილაკზე დაჭერა")
    public void countButtonClick(){
        driver.findElement(countButton).click();
    }
    @Step("რაოდენობის ფილტრში 20 პროდუქტის ჩვენების ლინკზე დაჭერა")
    public void chooseShow20(){
        driver.findElement(show20).click();
    }
    @Step("რაოდენობის ფილტრში 40 პროდუქტის ჩვენების ლინკზე დაჭერა")
    public void chooseShow40(){
        driver.findElement(show40).click();
    }
    @Step("რაოდენობის ფილტრში 100 პროდუქტის ჩვენების ლინკზე დაჭერა")
    public void chooseShow100(){
        driver.findElement(show100).click();
    }


    @Step("'ტელევიზორები და მონიტორები' ლინკის მოძებნა")
    public WebElement findMonitorsAndTV(){
        return driver.findElement(monitorsAndTV);
    }
    @Step("ბრენდებში LG-ს ლინკის მოძებნა")
    public WebElement findBrandLG(){
        return driver.findElement(brandLG);
    }
    @Step("'ნავიგაცია' მენიუში 'ტელევიზორები და მონიტორები' ლინკის არჩევა,ბრენდებში LG-ს ლინკზე დაჭერა")
    public void filterByLG(){

        //Action class
        Actions actions = new Actions(driver);
        actions.moveToElement(findMonitorsAndTV()).perform();
        actions.moveToElement(findBrandLG()).click().build().perform();
    }
}
