package com.lithan.Mealsonwheelsbackend.details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@SuppressWarnings("serial")
public class CustomRiderDetails extends User{
	
	private String email;
    private String driverLicense;
    private String phoneNumber;
    private Long riderId;
	

    
    public CustomRiderDetails(String username, String password, String phoneNumber, Collection<? extends GrantedAuthority> authorities, String email, String driverLicense, Long riderId) {
        super(username, password, authorities);
        this.driverLicense = driverLicense;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.riderId = riderId;
    }
   

	@Override
    public boolean isAccountNonExpired() {
        return true;  // Implement as needed
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;  // Implement as needed
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;  // Implement as needed
    }

    public String getDriverLicense() {
        return driverLicense;
    }


	public String getEmail() {
		return email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public Long getRiderId() {
		return riderId;
	}
	
}

