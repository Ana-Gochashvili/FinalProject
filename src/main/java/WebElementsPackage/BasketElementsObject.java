package WebElementsPackage;
import org.openqa.selenium.By;

public class BasketElementsObject {
    protected By
            mobilePhones = By.xpath("/html/body/div[7]/section/div[2]/div[1]/div[1]/div[2]/ul/li[1]"),
            basket = By.cssSelector("div.basket_white"),
            cookie = By.id("eu-cookie-ok"),
            headerBasket = By.className("h_basket_icon"),
            openHeaderBasket =By.xpath("/html/body/div[7]/header/div[4]/div[2]/div[3]/div[1]/div[2]/div/button"),
            clearButton = By.id("clear-basket-button"),
            clearButtonYes = By.xpath("/html/body/div[11]/div[2]/div[3]/button[1]");
}
