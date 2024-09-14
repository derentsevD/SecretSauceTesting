package pages.MainPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.MyBrowser;

public class MainPageSort {
    //Selector doesn't work
    private static final By SELECT_CONTAINER = By.className("product_sort_container");
    private static final By FIRST_ITEM = By.cssSelector("#inventory_container > div > div:nth-child(1) > div.inventory_item_description");

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
       return MyBrowser.driver.findElement(FIRST_ITEM).getText();
    }
}
