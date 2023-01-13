package P01_PracticesWithSeleniumWebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase01AlberHijn {


    @Test
    public void test01() {
//        1. Launch browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //        2. Navigate to url 'https://www.ah.nl'
        driver.get("https://www.ah.nl");
        //        3. Maximize the window
        driver.manage().window().maximize();
//        4. Click on 'Accepteer' button in the cookies window
        WebElement cookiesBtn = driver.findElement(By.id("accept-cookies"));
        cookiesBtn.click();

//        5. Verify 'Maak nu een profiel aan' is visible
        Actions action = new Actions(driver);
        //WebElement inlogBtn = driver.findElement(By.xpath("//a[@href='/mijn/inloggen']"));
        //action.moveToElement(inlogBtn).perform();
        //inlogBtn.getText();
        //System.out.println(inlogBtn.getText());
        WebElement inlog = driver.findElement(By.xpath("//a[@data-testhook='navigation-login']"));
        inlog.click();
        //6. click to maak een account aan
        WebElement singUpbtn = driver.findElement(By.xpath("//a[@data-testhook='signup-customer']"));
        singUpbtn.click();
        driver.navigate().back();
        //        7. Enter name and email address
        WebElement userNameTextBox = driver.findElement(By.id("username"));
        userNameTextBox.sendKeys("akyor06@hotmail.com");
        userNameTextBox.sendKeys(Keys.TAB);
        WebElement passwordTextBox = driver.findElement(By.id("password"));
        passwordTextBox.sendKeys("00000");
        passwordTextBox.sendKeys(Keys.TAB);
        action.sendKeys(Keys.TAB);
        WebElement logBtn = driver.findElement(By.xpath("//button[@data-testhook='login-form-submit']"));
        action.moveToElement(logBtn).click().perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.quit();

    }


}
