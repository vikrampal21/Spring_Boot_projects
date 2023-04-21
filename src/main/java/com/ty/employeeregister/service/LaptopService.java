package com.ty.employeeregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.employeeregister.dao.LaptopDao;
import com.ty.employeeregister.dto.Laptop;
import com.ty.employeeregister.response.ResponseStructure;

@Service
public class LaptopService {
	
	@Autowired
	LaptopDao laptopDao;


	public ResponseStructure insertLaptop(Laptop laptop) {
		Laptop laptop2=laptopDao.insertLaptopData(laptop);
		ResponseStructure responseStructure=new ResponseStructure<>();
		responseStructure.setData(laptop2);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setStatusCode(200);
		return responseStructure;
	}
}
