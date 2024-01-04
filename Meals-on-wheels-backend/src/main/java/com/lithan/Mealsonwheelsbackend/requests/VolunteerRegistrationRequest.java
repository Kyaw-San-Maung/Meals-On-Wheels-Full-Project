package com.lithan.Mealsonwheelsbackend.requests;

public class VolunteerRegistrationRequest extends LoginRequest{
	
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
