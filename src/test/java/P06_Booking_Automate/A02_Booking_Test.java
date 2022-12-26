package P06_Booking_Automate;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class A02_Booking_Test {
    WebDriver driver;
    //1. Booking.com git

    //2. Cookies handle et
    //3. Sayfanin basliginda "..." Kelimesi var mi ? Test et
    //4. Arama kutusuna gidecegin lokasyonu gir ve cikan sonuclarda girilen ismin yer aldigini test et.
    //5. Ilk cikan sonucu tikla ve resmin gorunur oldugunu test et.
    //6 tarih araliklarini gir, kisi sayisi  ve Oda sayilarini doldur ve sayfa da cikan son urune tikla ve fiyati tespit ederek gorunur oldugunu test et.

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
       driver= new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.booking.com/");
        driver.findElement(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]")).click();
    }
    @After
    public  void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }

    @Test
    public void titleTest(){
        String expectedWord="otel";
        String actualWord=driver.getTitle();
        System.out.println(actualWord);
        Assert.assertTrue(actualWord.contains(expectedWord));
    }
    @Test
    public void srcBxTest(){
        WebElement srcBx= driver.findElement(By.xpath("//input[@class=\"c-autocomplete__input sb-searchbox__input sb-destination__input\"]"));
        srcBx.sendKeys("Amsterdam"+ Keys.ENTER);
        String resultText= driver.findElement(By.xpath("//h1[@class=\"e1f827110f d3a14d00da\"]")).getText();
        System.out.println(resultText);
        Assert.assertTrue(resultText.toLowerCase().contains("amsterdam"));
    }

    @Test
    public void lastTest(){
        WebElement dateCheckin= driver.findElement(By.xpath("//span[@date-date='2022-12-27']"));
        dateCheckin.click();
        driver.findElement(By.xpath("//button[@data-testid='date-display-field-end']")).click();
        WebElement dateCheckout=driver.findElement(By.xpath("//span[@date-date='2022-12-30']"));
        dateCheckout.click();

    }

}
