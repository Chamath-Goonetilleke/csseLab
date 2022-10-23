package com.employeeManagement.main;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xpath.XPathExpressionException;

import com.employeeManagement.commons.XSLTransformUtil;
import com.employeeManagement.service.EmployeeServiceImpl;

public class MainExecution {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws SQLException
	 * @throws XPathExpressionException
	 */
	public static final Logger LOG = Logger.getLogger(MainExecution.class.getName());

	public static void main(String[] args) throws Exception {
		
//		declare Employee Service Implementation object
		EmployeeServiceImpl employee;
		
		try {
			employee = new EmployeeServiceImpl();
			XSLTransformUtil.RequestTransform();
//			get Employee Details
			employee.getEmployeesFromXML();
//			insert new Employee
			employee.addEmployee();
			
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (XPathExpressionException e) {
		}
	}

}
