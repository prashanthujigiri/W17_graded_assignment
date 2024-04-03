package com.gl.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort.Direction;

import com.gl.springboot.entity.Employee;
import com.gl.springboot.model.Credentials;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	
	Employee addEmployee(Employee employee);
	
	String addUser(Credentials credentials);
	
	Optional<Credentials> getUserDetailsById(int id);
	
	Optional<Employee> getEmployeeById(int id);
	
	Optional<Employee> updateEmployeeById(int id);
	
	String deleteEmployeeById(int id);
	
	Optional<Employee> getDuplicateEmployees(String string);
	
	List<Employee> getEmployeeCustomSortedByfirstName(Direction direction);
}
