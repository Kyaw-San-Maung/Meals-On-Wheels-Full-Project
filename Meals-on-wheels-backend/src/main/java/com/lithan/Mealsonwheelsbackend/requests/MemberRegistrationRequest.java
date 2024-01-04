package com.lithan.Mealsonwheelsbackend.requests;

public class MemberRegistrationRequest extends LoginRequest {
	
	String address;
	
	String location;

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

    
}
