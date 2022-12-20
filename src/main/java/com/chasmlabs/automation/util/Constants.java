package com.chasmlabs.automation.util;


public interface Constants {

	String VERIFY_URL = "http://20.121.45.110/api/verify_user/{verifyToken}";
	String REGISTRATION_URL = "http://20.121.45.110/api/register";


	String CLIENT_SECRET_HEADER = "clientsecret";
	String CLIENT_ID_HEADER = "clientid";

	String CLIENT_SECRET = "bgTiN7tBhoZTbLmlZCWxeoXVV0qSkvX5K2thwQNn";
	String CLIENT_ID = "2";

	String VERIFY_TOKEN = "verifyToken";

	interface ERROR_CODE {
		String CONFIGURATION_PROPERTY = "ERR_CFG_00";
	}

}
