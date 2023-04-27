package com.ty.houserental.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.houserental.dto.Location;
import com.ty.houserental.repository.LocationRepository;

import lombok.Data;

@Data
@Repository
public class LocationDao {

	@Autowired
	LocationRepository repo;

	public Location registerlocation(Location location) {
		Location location2 = repo.save(location);
		return location2;
	}

	public Location updatelocation(Location location) {
		Optional<Location> optional = repo.findById(location.getLocationId());
		if (optional.isPresent()) {
			Location location2 = repo.save(location);
			return location2;
		}
		throw new IllegalArgumentException();
	}

	public String deleteLocation(int loactionId) {
		Optional<Location> optional = repo.findById(loactionId);
		if (optional.isPresent()) {
			repo.delete(optional.get());
			return "Location deleted sucessfully";
		}
		throw new IllegalArgumentException();
	}

	public String deleteAllLocation() {
		Iterable<Location> allLocation = repo.findAll();
		if (allLocation!=null) {
			repo.deleteAll(allLocation);;
			return "All Location deleted sucessfully";
		}
		throw new IllegalArgumentException();
	}

	public Iterable<Location> getDetailsOfLocation() {
		Iterable<Location> allLocation = repo.findAll();
		if (allLocation!=null) {
			
			return allLocation; 
		}
		throw new IllegalArgumentException();
	}

	public Optional<Location> getLocationById(int locationId) {
		Optional<Location> optional = repo.findById(locationId);
		if (optional!=null) {
			
			return optional; 
		}
		throw new IllegalArgumentException();
	}
}
