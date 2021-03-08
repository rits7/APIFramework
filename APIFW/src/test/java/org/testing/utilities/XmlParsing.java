package org.testing.utilities;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlParsing {
	public static void parseXmlFile(String data, String nodeName) throws ParserConfigurationException, SAXException, IOException{
		//data = data.trim().replaceFirst("^([\\W]+)<","<");
		DocumentBuilderFactory db = DocumentBuilderFactory.newInstance();
		DocumentBuilder d = db.newDocumentBuilder();
		Document doc = d.parse(data);
		//Document doc = d.parse(new InputSource(data));
		NodeList nodes = doc.getElementsByTagName("books"); //whatever we want to fetch we can give it here
		for(int i=0;i<nodes.getLength();i++) {
			Node node = nodes.item(i);
			Element element = (Element)node;
			System.out.println(element.getElementsByTagName(data));
		}
		
	}
}
