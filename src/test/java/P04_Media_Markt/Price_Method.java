package P04_Media_Markt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Price_Method {
    public static void priceRange(String firstP, String secondP){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebElement minPrice= driver.findElement(By.cssSelector("input[name='min']"));
        minPrice.sendKeys(firstP);
        WebElement maxPrice= driver.findElement(By.cssSelector("input[name='max']"));
        maxPrice.sendKeys(secondP);
        maxPrice.sendKeys(Keys.ENTER);

    }
}
