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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
    }
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("rollNo"));
		 Cookie[] cookies = request.getCookies();
	        
	        // Check if cookies are not null
	        if (cookies != null) {
	        	String value = null;
	            for (Cookie cookie : cookies) {
	                // Check if the cookie's name matches the one you're looking for
	                if (cookie.getName().equals("section")) {
	                    response.getWriter().println("section: " + cookie.getValue());
	                    value = cookie.getValue();
	                    System.out.println(value);
	                }
	            }
	            HttpSession session = request.getSession(false);
	    		if(session!=null) {
	    			String studentClass = (String) session.getAttribute("teacherClass");
	    			try {
	    				TeacherDb.delete(id, value);
	    				response.sendRedirect("studentTable.jsp");
	    			} catch (ClassNotFoundException | SQLException e) {
	    				e.printStackTrace();
	    			}
	    		}
	        } else {
	            response.getWriter().println("No cookies found!");
	        }
		
	}

}
