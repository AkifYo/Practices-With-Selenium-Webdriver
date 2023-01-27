package Tests.P01_PracticesWithSeleniumWebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class TestCase06CoolBlue {

    @Test
    public void testCool(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.coolblue.nl/");
        // locate the cookies button en click on it.
        WebElement ckBtn= driver.findElement(By.xpath("//button[@aria-Label='Accepteer onze cookies']"));
        ckBtn.click();
        // hover over the assertimen or alle producten
        Actions actions= new Actions(driver);
        //WebElement proNavBar= driver.findElement(By.xpath("//span[@class='coolbar-navigation--title-with-tagline']"));
        //actions.moveToElement(proNavBar).click().perform();
        // click the first products category
        WebElement firstCategory= driver.findElement(By.xpath("/html/body/div[1]/div/div/nav[1]/ul/li[1]/button"));
        //actions.moveToElement(firstCategory).perform();// we have frist category product
        WebElement laptopBar= driver.findElement(By.xpath("/html/body/div[1]/div/div/nav[1]/ul/li[1]/div/div/ul/li[1]/ul/li[1]/a"));
        actions.moveToElement(laptopBar);
        // try to have all  products titles
        //li[@class='category-navigation__item']
        List<WebElement> titlesOfProducts= driver.findElements(By.xpath("//a[@class='card__title']"));
        for (WebElement each:titlesOfProducts  ) {
            System.out.println(each.getText());
            if (each.getText()=="Telefonie"){
                System.out.println(each.getText());
                actions.moveToElement(each).click().perform();
                //each.click();
            }

            }
        }



    }

