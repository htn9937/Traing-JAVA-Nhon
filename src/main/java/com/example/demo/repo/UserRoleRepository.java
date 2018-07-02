package com.example.demo.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,UUID> {
	@Query("select U.role.role_name from UserRole U where U.user.user_id=:userId")
	List<String> getRolesName(@Param("userId") UUID userId);
}
