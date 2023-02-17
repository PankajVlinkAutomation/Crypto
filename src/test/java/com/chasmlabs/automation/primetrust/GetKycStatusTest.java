package com.chasmlabs.automation.primetrust;

import com.chasmlabs.automation.controller.primetrust.GetKycStatusManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetKycStatusTest {

    @Test
    @DisplayName("Test case for to Get KYC Status")
    void getKycStatusTest_TC01(){
        GetKycStatusManager getKycStatusManager = new GetKycStatusManager( "AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = getKycStatusManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from Postman Response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "type" from Postman Response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("kyc_document_checks",type);

        //Assert "status" from Postman Response:-
        String status = responseManager.getResponsePojo().getStatus_();
        Assertions.assertEquals("verified",status);

        //Assert "message" from postman response:
        Object message = responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("Account Status",message);

        //Assert "status code" from postman response:
        int statusCode = responseManager.getResponsePojo().getStatus_code();
        Assertions.assertEquals(200,statusCode);

        //Assert "data" from Postman response:-
        Object data = responseManager.getResponsePojo().getData();
        String jsonString= getKycStatusManager.convertToJson(data);
        JSONArray object=new JSONArray(jsonString);
        Object identity = object.get(0);
        String s = identity.toString();
        JSONObject obj=new JSONObject(s);
        Object type1 = obj.get("type");
        Assertions.assertEquals("kyc-document-checks",type1);

    }
}