package com.chasmlabs.automation.primetrust;

import com.chasmlabs.automation.controller.primetrust.GetUploadDocumentsManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetUploadDocumentsTest {

    @Test
    @DisplayName("Test case for to Get Upload Document Status")
    void getUploadDocumentTest_TC01(){
        GetUploadDocumentsManager getUploadDocumentsManager = new GetUploadDocumentsManager( "AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = getUploadDocumentsManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from Postman Response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("false",success);

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
        String jsonString= getUploadDocumentsManager.convertToJson(data);


    }
}