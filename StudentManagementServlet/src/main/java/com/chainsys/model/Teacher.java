package com.chainsys.model;

public class Teacher {
	public String name;
	public String teacherName;
	public String password;
	public String section;
	
	
	public Teacher(String name, String teacherName, String password, String section) {
		super();
		this.name = name;
		this.teacherName = teacherName;
		this.password = password;
		this.section = section;
	}
	public Teacher() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	
	
	
}
