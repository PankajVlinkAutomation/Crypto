package com.chasmlabs.automation.primetrust;

import com.chasmlabs.automation.controller.primetrust.GetCIPStatusManager;
import com.chasmlabs.automation.controller.primetrust.GetKycStatusManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetCIPStatusTest {

    @Test
    @DisplayName("Test case for to Get CIP Status")
    void getCipStatusTest_TC01(){
        GetCIPStatusManager getCIPStatusManager = new GetCIPStatusManager( "AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = getCIPStatusManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from Postman Response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "type" from Postman Response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("cip_checks",type);

        //Assert "status" from Postman Response:-
        String status = responseManager.getResponsePojo().getStatus_();
        Assertions.assertEquals("pending",status);

            //Assert "message" from postman response:
        Object message = responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("CIP Status",message);

        //Assert "status code" from postman response:
        int statusCode = responseManager.getResponsePojo().getStatus_code();
        Assertions.assertEquals(200,statusCode);

        //Assert "data" from Postman response:-
        Object data = responseManager.getResponsePojo().getData();
        String jsonString= getCIPStatusManager.convertToJson(data);
        JSONObject jsonObject = new JSONObject(jsonString);

        Object type1 = jsonObject.get("type");
        Assertions.assertEquals("cip-checks",type1);
    }
}