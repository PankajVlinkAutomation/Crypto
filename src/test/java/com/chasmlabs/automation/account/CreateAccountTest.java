package com.chasmlabs.automation.account;

import com.chasmlabs.automation.controller.account.CreateAccountManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CreateAccountTest {

    @Test
    @DisplayName("Test case of Create Account with unique Details")
    void createAccountTest_TC01() {
        CreateAccountManager createAccountManager = new CreateAccountManager("AuthModule/JSON/Login/LoginRequest.json", "Account.JSON/CreateAccount.json");
        var responseManager = createAccountManager.executeApi();
        Assertions.assertNotNull(responseManager);
    }
    @Test
    @DisplayName("Test case of Create Account with already exist tax id")
    void createAccountTest_TC02() {
        CreateAccountManager createAccountManager = new CreateAccountManager("AuthModule/JSON/Login/LoginRequest.json", "Account.JSON/CreateAccount.json");
        var responseManager = createAccountManager.executeApi();
        Assertions.assertNotNull(responseManager);
        Object message = responseManager.getResponsePojo().getMessage();
        String jsonString = createAccountManager.convertToJson(message);
        JSONObject json=new JSONObject(jsonString);
        JSONArray emailArray = (JSONArray) json.get("tax_id_number");
        String txIdMsg= (String) emailArray.get(0);
        //Assert response with Postman response:-
        Assertions.assertEquals("The tax id number has already been taken.",txIdMsg);
    }
}
