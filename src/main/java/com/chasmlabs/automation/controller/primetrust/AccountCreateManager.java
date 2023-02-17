package com.chasmlabs.automation.controller.primetrust;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.commons.BaseApi;
import com.chasmlabs.automation.controller.auth.LoginManager;
import com.chasmlabs.automation.dto.common.response.GetStateResponseDto;
import com.chasmlabs.automation.dto.primetrust.request.AccountCreateRequest;
import com.chasmlabs.automation.dto.primetrust.response.AccountCreateResponseDto;
import com.chasmlabs.automation.dto.setting.resquest.ChangePasswordRequest;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.chasmlabs.automation.util.Constants.*;

@Slf4j
public class AccountCreateManager extends ApiManager {

    private Response response;

    public AccountCreateRequest requestDTO;
    private AccountCreateResponseDto responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();
    Map<String, String> pathParams = new HashMap<>();

    public AccountCreateManager(String loginPath,String accountCreatePath){
        String requestData=readJsonFile(accountCreatePath);
        setMethod(MethodType.POST);
        requestDTO = convertFromJson(requestData, AccountCreateRequest.class);

        LoginManager loginManager=new LoginManager(loginPath);
        loginManager=loginManager.executeApi();
        var apiResponse=loginManager.getResponsePojo();
        String accessToken=apiResponse.getAccessToken();
        headerList.add(new Header("Authorization","Bearer "+accessToken));
    }
    public AccountCreateManager executeApi(){

        headerList.add(new Header(CLIENT_ID_HEADER,CLIENT_ID));
        headerList.add(new Header(CLIENT_SECRET_HEADER,CLIENT_SECRET));
        //headerList.add(new Header(REQUEST_SERVER_URL_HEADER,REQUEST_URL));

        response=execute(queryParams,pathParams,headerList,new Gson().toJson(requestDTO), ContentType.JSON,ACCOUNT_CREATE_PRIME);
        if (response.getStatusCode() != 200) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responseDTO = convertFromJson(response.asString(), AccountCreateResponseDto.class);
        }
        return this;
    }
    @Override
    public Response getApiResponse() {
        return null;
    }

    @Override
    public AccountCreateResponseDto getResponsePojo() {
        return this.responseDTO;
    }
}
