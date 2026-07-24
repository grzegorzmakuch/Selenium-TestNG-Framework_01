package com.mqhstudio.qa.pages;

import com.mqhstudio.qa.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private final WebDriver driver;

    private final By productsHeader = By.cssSelector(".title");
    private final By cartIcon = By.cssSelector(".shopping_cart_link");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");

    private final String productAddToCartButtonXpath = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHeaderVisible() {
        return WaitUtils.waitForElementVisible(driver, productsHeader).isDisplayed();
    }

    public void addItemToCart(String itemName) {
        String dynamicLocator = String.format(productAddToCartButtonXpath, itemName);
        WaitUtils.waitForElementClicable(driver, By.xpath(dynamicLocator)).click();
    }

    public String getCartItemsAmount() {
        return WaitUtils.waitForElementVisible(driver, cartBadge).getText();
    }

    public void enterTheCartPage() {
        WaitUtils.waitForElementClicable(driver, cartIcon).click();
    }
}
