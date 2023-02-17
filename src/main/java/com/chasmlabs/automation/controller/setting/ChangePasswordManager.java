package com.chasmlabs.automation.controller.setting;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.commons.BaseApi;
import com.chasmlabs.automation.controller.auth.CheckEmailManager;
import com.chasmlabs.automation.controller.auth.LoginManager;
import com.chasmlabs.automation.dto.auth.request.CheckEmailRequest;
import com.chasmlabs.automation.dto.auth.response.CheckEmailResponse;
import com.chasmlabs.automation.dto.setting.response.ChangePasswordResponseDto;
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
public class ChangePasswordManager extends ApiManager {
    private Response response;
    public ChangePasswordRequest requestDTO;
    private ChangePasswordResponseDto responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();
    Map<String, String> pathParams = new HashMap<>();

    public ChangePasswordManager(String loginPath,String changePasswordBodyPath) {
        String requestData = readJsonFile(changePasswordBodyPath);
        setMethod(BaseApi.MethodType.POST);
        requestDTO = convertFromJson(requestData, ChangePasswordRequest.class);

        LoginManager loginManager=new LoginManager(loginPath);
        loginManager=loginManager.executeApi();
        var apiResponse=loginManager.getResponsePojo();
        String accessToken=apiResponse.getAccessToken();
        headerList.add(new Header("Authorization","Bearer "+accessToken));

    }
    public ChangePasswordManager executeApi() {
        headerList.add(new Header(CLIENT_ID_HEADER, CLIENT_ID));
        headerList.add(new Header(CLIENT_SECRET_HEADER, CLIENT_SECRET));
        headerList.add(new Header(REQUEST_SERVER_URL_HEADER, REQUEST_URL));

        response = execute( queryParams, pathParams, headerList, new Gson().toJson(requestDTO), ContentType.JSON, CHANGE_PASSWORD);
        if (response.getStatusCode() != 200) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responseDTO = convertFromJson(response.asString(), ChangePasswordResponseDto.class);
        }
        return this;
    }

    @Override
    public Response getApiResponse() {
        return null;
    }

    @Override
    public ChangePasswordResponseDto getResponsePojo() {
        return this.responseDTO;
    }
}
