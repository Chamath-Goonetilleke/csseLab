package com.employeemanagement.main;

import java.sql.SQLException;

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
	public static void main(String[] args) {
		EmployeeServiceImpl a1;
		try {
			a1 = new EmployeeServiceImpl();
			c3.RequestTransform();
			a1.getEmployeesFromXML();
			a1.getEmployeesFromXML();
			a1.addEmployee();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
