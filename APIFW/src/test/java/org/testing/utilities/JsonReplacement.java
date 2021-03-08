package org.testing.utilities;
//Step 2 to replace the object id with random id
import java.util.regex.Pattern;

public class JsonReplacement {
	public static String assignValuetoVariable(String bodyData, String varName, String varValue) {
		bodyData=bodyData.replaceAll(Pattern.quote("{{"+varName+"}}"), varValue);
		return bodyData;		
	}
}
