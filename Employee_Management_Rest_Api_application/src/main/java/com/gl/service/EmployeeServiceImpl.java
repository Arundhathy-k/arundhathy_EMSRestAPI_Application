package com.gl.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;
import com.gl.dao.EmployeeDAO;
import com.gl.entity.Employee;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO dao;

	@Override
	public Employee addEmployee(Employee e) {

		return dao.save(e);

	}

	@Override
	public Employee getEmployeeById(int id) {

		return dao.findById(id).get();
	}

	@Override
	public boolean deleteEmployeeById(int id) {
		if (dao.findById(id).isPresent()) {
			dao.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Employee> getAllEmployees() {

		return dao.findAll();
	}

	@Override
	public Employee updateEmployeeById(Employee e, int id) {

		Employee e1 = dao.findById(id).get();
		e1.setFirstName(e.getFirstName());
		e1.setLastName(e.getLastName());
		e1.setEmail(e.getEmail());
		dao.save(e1);
		return e1;
	}

	@Override
	public List<Employee> searchEmployeesByFirstName(String firstName) {

		return dao.findAllByFirstName(firstName);
	}

	@Override
	public List<Employee> getAllEmployeesSorted(String order) {
		Sort sort = order.equalsIgnoreCase("asc") ? Sort.by(Sort.Direction.ASC, "firstName")
				: Sort.by(Sort.Direction.DESC, "firstName");
		return dao.findAll(sort);
	}

}
