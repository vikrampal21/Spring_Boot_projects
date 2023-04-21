package com.ty.employeeregister.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Laptop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int laptopId;
	private String laptopName;
	private String laptopBrand;
	
	@JsonBackReference(value = "val")
	@OneToOne(mappedBy = "laptop")
	private Employee employee;

}
