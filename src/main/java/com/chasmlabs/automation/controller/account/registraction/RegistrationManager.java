package com.chasmlabs.automation.controller.account.registraction;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.commons.BaseApi;
import com.chasmlabs.automation.controller.auth.TokenManager;
import com.chasmlabs.automation.pojo.requestpojo.account.registration.RegistrationRequest;
import com.chasmlabs.automation.pojo.responsepojo.auth.registration.RegistrationResponse;
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
public class RegistrationManager extends ApiManager {

    private Response response;
    private RegistrationRequest requestPojo;
    private RegistrationResponse responsepojo;
    private final List<Header> headerList = new ArrayList<>();
    private String request;
    private String token;
    Map<String, String> queryParams = new HashMap<>();

    public RegistrationManager(String path) {
        String requestData = readJsonFile(path);
        setMethod(BaseApi.MethodType.POST);
        TokenManager tokenManager = new TokenManager();
        var tokenRes = tokenManager.executeApi();
        token = tokenRes.getResponsePojo().getToken();
        queryParams.put("include", "contacts");
        requestPojo = convertFromJson(requestData, RegistrationRequest.class);
    }

    public RegistrationManager executeApi() {
        headerList.add(new Header(AUTHORIZATION_HEADER, "Bearer " + token));
        response = execute( queryParams, null, headerList, new Gson().toJson(requestPojo), ContentType.JSON, REGISTRATION_URL);
        if (response.getStatusCode() != 201) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responsepojo = convertFromJson(response.asString(), RegistrationResponse.class);
        }
        return this;
    }



    @Override
    public Response getApiResponse() {
        return this.response;
    }

    @Override
    public RegistrationResponse getResponsePojo() {
        return this.responsepojo;
    }
}
