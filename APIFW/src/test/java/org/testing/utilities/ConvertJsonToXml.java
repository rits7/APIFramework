package org.testing.utilities;

import org.json.JSONObject;
import org.json.XML;

public class ConvertJsonToXml {
	public String convertToXml(String json) {
		JSONObject ob = new JSONObject(json);
		String xml = XML.toString(ob);
		return xml;
	}
}
