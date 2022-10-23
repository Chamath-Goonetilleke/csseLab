package com.employeemanagement.commons;

public class CommonConstants {

	// Path to config.properties file
	public static final String PATH_TO_CONFIG_PROPERTIES_FILE = "../config/config.properties";

	// Path to Employee-modified.xsl file
	public static final String PATH_TO_EMPLOYEE_MODIFIED_XML_XSL = "src/com/employeemanagement/config/Employee-modified.xsl";

	// Path to EmployeeRequest.xml file
	public static final String PATH_TO_EMPLOYEE_REQUEST_XML_FILE = "src/com/employeemanagement/config/EmployeeRequest.xml";

	// Path to EmployeeQuery.xml file
	public static final String PATH_TO_EMPLOYEE_QUERY_FILE = "src/com/employeemanagement/config/EmployeeQuery.xml";

	// Path to EmployeeResponse.xml file
	public static final String PATH_TO_EMPLOYEE_RESPONSE_XML_FILE = "src/com/employeemanagement/config/EmployeeResponse.xml";

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

	// EmployeeQuery.xml file query identification EMP_TABLE_CREATE
	public static final String EMP_TABLE_CREATE = "empTableCreate";

	// EmployeeQuery.xml file query identification DROP_EMP
	public static final String DROP_EMP = "dropEmp";

	// EmployeeQuery.xml file query identification INSERT_EMP
	public static final String INSERT_EMP = "insertEmp";

	// EmployeeQuery.xml file query identification GET_EMP_BY_ID
	public static final String GET_EMP_BY_ID = "getEmpById";

	// EmployeeQuery.xml file query identification GET_ALL_EMP
	public static final String GET_ALL_EMP = "getAllEmp";

	// EmployeeQuery.xml file query identification DELETE_EMP_BY_ID
	public static final String DELETE_EMP_BY_ID = "deleteEmpById";

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
	
	public static final int ZERO = 0;
	
	public static final int ONE = 1;

}
