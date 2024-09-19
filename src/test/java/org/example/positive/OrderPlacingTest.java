package org.example.positive;

import org.example.core.BaseTest;
import org.testng.annotations.Test;
import pages.Cart.CartProceedToCheckout;
import pages.Checkout.CheckoutFillData;
import pages.CheckoutOverview.CheckoutOverviewFinish;
import pages.Login.LoginUser;
import pages.MainPage.MainPageAddItemToCart;
import pages.MainPage.MainPaigeGoToCart;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class OrderPlacingTest extends BaseTest {

    @Test
    public void placeAnOrder(){
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        MainPageAddItemToCart.addBikeLightToCart();
        MainPageAddItemToCart.addOnesieToCart();
        MainPaigeGoToCart.goToCart();
        CartProceedToCheckout.proceedToCheckout();
        CheckoutFillData.fillCheckoutData("Dimitar", "Derentsev", "59068");
        CheckoutOverviewFinish.finishCheckout();
        assertTrue(CheckoutOverviewFinish.checkCheckoutCompleteContainerIsDisplayed(),"The order was not placed successfully. Container not displayed.");
        CheckoutOverviewFinish.takeScreenshot("checkout");
    }

    @Test
    public void checkCartPriceCalculatedCorrectly(){
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        MainPageAddItemToCart.addBikeLightToCart();
        MainPageAddItemToCart.addRedTshirtToCart();
        MainPageAddItemToCart.addOnesieToCart();
        MainPaigeGoToCart.goToCart();
        CartProceedToCheckout.proceedToCheckout();
        CheckoutFillData.fillCheckoutData("Test", "Test","12312");
        assertEquals(CheckoutOverviewFinish.checkTotalCalculation(),0,"The total price was not calculated correctly.");
    }
}
