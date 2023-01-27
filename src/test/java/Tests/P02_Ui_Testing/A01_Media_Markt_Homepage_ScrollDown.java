package Tests.P02_Ui_Testing;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class A01_Media_Markt_Homepage_ScrollDown {
   @Test
    public void findHomePageButtons() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       WebDriver driver= new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://www.mediamarkt.nl/");
       driver.findElement(By.xpath("//button[@id='pwa-consent-layer-accept-all-button']")).click();
       Actions actions= new Actions(driver);
//       JavascriptExecutor jse = (JavascriptExecutor)driver;
//       jse.executeScript("window.scrollBy(0,250)");
       WebElement footer= driver.findElement(By.xpath("(//li[@class='StyledLi-sc-25frrw-0 loSpRw'])[9]"));
       actions.scrollToElement(footer).perform();

// drag downwards



       driver.quit();
   }
}
