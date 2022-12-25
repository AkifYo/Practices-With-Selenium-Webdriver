package P06_Booking_Automate;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class A01_Booking {
    WebDriver driver;
    @BeforeTest
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.get("https://www.booking.com/");
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }
    @AfterTest
    public void finishDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void srcBxSrc() throws InterruptedException {
        placeToGo("mardin");
        choosingDate("2022-12-28","2023-01-31");
        chooseTheAmountPerson(2,2,2);
    }


    public void placeToGo(String place){
        WebElement srcBx= driver.findElement(By.xpath("//input[@class='c-autocomplete__input sb-searchbox__input sb-destination__input']"));
        srcBx.click();
        srcBx.sendKeys(place);// the way can also be implemented
        srcBx.submit();
        WebElement resultText= driver.findElement(By.xpath("//h1[@class='e1f827110f d3a14d00da']"));

        String expectedText=place;
        String actualResult=resultText.getText().toLowerCase();
        Assert.assertTrue(actualResult.contains(expectedText));
    }
    public void choosingDate(String checkInDate, String checkOutDate) throws InterruptedException {
        // date format should be 2022-12-31
        WebElement checkindate= driver.findElement(By.xpath("//span[@data-date='"+checkInDate+"']"));
        checkindate.click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@data-testid='date-display-field-end']")).click();
        WebElement checoutDate=driver.findElement(By.xpath("//span[@data-date='"+checkOutDate+"']"));
        checoutDate.click();

    }
    public void chooseTheAmountPerson(int adult, int child, int room) throws InterruptedException {

        WebElement personAmount = driver.findElement(By.xpath("//button[@data-testid='occupancy-config']"));
        personAmount.click();
        WebElement adultPlus= driver.findElement(By.xpath("(//button[@class='fc63351294 a822bdf511 e3c025e003 fa565176a8 f7db01295e e1b7cfea84 d64a4ea64d'])[1]"));

        for (int i = 2; i < adult; i++) {
            adultPlus.click();
        }
        Thread.sleep(2000);
        WebElement childPlus= driver.findElement(By.xpath("(//button[@class='fc63351294 a822bdf511 e3c025e003 fa565176a8 f7db01295e e1b7cfea84 d64a4ea64d'])[2]"));
        for (int i = 0; i <child ; i++) {
            childPlus.click();
        }
        Thread.sleep(2000);
        WebElement roomPlus= driver.findElement(By.xpath("(//button[@class='fc63351294 a822bdf511 e3c025e003 fa565176a8 f7db01295e e1b7cfea84 d64a4ea64d'])[3]"));
        for (int i = 0; i <room ; i++) {
            roomPlus.click();
        }
        driver.findElement(By.xpath("//button[@class='fc63351294 a822bdf511 e2b4ffd73d f7db01295e af18dbd5a4 a9a04704ee d285d0ebe9']")).click();
    }
}
