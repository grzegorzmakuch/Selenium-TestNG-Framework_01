package com.mqhstudio.qa;

import com.mqhstudio.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutE2ETest extends BaseTest{
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutInformationPage checkoutInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @Test
    public void fullPathProcessTest() {
        loginPage.loginToAccount("standard_user", "secret_sauce");
        inventoryPage.addItemToCart("Sauce Labs Backpack");
        inventoryPage.enterTheCartPage();
        cartPage.goToCartPage();
        checkoutInformationPage.fillTheClientData("jan", "nowak", "1125");
        checkoutOverviewPage.completeOrder();

        String currentMessage = checkoutCompletePage.getSuccessMessage();
        Assert.assertEquals(currentMessage, "Thank you for your order!", "Proces zakupu bez sukcesu");
    }
}
