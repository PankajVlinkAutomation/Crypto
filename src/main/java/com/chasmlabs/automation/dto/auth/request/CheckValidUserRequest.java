package com.chasmlabs.automation.dto.auth.request;

import com.chasmlabs.automation.commons.ApiManager;
import com.chasmlabs.automation.dto.auth.response.CheckEmailResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CheckValidUserRequest extends ApiManager.requestPojo {

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("password")
    @Expose
    public String password;

}
