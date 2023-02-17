package com.chasmlabs.automation.util;


public interface Constants {
//AUth API-
	String VERIFY_URL = "http://20.121.45.110/api/verify_user/{verifyToken}";
	String REGISTRATION_URL = "http://20.121.45.110/api/register";

	String LOGIN_URL = "http://20.121.45.110/api/oauth/token";

	String GET_USER_DETAILS_URL = "http://20.121.45.110/api/admin/user/details";

	String LOGOUT_URL="http://20.121.45.110/api/admin/logout";

	String CHECK_EMAIL = "http://20.121.45.110/api/checkEmail";

	String CHECK_VALID_USER = "http://20.121.45.110/api/checkValidUser";

	String RESEND_EMAIL_VERIFICATION="http://20.121.45.110/api/resendAccountConfirmation";
//SettingAPI
	String CHANGE_PASSWORD = "http://20.121.45.110/api/user/settings/changePassword";

	String CHANGE_EMAIL_REQUEST = "http://20.121.45.110/api/user/settings/changeEmailRequest";
	String CHANGE_PHONE_REQUES = "http://20.121.45.110/api/user/settings/changePhoneRequest";

	String TRANSACTION_LIMIT="http://20.121.45.110/api/user/settings/transactionLimits";
	String UPDATE_ADDRESS="http://20.121.45.110/api/user/settings/updateAddress";
//AccountApI
	String CREATE_ACCOUNT="http://20.121.45.110/api/user/account_data";
//Common API
	String GET_STATE_URL="http://20.121.45.110/api/common/getState";
	String GET_COIN_GECKO_URL="http://20.121.45.110/api/user/common/coinGecko";
	String GET_ASSET_MASTER_URL="http://20.121.45.110/api/user/common/assetMaster";

//Transaction:-
String TRANSACTION_URL="http://20.121.45.110/api/user/transactions";
//PrimeTrust API:-
	String ACCOUNT_CREATE_PRIME="http://20.121.45.110/api/user/primetrust/accountCreate";
	String GET_ACCOUNT_STATUS_PRIME="http://20.121.45.110/api/user/primetrust/accounts";
	String GET_KYC_STATUS_PRIME="http://20.121.45.110/api/user/primetrust/getKycStatus";
	String GET_UPLOAD_DOCUMENT="http://20.121.45.110/api/user/primetrust/getUploadDocuments";
	String GET_CIP_STATUS="http://20.121.45.110/api/user/primetrust/getCipStatus";
	String GET_BALANCE="http://20.121.45.110/api/user/primetrust/getBalance";
	String GET_ACCOUNT_ASSET_TOTALS="http://20.121.45.110/api/user/primetrust/getAccountAssetTotals";
	String GET_REFRENCE_CONTRIBUTION="http://20.121.45.110/api/user/primetrust/getRefrenceContribution";
	String GET_AML_CHECK="http://20.121.45.110/api/user/primetrust/getAmlStatus";
//Header Details:-
	String CLIENT_SECRET_HEADER = "clientsecret";
	String CLIENT_ID_HEADER = "clientid";
	String CLIENT_SECRET = "bgTiN7tBhoZTbLmlZCWxeoXVV0qSkvX5K2thwQNn";
	String CLIENT_ID = "2";
	String REQUEST_SERVER_URL_HEADER = "RequestServer";
	String REQUEST_URL="20.121.41.103";
	String VERIFY_TOKEN = "verifyToken";

	interface ERROR_CODE {
		String CONFIGURATION_PROPERTY = "ERR_CFG_00";
	}

}
