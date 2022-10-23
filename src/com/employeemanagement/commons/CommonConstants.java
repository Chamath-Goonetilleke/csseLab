package com.employeemanagement.commons;

public class CommonConstants {

	// Path to config.properties file
	public static final String PATH_TO_CONFIG_PROPERTIES_FILE = "../config/config.properties";

	// Path to Employee-modified.xsl file
	public static final String PATH_TO_EMPLOYEE_MODIFIED_XML_XSL = "src/e/Employee-modified.xsl";

	// Path to EmployeeRequest.xml file
	public static final String PATH_TO_EMPLOYEE_REQUEST_XML_FILE = "src/e/EmployeeRequest.xml";

	// Path to EmployeeQuery.xml file
	public static final String PATH_TO_EMPLOYEE_QUERY_FILE = "src/e/EmployeeQuery.xml";

	// Path to EmployeeResponse.xml file
	public static final String PATH_TO_EMPLOYEE_RESPONSE_XML_FILE = "src/e/EmployeeResponse.xml";

	// MySQL database connector driver class
	public static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

	// Database connection URL in config.properties
	public static final String URL = "URL";

	// Database connection user name in config.properties file
	public static final String USERNAME = "username";

	// Database connection user password in config.properties file
	public static final String PASSWORD = "password";

	// Employee response XML file employee if key
	public static final String XPATH_EMPLOYEE_ID_KEY = "XpathEmployeeIDKey";

	// Employee response XML file employee name key
	public static final String XPATH_EMPLOYEE_NAME_KEY = "XpathEmployeeNameKey";

	// Employee response XML file employee address key
	public static final String XPATH_EMPLOYEE_ADDRESS_KEY = "XpathEmployeeAddressKey";

	// Employee response XML file employee faculty name key
	public static final String XPATH_FACULTY_NAME_KEY = "XpathFacultyNameKey";

	// Employee response XML file employee department key
	public static final String XPATH_DEPARTMENT_KEY = "XpathDepartmentKey";

	// Employee response XML file employee designation key
	public static final String XPATH_DESIGNATION_KEY = "XpathDesignationKey";

	// EmployeeQuery.xml file 'query' tag
	public static final String QUERY = "query";

	// EmployeeQuery.xml file 'id' attribute of 'query' tag
	public static final String ID = "id";

	// EmployeeQuery.xml file query identification q1
	public static final String Q1 = "empTableCreate";

	// EmployeeQuery.xml file query identification q2
	public static final String Q2 = "dropEmp";

	// EmployeeQuery.xml file query identification q3
	public static final String Q3 = "insertEmp";

	// EmployeeQuery.xml file query identification q4
	public static final String Q4 = "getEmpById";

	// EmployeeQuery.xml file query identification q5
	public static final String Q5 = "getAllEmp";

	// EmployeeQuery.xml file query identification q6
	public static final String Q6 = "deleteEmpById";

	// 
	public static final String XML_PATH_PREFIX = "//Employees/Employee";

	public static final String XML_PATH_EMPLOYEEE_ID = "EmployeeID";

	public static final String XML_PATH_EMPLOYEE_FULL_NAME = "EmployeeFullName";

	public static final String XML_PATH_EMPLOYEE_ADDRESS = "EmployeeFullAddress";

	public static final String XML_PATH_FACULTY_NAME = "FacultyName";

	public static final String XML_PATH_DEPARTMENT = "Department";

	public static final String XML_PATH_DESIGNATION = "Designation";

	public static final String XML_TEXT_METHOD = "text()";

	public static final String BACKSLASH = "/";

	public static final String LEFT_BRACKET = "[";

	public static final String RIGHT_BRACKET = "]";

	public static final String LEFT_PARANTHESIS = "(";

	public static final String RIGHT_PARANTHESIS = ")";

	public static final String COUNT_METHOD_NAME = "count";

}
