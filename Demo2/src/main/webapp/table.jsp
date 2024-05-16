<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.demo1.Person" %>
<%@ page import="java.util.ArrayList" %>
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
    <table >
        <tr>
        	<th>RollNo</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Gender</th>
            <th>Delete</th>
            <th>Update</th>
        </tr>
        <% 
        // Assuming "person" is a list of person objects available in request attributes
        ArrayList<Person> person = (ArrayList<Person>) request.getAttribute("person");
        if (person != null) {
            for (Person p : person) {
        %>
        <tr>
        	<td><%= p.getRollNo() %></td>
            <td><%= p.getName() %></td>
            <td><%= p.getEmail() %></td>
            <td><%= p.getPhNo() %></td>
            <td><%= p.getGender() %></td>
           	<td>
           		<form action="FristExample" method="post">
           			<input type="hidden" name="rollNo" value="<%= p.getRollNo() %>">
           			<input type="submit" value="delete" name="action">
           		</form>
           	</td>
           	<td>
           		<a href="http://localhost:8080/Demo2/update.html" >Edit</a>
           	</td>
        </tr>
        <% 
            }
        } else {
        %>
        <tr>
            <td colspan="6">No users found</td>
        </tr>
        <% } %>
    </table>
    <a href="http://localhost:8080/Demo2/">Add User</a>
    
</body>
</html>
