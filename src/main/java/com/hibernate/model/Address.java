package com.hibernate.model;

public class Address {
	
	private String street_name;
	private String state;
	private String pincode;
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Address(String street_name, String state, String pincode) {
		super();
		this.street_name = street_name;
		this.state = state;
		this.pincode = pincode;
	}
	public Address() {
		super();
	}
	
	
	
	

}
