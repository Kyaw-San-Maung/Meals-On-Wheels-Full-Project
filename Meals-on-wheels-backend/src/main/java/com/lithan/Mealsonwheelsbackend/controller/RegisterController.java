package com.lithan.Mealsonwheelsbackend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lithan.Mealsonwheelsbackend.entity.Partner;
import com.lithan.Mealsonwheelsbackend.entity.Volunteer;
import com.lithan.Mealsonwheelsbackend.repo.AdminRepository;
import com.lithan.Mealsonwheelsbackend.repo.CaregiverRepository;
import com.lithan.Mealsonwheelsbackend.repo.MemberRepository;
import com.lithan.Mealsonwheelsbackend.repo.PartnerRepository;
import com.lithan.Mealsonwheelsbackend.requests.CaregiverRegistrationRequest;
import com.lithan.Mealsonwheelsbackend.requests.LoginRequest;
import com.lithan.Mealsonwheelsbackend.requests.MemberRegistrationRequest;
import com.lithan.Mealsonwheelsbackend.requests.PartnerRegistrationRequest;
import com.lithan.Mealsonwheelsbackend.requests.RiderRegistrationRequest;
import com.lithan.Mealsonwheelsbackend.requests.VolunteerRegistrationRequest;
import com.lithan.Mealsonwheelsbackend.service.RegistrationService;
@CrossOrigin(origins = {"http://localhost:5173"})
@RestController
@RequestMapping("/user-api")
public class RegisterController {

	
    private final MemberRepository memberRepository;
    private final RegistrationService registrationService;
    private final PartnerRepository partnerRepository;
    private final CaregiverRepository caregiverRepository;
    private final AdminRepository adminRepository;

    public RegisterController(MemberRepository userRepository, RegistrationService registrationService, PartnerRepository partnerRepository, CaregiverRepository caregiverRepository, AdminRepository adminRepository) {
    	this.memberRepository = userRepository;
        this.registrationService = registrationService;
        this.partnerRepository = partnerRepository;
        this.caregiverRepository = caregiverRepository;
        this.adminRepository = adminRepository;
    }
    
    @PostMapping("/member/register")
    public ResponseEntity<String> memberRegister(@RequestBody MemberRegistrationRequest memberRegistrationRequest) {
        // Check if the username is already taken
        if (memberRepository.findByEmail(memberRegistrationRequest.getEmail()) != null) {
        	
            return ResponseEntity.status(400).body("Account with this email already exist");
            
        } else {
        	
            try {
            	
                registrationService.registerMember(memberRegistrationRequest);
                return ResponseEntity.ok("Member registration successful!");
                
            	} catch (Exception e) {
            		
                return ResponseEntity.status(400).body("Member registration failed: " + e.getMessage());
            }
        }
    }
    
    
    @PostMapping("/volunteer/register")
    public ResponseEntity<String> volunteerRegister(@RequestBody VolunteerRegistrationRequest volunteerRegistrationRequest) {
        
        if (memberRepository.findByEmail(volunteerRegistrationRequest.getEmail()) != null) {
        	
            return ResponseEntity.status(400).body("Account with this email already exist");
            
        } else {
        	
            try {
            	
                registrationService.registerVolunteer(volunteerRegistrationRequest);
                return ResponseEntity.ok("Volunteer registration is pending!");
                
            	} catch (Exception e) {
            		
                return ResponseEntity.status(400).body("Volunteer registration failed: " + e.getMessage());
            }
        }
    }
    
    @PostMapping("/admin/register")
    public ResponseEntity<String> registerAdmin(@RequestBody LoginRequest loginRequest) {
        // Check if the username is already taken
        if (adminRepository.findByEmail(loginRequest.getEmail()) != null) {
        	
            return ResponseEntity.status(400).body("Account with this email already exist");
            
        } else {
        	
            try {
            	
                registrationService.registerAdmin(loginRequest);
                return ResponseEntity.ok("Volunteer registration is pending!");
                
            	} catch (Exception e) {
            		
                return ResponseEntity.status(400).body("Volunteer registration failed: " + e.getMessage());
            }
        }
    }
    
    @PostMapping("/partner/register")
    public ResponseEntity<String> partnerRegister(@RequestBody PartnerRegistrationRequest partnerRegistrationRequest) {
        // Check if the username is already taken
        if (partnerRepository.findByEmail(partnerRegistrationRequest.getEmail()) != null) {
        	
            return ResponseEntity.status(400).body("Account with this email already exist");
            
        } else {
        	
            try {
            	
                registrationService.registerPartner(partnerRegistrationRequest);
                return ResponseEntity.ok("Registration is pending!");
                
            	} catch (Exception e) {
            		
                return ResponseEntity.status(400).body("Partner registration failed: " + e.getMessage());
            }
        }
    }
    
    @PostMapping("/rider/register")
    public ResponseEntity<String> riderRegister(@RequestBody RiderRegistrationRequest riderRegistrationRequest) {
        // Check if the username is already taken
        if (partnerRepository.findByEmail(riderRegistrationRequest.getEmail()) != null) {
        	
            return ResponseEntity.status(400).body("Account with this email already exist");
            
        } else {
        	
            try {
            	
                registrationService.registerRider(riderRegistrationRequest);
                return ResponseEntity.ok("Registration is pending!");
                
            	} catch (Exception e) {
            		
                return ResponseEntity.status(400).body("Rider registration failed: " + e.getMessage());
            }
        }
    }
    
    
    @PostMapping("/caregiver/register")
    public ResponseEntity<String> caregiverRegister(@RequestBody CaregiverRegistrationRequest caregiverRegistrationRequest) {
        // Check if the username is already taken
        if (caregiverRepository.findByEmail(caregiverRegistrationRequest.getEmail()) != null) {
        	
            return ResponseEntity.status(400).body("Account with this email already exist");
            
        } else {
        	
            try {
            	
                registrationService.registerCaregiver(caregiverRegistrationRequest);
                return ResponseEntity.ok("Registration is pending!");
                
            	} catch (Exception e) {
            		
                return ResponseEntity.status(400).body("Caregiver registration failed: " + e.getMessage());
            }
        }
    }
}
