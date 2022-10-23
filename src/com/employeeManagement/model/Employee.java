package com.employeeManagement.model;



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
	//Getters for Employee Id
	public String getEmployeeId() {
		return employeeId;
	}
	//Setters for Employee Id
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	//Getters for Full Name
	public String getFullName() {
		return fullName;
	}
	//Setters for Full Name
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	//Getters for Address
	public String getAddress() {
		return address;
	}
	//Setters for Address
	public void setAddress(String address) {
		this.address = address;
	}
	////Getters for Faculty Name
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	//Getters for Department
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	//Getters for Designation
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
