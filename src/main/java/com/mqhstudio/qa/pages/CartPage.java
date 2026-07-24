package com.mqhstudio.qa.pages;

import com.mqhstudio.qa.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    private final WebDriver driver;
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CheckoutInformationPage goToCartPage() {
        WaitUtils.waitForElementClicable(driver, checkoutButton).click();
        return new CheckoutInformationPage(driver);
    }
}
