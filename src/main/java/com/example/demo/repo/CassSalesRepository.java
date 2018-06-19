package com.example.demo.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.cassandraEntity.CassSales;

@Repository
public interface CassSalesRepository extends CassandraRepository<CassSales, Long>{

}
