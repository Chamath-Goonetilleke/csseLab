package com.employeemanagement.service;

import org.xml.sax.SAXException;

import com.employeemanagement.commons.CommonConstants;
import com.employeemanagement.commons.QueryUtil;
import com.employeemanagement.commons.c1;
import com.employeemanagement.commons.c3;
import com.employeemanagement.model.Employee;

import java.sql.Connection;
import java.util.logging.Logger;
import java.sql.DriverManager;
import javax.xml.parsers.ParserConfigurationException;
import java.sql.PreparedStatement;
import javax.xml.xpath.XPathExpressionException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.sql.Statement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class EmployeeServiceImpl extends AbstractService{

	private final ArrayList<Employee> el = new ArrayList<Employee>();
	public static final Logger LOG = Logger.getLogger(EmployeeServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	private PreparedStatement preparedStatement;

	public EmployeeServiceImpl() throws XPathExpressionException, SQLException {
		try {
			Class.forName(CommonConstants.DRIVER_CLASS);
			connection = DriverManager.getConnection(p.getProperty(CommonConstants.URL),
					p.getProperty(CommonConstants.USERNAME), p.getProperty(CommonConstants.PASSWORD));
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void getEmployeesFromXML() throws Exception {
		try {
			int s = c3.xmlXPath().size();
			for (int i = 0; i < s; i++) {
				Map<String, String> l = c3.xmlXPath().get(i);
				Employee employee = new Employee();
				employee.setEmployeeId(l.get(CommonConstants.XPATH_EMPLOYEE_ID_KEY));
				employee.setFullName(l.get(CommonConstants.XPATH_EMPLOYEE_NAME_KEY));
				employee.setAddress(l.get(CommonConstants.XPATH_EMPLOYEE_ADDRESS_KEY));
				employee.setFacultyName(l.get(CommonConstants.XPATH_FACULTY_NAME_KEY));
				employee.setDepartment(l.get(CommonConstants.XPATH_DEPARTMENT_KEY));
				employee.setDesignation(l.get(CommonConstants.XPATH_DESIGNATION_KEY));

				el.add(employee);
				System.out.println(employee.toString() + "\n");
			}
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void createEmployeeTable() throws Exception {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(QueryUtil.Q(CommonConstants.DROP_EMP));
			statement.executeUpdate(QueryUtil.Q(CommonConstants.EMP_TABLE_CREATE));
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		
	}

	@Override
	public void addEmployee() throws Exception {
		try {
			preparedStatement = connection.prepareStatement(QueryUtil.Q(CommonConstants.INSERT_EMP));
			connection.setAutoCommit(false);
			for (Employee employee : el) {
				preparedStatement.setString(1, employee.getEmployeeId());
				preparedStatement.setString(2, employee.getFullName());
				preparedStatement.setString(3, employee.getAddress());
				preparedStatement.setString(4, employee.getFacultyName());
				preparedStatement.setString(5, employee.getDepartment());
				preparedStatement.setString(6, employee.getDesignation());
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

	@Override
	public void getEmployeeById(String employeeId) throws Exception {
		Employee employee = new Employee();
		try {
			preparedStatement = connection.prepareStatement(QueryUtil.Q(CommonConstants.GET_EMP_BY_ID));
			preparedStatement.setString(1, employeeId);
			ResultSet R = preparedStatement.executeQuery();
			while (R.next()) {
				employee.setEmployeeId(R.getString(1));
				employee.setFullName(R.getString(2));
				employee.setAddress(R.getString(3));
				employee.setFacultyName(R.getString(4));
				employee.setDepartment(R.getString(5));
				employee.setDesignation(R.getString(6));
			}
			ArrayList<Employee> l = new ArrayList<Employee>();
			l.add(employee);
			employeeOutput(l);
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		
	}

	@Override
	public void deleteEmployee(String employeeId) {
		try {
			preparedStatement = connection.prepareStatement(QueryUtil.Q(CommonConstants.DELETE_EMP_BY_ID));
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

	@Override
	public void displayEmployee() throws Exception {
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement(QueryUtil.Q(CommonConstants.GET_ALL_EMP));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(resultSet.getString(1));
				employee.setFullName(resultSet.getString(2));
				employee.setAddress(resultSet.getString(3));
				employee.setFacultyName(resultSet.getString(4));
				employee.setDepartment(resultSet.getString(5));
				employee.setDesignation(resultSet.getString(6));
				employeeList.add(employee);
			}
		} catch (ClassNotFoundException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		} catch (SQLException e) {
			LOG.log(Level.SEVERE, e.getMessage());
		}
		employeeOutput(employeeList);
		
	}

	@Override
	public void employeeOutput(ArrayList<Employee> l) {
		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out.println(
				"================================================================================================================");
		for (Employee employee : l) {
			System.out.println(employee.getEmployeeId() + "\t" + employee.getFullName() + "\t\t" + employee.getAddress()
					+ "\t" + employee.getFacultyName() + "\t" + employee.getDepartment() + "\t"
					+ employee.getDesignation() + "\n");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------");
		}
	}

}
