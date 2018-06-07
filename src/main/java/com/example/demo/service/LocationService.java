package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Location;
import com.example.demo.model.cassLocation;
import com.example.demo.repo.LocationRepository;
import com.example.demo.repo.cassLocationRepository;

@Service
public class LocationService implements ILocationService{

	@Autowired
	private LocationRepository repo;
	
	@Autowired
	private cassLocationRepository cassrepo;
	
	@Override
	public List<Location> findAll(){
		List<Location> loactions = (List<Location>) repo.findAll();
		return loactions;
	}
	@Override
	public String save(){
		UUID uuid = UUID.randomUUID();
		Location lc = new Location(uuid,"Viet Nam", "HCM", new Date(), new Date());
		repo.save(lc);
	//	repo.save(new Location(UUID.randomUUID(),"","",new Date(), new Date()));
		return uuid.toString();
	}
	
	
	@Override
	public List<cassLocation> getcassLocations(){
		List<cassLocation> list = new ArrayList<>();
		cassrepo.findAll().forEach(e -> list.add(e));
		return list;
	}
	
	//--------------------------------------------------------------------------
	@Override
	public Location getLocationById(UUID id) {
		Location obj = repo.findById(id).get();
		return obj;
	}
	
	@Override
	public List<Location> getAllLocations(){
		List<Location> loactions = (List<Location>) repo.findAll();
		return loactions;
	}
	
	@Override
	public synchronized boolean addLocation(Location location) { 
		Optional<Location> lo =  repo.findById(location.getLocation_id());
		if (lo.isPresent()) {
			return false;
			}
		else {
			repo.save(location);
			return true;
		}
	}
	
	@Override
	public void updateLocation(Location location) {
		repo.save(location);
	}
	
	@Override 
	public void  deleteLocation(UUID id) {
		repo.delete(getLocationById(id));
	}
}

