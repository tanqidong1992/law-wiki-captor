package com.tqd.tool.util;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

public class JsonUtils {
	
    private static final Gson gson=new GsonBuilder()
    		.setPrettyPrinting()
    		.create();
	public static String prettyFormat(String json) {
		if(StringUtils.isEmpty(json)) {
			return json;
		}
		JsonElement je=gson.fromJson(json, JsonElement.class);
		return gson.toJson(je);
	}

	public static <T> T parse(String json,Class<T> type){
		return gson.fromJson(json,type);
	}
}
