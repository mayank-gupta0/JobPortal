package com.jobportal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jobportal.entities.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MainController {

	@RequestMapping("/home")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("user", new User());
	     
	    return "signup_form";
	}
}
