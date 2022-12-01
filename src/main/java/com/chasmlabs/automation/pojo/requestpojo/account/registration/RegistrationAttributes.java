package com.chasmlabs.automation.pojo.requestpojo.account.registration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationAttributes {

    @SerializedName("account-type")
    @Expose
    private String accountType;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("authorized-signature")
    @Expose
    public String authorizedSignature;

    @SerializedName("owner")
    @Expose
    private Owner owner;


}
