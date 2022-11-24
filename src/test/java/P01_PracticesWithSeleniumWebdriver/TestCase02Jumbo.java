package P01_PracticesWithSeleniumWebdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestCase02Jumbo {
   @Test
    public void testJumboInloggen(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // Launch the web browser of the grocery
        driver.get("https://www.jumbo.com/");
        driver.manage().window().maximize();
        // click on the akkord button for cookies installation
       WebElement akkordBtn= driver.findElement(By.id("onetrust-accept-btn-handler"));
       akkordBtn.click();
       //navigate to mijn jumbo element
       WebElement mijnJumbo= driver.findElement(By.xpath("//*[@id=\"jum_user_menu_large_button\"]/span"));
       mijnJumbo.click();
       // navigate to sign up element (registeer button)
       WebElement registeerBtn= driver.findElement(By.xpath("//a[@data-label='Registreer']"));
       registeerBtn.click();
       WebElement accountMaak= driver.findElement(By.xpath("//a[@data-label='Een account voor thuis']"));
       accountMaak.click();
       driver.navigate().back();
       driver.navigate().back();
       mijnJumbo= driver.findElement(By.xpath("//*[@id=\"jum_user_menu_large_button\"]/span"));
       mijnJumbo.click();
       WebElement inlogBtn= driver.findElement(By.xpath("//a[@class='item-link']"));
       inlogBtn.click();
       WebElement userTextBox= driver.findElement(By.xpath("//input[@id='username']"));
       userTextBox.sendKeys("akyor06@hotmail.com");
       WebElement passwordTextBox= driver.findElement(By.xpath("//input[@id='password']"));
       passwordTextBox.sendKeys("11111");

       WebElement inBtn= driver.findElement(By.xpath("//button[@data-label='Inloggen']"));
       Actions actions= new Actions(driver);
       actions.moveToElement(inBtn).click().perform();

       WebElement srcBox= driver.findElement(By.xpath("//input[@class='search-bar-input']"));
       actions.moveToElement(srcBox).click().sendKeys("nutella").sendKeys(Keys.ENTER).perform();
       WebElement resultText= driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div/div/div[2]/div/div[1]/div/span"));
       System.out.println(resultText.getText());
      driver.quit();


   }
}
