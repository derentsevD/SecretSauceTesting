package pages.MainPage;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.MyBrowser;

import java.util.List;

public class MainPageSort {
    @FindBy(id = "product_sort_container")
    static Select dropdownSort;

    /**
     * Change the sort type of the items
     * @param sortId - the ID of the sorting you want:
     *               1.Name A-Z
     *               2.Name Z-A
     *               3.Price low-high
     *               4.Price high-low
     *
     */
    public static void SelectSortType(int sortId){dropdownSort.selectByIndex(sortId);}
}
