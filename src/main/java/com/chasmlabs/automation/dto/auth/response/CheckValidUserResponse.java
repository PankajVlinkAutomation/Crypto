package com.chasmlabs.automation.dto.auth.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CheckValidUserResponse {

    @SerializedName("scope")
    @Expose
    private String scope;
}
