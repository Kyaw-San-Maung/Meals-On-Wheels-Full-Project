package com.lithan.Mealsonwheelsbackend.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lithan.Mealsonwheelsbackend.entity.Meal;
import com.lithan.Mealsonwheelsbackend.entity.Member;
import com.lithan.Mealsonwheelsbackend.entity.Order;
import com.lithan.Mealsonwheelsbackend.entity.Partner;
import com.lithan.Mealsonwheelsbackend.repo.MealRepository;
import com.lithan.Mealsonwheelsbackend.repo.MemberRepository;
import com.lithan.Mealsonwheelsbackend.repo.OrderRepository;
import com.lithan.Mealsonwheelsbackend.requests.OrderRequest;
@CrossOrigin(origins = {"http://localhost:5173"})
@RestController
@RequestMapping("/order-api")
public class OrderController {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MealRepository mealRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
    @PostMapping("/{memberId}/order/{mealId}")
    public ResponseEntity<Order> createOrder(@PathVariable Long memberId, @PathVariable Long mealId) {
        // Assume OrderRequest contains memberId, mealId, and orderDate
        Optional<Member> optionalMember = memberRepository.findById(memberId);

        Optional<Meal> optionalMeal = mealRepository.findById(mealId);

        if (optionalMember.isPresent() && optionalMeal.isPresent()) {
               Member member = optionalMember.get();
               Meal meal = optionalMeal.get();
               LocalDateTime cur_time = LocalDateTime.now();

               // Format LocalDateTime to a string
               DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
               String formattedDate = cur_time.format(formatter);
               Order order = new Order(member, meal, formattedDate);
               // Save the order to the database
               orderRepository.save(order);
               return ResponseEntity.ok(order);
                } else {
                    throw new EntityNotFoundException("Member and meal not found: ");
                }

        // Create a new orde
    }

	@GetMapping("/orders")
	public List<OrderRequest> allMeals() {
		List<Order> allOrders = orderRepository.findAll();
	    List<OrderRequest> orderDtos = new ArrayList<>();

	    for (Order order : allOrders) {
	    	OrderRequest orderDto = new OrderRequest();
	    	orderDto.setId(order.getId());
	    	orderDto.setMemberName(order.getMember().getUsername());
	    	orderDto.setMemberAddress(order.getMember().getAddress());
	    	orderDto.setMemberLocation(order.getMember().getLocation());
	    	orderDto.setMealName(order.getMeal().getMealName()); // Include meal name in DTO
	    	orderDto.setOrderDate(order.getOrderDate());
	    	
	    	if (order.getRider() != null) {
		    	orderDto.setRiderName(order.getRider().getUsername());
	    	} else {
		    	orderDto.setRiderName("");
	    	}
	    	orderDtos.add(orderDto);
	    }
	    
		return orderDtos;
	}
	
	@GetMapping("/orders/{riderId}")
	public List<OrderRequest> ordersForRider(@PathVariable Long riderId) {
	    List<Order> ordersForRider = orderRepository.findByRiderId(riderId);
	    List<OrderRequest> orderDtos = new ArrayList<>();

	    for (Order order : ordersForRider) {
	        OrderRequest orderDto = new OrderRequest();
	        orderDto.setId(order.getId());
	        orderDto.setMemberName(order.getMember().getUsername());
	        orderDto.setMemberAddress(order.getMember().getAddress());
	        orderDto.setMemberLocation(order.getMember().getLocation());
	        orderDto.setMealName(order.getMeal().getMealName()); // Include meal name in DTO
	        orderDto.setOrderDate(order.getOrderDate());

	        if (order.getRider() != null) {
	            orderDto.setRiderName(order.getRider().getUsername());
	        } else {
	            orderDto.setRiderName("");
	        }
	        orderDtos.add(orderDto);
	    }

	    return orderDtos;
	}
}
