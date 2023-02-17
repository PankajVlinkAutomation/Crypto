package com.chasmlabs.automation.controller.auth;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.dto.auth.response.CheckEmailResponse;
import com.chasmlabs.automation.dto.auth.response.GetUserDetailsResponseData;
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
public class GetUserDetailsManager extends ApiManager {

    private Response response;
    private GetUserDetailsResponseData responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();
    Map<String, String> pathParams = new HashMap<>();

    //RegistrationManager registrationManager;
    LoginManager loginManager;


    public GetUserDetailsManager( String path) {
        setMethod(MethodType.GET);
        //Create access Token
        loginManager=new LoginManager(path);
        loginManager=loginManager.executeApi();
        var apiResponse = loginManager.getResponsePojo();
        String accessToken=apiResponse.getAccessToken();
        headerList.add(new Header("Authorization","Bearer "+accessToken));

    }

    public GetUserDetailsManager executeApi() {

        response = execute(queryParams, pathParams, headerList, null, ContentType.JSON, GET_USER_DETAILS_URL);
        if (response.getStatusCode() != 200) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responseDTO = convertFromJson(response.asString(), GetUserDetailsResponseData.class);
        }
        return this;
    }

    @Override
    public Response getApiResponse() {
        return this.response;
    }

    @Override
    public GetUserDetailsResponseData getResponsePojo() {
        return this.responseDTO;
    }
}
