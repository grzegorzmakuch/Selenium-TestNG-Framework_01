package com.mqhstudio.qa;

import com.mqhstudio.qa.pages.InventoryPage;
import com.mqhstudio.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest{

    private LoginPage loginPage;
    private InventoryPage inventoryPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);

        loginPage.loginToAccount("standard_user", "secret_sauce");
    }

    @Test
    public void addItemToCartTest() {
        Assert.assertTrue(inventoryPage.isHeaderVisible(), "Naglowek nie jest widoczny");
        inventoryPage.addItemToCart("Sauce Labs Backpack");
        String amountItemsInCart = inventoryPage.getCartItemsAmount();
        Assert.assertEquals(amountItemsInCart,"1", "Licznik nie zaktualizowal sie");
    }
}
