package com.cg.cbs.beans;

import javax.persistence.*;

@Entity
public class User 
{
	@Id
	private String userId;
	private String password;
	private String role;
	private String fullName;
	private String mobile;
	private String address;
	private String aadhar;
	
	public User() {
		super();
	}
	public User(String userId, String password, String role, String fullName, String mobile, String address,
			String aadhar) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.fullName = fullName;
		this.mobile = mobile;
		this.address = address;
		this.aadhar = aadhar;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + ", fullName=" + fullName
				+ ", mobile=" + mobile + ", address=" + address + ", aadhar=" + aadhar + "]";
	}	
}