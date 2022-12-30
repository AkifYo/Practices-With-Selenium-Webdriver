package P08_Amazon_Herokuapp;

import Utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class A03_Window_Handle extends TestBase {
    @Test
    public void test01(){

        //firs we are going to amazon.com
        driver.get("https://amazon.com");
        // then we are going to bbc.com
        // we are saving windows handle value to do turn bacto amazon side
        String amzWHV=driver.getWindowHandle();
        //driver.get("https://bbc.com");
        // then window quit the driver
        String amzPagetxt= driver.getTitle();
        String expectedText="Amazon";
        Assert.assertTrue(amzPagetxt.contains(expectedText));
        // now we ll open a new tab to open a new web site
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://bbc.com");
        // to turn bac to amazon website we should use windowshandle value
        // we are ganna test if we reach to bbc website
        String bbcPageTxt= driver.getTitle();
        String expectedTextBbc="Homepage";
        Assert.assertTrue(bbcPageTxt.contains(expectedTextBbc));
        driver.close();
        // we are turning back to amazon
        driver.switchTo().window(amzWHV);
         amzPagetxt= driver.getTitle();
         expectedText="Amazon";
        Assert.assertTrue(amzPagetxt.contains(expectedText));
    }
}
