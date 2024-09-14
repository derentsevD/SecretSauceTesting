package pages.MainPage;

import core.BasePage;
import org.openqa.selenium.By;

public class MainPageAddItemToCart extends BasePage {
    private static final By BIKE_LIGHT_ADD_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-bike-light");
    private static final By BACKPACK_ADD_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-backpack");
    private static final By TSHIRT_ADD_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private static final By JACKET_ADD_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private static final By ONESIE_ADD_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-onesie");
    private static final By RED_TSHIRT_ADD_TO_CART_BUTTON = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");


    public static void addBikeLightToCart(){click(BIKE_LIGHT_ADD_TO_CART_BUTTON);}
    public static void addBackpackToCart(){click(BACKPACK_ADD_TO_CART_BUTTON);}
    public static void addTshirtToCart(){click(TSHIRT_ADD_TO_CART_BUTTON);}
    public static void addJacketToCart(){click(JACKET_ADD_TO_CART_BUTTON);}
    public static void addOnesieToCart(){click(ONESIE_ADD_TO_CART_BUTTON);}
    public static void addRedTshirtToCart(){click(RED_TSHIRT_ADD_TO_CART_BUTTON);}
}
