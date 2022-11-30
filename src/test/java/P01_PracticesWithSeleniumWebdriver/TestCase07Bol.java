package P01_PracticesWithSeleniumWebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase07Bol {
    WebDriver driver;
    Actions actions;
    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.get("https://www.bol.com/nl/nl/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofDays(10));
        driver.findElement(By.id("js-first-screen-accept-all-button")).click();
    }
    @AfterTest
    public  void quit(){
        //driver.quit();
    }
    @Test
    public void productList(){
        WebElement srcBx= driver.findElement(By.id("searchfor"));
        actions= new Actions(driver);
        srcBx.sendKeys("koffie");
        srcBx.sendKeys(Keys.ENTER);

    }
}
