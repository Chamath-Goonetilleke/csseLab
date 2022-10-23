package com.employeemanagement.commons;


import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.IOException;
import java.util.Properties;

public class CommonUtil {

	public static final Properties p = new Properties();
	public static final Logger LOG = Logger.getLogger(CommonUtil.class.getName());

	static {
		try {
			p.load(QueryUtil.class.getResourceAsStream(CommonConstants.PATH_TO_CONFIG_PROPERTIES_FILE));
		}catch (NumberFormatException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		catch (IOException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
	}
}
