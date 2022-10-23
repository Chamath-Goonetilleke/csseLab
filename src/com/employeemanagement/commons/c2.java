package com.employeemanagement.commons;


import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.TransformerException;
import java.io.File;
import org.xml.sax.SAXException;

import com.employeemanagement.commons.CommonConstants;

import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import javax.xml.transform.TransformerConfigurationException;

public class c2 extends c1 {

	public static String Q(String id) throws Exception {
		NodeList n;
		Element e = null;
		n = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new File(CommonConstants.PATH_TO_EMPLOYEE_QUERY_FILE))
				.getElementsByTagName(CommonConstants.QUERY);
		for (int x = 0; x < n.getLength(); x++) {
			e = (Element) n.item(x);
			if (e.getAttribute(CommonConstants.ID).equals(id))
				break;
		}
		return e.getTextContent().trim();
	}
}
