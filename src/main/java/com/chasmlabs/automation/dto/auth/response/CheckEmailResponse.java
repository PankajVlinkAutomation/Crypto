package com.chasmlabs.automation.dto.auth.response;

import com.chasmlabs.automation.commons.ApiManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CheckEmailResponse extends ApiManager.responsePojo {

    @SerializedName("success")
    @Expose
    private String success;

     @SerializedName("status")
     @Expose
     private String status;

     @SerializedName("type")
     @Expose
     private String type;

     @SerializedName("message")
     @Expose
     private Object message;

     @SerializedName("status_code")
     @Expose
     private String status_code;

     @SerializedName("data")
     @Expose
     private String data;

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