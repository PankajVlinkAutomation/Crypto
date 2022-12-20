package com.chasmlabs.automation.controller.auth;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.commons.BaseApi;
import com.chasmlabs.automation.dto.auth.request.RegistrationRequest;
import com.chasmlabs.automation.dto.auth.response.RegistrationResponse;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.chasmlabs.automation.util.Constants.*;

@Slf4j
public class RegistrationManager extends ApiManager {

    private Response response;
    private RegistrationRequest requestDTO;
    private RegistrationResponse responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();
    public RegistrationManager(String path) {
        String requestData = readJsonFile(path);
        setMethod(BaseApi.MethodType.POST);
        requestDTO = convertFromJson(requestData, RegistrationRequest.class);

        /* To change email address */
        String email = requestDTO.getEmail();
        String[] elements = email.split("\\+"); //nktkmr27+007@gmail.com
        String newEmail = elements[0] + "+" + RandomUtils.nextInt() + elements[1];
        requestDTO.setEmail(newEmail);
    }

    public RegistrationManager executeApi() {
        headerList.add(new Header(CLIENT_ID_HEADER, CLIENT_ID));
        headerList.add(new Header(CLIENT_SECRET_HEADER, CLIENT_SECRET));

        response = execute( queryParams, null, headerList, new Gson().toJson(requestDTO), ContentType.JSON, REGISTRATION_URL);
        if (response.getStatusCode() != 200) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responseDTO = convertFromJson(response.asString(), RegistrationResponse.class);
        }
        return this;
    }



    @Override
    public Response getApiResponse() {
        return this.response;
    }

    @Override
    public RegistrationResponse getResponsePojo() {
        return this.responseDTO;
    }
}
