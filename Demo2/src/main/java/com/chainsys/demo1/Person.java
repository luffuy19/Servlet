package com.chainsys.demo1;

public class Person {
	int rollNo;
	String name;
	String email;
	int phNo;
	String password;
	String gender;
	public Person(int rollNo2, String name, String email, int phNo, String password, String gender) {
		super();
		this.rollNo = rollNo2;
		this.name = name;
		this.email = email;
		this.phNo = phNo;
		this.password = password;
		this.gender = gender;
	}
	public int getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getPhNo() {
		return phNo;
	}
	public String getPassword() {
		return password;
	}
	public String getGender() {
		return gender;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhNo(int phNo) {
		this.phNo = phNo;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}	
	
}
