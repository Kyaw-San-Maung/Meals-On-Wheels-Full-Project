package com.lithan.Mealsonwheelsbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lithan.Mealsonwheelsbackend.entity.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findByEmail(String email);
	
	 //Check or Find existing mail - return true or false
   //For Register (duplicate mail)
	Admin findByUsername(String username);
	
}
