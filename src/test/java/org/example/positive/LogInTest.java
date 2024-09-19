package org.example.positive;

import org.example.core.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Login.LoginUser;
import utils.MyBrowser;

import static org.testng.Assert.assertTrue;

public class LogInTest extends BaseTest {

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


}
