package Tests.P05_Amazon_Nl;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class A01_Arunner {
    public static void main(String[] args) throws InterruptedException {

        A01_SetUp.setUp();
        A01_SetUp.cookiesHandle();
        Thread.sleep(2000);
        A02_Search_Product.searchProduct("Samsung");
        Actions action= new Actions(A01_SetUp.driver);
        Thread.sleep(5000);
        A03_Review_Stars.reviewStar(4);
        A04_FindMark.findMark(3);
        Thread.sleep(2000);
        action.sendKeys(Keys.PAGE_DOWN).perform();

        A01_SetUp.finishTest();
    }
}
