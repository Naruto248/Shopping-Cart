package com.shoppingcart.beans;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoppingcart.model.Account;

@Component
public class Vendor {
	@Pattern(regexp="\\w+", message="Enter name")
	private String name;
	@Size(min=4, max=10, message="Size should be between 4 to 10")
	private String city;
	@Autowired
	private Account account;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Vendor [name=" + name + ", city=" + city + "]";
	}

	public void createVendor(Vendor v) {
		account.createVendor(v);
	}

	
}
