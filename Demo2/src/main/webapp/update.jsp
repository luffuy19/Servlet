<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.chainsys.model.Person"%>
<%@ page import="com.chainsys.dao.StudentImp1"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Form with Validation</title>
<link rel="stylesheet" href="register.css">
</head>
<body>

	<div class="container">
		<%
		StudentImp1 stu = new StudentImp1();
		ArrayList<Person> person = (ArrayList<Person>) stu.getAllUsers();
		Person p = person.get(1);
		%>
		<form id="registrationForm" action="FristExample" method="post">
			<h2>Update Form</h2>
			<div class="form-group">
				<label for="email">Email:</label> <input type="email" id="email"
					name="email" placeholder="<%=p.getEmail()%>" required>
			</div>
			<div class="form-group">
				<label for="phno">PhoneNo:</label> <input type="tel" id="phno"
					name="phno" placeholder="<%=p.getPhNo()%>" required>
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					id="password" name="password" placeholder="Enter New Password"
					required>
			</div>
			<div class="form-group">
				<input type="hidden" name="action" value="update"> 
				<input type="hidden" name="rollNo" value="<%=request.getParameter("rollNo")%>"> 
				<input type="submit" value="Update">
			</div>
		</form>

	</div>

</body>
</html>
