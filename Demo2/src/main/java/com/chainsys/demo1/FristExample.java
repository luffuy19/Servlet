package com.chainsys.demo1;

import java.io.IOException;
import java.io.PrintWriter;

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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FristExample() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter writer = response.getWriter();
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String phno = request.getParameter("phno");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		request.getRequestDispatcher("table.jsp").forward(request, response);
//		writer.print("<table>\r\n<tr>\r\n"
//				+ "    <th>Name</th>\r\n"
//				+ "    <th>Email</th>\r\n"
//				+ "    <th>Phone Number</th>\r\n"
//				+ "    <th>Password</th>\r\n"
//				+ "    <th>Gender</th>\r\n"
//				+ "  </tr>"
//				+ "  <tr>\r\n"
//				+ "    <th>"+name+"</th>\r\n"
//				+ "    <th>"+email+"</th>\r\n"
//				+ "    <th>"+phno+"</th>\r\n"
//				+ "    <th>"+password+"</th>\r\n"
//				+ "    <th>"+gender+"</th>\r\n"
//				+ "  </tr>\r\n"
//				+ "</table>");
//		System.out.println(name);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
