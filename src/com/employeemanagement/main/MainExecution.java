package com.employeemanagement.main;


import java.sql.SQLException;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import com.employeemanagement.commons.c3;
import com.employeemanagement.service.EmployeeServiceImpl;

public class MainExecution {

	/**
	 * @param args
	 * @throws SQLException 
	 * @throws XPathExpressionException 
	 */
	public static void main(String[] args) throws XPathExpressionException, SQLException {

		EmployeeServiceImpl a1 = new EmployeeServiceImpl();
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
