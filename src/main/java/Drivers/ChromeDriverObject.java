package Drivers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ChromeDriverObject {

    public static WebDriver  driver;
    @BeforeMethod (description = "BeforeMethod ეშვება ყოველი მეთოდის გაშვების წინ და ხსნის Chrome ბრაუზერს")
    public void runTheDriver(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://zoommer.ge/");

    }
    @AfterMethod (description = "AfterMethod ეშვება ყოველი მეთოდის გაშვების შემდეგ და ხურავს Chrome ბრაუზერს")
    public void closeTheDriver(){

        driver.close();

    }
}
