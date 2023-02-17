package com.chasmlabs.automation.controller.auth;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.commons.BaseApi;
import com.chasmlabs.automation.dto.auth.request.LoginRequest;
import com.chasmlabs.automation.dto.auth.response.LoginResponse;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.chasmlabs.automation.util.Constants.*;
@Slf4j
public class LoginManager extends ApiManager {
    private Response response;
    private LoginRequest requestDTO;
    private LoginResponse responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();

    public LoginManager(String path) {
        String requestData = readJsonFile(path);
        setMethod(BaseApi.MethodType.POST);
        requestDTO = convertFromJson(requestData, LoginRequest.class);

    }

    public LoginManager executeApi() {
        headerList.add(new Header(CLIENT_ID_HEADER, CLIENT_ID));
        headerList.add(new Header(CLIENT_SECRET_HEADER, CLIENT_SECRET));

        response = execute( queryParams, null, headerList, new Gson().toJson(requestDTO), ContentType.JSON, LOGIN_URL);
       if (response.getStatusCode() != 200) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
           responseDTO = convertFromJson(response.asString(), LoginResponse.class);
        }else {
            responseDTO = convertFromJson(response.asString(), LoginResponse.class);
        }
        return this;
    }

    @Override
    public Response getApiResponse() {
        return null;
    }

    @Override
    public LoginResponse getResponsePojo() {
        return this.responseDTO;
    }
}
