package com.chasmlabs.automation.dto.account.response;

import com.chasmlabs.automation.commons.ApiManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateAccountResponse extends ApiManager.responsePojo {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("user_id")
    @Expose
    private String userId;

    @SerializedName("id_for_primetrust")
    @Expose
    private String idForPrimetrust;

    @SerializedName("contact_id")
    @Expose
    private String contactId;

    @SerializedName("socure_document_uuid")
    @Expose
    private String socureDocumentUuid;

    @SerializedName("socure_device_id")
    @Expose
    private String socureDeviceId;

    @SerializedName("internal_account_id")
    @Expose
    private String internalAccountId;

    @SerializedName("funds_transfer_method_id")
    @Expose
    private String fundsTransferMethodId;

    @SerializedName("first_name")
    @Expose
    private String firstName;

    @SerializedName("middle_name")
    @Expose
    private String middleName;

    @SerializedName("last_name")
    @Expose
    private String lastName;

    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;

    @SerializedName("sex")
    @Expose
    private String sex;

    @SerializedName("tax_id_number")
    @Expose
    private String taxIdNumber;

    @SerializedName("tax_country")
    @Expose
    private String taxCountry;

    @SerializedName("primary_phone")
    @Expose
    private String primaryPhone;

    @SerializedName("primary_phone_country")
    @Expose
    private String primaryPhoneCountry;

    @SerializedName("primary_phone_sms")
    @Expose
    private String primaryPhoneSms;

    @SerializedName("primary_address_street_1")
    @Expose
    private String primaryAddressStreet_1;

    @SerializedName("primary_address_street_2")
    @Expose
    private String primaryAddressStreet_2;

    @SerializedName("primary_address_city")
    @Expose
    private String primaryAddressCity;

    @SerializedName("primary_address_state")
    @Expose
    private String primaryAddressState;

    @SerializedName("primary_address_postal_code")
    @Expose
    private String primaryAddressPostalCode;

    @SerializedName("primary_address_country")
    @Expose
    private String primaryAddressCountry;

    @SerializedName("kyc_status")
    @Expose
    private String kycStatus;

    @SerializedName("cip_status")
    @Expose
    private String cipStatus;

    @SerializedName("aml_status")
    @Expose
    private String amlStatus;

    @SerializedName("account_status")
    @Expose
    private String accountStatus;

    @SerializedName("institution_name")
    @Expose
    private String institutionName;

    @SerializedName("bank_account_id")
    @Expose
    private String bankAccountId;

    @SerializedName("access_token")
    @Expose
    private String accessToken;

    @SerializedName("contact_type")
    @Expose
    private String contactType;

    @SerializedName("privacy_policy_acknowledgement")
    @Expose
    private String privacyPolicyAcknowledgement;

    @SerializedName("org_id_for_bitwave")
    @Expose
    private String orgIdForBitwave;

    @SerializedName("user_id_for_bitwave")
    @Expose
    private String userIdForBitwave;

    @SerializedName("created_at")
    @Expose
    private String createdAt;

    @SerializedName("updated_at")
    @Expose
    private String updatedAt;

    @SerializedName("deleted_at")
    @Expose
    private String deletedAt;

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
