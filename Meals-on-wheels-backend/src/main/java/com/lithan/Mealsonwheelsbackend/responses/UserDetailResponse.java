package com.lithan.Mealsonwheelsbackend.responses;

import com.lithan.Mealsonwheelsbackend.entity.Member;

public class UserDetailResponse extends Member{

	public UserDetailResponse(String username, String address, String email, String location, boolean approved, String password,
			String userType) {
		// TODO Auto-generated constructor stub
	}
    // Getters for properties

    public String getUsername() {
        return getUsername();
    }

    public String getEmail() {
        return getEmail();
    }

    public boolean isApproved() {
        return isApproved();
    }

    public String getUserType() {
        return getUserType();
    }

	public String getAddress() {
		return getAddress();
	}


	public String getLocation() {
		return getLocation();
	}

    
    // Additional getters and setters as needed
}
