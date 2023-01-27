package Tests.P02_Ui_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class A02_MediaMarkt_HomePage_Buttons {
    @Test
    public void findBtns() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.mediamarkt.nl/");
        //click the cookies button
        driver.findElement(By.xpath("//button[@id='pwa-consent-layer-accept-all-button']")).click();
        WebElement firstBtn= driver.findElement(By.xpath("//button[@class='StyledButton-sc-3ahq4x-1 eEuWNB categories-button']"));

        //actions.moveToElement(firstBtn);
        firstBtn.click();
        Thread.sleep(3000);
        WebElement closeBtn= driver.findElement(By.id("app-header-categorymenu-close-button"));
        closeBtn.click();
        //login button

        WebElement klantIcon= driver.findElement(By.xpath("(//div[@class='Icon-sc-1vrq823-0 iPlLjE'])[2]"));
        klantIcon.click();
        WebElement lgnBtn= driver.findElement(By.xpath("//button[@class='StyledButton-sc-140xkaw-1 kMKmnq']"));
        //lgnBtn.click();
        driver.findElement(By.xpath("(//button[@class='StyledButton-sc-140xkaw-1 bnYMIj'])[1]")).click();



    }
}
