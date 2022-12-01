package com.chasmlabs.automation.util;


public interface Constants {

	String AUTH_URL = "https://sandbox.primetrust.com/auth/jwts";
	String REGISTRATION_URL = "https://sandbox.primetrust.com/v2/accounts";


	String AUTHORIZATION_HEADER = "Authorization";
	String AUTH_TOKEN = "Basic cHJpbWV0cnVzdGRldkBjYXJvbGluYWNyeXB0by5jb206UHJpbWVUcnVzdDIwMjEh";

	interface ERROR_CODE {
		String CONFIGURATION_PROPERTY = "ERR_CFG_00";
	}

}
