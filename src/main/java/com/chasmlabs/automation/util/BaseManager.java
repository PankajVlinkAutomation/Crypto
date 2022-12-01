package com.chasmlabs.automation.util;

import com.chasmlabs.automation.interfaces.IJsonParser;
import com.google.gson.JsonArray;
import net.minidev.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseManager extends ApiHelper implements IJsonParser {

    /*
     *
     * Implement IJson parser if needed.
     *
     */
    protected final JsonParser _jsonHelper;

    public BaseManager() {
        _jsonHelper = new JsonParser();
    }


    /**
     * This method will fetch map of value's at a particular JSON PATH mentioned in
     * propertyFilePath
     *
     * @param responseJson
     * @param propertyFilePath
     * @return
     */
    public Map<String, String> fieldMapperForASingleJsonObject(String responseJson, String propertyFilePath) {
        String finalExpectedVal = "";
        Map<String, String> masterMappings = fetchAllProperties(propertyFilePath);
        Map<String, String> expectedMap = new HashMap<>();
        for (Map.Entry<String, String> mapperProp : masterMappings.entrySet()) {
            Object expectedVal = _jsonHelper.fetchJPathVal(responseJson, mapperProp.getValue());
            if (expectedVal != null && expectedVal.getClass().isInstance(new JSONArray())) {

                JSONArray jsonArray = (JSONArray) expectedVal;
                finalExpectedVal = jsonArray.get(0) != null ? jsonArray.get(0).toString() : null; // get First Value
                // from List in case
                // of multiple
                // values
            } else
                finalExpectedVal = expectedVal == null ? null : String.valueOf(expectedVal); // incase Of String or null
            // values putting it as
            // it is
            expectedMap.put(mapperProp.getKey(), finalExpectedVal);

        }
        return expectedMap;
    }

    /**
     * Json Parser Methods Implementation
     **/

    @Override
    public <T> T convertFromJson(String jsonData, Class<T> classType) {
        return this._jsonHelper.convertFromJson(jsonData, classType);
    }

    @Override
    public <T> T convertFromJson(String jsonData, Type type) {
        return this._jsonHelper.convertFromJson(jsonData, type);
    }

    @Override
    public <T> List<T> convertFromJsonArray(String jsonArray, Type listType) {
        return this._jsonHelper.convertFromJsonArray(jsonArray, listType);
    }

    @Override
    public Object convertJsonArrayObjToStringObj(Object object) {
        return this._jsonHelper.convertJsonArrayObjToStringObj(object);
    }

    @Override
    public String convertToJson(Object obj) {
        return this._jsonHelper.convertToJson(obj);
    }

    @Override
    public Object fetchJPathVal(String inputJson, String keyName) {
        return this._jsonHelper.fetchJPathVal(inputJson, keyName);
    }

    @Override
    public <T> T fetchJPathVal(String inputJson, String keyName, Class<T> classType) {
        return this._jsonHelper.fetchJPathVal(inputJson, keyName, classType);
    }

    @Override
    public boolean isJsonArrayNotBlank(JsonArray jsonArray) {
        return this._jsonHelper.isJsonArrayNotBlank(jsonArray);
    }

    @Override
    public boolean isJsonObjectInsideJsonObjectNotBlank(JSONObject jsonObject, String field) {
        return this._jsonHelper.isJsonObjectInsideJsonObjectNotBlank(jsonObject, field);
    }

    @Override
    public boolean isListFieldBlank(JSONObject jsonObject, String field) {
        return this._jsonHelper.isListFieldBlank(jsonObject, field);
    }

    @Override
    public boolean isStringFeildNotBlankInsideJSONObject(JSONObject jsonObject, String field) {
        return this._jsonHelper.isListFieldBlank(jsonObject, field);
    }

    @Override
    public org.json.JSONArray objectToJSONArray(Object object) {
        return this._jsonHelper.objectToJSONArray(object);
    }

    @Override
    public Object sortArray(Object unsortedArrayObj) {
        return this._jsonHelper.sortArray(unsortedArrayObj);
    }

}
