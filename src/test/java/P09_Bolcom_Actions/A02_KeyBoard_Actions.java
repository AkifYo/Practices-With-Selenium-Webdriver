package P09_Bolcom_Actions;

import Utilities.ReuseableMethod;
import Utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class A02_KeyBoard_Actions extends TestBase {
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        // go to bol.com
        driver.get("https://www.bol.com/nl/nl/");
        driver.findElement(By.xpath("//button[@id='js-first-screen-accept-all-button']")).click();
        // locate the search bar
        WebElement srcBx= driver.findElement(By.xpath("//input[@name='searchtext']"));
        srcBx.clear();
        // create a actions class
        ReuseableMethod.wait(2);
        Actions actions= new Actions(driver);
        // search  the text Pixel 6A
        actions.click(srcBx)
                .keyDown(Keys.SHIFT)
                .sendKeys("p")
                .keyUp(Keys.SHIFT)
                .sendKeys("ixel 6")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys(Keys.ENTER)
                .perform();
        ReuseableMethod.wait(2);
        //test the resul if it has Pixel 7A
        String actualTx= driver.findElement(By.xpath("//h1[@data-test='page-title']")).getText();
        String expectedTx="Pixel 6A";
        Assert.assertTrue(actualTx.contains(expectedTx));
        ReuseableMethod.wait(2);


    }
}
