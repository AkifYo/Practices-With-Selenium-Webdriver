package Tests.P05_Amazon_Nl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class A02_Search_Product {
    public static  void searchProduct(String productName){
        WebElement srcBox=A01_SetUp.driver.findElement(By.id("twotabsearchtextbox"));
        srcBox.click();
        srcBox.sendKeys(productName);
        srcBox.sendKeys(Keys.ENTER);

    }
}
