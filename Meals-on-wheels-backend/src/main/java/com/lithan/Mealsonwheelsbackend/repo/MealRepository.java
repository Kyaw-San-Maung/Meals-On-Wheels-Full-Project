package com.lithan.Mealsonwheelsbackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lithan.Mealsonwheelsbackend.entity.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {
	 
	
}
