package com.jobportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@GetMapping("/login")
	public String admin(@RequestParam String email, @RequestParam String password) {

		return adminService.login(email, password);

	}

	@GetMapping("/approve") // admin approving hr account
	public String approve(@RequestParam String status, @RequestParam int id) {
		return adminService.approve(status, id);
	}

}
