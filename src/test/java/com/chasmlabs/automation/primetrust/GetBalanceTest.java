package com.chasmlabs.automation.primetrust;

import com.chasmlabs.automation.controller.primetrust.GetBalanceManager;
import com.chasmlabs.automation.controller.primetrust.GetKycStatusManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class GetBalanceTest {

    @Test
    @DisplayName("Test case for to Get Balance Status")
    void getBalanceTest_TC01(){
        GetBalanceManager getBalanceManager = new GetBalanceManager( "AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = getBalanceManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from Postman Response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "type" from Postman Response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("balance",type);

        //Assert "status" from Postman Response:-
        String status = responseManager.getResponsePojo().getStatus_();
        Assertions.assertEquals("Success",status);

        //Assert "message" from postman response:
        Object message = responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("balance successfully fetched",message);

        //Assert "status code" from postman response:
        int statusCode = responseManager.getResponsePojo().getStatus_code();
        Assertions.assertEquals(200,statusCode);

        //Assert "data" from Postman response:-
        Object data = responseManager.getResponsePojo().getData();
        String jsonString= getBalanceManager.convertToJson(data);
        JSONObject object=new JSONObject(jsonString);
        BigDecimal totalBalance = (BigDecimal)object.get("totalBalance");
        Assertions.assertEquals(BigDecimal.valueOf(0.0),totalBalance);

    }
}