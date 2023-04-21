package com.ty.employeeregister.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.employeeregister.dto.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	@Transactional
	public int deleteByEmail(String email);
	
}
