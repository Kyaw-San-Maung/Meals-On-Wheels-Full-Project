package com.lithan.Mealsonwheelsbackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lithan.Mealsonwheelsbackend.entity.Caregiver;
import com.lithan.Mealsonwheelsbackend.entity.Member;
import com.lithan.Mealsonwheelsbackend.entity.Partner;
import com.lithan.Mealsonwheelsbackend.entity.Rider;
import com.lithan.Mealsonwheelsbackend.entity.User;
import com.lithan.Mealsonwheelsbackend.entity.Volunteer;
import com.lithan.Mealsonwheelsbackend.repo.CaregiverRepository;
import com.lithan.Mealsonwheelsbackend.repo.MemberRepository;
import com.lithan.Mealsonwheelsbackend.repo.PartnerRepository;
import com.lithan.Mealsonwheelsbackend.repo.RiderRepository;
import com.lithan.Mealsonwheelsbackend.repo.UserRepository;
import com.lithan.Mealsonwheelsbackend.repo.VolunteerRepository;
import com.lithan.Mealsonwheelsbackend.requests.VolunteerRegistrationRequest;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;
    
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

    public List<Member> getPendingMemberRegistrations() {
        return memberRepository.findByApprovedFalse();
    }
    
    public List<Member> getApprovedMembers() {
        return memberRepository.findByApprovedTrue();
    }
    
    public List<Partner> getPendingPartnerRegistrations() {
        List<Partner> pendingPartner = partnerRepository.findByApprovedFalse();
        return pendingPartner;
    }
    
    public List<Partner> getApprovedPartners() {
        return partnerRepository.findByApprovedTrue();
    }
    
    public List<Volunteer> getPendingVolunteerRegistrations() {
        List<Volunteer> pendingVolunteer = volunteerRepository.findByApprovedFalse();
        return pendingVolunteer;
    }
    
    public List<Volunteer> getApprovedVolunteers() {
        List<Volunteer> volunteers = volunteerRepository.findByApprovedFalse();
        return volunteers;
    }
    
    public List<Caregiver> getPendingCaregiverRegistrations() {
        List<Caregiver> pendingCaregiver = caregiverRepository.findByApprovedFalse();
        return pendingCaregiver;
    }
    
    public List<Caregiver> getApprovedCaregivers() {
        List<Caregiver> caregivers = caregiverRepository.findByApprovedTrue();
        return caregivers;
    }
    
    public List<Rider> getPendingRiderRegistrations() {
        List<Rider> pendingRider = riderRepository.findByApprovedFalse();
        return pendingRider;
    }
    
    public List<Rider> getApprovedRiders() {
        List<Rider> riders = riderRepository.findByApprovedTrue();
        return riders;
    }


    public void approveRegistration(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setApproved(true);
            // You might want to perform additional actions, such as sending a notification to the user.
           userRepository.save(user);
        }
    }

    public void rejectRegistration(Long userId) {
        // Delete the user with the specified memberId
        userRepository.deleteById(userId);
    }
}
