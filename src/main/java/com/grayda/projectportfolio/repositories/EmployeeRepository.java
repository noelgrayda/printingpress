package com.grayda.projectportfolio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grayda.projectportfolio.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
	List<Employee> findAll();
}
