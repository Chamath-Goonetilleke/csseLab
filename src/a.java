

import org.xml.sax.SAXException;
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

	private static Connection c;

	private static Statement s;

	private PreparedStatement ps;

	public a() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),
					p.getProperty("password"));
		} catch (Exception e) {
		} 
	}

	public void a2() {

		try {
			int s = c3.XMLXPATHS().size();
			for (int i = 0; i < s; i++) {
				Map<String, String> l = c3.XMLXPATHS().get(i);
				Employee employee = new Employee();
				employee.setEmployeeId(l.get("XpathEmployeeIDKey"));
				employee.setFullName(l.get("XpathEmployeeNameKey"));
				employee.setAddress(l.get("XpathEmployeeAddressKey"));
				employee.setFacultyName(l.get("XpathFacultyNameKey"));
				employee.setDepartment(l.get("XpathDepartmentKey"));
				employee.setDesignation(l.get("XpathDesignationKey"));;
				el.add(employee);
				
				System.out.println(employee.toString() + "\n");
			}
		} catch (Exception e) {
		}
	}

	public void a3() {
		try {
			s = c.createStatement();
			s.executeUpdate(c2.Q("q2"));
			s.executeUpdate(c2.Q("q1"));
		} catch (Exception e) {
		}
	}

	public void a4() {
		try {
			ps = c.prepareStatement(c2.Q("q3"));
			c.setAutoCommit(false);
			for(int i = 0; i < el.size(); i++){
				Employee employee = el.get(i);
				ps.setString(1, employee.getEmployeeId());
				ps.setString(2, employee.getFullName());
				ps.setString(3, employee.getAddress());
				ps.setString(4, employee.getFacultyName());
				ps.setString(5, employee.getDepartment());
				ps.setString(6, employee.getDesignation());
				ps.addBatch();
			}
			ps.executeBatch();
			c.commit();
		} catch (Exception e) {
		}
	}

	public void getEmployeeById(String eid) {

		Employee employee = new Employee();
		try {
			ps = c.prepareStatement(c2.Q("q4"));
			ps.setString(1, eid);
			ResultSet R = ps.executeQuery();
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
			ps = c.prepareStatement(c2.Q("q6"));
			ps.setString(1, eid);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void a5() {

		ArrayList<Employee> l = new ArrayList<Employee>();
		try {
			ps = c.prepareStatement(c2.Q("q5"));
			ResultSet r = ps.executeQuery();
			while (r.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(r.getString(1));
				employee.setFullName(r.getString(2));
				employee.setAddress(r.getString(3));
				employee.setFacultyName(r.getString(4));
				employee.setDepartment(r.getString(5));
				employee.setDesignation(r.getString(6));
				l.add(employee);
			}
		} catch (Exception e) {
		}
		employeeOutput(l);
	}
	
	public void employeeOutput(ArrayList<Employee> l){
		
		System.out.println("Employee ID" + "\t\t" + "Full Name" + "\t\t" + "Address" + "\t\t" + "Faculty Name" + "\t\t"
				+ "Department" + "\t\t" + "Designation" + "\n");
		System.out
				.println("================================================================================================================");
		for(int i = 0; i < l.size(); i++){
			Employee e = l.get(i);
			System.out.println(e.getEmployeeId() + "\t" + e.getFullName() + "\t\t"
					+ e.getAddress()+ "\t" + e.getFacultyName() + "\t" + e.getDepartment() + "\t"
					+ e.getDesignation() + "\n");
			System.out
			.println("----------------------------------------------------------------------------------------------------------------");
		}
		
	}
}
