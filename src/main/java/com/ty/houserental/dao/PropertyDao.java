package com.ty.houserental.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.houserental.dto.Properties;
import com.ty.houserental.repository.PropertyRepository;

@Repository
public class PropertyDao {

	@Autowired
	PropertyRepository propertyRepository;

	public Properties registerProperty(Properties properties) {
		Properties properties2 = propertyRepository.save(properties);
		return properties2;
	}

	public Properties updateProperty(Properties properties) {
		Optional<Properties> optional = propertyRepository.findById(properties.getPropertyId());
		if (optional.isPresent()) {
			Properties properties2 = propertyRepository.save(properties);
			return properties2;
		}
		throw new IllegalArgumentException("ID not Found");
	}

	public String deleteAllProperty() {
		propertyRepository.deleteAll();
		return "All the data deleted Sucessfully";
	}

	public String deleteStateById(int propertyId) {
		Optional<Properties> optional = propertyRepository.findById(propertyId);
		if (optional.isPresent()) {
			propertyRepository.deleteById(propertyId);
			return "data deleted Sucessfully";
		}
		throw new IllegalArgumentException("ID not Found");
	}

	public Iterable<Properties> getAllProperty() {
		Iterable<Properties> iterable = propertyRepository.findAll();
		return iterable;

	}

	public Optional<Properties> getPropertyById(int propertyId) {
		Optional<Properties> optional = propertyRepository.findById(propertyId);
		return optional;
	}
}
