package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dto.TeacherDb;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		TeacherDb teacher = new TeacherDb();
		try {
			boolean loginCheck = teacher.loginCheck(username, password);
			if(loginCheck==true) {
				System.out.println("ok");
				String section = TeacherDb.findClass(username);
				 Cookie cookie = new Cookie("section",section);

			        // Set the maximum age (optional, in seconds)
			        cookie.setMaxAge(60 * 60 * 24); // 1 day

			        // Add the cookie to the response
			        response.addCookie(cookie);

			        response.getWriter().println("Cookie created successfully!");
				HttpSession session = request.getSession();
				session.setAttribute("teacherClass", section);
				response.sendRedirect("studentTable.jsp");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
