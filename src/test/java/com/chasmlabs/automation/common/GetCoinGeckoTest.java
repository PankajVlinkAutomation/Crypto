package com.chasmlabs.automation.common;

import com.chasmlabs.automation.controller.common.GetCoinGeckoManager;
import com.chasmlabs.automation.controller.common.GetStateManager;
import com.google.gson.internal.LinkedTreeMap;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

class GetCoinGeckoTest {

    @Test
    @DisplayName("Test case for to Get Coin Gecko")
    void getCoinGeckoTest_TC01(){
        GetCoinGeckoManager getCoinGeckoManager = new GetCoinGeckoManager( "AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = getCoinGeckoManager.executeApi();
        Assertions.assertNotNull(responseManager);

        //Assert "success" from Postman Response:-
        String success = responseManager.getResponsePojo().getSuccess();
        Assertions.assertEquals("true",success);

        //Assert "type" from Postman Response:-
        String type = responseManager.getResponsePojo().getType();
        Assertions.assertEquals("coin_gecko",type);

        //Assert "message" from postman response:
        String message = responseManager.getResponsePojo().getMessage();
        Assertions.assertEquals("Data Get Successfully!",message);

        //Assert "data" from Postman response:-
        Object data = responseManager.getResponsePojo().getData();
        String jsonString = getCoinGeckoManager.convertToJson(data);
        JSONObject jsonObject=new JSONObject(jsonString);

        //Assert "id" from Postman response:-
        Object id = jsonObject.get("id");
        String i_d=id.toString();
        Assertions.assertEquals("1.0",i_d);

        //Assert "digital_asset_ticker" from Postman response:-
        Object digitalAssetTicker = jsonObject.get("digital_asset_ticker");
        Assertions.assertEquals("BTC",digitalAssetTicker);

        //Assert "digital_asset_name" from Postman response:-
        Object  digitalAssetName= jsonObject.get("digital_asset_name");
        Assertions.assertEquals("bitcoin",digitalAssetName);

        //Assert "usd_price" from Postman response:-
        Object  usdPrice= jsonObject.get("usd_price");
        Assertions.assertEquals("16865.02",usdPrice);

        //Assert "status code" from postman response:
        int statusCode = responseManager.getResponsePojo().getStatusCode();
        Assertions.assertEquals(200,statusCode);

    }

}
