package Tests.P05_Amazon_Nl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class A04_FindMark {
    public static void findMark (int index) throws InterruptedException {
        WebElement marks=A01_SetUp.driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])["+index+"]"));
        // 3 - samsung
        // 4- google
        // 5- redmi
        marks.click();
        Thread.sleep(2000);
        Actions actions= new Actions(A01_SetUp.driver);
        actions.scrollByAmount(100,20);
    }
}
