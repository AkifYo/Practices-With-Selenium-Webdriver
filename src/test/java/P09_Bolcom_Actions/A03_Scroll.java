package P09_Bolcom_Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class A03_Scroll {
    @Test
    public void test01() throws InterruptedException {
        // go to bol.com
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.bol.com/nl/nl/");
        // handle the cookies setting with locating the webelement end clicking it
        driver.findElement(By.xpath("//button[@id='js-first-screen-accept-all-button']")).click();
        Actions actions= new Actions(driver);
        Thread.sleep(3000);
        WebElement footer= driver.findElement(By.xpath("//a[contains(text(),'Huishouden')]"));

        actions.scrollToElement(footer).perform();
        Thread.sleep(5000);
        List<WebElement> footerEleList= driver.findElements(By.xpath("//div[@class='navigation-block__column__category  navigation-block__group  accordion__item js_toggle_group']"));
        for (WebElement eachOf:footerEleList
             ) {
            System.out.println(eachOf.getText());
        }

        driver.manage().window().getSize();
        driver.quit();
    }
}
