package Tests.P01_PracticesWithSeleniumWebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase03Lidl {
    @Test
    public void testLidlUI(){
        // first you should do first setup
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // navigate to lidl web site
        driver.get("https://www.lidl.nl/");
        // accept the cookies installingen
        WebElement cookiesBtn= driver.findElement(By.xpath("//button[@class='cookie-alert-extended-button']"));
        cookiesBtn.click();
        // move to inloggen button en click  inloggen button
        WebElement inlogIcon= driver.findElement(By.xpath("//span[@class='m-icon m-icon--user']"));
        Actions actions= new Actions(driver);
        actions.moveToElement(inlogIcon).click().perform();
        WebElement emailBox= driver.findElement(By.xpath("//input[@id='field_EmailOrPhone']"));
        emailBox.sendKeys("akyor06@hotmail.com");
        WebElement submitBtn= driver.findElement(By.xpath("//button[@id='button_btn_submit_email']"));
        submitBtn.click();
        WebElement passwordBtn= driver.findElement(By.xpath("//input[@id='field_Password']"));
        passwordBtn.sendKeys("000000");
        WebElement submit2Btn = driver.findElement(By.xpath("//button[@id='button_submit']"));
        submit2Btn.click();
        WebElement navAssrt= driver.findElement(By.xpath("//a[@href='/c/assortiment/s10008009']"));
        actions.moveToElement(navAssrt).click().perform();

        WebElement scrBox= driver.findElement(By.xpath("//input[@class='s-search-input__field']"));
        scrBox.sendKeys("nutella");
        actions.moveToElement(scrBox).sendKeys(Keys.ENTER).perform();


    }
}
