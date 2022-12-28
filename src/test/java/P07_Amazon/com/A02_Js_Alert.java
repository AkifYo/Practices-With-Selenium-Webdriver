package P07_Amazon.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class A02_Js_Alert {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void tearDown () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void testJsAlert() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        // locate the js alert button
        WebElement jsAlertBtn= driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        // we are gonna click the js button to reach alert window
        jsAlertBtn.click();
        // right after we are ganna get the text of alert window
        // to do that we are ganna switc to the alert window
        String expectedText="I am a JS Alert";
       String actualText= driver.switchTo().alert().getText();
       Thread.sleep(2000);
        System.out.println(actualText);
        driver.switchTo().alert().accept();
        // then we are ganna assert the value of the text en we ll se the result
        Assert.assertEquals(actualText,expectedText);
    }
}
