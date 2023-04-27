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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ty.houserental.dto.State;
import com.ty.houserental.response.ResponseStructure;
import com.ty.houserental.service.StateService;

import jakarta.websocket.server.PathParam;
import lombok.Data;

@Data
@RestController
@RequestMapping("/state")
public class StateController {

	@Autowired
	StateService stateService;

	@PostMapping("/register")
	public ResponseEntity<?> registerState(@RequestBody State state) {
		ResponseStructure<State> responseStructure = stateService.registerState(state);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateState(@RequestBody State state) {
		ResponseStructure<State> responseStructure = stateService.updateState(state);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@DeleteMapping("/delete-all-states")
	public ResponseEntity<?> deleteAllStates() {
		ResponseStructure<String> responseStructure = stateService.deleteAllStates();
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{stateId}")
	public ResponseEntity<?> deleteStateById(@PathVariable int stateId) {
		ResponseStructure<String> responseStructure = stateService.deleteStateById(stateId);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@GetMapping("/getAllStates")
	public ResponseEntity<?> getAllStates() {
		ResponseStructure<Iterable<State>> responseStructure = stateService.getAllStates();
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
	@GetMapping("/getState/{stateId}")
	public ResponseEntity<?> getStateById(@PathVariable int stateId) {
		ResponseStructure responseStructure = stateService.getStateById(stateId);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
	
	/*
	 * @GetMapping("/stateName") public ResponseEntity<?>
	 * getStateByName(@RequestParam String stateName) { ResponseStructure
	 * responseStructure = stateService.getStatebyName(stateName); return new
	 * ResponseEntity<>(responseStructure, HttpStatus.OK); }
	 */
}
