package com.mqhstudio.qa.pages;

import com.mqhstudio.qa.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage {
    private final WebDriver driver;

    private final By productsHeader = By.cssSelector(".title");
    private final By cartIcon = By.cssSelector(".shopping_cart_link");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By sortDropdown = By.cssSelector("[data-test='product-sort-container']");
    private final By itemPrices = By.className("inventory_item_price");

//    private final String productAddToCartButtonXpath = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button";

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHeaderVisible() {
        return WaitUtils.waitForElementVisible(driver, productsHeader).isDisplayed();
    }

    public boolean isCartVisible() {
        return WaitUtils.waitForElementVisible(driver, cartIcon).isDisplayed();
    }

//    dodawanie artykulu
    public InventoryPage addItemToCart(String itemName) {
        By productButton = By.xpath("//div[text()='"+itemName+"']//ancestor::div[@class='inventory_item']//button[text()='Add to cart']");
//        String dynamicLocator = String.format(productAddToCartButtonXpath, itemName);
        WaitUtils.waitForElementClicable(driver, productButton).click();
        return this;
    }

//  usuwanie artykulu z koszyka
    public InventoryPage removeItemFromCart(String itemName) {
        By removeButton = By.xpath("//div[text()='"+itemName+"']//ancestor::div[@class='inventory_item']//button[text()='Remove']");
        WaitUtils.waitForElementClicable(driver, removeButton).click();
        return this;
    }

//  todo: zmiana opcji sortowania
    public InventoryPage sortProductsByPrice(String dropdownValue) {
        WebElement dropdownElement = WaitUtils.waitForElementVisible(driver, sortDropdown);
        Select select = new Select(dropdownElement);
        select.selectByValue(dropdownValue);
        return this;
    }

//  todo: pobranie listy cen produktow
    public List<Double> getProductsPrice() {
        List<WebElement> itemPriceElement = driver.findElements(itemPrices);
        return itemPriceElement.stream()
                .map(WebElement::getText)
                .map(text -> text.replace("$",""))
                .map(Double::parseDouble)
                .collect(Collectors.toUnmodifiableList());
    }

//  todo: zmienic zwracany typ danych na Integer
    public int getItemsAmountInCart() {
        List<WebElement> badges = driver.findElements(cartBadge);
        if(badges.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(badges.get(0).getText());
    }

    public String getCartItemsAmount() {
        return WaitUtils.waitForElementVisible(driver, cartBadge).getText();
    }

    public CartPage enterTheCartPage() {
        WaitUtils.waitForElementClicable(driver, cartIcon).click();
        return new CartPage(driver);
    }
}
