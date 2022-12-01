package com.chasmlabs.automation.pojo.responsepojo.auth.registration;

import com.chasmlabs.automation.commons.ApiManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationResponse extends ApiManager.responsePojo{
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("responseCode")
    @Expose
    private Integer responseCode;
    @SerializedName("data")
    @Expose
    private RegistrationResponseData data;

    @SerializedName("includes")
    @Expose
    private Object includes;

    @Override
    public Object getStatus() {
        return null;
    }

    @Override
    public int getResponseCode() {
        return 0;
    }

    @Override
    public Object getErrorMessage() {
        return null;
    }

    @Override
    public Object getErrorMsg() {
        return null;
    }

    @Override
    public int getErrorCode() {
        return 0;
    }


}
