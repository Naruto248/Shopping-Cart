package com.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.shoppingcart.beans.Product;
import com.shoppingcart.beans.Vendor;

@Controller
public class CartController {
	
	@Autowired
	private Product product;
	@Autowired
	private ModelAndView mav;
	@Autowired
	private Vendor vendor;
	
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
		mav.addObject("id", id);
		mav.setViewName("product_desc");
		return mav;
	}
	
	@RequestMapping("/Vendor-Registration")
	public String reqRegister(Model model){
		model.addAttribute("vendor", new Vendor());
		return "vendor_register";
	}
	
	@RequestMapping(value="/vendor-register", method=RequestMethod.POST)
	public String doRegister(Model model, @Valid Vendor v, BindingResult result){
		if(result.hasErrors()){
			return "vendor_register";
		}
		model.addAttribute("name", v.getName());
		model.addAttribute("city", v.getCity());
		//DB insert
		vendor.createVendor(v);
		return "set_password";
	}
}
