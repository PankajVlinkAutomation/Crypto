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
public class GetUserDetailsResponseDTO extends ApiManager.responsePojo{

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("success")
    @Expose
    private String success;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("user")
    @Expose
    private GetUserDetailsResponseData user;

    @SerializedName("user_permisions")
    @Expose
    private String userPermisions;

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
