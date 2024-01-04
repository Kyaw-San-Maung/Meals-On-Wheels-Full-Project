package com.lithan.Mealsonwheelsbackend.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithan.Mealsonwheelsbackend.entity.Caregiver;
import com.lithan.Mealsonwheelsbackend.entity.Partner;
import com.lithan.Mealsonwheelsbackend.entity.Rider;

public interface RiderRepository extends JpaRepository<Rider, Long>{

	
	Optional<Rider> findById(Long partnerId);

	Rider findByEmail(String email);

	List<Rider> findByApprovedFalse();

	List<Rider> findByApprovedTrue();
	
}
