package com.jobportal.request;

import java.util.List;

public class HRJobPostRequest {
	private String JobTitle;
	private String JobDescription;
	private String Experience;
	private String Location;
	private String JobMode;
	private String Salary;
	private int RequiredEmployee;
	private int HrrId;
	private SkillsRequest skills;

	public String getJobTitle() {
		return JobTitle;
	}

	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}

	public String getJobDescription() {
		return JobDescription;
	}

	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}

	public String getExperience() {
		return Experience;
	}

	public void setExperience(String experience) {
		Experience = experience;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getJobMode() {
		return JobMode;
	}

	public void setJobMode(String jobMode) {
		JobMode = jobMode;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	public int getRequiredEmployee() {
		return RequiredEmployee;
	}

	public void setRequiredEmployee(int requiredEmployee) {
		RequiredEmployee = requiredEmployee;
	}

	public SkillsRequest getSkills() {
		return skills;
	}

	public void setSkills(SkillsRequest skills) {
		this.skills = skills;
	}

	public int getHrrId() {
		return HrrId;
	}

	public void setHrrId(int hrrId) {
		HrrId = hrrId;
	}

	public HRJobPostRequest(String jobTitle, String jobDescription, String experience, String location, String jobMode,
			String salary, int requiredEmployee, int hrrId, SkillsRequest skills) {
		super();
		JobTitle = jobTitle;
		JobDescription = jobDescription;
		Experience = experience;
		Location = location;
		JobMode = jobMode;
		Salary = salary;
		RequiredEmployee = requiredEmployee;
		HrrId = hrrId;
		this.skills = skills;
	}

	public HRJobPostRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HRJobPostRequest [JobTitle=" + JobTitle + ", JobDescription=" + JobDescription + ", Experience="
				+ Experience + ", Location=" + Location + ", JobMode=" + JobMode + ", Salary=" + Salary
				+ ", RequiredEmployee=" + RequiredEmployee + ", HrrId=" + HrrId + ", skills=" + skills + "]";
	}

}
