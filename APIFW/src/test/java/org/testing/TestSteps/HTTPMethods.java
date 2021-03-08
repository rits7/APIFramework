package org.testing.TestSteps;

import static com.jayway.restassured.RestAssured.*;

import java.util.Properties;

import org.testing.utilities.PropertiesHandling;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

// input body data and URI
// output response object
public class HTTPMethods {
	public Response postRequest(String bodyData, String uriKey, Properties pr) {
		Response res =
		given()
		.contentType(ContentType.JSON)
		.body(bodyData)
		.when()
		.post(pr.getProperty(uriKey));		
		return res;
	}
	//Step 2 for get request to fetch one record based on id we get from TC1
	public Response getRequest(String pathParameter, String uriKey, Properties pr) {
		String uri = pr.getProperty(uriKey) +"/"+ pathParameter;		
		
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.when()
				.get(uri);
		return res;
	}
	//get request to get all records
	public Response getAll(String uriKey, Properties pr) {
		Response res =
				given()
				.contentType(ContentType.JSON)
				.when()
				.get(pr.getProperty(uriKey));		
		return res;
	}
	//put request to update the firstname from the id fetched in TC1
	public Response putRequest(String bodyData, String uriKey, String pathParameter, Properties pr) {
		String uri = pr.getProperty(uriKey) +"/"+ pathParameter;		
		
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.body(bodyData)
				.when()
				.put(uri);
		return res;
	}
	
	public Response deleteRequest(String uriKey, String pathParameter, Properties pr) {
		String uri = pr.getProperty(uriKey) +"/"+ pathParameter;		
		
		Response res = 
				given()
				.contentType(ContentType.JSON)
				.when()
				.delete(uri);
		return res;
	}	
	
}
