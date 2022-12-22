package P05_Amazon_Nl;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.security.Key;

public class A01_Arunner {
    public static void main(String[] args) throws InterruptedException {

        A01_SetUp.setUp();
        A01_SetUp.cookiesHandle();
        Thread.sleep(3000);
        A02_Search_Product.searchProduct("iphone");
        Actions action= new Actions(A01_SetUp.driver);
        Thread.sleep(3000);
        A03_Review_Stars.reviewStar(4);
        A04_FindMark.findMark(3);
        Thread.sleep(2000);
        action.sendKeys(Keys.PAGE_DOWN).perform();

        A01_SetUp.finishTest();
    }
}
