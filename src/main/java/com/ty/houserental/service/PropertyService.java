package com.ty.houserental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.houserental.dao.PropertyDao;
import com.ty.houserental.dto.Properties;
import com.ty.houserental.dto.State;
import com.ty.houserental.response.ResponseStructure;

@Service
public class PropertyService {
	
	@Autowired
	PropertyDao propertyDao;

	public ResponseStructure<State> registerProperty(Properties properties) {
		Properties properties2 = propertyDao.registerProperty(properties);
		ResponseStructure responseStructure = new ResponseStructure<>();
		responseStructure.setCode(200);
		responseStructure.setData(properties);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("Property data is saved sucessfully");
		return responseStructure;
	}

	public ResponseStructure<State> updateProperty(Properties properties) {
		Properties properties2= propertyDao.updateProperty(properties);
		ResponseStructure responseStructure = new ResponseStructure<>();
		responseStructure.setCode(200);
		responseStructure.setData(properties2);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("Property data is updated sucessfully");
		return responseStructure;
	}
	public ResponseStructure<String> deleteAllProperty() {
		String string = propertyDao.deleteAllProperty();
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setCode(200);
		responseStructure.setData("All the Property deleted sucessfully");
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("All the Property deleted sucessfully".toUpperCase());
		return responseStructure;
	}

		public ResponseStructure<String> deletePropertyById(int propertyId) {
			String string = propertyDao.deleteStateById(propertyId);
			ResponseStructure<String> responseStructure = new ResponseStructure<>();
			responseStructure.setCode(200);
			responseStructure.setData("Property deleted sucessfully");
			responseStructure.setHttpStatus(HttpStatus.OK);
			responseStructure.setMessage("Property deleted sucessfully".toUpperCase());
			return responseStructure;
		}


	public ResponseStructure<Iterable<Properties>> getAllProperty() {
		Iterable<Properties> allProperty = propertyDao.getAllProperty();
		ResponseStructure<Iterable<Properties>> responseStructure = new ResponseStructure<>();
		responseStructure.setCode(200);
		responseStructure.setData(allProperty);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("States Details displayed sucessfully".toUpperCase());
		return responseStructure;
	}
	public ResponseStructure getPropertyById(int propertyId) {
		Optional<Properties> property = propertyDao.getPropertyById(propertyId);
		ResponseStructure responseStructure = new ResponseStructure<>();
		responseStructure.setCode(200);
		responseStructure.setData(property.get());
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("State displayed sucessfully".toUpperCase());
		return responseStructure;
	
	
	}

}
