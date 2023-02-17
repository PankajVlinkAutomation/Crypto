package com.chasmlabs.automation.dto.auth.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VerifyResponseData {

    @SerializedName("id")
    @Expose
    public String  id;

    @SerializedName("first_name")
    @Expose
    public String  firstName;

    @SerializedName("last_name")
    @Expose
    public String  lastName;

    @SerializedName("name")
    @Expose
    public String  name;

    @SerializedName("email")
    @Expose
    public String  email;

    @SerializedName("email_verified_at")
    @Expose
    public String  emailVerifiedAt;

    @SerializedName("country")
    @Expose
    public String  country;

    @SerializedName("state")
    @Expose
    public String  state;

    @SerializedName("user_status")
    @Expose
    public String  userStatus;

    @SerializedName("contact_type")
    @Expose
    public String  contactType;

    @SerializedName("agree_to_terms")
    @Expose
    public String  agreeToTerms;

    @SerializedName("updated_at")
    @Expose
    public String  updatedAt;

    @SerializedName("created_at")
    @Expose
    public String  createdAt;

    @SerializedName("two_factor")
    @Expose
    public String  twoFactor;

    @SerializedName("two_factor_code")
    @Expose
    public String  twoFactorCode;

    @SerializedName("two_factor_expires_at")
    @Expose
    public String  twoFactorExpiresAt;

    @SerializedName("certify_age_acknowledgement")
    @Expose
    public String  certifyAgeAcknowledgement;

    @SerializedName("verified")
    @Expose
    public String  verified;

    @SerializedName("verified_at")
    @Expose
    public String  verifiedAt;

    @SerializedName("verification_token")
    @Expose
    public String  verificationToken;
}
