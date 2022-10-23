package com.employeemanagement.commons;


import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

public class QueryUtil extends c1 {

	public static String Q(String id) throws Exception {
		NodeList nodeList;
		Element element = null;
		try {
			nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse(new File(CommonConstants.PATH_TO_EMPLOYEE_QUERY_FILE))
					.getElementsByTagName(CommonConstants.QUERY);
			for (int x = 0; x < nodeList.getLength(); x++) {
				element = (Element) nodeList.item(x);
				if (element.getAttribute(CommonConstants.ID).equals(id))
					break;
			}
		}catch (NumberFormatException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		catch (IOException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		return element.getTextContent().trim();
	}
}
