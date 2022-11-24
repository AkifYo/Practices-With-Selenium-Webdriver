package P01_PracticesWithSeleniumWebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TesteCase05MediaMarkt {
    @Test
    public void testMediMarkt (){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.mediamarkt.nl/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[@id='pwa-consent-layer-accept-all-button']")).click();

        WebElement srcBx= driver.findElement(By.xpath("//input[@aria-label='Wat zoek je?']"));
        srcBx.sendKeys("GoPro");
        srcBx.sendKeys(Keys.ENTER);
        WebElement sdBr= driver.findElement(By.xpath("//div[@class='AccordionWrapper-sc-1k8e15j-1 dWXWIp']"));
        sdBr.click();
        List<WebElement> proListUp= driver.findElements(By.xpath("//div[@data-test='mms-search-srp-productlist-item']"));
        proListUp.get(11).click();
        //driver.navigate().back();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));






        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       // driver.quit();
    }
}
