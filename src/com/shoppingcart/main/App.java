package com.shoppingcart.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.shoppingcart.beans.Product;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/shoppingcart/main/Beans.xml");
		Product p = (Product)context.getBean("product");
		System.out.println(p.toString());
		((ClassPathXmlApplicationContext)context).close();
	}

}
