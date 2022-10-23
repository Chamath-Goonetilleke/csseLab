package com.employeemanagement.commons;


import javax.xml.xpath.XPathFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.w3c.dom.Document;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.TransformerFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;

public class XSLTransformUtil extends c1 {

//	create Transform List
    private static final ArrayList<Map<String, String>> transformList = new ArrayList<Map<String, String>>();

    //declare map
    private static Map<String, String> empMap = null;
    public static final Logger LOG = Logger.getLogger(XSLTransformUtil.class.getName());

//    Request Transform static method
    public static void RequestTransform() throws Exception {
        Source employeeRequest = new StreamSource(new File(CommonConstants.PATH_TO_EMPLOYEE_REQUEST_XML_FILE));
        Source source = new StreamSource(new File(CommonConstants.PATH_TO_EMPLOYEE_MODIFIED_XML_XSL));
        Result result = new StreamResult(new File(CommonConstants.PATH_TO_EMPLOYEE_RESPONSE_XML_FILE));
        TransformerFactory.newInstance().newTransformer(source).transform(employeeRequest, result);
    }

//    XML XPath static methods
    public static ArrayList<Map<String, String>> xmlXPath() throws Exception {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
                .parse(CommonConstants.PATH_TO_EMPLOYEE_RESPONSE_XML_FILE);

        XPath employeeRequest = XPathFactory.newInstance().newXPath();

        int n = Integer.parseInt((String) employeeRequest
                .compile(CommonConstants.COUNT_METHOD_NAME + CommonConstants.LEFT_PARANTHESIS
                        + CommonConstants.XML_PATH_PREFIX + CommonConstants.RIGHT_PARANTHESIS)
                .evaluate(document, XPathConstants.STRING));

        for (int i = CommonConstants.ONE; i <= n; i++) {
        	empMap = new HashMap<String, String>();
        	empMap.put(CommonConstants.XPATH_EMPLOYEE_ID_KEY,
                    (String) employeeRequest.compile(CommonConstants.XML_PATH_PREFIX + CommonConstants.LEFT_BRACKET + i
                            + CommonConstants.RIGHT_BRACKET + CommonConstants.BACKSLASH
                            + CommonConstants.XML_PATH_EMPLOYEEE_ID + CommonConstants.BACKSLASH
                            + CommonConstants.XML_TEXT_METHOD).evaluate(document, XPathConstants.STRING));
        	empMap.put(CommonConstants.XPATH_EMPLOYEE_NAME_KEY,
                    (String) employeeRequest.compile(CommonConstants.XML_PATH_PREFIX + CommonConstants.LEFT_BRACKET + i
                            + CommonConstants.RIGHT_BRACKET + CommonConstants.BACKSLASH
                            + CommonConstants.XML_PATH_EMPLOYEE_FULL_NAME + CommonConstants.BACKSLASH
                            + CommonConstants.XML_TEXT_METHOD).evaluate(document, XPathConstants.STRING));
        	empMap.put(CommonConstants.XPATH_EMPLOYEE_ADDRESS_KEY,
                    (String) employeeRequest.compile(CommonConstants.XML_PATH_PREFIX + CommonConstants.LEFT_BRACKET + i
                            + CommonConstants.RIGHT_BRACKET + CommonConstants.BACKSLASH
                            + CommonConstants.XML_PATH_EMPLOYEE_ADDRESS + CommonConstants.BACKSLASH
                            + CommonConstants.XML_TEXT_METHOD).evaluate(document, XPathConstants.STRING));
        	empMap.put(CommonConstants.XPATH_FACULTY_NAME_KEY,
                    (String) employeeRequest.compile(CommonConstants.XML_PATH_PREFIX + CommonConstants.LEFT_BRACKET + i
                            + CommonConstants.RIGHT_BRACKET + CommonConstants.BACKSLASH
                            + CommonConstants.XML_PATH_FACULTY_NAME + CommonConstants.BACKSLASH
                            + CommonConstants.XML_TEXT_METHOD).evaluate(document, XPathConstants.STRING));
        	empMap.put(CommonConstants.XPATH_DEPARTMENT_KEY,
                    (String) employeeRequest.compile(CommonConstants.XML_PATH_PREFIX + CommonConstants.LEFT_BRACKET + i
                            + CommonConstants.RIGHT_BRACKET + CommonConstants.BACKSLASH
                            + CommonConstants.XML_PATH_DEPARTMENT + CommonConstants.BACKSLASH
                            + CommonConstants.XML_TEXT_METHOD).evaluate(document, XPathConstants.STRING));
        	empMap.put(CommonConstants.XPATH_DESIGNATION_KEY,
                    (String) employeeRequest.compile(CommonConstants.XML_PATH_PREFIX + CommonConstants.LEFT_BRACKET + i
                            + CommonConstants.RIGHT_BRACKET + CommonConstants.BACKSLASH
                            + CommonConstants.XML_PATH_DESIGNATION + CommonConstants.BACKSLASH
                            + CommonConstants.XML_TEXT_METHOD).evaluate(document, XPathConstants.STRING));
            transformList.add(empMap);
        }

        return transformList;
    }

}
