package com.chasmlabs.automation.pojo.responsepojo.auth.registration;

import com.chasmlabs.automation.pojo.requestpojo.account.registration.RegistrationAttributes;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationResponseData {
    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("attributes")
    @Expose
    private RegistrationResponseAttributes attributes;

    @SerializedName("links")
    @Expose
    private Object links;

    @SerializedName("relationships")
    @Expose
    private Object relationships;
}
