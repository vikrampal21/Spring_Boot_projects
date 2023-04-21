package com.ty.employeeregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.employeeregister.dto.Employee;
import com.ty.employeeregister.dto.Laptop;
import com.ty.employeeregister.repository.EmployeeRepo;
import com.ty.employeeregister.response.ResponseStructure;
import com.ty.employeeregister.service.EmployeeService;
import com.ty.employeeregister.service.LaptopService;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	LaptopService laptopService;

	@Autowired
	EmployeeRepo employeeRepo;

//	@ApiOperation(value = "insert end point " ,notes = "insert the employee")
//	@ApiResponses(value = { @ApiResponse(code = 200,message =  "data inserted"),
//	@ApiResponse(code = 400, message = "data not inserted")})
	@RequestMapping(path = "/insert", method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody Employee employee) {
		ResponseStructure responseStructure = employeeService.insert(employee);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}

	@GetMapping(path = "/fetch")
	public ResponseEntity<?> fetch(@RequestBody Employee employee) {
		System.out.println(employee);
		// ResponseStructure responseStructure= employeeService.fetch(employee);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(path = "/insertLaptop", method = RequestMethod.POST)
	public ResponseEntity<?> insertLaptopData(@RequestBody Laptop laptop) {
		ResponseStructure responseStructure = laptopService.insertLaptop(laptop);
		return new ResponseEntity<>(responseStructure, responseStructure.getHttpStatus());
	}

	@RequestMapping(path = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteByEmail(@RequestParam String email) {
		int deleteCount = employeeRepo.deleteByEmail(email);
		return new ResponseEntity<>(deleteCount, HttpStatus.OK);
	}

	@GetMapping(path = "/laptop/{pageNo}")
	public ResponseEntity<?> fetchPage(@PathVariable int pageNo) {
		PageRequest pageRequest = PageRequest.of(pageNo, 20);
		Page<Employee> pageData = employeeRepo.findAll(pageRequest);
		return new ResponseEntity<>(pageData, HttpStatus.OK);
	}
}
