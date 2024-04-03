package com.gl.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gl.springboot.entity.Employee;
import com.gl.springboot.model.Credentials;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	Optional<Employee> findEmployeesByfirstName(String string);

	String save(Credentials credentials);

}
