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
        WebElement minPrice= driver.findElement(By.cssSelector("input[name='min']"));
        String str= minPrice.getAttribute("value");
        System.out.println(str);
        //System.out.println(minPrice.getAttribute("value"));
        minPrice.click();
        for (int i = 0; i < 3; i++) {
            minPrice.sendKeys(Keys.BACK_SPACE);
        }

        minPrice.sendKeys("150");

        WebElement maxPrice= driver.findElement(By.xpath("(//input[@class='StyledInputMask-sc-6brnnh-3 eQMVTh'])[2]"));
        //System.out.println(maxPrice.getAttribute("value"));
        Thread.sleep(1000);
        maxPrice.click();

        Thread.sleep(1000);
        for (int i = 0; i < 5; i++) {
            maxPrice.sendKeys(Keys.BACK_SPACE);
        }
        maxPrice.sendKeys("250");
        maxPrice.sendKeys(Keys.ENTER);
        //driver.quit();

    }

}
