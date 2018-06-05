package com.example.demo.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID>{

}
