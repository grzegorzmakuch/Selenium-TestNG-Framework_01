package com.mqhstudio.qa.utils;

public class LoginData {
    private String username;
    private String password;
    private String expectedErrorMessage;

    public LoginData() {}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getExpectedErrorMessage() {
        return expectedErrorMessage;
    }
}
