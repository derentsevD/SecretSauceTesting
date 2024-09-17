package pages.MainPage;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.MyBrowser;

import java.util.ArrayList;

public class MainPageSort extends BasePage {
    //Selector doesn't work
    private static final By SELECT_CONTAINER = By.className("product_sort_container");
    private static final By FIRST_ITEM = By.cssSelector("#inventory_container > div > div:nth-child(1) > div.inventory_item_description");
    private static final By INVENTORY_ITEM_NAME = By.className("inventory_item_name");
    private static final By INVENTORY_ITEM_PRICE = By.className("inventory_item_price");
    /**
     * Change the sort type of the items
     * @param sortId - the ID of the sorting you want:
     *               0.Name A-Z
     *               1.Name Z-A
     *               2.Price low-high
     *               3.Price high-low
     *
     */
    public static void selectSortType(int sortId){
     Select filterDropdown = new Select(MyBrowser.driver.findElement(SELECT_CONTAINER));
     filterDropdown.selectByIndex(sortId);
    }

    public static String getFirstItemPrice(){
       //return MyBrowser.driver.findElement(FIRST_ITEM).getText();
       return getTextFromElement(FIRST_ITEM);
    }

    /**
     * Checks if the items on the main paige are sorted by price descending(High->Low)
     * by comparing the first product's price to the second, second to third, etc.
     *
     * @return returns a boolean whether the items are sorted correctly
     */
    public static boolean checkSortedByPriceHiLo(){
        boolean sortedCorrectly = true;
        ArrayList<WebElement> collection = new ArrayList<>(MyBrowser.driver.findElements(INVENTORY_ITEM_PRICE));
        for(int i = 0; i < collection.size() - 1; i++){
            //Gets the double value for price of each element, by getting the text and subtracting the dollar sign.
            if(Double.parseDouble(collection.get(i).getText().substring(1)) < Double.parseDouble(collection.get(i + 1).getText().substring(1))){
                sortedCorrectly = false;
                return sortedCorrectly;
            }
        }
        return sortedCorrectly;
    }

    public static boolean checkSortedByPriceLoHi(){
        boolean sortedCorrectly = true;
        ArrayList<WebElement> collection = new ArrayList<>(MyBrowser.driver.findElements(INVENTORY_ITEM_PRICE));
        for(int i = 0; i < collection.size() - 1; i++){
            //Gets the double value for price of each element, by getting the text and subtracting the dollar sign.
            if(Double.parseDouble(collection.get(i).getText().substring(1)) > Double.parseDouble(collection.get(i + 1).getText().substring(1))){
                sortedCorrectly = false;
                return sortedCorrectly;
            }
        }
        return sortedCorrectly;
    }

    public static boolean checkSortedByAZ(){
        boolean sortedCorrectly = true;
        ArrayList<WebElement> collection = new ArrayList<>(MyBrowser.driver.findElements(INVENTORY_ITEM_NAME));
        for(int i = 0; i < collection.size() - 1; i++){
            //Gets the double value for price of each element, by getting the text and subtracting the dollar sign.
            if(collection.get(i).getText().compareTo(collection.get(i+1).getText()) > 0){
                sortedCorrectly = false;
                return sortedCorrectly;
            }
        }
        return sortedCorrectly;
    }

    public static boolean checkSortedByZA(){
        boolean sortedCorrectly = true;
        ArrayList<WebElement> collection = new ArrayList<>(MyBrowser.driver.findElements(INVENTORY_ITEM_NAME));
        for(int i = 0; i < collection.size() - 1; i++){
            //Gets the double value for price of each element, by getting the text and subtracting the dollar sign.
            if(collection.get(i).getText().compareTo(collection.get(i+1).getText()) < 0){
                sortedCorrectly = false;
                return sortedCorrectly;
            }
        }
        return sortedCorrectly;
    }


}
