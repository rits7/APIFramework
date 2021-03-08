package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.ResponseValidation.Responsehandling;
import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.LogsCapture;
import org.testing.utilities.PropertiesHandling;
import org.testing.utilities.ResponseParsingUsingOrgJson;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TC3 {
	@Test
	public void testcase3() throws IOException {
		Properties pr = PropertiesHandling.loadProperties("../APIFW/URI.properties");
		HTTPMethods http = new HTTPMethods();
		Response res = http.getAll("QA_URI", pr);
		/*System.out.println("Status code is " + res.statusCode());
		System.out.println("Data is " + res.asString());
		System.out.println("Response time for Testcase 3 is " +res.time());*/
		
		LogsCapture.takeLogs("TC3","================= TESTCASE 3 =====================");
		LogsCapture.takeLogs("TC3","Status code is " + res.statusCode());
		
		ResponseParsingUsingOrgJson.ResponseParsing(res.asString(), "id");
		Responsehandling.responseStatusCode(res, 200);

	}
}
