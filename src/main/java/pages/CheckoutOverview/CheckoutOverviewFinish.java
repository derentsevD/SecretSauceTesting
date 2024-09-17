package pages.CheckoutOverview;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;

import static utils.MyBrowser.driver;

public class CheckoutOverviewFinish extends BasePage {
    private static final By FINISH_BUTTON = By.id("finish");
    private static final By CHECKOUT_COMPLETE_CONTAINER = By.id("checkout_complete_container");

    public static void finishCheckout() {
        click(FINISH_BUTTON);
    }

    public static void takeScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("E:\\Automation QA\\Screenshots\\checkoutScreenshot " + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date()) +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkCheckoutCompleteContainerIsDisplayed() {
        return checkElementIsDisplayed(CHECKOUT_COMPLETE_CONTAINER);
    }
}