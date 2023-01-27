package Tests.P03_Ui_UseMethods;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class B_FirstMethods {
    static WebDriver driver;

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bol.com/nl/nl/");
    }
    public static void cookiesHandle(){
         driver.findElement(By.id("js-first-screen-accept-all-button")).click();
    }

    public static void finishTest() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
    }
}
