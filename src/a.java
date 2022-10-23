
import org.xml.sax.SAXException;

import com.employeemanagement.commons.CommonConstants;

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

public class a extends c1 {

	private final ArrayList<Employee> el = new ArrayList<Employee>();

	private static Connection connection;

	private static Statement statement;

	private PreparedStatement preparedStatement;

	public a() {
		try {
			Class.forName(CommonConstants.DRIVER_CLASS);
			connection = DriverManager.getConnection(p.getProperty(CommonConstants.URL), p.getProperty(CommonConstants.USERNAME),
					p.getProperty(CommonConstants.PASSWORD));
		} catch (Exception e) {
		}
	}

	public void getEmployeesFromXML() {

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
				;
				el.add(employee);

				System.out.println(employee.toString() + "\n");
			}
		} catch (Exception e) {
		}
	}

	public void createEmployeeTable() {
		try {
			statement = connection.createStatement();
			statement.executeUpdate(c2.Q(CommonConstants.Q2));
			statement.executeUpdate(c2.Q(CommonConstants.Q1));
		} catch (Exception e) {
		}
	}

	public void addEmployee() {
		try {
			preparedStatement = connection.prepareStatement(c2.Q(CommonConstants.Q3));
			connection.setAutoCommit(false);
			for (int i = 0; i < el.size(); i++) {
				Employee employee = el.get(i);
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
		} catch (Exception e) {
		}
	}

	public void getEmployeeById(String eid) {

		Employee employee = new Employee();
		try {
			preparedStatement = connection.prepareStatement(c2.Q(CommonConstants.Q4));
			preparedStatement.setString(1, eid);
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
		} catch (Exception ex) {
		}
	}

	public void deleteEmployee(String eid) {

		try {
			preparedStatement = connection.prepareStatement(c2.Q(CommonConstants.Q6));
			preparedStatement.setString(1, eid);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void displayEmployee() {

		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		try {
			preparedStatement = connection.prepareStatement(c2.Q(CommonConstants.Q5));
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
		} catch (Exception e) {
		}
		employeeOutput(employeeList);
	}

	public void employeeOutput(ArrayList<Employee> l) {

		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out.println(
				"================================================================================================================");
		for (int i = 0; i < l.size(); i++) {
			Employee e = l.get(i);
			System.out.println(e.getEmployeeId() + "\t" + e.getFullName() + "\t\t" + e.getAddress() + "\t"
					+ e.getFacultyName() + "\t" + e.getDepartment() + "\t" + e.getDesignation() + "\n");
			System.out.println(
					"----------------------------------------------------------------------------------------------------------------");
		}

	}
}
