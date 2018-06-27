package com.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingcart.beans.Product;

@Controller
public class CartController {
	
	@Autowired
	private Product product;
	
	@RequestMapping("/")
	public String showIndex(Model model){
		model.addAttribute("name", "Abhijeet");
		return "index";
	}
	
	@RequestMapping("/Show-All-Products")
	public String showAllProducts(HttpSession session){
		List<Product> list = product.getAllProducts();
		session.setAttribute("list", list);
		return "products";
	}
	
	@RequestMapping("/Show-Product")
	public ModelAndView showProduct(@ModelAttribute("id") String id){
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.setViewName("product_desc");
		return mav;
	}
}
