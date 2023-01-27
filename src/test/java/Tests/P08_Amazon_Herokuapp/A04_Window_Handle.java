package Tests.P08_Amazon_Herokuapp;

import Utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class A04_Window_Handle extends TestBase {
    @Test
    public void test02(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        // we open the example website
        driver.get("https://the-internet.herokuapp.com/windows");
        // we are locating the link element to click
        String firstPageHandleValue=driver.getWindowHandle();//
        driver.findElement(By.linkText("Click Here")).click();
        //now there will be creayted new window that will be opening
        // then we should move on to new website
        // but first we need to save first page handle value

        //later on we are ganna test if second tab has ""
        Set<String> handleValues=driver.getWindowHandles();
        String secondTabHValue="";
        for (String eachWinHandleValu:handleValues) {
            if(!(eachWinHandleValu ==firstPageHandleValue)){
                secondTabHValue=eachWinHandleValu;
            }
        }
        driver.switchTo().window(secondTabHValue);

        String expectedNewPageText="New Window";
        String actualText= driver.findElement(By.tagName("h3")).getText();
        Assert.assertTrue(actualText.contains(expectedNewPageText));

    }
}
