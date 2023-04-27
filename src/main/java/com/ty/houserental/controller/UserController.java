package com.ty.houserental.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.houserental.dto.Users;
import com.ty.houserental.response.ResponseStructure;
import com.ty.houserental.service.UserService;

import lombok.Data;

@Data
@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping("/registration")
	public ResponseEntity<?> userRegistration(@RequestBody Users users) {
		ResponseStructure<Users> responseStructure = userService.registerUser(users);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@GetMapping("/userLogin")
	public ResponseEntity<?> userLogin(@RequestParam String userEmail, @RequestParam String password) {
		return null;
	}

	@PutMapping("/passwordUpdate")
	public ResponseEntity<?> passwordUpdate(@RequestBody Users users) {
		ResponseStructure<Users> responseStructure = userService.passwordUpdate(users);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@DeleteMapping("/adminDelete/{adminId}")
	public ResponseEntity<?> deleteAdmin(@PathVariable int adminId) {
		ResponseStructure<String> responseStructure = userService.deleteAdmin(adminId);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
	@GetMapping("/getDetails")
	public ResponseEntity<?> getDetailsOfUsers() {
		ResponseStructure<Iterable<Users>> responseStructure = userService.getDetailsOfUsers();
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	} 
	
}
