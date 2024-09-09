package pages.MainPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyBrowser;

public class MainPageAddItemToCart {
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    static WebElement bikeLightAddToCart;
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    static WebElement backpackAddToCart;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    static WebElement tshirtAddToCart;
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    static WebElement jacketAddToCart;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    static WebElement onesieAddToCart;
    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    static WebElement redTshirtAddToCart;

    static {
        PageFactory.initElements(MyBrowser.driver, MainPageAddItemToCart.class);
    }

    public static void AddBikeLightToCart(){bikeLightAddToCart.click();}
    public static void AddBackpackToCart(){backpackAddToCart.click();}
    public static void AddTshirtToCart(){tshirtAddToCart.click();}
    public static void AddJacketToCart(){jacketAddToCart.click();}
    public static void AddOnesieToCart(){onesieAddToCart.click();}
    public static void AddRedTshirtToCart(){redTshirtAddToCart.click();}
}
