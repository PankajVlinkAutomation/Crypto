package com.chasmlabs.automation.primetrust;

import com.chasmlabs.automation.controller.common.GetAssetMasterManager;
import com.chasmlabs.automation.controller.primetrust.GetAccountStatusManager;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetAccountStatusTest {

    @Test
    @DisplayName("Test case for to Get Coin Gecko")
    void getAccountStatusTest_TC01(){
        GetAccountStatusManager getAccountStatusManager = new GetAccountStatusManager( "AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = getAccountStatusManager.executeApi();
        Assertions.assertNotNull(responseManager);
//        {
//            "success": true,
//                "status": "opened",
//                "type": "accounts",
//                "message": "Account Status",
//                "url": "",
//                "status_code": 200,
//                "data": ""
//        }
        //Assert "success" from Postman Response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "type" from Postman Response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("accounts",type);

        //Assert "status" from Postman Response:-
        String status = responseManager.getResponsePojo().getStatus_();
        Assertions.assertEquals("opened",status);

        //Assert "message" from postman response:
        Object message = responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("Account Status",message);

        //Assert "status code" from postman response:
        int statusCode = responseManager.getResponsePojo().getStatus_code();
        Assertions.assertEquals(200,statusCode);

    }

}
