package com.chasmlabs.automation.controller.auth;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.commons.BaseApi;
import com.chasmlabs.automation.pojo.responsepojo.auth.authentication.TokenResponse;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

import static com.chasmlabs.automation.util.Constants.*;

@Slf4j
public class TokenManager extends ApiManager {

    private Response response;
    private TokenResponse responsepojo;
    private final List<Header> headerList = new ArrayList<>();;


    public TokenManager() {
        setMethod(MethodType.POST);
        headerList.add(new Header( AUTHORIZATION_HEADER, AUTH_TOKEN));
    }

    public TokenManager executeApi() {
        response = execute(null, null,headerList, null, ContentType.JSON, AUTH_URL);
        if (response.getStatusCode() != 201) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responsepojo = convertFromJson(response.asString(), TokenResponse.class);
        }
        return this;
    }

    @Override
    public Response getApiResponse() {
        return this.response;
    }

    @Override
    public TokenResponse getResponsePojo() {
        return this.responsepojo;
    }
}
