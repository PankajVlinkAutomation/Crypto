package com.chasmlabs.automation.dto.auth.request;

import com.chasmlabs.automation.commons.ApiManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResendEmailConfirmationRequest extends ApiManager.requestPojo {

    @SerializedName("email")
    @Expose
    public String email;

}
