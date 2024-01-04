package com.lithan.Mealsonwheelsbackend.entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DiscriminatorValue("CAREGIVER")
public class Caregiver extends User{
	
	private String caregiverQualificationandSkills;
	
    @OneToMany(mappedBy = "caregiver")
    @JsonManagedReference
    private List<Member> memberUnderCare;

	public List<Member> getMemberUnderCare() {
		return memberUnderCare;
	}

	public void setMemberUnderCare(List<Member> memberUnderCare) {
		this.memberUnderCare = memberUnderCare;
	}

	public String getCaregiverQualificationandSkills() {
		return caregiverQualificationandSkills;
	}

	public void setCaregiverQualificationandSkills(String caregiverQualificationandSkills) {
		this.caregiverQualificationandSkills = caregiverQualificationandSkills;
	}
    
    
    
}
