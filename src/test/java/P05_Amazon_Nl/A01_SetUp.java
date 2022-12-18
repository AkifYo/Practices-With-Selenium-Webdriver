package P05_Amazon_Nl;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A01_SetUp {
    static WebDriver driver;

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.nl/");
        driver.manage().window().maximize();
    }
    public static void cookiesHandle(){
        driver.findElement(By.id("sp-cc-accept")).click();
    }

    public static void finishTest() throws InterruptedException {
        Thread.sleep(8000);
        driver.quit();
    }
}
