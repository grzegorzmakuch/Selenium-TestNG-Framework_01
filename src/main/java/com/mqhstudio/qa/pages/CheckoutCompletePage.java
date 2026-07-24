package com.mqhstudio.qa.pages;

import com.mqhstudio.qa.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    private final WebDriver driver;
    private final By completeHeader = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getSuccessMessage() {
        return WaitUtils.waitForElementVisible(driver, completeHeader).getText();
    }
}
