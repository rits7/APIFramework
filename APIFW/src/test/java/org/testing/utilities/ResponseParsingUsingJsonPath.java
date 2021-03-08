package org.testing.utilities;

//step 2 parsing id and passing it to jsonPath 
import com.jayway.restassured.response.Response;

//method will return corresponding value to node which it will take as input
public class ResponseParsingUsingJsonPath {
	public static String responseParsing(Response res, String jsonPath) {
		return res.jsonPath().get(jsonPath);
	}

}
