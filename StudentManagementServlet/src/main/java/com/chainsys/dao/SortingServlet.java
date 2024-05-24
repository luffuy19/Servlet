package com.chainsys.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.chainsys.dto.TeacherDb;
import com.chainsys.model.Student;

/**
 * Servlet implementation class SortingServlet
 */
@WebServlet("/SortingServlet")
public class SortingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public SortingServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String columnName = request.getParameter("column");
		 System.out.println(columnName);
		 HttpSession session = request.getSession(false);
		 String section = (String) session.getAttribute("teacherClass");
		 System.out.println(section);
		 try {
			ArrayList<Student> employees = getEmployeesSortedByColumn(columnName,section);
			request.setAttribute("student", employees);
			request.getRequestDispatcher("studentTable.jsp").forward(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Student> getEmployeesSortedByColumn(String columnName,String section) throws ClassNotFoundException, SQLException {
	    ArrayList<Student> employees = TeacherDb.show(section); // Assuming insert() retrieves all employees
	    System.out.println(employees.get(0));
	    switch (columnName) {
	        case "rank":
	            Collections.sort(employees, Comparator.comparing(Student::getStudentRank));
	            break;
	        case "attendance":
	            Collections.sort(employees, Comparator.comparing(Student::getAttendence));
	            break;
	        case "name":
	            Collections.sort(employees, Comparator.comparing(Student::getStudentName));
	            break;
	        // Add cases for other columns if needed
	        default:
	            // Default sorting by name
	            Collections.sort(employees, Comparator.comparing(Student::getStudentName));
	    }
	    return employees;
	}

}
