package com.ty.houserental.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ty.houserental.dao.LocationDao;
import com.ty.houserental.dto.Location;
import com.ty.houserental.dto.Users;
import com.ty.houserental.response.ResponseStructure;

import lombok.Data;

@Data
@Service
public class LocationService {

	@Autowired
	LocationDao locationDao;;

	public ResponseStructure registerLocation(Location location) {
		Location location2 = locationDao.registerlocation(location);
		ResponseStructure responseStructure = new ResponseStructure<>();
		responseStructure.setData(location2);
		responseStructure.setCode(200);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("location saved sucessfully".toUpperCase());
		return responseStructure;
	}

	public ResponseStructure<Location> locationUpdate(Location location) {
		Location location2 = locationDao.updatelocation(location);
		ResponseStructure responseStructure = new ResponseStructure<>();
		responseStructure.setData(location2);
		responseStructure.setCode(200);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("location saved sucessfully".toUpperCase());
		return responseStructure;
	}

	public ResponseStructure<String> deleteLocation(int loactionId) {
		String string = locationDao.deleteLocation(loactionId);
		ResponseStructure responseStructure = new ResponseStructure<>();
		responseStructure.setData(string);
		responseStructure.setCode(200);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("location deleted sucessfully".toUpperCase());
		return responseStructure;
	}

	public ResponseStructure<String> deleteAllLocation() {
		String string = locationDao.deleteAllLocation();
		ResponseStructure responseStructure = new ResponseStructure<>();
		responseStructure.setData(string);
		responseStructure.setCode(200);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("All the ocation deleted sucessfully".toUpperCase());
		return responseStructure;
	}

	public ResponseStructure<Iterable<Users>> getDetailsOfLocation() {
		Iterable<Location> string = locationDao.getDetailsOfLocation();
		ResponseStructure responseStructure = new ResponseStructure<>();
		responseStructure.setData(string);
		responseStructure.setCode(200);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("All the Location Displayed sucessfully".toUpperCase());
		return responseStructure;
	}

	public ResponseStructure<String> getLocationById(int locationId) {
		Optional<Location> optional = locationDao.getLocationById(locationId);
		ResponseStructure responseStructure = new ResponseStructure<>();
		responseStructure.setData(optional);
		responseStructure.setCode(200);
		responseStructure.setHttpStatus(HttpStatus.OK);
		responseStructure.setMessage("Location Displayed sucessfully".toUpperCase());
		return responseStructure;
	}

}
