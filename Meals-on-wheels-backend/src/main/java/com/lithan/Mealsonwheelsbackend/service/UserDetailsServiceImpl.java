package com.lithan.Mealsonwheelsbackend.service;

import java.util.List;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lithan.Mealsonwheelsbackend.details.CustomAdminDetails;
import com.lithan.Mealsonwheelsbackend.details.CustomCaregiverDetails;
import com.lithan.Mealsonwheelsbackend.details.CustomMemberDetails;
import com.lithan.Mealsonwheelsbackend.details.CustomPartnerDetails;
import com.lithan.Mealsonwheelsbackend.details.CustomRiderDetails;
import com.lithan.Mealsonwheelsbackend.details.CustomVolunteerDetails;
import com.lithan.Mealsonwheelsbackend.entity.Admin;
import com.lithan.Mealsonwheelsbackend.entity.Caregiver;
import com.lithan.Mealsonwheelsbackend.entity.Member;
import com.lithan.Mealsonwheelsbackend.entity.Partner;
import com.lithan.Mealsonwheelsbackend.entity.Rider;
import com.lithan.Mealsonwheelsbackend.entity.User;
import com.lithan.Mealsonwheelsbackend.entity.Volunteer;
import com.lithan.Mealsonwheelsbackend.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

       
        switch (user.getUserType()) {
        case "MEMBER":
            Member member = (Member) user;
            return buildUserDetailsForMember(member);
        case "VOLUNTEER":
            Volunteer volunteer = (Volunteer) user;
            return buildUserDetailsForVolunteer(volunteer);
        case "PARTNER":
            Partner partner = (Partner) user;
            return buildUserDetailsForPartner(partner);
        case "RIDER":
            Rider rider = (Rider) user;
            return buildUserDetailsForRider(rider);
        case "CAREGIVER":
            Caregiver caregiver = (Caregiver) user;
            return buildUserDetailsForCaregiver(caregiver);
        case "ADMIN":
            Admin admin = (Admin) user;
            return buildUserDetailsForAdmin(admin);
        default:
            throw new UsernameNotFoundException("User not found with email: " + email);
    }
    }
    
    private UserDetails buildUserDetailsForMember(Member member) {
    	
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_" + member.getUserType());

        return new CustomMemberDetails(
                member.getUsername(),
                member.getPassword(),
                member.getPhoneNumber(),
                authorities,
                member.getEmail(),
                member.getAddress(), 
                member.getLocation(),
                member.getId()
        );
    }

    private UserDetails buildUserDetailsForVolunteer(Volunteer volunteer) {
    	
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_" + volunteer.getUserType());

        return new CustomVolunteerDetails(
        		volunteer.getUsername(),
        		volunteer.getPassword(),
        		volunteer.getPhoneNumber(),
                authorities,
                volunteer.getEmail(),
                volunteer.getAvailability(),
                volunteer.getQualificationsAndSkills(),
                volunteer.getId()
        );
    }
    
    private UserDetails buildUserDetailsForPartner(Partner partner) {
    	
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_" + partner.getUserType());

        return new CustomPartnerDetails(
        		partner.getUsername(),
        		partner.getPassword(),
        		partner.getPhoneNumber(),
                authorities,
                partner.getEmail(),
                partner.getCompanyName(),
                partner.getCompanyDes(),
                partner.getId()
        );
    }
    
    
    private UserDetails buildUserDetailsForRider(Rider rider) {
    	
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_" + rider.getUserType());

        return new CustomRiderDetails(
        		rider.getUsername(),
        		rider.getPassword(),
        		rider.getPhoneNumber(),
                authorities,
                rider.getEmail(),
                rider.getDriverLicense(),
                rider.getId()
        );
    }
    
    
    private UserDetails buildUserDetailsForCaregiver(Caregiver caregiver) {
    	
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_" + caregiver.getUserType());

        return new CustomCaregiverDetails(
        		caregiver.getUsername(),
        		caregiver.getPassword(),
                authorities,
                caregiver.getEmail(),
                caregiver.getId()
        );
    }
    
    private UserDetails buildUserDetailsForAdmin(Admin admin) {
    	
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_" + admin.getUserType());

        return new CustomAdminDetails(
        		admin.getUsername(),
        		admin.getPassword(),
                authorities,
                admin.getEmail()
        );
    }
    
}

