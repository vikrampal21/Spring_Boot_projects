package com.ty.houserental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.houserental.dto.Properties;
import com.ty.houserental.dto.State;
import com.ty.houserental.response.ResponseStructure;
import com.ty.houserental.service.PropertyService;

@RestController
@RequestMapping("/properties")
public class PropertyController {
	
	@Autowired
	PropertyService propertyService;

	
	@PostMapping("/register")
	public ResponseEntity<?> registerProperty(@RequestBody Properties properties) {
		ResponseStructure<State> responseStructure = propertyService.registerProperty(properties);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateProperty(@RequestBody Properties properties) {
		ResponseStructure<State> responseStructure = propertyService.updateProperty(properties);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@DeleteMapping("/delete-all-properties")
	public ResponseEntity<?> deleteAllProperty() {
		ResponseStructure<String> responseStructure = propertyService.deleteAllProperty();
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{propertyId}")
	public ResponseEntity<?> deletePropertyById(@PathVariable int propertyId) {
		ResponseStructure<String> responseStructure = propertyService.deletePropertyById(propertyId);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@GetMapping("/getAllProperty")
	public ResponseEntity<?> getAllProperty() {
		ResponseStructure<Iterable<Properties>> responseStructure = propertyService.getAllProperty();
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
	@GetMapping("/getProperty/{propertyId}")
	public ResponseEntity<?> getPropertyById(@PathVariable int propertyId) {
		ResponseStructure responseStructure = propertyService.getPropertyById(propertyId);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
}
