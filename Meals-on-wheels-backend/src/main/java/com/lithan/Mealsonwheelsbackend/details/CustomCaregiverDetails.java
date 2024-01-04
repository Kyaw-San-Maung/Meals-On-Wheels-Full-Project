package com.lithan.Mealsonwheelsbackend.details;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@SuppressWarnings("serial")
public class CustomCaregiverDetails extends User{
	
	private String email;
	private Long caregiverId;
	
    public CustomCaregiverDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String email, Long caregiverId) {
        super(username, password, authorities);
        this.email = email;
        this.caregiverId = caregiverId;        
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

	public String getEmail() {
		return email;
	}


	public Long getCaregiverId() {
		return caregiverId;
	}

}
