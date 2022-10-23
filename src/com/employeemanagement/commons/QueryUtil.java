package com.employeemanagement.commons;


import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


public class QueryUtil extends CommonUtil {

	public static String quary(String id) throws Exception {
		NodeList nodeList;
		Element element = null;
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(new File(CommonConstants.PATH_TO_EMPLOYEE_QUERY_FILE))
				.getElementsByTagName(CommonConstants.QUERY);
		
		for (int x = CommonConstants.ZERO; x < nodeList.getLength(); x++) {
			element = (Element) nodeList.item(x);
			if (element.getAttribute(CommonConstants.ID).equals(id))
				break;
		}
		return element.getTextContent().trim();
	}
}
