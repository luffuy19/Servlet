<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Information</title>
<style type="text/css">
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
</style>
</head>
<body>
	<h2>User Information</h2>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Phone Number</th>
			<th>Password</th>
			<th>Gender</th>
		</tr>
		<tr>
			<td><%= request.getParameter("username") %></td>
			<td><%= request.getParameter("email") %></td>
			<td><%= request.getParameter("phno") %></td>
			<td><%= request.getParameter("password") %></td>
			<td><%= request.getParameter("gender") %></td>
		</tr>
	</table>
</body>
</html>
