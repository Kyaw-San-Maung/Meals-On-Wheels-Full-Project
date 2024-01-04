package com.lithan.Mealsonwheelsbackend.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithan.Mealsonwheelsbackend.entity.Member;
import com.lithan.Mealsonwheelsbackend.entity.Partner;
import com.lithan.Mealsonwheelsbackend.entity.User;

public interface PartnerRepository extends JpaRepository<Partner, Long>{

	Partner findByCompanyName(String companyName);
	
	Optional<Partner> findById(Long partnerId);

	Partner findByEmail(String email);

	List<Partner> findByApprovedFalse();

	List<Partner> findByApprovedTrue();
	
}
