package pages.Cart;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyBrowser;

public class CartProceedToCheckout extends BasePage {
    @FindBy(id = "checkout")
    static WebElement checkoutButton;

    private static final By CHECKOUT_BUTTON = By.id("checkout");

    static {
        PageFactory.initElements(MyBrowser.driver, CartProceedToCheckout.class);
    }

    /**
     * Clicks the button to proceed to checkout
     */
    public static void proceedToCheckout(){click(CHECKOUT_BUTTON);}
}
