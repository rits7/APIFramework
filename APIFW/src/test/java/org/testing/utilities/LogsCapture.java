package org.testing.utilities;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LogsCapture {
	public static void takeLogs(String className, String logMsg) {
		DOMConfigurator.configure("../APIFW/layout.xml");
		Logger l = Logger.getLogger(className);
		l.info(logMsg);
	}
}
