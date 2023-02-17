
package com.chasmlabs.automation.dto.setting.resquest;

import com.chasmlabs.automation.commons.ApiManager;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateAddressRequest extends ApiManager.requestPojo {

    @SerializedName("user_id")
    @Expose
    public String userId;

    @SerializedName("primary_address_street_1")
    @Expose
    public String primaryAddressStreet1;

    @SerializedName("primary_address_street_2")
    @Expose
    public String primaryAddressStreet2;

    @SerializedName("primary_address_city")
    @Expose
    public String primaryAddressCity;

    @SerializedName("primary_address_state")
    @Expose
    public String primaryAddressState;

    @SerializedName("primary_address_postal_code")
    @Expose
    public String primaryAddressPostalCode;

}
