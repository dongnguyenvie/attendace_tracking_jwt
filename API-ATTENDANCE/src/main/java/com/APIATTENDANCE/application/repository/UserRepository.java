package com.APIATTENDANCE.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.APIATTENDANCE.application.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("select u FROM User u where (u.us_phone = ?1 OR u.us_email = ?1) and u.us_password = ?2")
	User LoginUser(String username, String password);
	
	@Query("SELECT u FROM User u INNER JOIN u.track as t WHERE u.us_id=1 AND t.track_id=3")
	User FilterUser(int id);
}
