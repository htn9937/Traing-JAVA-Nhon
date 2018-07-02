package com.example.demo.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,UUID>{
	@Query("select R from Role R where R.role_id =:roleId")
	List<Role> getRoleName(@Param("roleId") UUID roleId);
}
