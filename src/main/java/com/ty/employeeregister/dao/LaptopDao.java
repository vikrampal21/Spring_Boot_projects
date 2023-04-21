package com.ty.employeeregister.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.employeeregister.dto.Laptop;
import com.ty.employeeregister.repository.LaptopRepo;

@Repository
public class LaptopDao {
	
	@Autowired
	LaptopRepo laptopRepo;

	public Laptop insertLaptopData(Laptop laptop) {
		Laptop laptop2 = laptopRepo.save(laptop);
		return laptop2;
	}

}
