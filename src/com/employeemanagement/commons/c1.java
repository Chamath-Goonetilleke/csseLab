package com.employeemanagement.commons;


import java.util.logging.Level;
import java.util.logging.Logger;

import com.employeemanagement.commons.CommonConstants;

import java.io.IOException;
import java.util.Properties;

public class c1 {

	public static final Properties p = new Properties();

	static {
		try {
			p.load(c2.class.getResourceAsStream(CommonConstants.PATH_TO_CONFIG_PROPERTIES_FILE));
		} catch (Exception e) {

		}
	}
}
