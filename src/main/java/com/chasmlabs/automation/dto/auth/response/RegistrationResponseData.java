package com.chasmlabs.automation.dto.auth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationResponseData {

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

    @SerializedName("updated_at")
    @Expose
    public String  updatedAt;

    @SerializedName("created_at")
    @Expose
    public String  createdAt;

    @SerializedName("id")
    @Expose
    public String  id;

    @SerializedName("verification_token")
    @Expose
    public String  verificationToken;

}
