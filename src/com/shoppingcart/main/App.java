package com.shoppingcart.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shoppingcart.beans.Product;
import com.shoppingcart.model.Account;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/shoppingcart/main/Beans.xml");
		Product p = (Product) context.getBean("product");
		Account a = (Account) context.getBean("account");

		List<Product> list = a.getAllProducts();
		p = a.getOneProduct(3);
		
//		for(Product p1 : list){
//			System.out.println(p1.getName() + " -- " + p1.getPrice() + " -- " + p1.getDesc());
//		}
		
		System.out.println(p.getName() + " -- " + p.getPrice() + " -- " + p.getDesc());

		((ClassPathXmlApplicationContext) context).close();
	}

}
