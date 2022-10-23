package com.employeemanagement.service;

import java.util.ArrayList;

import com.employeemanagement.commons.c1;
import com.employeemanagement.model.Employee;

public abstract class AbstractService extends c1 {
	

	abstract void getEmployeesFromXML() throws Exception;
	abstract void createEmployeeTable() throws Exception;
	abstract void addEmployee() throws Exception;
	abstract void getEmployeeById(String employeeId) throws Exception;
	abstract void deleteEmployee(String employeeId);
	abstract void displayEmployee() throws Exception;
	abstract void employeeOutput(ArrayList<Employee> employeeList);

}
