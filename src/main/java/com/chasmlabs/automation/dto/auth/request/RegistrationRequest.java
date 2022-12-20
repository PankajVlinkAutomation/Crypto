package com.chasmlabs.automation.dto.auth.request;

import com.chasmlabs.automation.commons.ApiManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class RegistrationRequest extends ApiManager.requestPojo {

    @SerializedName("country")
    @Expose
    public String  country;

    @SerializedName("state")
    @Expose
    public String  state;

    @SerializedName("first_name")
    @Expose
    public String  firstName;

    @SerializedName("last_name")
    @Expose
    public String  lastName;

    @SerializedName("email")
    @Expose
    public String  email;

    @SerializedName("agree_to_terms")
    @Expose
    public String  agreeToTerms;

    @SerializedName("agree_for_age")
    @Expose
    public String  agreeForAge;

    @SerializedName("password")
    @Expose
    public String  password;

    @SerializedName("password_confirmation")
    @Expose
    public String  passwordConfirmation;
}
