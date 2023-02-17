package com.chasmlabs.automation.controller.account;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.commons.BaseApi;
import com.chasmlabs.automation.controller.auth.LoginManager;
import com.chasmlabs.automation.controller.setting.ChangeEmailRequestManager;
import com.chasmlabs.automation.dto.account.request.CreateAccountRequest;
import com.chasmlabs.automation.dto.account.response.CreateAccountResponseDto;
import com.chasmlabs.automation.dto.setting.response.ChangeEmailRequestResponseDto;
import com.chasmlabs.automation.dto.setting.resquest.ChangeEmailRequestRequest;
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
public class CreateAccountManager extends ApiManager {
    public Response response;
    public CreateAccountRequest requestDTO;
    private CreateAccountResponseDto responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();
    Map<String, String> pathParams = new HashMap<>();

    public CreateAccountManager(String loginPath,String createAccountBody) {
        String requestData = readJsonFile(createAccountBody);
        setMethod(BaseApi.MethodType.POST);
        requestDTO = convertFromJson(requestData, CreateAccountRequest.class);

        LoginManager loginManager = new LoginManager(loginPath);
        loginManager = loginManager.executeApi();
        var apiResponse = loginManager.getResponsePojo();
        String accessToken = apiResponse.getAccessToken();
        headerList.add(new Header("Authorization", "Bearer " + accessToken));
    }
    public CreateAccountManager executeApi() {
        headerList.add(new Header(CLIENT_ID_HEADER, CLIENT_ID));
        headerList.add(new Header(CLIENT_SECRET_HEADER, CLIENT_SECRET));
        response = execute( queryParams, pathParams, headerList, new Gson().toJson(requestDTO), ContentType.JSON, CREATE_ACCOUNT);
        if (response.getStatusCode() != 200) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responseDTO = convertFromJson(response.asString(), CreateAccountResponseDto.class);
        }
        return this;
    }
    @Override
    public Response getApiResponse() {
        return null;
    }

    @Override
    public CreateAccountResponseDto getResponsePojo() {
        return this.responseDTO;
    }
}
