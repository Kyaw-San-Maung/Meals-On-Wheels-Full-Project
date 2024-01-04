package com.lithan.Mealsonwheelsbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lithan.Mealsonwheelsbackend.entity.Caregiver;
import com.lithan.Mealsonwheelsbackend.entity.Meal;
import com.lithan.Mealsonwheelsbackend.repo.CaregiverRepository;

@CrossOrigin(origins = {"http://localhost:5173"})
@RestController
@RequestMapping("/caregiver-api")
public class CaregiverController {
	
	@Autowired
	CaregiverRepository caregiverRepository;

	@GetMapping("/caregivers")
	public List<Caregiver> allMeals() {
		List<Caregiver> allCaregiver = caregiverRepository.findAll();
		return allCaregiver;
	}
}
