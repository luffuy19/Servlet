package com.chainsys.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.model.Student;
import com.chainsys.model.Teacher;
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
			if(rs.getString("user_name").equals(userNname)) {
			return true;
			}
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

	public static List<Student> show(String section) throws SQLException, ClassNotFoundException {

		String query = "select rollNo,studentName,attendence,studentRank,total,standard,studentClass,mentorName,half_yearly,Annual_yearly from student where studentClass=?";
		Connection con = Connectionutil.getConnections();
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, section);
		ResultSet rs = statement.executeQuery();
		ArrayList<Student> al = new ArrayList<>();

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
	public static Teacher findTeacherDetails(String studentClass) throws SQLException, ClassNotFoundException {
	    Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    try {
	        con = Connectionutil.getConnections();
	        String query = "SELECT user_name, teacher_name FROM admin_users WHERE section = ?";
	        statement = con.prepareStatement(query);
	        statement.setString(1, studentClass);  // Use the parameter studentClass
	        rs = statement.executeQuery();
	        
	        if (rs.next()) {  // Check if the ResultSet has at least one row
	            Teacher t = new Teacher();
	            t.setName(rs.getString("teacher_name"));
	            t.setTeacherName(rs.getString("user_name"));
	            return t;
	        }
	    } finally {
	        // Close the resources in the reverse order of their creation
	        if (rs != null) {
	            try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
	        }
	        if (statement != null) {
	            try { statement.close(); } catch (SQLException e) { e.printStackTrace(); }
	        }
	        if (con != null) {
	            try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
	        }
	    }
	    
	    System.out.println(studentClass);
	    System.out.println("class");
	    return null;  // Return null if no teacher is found
	}
	public static void delete(int id, String section) throws SQLException, ClassNotFoundException {
		Connection connection = Connectionutil.getConnections();
		String query = "delete from student where rollNo=? && studentClass=?";
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id);
		statement.setString(2,section );
		int execute = statement.executeUpdate();
		System.out.println(execute+" Row Affected");
		connection.close();
	}

}
