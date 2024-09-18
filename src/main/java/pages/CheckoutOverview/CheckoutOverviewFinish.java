package pages.CheckoutOverview;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DecimalFormat;
import java.util.List;

public class CheckoutOverviewFinish extends BasePage {
    private static final By FINISH_BUTTON = By.id("finish");
    private static final By CHECKOUT_COMPLETE_CONTAINER = By.id("checkout_complete_container");
    private static final By INVENTORY_ITEM_PRICE = By.className("inventory_item_price");
    private static final By SUMMARY_TOTAL_LABEL = By.className("summary_total_label");
    private static final DecimalFormat df = new DecimalFormat("0.00");


    public static void finishCheckout() {
        click(FINISH_BUTTON);
    }

    public static boolean checkCheckoutCompleteContainerIsDisplayed() {
        return checkElementIsDisplayed(CHECKOUT_COMPLETE_CONTAINER);
    }

    /**
     * Sums the prices of all the products, add tax and compares if the "Total calculation" is correct
     * @return - returns 0 if the price is correct
     */
    public static int checkTotalCalculation(){
        double totalPrice = 0;

        List<WebElement> productPrices = findElements(INVENTORY_ITEM_PRICE);

        for (WebElement productPrice : productPrices) {
            totalPrice += Double.parseDouble(productPrice.getText().substring(1));
        }

        //The tax is 8%
        totalPrice *= 1.08;

        //Should return 0 if values are equal
        //Removes the first 8 chars from the "total" to subtract only the price
        return Double.compare(Double.parseDouble(df.format(totalPrice)),Double.parseDouble(findElement(SUMMARY_TOTAL_LABEL).getText().substring(8)));
    }
}