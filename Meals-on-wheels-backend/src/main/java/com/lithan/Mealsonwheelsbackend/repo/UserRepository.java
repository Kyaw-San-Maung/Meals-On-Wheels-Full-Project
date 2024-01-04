package com.lithan.Mealsonwheelsbackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithan.Mealsonwheelsbackend.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	
	User findByEmail(String email);

	List<User> findByApprovedFalse();
}
