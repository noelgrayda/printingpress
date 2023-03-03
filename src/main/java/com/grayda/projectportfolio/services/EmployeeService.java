package com.grayda.projectportfolio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grayda.projectportfolio.models.Employee;
import com.grayda.projectportfolio.repositories.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepo;
	
	// GETTING ALL ITEM
	public List<Employee> s_allEmployee(){
		return employeeRepo.findAll();
	}
	
	// ADDING NEW ITEM
	public Employee s_addEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	//deletes an ITEM
	public void s_deleteEmployee(Long id) {	
		Optional<Employee> optionalEmployee = employeeRepo.findById(id);
		
		if(optionalEmployee.isPresent()) {
			employeeRepo.deleteById(id);
		}		
	}

	// FINDING ID OF ITEM
	public Employee s_findEmployee(Long id){
		Optional<Employee> optionalEmployee = employeeRepo.findById(id);
		
		if(optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		}
		else {
			return null;
		}		
	}
}
