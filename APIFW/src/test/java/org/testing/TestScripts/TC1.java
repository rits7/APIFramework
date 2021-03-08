package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.testing.ResponseValidation.Responsehandling;
import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.JsonLoad;
import org.testing.utilities.JsonReplacement;
import org.testing.utilities.LogsCapture;
import org.testing.utilities.PropertiesHandling;
import org.testing.utilities.ResponseParsingUsingJsonPath;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

//	TC1 ------hit the post request
//	before hitting the post request prerequisite is 
//	body data (from jsonLoad file)
//	URI  (URI will be fetched from the properties file)

public class TC1 {
	
	static String responseIdValue;   //to store the extracted id value from response using jsonPath	
	@Test
	public void testcase1() throws IOException { 
		Random r = new Random();
		Integer generatedId = r.nextInt();		
		Properties pr = PropertiesHandling.loadProperties("../APIFW/URI.properties");
		String bodyData = JsonLoad.loadJsonFile("../APIFW/src/test/java/org/testing/Payloads/bodyData.json");
		// 2nd part replace the id value here
		bodyData = JsonReplacement.assignValuetoVariable(bodyData, "id", generatedId.toString());
		HTTPMethods http = new HTTPMethods();
		Response res = http.postRequest(bodyData, "QA_URI", pr);
		
		//No need to use Syso after integrating with Log4j
		/*System.out.println("================= TESTCASE 1 =====================");
		System.out.println("Status code is  " + res.statusCode());
		System.out.println("Data is  " + res.asString());
		System.out.println("Response time for Testcase 1 is " +res.time());*/
		
		//Step 2 API chaining to TC2
		responseIdValue = ResponseParsingUsingJsonPath.responseParsing(res, "id");	
		
		LogsCapture.takeLogs("TC1", "================= TESTCASE 1 =====================");
		LogsCapture.takeLogs("TC1", "Status code is " + res.statusCode());
		
		//Step 3
		Responsehandling.responseStatusCode(res, 201);		
				
	}
}
