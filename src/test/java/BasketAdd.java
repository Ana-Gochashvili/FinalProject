import Drivers.ChromeDriverObject;
import TestingStepsPackage.BasketAddSteps;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BasketAdd extends ChromeDriverObject {
    @Test (testName = "basket testing") // test 7
    @Description("პროდუქტის კალათაში დამატება,კალათაში გადასვლა და გასუფთავება")
    @Severity(SeverityLevel.BLOCKER)
    public void basketAddTesting() throws InterruptedException {

        BasketAddSteps basketAdd = new BasketAddSteps(driver);
        basketAdd.closeCookie();
        basketAdd.chooseMobilePhones();
        basketAdd.basketAdd();
        basketAdd.clickHeaderBasket();
        Thread.sleep(3000);
        basketAdd.openHeaderBasket();


        // assertion
        Assert.assertTrue(driver.getTitle().contains("კალათა"));

        String price = driver.findElement(By.xpath("//*[@id=\"shopping-cart-items\"]/div/div[2]/div[1]/div[2]/div[3]")).getText();
        String sum = driver.findElement(By.xpath("//*[@id=\"shopping-cart-items\"]/div/div[2]/div[1]/div[2]/div[4]")).getText();
        Assert.assertEquals(price,sum);


        basketAdd.clearBasket();


        //assertion
        Assert.assertEquals(driver.findElement(By.className("popup_error_text")).getText(), "ნამდვილად გსურთ კალათის გასუფთავება?");


        basketAdd.clearButtonYes();
        Thread.sleep(5000);


        //assertion

        By emptyBasket = By.className("empty_basket_inside");
        Assert.assertEquals(driver.findElement(emptyBasket).getText(), "თქვენი კალათა ცარიელია\n" +
                "გთხოვთ გადახვიდეთ პროდუქციის გვერდზე და კალათაში დაამატოთ თქვენთვის სასურველი პროდუქტი");


    }
}
