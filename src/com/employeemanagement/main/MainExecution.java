package com.employeemanagement.main;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.xpath.XPathExpressionException;

import com.employeemanagement.commons.XSLTransformUtil;
import com.employeemanagement.service.EmployeeServiceImpl;

public class MainExecution {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws SQLException
	 * @throws XPathExpressionException
	 */
	public static final Logger LOG = Logger.getLogger(MainExecution.class.getName());

	public static void main(String[] args) throws Exception {
		
		EmployeeServiceImpl employee;
		try {
			employee = new EmployeeServiceImpl();
			XSLTransformUtil.RequestTransform();
			employee.getEmployeesFromXML();
			employee.getEmployeesFromXML();
			employee.addEmployee();
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (XPathExpressionException e) {
		}
	}

}
