package com.chasmlabs.automation.common;

import com.chasmlabs.automation.controller.common.GetAssetMasterManager;
import com.chasmlabs.automation.controller.common.GetCoinGeckoManager;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetAssetMasterTest {

    @Test
    @DisplayName("Test case for to Get Coin Gecko")
    void getCoinGeckoTest_TC01(){
        GetAssetMasterManager getAssetMasterManager = new GetAssetMasterManager( "AuthModule/JSON/Login/LoginRequest.json");
        var responseManager = getAssetMasterManager.executeApi();
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

        //Assert "status code" from postman response:
        int statusCode = responseManager.getResponsePojo().getStatusCode();
        Assertions.assertEquals(200,statusCode);

        //Assert "data" from Postman response:-
        Object data = responseManager.getResponsePojo().getData();
        String jsonString = getAssetMasterManager.convertToJson(data);
        JSONObject jsonObject=new JSONObject(jsonString);

        //Assert "asset_name" from postman response:
        Object assetName = jsonObject.get("asset_name");
        Assertions.assertEquals("Bitcoin",assetName);

        //Assert "asset_amount_ticker" from postman response:
        Object assetAmountTicker = jsonObject.get("asset_amount_ticker");
        Assertions.assertEquals("BTC",assetAmountTicker);

        //Assert "coingecko_asset_name" from postman response:
        Object  coinGeckoAssetName= jsonObject.get("coingecko_asset_name");
        Assertions.assertEquals("bitcoin",coinGeckoAssetName);

        //Assert "asset_unit_name" from postman response:
        Object  assetUnitName= jsonObject.get("asset_unit_name");
        Assertions.assertEquals("BTC",assetUnitName);

        //Assert "primetrust_asset_id" from postman response:
        Object  primeTrustAssetId= jsonObject.get("primetrust_asset_id");
        Assertions.assertEquals("798debbc-ec84-43ea-8096-13e2ebcf4749",primeTrustAssetId);

        //Assert "asset_transfer_type" from postman response:
        Object  assetTransferType= jsonObject.get("asset_transfer_type");
        Assertions.assertEquals("bitcoin",assetTransferType);

        //Assert "hex_codes" from postman response:
        Object  hexCodes= jsonObject.get("hex_codes");
        Assertions.assertEquals("#F7931A",hexCodes);

        //Assert "asset_decimal_places" from postman response:
        Object  assetDecimalPlaces= jsonObject.get("asset_decimal_places");
        String h=assetDecimalPlaces.toString();
        Assertions.assertEquals("8.0",h);

    }

}
