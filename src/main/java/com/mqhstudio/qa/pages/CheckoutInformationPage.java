package com.mqhstudio.qa.pages;

import com.mqhstudio.qa.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage {
    private final WebDriver driver;

    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By postalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");

    public CheckoutInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillTheClientData(String firstName, String lastName, String postalCode) {
        WaitUtils.waitForElementVisible(driver, firstNameField).sendKeys(firstName);
        WaitUtils.waitForElementVisible(driver, lastNameField).sendKeys(lastName);
        WaitUtils.waitForElementVisible(driver, postalCodeField).sendKeys(postalCode);
        WaitUtils.waitForElementClicable(driver, continueButton).click();
    }
}
