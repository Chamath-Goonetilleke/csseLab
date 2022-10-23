

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
import javax.xml.xpath.XPathExpressionException;

public class c3 extends c1 {

	private static final ArrayList<Map<String, String>> l = new ArrayList<Map<String, String>>();

	private static Map<String, String> m = null;
	public static final Logger LOG = Logger.getLogger(c3.class.getName());

	public static void RequestTransform() throws Exception {

		Source employeeRequest = new StreamSource(new File("src/e/EmployeeRequest.xml"));
		Source source = new StreamSource(new File("src/e/Employee-modified.xsl"));
		Result result = new StreamResult(new File("src/e/EmployeeResponse.xml"));
		TransformerFactory.newInstance().newTransformer(source).transform(employeeRequest, result);
	}

	public static ArrayList<Map<String, String>> xmlXPath() throws Exception {

		try {
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.parse("src/e/EmployeeResponse.xml");
			XPath employeeRequest = XPathFactory.newInstance().newXPath();
			int n = Integer.parseInt((String) employeeRequest.compile("count(//Employees/Employee)").evaluate(document, XPathConstants.STRING));
			for (int i = 1; i <= n; i++) {
				m = new HashMap<String, String>();
				m.put("XpathEmployeeIDKey", (String) employeeRequest.compile("//Employees/Employee[" + i + "]/EmployeeID/text()")
						.evaluate(document, XPathConstants.STRING));
				m.put("XpathEmployeeNameKey", (String) employeeRequest.compile("//Employees/Employee[" + i + "]/EmployeeFullName/text()")
						.evaluate(document, XPathConstants.STRING));
				m.put("XpathEmployeeAddressKey",
						(String) employeeRequest.compile("//Employees/Employee[" + i + "]/EmployeeFullAddress/text()").evaluate(document,
								XPathConstants.STRING));
				m.put("XpathFacultyNameKey", (String) employeeRequest.compile("//Employees/Employee[" + i + "]/FacultyName/text()")
						.evaluate(document, XPathConstants.STRING));
				m.put("XpathDepartmentKey", (String) employeeRequest.compile("//Employees/Employee[" + i + "]/Department/text()")
						.evaluate(document, XPathConstants.STRING));
				m.put("XpathDesignationKey", (String) employeeRequest.compile("//Employees/Employee[" + i + "]/Designation/text()")
						.evaluate(document, XPathConstants.STRING));
				l.add(m);
				
			}
		}catch(XPathExpressionException e) {
			LOG.info("");
		}
			
		
		return l;
	}


}
