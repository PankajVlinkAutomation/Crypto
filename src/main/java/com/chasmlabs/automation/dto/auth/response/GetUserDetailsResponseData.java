package com.chasmlabs.automation.dto.auth.response;

import com.chasmlabs.automation.commons.ApiManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GetUserDetailsResponseData extends ApiManager.responsePojo {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("email_verified_at")
    @Expose
    private String emailVerifiedAt;

    @SerializedName("state")
    @Expose
    private String state;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("user_status")
    @Expose
    private String userStatus;

    @SerializedName("contact_type")
    @Expose
    private String contactType;

    @SerializedName("agree_to_terms")
    @Expose
    private String agreeToTerms;

    @SerializedName("certify_age_acknowledgement")
    @Expose
    private String certifyAgeAcknowledgement;

    @SerializedName("verified")
    @Expose
    private String verified;

    @SerializedName("verified_at")
    @Expose
    private String verifiedAt;

    @SerializedName("verification_token")
    @Expose
    private String verificationToken;

    @SerializedName("two_factor")
    @Expose
    private String twoFactor;

    @SerializedName("two_factor_code")
    @Expose
    private String twoFactorCode;

    @SerializedName("two_factor_expires_at")
    @Expose
    private String twoFactorExpires_at;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("accounts_data")
    @Expose
    private String accountsData;


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
