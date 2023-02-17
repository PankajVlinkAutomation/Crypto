package com.chasmlabs.automation.dto.account.request;

import com.chasmlabs.automation.commons.ApiManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class CreateAccountRequest extends ApiManager.requestPojo {
    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("primary_phone_country")
    @Expose
    public String primaryPhoneCountry;

    @SerializedName("tax_country")
    @Expose
    public String taxCountry;

    @SerializedName("primary_address_country")
    @Expose
    public String primaryAddressCountry;

    @SerializedName("primary_phone_sms")
    @Expose
    public String primaryPhoneSms;

    @SerializedName("first_name")
    @Expose
    public String firstName;

    @SerializedName("last_name")
    @Expose
    public String lastName;

    @SerializedName("primary_phone")
    @Expose
    public String primaryPhone;

    @SerializedName("sex")
    @Expose
    public String sex;

    @SerializedName("date_of_birth")
    @Expose
    public String dateOfBirth;

    @SerializedName("taxId_or_ssn")
    @Expose
    public String taxIdOrSsn;

    @SerializedName("tax_id_number")
    @Expose
    public String taxIdNumber;

    @SerializedName("primary_address_street_1")
    @Expose
    public String primaryAddressStreet_1;

    @SerializedName("primary_address_street_2")
    @Expose
    public String primaryAddressStreet_2;

    @SerializedName("primary_address_city")
    @Expose
    public String primaryAddressCity;

    @SerializedName("primary_address_state")
    @Expose
    public String primaryAddressState;

    @SerializedName("primary_address_postal_code")
    @Expose
    public String primaryAddressPostalCode;

    @SerializedName("pt_custodial_agreement")
    @Expose
    public String ptCustodialAgreement;

}
