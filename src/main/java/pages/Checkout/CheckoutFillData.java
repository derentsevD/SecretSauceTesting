package pages.Checkout;

import core.BasePage;
import org.openqa.selenium.By;

public class CheckoutFillData extends BasePage {
    private static final By FIRST_NAME_FIELD = By.id("first-name");
    private static final By LAST_NAME_FIELD = By.id("last-name");
    private static final By POSTAL_CODE_FIELD = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");

    /**
     * Fills the information needed to place the order and clicks continue
     * @param firstName - customer's first name
     * @param lastName - customer's last name
     * @param postalCode - customer's postcode
     */
    public static void fillCheckoutData(String firstName, String lastName, String postalCode){
        type(FIRST_NAME_FIELD,firstName);
        type(LAST_NAME_FIELD,lastName);
        type(POSTAL_CODE_FIELD,postalCode);
        click(CONTINUE_BUTTON);
    }
}
