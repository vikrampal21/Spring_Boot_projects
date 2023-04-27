package com.ty.houserental.repository;

import org.springframework.data.repository.CrudRepository;

import com.ty.houserental.dto.State;

public interface StateRepository extends CrudRepository<State, Integer>{
 
	/*
	 * public State findStateByStateId(int stateId); public State
	 * findStateByStateName(String stateName);
	 */
}
