package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.LocationDTO;
import com.example.demo.Entity.Location;
import com.example.demo.Utils.LogUtil;
import com.example.demo.model.cassandraEntity.CassLocation;
import com.example.demo.repo.LocationRepository;
import com.example.demo.service.ILocationService;
import com.example.demo.repo.CassLocationRepository;

@Service
public class LocationServiceImpl implements ILocationService{

	@Autowired
	private LocationRepository repo;
	
	@Autowired
	private CassLocationRepository cassrepo;

	@Override
	public List<CassLocation> getcassLocations(){
		List<CassLocation> list = new ArrayList<>();
		cassrepo.findAll().forEach(e -> list.add(e));
		return list;
	}
	
//	@Override
//	public String copyy(){
//		List<CassLocation> list = new ArrayList<>();
//		cassrepo.findAll().forEach(e -> list.add(e));
//		for(CassLocation x : list) {
//			Location l = new Location(x.getLocation_id(),x.getCity(),x.getCountry(),x.getCreate_at(),x.getCreate_at());
//			repo.save(l);
//		}
//		return "DONE";
//	}

//--------------------------------------------------------------------------
	
	@Override
	public Location getLocationById(UUID id) {
		LogUtil.Debug(this.getClass(), "getLocationById >>> Start");
		Location obj = repo.findById(id).get();
		LogUtil.Debug(this.getClass(), "getLocationById >>> End");
		return obj;
	}
	
	@Override
	public LocationDTO getLocationByIdDTO(UUID id) {
		LogUtil.Debug(this.getClass(), "getLocationById >>> Start");
		Location obj = repo.findById(id).get();
		ModelMapper modelMapper = new ModelMapper();
		LocationDTO locationDto = modelMapper.map(obj, LocationDTO.class);
		LogUtil.Debug(this.getClass(), "getLocationById >>> End");
		return locationDto;
	}
	
	
	
	@Override
	public List<Location> getAllLocations(){
		LogUtil.Debug(this.getClass(), "getAllLocations >>> Start");
		List<Location> loactions = (List<Location>) repo.findAll();
		LogUtil.Debug(this.getClass(), "getAllLocations >>> End");
		return loactions;
	}
	
	@Override
	public synchronized boolean addLocation(Location location) { 
		LogUtil.Debug(this.getClass(), "addLocation >>> Start");
		Optional<Location> lo =  repo.findById(location.getLocation_id());
		if (lo.isPresent()) {
			LogUtil.Debug(this.getClass(), "addLocation >>> End");
			return false;
			}
		else {
			repo.save(location);
			LogUtil.Debug(this.getClass(), "addLocation >>> End");
			return true;
			}
	}
	
	@Override
	public void updateLocation(Location location) {
		LogUtil.Debug(this.getClass(), "updateLocation >>> Start");
		repo.save(location);
		LogUtil.Debug(this.getClass(), "updateLocation >>> End");
	}
	
	@Override 
	public void  deleteLocation(UUID id) {
		LogUtil.Debug(this.getClass(), "deleteLocation >>> Start");
		repo.delete(getLocationById(id));
		LogUtil.Debug(this.getClass(), "deleteLocation >>> End");
	}
}

