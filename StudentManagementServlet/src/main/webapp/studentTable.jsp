<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.Student"%>
<%@ page import="com.chainsys.dto.TeacherDb"%>
<%@ page import="java.util.ArrayList"%>
<%
if(session==null || session.getAttribute("teacherClass")==null){
	response.sendRedirect("index.html");
}
String section = (String) session.getAttribute("teacherClass");
ArrayList<Student> al = (ArrayList<Student>) TeacherDb.show(section);
request.setAttribute("student", al);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Information</title>
<style>
table {
	width: 100%;
	border-collapse: collapse;
}

table, th, td {
	border: 1px solid #ddd;
}

th, td {
	padding: 8px;
	text-align: left;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

th {
	background-color: #4CAF50;
	color: white;
}

/* Style for delete button */
.delete-button {
	background-color: #f44336;
	color: white;
	border: none;
	padding: 6px 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	cursor: pointer;
}

/* Style for edit button */
.edit-button {
	background-color: #4CAF50;
	color: white;
	border: none;
	padding: 6px 10px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	cursor: pointer;
}

/* Style for add user link */
.add-user-link {
	background-color: #008CBA;
	color: white;
	padding: 6px 10px;
	text-decoration: none;
}

.add-user-link:hover {
	background-color: #005f6b;
}
</style>
</head>
<body>
	<h2>User Information</h2>
	<form action="SortingServlet" method="post">
		<select name="column" id="column"
			style="width: 7%; padding: 10px; margin: 10px 0; border-radius: 4px; border: 1px solid #ccc; font-size: 16px;">
			<option value="rank">Rank</option>
			<option value="attendance">Attendance</option>
			<option value="name">Name</option>
		</select>
		<button type="submit"
			style="background-color: #007bff; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;">Sort</button>
	</form>
	<form action="SearchServlet" method="post"
		style="display: flex; align-items: center;">
		<input type="search" name="searchQuery"
			style="width: 10%; padding: 10px; margin: 10px 0; border-radius: 4px; border: 1px solid #ccc; font-size: 16px;">
		<input type="button" value="Search"
			style="padding: 10px 20px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px;">
	</form>

	<table>
		<tr>
			<th>RollNo</th>
			<th>Name</th>
			<th>Attendance</th>
			<th>Rank</th>
			<th>Quaterly</th>
			<th>Half Yearly</th>
			<th>Annual Yearly</th>
			<th>Standard</th>
			<th>Class</th>
			<th>Mentor Name</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<%
		ArrayList<Student> student = (ArrayList<Student>) request.getAttribute("student");
		if (student != null) {
			for (Student s : student) {
		%>
		<tr>
			<td><%=s.getRollNo()%></td>
			<td><%=s.getStudentName()%></td>
			<td><%=s.getAttendence()%></td>
			<td><%=s.getStudentRank()%></td>
			<td><%=s.getQuaterly()%></td>
			<td><%=s.getHalfYearly()%></td>
			<td><%=s.getAnnualTotal()%></td>
			<td><%=s.getStandard()%></td>
			<td><%=s.getStudentClass()%></td>
			<td><%=s.getMentorName()%></td>
			<td>
				<form action="DeleteServlet" method="post">
					<input type="hidden" name="rollNo" value="<%=s.getRollNo()%>">
					<input type="submit" class="delete-button" value="delete"
						name="action">
				</form>
			</td>
			<td>
				<form action="FristExample" method="post">
					<a
						href="http://localhost:8080/Demo2/update.jsp?rollNo=<%=s.getRollNo()%>"
						class="edit-button">Edit</a>
				</form>
			</td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="12">No users found</td>
		</tr>
		<%
		}
		%>
	</table>
	<a href="studentRegister.jsp" class="add-user-link">Add User</a>
	<a href="LogoutServlet" class="add-user-link">LogOut</a>
</body>
</html>
