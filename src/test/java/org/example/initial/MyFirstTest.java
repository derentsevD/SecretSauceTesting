package org.example.initial;

import org.example.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Cart.CartProceedToCheckout;
import pages.Checkout.CheckoutFillData;
import pages.CheckoutOverview.CheckoutOverviewFinish;
import pages.Login.LoginUser;
import pages.MainPage.MainPageAddItemToCart;
import pages.MainPage.MainPaigeGoToCart;

public class MyFirstTest extends BaseTest {
    @Test
    public void logInLockedAccount(){
        LoginUser.goTo();
        LoginUser.userLogin("locked_out_user", "secret_sauce");
        Assert.assertEquals(LoginUser.checkUserIsLockedOut(),"Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void placingAnOrder(){
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        MainPageAddItemToCart.AddBikeLightToCart();
        MainPageAddItemToCart.AddOnesieToCart();
        MainPaigeGoToCart.goToCart();
        CartProceedToCheckout.proceedToCheckout();
        CheckoutFillData.FillCheckoutData("Dimitar", "Derentsev", "59068");
        CheckoutOverviewFinish.FinishCheckout();
        Assert.assertTrue(CheckoutOverviewFinish.checkCheckoutCompleteContainerIsDisplayed(),"The order was not placed successfully. Container not displayed.");
        CheckoutOverviewFinish.TakeScreenshot();
    }
}
