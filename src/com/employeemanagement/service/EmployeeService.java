package com.employeemanagement.service;

import java.util.ArrayList;

import com.employeemanagement.model.Employee;

public interface EmployeeService {
	
	void getEmployeesFromXML();
	void createEmployeeTable();
	void addEmployee();
	void getEmployeeById(String employeeId);
	void deleteEmployee(String employeeId);
	void displayEmployee();
	void employeeOutput(ArrayList<Employee> l);

}
