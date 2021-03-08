package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.ResponseValidation.Responsehandling;
import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.LogsCapture;
import org.testing.utilities.PropertiesHandling;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TC5 {
	@Test
	public void testcase5() throws IOException {
		Properties pr = PropertiesHandling.loadProperties("../APIFW/URI.properties");
		HTTPMethods http = new HTTPMethods();
		Response res = http.deleteRequest( "QA_URI", TC1.responseIdValue, pr);
		/*System.out.println("================TestCase5=================");
		System.out.println("Status code is  " + res.statusCode());*/
		
		LogsCapture.takeLogs("TC5", "================ TESTCASE 5 =======================");
		LogsCapture.takeLogs("TC5", "Status code is " + res.statusCode());
		
		Responsehandling.responseStatusCode(res, 200);
				
	}
}
