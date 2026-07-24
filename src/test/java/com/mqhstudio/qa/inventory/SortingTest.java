package com.mqhstudio.qa.inventory;

import com.mqhstudio.qa.BaseTest;
import com.mqhstudio.qa.pages.InventoryPage;
import com.mqhstudio.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingTest extends BaseTest {

    @Test
    public void sortItemsByPriceAscending() {
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = loginPage.loginToAccount("standard_user", "secret_sauce");
        inventoryPage.sortProductsByPrice("lohi");
        List<Double> currentPrices = inventoryPage.getProductsPrice();
        List<Double> sortedPrices = new ArrayList<>(currentPrices);
        Collections.sort(sortedPrices);

        Assert.assertEquals(currentPrices, sortedPrices, "Produkty nie sa posortowane wlasciwie");
    }
}
