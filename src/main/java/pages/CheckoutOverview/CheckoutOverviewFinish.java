package pages.CheckoutOverview;

import core.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.PageFactory;
import utils.MyBrowser;

import static utils.MyBrowser.driver;

public class CheckoutOverviewFinish extends BasePage {
    @FindBy(id = "finish")
    static WebElement finishButton;
    @FindBy(id = "checkout_complete_container")
    static WebElement checkoutCompleteContainer;

    static {
        PageFactory.initElements(MyBrowser.driver, CheckoutOverviewFinish.class);
    }

    public static void FinishCheckout(){
        finishButton.click();
        }

    public static void TakeScreenshot(){
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("E:\\Automation QA\\Screenshots\\checkoutScreenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkCheckoutCompleteContainerIsDisplayed(){
        return checkElementIsDisplayed(checkoutCompleteContainer);
    }
}


