package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.json.JSONTokener;

//	input ----JSON file path
// 	action ----it will load (read) the JSON file
// 	output ---the content of JSON file
public class JsonLoad {
	public static String loadJsonFile(String path) throws FileNotFoundException {
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		JSONTokener js = new JSONTokener(fis);
		JSONObject data = new JSONObject(js);
		return data.toString();
	}
}
