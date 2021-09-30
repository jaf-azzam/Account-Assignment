package com.example.demo.account;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//@Entity
public class Address {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	Integer id;
	
//	@OneToMany(targetEntity = Account.class, mappedBy = "id", fetch = FetchType.EAGER)
	
	private String city;
	private String state;
	private int pin;
	
	
	
	
	
	public Address(String city, String state, int pin) {
		super();
		this.city = city;
		this.state = state;
		this.pin = pin;
	}
	
	public Address() {
		
	}
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
}

