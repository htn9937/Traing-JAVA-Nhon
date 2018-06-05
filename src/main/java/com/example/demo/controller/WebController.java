package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Location;
import com.example.demo.model.cassLocation;
import com.example.demo.service.ILocationService;

@RestController
public class WebController {

	@Autowired
	ILocationService locationService;
//	@RequestMapping("/save")
//	public String process(){
//		// save a single Customer
//		repository.save(new Customer("Jack", "Smith"));
//		
//		// save a list of Customers
//	
//		
//		return "Done";
//	}
	@RequestMapping("/save")
	public String process(){
		// save a single Customer
		return locationService.save();
		
		// save a list of Customers
	
	}
	
	@RequestMapping("/findall")
	public String findAll(){
		String result = "";
		List<Location> customers = (List<Location>) locationService.getAllLocations();
		for(Location cust : customers){
			result += cust.toString() + "<br>";
		}
		Date date = new Date();
		result +=date.toString();
		return result;
	}
	@RequestMapping("/findall2")
	public String findAll2(){
		String result = "";
		List<cassLocation> customers = (List<cassLocation>) locationService.getcassLocations();
		for(cassLocation cust : customers){
			result += cust.toString() + "<br>";
		}
		Date date = new Date();
		result +=date.toString();
		return result;
	}
//	@RequestMapping("/findbyid")
//	public String findById(@RequestParam("id") long id){
//		String result = "";
//		result = repository.findById(id).toString();
//		return result;
//	}
//	
//	@RequestMapping("/findbylastname")
//	public String fetchDataByLastName(@RequestParam("lastname") String lastName){
//		String result = "";
//		
//		for(Customer cust: repository.findByLastName(lastName)){
//			result += cust.toString() + "<br>"; 
//		}
//		
//		return result;
//	}
}
