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

import com.jobportal.entities.HRJobPost;
import com.jobportal.entities.HRSeeing;
import com.jobportal.entities.User;
import com.jobportal.entities.UserAppliedJob;
import com.jobportal.repository.UserRepository;
import com.jobportal.request.UserApplyRequest;
import com.jobportal.request.UserRequest;

import com.jobportal.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

	boolean flag = false;

	@Autowired
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@PostMapping("/register")
	public String register(@RequestBody UserRequest request) {

		return userService.register(request);
	}

	@GetMapping("/all-user")
	public List<User> findAll() {
		return userService.findAll();
	}

	/******************************************/
	@GetMapping("/login")
	public String log(@RequestParam String email, @RequestParam String password) {
		User lst1 = userRepository.findByemail(email);
		if (lst1 == null) {
			return "Login Not Found Please Do Registration!";
		} else {
			return userService.log(lst1, email, password);
		}
	}

	@PostMapping("/jobmatching") // filter user and showing all interested job according to user skills
	public List<HRJobPost> applyjob(@RequestBody UserApplyRequest userApplyRequest) {

		return userService.applyjob(userApplyRequest);

	}

	@GetMapping("/showstatus") // user applied for job by giving job id
	public List<UserAppliedJob> showappliedjob(@RequestParam int id1, @RequestParam int id2, @RequestParam int userId) {
		int y = 0;
		List<User> gh = userRepository.findById(userId);

		if (gh == null) {
			y++;
		}

		if (y == 0) {
			return userService.showappliedjob(id1, id2, userId);

		} else {
			return null;
		}

	}

	@GetMapping("/approvedstatus") // user checking status of jobs in which hr approved
	public List<HRSeeing> approvedStatus(@RequestParam int id) {
		return userService.approvedStatus(id);

	}

}
