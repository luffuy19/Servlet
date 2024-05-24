package com.chainsys.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.chainsys.model.Student;
import com.studentcrud.util.Connectionutil;

public class TeacherDb {
	public boolean loginCheck(String userNname, String password) throws SQLException, ClassNotFoundException {
		Connection con = Connectionutil.getConnections();
		String query = "select user_name,password from admin_users where user_name=? && password=?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, userNname);
		statement.setString(2, password);
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			return true;
		}
		return false;

	}

	public static void insertValues(int rollNo, String studentName, int atttendence, int studentRank, int quaterYearly,
			String standard, String studentClass, String mentorName, String teacherusername, int halfYearly,
			int annualExam) throws SQLException, ClassNotFoundException {
		Connection connection = Connectionutil.getConnections();
		String query = "insert into Student values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, rollNo);
		statement.setString(2, studentName);
		statement.setInt(3, atttendence);
		statement.setInt(4, studentRank);
		statement.setInt(5, quaterYearly);
		statement.setString(6, standard);
		statement.setString(7, studentClass);
		statement.setString(8, mentorName);
		statement.setString(9, teacherusername);
		statement.setInt(10, halfYearly);
		statement.setInt(11, annualExam);
		try {
			statement.execute();
		} catch (Exception e) {

		}
		connection.close();
	}

	public static ArrayList<Student> show(String section) throws SQLException, ClassNotFoundException {

		String query = "select rollNo,studentName,attendence,studentRank,total,standard,studentClass,mentorName,half_yearly,Annual_yearly from student where studentClass=?";
		Connection con = Connectionutil.getConnections();
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, section);
		ResultSet rs = statement.executeQuery();
		ArrayList<Student> al = new ArrayList<Student>();

		while (rs.next()) {
			int rollNo = rs.getInt("rollNo");
			String studentName = rs.getString("studentName");
			int attendence = rs.getInt("attendence");
			int studentRank = rs.getInt("studentRank");
			int total = rs.getInt("total");
			String standard = rs.getString("standard");
			String studentClass = rs.getString("studentClass");
			String mentorName = rs.getString("mentorName");
			int halfYearly = rs.getInt("half_yearly");
			int annualYearly = rs.getInt("Annual_yearly");
			Student s = new Student(rollNo, studentName, attendence, studentRank, total, standard, studentClass,
					mentorName, null, halfYearly, annualYearly);
			al.add(s);
		}

		con.close();
		return al;
	}
	public static String findClass(String teacherName) throws SQLException, ClassNotFoundException {
		Connection con = Connectionutil.getConnections();
		String query="select section from admin_users where user_name=?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, teacherName);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			String studentClass=rs.getNString("section");
			return studentClass ;
		}
		return null;
	}
}
