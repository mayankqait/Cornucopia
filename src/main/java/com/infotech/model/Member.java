package com.infotech.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="Member")
@EntityListeners(AuditingEntityListener.class)
public class Member {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="empId")
	private int empId;
	private String name;
	private String email;
	private long mobile;
	private String skypeId;
	
	

	public Member() {
		super();
	}

	public Member(int empId, String name, String email, long mobile, String skypeId) {
		super();
		//this.empId = empId;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.skypeId = skypeId;
	}
    
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	@Override
	public String toString() {
		return "Member [empId=" + empId + ", name=" + name + ", email=" + email + ", moblie=" + mobile + ", skypeId="
				+ skypeId + "]";
	}

	
	
	
}
