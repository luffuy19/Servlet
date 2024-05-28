package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chainsys.dto.TeacherDb;
import com.chainsys.model.Student;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String section = (String) session.getAttribute("teacherClass");
		if (session != null && session.getAttribute("teacherClass") != null) {
			String searchQuery = request.getParameter("searchQuery");
			try {
				List<Student> students  = TeacherDb.show(section);
				// Apply search filter
				students = students.stream()
							.filter(Student -> Student.getStudentName().toLowerCase().contains(searchQuery.toLowerCase()))
							.collect(Collectors.toList());
				request.setAttribute("student", students);
				request.getRequestDispatcher("studentTable.jsp").forward(request, response);
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				request.getRequestDispatcher("error.jsp");
			}
		} else {
			request.getRequestDispatcher("studentTable.jsp");
		}
	}

}
