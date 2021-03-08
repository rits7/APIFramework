package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//input - Properties path
//activity - it will load the properties file 
//output - it will return the object of properties

public class PropertiesHandling {
	public static Properties loadProperties(String path) throws IOException {
		File f =  new File(path); //establish connection
		FileInputStream fis = new FileInputStream(f);
		Properties pr=new Properties();
		pr.load(fis);
		return pr;	//it will return the properties object
	}
}
