package P10_Facebook_FormFilling;

import Utilities.ReuseableMethod;
import Utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class A02_Walmart_Send_keys extends TestBase {
    @Test
    public void test01(){
        // navigate to walmart.com
        driver.get("https://walmart.com");
        // locate the search box
        WebElement srcBx= driver.findElement(By.xpath("//input[@placeholder='Search everything at Walmart online and in store']"));
        // send keys to search box by using actions class
        // first create new actions class to reach all methods
        Actions actoins= new Actions(driver);
        actoins.sendKeys(srcBx, "ring of the lords").perform();
        WebDriverWait waitNw= new WebDriverWait(driver, Duration.ofSeconds(15));

       // WebElement holdBtn=waitNw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@id='uNZerhzNfTvnEcx'])[9]")));        //waitNw.withTimeout(Duration.ofSeconds(15)).until(holdBtn,driver)
       //WebElement holdBtn= driver.findElement(By.xpath("//div[@aria-label='Press & Hold']"));
        ReuseableMethod.wait(10);
       //actoins.moveToElement(holdBtn).clickAndHold().perform();
        ReuseableMethod.wait(300);
    }
}
