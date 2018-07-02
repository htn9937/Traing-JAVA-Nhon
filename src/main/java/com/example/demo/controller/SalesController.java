package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.Entity.Sales;
import com.example.demo.exception.DataNotFoundException;
import com.example.demo.service.ISalesService;

@RestController(value= SalesController.BASE_URL)
public class SalesController {
	public static final String BASE_URL = "/sale";
	public static final String GET_SALES = BASE_URL;

	@Autowired
	private ISalesService saveService;
	
	@RequestMapping(value = GET_SALES, method = RequestMethod.GET)
	public ResponseEntity<List<Sales>> getAllSaves() throws Exception{
		try {
			List<Sales> sales = saveService.getAllSales();
			return new ResponseEntity<List<Sales>>(sales, HttpStatus.OK);
		} catch (Exception e) {
			throw new DataNotFoundException("");
			//LogUtil.error(logger, e) ===> logger.error(e.getMessage(), e); }
		}
	}
	@RequestMapping(value = GET_SALES+"1", method = RequestMethod.GET)
	public Sales addSale() {
		saveService.test();
		return saveService.test();
	}
	
//	@GetMapping("salesproduct2")
//	public ResponseEntity<List<Sales>> getAllSalet(){ 
//		try {
//			List<Sales> sales = saveService.getAllSales2();
//			return new ResponseEntity<List<Sales>>(sales, HttpStatus.OK);
//		}
//		catch(Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
}
