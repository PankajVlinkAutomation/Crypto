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
public class ChangePhoneRequesRequest extends ApiManager.requestPojo {

    @SerializedName("user_id")
    @Expose
    public String userId;

    @SerializedName("phone")
    @Expose
    public String phone;

    @SerializedName("new_phone")
    @Expose
    public String newPhone;

    @SerializedName("password")
    @Expose
    public String password;


}
