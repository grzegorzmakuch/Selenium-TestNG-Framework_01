package com.mqhstudio.qa.login;

import com.mqhstudio.qa.BaseTest;
import com.mqhstudio.qa.pages.LoginPage;
import com.mqhstudio.qa.utils.JsonDataReader;
import com.mqhstudio.qa.utils.LoginData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "wrongLoginData", dataProviderClass = JsonDataReader.class)
    public void wrongLoginTest(LoginData testData) {
        LoginPage loginPage = new LoginPage(driver);

        String actualErrorMessage =  loginPage
                .enterUsername(testData.getUsername())
                .enterPassword(testData.getPassword())
                .clickLoginButton()
                .getErrorMessage();

        Assert.assertEquals(actualErrorMessage, testData.getExpectedErrorMessage(), "Zly komunikat bledu");
    }

    @Test(dataProvider = "correctLoginData", dataProviderClass = JsonDataReader.class)
    public void loginWithSuccessTest(LoginData testData) {
        LoginPage loginPage = new LoginPage(driver);
        boolean isCartVisible = loginPage
                .loginToAccount(testData.getUsername(), testData.getPassword())
                .isCartVisible();

        Assert.assertTrue(isCartVisible, "Logowanie nieudane, koszyk nie jest widoczny");
    }
}
