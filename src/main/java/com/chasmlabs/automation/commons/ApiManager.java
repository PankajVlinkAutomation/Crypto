package com.chasmlabs.automation.commons;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.List;

public abstract class ApiManager extends BaseApi {

	public requestPojo getRequestPojo() {
		return null;
	}


	public abstract static class responsePojo {
		public abstract Object getStatus();
		public abstract int getResponseCode();
		public abstract Object getErrorMessage();
		public abstract Object getErrorMsg();
		public abstract int getErrorCode();
		public String getCode() {
			return null;
		}
		public Object getMessage() {
			return null;
		}
	}

	public Gson getCustomGson(Type type, JsonDeserializer jsonDeserializer) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(type, jsonDeserializer);
		return gsonBuilder.create();
	}

	public abstract Response getApiResponse();

	public abstract static class requestPojo {}

	public abstract static class webResponsePojo {}

	public abstract responsePojo getResponsePojo();

	public responsePojo getCompareResponsePojo() {
		return null;
	}

	public webResponsePojo getWebResponsePojo() {
		return null;
	}

	public webResponsePojo getCompareWebResponsePojo() {
		return null;
	}

	public List<webResponsePojo> getListWebResponsePojo() {
		return null;
	}

	public List<webResponsePojo> getListCompareWebResponsePojo() {
		return null;
	}
}
