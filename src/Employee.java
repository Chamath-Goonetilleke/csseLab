

public class Employee {

	public String employeeId;
	public String fullName;
	public String address;
	public String facultyName;
	public String department;
	public String designation;
	
	public Employee() {
		super();
	}
	public Employee(String employeeId, String fullName, String address, String facultyName, String department,
			String designation) {
		super();
		this.employeeId = employeeId;
		this.fullName = fullName;
		this.address = address;
		this.facultyName = facultyName;
		this.department = department;
		this.designation = designation;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "b [employeeId=" + employeeId + ", fullName=" + fullName + ", address=" + address + ", facultyName="
				+ facultyName + ", department=" + department + ", designation=" + designation + "]";
	}
	
	
}
