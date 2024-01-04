package com.lithan.Mealsonwheelsbackend.details;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

@SuppressWarnings("serial")
public class CustomAdminDetails extends User{
	
	private String email;

	
    public CustomAdminDetails(String username, String password, Collection<? extends GrantedAuthority> authorities, String email) {
        super(username, password, authorities);
        this.email = email;      
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


}
