package P07_Herokuapp_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class A01_Iframe {
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
    public void testIframe() throws InterruptedException {
        // first we are ganna navigate to the website
        driver.get("https://the-internet.herokuapp.com/iframe");
        // later on we are ganna locate the iframe
        driver.switchTo().frame("mce_0_ifr");
        WebElement iframe= driver.findElement(By.xpath("//body[@id='tinymce']"));


        iframe.clear();
        iframe.sendKeys("Akif Yorulmaz");
        Thread.sleep(2000);
        //driver.switchTo().parentFrame();// this goes parent frame
        driver.switchTo().defaultContent();// this goes main html page
        Thread.sleep(2000);
        WebElement textEl= driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(textEl.isDisplayed());
        System.out.println(textEl.getText());

    }


}
