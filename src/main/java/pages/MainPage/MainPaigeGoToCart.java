package pages.MainPage;

import core.BasePage;
import org.openqa.selenium.By;

public class MainPaigeGoToCart extends BasePage {
    private static final By SHOPPING_CART_LINK = By.className("shopping_cart_link");

    public static void goToCart(){
        click(SHOPPING_CART_LINK);
    }
}
