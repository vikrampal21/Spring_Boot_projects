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

import com.ty.houserental.dto.Location;
import com.ty.houserental.dto.Users;
import com.ty.houserental.response.ResponseStructure;
import com.ty.houserental.service.LocationService;

import lombok.Data;

@Data
@RestController
@RequestMapping("/location")
public class LocationsController {

	@Autowired
	private LocationService locationService;

	@PostMapping("/register")
	public ResponseEntity<?> registerLocation(@RequestBody Location location) {
		ResponseStructure response = locationService.registerLocation(location);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> locationUpdate(@RequestBody Location location) {
		ResponseStructure<Location> responseStructure = locationService.locationUpdate(location);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{locationId}")
	public ResponseEntity<?> deleteLocation(@PathVariable int loactionId) {
		ResponseStructure<String> responseStructure = locationService.deleteLocation(loactionId);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteLocation() {
		ResponseStructure<String> responseStructure = locationService.deleteAllLocation();
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@GetMapping("/getLocation")
	public ResponseEntity<?> getDetailsOfLocation() {
		ResponseStructure<Iterable<Users>> responseStructure = locationService.getDetailsOfLocation();
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);

	}
	@GetMapping("/getLocation/{locationId}")
	public ResponseEntity<?> getLocationById(@PathVariable int locationId) {
		ResponseStructure<String> responseStructure = locationService.getLocationById(locationId);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
	
	
	
	
	
	
	
}
