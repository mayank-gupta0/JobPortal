package com.jobportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "adminapproval")
public class AdminApproval {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String name;
	private String email;
	private String phoneNumber;
	private String approvalStatus;

	@JoinColumn(name = "HrId")
	private int approveHrid;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getApprovalStatus() {
		return approvalStatus;
	}

	public void setApprovalStatus(String approvalStatus) {
		this.approvalStatus = approvalStatus;
	}

	public int getApproveHrid() {
		return approveHrid;
	}

	public void setApproveHrid(int approveHrid) {
		this.approveHrid = approveHrid;
	}

	public AdminApproval(int id, String name, String email, String phoneNumber, String approvalStatus,
			int approveHrid) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.approvalStatus = approvalStatus;
		this.approveHrid = approveHrid;
	}

	public AdminApproval() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AdminApproval [Id=" + Id + ", name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ ", approvalStatus=" + approvalStatus + ", approveHrid=" + approveHrid + "]";
	}

	

	
	

}
