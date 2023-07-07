import Drivers.ChromeDriverObject;
import TestingStepsPackage.FilterSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class FilterT extends ChromeDriverObject {
    @Test (priority = 1) // test 8
    @Description("ძირითადი მენიუს გატესტვა 'ნავიგაცია' ღილაკიდან")
    @Severity(SeverityLevel.CRITICAL)
    public void navigationBody(){

        FilterSteps MainMenu = new FilterSteps(driver);
        MainMenu.launchMainMenu();


        // assertions

        List<WebElement> filterList = driver.findElements(By.cssSelector("[data-show-id]"));
        Assert.assertEquals(filterList.size(), 8);
        Assert.assertEquals(filterList.get(0).getText(), "მობილურები");
        Assert.assertEquals(filterList.get(1).getText(), "ტაბები | აქსესუარები");
        Assert.assertEquals(filterList.get(2).getText(), "ლეპტოპები | IT");
        Assert.assertEquals(filterList.get(3).getText(), "აუდიო სისტემა");
        Assert.assertEquals(filterList.get(4).getText(), "Gaming");
        Assert.assertEquals(filterList.get(5).getText(), "ტელევიზორი | მონიტორი");
        Assert.assertEquals(filterList.get(6).getText(), "ფოტო | ვიდეო | ოპტიკა");
        Assert.assertEquals(filterList.get(7).getText(), "ჭკვიანი სახლი");

    }



    @Test (groups = "filters", priority = 3) //  test 9
    @Description("პროდუქტების გაფილტვრა გამოცხადებული ფასდაკლებების მიხედვით")
    @Severity(SeverityLevel.CRITICAL)
    public void filterByDiscount() throws InterruptedException {

        FilterSteps Filter = new FilterSteps(driver);
        Filter.openMobilePhones();
        Filter.openFilter();
        Filter.filterByDiscount();

        Thread.sleep(3000);


        // assertions

        List<WebElement> filteredProductList = driver.findElements(By.className("product_blocks"));
        Assert.assertEquals(filteredProductList.size(), 40);

        List<WebElement> sale = driver.findElements(By.className("sale_label"));
  //    Assert.assertEquals(sale.size(), 27);   // ციფრები იცვლება დღის განმავლობაში

        // while loop

        int i = 0;
        while ( i < sale.size()) {

            Assert.assertEquals(sale.get(i).getText(), "SALE");
            Assert.assertEquals(sale.get(i).getCssValue("color"), "rgba(255, 255, 255, 1)");
            Assert.assertEquals(sale.get(i).getCssValue("background-color"), "rgba(144, 174, 255, 1)");
            i++;

        }

        List<WebElement> zoommerPrice = driver.findElements(By.cssSelector("[style~=\"background-color:#fb7613\"]"));
//      Assert.assertEquals(zoommerPrice.size(), 13);    // ციფრები იცვლება დღის განმავლობაში


            // for loop

        for (int j = 0; j < zoommerPrice.size(); j++) {

            Assert.assertEquals(zoommerPrice.get(j).getText(), "ზუმერული ფასი");
            Assert.assertEquals(zoommerPrice.get(j).getCssValue("color"), "rgba(255, 255, 255, 1)");
            Assert.assertEquals(zoommerPrice.get(j).getCssValue("background-color"), "rgba(251, 118, 19, 1)");

        }

    }


    @Test (groups = "filters", priority = 2)   //  test 10
    @Description("რაოდენობების ფილტრის გატესტვა ეკრანზე გამოტანილი პროდუქტების რაოდენობის მიხედვით")
    @Severity(SeverityLevel.NORMAL)
    public void filterByCount() {

        FilterSteps FilterByCount = new FilterSteps(driver);
        FilterByCount.openMobilePhones();
        FilterByCount.countButtonClick();
        FilterByCount.chooseShow20();

        // assertions

        List<WebElement> filteredProductList20 = driver.findElements(By.className("product_blocks"));
        Assert.assertEquals(filteredProductList20.size(), 20);

        FilterByCount.countButtonClick();
        FilterByCount.chooseShow40();

        List<WebElement> filteredProductList40 = driver.findElements(By.className("product_blocks"));
        Assert.assertEquals(filteredProductList40.size(), 40);

        FilterByCount.countButtonClick();
        FilterByCount.chooseShow100();

        List<WebElement> filteredProductList100 = driver.findElements(By.className("product_blocks"));
        Assert.assertEquals(filteredProductList100.size(), 100);

    }



    @Test (groups = "filters", priority = 1) // hover test  11
    @Description("პროდუქტის გაფილტვრა ბრენდის მიხედვით დაფარული მენიუდან")
    @Severity(SeverityLevel.NORMAL)
    public void FilterTVByBrands() throws InterruptedException {

        FilterSteps TVMenu = new FilterSteps(driver);
        TVMenu.findBrandLG();
        TVMenu.findBrandLG();
        TVMenu.filterByLG();
        Thread.sleep(3000);


        // assertions

        Assert.assertEquals(driver.getTitle(), "LG|Zoommer.ge");

        List<WebElement> filteredProductsLG = driver.findElements(By.className("product_blocks"));

//        Assert.assertEquals(filteredProductsLG.size(), 7);   // ციფრები შეიძლება შეიცვალოს დღის განმავლობაში

        // for loop

        for(int i = 0; i < filteredProductsLG.size(); i++){

            Assert.assertTrue(driver.findElements(By.className("product_blocks")).get(i).getText().contains("LG"));

        }


    }
}


