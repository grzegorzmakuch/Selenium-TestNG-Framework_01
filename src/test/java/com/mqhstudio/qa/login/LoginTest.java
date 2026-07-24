package com.mqhstudio.qa.login;

import com.mqhstudio.qa.BaseTest;
import com.mqhstudio.qa.pages.LoginPage;
import com.mqhstudio.qa.utils.JsonDataReader;
import com.mqhstudio.qa.utils.LoginData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = JsonDataReader.class)
    public void wrongLoginTest(LoginData testData) {
        LoginPage loginPage = new LoginPage(driver);

        String actualErrorMessage =  loginPage
                .enterUsername(testData.getUsername())
                .enterPassword(testData.getPassword())
                .clickLoginButton()
                .getErrorMessage();

        Assert.assertEquals(actualErrorMessage, testData.getExpectedErrorMessage(), "Zly komunikat bledu");
    }
}
