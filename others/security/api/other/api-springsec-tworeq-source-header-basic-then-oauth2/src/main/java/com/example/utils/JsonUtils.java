package com.example.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.example.jsons.UserJson;

public class JsonUtils {

    public static UserJson getUserJson(String authorization) throws IOException {

		String base64Credentials = authorization.substring("Basic".length()).trim();
    	byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
    	String credentials = new String(credDecoded, StandardCharsets.UTF_8);
    	final String[] credentialsArray = credentials.split(":");

		return new UserJson(credentialsArray[0], credentialsArray[1]);        

    }
    
}
