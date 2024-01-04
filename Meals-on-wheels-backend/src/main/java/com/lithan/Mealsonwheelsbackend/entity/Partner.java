package com.lithan.Mealsonwheelsbackend.entity;

import javax.persistence.DiscriminatorValue;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PARTNER")
public class Partner extends User{
	
	private String companyName;
	
	private String companyDes;
	
	private String companyLocation;
	
    public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

	@OneToMany(mappedBy = "partner", cascade = CascadeType.ALL)
	@JsonBackReference
    private List<Meal> providedMeals = new ArrayList<>();

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyDes() {
		return companyDes;
	}

	public void setCompanyDes(String companyDes) {
		this.companyDes = companyDes;
	}

	public List<Meal> getProvidedMeals() {
		return providedMeals;
	}

	public void setProvidedMeals(List<Meal> providedMeals) {
		this.providedMeals = providedMeals;
	}
    
    
    
}
