package P03_Ui_UseMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class F_Products_Title {
    public static void firstPageProducts(){

        for (int i = 1; i <6 ; i++) {
            WebElement firstPageProducts= B_FirstMethods.driver.findElement(By.xpath("(//a[@class='product-title px_list_page_product_click list_page_product_tracking_target'])["+i+"]"));
            WebElement price= B_FirstMethods.driver.findElement(By.xpath("(//span[@class='promo-price'])["+i+"]"));
            System.out.println("====="+price.getText()+"==="+firstPageProducts.getText()+"=====");
        }









    }
}
