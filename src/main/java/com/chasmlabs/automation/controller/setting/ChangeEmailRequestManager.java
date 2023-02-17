package com.chasmlabs.automation.controller.setting;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.commons.BaseApi;
import com.chasmlabs.automation.controller.auth.LoginManager;
import com.chasmlabs.automation.dto.setting.response.ChangeEmailRequestResponseDto;
import com.chasmlabs.automation.dto.setting.response.ChangePasswordResponseDto;
import com.chasmlabs.automation.dto.setting.resquest.ChangeEmailRequestRequest;
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
public class ChangeEmailRequestManager extends ApiManager {
    private Response response;
    public ChangeEmailRequestRequest requestDTO;
    private ChangeEmailRequestResponseDto responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();
    Map<String, String> pathParams = new HashMap<>();

    public ChangeEmailRequestManager(String loginPath,String changeEmailRequestBody) {
        String requestData = readJsonFile(changeEmailRequestBody);
        setMethod(BaseApi.MethodType.POST);
        requestDTO = convertFromJson(requestData, ChangeEmailRequestRequest.class);

        LoginManager loginManager=new LoginManager(loginPath);
        loginManager=loginManager.executeApi();
        var apiResponse=loginManager.getResponsePojo();
        String accessToken=apiResponse.getAccessToken();
        headerList.add(new Header("Authorization","Bearer "+accessToken));

    }
    public ChangeEmailRequestManager executeApi() {
        headerList.add(new Header(CLIENT_ID_HEADER, CLIENT_ID));
        headerList.add(new Header(CLIENT_SECRET_HEADER, CLIENT_SECRET));
        headerList.add(new Header(REQUEST_SERVER_URL_HEADER, REQUEST_URL));

        response = execute( queryParams, pathParams, headerList, new Gson().toJson(requestDTO), ContentType.JSON, CHANGE_EMAIL_REQUEST);
        if (response.getStatusCode() != 200) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responseDTO = convertFromJson(response.asString(), ChangeEmailRequestResponseDto.class);
        }
        return this;
    }
    @Override
    public Response getApiResponse() {
        return null;
    }

    @Override
    public ChangeEmailRequestResponseDto getResponsePojo() {
        return this.responseDTO;
    }
}
