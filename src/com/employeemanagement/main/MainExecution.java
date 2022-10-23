package com.employeemanagement.main;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
	 * @throws Exception 
	 * @throws SQLException
	 * @throws XPathExpressionException
	 */
	public static void main(String[] args) throws Exception {
		EmployeeServiceImpl a1;
		final Logger LOG = Logger.getLogger(EmployeeServiceImpl.class.getName());
		try {
			a1 = new EmployeeServiceImpl();
			c3.RequestTransform();
			a1.getEmployeesFromXML();
			a1.getEmployeesFromXML();
			a1.addEmployee();
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			LOG.log(Level.SEVERE, e.getMessage());
		}
	}

}
