package com.lithan.Mealsonwheelsbackend.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mealName;
    // Other fields specific to a meal

    private String mealPhoto;
    
    private String mealDesc;
    
    @ManyToOne
    @JoinColumn(name = "partner_id")
    @JsonManagedReference
    private Partner partner;
    
    @OneToMany(mappedBy = "meal")
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();

    // Constructors, getters, and setters

    // Example constructor and getters/setters (implement as needed)
    public Meal() {
    }

    public Meal(String mealName) {
        this.mealName = mealName;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public Partner getPartner() {
		return partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public String getMealPhoto() {
		return mealPhoto;
	}

	public void setMealPhoto(String mealPhoto) {
		this.mealPhoto = mealPhoto;
	}

	public String getMealDesc() {
		return mealDesc;
	}

	public void setMealDesc(String mealDesc) {
		this.mealDesc = mealDesc;
	}

    
}

