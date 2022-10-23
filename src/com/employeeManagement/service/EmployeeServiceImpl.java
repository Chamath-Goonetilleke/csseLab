package com.employeeManagement.service;

import com.employeeManagement.commons.CommonConstants;
import com.employeeManagement.commons.DBConnectionUtil;
import com.employeeManagement.commons.QueryUtil;
import com.employeeManagement.commons.XSLTransformUtil;
import com.employeeManagement.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Map;
import javax.xml.xpath.XPathExpressionException;



public class EmployeeServiceImpl extends AbstractService{

//	Employee List
	private final ArrayList<Employee> employeeList = new ArrayList<Employee>();
//	Logger
	public static final Logger LOG = Logger.getLogger(EmployeeServiceImpl.class.getName());

//	create Connection
	private Connection connection;
//	create Statements
	private Statement statement;
//	Prepared Statement
	private PreparedStatement preparedStatement;


//	get DB connection from DBUril class
	public EmployeeServiceImpl() throws XPathExpressionException, SQLException {

		connection = DBConnectionUtil.getInstance().getConnection();
	}

//	get Employees Details From XML
	@Override
	public void getEmployeesFromXML() throws Exception {
		
		try {
			
			for (Map<String, String> list: XSLTransformUtil.xmlXPath()) {
				
				Employee employee = new Employee();
				employee.setEmployeeId(list.get(CommonConstants.XPATH_EMPLOYEE_ID_KEY));
				employee.setFullName(list.get(CommonConstants.XPATH_EMPLOYEE_NAME_KEY));
				employee.setAddress(list.get(CommonConstants.XPATH_EMPLOYEE_ADDRESS_KEY));
				employee.setFacultyName(list.get(CommonConstants.XPATH_FACULTY_NAME_KEY));
				employee.setDepartment(list.get(CommonConstants.XPATH_DEPARTMENT_KEY));
				employee.setDesignation(list.get(CommonConstants.XPATH_DESIGNATION_KEY));

				employeeList.add(employee);
				LOG.info(employee.toString() + "\n");
				
			}
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
	}

//	create Employee Table
	@Override
	public void createEmployeeTable() throws Exception {
		try {
//			create Statements
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.quary(CommonConstants.DROP_EMP));
			statement.executeUpdate(QueryUtil.quary(CommonConstants.EMP_TABLE_CREATE));
			
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		
	}

//	Add new Employees
	@Override
	public void addEmployee() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(QueryUtil.quary(CommonConstants.INSERT_EMP));
			connection.setAutoCommit(false);
			for (Employee employee : employeeList) {
				preparedStatement.setString(CommonConstants.ONE, employee.getEmployeeId());
				preparedStatement.setString(CommonConstants.TWO, employee.getFullName());
				preparedStatement.setString(CommonConstants.THREE, employee.getAddress());
				preparedStatement.setString(CommonConstants.FOUR, employee.getFacultyName());
				preparedStatement.setString(CommonConstants.FIVE, employee.getDepartment());
				preparedStatement.setString(CommonConstants.SIX, employee.getDesignation());
				preparedStatement.addBatch();
			}
			preparedStatement.executeBatch();
			connection.commit();
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		
	}

//	get Employee Details By Id
	@Override
	public void getEmployeeById(String employeeId) throws Exception {
		Employee employee = new Employee();
		try {
			preparedStatement = connection.prepareStatement(QueryUtil.quary(CommonConstants.GET_EMP_BY_ID));
			preparedStatement.setString(CommonConstants.ONE, employeeId);
			ResultSet R = preparedStatement.executeQuery();
			while (R.next()) {
				employee.setEmployeeId(R.getString(CommonConstants.ONE));
				employee.setFullName(R.getString(CommonConstants.TWO));
				employee.setAddress(R.getString(CommonConstants.THREE));
				employee.setFacultyName(R.getString(CommonConstants.FOUR));
				employee.setDepartment(R.getString(CommonConstants.FIVE));
				employee.setDesignation(R.getString(CommonConstants.SIX));
			}
			ArrayList<Employee> employeeList = new ArrayList<Employee>();
			employeeList.add(employee);
			employeeOutput(employeeList);
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		
	}

//	delete Specific Employee
	@Override
	public void deleteEmployee(String employeeId) {
		try {
			preparedStatement = connection.prepareStatement(QueryUtil.quary(CommonConstants.DELETE_EMP_BY_ID));
			preparedStatement.setString(1, employeeId);
			preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

//	Display all Employees
	@Override
	public void displayEmployee() throws Exception {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement(QueryUtil.quary(CommonConstants.GET_ALL_EMP));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
//				Create Employee Object
				Employee employee = new Employee();
				employee.setEmployeeId(resultSet.getString(CommonConstants.ONE));
				employee.setFullName(resultSet.getString(CommonConstants.TWO));
				employee.setAddress(resultSet.getString(CommonConstants.THREE));
				employee.setFacultyName(resultSet.getString(CommonConstants.FOUR));
				employee.setDepartment(resultSet.getString(CommonConstants.FIVE));
				employee.setDesignation(resultSet.getString(CommonConstants.SIX));
				employeeList.add(employee);
			}
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		employeeOutput(employeeList);
		
	}

//	Display Employee Details
	@Override
	public void employeeOutput(ArrayList<Employee> employeeList) {

		LOG.info("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");

		LOG.info("================================================================================================================");
		for (Employee employee : employeeList) {

			LOG.info(employee.getEmployeeId() + "\t" + employee.getFullName() + "\t\t" + employee.getAddress()
			+ "\t" + employee.getFacultyName() + "\t" + employee.getDepartment() + "\t"
			+ employee.getDesignation() + "\n");
			LOG.info("----------------------------------------------------------------------------------------------------------------");

		}
	}

}
