package com.chasmlabs.automation.primetrust;

import com.chasmlabs.automation.controller.primetrust.GetRefrenceContributionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetReferenceContributionTest {

    @Test
    @DisplayName("Test case for to Get Reference Contribution ")
    void getReferenceContributionTest_TC01(){
        GetRefrenceContributionManager getRefrenceContributionManager = new GetRefrenceContributionManager( "AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = getRefrenceContributionManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from Postman Response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "type" from Postman Response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("contact_funds_transfer_references",type);

        //Assert "status" from Postman Response:-
        String status = responseManager.getResponsePojo().getStatus_();
        Assertions.assertEquals("Success",status);

        //Assert "message" from postman response:
        Object message = responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("Data Get Successfully!",message);

        //Assert "status code" from postman response:
        int statusCode = responseManager.getResponsePojo().getStatus_code();
        Assertions.assertEquals(200,statusCode);

    }
}