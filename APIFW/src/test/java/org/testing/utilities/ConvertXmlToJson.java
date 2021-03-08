package org.testing.utilities;

import org.json.JSONObject;
import org.json.XML;

public class ConvertXmlToJson {
	public static String convertToJson(String xml) {
		JSONObject ob = XML.toJSONObject(xml);
		return ob.toString();
	}
}
