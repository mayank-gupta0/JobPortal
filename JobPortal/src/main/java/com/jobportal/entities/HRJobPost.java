package com.jobportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "hrjobpost")
public class HRJobPost {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name="jobbId")
	private int jobId;
	private String JobTitle;
	private String JobDescription;
	private String Experience;
	private String Location;
	private String JobMode;
	private String Salary;
	private int RequiredEmployee;
	private int HrrId;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

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

	public int getHrrId() {
		return HrrId;
	}

	public void setHrrId(int hrrId) {
		HrrId = hrrId;
	}

	public HRJobPost(int jobId, String jobTitle, String jobDescription, String experience, String location,
			String jobMode, String salary, int requiredEmployee, int hrrId) {
		super();
		this.jobId = jobId;
		JobTitle = jobTitle;
		JobDescription = jobDescription;
		Experience = experience;
		Location = location;
		JobMode = jobMode;
		Salary = salary;
		RequiredEmployee = requiredEmployee;
		HrrId = hrrId;
	}

	public HRJobPost() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HRJobPost [jobId=" + jobId + ", JobTitle=" + JobTitle + ", JobDescription=" + JobDescription
				+ ", Experience=" + Experience + ", Location=" + Location + ", JobMode=" + JobMode + ", Salary="
				+ Salary + ", RequiredEmployee=" + RequiredEmployee + ", HrrId=" + HrrId + "]";
	}

}
