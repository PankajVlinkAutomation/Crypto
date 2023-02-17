package com.chasmlabs.automation.transaction;

import com.chasmlabs.automation.controller.transaction.TransactionManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TransactionTest {

    @Test
    @DisplayName("Test case for to Get Status ")
    void transactionTest_TC01(){
        TransactionManager transactionManager = new TransactionManager( "AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = transactionManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from Postman Response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "type" from Postman Response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("transactions",type);

        //Assert "message" from postman response:
        String message = responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("Data Get Successfully!",message);

    }

}
