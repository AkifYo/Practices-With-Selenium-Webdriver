package Tests.P03_Ui_UseMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class E_Review {


    public static void chooseStars(int starValue){
        WebElement starsFilter1= B_FirstMethods.driver.findElement(By.cssSelector("input[value='"+starValue+"']"));
//        WebElement starsFilter2= B_FirstMethods.driver.findElement(By.cssSelector("input[value='2']"));
//        WebElement starsFilter3= B_FirstMethods.driver.findElement(By.cssSelector("input[value='3']"));
//        WebElement starsFilter4= B_FirstMethods.driver.findElement(By.cssSelector("input[value='4']"));
//        WebElement starsFilter5= B_FirstMethods.driver.findElement(By.cssSelector("input[value='5']"));

            starsFilter1.click();

    }
}
