package core;

import org.openqa.selenium.By;
import utils.MyBrowser;

public class BasePage {
    protected static void click(By locator){MyBrowser.driver.findElement(locator).click();}
    protected static void type(By locator, String text){MyBrowser.driver.findElement(locator).sendKeys(text);}
    protected static void openUrl(String url){MyBrowser.driver.get(url);}
    protected static String getText(By locator){return MyBrowser.driver.findElement(locator).getText();}
    protected static boolean checkElementIsDisplayed(By locator){return MyBrowser.driver.findElement(locator).isDisplayed();}
    protected static String getTextFromElement(By locator, String attribute){return MyBrowser.driver.findElement(locator).getText();}
}
