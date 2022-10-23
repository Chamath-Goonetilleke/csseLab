package com.employeeManagement.commons;

import com.employeeManagement.service.EmployeeServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Properties;

public class DBConnectionUtil {
	
	private static DBConnectionUtil dbIsntance;

	public static final Logger LOG = Logger.getLogger(EmployeeServiceImpl.class.getName());
	public static final Properties properties = new Properties();
	private static Connection con;
	public DBConnectionUtil() {

	}

	public static DBConnectionUtil getInstance(){
	    if(dbIsntance==null){
	        dbIsntance= new DBConnectionUtil();
	    }
	    return dbIsntance;
	    }

	
//	create get connection with DB
	public Connection getConnection(){
		if(con == null) {
			try {
				Class.forName(CommonConstants.DRIVER_CLASS); //get Driver class
				con = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
						properties.getProperty(CommonConstants.USERNAME), properties.getProperty(CommonConstants.PASSWORD));
			} catch (ClassNotFoundException e) {
				LOG.log(Level.SEVERE, e.getMessage());
			} catch (SQLException e) {
				LOG.log(Level.SEVERE, e.getMessage());
			}
		}
		return con;
	}
	

}
