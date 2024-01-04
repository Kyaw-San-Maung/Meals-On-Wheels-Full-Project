package com.lithan.Mealsonwheelsbackend.requests;

public class RiderRegistrationRequest extends LoginRequest{
	
	private String driverLicense;

	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

}
