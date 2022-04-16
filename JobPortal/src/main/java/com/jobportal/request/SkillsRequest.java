package com.jobportal.request;

public class SkillsRequest {
	private String skill1;
	private String skill2;
	private String skill3;
	private String skill4;
	public String getSkill1() {
		return skill1;
	}
	public void setSkill1(String skill1) {
		this.skill1 = skill1;
	}
	public String getSkill2() {
		return skill2;
	}
	public void setSkill2(String skill2) {
		this.skill2 = skill2;
	}
	public String getSkill3() {
		return skill3;
	}
	public void setSkill3(String skill3) {
		this.skill3 = skill3;
	}
	public String getSkill4() {
		return skill4;
	}
	public void setSkill4(String skill4) {
		this.skill4 = skill4;
	}
	public SkillsRequest(String skill1, String skill2, String skill3, String skill4) {
		super();
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
		this.skill4 = skill4;
	}
	public SkillsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SkillsRequest [skill1=" + skill1 + ", skill2=" + skill2 + ", skill3=" + skill3 + ", skill4=" + skill4
				+ "]";
	}
	
	

}
