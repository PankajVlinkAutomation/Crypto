package com.chasmlabs.automation.primetrust;

import com.chasmlabs.automation.controller.primetrust.AccountCreateManager;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountCreateTest {
    @Test
    @DisplayName("Test case for to Account Create in PrimeTrust")
    void accountCreateTest_TC01(){
        AccountCreateManager accountCreateManager = new AccountCreateManager( "AuthModule/JSON/Login/LoginRequest.json","Primetrust.JSON/CreateAccount.json");
        var responseManager = accountCreateManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from Postman Response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "type" from Postman Response:-
        String typee = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("create_account",typee);

        //Assert "message" from postman response:
        Object message = responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("Account has been successfully created",message);

        //Assert "data" from Postman response:-
        Object data = responseManager.getResponsePojo().getData();
        String jsonString= accountCreateManager.convertToJson(data);

        JSONObject jsonObject=new JSONObject(jsonString);

        //Assert "type" object under "data" from Postman response:-
        Object type = jsonObject.get("type");
        Assertions.assertEquals("accounts",type);

        //Assert "attributes" from Postman response:-
        Object attributes = jsonObject.get("attributes");
        String att= accountCreateManager.convertToJson(attributes);

        JSONObject object=new JSONObject(att);
        String s = object.get("map").toString();

        //Assert "name" from Postman Response:-
        JSONObject object1=new JSONObject(s);
        Object name = object1.get("name");
        Assertions.assertEquals("Pankaj Kashyap",name);
    }

}
