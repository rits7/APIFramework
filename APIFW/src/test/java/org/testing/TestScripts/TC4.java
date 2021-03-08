package org.testing.TestScripts;

import java.io.IOException;
import java.util.Properties;
import org.apache.commons.lang3.RandomStringUtils;
import org.testing.ResponseValidation.Responsehandling;
import org.testing.TestSteps.HTTPMethods;
import org.testing.utilities.JsonLoad;
import org.testing.utilities.JsonReplacement;
import org.testing.utilities.LogsCapture;
import org.testing.utilities.PropertiesHandling;
import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class TC4 {
	@Test
	public void testcase4() throws IOException {
		
		String generatedString = RandomStringUtils.randomAlphabetic(10);   
		Properties pr = PropertiesHandling.loadProperties("../APIFW/URI.properties");
		String bodyData = JsonLoad.loadJsonFile("../APIFW/src/test/java/org/testing/Payloads/bodyDataForUpdateRequest.json");
		bodyData = JsonReplacement.assignValuetoVariable(bodyData, "id", TC1.responseIdValue);
		bodyData = JsonReplacement.assignValuetoVariable(bodyData, "firstname", generatedString);
		HTTPMethods http = new HTTPMethods();
		Response res = http.putRequest(bodyData, "QA_URI", TC1.responseIdValue, pr);
		/*
		 * System.out.println("=================TESTCASE 4=====================");
		 * System.out.println("Status code is  "+ res.statusCode());
		 * System.out.println("Data is  " + res.asString());
		 * System.out.println("response time is  " + res.time());
		 */
		LogsCapture.takeLogs("TC4", "================= TESTCASE 4 =====================");
		LogsCapture.takeLogs("TC4", "Status code is " + res.statusCode());
		
		Responsehandling.responseStatusCode(res, 200);
		Responsehandling.responseDataValidate(generatedString, res, "firstname");
		
		
		
	}
}
