package PracticesWithSeleniumWebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TesteCase06CoolBlue {

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
        WebElement proNavBar= driver.findElement(By.xpath("//span[@class='coolbar-navigation--title-with-tagline']"));
        actions.moveToElement(proNavBar).click().perform();
        // click the first products category
        //WebElement firstCategory= driver.findElement(By.xpath("//li[@class='navigation-bar__item collapsible-panel alt-horizontal is-collapsed js-collapsible js-category-navigation-menu--link is-active']"));
        //actions.moveToElement(firstCategory).perform();

    }
}
