package com.shoppingcart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	
	@RequestMapping("/")
	public String showIndex(Model model){
		model.addAttribute("name", "Abhijeet");
		return "index";
	}
	
	@RequestMapping("/Show-Login")
	public String showLogin(Model model){
		return "login";
	}
}
