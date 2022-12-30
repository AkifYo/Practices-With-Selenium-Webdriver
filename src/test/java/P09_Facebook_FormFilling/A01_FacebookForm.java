package P09_Facebook_FormFilling;

import Utilities.ReuseableMethod;
import Utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class A01_FacebookForm extends TestBase {
    @Test
    public void test01(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_only_essential_button']")).click();
        // select the registration form
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        ReuseableMethod.wait(2);
        WebElement firstNameTxBox=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions= new Actions(driver);
        actions.sendKeys("Ali")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys("Okuz")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys("04507287875")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys("Ay233134")
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .keyDown(Keys.UP)
                .keyUp(Keys.UP)
                .sendKeys(Keys.ENTER)
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .keyDown(Keys.UP)
                .keyUp(Keys.UP)
                .keyDown(Keys.UP)
                .keyUp(Keys.UP)
                .keyDown(Keys.UP)
                .keyUp(Keys.UP)
                .keyDown(Keys.UP)
                .keyUp(Keys.UP)
                .keyDown(Keys.UP)
                .keyUp(Keys.UP)
                .keyDown(Keys.UP)
                .keyUp(Keys.UP)
                .sendKeys(Keys.ENTER)
                .keyDown(Keys.TAB)
                .keyUp(Keys.TAB)
                .perform();
        ReuseableMethod.wait(2);
        driver.quit();

    }
}
