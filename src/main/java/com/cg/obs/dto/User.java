package com.cg.obs.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customerlogindetail")
public class User {
	@Id
	@Column(name="phoneno")
	private long phoneNo;

	@Column(name="password")
	private String passWord;
	
	public User(){}
   


	
	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}




	public long getPhoneNo() {
		return phoneNo;
	}




	public User(long mobileNo, String passWord) {
		super();
		this.phoneNo = mobileNo;
		this.passWord = passWord;
	}




	public void setPhoneNo(long mobileNo) {
		this.phoneNo = mobileNo;
	}




	@Override
	public String toString() {
		return "User [phoneNo=" + phoneNo + ", passWord=" + passWord + "]";
	}

	

	
	
}
