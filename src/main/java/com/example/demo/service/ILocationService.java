package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Location;
import com.example.demo.model.cassLocation;

public interface ILocationService {

	List<Location> findAll();

	String save();

	List<Location> getAllLocations();

	List<cassLocation> getcassLocations();

	Location getLocationById(UUID id);

	boolean addLocation(Location location);

	void updateLocation(Location location);

	void deleteLocation(UUID id);

}
