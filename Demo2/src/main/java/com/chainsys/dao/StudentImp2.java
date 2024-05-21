package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.model.Person;

/**
 * Servlet implementation class StudentImp1
 */
@WebServlet("/FristExample")
public class StudentImp2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollNo=Integer.parseInt(request.getParameter("rollNo"));
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String phno = request.getParameter("phno");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		Person p=new Person(rollNo,name, email,phno, password, gender);
		StudentImp1 studentImp1 = new StudentImp1();
		try {
			ArrayList<Person> al = studentImp1.saveStudent(p);
			request.setAttribute("person", al);
			request.getRequestDispatcher("table.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		request.setAttribute("person", p);
//		request.getRequestDispatcher("table.jsp").forward(request, response);
	}
//	protected void doDelete(int rollNo ,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		for(int i=0;i<person.size();i++) {
//			if((person.get(i).getRollNo())==rollNo) {
//				person.remove(i);
//			}
//		}
//		request.setAttribute("person", person);
//		request.getRequestDispatcher("table.jsp").forward(request, response);
//	}
//	protected void doUpdate(int rollNo ,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String name = request.getParameter("username");
//		String email = request.getParameter("email");
//		int phno = (int)Integer.parseInt(request.getParameter("phno"));
//		String password = request.getParameter("password");
//		String gender = request.getParameter("gender");
//		for(int i=0;i<person.size();i++) {
//			if((person.get(i).getRollNo())==rollNo) {
//				Person persons = person.get(i);
//				persons.setRollNo(rollNo);
//				persons.setName(name);
//				persons.setEmail(email);
//				persons.setPhNo(phno);
//				persons.setPassword(password);
//				persons.setGender(gender);
//			}
//		}
		
//		request.setAttribute("person", person);
//		request.getRequestDispatcher("table.jsp").forward(request, response);
//	}
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		int rollNo = Integer.parseInt(request.getParameter("rollNo"));
//		String choice = request.getParameter("action");
//
//		switch(choice){
//			case "delete" : doDelete(rollNo, request, response);
//			case "update" : doUpdate(rollNo, request, response);
//		}	
//	}

}
