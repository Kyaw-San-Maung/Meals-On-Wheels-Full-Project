package com.lithan.Mealsonwheelsbackend.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@DiscriminatorValue("MEMBER")
public class Member extends User{

	private String address;
	
	private String location;

    @OneToMany(mappedBy = "member")
    @JsonManagedReference
    private List<Order> orders = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(name = "caregiver_id")
    @JsonBackReference
    private Caregiver caregiver;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Caregiver getCaregiver() {
		return caregiver;
	}

	public void setCaregiver(Caregiver caregiver) {
		this.caregiver = caregiver;
	}
	
	
    
}
