package com.chasmlabs.automation.dto.setting.resquest;

import com.chasmlabs.automation.commons.ApiManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChangeEmailRequestRequest extends ApiManager.requestPojo {

    @SerializedName("user_id")
    @Expose
    public String userId;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("new_email")
    @Expose
    public String newEmail;

    @SerializedName("password")
    @Expose
    public String password;

}
