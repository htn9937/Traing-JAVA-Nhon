package com.example.demo.service;

import java.util.List;
import java.util.UUID;

import com.example.demo.model.Location;
import com.example.demo.model.cassandraEntity.CassLocation;

public interface ILocationService {

	List<Location> getAllLocations();

	List<CassLocation> getcassLocations();

	Location getLocationById(UUID id);

	boolean addLocation(Location location);

	void updateLocation(Location location);

	void deleteLocation(UUID id);

}
