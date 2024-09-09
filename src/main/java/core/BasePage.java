package core;

import org.openqa.selenium.WebElement;
import utils.MyBrowser;

public class BasePage {
    protected static void click(WebElement element){element.click();}
    protected static void type(WebElement element, String text){element.sendKeys(text);}
    protected static void openUrl(String url){MyBrowser.driver.get(url);}
    protected static String getText(WebElement element){return element.getText();}
    protected static boolean checkElementIsDisplayed(WebElement element){return element.isDisplayed();}
}
