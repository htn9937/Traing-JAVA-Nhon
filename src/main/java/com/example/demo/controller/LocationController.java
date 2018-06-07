package com.example.demo.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.model.Location;
import com.example.demo.service.ILocationService;

import javassist.NotFoundException;

@RestController
public class LocationController {
	private final static Logger LOGGER = Logger.getLogger(LocationController.class.getName());
	@Autowired
	ILocationService locationService;
	
	@GetMapping("location/{id}")
	public ResponseEntity<Location> getLocationById(@PathVariable("id") UUID id) throws Exception{
			Location location  = locationService.getLocationById(id);
			if(location!=null) {
				LOGGER.info("Logging an INFO-level message");
				throw new NotFoundException("LOCATION NOT FOUND");
			}
			LOGGER.info("Logging an INFO-level message");
			return new ResponseEntity<Location>(location, HttpStatus.OK);
	}
	
	@GetMapping("locations")
	public ResponseEntity<List<Location>> getAllLocations(){
		List<Location> locations = locationService.getAllLocations();
		return new ResponseEntity<List<Location>>(locations, HttpStatus.OK);
	}
	
	@DeleteMapping("location/{id}")
	public ResponseEntity<Void> deleteLocation(@PathVariable("id") UUID id) {
		locationService.deleteLocation(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
	@PostMapping("location")
	public ResponseEntity<Void> addLocation(@RequestBody Location location, UriComponentsBuilder builder) {
        		//location.setLocation_id(UUID.randomUUID());
                boolean flag = locationService.addLocation(location);
                if (flag == false) {
                	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/location/{id}").buildAndExpand(location.getLocation_id()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("location")
	public ResponseEntity<Location> updateArticle(@RequestBody Location location) {
		locationService.updateLocation(location);
		return new ResponseEntity<Location>(location, HttpStatus.OK);
	}
}
