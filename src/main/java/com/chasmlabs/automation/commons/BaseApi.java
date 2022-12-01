package com.chasmlabs.automation.commons;

import com.chasmlabs.automation.util.BaseManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseApi extends BaseManager {

	private RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
	private MethodType method;

	public enum MethodType {
		POST, GET, PUT, DELETE, PATCH
	}

	public MethodType getMethod() {
		return method;
	}

	public void setMethod(MethodType method) {
		this.method = method;
	}

	public RequestSpecBuilder getRequestSpecBuilder() {
		return requestSpecBuilder;
	}

	public RequestSpecBuilder getProdRequestSpecBuilder() {
		requestSpecBuilder = new RequestSpecBuilder();
		return requestSpecBuilder;
	}

	public Response execute( Map<String, String> queryParams,
							 List<Header> headers,
							 String body,
							 ContentType contentType,
			                 String url,
							 Map<String, String> formParams) {
		Response response = null;
		switch (method) {
		case POST:
			response = postResponseWithHeaders(body, queryParams, headers, contentType, url, false, formParams);
			break;
		default:
			break;
		}
		return response;
	}

	public Response execute( Map<String, String> queryParams,
							 List<Header> headers,
							 String body,
							 ContentType contentType,
							 String url) {
		Response response = null;
		switch (method) {
		case GET:
			if (headers.isEmpty())
				response = getResponse(queryParams, url, false);
			else
				response = getResponseWithHeaders(queryParams, headers, url, false);
			break;
		case POST:
			if (headers.isEmpty())
				response = postResponse(body, contentType, url, false);
			else
				response = postResponseWithHeaders(body, queryParams, headers, contentType, url, false, null);
			break;
			case PATCH:
				if (headers.isEmpty())
					response = postResponse(body, contentType, url, false);
				else
					response = postResponseWithHeaders(body, queryParams, headers, contentType, url, false, null);
				break;
			case PUT:
				if (headers.isEmpty())
					response = putResponse(body,contentType,url);
				else
					response = putResponseWithHeaders(body,headers,contentType,url,queryParams,false);
		default:
			break;
		}
		return response;
	}

	public Response execute() {
		RequestSpecification requestSpecification = requestSpecBuilder.addFilter(new RequestLoggingFilter())
				.addFilter(new ResponseLoggingFilter()).build();
		Response response;
		RestAssured.defaultParser = Parser.JSON;
		switch (method) {
		case GET:
			response = given().spec(requestSpecification).when().get();
			break;
		case POST:
			response = given().spec(requestSpecification).when().post();
			break;
		case PUT:

			response = given().spec(requestSpecification).when().put();
			break;
		case DELETE:
			response = given().spec(requestSpecification).when().delete();
			break;
		case PATCH:
			response = given().spec(requestSpecification).when().patch();
			break;
		default:
			throw new RuntimeException("API method not specified");

		}
		return response;
	}

	public boolean isJSONValid(String test) {
		try {
			new JSONObject(test);
		} catch (JSONException ex) {
			try {
				new JSONArray(test);
			} catch (JSONException ex1) {
				return false;
			}
		}
		return true;
	}

}
