package com.lithan.Mealsonwheelsbackend.details;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomPartnerDetails extends User{
	
	private String email;
	private String companyName;
	private String companyDes;
	private String phoneNumber;
	private Long partnerId;
	

    
    public CustomPartnerDetails(String username, String password, String phoneNumber, Collection<? extends GrantedAuthority> authorities, String email, String companyName, String companyDes, Long partnerId) {
        super(username, password, authorities);
        this.phoneNumber = phoneNumber;
        this.companyName = companyName;
        this.companyDes = companyDes;
        this.email = email;
        this.partnerId = partnerId;
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

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanyDes() {
		return companyDes;
	}

	public String getEmail() {
		return email;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public Long getPartnerId() {
		return partnerId;
	}

}
