package com.lithan.Mealsonwheelsbackend.requests;

public class PartnerRegistrationRequest extends LoginRequest {
	
	private String companyName;
	
	private String companyDes;
	
	private String companyLocation;

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
	}

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


    
}
