package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Cart.CartProceedToCheckout;
import pages.Checkout.CheckoutFillData;
import pages.CheckoutOverview.CheckoutOverviewFinish;
import pages.Login.LoginUser;
import pages.MainPage.MainPageAddItemToCart;
import pages.MainPage.MainPaigeGoToCart;
import utils.MyBrowser;

public class MyFirstTest {

    @BeforeMethod
    public void setup(){
        MyBrowser.open();
    }

    @Test
    public void placingAnOrder(){

        MyBrowser.driver.get("https://www.saucedemo.com/");
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

    @AfterMethod
    public void tearDown(){
        MyBrowser.quit();
    }
}
