package com.chasmlabs.automation.pojo.responsepojo.auth.registration;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegistrationResponseAttributes {

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("number")
    @Expose
    private String number;

    @SerializedName("created-at")
    @Expose
    private String createdAt;

    @SerializedName("updated-at")
    @Expose
    private String updatedAt;


    @SerializedName("contributions-frozen")
    @Expose
    private String contributionsFrozen;

    @SerializedName("disbursements-frozen")
    @Expose
    private String disbursementsFrozen;

    @SerializedName("organization-label")
    @Expose
    private String organizationLabel;

    @SerializedName("statements")
    @Expose
    private String statements;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("solid-freeze")
    @Expose
    private String solidFreeze;

    @SerializedName("freeze-required-actions")
    @Expose
    private Object freezeRequiredActions;

    @SerializedName("freeze-not-required-actions")
    @Expose
    private Object freezeNotRequiredActions;

    @SerializedName("uploaded-document-ids")
    @Expose
    private Object uploadedDocumentIds;

}
