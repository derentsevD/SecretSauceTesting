package pages.Cart;

import core.BasePage;
import org.openqa.selenium.By;

public class CartProceedToCheckout extends BasePage {
    private static final By CHECKOUT_BUTTON = By.id("checkout");

    /**
     * Clicks the button to proceed to checkout
     */
    public static void proceedToCheckout(){click(CHECKOUT_BUTTON);}
}
