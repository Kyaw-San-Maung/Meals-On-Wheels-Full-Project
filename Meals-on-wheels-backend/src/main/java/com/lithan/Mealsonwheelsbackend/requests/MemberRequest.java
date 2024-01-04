package com.lithan.Mealsonwheelsbackend.requests;

public class MemberRequest {

    private Long id;
    private String username;
    private String phoneNumber;
    private String email;
    private String memberAddress;
    private String memberLocation;
    private String caregiverName;
    
    public MemberRequest() {
    }
    
	public MemberRequest(Long id, String username, String phoneNumber, String email, String memberAddress,
			String memberLocation, String caregiverName) {
		this.id = id;
		this.username = username;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.memberAddress = memberAddress;
		this.memberLocation = memberLocation;
		this.caregiverName = caregiverName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemberAddress() {
		return memberAddress;
	}

	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}

	public String getMemberLocation() {
		return memberLocation;
	}

	public void setMemberLocation(String memberLocation) {
		this.memberLocation = memberLocation;
	}

	public String getCaregiverName() {
		return caregiverName;
	}

	public void setCaregiverName(String caregiverName) {
		this.caregiverName = caregiverName;
	}
    
    
	
}
