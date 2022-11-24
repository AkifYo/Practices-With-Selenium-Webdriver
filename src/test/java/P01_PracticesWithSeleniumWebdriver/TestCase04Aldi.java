package P01_PracticesWithSeleniumWebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestCase04Aldi {
    @Test
    public static void main(String[] args) {
        // first you should do first setup
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // navigate to aldi web site
        driver.get("https://www.aldi.nl/");
        // accept the cookies installingen
        List<WebElement> elements = driver.findElements(By.tagName("button"));

        for (WebElement element : elements) {
            if (element.getText().contains("Accepteer")){
                System.out.println(element.getText());
            }

        }

//        WebElement copkiesBtn= driver.findElement(By.tagName("button"));
//        copkiesBtn.click();



    }
}
