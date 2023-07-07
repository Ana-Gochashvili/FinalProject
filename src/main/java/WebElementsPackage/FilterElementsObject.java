package WebElementsPackage;
import org.openqa.selenium.By;

public class FilterElementsObject {

    protected By
            mainFilter = By.cssSelector("[data-show-id]"),
            Navigation = By.className("navigation-header");




    protected By
            mobilePhones = By.xpath("/html/body/div[7]/section/div[2]/div[1]/div[1]/div[2]/ul/li[1]/a/span"),
            filter = By.className("sorter_div"),
            discountButton = By.xpath("//*[@id=\"js-filter-cont\"]/div[4]/div[1]/div[1]/div[2]/div[2]/ul/li[7]/a");




    protected By
            countButton = By.className("count_on_page_dp"),
            show20 = By.xpath("//*[@id=\"js-filter-cont\"]/div[4]/div[1]/div[1]/div[1]/ul/li[1]/a"),
            show40 = By.xpath("//*[@id=\"js-filter-cont\"]/div[4]/div[1]/div[1]/div[1]/ul/li[2]/a"),
            show100 = By.xpath("//*[@id=\"js-filter-cont\"]/div[4]/div[1]/div[1]/div[1]/ul/li[3]/a");




    protected By
            monitorsAndTV = By.xpath("/html/body/div[7]/section/div[2]/div[1]/div[1]/div[2]/ul/li[6]/a/span"),
            brandLG = By.xpath("/html/body/div[7]/section/div[2]/div[1]/div[7]/div/ul[1]/div[1]/li[2]/a");

}