package com.ty.houserental.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.houserental.dao.StateDao;
import com.ty.houserental.dto.State;
import com.ty.houserental.response.ResponseStructure;

import lombok.Data;

@Service
@Data
public class StateService {

	@Autowired
	StateDao stateDao;

	public ResponseStructure<State> registerState(State state) {
		State state2 = stateDao.registerState(state);
		ResponseStructure responseStructure = new ResponseStructure<>();
		responseStructure.setCode(200);
		responseStructure.setData(state2);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("state data is saved sucessfully");
		return responseStructure;
	}

	public ResponseStructure<State> updateState(State state) {
		State state2 = stateDao.updateState(state);
		ResponseStructure responseStructure = new ResponseStructure<>();
		responseStructure.setCode(200);
		responseStructure.setData(state2);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("state data is updated sucessfully");
		return responseStructure;
	}

	public ResponseStructure<String> deleteAllStates() {
		String string = stateDao.deleteAllStates();
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setCode(200);
		responseStructure.setData("All the states deleted sucessfully");
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("All the states deleted sucessfully".toUpperCase());
		return responseStructure;
	}

	public ResponseStructure<String> deleteStateById(int stateId) {
		String string = stateDao.deleteStateById(stateId);
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setCode(200);
		responseStructure.setData("states deleted sucessfully");
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("States deleted sucessfully".toUpperCase());
		return responseStructure;
	}

	public ResponseStructure<Iterable<State>> getAllStates() {
		Iterable<State> allStates = stateDao.getAllStates();
		ResponseStructure<Iterable<State>> responseStructure = new ResponseStructure<>();
		responseStructure.setCode(200);
		responseStructure.setData(allStates);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("States Details displayed sucessfully".toUpperCase());
		return responseStructure;
	}

	public ResponseStructure getStateById(int stateId) {
		Optional<State> state2 = stateDao.getStateById(stateId);
		ResponseStructure responseStructure = new ResponseStructure<>();
		responseStructure.setCode(200);
		responseStructure.setData(state2.get());
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("State displayed sucessfully".toUpperCase());
		return responseStructure;
	}
	
	/*
	 * public ResponseStructure getStatebyName(String stateName) { State state2 =
	 * stateDao.getStatebyName(stateName); ResponseStructure responseStructure = new
	 * ResponseStructure<>(); responseStructure.setCode(200);
	 * responseStructure.setData(state2);
	 * responseStructure.setHttpStatus(HttpStatus.OK);
	 * responseStructure.setMessage("State displayed sucessfully".toUpperCase());
	 * return responseStructure; }
	 */	
}
