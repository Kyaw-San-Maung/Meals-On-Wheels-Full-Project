package com.lithan.Mealsonwheelsbackend.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lithan.Mealsonwheelsbackend.entity.Caregiver;
import com.lithan.Mealsonwheelsbackend.entity.Meal;
import com.lithan.Mealsonwheelsbackend.entity.Member;
import com.lithan.Mealsonwheelsbackend.entity.Order;
import com.lithan.Mealsonwheelsbackend.entity.Partner;
import com.lithan.Mealsonwheelsbackend.entity.Rider;
import com.lithan.Mealsonwheelsbackend.entity.User;
import com.lithan.Mealsonwheelsbackend.entity.Volunteer;
import com.lithan.Mealsonwheelsbackend.repo.CaregiverRepository;
import com.lithan.Mealsonwheelsbackend.repo.MemberRepository;
import com.lithan.Mealsonwheelsbackend.repo.OrderRepository;
import com.lithan.Mealsonwheelsbackend.repo.PartnerRepository;
import com.lithan.Mealsonwheelsbackend.repo.RiderRepository;
import com.lithan.Mealsonwheelsbackend.repo.VolunteerRepository;
import com.lithan.Mealsonwheelsbackend.requests.MemberRequest;
import com.lithan.Mealsonwheelsbackend.requests.OrderRequest;
import com.lithan.Mealsonwheelsbackend.service.AdminService;
@CrossOrigin(origins = {"http://localhost:5173"})
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private VolunteerRepository voluntRepo;
    
    @Autowired
    private PartnerRepository partnerRepo;
    
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RiderRepository riderRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private CaregiverRepository caregiverRepository;
	

    @GetMapping("/pending-member-registrations")
    public List<Member> getPendingMemberRegistrations() {
        return adminService.getPendingMemberRegistrations();
    }
    
    @GetMapping("/pending-partner-registrations")
    public List<Partner> getPendingPartnerRegistrations() {
        return adminService.getPendingPartnerRegistrations();
    }
    
    @GetMapping("/pending-volunteer-registrations")
    public List<Volunteer> getPendingVounteerRegistrations() {
        return adminService.getPendingVolunteerRegistrations();
    }
    
    @GetMapping("/pending-caregiver-registrations")
    public List<Caregiver> getPendingCaregiverRegistrations() {
        return adminService.getPendingCaregiverRegistrations();
    }
    
    @GetMapping("/pending-rider-registrations")
    public List<Rider> getPendingRiderRegistrations() {
        return adminService.getPendingRiderRegistrations();
    }

    @GetMapping("/members")
    public List<MemberRequest> getAllMembers() {
		List<Member> allMembers = memberRepository.findAll();
	    List<MemberRequest> memberDtos = new ArrayList<>();

	    for (Member member : allMembers) {
	    	MemberRequest memberDto = new MemberRequest();
	    	memberDto.setId(member.getId());
	    	memberDto.setUsername(member.getUsername());
	    	memberDto.setPhoneNumber(member.getPhoneNumber());
	    	memberDto.setEmail(member.getEmail());
	    	memberDto.setMemberAddress(member.getAddress());
	    	memberDto.setMemberLocation(member.getLocation()); // Include meal name in DTO
	    	
	    	if (member.getCaregiver() != null) {
		    	memberDto.setCaregiverName(member.getCaregiver().getUsername());
	    	} else {
	    		memberDto.setCaregiverName("");
	    	}
	    	memberDtos.add(memberDto);
	    }
	    
		return memberDtos;
    }
    
    @GetMapping("/members/{caregiverId}")
    public List<MemberRequest> getMembersAssignedtoCaregiver(@PathVariable Long caregiverId) {
    	List<Member> members = memberRepository.findByCaregiverId(caregiverId);
	    List<MemberRequest> memberDtos = new ArrayList<>();

	    for (Member member : members) {
	    	MemberRequest memberDto = new MemberRequest();
	    	memberDto.setId(member.getId());
	    	memberDto.setUsername(member.getUsername());
	    	memberDto.setPhoneNumber(member.getPhoneNumber());
	    	memberDto.setEmail(member.getEmail());
	    	memberDto.setMemberAddress(member.getAddress());
	    	memberDto.setMemberLocation(member.getLocation()); // Include meal name in DTO
	    	
	    	if (member.getCaregiver() != null) {
		    	memberDto.setCaregiverName(member.getCaregiver().getUsername());
	    	} else {
	    		memberDto.setCaregiverName("");
	    	}
	    	memberDtos.add(memberDto);
	    }
	    
		return memberDtos;
    }
    
    // getting All Volunteer Info
    @GetMapping("/volunteerGetall")
    public List<Volunteer> getVolunteerInfoAll() {
        return voluntRepo.findAll();
    }
    
    @GetMapping("/partnerGetAll")
    public List<Partner> getPartnerInfoAll() {
        return partnerRepo.findAll();
    }
    
    @GetMapping("/riderGetAll")
    public List<Rider> getRiderInfoAll() {
        return riderRepository.findAll();
    }
    
    @GetMapping("/approved-rider")
    public List<Rider> getApprovedRiders() {
        return adminService.getApprovedRiders();
    }

    
    @PostMapping("/approve-registration/{userId}")
    public void approveRegistration(@PathVariable Long userId) {
        adminService.approveRegistration(userId);
    }

    @PostMapping("/reject-registration/{userId}")
    public void rejectRegistration(@PathVariable Long userId) {
        adminService.rejectRegistration(userId);
    }
    
    @PostMapping("/{orderId}/assign-rider/{riderId}")
    public ResponseEntity<String> assignRiderToOrder(@PathVariable Long orderId, @PathVariable Long riderId) {
        // Retrieve order and rider from the database
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
 
        Optional<Rider> optionalRider = riderRepository.findById(riderId);
 
        if (optionalOrder.isPresent() && optionalRider.isPresent()) {
        	Order order = optionalOrder.get();
        	Rider rider = optionalRider.get();
        	
            // Assign the rider to the order
            order.setRider(rider);

            // Save the updated order to the database
            orderRepository.save(order);
            
            return ResponseEntity.ok(rider.getUsername());

        } else {
        	throw new EntityNotFoundException("Order and rider not found: ");
        }
    }
    
    
    @PostMapping("/{memberId}/assign-caregiver/{caregiverId}")
    public ResponseEntity<String> assignCaregiverToMember(@PathVariable Long memberId, @PathVariable Long caregiverId) {
        // Retrieve order and rider from the database
        Optional<Member> optionalMember = memberRepository.findById(memberId);
 
        Optional<Caregiver> optionalCaregiver = caregiverRepository.findById(caregiverId);
 
        if (optionalMember.isPresent() && optionalCaregiver.isPresent()) {
        	Member member = optionalMember.get();
        	Caregiver caregiver = optionalCaregiver.get();
        	
            // Assign the rider to the order
            member.setCaregiver(caregiver);

            // Save the updated order to the database
            memberRepository.save(member);
            
            return ResponseEntity.ok(caregiver.getUsername());

        } else {
        	throw new EntityNotFoundException("Order and rider not found: ");
        }
    }
}



