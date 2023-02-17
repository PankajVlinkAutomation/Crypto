package com.chasmlabs.automation.setting;

import com.chasmlabs.automation.controller.setting.ChangeEmailRequestManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangeEmailRequestTest {
    @Test
    @DisplayName("Test case of change Email with valid Email")
    void changeEmailRequestTest_TC01() {
        ChangeEmailRequestManager changeEmailRequestManager = new ChangeEmailRequestManager("AuthModule/JSON/Login/LoginRequest.json", "Setting/JSON/ChangeEmailRequest/ChangeEmailRequest.json");
        var responseManager = changeEmailRequestManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from postman response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "message" from postman response:-
        String message =(String) responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("An email has been sent to confirm your email address change.",message);

        //Assert "data" from postman response:-
        Object data = responseManager.getResponsePojo().getData();
        String  jsonString=changeEmailRequestManager.convertToJson(data);
        JSONObject jsonObject=new JSONObject(jsonString);
        Object email = jsonObject.get("email");
        Assertions.assertEquals("testerq065+3@gmail.com",email);

        Object newEmail = jsonObject.get("new_email");
        Assertions.assertEquals("testerq065+9@gmail.com",newEmail);

        //Assert "type" from postman response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("change_email_request_email",type);

    }
    @Test
    @DisplayName("Test case of change Email with Invalid Email & valid Password")
    void changeEmailRequestTest_TC02() {
        ChangeEmailRequestManager changeEmailRequestManager = new ChangeEmailRequestManager("AuthModule/JSON/Login/LoginRequest.json", "Setting/JSON/ChangeEmailRequest/ChangeEmailRequestInvalid.json");
        var responseManager = changeEmailRequestManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from postman response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("false",success);

        //Assert "message" from postman response:-
        Object message = responseManager.getResponsePojo().getMessage();
        String jsonString = changeEmailRequestManager.convertToJson(message);
        JSONObject json=new JSONObject(jsonString);
        JSONArray emailArray = (JSONArray) json.get("new_email");
        Object password=emailArray.get(0);
        Assertions.assertEquals("The new email must be a valid email address.",password);

        //Assert "type" from postman response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("validation",type);

    }
    @Test
    @DisplayName("Test case of change Email with valid Email & Invalid Password")
    void changeEmailRequestTest_TC03(){
        ChangeEmailRequestManager changeEmailRequestManager = new ChangeEmailRequestManager("AuthModule/JSON/Login/LoginRequest.json", "Setting/JSON/ChangeEmailRequest/ChangeEmailWithInvalidPassword.json");
        var responseManager = changeEmailRequestManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from postman response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("false",success);

        //Assert "message" from postman response:-
        Object message = responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("The current password is not match with old password.",message);

        //Assert "type" from postman response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("password_not_match",type);


    }
}
