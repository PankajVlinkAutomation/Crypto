package com.chasmlabs.automation.pojo.requestpojo.account.registration;

import com.chasmlabs.automation.commons.ApiManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class RegistrationRequest extends ApiManager.requestPojo {

    @SerializedName("data")
    @Expose
    public RegistrationData data;
}
