package com.ty.employeeregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.employeeregister.dto.Laptop;

public interface LaptopRepo extends JpaRepository<Laptop, Integer> {

}
