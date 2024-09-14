package org.example.initial;

import org.example.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Cart.CartProceedToCheckout;
import pages.Checkout.CheckoutFillData;
import pages.CheckoutOverview.CheckoutOverviewFinish;
import pages.Login.LoginUser;
import pages.MainPage.MainPageAddItemToCart;
import pages.MainPage.MainPageSort;
import pages.MainPage.MainPaigeGoToCart;

public class MyFirstTest extends BaseTest {
    @Test
    public void logInLockedAccount(){
        LoginUser.goTo();
        LoginUser.userLogin("locked_out_user", "secret_sauce");
        //locator doesn't work
        String text = LoginUser.checkUserIsLockedOut("textContent");
        Assert.assertEquals(text,"Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void placingAnOrder(){
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        MainPageAddItemToCart.addBikeLightToCart();
        MainPageAddItemToCart.addOnesieToCart();
        MainPaigeGoToCart.goToCart();
        CartProceedToCheckout.proceedToCheckout();
        CheckoutFillData.fillCheckoutData("Dimitar", "Derentsev", "59068");
        CheckoutOverviewFinish.finishCheckout();
        Assert.assertTrue(CheckoutOverviewFinish.checkCheckoutCompleteContainerIsDisplayed(),"The order was not placed successfully. Container not displayed.");
        CheckoutOverviewFinish.takeScreenshot();
    }


    @Test
    public void changeSortingType() throws InterruptedException {
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        //Sorts them by price High->Low
        MainPageSort.selectSortType(3);
        //Checks the first product is the most expensive.
        Assert.assertTrue(MainPageSort.getFirstItemPrice().contains("$49.99"));
    }


}
