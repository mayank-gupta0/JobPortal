package com.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.entities.AdminApproval;
import com.jobportal.entities.HR;
import com.jobportal.entities.User;
import com.jobportal.request.HRJobPostRequest;
import com.jobportal.request.HRRequest;
import com.jobportal.service.HRService;

@RestController
@CrossOrigin
@RequestMapping("/hr")
public class HRController {

	boolean flag = false;

	@Autowired
	HRService hrService;

	@PostMapping("/register") // hr registering
	public String register(@RequestBody HRRequest request) {

		return hrService.register(request);
	}

	@GetMapping("/login") // hr login
	public String findByEmail(@RequestParam String email, @RequestParam String password) {
		List<HR> lst = hrService.findAll();
		String ml = hrService.findByEmail(lst, email, password);
		if (ml.equals("Login Done Successfully: " + email)) {
			flag = true;
		}
		return ml;

	}

	@GetMapping("/all-hr")
	public List<HR> findAll() {
		return hrService.findAll();
	}

	@PostMapping("/jobpost") // hr job posting and checking two validation 1: login before posting and 2: hr // approval status
	public String JobPost(@RequestBody HRJobPostRequest hrJobPostRequest, @RequestParam int id) {
		boolean lst = hrService.find(id);

		if (lst) {
			if (flag) {
				return hrService.jobposting(hrJobPostRequest, id);
			} else {
				return "Login Not done";
			}
		} else {
			return "Not Approved by Admin";

		}
	}

	@GetMapping("/approve") // hr approving user applied job
	public String approve(@RequestParam String status, @RequestParam int userid, @RequestParam int id) {
		return hrService.approve(status, userid, id);
	}

}
