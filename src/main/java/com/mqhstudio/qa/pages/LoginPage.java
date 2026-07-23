package com.mqhstudio.qa.pages;

import com.mqhstudio.qa.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.cssSelector("[data-test='error']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
//        driver.findElement(usernameField).sendKeys(username);
        WaitUtils.waitForElementVisible(driver, usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
//        driver.findElement(passwordField).sendKeys(password);
        WaitUtils.waitForElementVisible(driver, passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
//        driver.findElement(loginButton).click();
        WaitUtils.waitForElementClicable(driver, loginButton).click();
    }

    public void loginToAccount(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    public String getErrorMessage() {
//        return driver.findElement(errorMessage).getText();
        return WaitUtils.waitForElementVisible(driver, errorMessage).getText();
    }
}
