package com.chainsys.dao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		HttpSession session = request.getSession(false);
//		String section = (String) session.getAttribute("teacherClass");
//		if (session != null && session.getAttribute("user") != null) {
//			User user = (User) session.getAttribute("user");
//			int userId = user.getId();
//			String sortField = request.getParameter("sortField");
//			String sortOrder = request.getParameter("sortOrder");
//			String searchQuery = request.getParameter("searchQuery");
//
//			try {
//				List<Contact> contacts = contactOperations.getAllContacts(userId);
//
//				// Apply search filter
//				if (searchQuery != null && !searchQuery.isEmpty()) {
//					contacts = contacts.stream()
//							.filter(contact -> contact.getName().toLowerCase().contains(searchQuery.toLowerCase()))
//							.collect(Collectors.toList());
//				}
//
//				// Apply sorting
//				if (sortField != null && !sortField.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
//					Comparator<Contact> comparator;
//					switch (sortField) {
//					case "name":
//						comparator = Comparator.comparing(Contact::getName);
//						break;
//					default:
//						comparator = Comparator.comparing(Contact::getName);
//						sortField = "name";
//						sortOrder = "asc";
//						break;
//					}
//
//					if ("desc".equalsIgnoreCase(sortOrder)) {
//						comparator = comparator.reversed();
//					}
//
//					contacts = contacts.stream().sorted(comparator).collect(Collectors.toList());
//				}
//
//				request.setAttribute("contacts", contacts);
//				request.setAttribute("sortField", sortField);
//				request.setAttribute("sortOrder", sortOrder);
//				request.setAttribute("searchQuery", searchQuery);
//				request.getRequestDispatcher("viewcontact.jsp").forward(request, response);
//			} catch (SQLException | ClassNotFoundException e) {
//				e.printStackTrace();
//				response.sendRedirect("error.jsp");
//			}
//		} else {
//			response.sendRedirect("login.jsp");
//		}
//	}
//
}
