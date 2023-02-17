package com.chasmlabs.automation.common;

import com.chasmlabs.automation.controller.common.GetStateManager;
import com.google.gson.internal.LinkedTreeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

class GetStateTest {

    @Test
    @DisplayName("Test case for to Get Status ")
    void getStateTest_TC01(){
        GetStateManager getStateManager = new GetStateManager( "AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = getStateManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from Postman Response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "type" from Postman Response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("state_list",type);

        //Assert "message" from postman response:
        String message = responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("Data Get Successfully!",message);

        //Assert "data" from Postman response:-
        Object data = responseManager.getResponsePojo().getData();
        String jsonString= getStateManager.convertToJson(data);
        Object name = ((LinkedTreeMap<?, ?>) ((ArrayList<?>) responseManager.getResponsePojo().getData()).get(0)).get("name");
        Object abbreviation = ((LinkedTreeMap<?, ?>) ((ArrayList<?>) responseManager.getResponsePojo().getData()).get(0)).get("abbreviation");
        Assertions.assertEquals("Alabama",name);
        Assertions.assertEquals("AL",abbreviation);

    }

}
