package com.chasmlabs.automation.auth;

import com.chasmlabs.automation.controller.auth.VerifyManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class VerifyTest {

    @Test
    @DisplayName("Test case of success scenario for User attempts to verify an user")
    void userVerifyTest_TC01(){
        VerifyManager verifyManager = new VerifyManager( false,  "", "AuthModule/JSON/registration/RegistrationRequest.json");
        var responseManager = verifyManager.executeApi();
        Assertions.assertNotNull(responseManager);
    }


    @Test
    @DisplayName("Test case of failed scenario for User attempts to verify an user")
    void userVerifyTest_TC02(){
        VerifyManager verifyManager = new VerifyManager( true,  "invalid token", null);
        var responseManager = verifyManager.executeApi();
        Assertions.assertNotNull(responseManager);
    }

}
