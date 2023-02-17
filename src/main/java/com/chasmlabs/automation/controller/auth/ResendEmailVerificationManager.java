package com.chasmlabs.automation.controller.auth;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.commons.BaseApi;
import com.chasmlabs.automation.dto.auth.request.ResendEmailConfirmationRequest;
import com.chasmlabs.automation.dto.auth.response.GetUserDetailsResponseData;
import com.chasmlabs.automation.dto.auth.response.ResendEmailVerificationResponse;
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
public class ResendEmailVerificationManager extends ApiManager {

    private Response response;
    public ResendEmailConfirmationRequest requestDTO;
    private ResendEmailVerificationResponse responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();
    Map<String, String> pathParams = new HashMap<>();

    public ResendEmailVerificationManager( String path) {
        String requestData = readJsonFile(path);
        setMethod(BaseApi.MethodType.POST);
        requestDTO=convertFromJson(requestData, ResendEmailConfirmationRequest.class);
    }

    public ResendEmailVerificationManager executeApi() {

        headerList.add(new Header(CLIENT_SECRET_HEADER,CLIENT_SECRET));
        headerList.add(new Header(CLIENT_ID_HEADER,CLIENT_ID));
        response = execute(queryParams, pathParams, headerList, new Gson().toJson(requestDTO), ContentType.JSON, RESEND_EMAIL_VERIFICATION);
        if (response.getStatusCode() != 200) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responseDTO = convertFromJson(response.asString(), ResendEmailVerificationResponse.class);
        }
        return this;
    }

    @Override
    public Response getApiResponse() {
        return null;
    }

    @Override
    public ResendEmailVerificationResponse getResponsePojo() {
        return this.responseDTO;
    }
}
