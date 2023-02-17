package com.chasmlabs.automation.controller.primetrust;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.controller.auth.LoginManager;
import com.chasmlabs.automation.dto.primetrust.response.GetAccountResponseDto;
import com.chasmlabs.automation.dto.primetrust.response.GetKycStatusResponseDto;
import io.restassured.http.Header;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.chasmlabs.automation.util.Constants.*;

@Slf4j
public class GetKycStatusManager extends ApiManager {

    private Response response;
    private GetKycStatusResponseDto responseDTO;
    private final List<Header> headerList = new ArrayList<>();
    Map<String, String> queryParams = new HashMap<>();
    Map<String, String> pathParams = new HashMap<>();

    public GetKycStatusManager(String loginPath){
        setMethod(MethodType.GET);
        LoginManager loginManager=new LoginManager(loginPath);
        var apiResponse = loginManager.executeApi();
        String accessToken = apiResponse.getResponsePojo().getAccessToken();
        headerList.add(new Header("Authorization","Bearer "+accessToken));
    }
    public GetKycStatusManager executeApi(){
        headerList.add(new Header(CLIENT_ID_HEADER,CLIENT_ID));
        headerList.add(new Header(CLIENT_SECRET_HEADER,CLIENT_SECRET));

        response=execute(queryParams,pathParams,headerList,null, null,GET_KYC_STATUS_PRIME);
        if (response.getStatusCode() != 200) {
            log.error(this.getClass() + "Coupon creation failed ... " + response.prettyPrint());
        }else {
            responseDTO = convertFromJson(response.asString(), GetKycStatusResponseDto.class);
        }
        return this;
    }
    @Override
    public Response getApiResponse() {
        return null;
    }

    @Override
    public GetKycStatusResponseDto getResponsePojo() {
        return this.responseDTO;
    }
}
