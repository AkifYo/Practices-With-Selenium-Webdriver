package P05_Amazon_Nl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class A02_Search_Product {
    public static  void searchProduct(String productName){
        WebElement srcBox=A01_SetUp.driver.findElement(By.xpath("//input[@id='nav-bb-search']"));
        srcBox.click();
        srcBox.sendKeys(productName);
        srcBox.sendKeys(Keys.ENTER);

    }
}
