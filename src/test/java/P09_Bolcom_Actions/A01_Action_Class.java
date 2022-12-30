package P09_Bolcom_Actions;

import Utilities.ReuseableMethod;
import Utilities.SetUp;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class A01_Action_Class extends SetUp {
    @Test
    public void test01(){
        // go to bol.com
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.bol.com/nl/nl/");
        // handle the cookies setting with locating the webelement end clicking it
        driver.findElement(By.xpath("//button[@id='js-first-screen-accept-all-button']")).click();
        //move to categories by using actions class
        // we are locating categories web element
        WebElement categoriesEl= driver.findElement(By.xpath("//button[@data-test='category-menu']"));
        // after that moving to this element
        Actions actions= new Actions(driver);
        actions.moveToElement(categoriesEl).perform();
        ReuseableMethod.wait(3);
        //then move to eten en drinken
        // we are locating eten en drinken element
        WebElement etenDrinken=driver.findElement(By.xpath("//li[@data-nav-id='10']"));
        actions.moveToElement(etenDrinken).perform();
        ReuseableMethod.wait(3);
        // later move to koffie en tea
        WebElement koffieTea= driver.findElement(By.xpath("//span[text()='Koffie & Thee']"));

        actions.moveToElement(koffieTea).perform();
        ReuseableMethod.wait(3);

        WebElement whiteTea=driver.findElement(By.xpath("//a[text()='Witte thee']"));
        actions.moveToElement(whiteTea).click().perform();
        ReuseableMethod.wait(3);
        // test the result if it contains 'witte thee'
        String actualText= driver.findElement(By.xpath("//h1[@data-test='page-title']")).getText();
        String expectedText="Witte thee";
        Assert.assertEquals(actualText,expectedText);
        ReuseableMethod.wait(3);

    }
}
