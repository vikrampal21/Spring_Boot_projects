package com.ty.houserental.repository;

import org.springframework.data.repository.CrudRepository;

import com.ty.houserental.dto.Properties;

public interface PropertyRepository extends CrudRepository<Properties, Integer>{

}
