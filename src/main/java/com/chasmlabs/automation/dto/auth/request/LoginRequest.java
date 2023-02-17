package com.chasmlabs.automation.dto.auth.request;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.dto.auth.response.CheckEmailResponse;
import com.chasmlabs.automation.util.ApiHelper;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginRequest extends ApiManager.requestPojo {
    @SerializedName("username")
    @Expose
    public String  userName;

    @SerializedName("password")
    @Expose
    public String  password;

    @SerializedName("client_id")
    @Expose
    public String  clientId;

    @SerializedName("client_secret")
    @Expose
    public String clientSecret;

    @SerializedName("grant_type")
    @Expose
    public String grantType;

    @SerializedName("scope")
    @Expose
    public String scope;

}
