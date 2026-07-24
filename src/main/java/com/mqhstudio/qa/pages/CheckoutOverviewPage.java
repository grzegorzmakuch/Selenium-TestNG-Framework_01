package com.mqhstudio.qa.pages;

import com.mqhstudio.qa.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
    private final WebDriver driver;
    private final By finishButton = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    public void completeOrder() {
        WaitUtils.waitForElementClicable(driver, finishButton).click();
    }
}
