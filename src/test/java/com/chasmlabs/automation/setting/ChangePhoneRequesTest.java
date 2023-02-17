package com.chasmlabs.automation.setting;

import com.chasmlabs.automation.controller.setting.ChangePhoneRequesManager;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangePhoneRequesTest {
    @Test
    @DisplayName("Test case of change phone with valid phone")
    void changePhoneTest_TC01() {
        ChangePhoneRequesManager changePhoneRequesManager = new ChangePhoneRequesManager("AuthModule/JSON/Login/LoginRequest.json", "Setting/JSON/ChangePhone/ChangePhonePositive.json");
        var responseManager = changePhoneRequesManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "status" from response from Postman response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "message" from response from Postman response:-
        String message = (String) responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("An email has been sent to confirm your phone number change.",message);

        //Assert "status_code" from response from Postman response:-
        String statusCode = responseManager.getResponsePojo().getStatusCode();
        Assertions.assertEquals("200",statusCode);

        //Assert "data" from response from Postman response:-
        Object data = responseManager.getResponsePojo().getData();
        String jsonString = changePhoneRequesManager.convertToJson(data);

        //convert response in jsonObject:-
        JSONObject jsonObject=new JSONObject(jsonString);

        //Assert "phone" from response from postman:-
        Object phone = jsonObject.get("phone");
        Assertions.assertEquals("7905727019",phone);

        //Assert "new_phone" from response from postman:-
        Object new_phone = jsonObject.get("new_phone");
        Assertions.assertEquals("7905727018",new_phone);
    }
    @Test
    @DisplayName("Test case of change phone with previous phone number")
    void changePhoneTest_TC02() {
        ChangePhoneRequesManager changePhoneRequesManager = new ChangePhoneRequesManager("AuthModule/JSON/Login/LoginRequest.json", "Setting/JSON/ChangePhone/ChangePhoneWithOldPhone.json");
        var responseManager = changePhoneRequesManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from postman response
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("false",success);

        //Assert "message" from postman response
        String message = (String) responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("This phone is already associated to another user’s account.",message);

    }
    @Test
    @DisplayName("Test case of change phone number with  invalid phone number")
    void changePhoneTest_TC03(){
        ChangePhoneRequesManager changePhoneRequesManager=new ChangePhoneRequesManager("AuthModule/JSON/Login/LoginRequest.json", "Setting/JSON/ChangePhone/ChangePhoneInvalid.json");
        var responseManager = changePhoneRequesManager.executeApi();

        //Assert "success" from postman response
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("false",success);

        //Assert "type" from postman response
        Object type =responseManager.getResponsePojo().getType();
        Assertions.assertEquals("validation",type);

        //Assert "message" from postman response
        Object message = responseManager.getResponsePojo().getMessage();
        String jsonString=changePhoneRequesManager.convertToJson(message);
        JSONObject jsonObject=new JSONObject(jsonString);
        JSONArray jsonArray=jsonObject.getJSONArray("new_phone");
        Object newPhone = jsonArray.get(0);
        Assertions.assertEquals("The new phone must be at least 10 characters.",newPhone);
    }
}
