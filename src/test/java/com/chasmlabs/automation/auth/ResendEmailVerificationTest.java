package com.chasmlabs.automation.auth;

import com.chasmlabs.automation.controller.auth.ResendEmailVerificationManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResendEmailVerificationTest {
    @Test
    @DisplayName("Test for Resend Email Verification with valid Email")
    void userResendEmailVerification_TC01(){
        ResendEmailVerificationManager resendEmailVerificationManager=new ResendEmailVerificationManager("AuthModule/JSON/ResendEmailVerification/ResendEmailVerificationWithValidEmail.json");
        var responseManager = resendEmailVerificationManager.executeApi();
        Assertions.assertNotNull(responseManager);
        Object message = responseManager.getResponsePojo().getMessage();
        String jsonString = resendEmailVerificationManager.convertToJson(message);
    }

    @Test
    @DisplayName("Test for Resend Email Verification with Invalid Email")
    void userResendEmailVerification_TC02(){
        ResendEmailVerificationManager resendEmailVerificationManager=new ResendEmailVerificationManager("AuthModule/JSON/ResendEmailVerification/ResendEmailVerificationWithInValidEmail.json");
        var responseManager = resendEmailVerificationManager.executeApi();
        Assertions.assertNotNull(responseManager);
        Object message = responseManager.getResponsePojo().getMessage();
        String jsonString = resendEmailVerificationManager.convertToJson(message);
        JSONObject json=new JSONObject(jsonString);
        JSONArray emailArray = (JSONArray) json.get("email");
        String email= (String) emailArray.get(0);
        //Assert response with Postman response:-
        Assertions.assertEquals("The email must be a valid email address.",email);


    }
}
