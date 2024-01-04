package com.lithan.Mealsonwheelsbackend.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lithan.Mealsonwheelsbackend.entity.Admin;
import com.lithan.Mealsonwheelsbackend.entity.Caregiver;
import com.lithan.Mealsonwheelsbackend.entity.Member;
import com.lithan.Mealsonwheelsbackend.entity.Partner;
import com.lithan.Mealsonwheelsbackend.entity.Rider;
import com.lithan.Mealsonwheelsbackend.entity.Role;
import com.lithan.Mealsonwheelsbackend.entity.Volunteer;
import com.lithan.Mealsonwheelsbackend.repo.AdminRepository;
import com.lithan.Mealsonwheelsbackend.repo.CaregiverRepository;
import com.lithan.Mealsonwheelsbackend.repo.MemberRepository;
import com.lithan.Mealsonwheelsbackend.repo.PartnerRepository;
import com.lithan.Mealsonwheelsbackend.repo.RiderRepository;
import com.lithan.Mealsonwheelsbackend.repo.RoleRepository;
import com.lithan.Mealsonwheelsbackend.repo.VolunteerRepository;
import com.lithan.Mealsonwheelsbackend.requests.CaregiverRegistrationRequest;
import com.lithan.Mealsonwheelsbackend.requests.LoginRequest;
import com.lithan.Mealsonwheelsbackend.requests.MemberRegistrationRequest;
import com.lithan.Mealsonwheelsbackend.requests.PartnerRegistrationRequest;
import com.lithan.Mealsonwheelsbackend.requests.RiderRegistrationRequest;
import com.lithan.Mealsonwheelsbackend.requests.VolunteerRegistrationRequest;


@Service
public class RegistrationService {

	 @Autowired
	 private MemberRepository memberRepository;
	 
	 @Autowired
	 private VolunteerRepository volunteerRepository;
	 
	 @Autowired
	 private PartnerRepository partnerRepository;
	 
	 @Autowired
	 private RiderRepository riderRepository;
	 
	 @Autowired
	 private CaregiverRepository caregiverRepository;
	 
	 @Autowired
	 private AdminRepository adminRepository;
	 
	 private final PasswordEncoder passwordEncoder;

	    public RegistrationService(PasswordEncoder passwordEncoder) {
	        this.passwordEncoder = passwordEncoder;
	    }
	 
	    public void registerMember(MemberRegistrationRequest memberRegistrationRequest) {
	        Member newUser = new Member();
	        newUser.setUsername(memberRegistrationRequest.getUsername());
	        newUser.setPassword(passwordEncoder.encode(memberRegistrationRequest.getPassword()));
	        newUser.setEmail(memberRegistrationRequest.getEmail());
	        newUser.setAddress(memberRegistrationRequest.getAddress());
	        newUser.setLocation(memberRegistrationRequest.getLocation());;
	        newUser.setUserType("MEMBER");
	        newUser.setApproved(true);
	        memberRepository.save(newUser);
	    }
	    
	    public void registerVolunteer(VolunteerRegistrationRequest volunteerRegistrationRequest) {
	        Volunteer newUser = new Volunteer();
	        newUser.setUsername(volunteerRegistrationRequest.getUsername());
	        newUser.setPassword(passwordEncoder.encode(volunteerRegistrationRequest.getPassword()));
	        newUser.setEmail(volunteerRegistrationRequest.getEmail());
	        newUser.setAvailability(volunteerRegistrationRequest.getAvailability());
	        newUser.setQualificationsAndSkills(volunteerRegistrationRequest.getQualificationsAndSkills());;
	        newUser.setUserType("VOLUNTEER");
	        newUser.setApproved(true);
	        volunteerRepository.save(newUser);
	    }
	    
	    public void registerPartner(PartnerRegistrationRequest partnerRegistrationRequest) {
	    	Partner newUser = new Partner();
	        newUser.setUsername(partnerRegistrationRequest.getUsername());
	        newUser.setPassword(passwordEncoder.encode(partnerRegistrationRequest.getPassword()));
	        newUser.setEmail(partnerRegistrationRequest.getEmail());
	        newUser.setCompanyName(partnerRegistrationRequest.getCompanyName());
	        newUser.setCompanyDes(partnerRegistrationRequest.getCompanyDes());
	        newUser.setCompanyLocation(partnerRegistrationRequest.getCompanyLocation());;
	        newUser.setUserType("PARTNER");
	        newUser.setApproved(true);
	        partnerRepository.save(newUser);
	    }
	    
	    public void registerRider(RiderRegistrationRequest riderRegistrationRequest) {
	    	Rider newUser = new Rider();
	        newUser.setUsername(riderRegistrationRequest.getUsername());
	        newUser.setPassword(passwordEncoder.encode(riderRegistrationRequest.getPassword()));
	        newUser.setEmail(riderRegistrationRequest.getEmail());
	        newUser.setDriverLicense(riderRegistrationRequest.getDriverLicense());
	        newUser.setUserType("RIDER");
	        newUser.setApproved(true);
	        riderRepository.save(newUser);
	    }
	    
	    public void registerCaregiver(CaregiverRegistrationRequest caregiverRegistrationRequest) {
	    	Caregiver newUser = new Caregiver();
	        newUser.setUsername(caregiverRegistrationRequest.getUsername());
	        newUser.setPassword(passwordEncoder.encode(caregiverRegistrationRequest.getPassword()));
	        newUser.setEmail(caregiverRegistrationRequest.getEmail());
	        newUser.setCaregiverQualificationandSkills(caregiverRegistrationRequest.getCaregiverQualificationandSkills());
	        newUser.setUserType("CAREGIVER");
	        newUser.setApproved(true);
	        caregiverRepository.save(newUser);
	    }
	    public void registerAdmin(LoginRequest loginRequest) {
	        Admin newUser = new Admin();
	        newUser.setUsername(loginRequest.getUsername());
	        newUser.setPassword(passwordEncoder.encode(loginRequest.getPassword()));
	        newUser.setEmail(loginRequest.getEmail());
	        newUser.setUserType("ADMIN");
	        newUser.setApproved(true);
	        adminRepository.save(newUser);
	    }
	    
}
