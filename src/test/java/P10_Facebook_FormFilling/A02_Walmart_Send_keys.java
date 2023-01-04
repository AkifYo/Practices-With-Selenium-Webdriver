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
        //e71c9f7cb5f9cbf7ed7c1cb4ad0f78dd9709dff4970633409f78a6a2aef429490c0cc1979719e0dba252899b1f39c0047a9d0f622024424b54aa60586ff0f871
        //fbf8138af6a9ca17ea5e24506a8b9c8d9cd9f9ae0ad310832e874a1896fa8e06963b6b2bca1acf12bd3bf58efad0a8f06adca115eba6caff3202efb4b243f4b5
       // WebElement holdBtn=waitNw.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//p[@id='uNZerhzNfTvnEcx'])[9]")));        //waitNw.withTimeout(Duration.ofSeconds(15)).until(holdBtn,driver)
       //WebElement holdBtn= driver.findElement(By.xpath("//div[@aria-label='Press & Hold']"));

      WebElement ifEl= driver.findElement(By.xpath("//div[@id='px-captcha']"));
      //WebElement holdBtn=driver.switchTo().frame(ifEl).findElement(By.xpath("//div[@aria-label='Press & Hold']"));

        ReuseableMethod.wait(9);
     actoins.clickAndHold(ifEl); //*[@id="px-captcha"]//iframe[6]
        ReuseableMethod.wait(5);
        //This code failed to reach to mainwebpage
        // it is hard to recah shadow element
    }
}
