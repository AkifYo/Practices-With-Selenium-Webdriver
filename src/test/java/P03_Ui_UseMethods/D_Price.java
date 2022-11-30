package P03_Ui_UseMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class D_Price {
    public static void priceControl(String firstValue, String secondValue){
       WebElement leftSide= B_FirstMethods.driver.findElement(By.id("multiple-range_12194_selected-min"));
       leftSide.clear();
       leftSide.sendKeys(firstValue);
       WebElement rightSide= B_FirstMethods.driver.findElement(By.id("multiple-range_12194_selected-max"));
       rightSide.clear();
      rightSide.sendKeys(secondValue);
    }
}
