package pages.MainPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyBrowser;

public class MainPaigeGoToCart {
    @FindBy(className= "shopping_cart_link")
    static WebElement cartButton;

    static {
        PageFactory.initElements(MyBrowser.driver, MainPaigeGoToCart.class);
    }

    public static void goToCart(){
        cartButton.click();
    }
}
