package Tests.P05_Amazon_Nl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class A03_Review_Stars {
    public static void reviewStar(int reviewEndMore){
       WebElement stars= A01_SetUp.driver.findElement(By.xpath("//i[@class='a-icon a-icon-star-medium a-star-medium-"+reviewEndMore+"']"));
        stars.click();
    }
}
