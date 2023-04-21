package com.ty.employeeregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.employeeregister.dao.EmployeeDao;
import com.ty.employeeregister.dao.LaptopDao;
import com.ty.employeeregister.dto.Employee;
import com.ty.employeeregister.dto.Laptop;
import com.ty.employeeregister.response.ResponseStructure;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;
	
	public ResponseStructure insert(Employee employee) {
		Employee employee2=dao.insert(employee);
		ResponseStructure responseStructure=new ResponseStructure<>();
		responseStructure.setData(employee2);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setStatusCode(200);
		return responseStructure;
	}

	public ResponseStructure fetch(Employee employee) {
		Employee employee2=dao.fetch(employee);
		ResponseStructure responseStructure=new ResponseStructure<>();
		responseStructure.setData(employee2);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setStatusCode(200);
		return responseStructure;
	}

	public ResponseStructure fetchPage(int pageNo) {

		return null;
	}


}
