package com.chasmlabs.automation.auth;

import com.chasmlabs.automation.controller.auth.VerifyManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

class VerifyManagerTest {

    @Test
    @DisplayName("Test case of success scenario for User attempts to verify an user")
    void userVerifyTest_TC01(){
        VerifyManager verifyManager = new VerifyManager( false,  "", "registration/RegistrationRequest.json");
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

    @Test
    @DisplayName("Test case of failed scenario for User attempts to verify an user")
    void userVerifyTest_TC03(){
        given()
                .pathParam("verifyToken", "LLRPqxvU1uoT8YSl8")
                .get("http://20.121.45.110/api/verify_user/{verifyToken}")
                .then()
                .statusCode(422);
    }
}
