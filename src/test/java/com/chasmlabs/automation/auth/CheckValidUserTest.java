package com.chasmlabs.automation.auth;

import com.chasmlabs.automation.controller.auth.CheckValidUserManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CheckValidUserTest {

    @Test
    @DisplayName("Test case to Check Valid User ")
    void checkValidUserTest_TC01() {
        CheckValidUserManager checkValidUserManager = new CheckValidUserManager("AuthModule/JSON/Login/LoginRequest.json", "CheckValidUser/CheckValidUser.json");
        var responseManager = checkValidUserManager.executeApi();
        Assertions.assertNotNull(responseManager);
    }

    @Test
    @DisplayName("Test case to Check Valid User ")
    void checkValidUserTest_TC02() {
        CheckValidUserManager checkValidUserManager = new CheckValidUserManager("AuthModule/JSON/Login/LoginRequest.json","CheckValidUser/CheckValidUserWithInvalidUser.json");
        var responseManager = checkValidUserManager.executeApi();
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("false",success);
        Object message = responseManager.getResponsePojo().getMessage();
        String jsonString = checkValidUserManager.convertToJson(message);
        JSONObject json=new JSONObject(jsonString);
        JSONArray emailArray = (JSONArray) json.get("email");
        Object o = emailArray.get(0);
        //Assert response with Postman response:-
        Assertions.assertEquals("This user are verify both status and email verification",o);
        Assertions.assertNotNull(responseManager);
    }
    @Test
    @DisplayName("Test case to Check Valid User ")
    void checkValidUserTest_TC03() {
        CheckValidUserManager checkValidUserManager = new CheckValidUserManager("AuthModule/JSON/Login/LoginRequest.json", "CheckValidUser/CheckValidUserWithInvalidUser.json");
        var responseManager = checkValidUserManager.executeApi();
        Object message = responseManager.getResponsePojo().getMessage();
        String jsonString = checkValidUserManager.convertToJson(message);
        JSONObject json=new JSONObject(jsonString);
        JSONArray password = (JSONArray) json.get("email");
        Object o = password.get(0);
        //Assert response with Postman response:-
        Assertions.assertEquals("This user are verify both status and email verification",o);
        Assertions.assertNotNull(responseManager);

    }

}
