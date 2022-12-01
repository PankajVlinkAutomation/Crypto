package com.chasmlabs.automation.pojo.requestpojo.account.registration;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Owner {
    @SerializedName("contact-type")
    @Expose
    private String contactType;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("date-of-birth")
    @Expose
    private String dob;

    @SerializedName("tax-id-number")
    @Expose
    private String taxIdNo;

    @SerializedName("tax-country")
    @Expose
    private String taxCountry;

    @SerializedName("ip-address")
    @Expose
    private String ipAddress;

    @SerializedName("geolocation")
    @Expose
    private String geoLocation;

    @SerializedName("primary-phone-number")
    @Expose
    private ContactInfo primaryPhoneNumber;

    @SerializedName("primary-address")
    @Expose
    private Address primaryAddress;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Address {
        @SerializedName("street-1")
        @Expose
        private String street1;

        @SerializedName("street-2")
        @Expose
        private String street2;

        @SerializedName("postal-code")
        @Expose
        private String postalCode;

        @SerializedName("city")
        @Expose
        private String city;

        @SerializedName("region")
        @Expose
        private String region;

        @SerializedName("country")
        @Expose
        private String country;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    private static class ContactInfo {

        @SerializedName("country")
        @Expose
        private String country;

        @SerializedName("number")
        @Expose
        private String number;

        @SerializedName("sms")
        @Expose
        private boolean sms;
    }
}
