package com.employeemanagement.service;

import java.util.ArrayList;

import com.employeemanagement.model.Employee;

public interface EmployeeService {
	
	void getEmployeesFromXML() throws Exception;
	void createEmployeeTable() throws Exception;
	void addEmployee() throws Exception;
	void getEmployeeById(String employeeId) throws Exception;
	void deleteEmployee(String employeeId);
	void displayEmployee() throws Exception;
	void employeeOutput(ArrayList<Employee> l);

}
