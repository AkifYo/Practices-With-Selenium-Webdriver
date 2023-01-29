package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlbertHijnHomePage {
    public AlbertHijnHomePage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (id = "accept-cookies")
    public WebElement cookiesButton;
}
