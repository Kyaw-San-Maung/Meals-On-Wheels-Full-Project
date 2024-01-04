package com.lithan.Mealsonwheelsbackend.requests;

public class OrderRequest {

    private Long id;
    private String memberName;
    private String memberAddress;
    private String memberLocation;
    private String mealName;
    private String orderDate;
    private String riderName;

    // Constructors, getters, and setters

    public OrderRequest() {
    }

    public OrderRequest(Long id, String memberName, String memberAddress, String memberLocation, String mealName, String orderDate) {
		this.id = id;
		this.memberName = memberName;
		this.memberAddress = memberAddress;
		this.memberLocation = memberLocation;
		this.mealName = mealName;
		this.orderDate = orderDate;
	}

	public Long getId() {
		return id;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getMealName() {
		return mealName;
	}

	public void setMealName(String mealName) {
		this.mealName = mealName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getRiderName() {
		return riderName;
	}

	public void setRiderName(String riderName) {
		this.riderName = riderName;
	}


}
