package org.example.initial;

import org.example.core.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Cart.CartProceedToCheckout;
import pages.Checkout.CheckoutFillData;
import pages.CheckoutOverview.CheckoutOverviewFinish;
import pages.Login.LoginUser;
import pages.MainPage.MainPageAddItemToCart;
import pages.MainPage.MainPageSort;
import pages.MainPage.MainPaigeGoToCart;
import utils.MyBrowser;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyFirstTest extends BaseTest {

    @Test
    public void logInLockedAccount(){
        LoginUser.goTo();
        LoginUser.userLogin("locked_out_user", "secret_sauce");
        String text = LoginUser.checkUserIsLockedOut();
        Assert.assertEquals(text,"Epic sadface: Sorry, this user has been locked out.","User not locked");
    }

    @Test
    public void logInLogOut(){
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        LoginUser.userLogout();
        assertTrue(MyBrowser.driver.findElement(By.id("login-button")).isDisplayed());
    }

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
    public void changeSortingTypeToAZ() {
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        MainPageSort.selectSortType(0);
        assertTrue(MainPageSort.checkSortedByAZ(),"Items not sorted by alphabetical order A to Z");
    }

    @Test
    public void changeSortingTypeToZA() {
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        MainPageSort.selectSortType(1);
        assertTrue(MainPageSort.checkSortedByZA(),"Items not sorted by alphabetical order Z to A");
    }

    @Test
    public void changeSortingTypeToPriceAscending() {
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        MainPageSort.selectSortType(2);
        assertTrue(MainPageSort.checkSortedByPriceLoHi(),"Items not sorted by price in ascending.");
    }

    @Test
    public void changeSortingTypeToPriceDescending() {
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        MainPageSort.selectSortType(3);
        assertTrue(MainPageSort.checkSortedByPriceHiLo(), "Items not sorted by price in descending");
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
