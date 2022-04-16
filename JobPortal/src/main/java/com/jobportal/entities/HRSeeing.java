package com.jobportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="hrseeing")
public class HRSeeing {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String hrName;
	private String jobTitle;
	private String jobDescription;
	private String experience;
	private String jobMode;
	private String location;
	private String salary;
	
	@JoinColumn(name="userId")
	private int userId;
	
	private String status;
	public String getHrName() {
		return hrName;
	}
	public void setHrName(String hrName) {
		this.hrName = hrName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "HRSeeing [id=" + id + ", hrName=" + hrName + ", jobTitle=" + jobTitle + ", jobDescription="
				+ jobDescription + ", experience=" + experience + ", jobMode=" + jobMode + ", location=" + location
				+ ", salary=" + salary + ", userId=" + userId + ", status=" + status + "]";
	}
	public HRSeeing(int id, String hrName, String jobTitle, String jobDescription, String experience, String jobMode,
			String location, String salary, int userId, String status) {
		super();
		this.id = id;
		this.hrName = hrName;
		this.jobTitle = jobTitle;
		this.jobDescription = jobDescription;
		this.experience = experience;
		this.jobMode = jobMode;
		this.location = location;
		this.salary = salary;
		this.userId = userId;
		this.status = status;
	}
	public HRSeeing() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

}
