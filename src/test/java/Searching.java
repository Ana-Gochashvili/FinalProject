import Drivers.ChromeDriverObject;
import TestingStepsPackage.SearchingSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static DataPackage.SearchDataObject.*;


public class Searching extends ChromeDriverObject {
    @Test (groups = "search", priority = 2)    //   test 4
    @Description("ძებნის შედეგების ნახვა 'ყველას ნახვა' ღილაკიდან")
    @Severity(SeverityLevel.CRITICAL)
    public void searchFromSeeAllResult() throws InterruptedException {

        SearchingSteps search = new SearchingSteps(driver);
        search.searchPhone(iPhone);
        search.closeCookie();
        search.seeAllResult();
        Thread.sleep(5000);


      //  assertions

        List<WebElement> resultList=driver.findElements(By.className("product_blocks"));

        Assert.assertEquals(resultList.size(), 9 ); // ციფრები შეიძლება შეიცვალოს
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"js-filter-cont\"]/div[3]/div[1]/div[2]")).getText(), "მოიძებნა9 პროდუქტიApple iPhone 14 Pro | Gold");  // ციფრები შეიძლება შეიცვალოს
        Assert.assertEquals(driver.findElement(By.tagName("strong")).getCssValue("color"), "rgba(10, 50, 81, 1)");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"js-filter-cont\"]/div[3]/div[1]/div[2]/span")).getCssValue("color"), "rgba(254, 95, 85, 1)");

    }

    @Test (groups = "search", priority = 1) // test 5
    @Description("ძებნის შედეგების ნახვა 'ძებნა' ღილაკიდან")
    @Severity(SeverityLevel.CRITICAL)
    public void searchFromSearchButton() throws InterruptedException{

        SearchingSteps searchBTN = new SearchingSteps(driver);
        searchBTN.searchPhone(samsung);
        searchBTN.searchButtonClick();
        Thread.sleep(5000);

        // assertions

        List<WebElement> resultList=driver.findElements(By.className("col_5"));
        Assert.assertEquals(resultList.size(), 8 );
        Assert.assertEquals(driver.findElement(By.className("search_result_text")).getText(), "ძიების შედეგები\n" +
                "მოიძებნა8 პროდუქტიSamsung Galaxy S22 Purple");

        // for each, if,

        int count = 0;
        int x =0;
        for(WebElement result : resultList){
            if(result.getText().contains("Coverage")){
                count++;
            }
            x = count;
        }
        Assert.assertEquals(x, 6);  // searched 8 product, from this six are Coverage Silicon Case

    }


    @Test (groups = "compare") // test 6
    @Description("კონკრეტული პროდუქტების მოძებნა და ერთმანეთთან შედარება")
    @Severity(SeverityLevel.NORMAL)
    public void compareProductsTesting() throws InterruptedException {

        SearchingSteps compare = new SearchingSteps(driver);
        compare.closeCookie();
        compare.searchPhone(iPhone14Pro);
        compare.openPhoneDetails();
        compare.compareButtonClick();
        compare.searchPhone(iPhone14ProMax);
        compare.openPhoneDetails();
        compare.compareButtonClick();
        compare.compareProductsStart();
        compare.showDifference();
        Thread.sleep(5000);


        //assertions

        WebElement shareButton = driver.findElement(By.xpath("/html/body/div[7]/section/div[5]/div[2]/button"));
        Assert.assertEquals(shareButton.getText(), "გაზიარება");

        boolean shareButtonIsEnabled = driver.findElement(By.xpath("/html/body/div[7]/section/div[5]/div[2]/button")).isEnabled();
        Assert.assertTrue(shareButtonIsEnabled);

        boolean printButtonIsDisplayed = driver.findElement(By.className("fa")).isDisplayed();
        Assert.assertTrue(printButtonIsDisplayed);

        boolean printButtonIsEnabled = driver.findElement(By.className("fa")).isEnabled();
        Assert.assertTrue(printButtonIsEnabled);

    }


}
