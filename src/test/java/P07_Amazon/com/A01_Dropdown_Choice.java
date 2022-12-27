package P07_Amazon.com;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class A01_Dropdown_Choice {
    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        driver.close();
    }
    @Test
    public void dropdown() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement drpBx=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select= new Select(drpBx);

        //select.selectByValue("search-alias=beauty-intl-ship");
        //select.selectByVisibleText("Beauty & Personal Care");
        select.selectByIndex(4);
        Thread.sleep(3000);
    }
}
