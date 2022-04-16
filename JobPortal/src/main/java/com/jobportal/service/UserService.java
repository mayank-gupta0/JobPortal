package com.jobportal.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobportal.entities.HR;
import com.jobportal.entities.HRJobPost;
import com.jobportal.entities.HRSeeing;
import com.jobportal.entities.Skills;
import com.jobportal.entities.User;
import com.jobportal.entities.UserAppliedJob;
import com.jobportal.repository.HRJobPostRepository;
import com.jobportal.repository.HRRepository;
import com.jobportal.repository.HRSeeingRepository;
import com.jobportal.repository.SkillsRepository;
import com.jobportal.repository.UserAppliedJobRepository;
import com.jobportal.repository.UserRepository;
import com.jobportal.request.UserApplyRequest;
import com.jobportal.request.UserRequest;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	SkillsRepository skillsRepository;

	@Autowired
	HRJobPostRepository hrJobPostRepository;

	@Autowired
	HRRepository hrRepository;

	@Autowired
	UserAppliedJobRepository userAppliedJobRepository;

	@Autowired
	HRSeeingRepository hrSeeingRepository;

	public String register(UserRequest request) {

		User u = new User();
		if (request.getName().equals("")) {
			return "Sorry, You can't leave this field blank";
		} else {
			if (request.getEmail().equals("")) {
				return "Sorry, You can't leave this field blank";
			} else {
				if (request.getPassword().equals("")) {
					return "Sorry, You can't leave this field blank";
				} else {
					User us = new User();
					us = userRepository.findByemail(request.getEmail());
					if (us == null) {
						u.setEmail(request.getEmail());
						u.setName(request.getName());
						u.setPassword(request.getPassword());
						u.setPhoneNumber(request.getPhoneNumber());
						u.setArea(request.getArea());
						u.setCity(request.getCity());
						u.setState(request.getState());
						u.setPincode(request.getPincode());

						userRepository.save(u);
						return "Registration Successfull";
					} else {
						return "Registration with this email already exist, Please do login";
					}
				}
			}
		}
	}

	/*************************************************************/

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	public String log(User lst1, String email, String password) {
		if (lst1.getEmail().equals(email) && lst1.getPassword().equals(password)) {
			return "Login Done Successfully: " + email;
		} else {
			return "";
		}
	}

	/*************************************************************/

	public List<HRJobPost> applyjob(UserApplyRequest userApplyRequest) {
		// TODO Auto-generated method stub
//		Skills s=new Skills();

		List<Skills> lst = skillsRepository.findAll();
		List<Skills> pst = new ArrayList<>(lst);
		int i = 0;
		int j = 0;
		int m = 0;
		int a[] = new int[20];

		for (Skills e : pst) {
			if (e.getSkill1().equals(userApplyRequest.getUsserApplySkillsRequests().getSkill1())
					|| e.getSkill2().equals(userApplyRequest.getUsserApplySkillsRequests().getSkill1())
					|| e.getSkill3().equals(userApplyRequest.getUsserApplySkillsRequests().getSkill1())
					|| e.getSkill4().equals(userApplyRequest.getUsserApplySkillsRequests().getSkill1())) {
				i = e.getJobbId();
				m++;
				while (j < m) {
					a[j] = i;
					break;
				}
				j++;
			}
		}

		List<HRJobPost> hrr = hrJobPostRepository.findAll();
		List<HRJobPost> tr = new ArrayList<>(hrr);

		List<HRJobPost> oop = new ArrayList<HRJobPost>();
		HRJobPost lo;
		for (HRJobPost e : tr) {
			for (int l = 0; l < m; l++) {
				if (e.getJobId() == a[l]) {
					lo = new HRJobPost();
					lo = e;
					oop.add(lo);
					break;
				}
			}

		}
		System.out.println("data " + oop);
		return oop;
	}

	/*************************************************************/

	public List<UserAppliedJob> showappliedjob(int id1, int id2, int userId) {
		// TODO Auto-generated method stub
		List<HRJobPost> lst = hrJobPostRepository.findAll();
		List<HRJobPost> tr = new ArrayList<>(lst);
		List<UserAppliedJob> lst3 = new ArrayList<>();
		UserAppliedJob u;
		HRSeeing h;
		List<Integer> list3 = new ArrayList<>();
		list3.add(id1);
		list3.add(id2);

		for (HRJobPost e : tr) {
			for (Integer f : list3) {
				if (e.getJobId() == f) {
					h = new HRSeeing();
					u = new UserAppliedJob();
					int i = e.getHrrId();
					List<HR> lst1 = hrRepository.findAll();
					List<HR> list2 = new ArrayList<>(lst1);
					for (HR p : list2) {
						if (p.getHrId() == i) {
							u.setHrName(p.getName());
							u.setHrEmail(p.getEmail());
							h.setHrName(p.getName());
							break;
						}
					}
					u.setJobTitle(e.getJobTitle());
					u.setJobDescription(e.getJobDescription());
					u.setJobMode(e.getJobMode());
					u.setLocation(e.getLocation());
					u.setSalary(e.getSalary());
					u.setExperience(e.getExperience());
					u.setUserId(userId);

					h.setJobTitle(e.getJobTitle());
					h.setJobDescription(e.getJobDescription());
					h.setJobMode(e.getJobMode());
					h.setSalary(e.getSalary());
					h.setLocation(e.getLocation());
					h.setExperience(e.getExperience());
					h.setStatus("null");
					h.setUserId(userId);

					hrSeeingRepository.save(h);
					userAppliedJobRepository.save(u);
					lst3.add(u);

				}
			}
		}

		return lst3;
	}

	/*************************************************************/
	public List<HRSeeing> approvedStatus(int id) {
		// TODO Auto-generated method stub
		List<HRSeeing> lst5 = hrSeeingRepository.findAll();
		List<HRSeeing> lst6 = new ArrayList<>(lst5);

		boolean flag = false;

		List<HRSeeing> display = new ArrayList<>();
		HRSeeing h1;
		for (HRSeeing e : lst6) {
			if (e.getUserId() == id && e.getStatus().equals("yes")) {
				h1 = new HRSeeing();
				h1 = e;
				display.add(h1);
				flag = true;
			}
		}

		if (flag) {
			return display;
		} else {
			return null;
		}
	}

	/***********************************************************************/

}

/*************************************************************/
