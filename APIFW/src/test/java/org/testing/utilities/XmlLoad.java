package org.testing.utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class XmlLoad {
	public static String readXmlData(String path) throws IOException {

		// XmlLoad.LoadXmlFile("../APIFW/src/test/java/org/testing/Payloads/dummy.xml");
		String data = null;
		File f = new File(path);
		FileReader fr = new FileReader(f);
		BufferedReader br = new BufferedReader(fr);
		String s;
		while ((s = br.readLine()) != null) {
			data = data + s;
		}
		//br.close();
		return data;		
	}
	
}
