package org.testing.ResponseValidation;

import org.testing.utilities.ResponseParsingUsingJsonPath;
import org.testng.Assert;

import com.jayway.restassured.response.Response;

public class Responsehandling {
	public static void responseStatusCode(Response res, int expectedStatusCode) {
		int actualStatusCode=res.statusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode, "Status code is not matching so failed");//Hard Assertion(given by testng)
		/*if(actualStatusCode==expectedStatusCode) {
			System.out.println("Status code is matching - Assertion Passed!");
		}
		else {
			System.out.println("Status code is not matching - Assertion Failed!");
		}*/		
	}
	
	public static void responseDataValidate(String expectedData, Response res, String jsonPath) {
		//String actualData=res.jsonPath().get(jsonPath);
		String actualData=ResponseParsingUsingJsonPath.responseParsing(res, jsonPath);
		Assert.assertEquals(actualData, expectedData);
	}
}
