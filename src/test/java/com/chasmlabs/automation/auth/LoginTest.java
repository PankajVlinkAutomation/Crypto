package com.chasmlabs.automation.auth;

import com.chasmlabs.automation.controller.auth.LoginManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LoginTest {

    @Test
    @DisplayName("Test case of success scenario for User attempts to Login with registered email")
    void userLoginTest_TC01() {
        LoginManager loginManager = new LoginManager("AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = loginManager.executeApi();
        Assertions.assertNotNull(responseManager);
        String tokenType = responseManager.getResponsePojo().getTokenType();
        Assertions.assertEquals("Bearer",tokenType);
    }

    @Test
    @DisplayName("Test case of User attempts to Login with unregistered email ")
    void userLoginTest_TC02() {
        LoginManager loginManager = new LoginManager("AuthModule/JSON/Login/LoginRequestWithUnregistered.json");
        var responseManager = loginManager.executeApi();
        String tokenType = responseManager.getResponsePojo().getTokenType();
        Assertions.assertEquals("Bearer",tokenType);

    }
}
