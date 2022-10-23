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

	// EmployeeQuery.xml file query identification XML_PATH_PREFIX
	public static final String XML_PATH_PREFIX = "//Employees/Employee";
	// EmployeeQuery.xml file query identification XML_PATH_EMPLOYEEE_ID
	public static final String XML_PATH_EMPLOYEEE_ID = "EmployeeID";
	// EmployeeQuery.xml file query identification XML_PATH_EMPLOYEE_FULL_NAME
	public static final String XML_PATH_EMPLOYEE_FULL_NAME = "EmployeeFullName";
	// EmployeeQuery.xml file query identification XML_PATH_EMPLOYEE_ADDRESS
	public static final String XML_PATH_EMPLOYEE_ADDRESS = "EmployeeFullAddress";
	// EmployeeQuery.xml file query identification XML_PATH_FACULTY_NAME
	public static final String XML_PATH_FACULTY_NAME = "FacultyName";
	// EmployeeQuery.xml file query identification XML_PATH_DEPARTMENT
	public static final String XML_PATH_DEPARTMENT = "Department";
	// EmployeeQuery.xml file query identification XML_PATH_DESIGNATION
	public static final String XML_PATH_DESIGNATION = "Designation";
	// EmployeeQuery.xml file query identification XML_TEXT_METHOD
	public static final String XML_TEXT_METHOD = "text()";
	// EmployeeQuery.xml file query identification BACKSLASH
	public static final String BACKSLASH = "/";
	// EmployeeQuery.xml file query identification LEFT_BRACKET
	public static final String LEFT_BRACKET = "[";
	// EmployeeQuery.xml file query identification RIGHT_BRACKET
	public static final String RIGHT_BRACKET = "]";
	// EmployeeQuery.xml file query identification LEFT_PARANTHESIS
	public static final String LEFT_PARANTHESIS = "(";
	// EmployeeQuery.xml file query identification RIGHT_PARANTHESIS
	public static final String RIGHT_PARANTHESIS = ")";
	// EmployeeQuery.xml file query identification COUNT_METHOD_NAME
	public static final String COUNT_METHOD_NAME = "count";
	// EmployeeQuery.xml file query identification ZERO
	public static final int ZERO = 0;
	// EmployeeQuery.xml file query identification ONE
	public static final int ONE = 1;
	// EmployeeQuery.xml file query identification TWO
	public static final int TWO = 2;
	// EmployeeQuery.xml file query identification THREE
	public static final int THREE = 3;
	// EmployeeQuery.xml file query identification FOUR
	public static final int FOUR = 4;
	// EmployeeQuery.xml file query identification FIVE
	public static final int FIVE = 5;
	// EmployeeQuery.xml file query identification SIX
	public static final int SIX = 6;

}
