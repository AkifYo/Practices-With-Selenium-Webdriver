package Tests.P10_Facebook_FormFilling;

import Utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class A03_AirBnb_ScrenShot extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // navigate to ainbnb.com
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.airbnb.com");
        // locate the search box element end initialize it to a webelement
        WebElement srcBx= driver.findElement(By.xpath("//span[@id='littleSearchLabel']"));
        Thread.sleep(2000);
        //srcBx.click();
        // now activate the search button to enter a place to go
        Actions actions= new Actions(driver);
        WebElement srcBx2= driver.findElement(By.xpath("//input[@id='bigsearch-query-location-input']"));
        Thread.sleep(1000);
        actions.moveToElement(srcBx2).click()
                .perform();
        Thread.sleep(1000);
        srcBx2.sendKeys("Istanbul");
        srcBx2.submit();
        //get the title of the first three places to go
        screenShot(driver);


        Thread.sleep(3000);
        List<WebElement> placesOfCard= driver.findElements(By.xpath("//div[@class='t1jojoys dir dir-ltr']"));
        for (WebElement eachPlace:placesOfCard   ) {
            System.out.println(eachPlace.getText());
        }
        System.out.println(placesOfCard.size());
        Thread.sleep(3000);
        driver.quit();


    }
    public void screenShot(WebDriver driver){
        TakesScreenshot screenshot= (TakesScreenshot) driver;
        LocalDateTime ldt= LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("yyyyMMdd");
        String date= ldt.format(dtf);
        String dosyaYolu="target/Screen/img"+date+".jpeg";
        File scShot= new File("\"target/Screen/img\"+date+\".jpeg\"");
        File tmpFile=screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(tmpFile,scShot);
        } catch (Exception e) {

        }
    }
}
