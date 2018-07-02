package com.example.demo.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,UUID> {
	@Query("select U from User U where U.user_name =:userName")
	User findUserByUserName(@Param("userName") String userName);
}
