package core;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import static utils.MyBrowser.driver;

public class BasePage {
    protected static void click(By locator){driver.findElement(locator).click();}
    protected static void type(By locator, String text){driver.findElement(locator).sendKeys(text);}
    protected static void openUrl(String url){driver.get(url);}
    protected static String getText(By locator){return driver.findElement(locator).getText();}
    protected static boolean checkElementIsDisplayed(By locator){return driver.findElement(locator).isDisplayed();}
    protected static String getTextFromElement(By locator){return driver.findElement(locator).getText();}
    protected static WebElement findElement(By locator){return driver.findElement(locator);}

    public static void takeScreenshot(String fileName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("E:\\Automation QA\\Screenshots\\" + fileName + new SimpleDateFormat("ss.mm.HH.dd.MM.yyyy").format(new java.util.Date()) +".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }
}
