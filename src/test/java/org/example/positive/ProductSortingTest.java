package org.example.positive;

import org.example.core.BaseTest;
import org.testng.annotations.Test;
import pages.Login.LoginUser;
import pages.MainPage.MainPageSort;

import static org.testng.Assert.assertTrue;

public class ProductSortingTest extends BaseTest {
    @Test
    public void changeSortingTypeToAZ() {
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        MainPageSort.selectSortType(0);
        assertTrue(MainPageSort.checkSortedByAZ(),"Items not sorted by alphabetical order A to Z");
    }

    @Test
    public void changeSortingTypeToZA() {
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        MainPageSort.selectSortType(1);
        assertTrue(MainPageSort.checkSortedByZA(),"Items not sorted by alphabetical order Z to A");
    }

    @Test
    public void changeSortingTypeToPriceAscending() {
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        MainPageSort.selectSortType(2);
        assertTrue(MainPageSort.checkSortedByPriceLoHi(),"Items not sorted by price in ascending.");
    }

    @Test
    public void changeSortingTypeToPriceDescending() {
        LoginUser.goTo();
        LoginUser.userLogin("standard_user", "secret_sauce");
        MainPageSort.selectSortType(3);
        assertTrue(MainPageSort.checkSortedByPriceHiLo(), "Items not sorted by price in descending");
    }
}
