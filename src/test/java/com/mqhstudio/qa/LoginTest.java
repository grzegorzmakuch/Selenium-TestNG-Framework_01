package com.mqhstudio.qa;

import com.mqhstudio.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @org.testng.annotations.DataProvider(name="wrongLoginData")
    public Object[][] dataToFeed() {
        return new Object[][] {
                {"standard_user", "zle_haslo", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test
    public void correctLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToAccount("standard_user", "secret_sauce");

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Logowanie nie powiodlo sie");
    }

    @Test(dataProvider = "wrongLoginData")
    public void wrongLoginTest(String login, String password, String expectedError) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToAccount(login, password);

        String currentErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(currentErrorMessage, expectedError, "Niepoprawny komunikat bledu");
    }
}
