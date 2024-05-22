package com.chainsys.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.chainsys.model.Person;
import com.studentcrud.util.Connectionutil;

public class StudentImp1 implements StudentDao{

	@Override
	public ArrayList<Person> saveStudent(Person p) throws SQLException {
		Connection con;
		try {
			con = Connectionutil.getConnections();
			String query="INSERT INTO Users (username, email, phoneNumber, password, gender) VALUES (?,?,?,?,?);";
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setString(1,p.getName());
			statement.setString(2,p.getEmail());
			statement.setString(3,p.getPhNo());
			statement.setString(4,p.getPassword());
			statement.setString(5,p.getGender());
			int execute = statement.executeUpdate();
			System.out.println(execute);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Person> al = getAllUsers();
		return al;
		
	}
	public static ArrayList<Person> getAllUsers() {
		Connection con;
		ArrayList<Person> al = new ArrayList<Person>();
		try {
			con = Connectionutil.getConnections();
			String query="SELECT * from users";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while(rs.next()) {
				int rollNo = rs.getInt("rollNo");
				String userName = rs.getString("username");
				String email = rs.getString("email");
				String phNo = rs.getString("phoneNumber");
				String gender = rs.getString("gender");
				Person p = new Person();
				p.setRollNo(rollNo);
				p.setName(userName);
				p.setPhNo(phNo);
				p.setEmail(email);
				p.setGender(gender);
				al.add(p);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
		
	}
	public ArrayList<Person> delete(int rollNo) throws ClassNotFoundException, SQLException {
		Connection con;
		con = Connectionutil.getConnections();
		String query="DELETE from users WHERE rollNo=?";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setInt(1, rollNo);
		int executeUpdate = statement.executeUpdate();
		System.out.println(executeUpdate);
		ArrayList<Person> allUsers = getAllUsers();
		return allUsers;
	}
	
	public ArrayList<Person> UpdateStudent(String email, String password, String phno,int rollNo) throws SQLException {
		Connection con;
		try {
			con = Connectionutil.getConnections();
			String query="UPDATE Users SET email = ?,phoneNumber = ?,password = ? WHERE rollNo = ?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1,email);
			statement.setString(2,phno);
			statement.setString(3,password);
			statement.setInt(4,rollNo);
			int execute = statement.executeUpdate();
			System.out.println(execute);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Person> al = getAllUsers();
		return al;
		
	}
	public ArrayList<Person> SpecficStudent(String email, String password, String phno,int rollNo) throws SQLException {
		Connection con;
		try {
			con = Connectionutil.getConnections();
			String query="SELECT * FROM users WHERE rollNo = ?";
			PreparedStatement statement = con.prepareStatement(query);
			
			int execute = statement.executeUpdate();
			System.out.println(execute);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Person> al = getAllUsers();
		return al;
		
	}
}
