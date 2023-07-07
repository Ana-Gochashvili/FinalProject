package WebElementsPackage;
import org.openqa.selenium.By;

public class SearchElementsObject {
    protected By
            searchField = By.id("small-searchterms"),
            seeAllResultButton = By.xpath("//*[@id=\"small-search-box-form\"]/div[1]/div[3]/a");


    protected By
            searchButton = By.className("h_search_btn");



    protected By
            cookie = By.id("eu-cookie-ok"),
            phoneDetails = By.className("result_product_block"),
            compareStartButton = By.className("comp-product-start"),
            compareButton = By.className("btn"),
            differenceButton = By.id("diffbtn");
}
