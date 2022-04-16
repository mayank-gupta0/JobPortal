package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entities.AdminApproval;
import com.jobportal.repository.AdminRepository;
import com.jobportal.repository.HRRepository;
import com.jobportal.repository.UserRepository;

@Service
public class AdminService {

	@Autowired
	HRRepository hrRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	AdminRepository adminRepository;

	public String login(String email, String password) {

		if (email.equals("admin@gmail.com") && password.equals("root")) {
			return "Welcome Boss";
		} else {
			return "Wrong Username and password";
		}
	}


	public String approve(String status, int id) {
		// TODO Auto-generated method stub
		String x="";
		List<AdminApproval> lst = adminRepository.findAll();
		List<AdminApproval> lst1 = new ArrayList<>(lst);
	
		AdminApproval a=new AdminApproval();
		for (AdminApproval e : lst1) {
			if (e.getApproveHrid() == id) {
				a.setId(e.getId());
				a.setEmail(e.getEmail());
				a.setPhoneNumber(e.getPhoneNumber());
				a.setName(e.getName());
				a.setApprovalStatus(status);
				a.setApproveHrid(e.getApproveHrid());
				adminRepository.save(a);
				x="Status Updated";
			}
			else {
				x="Hr id not found";
			}
		}
		return x;

	}

}
