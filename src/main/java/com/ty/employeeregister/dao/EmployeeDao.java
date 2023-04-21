package com.ty.employeeregister.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.employeeregister.dto.Employee;
import com.ty.employeeregister.repository.EmployeeRepo;

@Repository
public class EmployeeDao {
	
	@Autowired
	EmployeeRepo employeeRepo;

	public Employee insert(Employee employee) {
		Employee employee2 = employeeRepo.save(employee);
		return employee2;
	}

	public Employee update(Employee employee) {
		Employee save = employeeRepo.save(employee);
		return save;
	}

	public Employee fetch(Employee employee) {
		return null;
	}
 
}
