package com.lithan.Mealsonwheelsbackend.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lithan.Mealsonwheelsbackend.entity.Meal;
import com.lithan.Mealsonwheelsbackend.entity.Member;
import com.lithan.Mealsonwheelsbackend.entity.Order;
import com.lithan.Mealsonwheelsbackend.entity.Partner;
import com.lithan.Mealsonwheelsbackend.entity.Rider;
import com.lithan.Mealsonwheelsbackend.repo.OrderRepository;
import com.lithan.Mealsonwheelsbackend.repo.RiderRepository;
import com.lithan.Mealsonwheelsbackend.requests.OrderRequest;

@CrossOrigin(origins = {"http://localhost:5173"})
@RestController
@RequestMapping("/rider-api")
public class RIderController {

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RiderRepository riderRepository;
	
	@GetMapping("/riders")
	public List<Rider> allRiders() {
		List<Rider> allRiders = riderRepository.findAll();
		return allRiders;
	}
	
	
	
}
