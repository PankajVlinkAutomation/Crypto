package com.chasmlabs.automation.controller.common;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.controller.auth.LoginManager;
import com.chasmlabs.automation.dto.common.response.GetCoinGeckoResponseDto;
import com.chasmlabs.automation.dto.common.response.GetStateResponseDto;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.chasmlabs.automation.util.Constants.*;

@Slf4j
public class GetCoinGeckoManager extends ApiManager {

    private Response response;
    private GetCoinGeckoResponseDto responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();
    Map<String, String> pathParams = new HashMap<>();

    public GetCoinGeckoManager(String loginPath){
        setMethod(MethodType.GET);
        LoginManager loginManager=new LoginManager(loginPath);
        var apiResponse = loginManager.executeApi();
        String accessToken = apiResponse.getResponsePojo().getAccessToken();
        headerList.add(new Header("Authorization","Bearer "+accessToken));
    }
    public GetCoinGeckoManager executeApi(){
        headerList.add(new Header(CLIENT_ID_HEADER,CLIENT_ID));
        headerList.add(new Header(CLIENT_SECRET_HEADER,CLIENT_SECRET));
       // pathParams.put("whereColumn","digital_asset_name,digital_asset_ticker");
        //.put("whereValue","bitcoin,BTC");

        response=execute(queryParams,pathParams,headerList,null, null,GET_COIN_GECKO_URL);
        if (response.getStatusCode() != 200) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responseDTO = convertFromJson(response.asString(), GetCoinGeckoResponseDto.class);
        }
        return this;
    }
    @Override
    public Response getApiResponse() {
        return null;
    }

    @Override
    public GetCoinGeckoResponseDto getResponsePojo() {
        return this.responseDTO;
    }
}
