package com.lithan.Mealsonwheelsbackend.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VOLUNTEER")
public class Volunteer extends User{
	
	private String availability;
	
	private String qualificationsAndSkills;

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getQualificationsAndSkills() {
		return qualificationsAndSkills;
	}

	public void setQualificationsAndSkills(String qualificationsAndSkills) {
		this.qualificationsAndSkills = qualificationsAndSkills;
	}
	
	
}
