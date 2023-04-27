package com.ty.houserental.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.houserental.dto.State;
import com.ty.houserental.repository.StateRepository;

import lombok.Data;

@Repository
public class StateDao {
	
	@Autowired
	StateRepository stateRepository;

	public State registerState(State state) {
		State state2 = stateRepository.save(state);
		return state2;
	}

	public State updateState(State state) {
		Optional<State> optional = stateRepository.findById(state.getStateId());
		if (optional.isPresent()) {
			State state2 = stateRepository.save(state);
			return state2;
		}
		throw new IllegalArgumentException("Id not found");
	}

	public String deleteAllStates() {
		Iterable<State> all = stateRepository.findAll();
		if (all != null) {
			stateRepository.deleteAll();
		}
		throw new IllegalArgumentException("No data is present");
	}

	public String deleteStateById(int stateId) {
		Optional<State> findById = stateRepository.findById(stateId);
		System.out.println(findById.get().toString());
		if (findById.isPresent()) {
			System.out.println("Hello i am going to delete the state");
			stateRepository.deleteById(stateId);
		}
		throw new IllegalArgumentException("id not found".toUpperCase());
	}

	public Iterable<State> getAllStates() {
		Iterable<State> allStates = stateRepository.findAll();
		return allStates;
	}

	/*
	 * public State getStatebyName(String stateName) { State state2 =
	 * stateRepository.findStateByStateName(stateName); return state2; }
	 */
	public Optional<State> getStateById(int stateId) {
		Optional<State> state2 = stateRepository.findById(stateId);
		return state2;
	}
}
