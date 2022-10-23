
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.employeemanagement.commons.c3;
import com.employeemanagement.service.employeeServiceImpl;

public class MainExecution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		employeeServiceImpl a1 = new employeeServiceImpl();
		try {
			c3.RequestTransform();
			a1.getEmployeesFromXML();
			a1.getEmployeesFromXML();
			a1.addEmployee();
			// employeeService.eMPLOYEEGETBYID("EMP10004");
			// employeeService.EMPLOYEEDELETE("EMP10001");
			a1.displayEmployee();
		} catch (Exception e) {
		}

	}

}
