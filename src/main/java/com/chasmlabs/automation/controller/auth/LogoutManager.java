package com.chasmlabs.automation.controller.auth;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.commons.BaseApi;
import com.chasmlabs.automation.dto.auth.request.LoginRequest;
import com.chasmlabs.automation.dto.auth.request.LogoutRequest;
import com.chasmlabs.automation.dto.auth.response.LogOutResponse;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.chasmlabs.automation.util.Constants.LOGOUT_URL;
@Slf4j
public class LogoutManager extends ApiManager {
    private Response response;
    public LogoutRequest requestDTO;
    private LogOutResponse responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();
    Map<String, String> pathParams = new HashMap<>();

    LoginManager loginManager;
    public LogoutManager(String loginPath,String logoutBodyPath){
        String requestData=readJsonFile(logoutBodyPath);
        setMethod(BaseApi.MethodType.POST);
        requestDTO = convertFromJson(requestData, LogoutRequest.class);
//Create access Token
        loginManager=new LoginManager(loginPath);
        loginManager=loginManager.executeApi();
        var apiResponse = loginManager.getResponsePojo();
        String accessToken=apiResponse.getAccessToken();
        headerList.add(new Header("Authorization","Bearer "+accessToken));

    }
    public LogoutManager executeApi() {

        response = execute(queryParams, pathParams, headerList, null, ContentType.JSON, LOGOUT_URL);
        if (response.getStatusCode() != 200) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responseDTO = convertFromJson(response.asString(), LogOutResponse.class);
        }
        return this;
    }

    @Override
    public Response getApiResponse() {
        return null;
    }

    @Override
    public LogOutResponse getResponsePojo() {
        return this.responseDTO;
    }
}
