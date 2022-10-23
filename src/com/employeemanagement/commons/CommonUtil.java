package com.employeemanagement.commons;


import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;
import java.util.Properties;

public class CommonUtil {

<<<<<<< HEAD:src/com/employeemanagement/commons/c1.java
	//create Properties
	public static final Properties property = new Properties();
	//initialize Logger
	public static final Logger LOG = Logger.getLogger(c1.class.getName());
=======
	public static final Properties p = new Properties();
	public static final Logger LOG = Logger.getLogger(CommonUtil.class.getName());
>>>>>>> 7f07785135313f59ceb3e0e5f3dec17976a1f067:src/com/employeemanagement/commons/CommonUtil.java

	static {
		try {
			property.load(QueryUtil.class.getResourceAsStream(CommonConstants.PATH_TO_CONFIG_PROPERTIES_FILE));
		}catch (NumberFormatException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		catch (IOException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
	}
}
