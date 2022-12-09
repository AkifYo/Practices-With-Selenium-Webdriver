package P04_Media_Markt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SendKeys {


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.mediamarkt.nl/");

        Actions action= new Actions(driver);
        driver.findElement(By.xpath("//button[@id='pwa-consent-layer-accept-all-button']")).click();
        Thread.sleep(1000);
        WebElement srcBx= driver.findElement(By.xpath("//input[@class='StyledTextInput-sc-19g71jg-1 drIVXg']"));
        srcBx.clear();
        srcBx.click();
        srcBx.sendKeys("afzuigkap");
        action.sendKeys(srcBx, Keys.ENTER).perform();
        Thread.sleep(2000);
        Price_Method.priceRange("50","500");

    }

}
