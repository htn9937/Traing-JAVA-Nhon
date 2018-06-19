package com.example.demo.controller;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.model.Location;
import com.example.demo.service.ILocationService;

@RestController(value= LocationController.BASE_URL)
public class LocationController {
	public static final String BASE_URL = "/location";
	public static final String GET_LOCATIONS = BASE_URL;
	public static final String ADD_LOCATION = BASE_URL;
	public static final String UPDATE_LOCATION = BASE_URL;
	public static final String GET_LOCATION_BY_ID = BASE_URL +"/{id}";
	public static final String DELETE_LOCATION_BY_ID = BASE_URL +"/{id}";
	@Autowired
	ILocationService locationService;
	
//	@GetMapping("location/{id}")
	@RequestMapping(value = GET_LOCATION_BY_ID, method = RequestMethod.GET)
	public ResponseEntity<Location> getLocationById(@PathVariable("id") UUID id){
		com.example.demo.Utils.LogUtil.Debug(this.getClass(), "getLocationById >>> Start");
		Location location  = locationService.getLocationById(id);
		com.example.demo.Utils.LogUtil.Debug(this.getClass(), "getLocationById >>> End");
		return new ResponseEntity<Location>(location, HttpStatus.OK);
	}
	
	@RequestMapping(value = GET_LOCATIONS, method = RequestMethod.GET)
	public ResponseEntity<List<Location>> getAllLocations(){
		com.example.demo.Utils.LogUtil.Debug(this.getClass(), "getAllLocations >>> Start");
//		com.example.demo.Utils.LogUtil.mylog("getAllLocations >>> Start");
		List<Location> locations = locationService.getAllLocations();
		com.example.demo.Utils.LogUtil.Debug(this.getClass(), "getAllLocations >>> End");
		return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
	}
	
//	@DeleteMapping("location/{id}")
	@RequestMapping(value = DELETE_LOCATION_BY_ID, method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLocation(@PathVariable("id") UUID id) {
		com.example.demo.Utils.LogUtil.Debug(this.getClass(), "deleteLocation >>> Start");
		locationService.deleteLocation(id);
		com.example.demo.Utils.LogUtil.Debug(this.getClass(), "deleteLocation >>> End");
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
//	@PostMapping("location")
	@RequestMapping(value = ADD_LOCATION, method = RequestMethod.POST)
	public ResponseEntity<Void> addLocation(@RequestBody Location location, UriComponentsBuilder builder) {
		com.example.demo.Utils.LogUtil.Debug(this.getClass(), "addLocation >>> Start");
        boolean flag = locationService.addLocation(location);
        if (flag == false) {
        	com.example.demo.Utils.LogUtil.Debug(this.getClass(), "addLocation >>> End");
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/location/{id}").buildAndExpand(location.getLocation_id()).toUri());
    	com.example.demo.Utils.LogUtil.Debug(this.getClass(), "addLocation >>> End");
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
//	@PutMapping("location")
	@RequestMapping(value = UPDATE_LOCATION, method = RequestMethod.PUT)
	public ResponseEntity<Location> updateArticle(@RequestBody Location location) {
		com.example.demo.Utils.LogUtil.Debug(this.getClass(), "updateArticle >>> Start");
		locationService.updateLocation(location);
		com.example.demo.Utils.LogUtil.Debug(this.getClass(), "updateArticle >>> Start");
		return new ResponseEntity<Location>(location, HttpStatus.OK);
	}
}
