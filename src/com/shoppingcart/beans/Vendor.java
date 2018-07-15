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
	@Pattern(regexp="\\w+\\@\\w+\\.\\w+", message="Please enter valid email")
	private String email;
	@Size(min=4, max=10, message="Size should be between 4 to 10")
	private String password;
	private String enabled;
	private String authority;

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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "Vendor [name=" + name + ", city=" + city + "]";
	}

	public void createVendor(Vendor v) {
		account.createVendor(v);
	}

	
}
