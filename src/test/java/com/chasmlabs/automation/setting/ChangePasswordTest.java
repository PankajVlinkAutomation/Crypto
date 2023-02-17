package com.chasmlabs.automation.setting;

import com.chasmlabs.automation.controller.auth.CheckEmailManager;
import com.chasmlabs.automation.controller.setting.ChangePasswordManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangePasswordTest {
    @Test
    @DisplayName("Test case of change password with valid password")
    void changePasswordTest_TC01() {
        ChangePasswordManager changePasswordManager = new ChangePasswordManager("AuthModule/JSON/Login/LoginRequest.json", "Setting/JSON/ChangePassword/ChangePasswordPositive.json");
        var responseManager = changePasswordManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from postman response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "message" from postman response:-
        Object message = responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("Password changed successfully",message);

        //Assert "type" from postman response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("password_changed",type);

    }
    @Test
    @DisplayName("Test case of change password with Invalid password")
    void changePasswordTest_TC02() {
        ChangePasswordManager changePasswordManager = new ChangePasswordManager("AuthModule/JSON/Login/LoginRequest.json", "Setting/JSON/ChangePassword/ChangePasswordNegative.json");
        var responseManager = changePasswordManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from postman response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("false",success);

        //Assert "message" from postman response:-
        Object message = responseManager.getResponsePojo().getMessage();
        String jsonString = changePasswordManager.convertToJson(message);
        JSONObject jsonObject=new JSONObject(jsonString);
        JSONArray jsonArray=jsonObject.getJSONArray("password");
        Object password = jsonArray.get(0);
        Assertions.assertEquals("The password must be at least 8 characters.",password);

        //Assert "type" from postman response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("validation",type);
    }
    @Test
    @DisplayName("Test case of Change Password with Old Password")
    void changePasswordTest_TC03(){
        ChangePasswordManager changePasswordManager=new ChangePasswordManager("AuthModule/JSON/Login/LoginRequest.json", "Setting/JSON/ChangePassword/ChangePasswordWithOldPassword.json");
        var responseManager=changePasswordManager.executeApi();

        //Assert "success" from postman response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("false",success);

        //Assert "message" from postman response:-
        String message = (String) responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("New Password cannot be same as your current password.",message);

    }
}
