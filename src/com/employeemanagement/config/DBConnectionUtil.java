package com.employeemanagement.config;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.employeemanagement.commons.CommonConstants;
import com.employeemanagement.service.EmployeeServiceImpl;

public class DBConnectionUtil {
	
	public static final Logger LOG = Logger.getLogger(EmployeeServiceImpl.class.getName());
	public static final Properties p = new Properties();

	DBConnectionUtil(){
		try {
			Class.forName(CommonConstants.DRIVER_CLASS);
			DriverManager.getConnection(p.getProperty(CommonConstants.URL),
					p.getProperty(CommonConstants.USERNAME), p.getProperty(CommonConstants.PASSWORD));
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
	}
	

}
