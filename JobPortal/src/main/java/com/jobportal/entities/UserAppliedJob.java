package com.jobportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "userappliedjob")
public class UserAppliedJob {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String hrName;
	private String hrEmail;
	private String jobTitle;
	private String jobDescription;
	private String experience;
	private String jobMode;
	private String salary;
	private String location;

	@JoinColumn(name = "userId")
	private int userId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHrName() {
		return hrName;
	}

	public void setHrName(String hrName) {
		this.hrName = hrName;
	}

	public String getHrEmail() {
		return hrEmail;
	}

	public void setHrEmail(String hrEmail) {
		this.hrEmail = hrEmail;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getJobMode() {
		return jobMode;
	}

	public void setJobMode(String jobMode) {
		this.jobMode = jobMode;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserAppliedJob(int id, String hrName, String hrEmail, String jobTitle, String jobDescription,
			String experience, String jobMode, String salary, String location, int userId) {
		super();
		this.id = id;
		this.hrName = hrName;
		this.hrEmail = hrEmail;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.experience = experience;
		this.jobMode = jobMode;
		this.salary = salary;
		this.location = location;
		this.userId = userId;
	}

	public UserAppliedJob() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserAppliedJob [id=" + id + ", hrName=" + hrName + ", hrEmail=" + hrEmail + ", jobTitle=" + jobTitle
				+ ", jobDescription=" + jobDescription + ", experience=" + experience + ", jobMode=" + jobMode
				+ ", salary=" + salary + ", location=" + location + ", userId=" + userId + "]";
	}

}
