package com.chasmlabs.automation.dto.primetrust.request;

import com.chasmlabs.automation.commons.ApiManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountCreateRequest extends ApiManager.requestPojo {

    @SerializedName("contact_type")
    @Expose
    public String contactType;

    @SerializedName("natural_person")
    @Expose
    public String naturalPerson;

    @SerializedName("first_name")
    @Expose
    public String firstName;

    @SerializedName("last_name")
    @Expose
    public String lastName;

    @SerializedName("email")
    @Expose
    public String email;

    @SerializedName("date_of_birth")
    @Expose
    public String dateOfBirth;

    @SerializedName("tax_id_number")
    @Expose
    public String taxIdNumber;

    @SerializedName("tax_country")
    @Expose
    public String taxCountry;

    @SerializedName("socure_document_uuid")
    @Expose
    public String socureDocumentUuid;

    @SerializedName("socure_device_id")
    @Expose
    public String socureDeviceId;

    @SerializedName("primary_phone")
    @Expose
    public String primaryPhone;

    @SerializedName("primary_address_street_1")
    @Expose
    public String primaryAddressStreet_1;

    @SerializedName("primary_address_street_2")
    @Expose
    public String primaryAddressStreet_2;

    @SerializedName("primary_address_postal_code")
    @Expose
    public String primaryAddressPostalCode;

    @SerializedName("primary_address_city")
    @Expose
    public String primaryAddressCity;

    @SerializedName("primary_address_state")
    @Expose
    public String primaryAddressState;

    @SerializedName("primary_address_country")
    @Expose
    public String primaryAddressCountry;

    @SerializedName("ip_address")
    @Expose
    public String ipAddress;

}
