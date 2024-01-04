package com.lithan.Mealsonwheelsbackend.details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomVolunteerDetails extends User{
	
	private String email;
	private String availability;
	private String qualificationsAndSkills;
	private String phoneNumber;
	private Long volunteerId;

    
    public CustomVolunteerDetails(String username, String password, String phoneNumber, Collection<? extends GrantedAuthority> authorities, String email, String availability, String qualificationsAndSkills, Long volunteerId) {
        super(username, password, authorities);
        this.availability = availability;
        this.qualificationsAndSkills = qualificationsAndSkills;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.volunteerId = volunteerId;
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

	public String getAvailability() {
		return availability;
	}

	public String getQualificationsAndSkills() {
		return qualificationsAndSkills;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}


	public Long getVolunteerId() {
		return volunteerId;
	}

	
}
