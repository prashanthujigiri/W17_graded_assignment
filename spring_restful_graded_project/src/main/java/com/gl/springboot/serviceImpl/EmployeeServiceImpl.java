package com.gl.springboot.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gl.springboot.entity.Employee;
import com.gl.springboot.model.Credentials;
import com.gl.springboot.repository.EmployeeRepository;
import com.gl.springboot.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	@Override
	public Employee addEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}
	@Override
	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepository.findById(id);
	}
	@Override
	public String addUser(Credentials credentials) {
		employeeRepository.save(credentials);
		return "User saved Successfully";
	}
	@Override
	public Optional<Credentials> getUserDetailsById(int id) {
		return Optional.empty();
	}
	@Override
	public Optional<Employee> updateEmployeeById(int id) {
		
		return employeeRepository.findById(id);
	}
	@Override
	public String deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		
		return "Deleted employee id - " + id;
	}
	@Override
	public Optional<Employee> getDuplicateEmployees(String string) {
		
		return employeeRepository.findEmployeesByfirstName(string);
	}
	
	@Override
	public List<Employee> getEmployeeCustomSortedByfirstName(Direction direction) {
		// TODO Auto-generated method stub
		return employeeRepository.findAll(Sort.by(Direction.ASC, "firstName"));
	}
}
