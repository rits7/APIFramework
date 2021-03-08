package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.ResponseValidation.Responsehandling;
import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.LogsCapture;
import org.testing.utilities.PropertiesHandling;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

//Get Request
public class TC2 {
	@Test
	public void testcase2() throws IOException {
		Properties pr = PropertiesHandling.loadProperties("../APIFW/URI.properties");
		String idValue = TC1.responseIdValue;
		HTTPMethods http = new HTTPMethods();
		Response res = http.getRequest(idValue, "QA_URI", pr);
		/*System.out.println("Status code is " + res.statusCode());
		System.out.println("Data is " + res.asString());
		System.out.println("Response time for Testcase 2 is " +res.time());*/
		LogsCapture.takeLogs("TC2","================= TESTCASE 2 =====================");
		LogsCapture.takeLogs("TC2","Status code is " + res.statusCode());
		
		Responsehandling.responseStatusCode(res, 200);
		Responsehandling.responseDataValidate("Jane", res, "firstname");
	}
}
