package pages.Cart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyBrowser;

public class CartProceedToCheckout {
    @FindBy(id = "checkout")
    static WebElement checkoutButton;

    static {
        PageFactory.initElements(MyBrowser.driver, CartProceedToCheckout.class);
    }

    /**
     * Clicks the button to proceed to checkout
     */
    public static void proceedToCheckout(){checkoutButton.click();}
}
