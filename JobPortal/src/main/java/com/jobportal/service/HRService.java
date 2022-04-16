package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entities.AdminApproval;
import com.jobportal.entities.HR;
import com.jobportal.entities.HRJobPost;
import com.jobportal.entities.HRSeeing;
import com.jobportal.entities.Skills;
import com.jobportal.repository.AdminRepository;
import com.jobportal.repository.HRJobPostRepository;
import com.jobportal.repository.HRRepository;
import com.jobportal.repository.HRSeeingRepository;
import com.jobportal.repository.SkillsRepository;
import com.jobportal.request.HRJobPostRequest;
import com.jobportal.request.HRRequest;


@Service
public class HRService {

	@Autowired
	HRRepository hrRepository;

	@Autowired
	HRJobPostRepository hrJobPostRepository;

	@Autowired
	SkillsRepository skillsRepository;

	@Autowired
	AdminRepository adminRepository;

	@Autowired
	HRSeeingRepository hrSeeingRepository;

	public String register(HRRequest request) {

		AdminApproval a = new AdminApproval();
		HR u = new HR();
		if (request.getName().equals("")) {
			return "Sorry, You can't leave this field blank";
		} else {
			if (request.getEmail().equals("")) {
				return "Sorry, You can't leave this field blank";
			} else {
				if (request.getPassword().equals("")) {
					return "Sorry, You can't leave this field blank";
				} else {
					HR h = new HR();
					h = hrRepository.findByEmail(request.getEmail());
					if (h == null) {
						u.setName(request.getName());
						u.setEmail(request.getEmail());
						u.setPassword(request.getPassword());
						u.setPhoneNumber(request.getPhoneNumber());
						u.setArea(request.getArea());
						u.setCity(request.getCity());
						u.setState(request.getState());
						u.setPincode(request.getPincode());

						hrRepository.save(u);

						a.setEmail(request.getEmail());
						a.setName(request.getName());
						a.setPhoneNumber(request.getPhoneNumber());
						a.setApproveHrid(u.getHrId());
						a.setApprovalStatus("null");

						adminRepository.save(a);

						return "HR Registration Successfull";
					} else {
						return "Registration with this email already exist, Please do login";
					}
				}
			}
		}

	}

	/****************************************************************************************************/
	public List<HR> findAll() {
		return hrRepository.findAll();
	}

	public String findByEmail(List<HR> lst2, String email, String password) {
		List<HR> pst = new ArrayList<>(lst2);
		boolean flag = false;
		for (HR e : pst) {
			if (e.getEmail().equals(email) && e.getPassword().equals(password)) {
				flag = true;
				break;
			} else {
				flag = false;
			}
		}

		if (flag) {
			return "Login Done Successfully: " + email;
		} else {
			return "Login Not Found Please Do Registration!";
		}

	}

	/****************************************************************************************************/

	public String jobposting(HRJobPostRequest hrJobPostRequest, int id) {
		// TODO Auto-generated method stub
		HRJobPost hr = new HRJobPost();
		hr.setJobTitle(hrJobPostRequest.getJobTitle());
		hr.setJobDescription(hrJobPostRequest.getJobDescription());
		hr.setExperience(hrJobPostRequest.getExperience());
		hr.setLocation(hrJobPostRequest.getLocation());
		hr.setJobMode(hrJobPostRequest.getJobMode());
		hr.setSalary(hrJobPostRequest.getSalary());
		hr.setRequiredEmployee(hrJobPostRequest.getRequiredEmployee());
		hr.setHrrId(id);

		hrJobPostRepository.save(hr);

		Skills s = new Skills();
		s.setSkill1(hrJobPostRequest.getSkills().getSkill1());
		s.setSkill2(hrJobPostRequest.getSkills().getSkill2());
		s.setSkill3(hrJobPostRequest.getSkills().getSkill3());
		s.setSkill4(hrJobPostRequest.getSkills().getSkill4());
		s.setJobbId(hr.getJobId());

		skillsRepository.save(s);

		return "Job Post Uploaded";
	}

	public boolean find(int id) {
		boolean flag = false;
		// TODO Auto-generated method stub
		List<AdminApproval> lst = adminRepository.findAll();
		List<AdminApproval> lst1 = new ArrayList<>(lst);
		for (AdminApproval e : lst1) {
			if (e.getApproveHrid() == id) {
//				String x = e.getApprovalStatus();
				if (e.getApprovalStatus().equals("yes")) {
					flag = true;

				} else {
					flag = false;
				}
			}
		}
		return flag;
	}

	public String approve(String status, int userid, int id) {
		// TODO Auto-generated method stub
		List<HRSeeing> lst = hrSeeingRepository.findAll();
		List<HRSeeing> lst1 = new ArrayList<>(lst);

		boolean flag = false;

		HRSeeing a = new HRSeeing();
		for (HRSeeing e : lst1) {
			if (e.getUserId() == userid && e.getId() == id) {
				a.setId(e.getId());
				a.setHrName(e.getHrName());
				a.setJobDescription(e.getJobDescription());
				a.setJobMode(e.getJobMode());
				a.setSalary(e.getSalary());
				a.setExperience(e.getExperience());
				a.setJobTitle(e.getJobTitle());
				a.setLocation(e.getLocation());
				a.setStatus(status);
				a.setUserId(e.getUserId());
				hrSeeingRepository.save(a);

				flag = true;
			} else {
				flag = false;
			}
		}
		if (flag) {
			return "Status updated";
		} else {
			return "User id not found";
		}
	}

}
