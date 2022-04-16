package com.jobportal.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class Skills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int skillId;

	private String skill1;
	private String skill2;
	private String skill3;
	private String skill4;

	@JoinColumn(name = "jobId")
	private int jobbId;

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

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

	public int getJobbId() {
		return jobbId;
	}

	public void setJobbId(int jobbId) {
		this.jobbId = jobbId;
	}

	public Skills(int skillId, String skill1, String skill2, String skill3, String skill4, int jobbId) {
		super();
		this.skillId = skillId;
		this.skill1 = skill1;
		this.skill2 = skill2;
		this.skill3 = skill3;
		this.skill4 = skill4;
		this.jobbId = jobbId;
	}

	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Skills [skillId=" + skillId + ", skill1=" + skill1 + ", skill2=" + skill2 + ", skill3=" + skill3
				+ ", skill4=" + skill4 + ", jobbId=" + jobbId + "]";
	}

}
