package com.ty.houserental.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private int cityId;
	 private String cityName;
	 private String cityManager;
}
