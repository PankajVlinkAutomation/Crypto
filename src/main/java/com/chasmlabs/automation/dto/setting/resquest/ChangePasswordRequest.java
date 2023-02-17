package com.chasmlabs.automation.dto.setting.resquest;

import com.chasmlabs.automation.commons.ApiManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ChangePasswordRequest extends ApiManager.requestPojo {

    @SerializedName("current_password")
    @Expose
    public String currentPassword;

    @SerializedName("password")
    @Expose
    public String password;

    @SerializedName("password_confirmation")
    @Expose
    public String passwordConfirmation;


}
