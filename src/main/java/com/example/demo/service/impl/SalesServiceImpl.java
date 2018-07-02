package com.example.demo.service.impl;

//import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Sales;
import com.example.demo.repo.SalesRepository;
import com.example.demo.service.ISalesService;

@Service
public class SalesServiceImpl implements ISalesService{
	
	@Autowired
	private SalesRepository salesRepository;
	
	@Override
	public List<Sales> getAllSales(){
		List<Sales> sales = (List<Sales>) salesRepository.findAll();
		return sales;
	}
	
//	@Override
//	public void addNewSales(){
//		Sales a = new Sales(UUID.fromString("68602869-3c12-4b8e-9f48-7970f81b8006"),UUID.fromString("c156ee10-688c-11e8-b87a-81a2c9c40b81"),UUID.fromString("e6233937-78d2-42a6-addf-87b28d4e1bb8"),UUID.randomUUID());
//		salesRepository.save(a);
//	}
	
	@Override
	public Sales test() {
		return salesRepository.findOneWithSalesById(UUID.fromString("c156ee10-688c-11e8-b87a-81a2c9c40b81"));
	}
	
}
