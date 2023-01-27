package Tests.P03_Ui_UseMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class C_Search_Box {
    public static void  searchText(String productName){
        WebElement searchBx= B_FirstMethods.driver.findElement(By.id("searchfor"));
        searchBx.sendKeys(productName);
        searchBx.sendKeys(Keys.ENTER);

    }
}
