package com.shoppingcart.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoppingcart.model.Account;

@Component("Product")
public class Product {

	private int id;
	private String name;
	private String price;
	private String desc;
	private Vendor vendor;
	private Account account;
	
	
	@Autowired
	public void setAccount(Account account) {
		this.account = account;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Vendor getVendor() {
		return vendor;
	}

	@Autowired
	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", vendor=" + vendor
				+ "]";
	}

	public List<Product> getAllProducts(){
		return account.getAllProducts();
	}
	
	public Product getOneProduct(int id){
		return account.getOneProduct(id);
	}
}
