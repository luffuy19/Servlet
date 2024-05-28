package com.chainsys.model;

public class Student {
	int rollNo;
	String studentName;
	int attendence;
	int studentRank;
	int quaterly;
	String standard;
	String studentClass;
	String mentorName;
	String teacherUsername;
	int halfYearly;
	int annualTotal;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAttendence() {
		return attendence;
	}
	public void setAttendence(int attendence) {
		this.attendence = attendence;
	}
	public int getStudentRank() {
		return studentRank;
	}
	public void setStudentRank(int studentRank) {
		this.studentRank = studentRank;
	}
	public int getQuaterly() {
		return quaterly;
	}
	public void setQuaterly(int quaterly) {
		this.quaterly = quaterly;
	}
	public String getStandard() {
		return standard;
	}
	public void setStandard(String standard) {
		this.standard = standard;
	}
	public String getStudentClass() {
		return studentClass;
	}
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
	public String getMentorName() {
		return mentorName;
	}
	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}
	public String getTeacherUsername() {
		return teacherUsername;
	}
	public void setTeacherUsername(String teacherUsername) {
		this.teacherUsername = teacherUsername;
	}
	public int getHalfYearly() {
		return halfYearly;
	}
	public void setHalfYearly(int halfYearly) {
		this.halfYearly = halfYearly;
	}
	public int getAnnualTotal() {
		return annualTotal;
	}
	public void setAnnualTotal(int annualTotal) {
		this.annualTotal = annualTotal;
	}
	public Student(int rollNo, String studentName, int attendence, int studentRank, int quaterly, String standard,
			String studentClass, String mentorName, String teacherUsername, int halfYearly, int annualTotal) {
		super();
		this.rollNo = rollNo;
		this.studentName = studentName;
		this.attendence = attendence;
		this.studentRank = studentRank;
		this.quaterly = quaterly;
		this.standard = standard;
		this.studentClass = studentClass;
		this.mentorName = mentorName;
		this.teacherUsername = teacherUsername;
		this.halfYearly = halfYearly;
		this.annualTotal = annualTotal;
	}
	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", studentName=" + studentName + ", attendence=" + attendence
				+ ", studentRank=" + studentRank + ", quaterly=" + quaterly + ", standard=" + standard
				+ ", studentClass=" + studentClass + ", mentorName=" + mentorName + ", teacherUsername="
				+ teacherUsername + ", halfYearly=" + halfYearly + ", annualTotal=" + annualTotal + "]";
	}
	
	
}
