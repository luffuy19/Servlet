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
       
	@SuppressWarnings("unlikely-arg-type")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentImp1 studentImp1 = new StudentImp1();
		ArrayList<Person> allUsers = StudentImp1.getAllUsers();
		String name = request.getParameter("username");
		for(Person names : allUsers) {
			if(names.getName().equals(name)) {
				request.setAttribute("namemessage","Already User Exit");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		String email = request.getParameter("email");
		String phno = request.getParameter("phno");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		Person p=new Person(0,name, email,phno, password, gender);

		try {
			ArrayList<Person> al = studentImp1.saveStudent(p);
			request.setAttribute("person", al);
			request.getRequestDispatcher("table.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doDelete(int rollNo ,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentImp1 studentImp1 = new StudentImp1();
		ArrayList<Person> delete;
		try {
			delete = studentImp1.delete(rollNo);
			request.setAttribute("person", delete);
			request.getRequestDispatcher("table.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected void doUpdate(int rollNo ,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String email = request.getParameter("email");
			String phno = request.getParameter("phno");
			String password = request.getParameter("password");
			StudentImp1 studentImp1 = new StudentImp1();
			studentImp1.UpdateStudent(email,password,phno,rollNo);
			ArrayList<Person> allUsers = StudentImp1.getAllUsers();
			request.setAttribute("person", allUsers);
			request.getRequestDispatcher("table.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		request.setAttribute("person", person);
//		request.getRequestDispatcher("table.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rollNo = Integer.parseInt(request.getParameter("rollNo"));
		String choice = request.getParameter("action");
		System.out.println(choice);
		switch(choice){
			case "delete" : doDelete(rollNo, request, response);
			case "update" : doUpdate(rollNo, request, response);
							
		}	
	}

}
