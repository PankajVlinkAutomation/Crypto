package com.chasmlabs.automation.primetrust;

import com.chasmlabs.automation.controller.primetrust.GetAMLCheckManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetAMLCheckTest {

    @Test
    @DisplayName("Test case for to Get AML Check ")
    void getAMLCheckTest_TC01(){
        GetAMLCheckManager getAMLCheckManager = new GetAMLCheckManager( "AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = getAMLCheckManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from Postman Response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "type" from Postman Response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("aml_checks",type);

        //Assert "status" from Postman Response:-
        String status = responseManager.getResponsePojo().getStatus_();
        Assertions.assertEquals("",status);

        //Assert "message" from postman response:
        Object message = responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("Please wait till update your AML status",message);

        //Assert "status code" from postman response:
        int statusCode = responseManager.getResponsePojo().getStatus_code();
        Assertions.assertEquals(200,statusCode);

    }
}