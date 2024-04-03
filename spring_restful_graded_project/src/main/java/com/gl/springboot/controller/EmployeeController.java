package com.gl.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.springboot.entity.Employee;
import com.gl.springboot.model.Credentials;
import com.gl.springboot.serviceImpl.EmployeeServiceImpl;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl empSvcImp;
	
	@GetMapping("/list")
	public List<Employee> getAllEmployees() {
		return empSvcImp.getAllEmployees();
	}
	
	@PostMapping("/addemployee")
	public Employee addEmployee(Employee employee) {
		
		return empSvcImp.addEmployee(employee);
	}
	
	@GetMapping("/{id}")
	public void getEmployeeById(@PathVariable("id") int id) {
		empSvcImp.getEmployeeById(id);
	}
	
	@PostMapping("/addUser")
	public void addUser(Credentials credentials) {
		empSvcImp.addUser(credentials);
	}
	
	@GetMapping("/userDetailsById")
	public void getUserDetailsById(int id) {
		empSvcImp.getUserDetailsById(id);
	}
	
	@PutMapping("/update")
	public void updateEmployeById(int id) {
		empSvcImp.updateEmployeeById(id);
	}
	
	@DeleteMapping("/delete")
	public void deleteEmployeeById(int id) {
		empSvcImp.deleteEmployeeById(id);
	}
	
	@GetMapping("/getDuplicates")
	public Optional<Employee> getEmployeesByName(String string){
		return empSvcImp.getDuplicateEmployees(string);
	}
	
	@GetMapping("/ordered")
	public List<Employee> orederdEmployee(Direction direction){
		return empSvcImp.getEmployeeCustomSortedByfirstName(direction);
	}

}
