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

import static org.testng.Assert.assertTrue;

public class MyFirstTest extends BaseTest {
    @Test
    public void logInLockedAccount(){
        LoginUser.goTo();
        LoginUser.userLogin("locked_out_user", "secret_sauce");
        //locator doesn't work
        String text = LoginUser.checkUserIsLockedOut("textContent");
        Assert.assertEquals(text,"Epic sadface: Sorry, this user has been locked out.","User not locked");
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
        CheckoutOverviewFinish.takeScreenshot();
    }


    @Test
    public void changeSortingType() {
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        //Sorts them by price High->Low(ID = 3)
        MainPageSort.selectSortType(3);
        //Checks the first product is the most expensive.
        assertTrue(MainPageSort.getFirstItemPrice().contains("$49.99"),"Sorting not correct");
    }

    @Test
    public void logInLogOut(){
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        LoginUser.userLogout();
        assertTrue(MyBrowser.driver.findElement(By.id("login-button")).isDisplayed());
    }
}
