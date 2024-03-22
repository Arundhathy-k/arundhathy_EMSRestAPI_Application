package com.gl.service;

import java.util.List;
import com.gl.entity.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee e);

	public Employee getEmployeeById(int id);

	public boolean deleteEmployeeById(int id);

	public List<Employee> getAllEmployees();

	public Employee updateEmployeeById(Employee e, int id);
	
	public List<Employee> searchEmployeesByFirstName(String firstName);
	
    public List<Employee> getAllEmployeesSorted(String order);
}
