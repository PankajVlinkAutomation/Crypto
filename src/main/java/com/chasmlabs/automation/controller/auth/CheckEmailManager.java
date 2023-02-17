package com.chasmlabs.automation.controller.auth;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.commons.BaseApi;
import com.chasmlabs.automation.dto.auth.request.CheckEmailRequest;
import com.chasmlabs.automation.dto.auth.response.CheckEmailResponse;
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
public class CheckEmailManager extends ApiManager {
    private Response response;
    public CheckEmailRequest requestDTO;
    private CheckEmailResponse responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();
    Map<String, String> pathParams = new HashMap<>();

    public CheckEmailManager(String loginPath,String emailBodyPath) {
        String requestData = readJsonFile(emailBodyPath);
        setMethod(BaseApi.MethodType.POST);
        requestDTO = convertFromJson(requestData, CheckEmailRequest.class);

        LoginManager loginManager=new LoginManager(loginPath);
        loginManager=loginManager.executeApi();
        var apiResponse=loginManager.getResponsePojo();
        String accessToken=apiResponse.getAccessToken();
        headerList.add(new Header("Authorization","Bearer "+accessToken));

    }

    public CheckEmailManager executeApi() {
        headerList.add(new Header(CLIENT_ID_HEADER, CLIENT_ID));
        headerList.add(new Header(CLIENT_SECRET_HEADER, CLIENT_SECRET));

        response = execute( queryParams, pathParams, headerList, new Gson().toJson(requestDTO), ContentType.JSON, CHECK_EMAIL);
        if (response.getStatusCode() != 200) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responseDTO = convertFromJson(response.asString(), CheckEmailResponse.class);
        }
        return this;
    }

    public Response getApiResponse() {
        return null;
    }

    @Override
    public CheckEmailResponse getResponsePojo() {
        return this.responseDTO;
    }
}
