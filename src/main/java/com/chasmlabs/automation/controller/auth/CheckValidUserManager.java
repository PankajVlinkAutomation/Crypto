package com.chasmlabs.automation.controller.auth;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.commons.BaseApi;
import com.chasmlabs.automation.dto.auth.request.CheckValidUserRequest;
import com.chasmlabs.automation.dto.auth.response.CheckValidUserResponse;
import com.chasmlabs.automation.dto.auth.response.CheckValidUserResponseDTO;
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
public class CheckValidUserManager extends ApiManager {
    private Response response;
    public CheckValidUserRequest requestDTO;
    private CheckValidUserResponseDTO responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();
    Map<String, String> pathParams = new HashMap<>();
    LoginManager loginManager;
    public CheckValidUserManager(String loginPath,String checkValidUserBodyPath){
        String requestData=readJsonFile(checkValidUserBodyPath);
        setMethod(BaseApi.MethodType.POST);
        requestDTO = convertFromJson(requestData, CheckValidUserRequest.class);
        //Create access Token
         loginManager=new LoginManager(loginPath);
        loginManager=loginManager.executeApi();
        var apiResponse=loginManager.getResponsePojo();
        String accessToken=apiResponse.getAccessToken();
        headerList.add(new Header("Authorization","Bearer "+accessToken));
    }

    public CheckValidUserManager executeApi(){

        headerList.add(new Header(CLIENT_ID_HEADER, CLIENT_ID));
        headerList.add(new Header(CLIENT_SECRET_HEADER, CLIENT_SECRET));

        response=execute(queryParams,pathParams,headerList,new Gson().toJson(requestDTO), ContentType.JSON,CHECK_VALID_USER);

        if(response.getStatusCode() !=200){
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }
        else {
            responseDTO=convertFromJson(response.asString(), CheckValidUserResponseDTO.class);


        }
        return this;
    }

    @Override
    public Response getApiResponse() {
        return null;
    }

    @Override
    public CheckValidUserResponseDTO getResponsePojo() {
        return this.responseDTO;
    }
}
