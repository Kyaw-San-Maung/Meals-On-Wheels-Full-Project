package com.lithan.Mealsonwheelsbackend.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithan.Mealsonwheelsbackend.entity.Caregiver;

public interface CaregiverRepository extends JpaRepository<Caregiver, Long> {

	Caregiver findByEmail(String email);

	List<Caregiver> findByApprovedFalse();

	List<Caregiver> findByApprovedTrue();

}
