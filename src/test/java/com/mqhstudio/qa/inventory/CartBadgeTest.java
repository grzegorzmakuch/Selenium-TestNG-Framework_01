package com.mqhstudio.qa.inventory;

import com.mqhstudio.qa.BaseTest;
import com.mqhstudio.qa.pages.InventoryPage;
import com.mqhstudio.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartBadgeTest extends BaseTest {

    @Test
    public void verifyDynamicCartBadge() {
        LoginPage loginPage = new LoginPage(driver);
        String testingItem = "Sauce Labs Backpack";

        InventoryPage inventoryPage = loginPage.loginToAccount("standard_user", "secret_sauce");
        Assert.assertEquals(inventoryPage.getItemsAmountInCart(), 0, "Blad koszyka");

        inventoryPage.addItemToCart(testingItem);
        Assert.assertEquals(inventoryPage.getItemsAmountInCart(), 1, "nie odswiezony");

        inventoryPage.removeItemFromCart(testingItem);
        Assert.assertEquals(inventoryPage.getItemsAmountInCart(), 0, "produkt nie usunal sie");
    }
}
