<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.chainsys.model.Person" %>
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
    <table>
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
                    <input type="submit" class="delete-button" value="Delete" name="action">
                </form>
            </td>
            <td>
            	<form action="FristExample" method="post">
                    <a href="http://localhost:8080/Demo2/update.jsp?rollNo=<%=p.getRollNo() %>" class="edit-button" >Edit</a>
                </form>
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
    <a href="http://localhost:8080/Demo2/" class="add-user-link">Add User</a>
    
</body>
</html>

