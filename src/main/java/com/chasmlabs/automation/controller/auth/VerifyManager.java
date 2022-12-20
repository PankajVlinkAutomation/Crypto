package com.chasmlabs.automation.controller.auth;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.dto.auth.response.VerifyResponseDTO;
import com.chasmlabs.automation.dto.auth.response.VerifyResponseData;
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
public class VerifyManager extends ApiManager {

    private Response response;
    private VerifyResponseDTO responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();
    Map<String, String> pathParams = new HashMap<>();

    RegistrationManager registrationManager;


    public VerifyManager(boolean isRegistered, String verifyToken, String path) {
        setMethod(MethodType.GET);

        if (!isRegistered){
            registrationManager = new RegistrationManager(path);
            registrationManager = registrationManager.executeApi();
            var apiResponse = registrationManager.getResponsePojo();
            verifyToken = apiResponse.getData().getVerificationToken();
        }
        pathParams.put(VERIFY_TOKEN,verifyToken);
    }

    public VerifyManager executeApi() {
        headerList.add(new Header(CLIENT_ID_HEADER, CLIENT_ID));
        headerList.add(new Header(CLIENT_SECRET_HEADER, CLIENT_SECRET));

        response = execute(null, pathParams, headerList, null, ContentType.JSON, VERIFY_URL);
        if (response.getStatusCode() != 200) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responseDTO = convertFromJson(response.asString(), VerifyResponseDTO.class);
        }
        return this;
    }

    @Override
    public Response getApiResponse() {
        return this.response;
    }

    @Override
    public VerifyResponseDTO getResponsePojo() {
        return this.responseDTO;
    }
}
