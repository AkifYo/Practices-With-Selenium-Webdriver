package P04_Media_Markt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Methods_Main {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.mediamarkt.nl/");
        driver.findElement(By.xpath("//button[@id='pwa-consent-layer-accept-all-button']")).click();
        Thread.sleep(3000);
        List<WebElement> navbarBtns = driver.findElements(By.cssSelector("span[class='BaseTypo-sc-1jga2g7-0 izkVco StyledInfoTypo-sc-1jga2g7-1 fMeBkU Text-sc-1drhx1h-4 gruBya']"));

        for (WebElement each : navbarBtns) {
            each.click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);

        }
    }

}
