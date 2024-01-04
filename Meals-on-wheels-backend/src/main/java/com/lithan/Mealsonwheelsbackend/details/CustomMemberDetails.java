package com.lithan.Mealsonwheelsbackend.details;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import com.lithan.Mealsonwheelsbackend.entity.Member;


public class CustomMemberDetails extends User{
	
	private String email;
    private String address;
    private String location;
    private String phoneNumber;
    private Long memberId;

    
    public CustomMemberDetails(String username, String password, String phoneNumber, Collection<? extends GrantedAuthority> authorities, String email, String address, String location, Long memberId) {
        super(username, password, authorities);
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.location = location;
        this.email = email;
        this.memberId = memberId;
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


    // Additional methods or getters as needed
    public String getAddress() {
        return address;
    }

    public String getLocation() {
        return location;
    }


	public String getEmail() {
		return email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public Long getMemberId() {
		return memberId;
	}

}
