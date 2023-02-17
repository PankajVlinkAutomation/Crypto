package com.chasmlabs.automation.auth;

import com.chasmlabs.automation.controller.auth.LogoutManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LogoutTest {

    @Test
    @DisplayName("Test case of success Logout")
    void userLogoutTest_TC01() {
        LogoutManager logoutManager = new LogoutManager("AuthModule/JSON/Login/LoginRequest.json", "AuthModule/JSON/registration/LogoutRequest.json");
        var responseManager = logoutManager.executeApi();
        Assertions.assertNotNull(responseManager);
    }
}
