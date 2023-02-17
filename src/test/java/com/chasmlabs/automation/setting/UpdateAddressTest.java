package com.chasmlabs.automation.setting;

import com.chasmlabs.automation.controller.setting.ChangeEmailRequestManager;
import com.chasmlabs.automation.controller.setting.UpdateAddressManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UpdateAddressTest {
    @Test
    @DisplayName("Test case of Update Address")
    void updateAddressTest_TC01() {
        UpdateAddressManager updateAddressManager = new UpdateAddressManager("AuthModule/JSON/Login/LoginRequest.json", "Setting/JSON/UpdateAddress/updateAddress.json");
        var responseManager = updateAddressManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from postman response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "message" from postman response:-
//        String message =(String) responseManager.getResponsePojo().getMessage();
//        Assertions.assertEquals("An email has been sent to confirm your email address change.",message);
//
//        //Assert "data" from postman response:-
//        Object data = responseManager.getResponsePojo().getData();
//        String  jsonString=updateAddressManager.convertToJson(data);
//        JSONObject jsonObject=new JSONObject(jsonString);
//        Object email = jsonObject.get("email");
//        Assertions.assertEquals("testerq065+3@gmail.com",email);
//
//        Object newEmail = jsonObject.get("new_email");
//        Assertions.assertEquals("testerq065+9@gmail.com",newEmail);
//
//        //Assert "type" from postman response:-
//        String type = responseManager.getResponsePojo().getType();
//        Assertions.assertEquals("change_email_request_email",type);

    }

}
