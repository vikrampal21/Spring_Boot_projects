package com.ty.employeeregister.dto;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	@NotBlank
	private String employeeName;
	@NotBlank
	private String email;
	@NotBlank
	@Size(min = 6, max = 12)
	private String password;
	private String phone;
	@JsonManagedReference(value = "val")
	@OneToOne
	private Laptop laptop;

}
