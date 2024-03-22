package com.gl.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gl.entity.Employee;
import com.gl.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {

		return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id) {

		return new ResponseEntity<>(service.getEmployeeById(id), HttpStatus.OK);
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee e) {

		return new ResponseEntity<>(service.addEmployee(e), HttpStatus.OK);
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Boolean> deleteByID(@PathVariable("id") int id) {

		return new ResponseEntity<>(service.deleteEmployeeById(id), HttpStatus.OK);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee e, @PathVariable("id") int id) {

		return new ResponseEntity<>(service.updateEmployeeById(e, id), HttpStatus.OK);
	}

	@GetMapping("/employees/search/{firstName}")
	public ResponseEntity<List<Employee>> searchEmployeesByFirstName(@PathVariable String firstName) {
		List<Employee> employees = service.searchEmployeesByFirstName(firstName);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	@GetMapping("/employees/sort")
	public ResponseEntity<List<Employee>> getAllEmployeesSorted(@RequestParam String order) {
		List<Employee> employees = service.getAllEmployeesSorted(order);
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

}
