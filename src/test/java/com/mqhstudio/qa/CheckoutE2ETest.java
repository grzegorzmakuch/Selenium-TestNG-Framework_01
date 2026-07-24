package com.mqhstudio.qa;

import com.mqhstudio.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutE2ETest extends BaseTest{
    private LoginPage loginPage;

    @BeforeMethod
    public void setupTest() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void fullPathProcessTest() {
        String currentMessage = loginPage
                .loginToAccount("standard_user", "secret_sauce")
                .addItemToCart("Sauce Labs Backpack")
                .enterTheCartPage()
                .goToCartPage()
                .fillTheClientData("jan", "nowak", "1125")
                .completeOrder()
                .getSuccessMessage();

//        String currentMessage = checkoutCompletePage.getSuccessMessage();
        Assert.assertEquals(currentMessage, "Thank you for your order!", "Proces zakupu bez sukcesu");
    }
}
