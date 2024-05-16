package com.chainsys.demo1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FristExample
 */
@WebServlet("/FristExample")
public class FristExample extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FristExample() {
        super();
        // TODO Auto-generated constructor stub
    }
    ArrayList<Person> person = new ArrayList<Person>();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rollNo=Integer.parseInt(request.getParameter("rollNo"));
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		int phno = (int)Integer.parseInt(request.getParameter("phno"));
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		Person p=new Person(rollNo,name, email,phno, password, gender);
		person.add(p);
		request.setAttribute("person", person);
		request.getRequestDispatcher("table.jsp").forward(request, response);
	}
	protected void doDelete(int rollNo ,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		for(int i=0;i<person.size();i++) {
			if((person.get(i).getRollNo())==rollNo) {
				person.remove(i);
			}
		}
		request.setAttribute("person", person);
		request.getRequestDispatcher("table.jsp").forward(request, response);
	}
	protected void doUpdate(int rollNo ,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		int phno = (int)Integer.parseInt(request.getParameter("phno"));
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		for(int i=0;i<person.size();i++) {
			if((person.get(i).getRollNo())==rollNo) {
				Person persons = person.get(i);
				persons.setRollNo(rollNo);
				persons.setName(name);
				persons.setEmail(email);
				persons.setPhNo(phno);
				persons.setPassword(password);
				persons.setGender(gender);
			}
		}
		
		request.setAttribute("person", person);
		request.getRequestDispatcher("table.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rollNo = Integer.parseInt(request.getParameter("rollNo"));
		String choice = request.getParameter("action");

		switch(choice){
			case "delete" : doDelete(rollNo, request, response);
			case "update" : doUpdate(rollNo, request, response);
		}	
	}

}
