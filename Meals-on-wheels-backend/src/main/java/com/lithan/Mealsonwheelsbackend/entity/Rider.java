package com.lithan.Mealsonwheelsbackend.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DiscriminatorValue("RIDER")
public class Rider extends User{
	
	private String driverLicense;

    @OneToMany(mappedBy = "rider")
    @JsonManagedReference
    private List<Order> deliveredOrders;
	
	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

	public List<Order> getDeliveredOrders() {
		return deliveredOrders;
	}

	public void setDeliveredOrders(List<Order> deliveredOrders) {
		this.deliveredOrders = deliveredOrders;
	}
	
	

}
