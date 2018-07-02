package com.example.demo.repo;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Sales;

@Repository
public interface SalesRepository extends JpaRepository<Sales,UUID>{
	@Query("select s from Sales s join fetch s.location where s.location.location_id =:id")
	Sales findOneWithSalesById(@Param("id") UUID id);
	
}
