package com.chasmlabs.automation.auth;

import com.chasmlabs.automation.controller.auth.GetUserDetailsManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class GetUserDetailsTest {

    @Test
    @DisplayName("Test case of success scenario for Get User Details")
    void getUserDetailsTest_TC01(){
        GetUserDetailsManager getUserDetailsManager = new GetUserDetailsManager("AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = getUserDetailsManager.executeApi();
        Assertions.assertNotNull(responseManager);
    }
}
