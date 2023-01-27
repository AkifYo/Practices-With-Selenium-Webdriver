package Tests.P02_Ui_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class A03_MediaMarkt_AanmedlenBtn {
   @Test
    public void aanmeldenBtnTest() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
       driver.get("https://www.mediamarkt.nl/");
       //click the cookies button
       driver.findElement(By.xpath("//button[@id='pwa-consent-layer-accept-all-button']")).click();
       driver.findElement(By.xpath("(//div[@class='Icon-sc-1vrq823-0 iPlLjE'])[2]")).click();
       Thread.sleep(2000);
       driver.findElement(By.xpath("//button[@class='StyledButton-sc-140xkaw-1 kMKmnq']")).click();
    }
}
