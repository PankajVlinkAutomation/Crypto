package com.chasmlabs.automation.setting;

import com.chasmlabs.automation.controller.setting.TransactionLimitManager;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TransactionLimitTest {
    @Test
    @DisplayName("Test case to get Transaction Limit")
    void transactionLimitTest_TC01(){
        TransactionLimitManager transactionLimitManager=new TransactionLimitManager("AuthModule/JSON/Login/LoginRequest.json");
        var responseManager=transactionLimitManager.executeApi();

        //Assert "success" from postman response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "type" from postman response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("transaction_limits",type);

        //Assert "message" from postman response:-
        String message = (String) responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("Transaction limits get successfully",message);

        //Assert "data" from postman response:-
        Object data = responseManager.getResponsePojo().getData();
        String jsonString= transactionLimitManager.convertToJson(data);
        JSONObject jsonObject=new JSONObject(jsonString);
        Object total_transaction_per_day_limit = jsonObject.get("total_transaction_per_day_limit");
        Assertions.assertEquals("5",total_transaction_per_day_limit);
    }

}
