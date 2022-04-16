package com.jobportal.request;

import java.util.*;

public class UserApplyRequest {
	private String JobRole;
	private String CollegeName;
	private String Degree;
	private String branch;
	private UserApplySkillsRequest usserApplySkillsRequests;

	public String getJobRole() {
		return JobRole;
	}

	public void setJobRole(String jobRole) {
		JobRole = jobRole;
	}

	public String getCollegeName() {
		return CollegeName;
	}

	public void setCollegeName(String collegeName) {
		CollegeName = collegeName;
	}

	public String getDegree() {
		return Degree;
	}

	public void setDegree(String degree) {
		Degree = degree;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public UserApplySkillsRequest getUsserApplySkillsRequests() {
		return usserApplySkillsRequests;
	}

	public void setUsserApplySkillsRequests(UserApplySkillsRequest usserApplySkillsRequests) {
		this.usserApplySkillsRequests = usserApplySkillsRequests;
	}

	public UserApplyRequest(String jobRole, String collegeName, String degree, String branch,
			UserApplySkillsRequest usserApplySkillsRequests) {
		super();
		JobRole = jobRole;
		CollegeName = collegeName;
		Degree = degree;
		this.branch = branch;
		this.usserApplySkillsRequests = usserApplySkillsRequests;
	}

	public UserApplyRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserApplyRequest [JobRole=" + JobRole + ", CollegeName=" + CollegeName + ", Degree=" + Degree
				+ ", branch=" + branch + ", usserApplySkillsRequests=" + usserApplySkillsRequests + "]";
	}

}
