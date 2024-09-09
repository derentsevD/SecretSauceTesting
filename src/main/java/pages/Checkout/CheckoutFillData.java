package pages.Checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.MyBrowser;

public class CheckoutFillData {
    @FindBy(id = "first-name")
    static WebElement firstNameField;
    @FindBy(id = "last-name")
    static WebElement lastNameField;
    @FindBy(id = "postal-code")
    static WebElement postalCodeField;
    @FindBy(id = "continue")
    static WebElement btnContinue;

    static {
        PageFactory.initElements(MyBrowser.driver, CheckoutFillData.class);
    }

    /**
     * Fills the information needed to place the order and clicks continue
     * @param firstName - customer's first name
     * @param lastName - customer's last name
     * @param postalCode - customer's postcode
     */
    public static void FillCheckoutData(String firstName, String lastName, String postalCode){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
        btnContinue.click();
    }
}
