package com.chasmlabs.automation.auth;

import com.chasmlabs.automation.controller.auth.CheckEmailManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckEmailTest {

    @Test
    @DisplayName("Test case of check existing email")
    void checkEmailTest_TC01() {
        CheckEmailManager checkEmailManager = new CheckEmailManager("AuthModule/JSON/Login/LoginRequest.json", "AuthModule/JSON/CheckEmail/CheckEmail.json");
        var responseManager = checkEmailManager.executeApi();
        Assertions.assertNotNull(responseManager);
    }

    @Test
    @DisplayName("Test case of check non existing email")
    void checkEmailTest_TC02() {
        CheckEmailManager checkEmailManager = new CheckEmailManager("AuthModule/JSON/Login/LoginRequest.json", "AuthModule/JSON/CheckEmail/CheckEmailWithNonExistingEmail.json");
        var responseManager = checkEmailManager.executeApi();
        Assertions.assertNotNull(responseManager);
    }

    @Test
    @DisplayName("Test case of check invalid email")
    void checkEmailTest_TC03() {
        CheckEmailManager checkEmailManager = new CheckEmailManager("AuthModule/JSON/Login/LoginRequest.json", "AuthModule/JSON/CheckEmail/CheckMailWithInvalidEmail.json");
        var responseManager = checkEmailManager.executeApi();
        Assertions.assertNotNull(responseManager);
        String status = responseManager.getResponsePojo().getStatus();
        Assertions.assertEquals("false",status);
        Object message = responseManager.getResponsePojo().getMessage();
        String jsonString = checkEmailManager.convertToJson(message);
        JSONObject json=new JSONObject(jsonString);
        JSONArray emailArray = (JSONArray) json.get("email");
        Object o = emailArray.get(0);
        //Assert response with Postman response:-
        Assertions.assertEquals("The email must be a valid email address.",o);

    }
}
