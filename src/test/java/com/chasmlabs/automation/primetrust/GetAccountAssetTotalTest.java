package com.chasmlabs.automation.primetrust;

import com.chasmlabs.automation.controller.primetrust.GetAccountAssetTotalsManager;
import com.chasmlabs.automation.controller.primetrust.GetKycStatusManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetAccountAssetTotalTest {

    @Test
    @DisplayName("Test case for to Get Account asset Total")
    void getAccountAssetTotalsTest_TC01(){
        GetAccountAssetTotalsManager getAccountAssetTotalsManager = new GetAccountAssetTotalsManager( "AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = getAccountAssetTotalsManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from Postman Response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "type" from Postman Response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("asset_balance",type);

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