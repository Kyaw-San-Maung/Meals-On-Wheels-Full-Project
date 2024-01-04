package com.lithan.Mealsonwheelsbackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.lithan.Mealsonwheelsbackend.entity.Volunteer;

@Repository
public interface VolunteerRepository extends JpaRepository<Volunteer, Long>{
	Volunteer findByEmail(String email);
	
	 //Check or Find existing mail - return true or false
    //For Register (duplicate mail)
    Volunteer findByUsername(String username);
    
    
	List<Volunteer> findByApprovedFalse();
    
}
