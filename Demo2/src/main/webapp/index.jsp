<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
		String msg=(String)request.getAttribute("namemessage");
		if(msg==null){
	%>
    <form id="registrationForm" action="FristExample">
        <h2>Registration Form</h2>
        <div class="form-group">
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="phno">PhoneNo:</label>
            <input type="tel" id="phno" name="phno" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
        </div>
        <div class="form-group-gender">
            <br>
            <label for="gender">Male</label>
            <br>
            <input type="radio" id="gender" name="gender" value="Male" required>
            <label for="gender">Female</label>
            <input type="radio" id="gender" name="gender" value="Female" required>
            <label for="gender">Not Prefered</label>
            <input type="radio" id="gender" name="gender" value="Not Prefered" required>
        </div>
        <br>
        <button>Register</button>
    </form>
    <%
		}
		else{
    %>
    <form id="registrationForm" action="FristExample">
        <h2>Registration Form</h2>
        <div class="form-group">
            <label for="username">Username:</label>
         <input type="text" id="username" name="username" placeholder="<%=msg %>" required>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div class="form-group">
            <label for="phno">PhoneNo:</label>
            <input type="tel" id="phno" name="phno" required>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="confirmPassword">Confirm Password:</label>
            <input type="password" id="confirmPassword" name="confirmPassword" required>
        </div>
        <div class="form-group-gender">
            <br>
            <label for="gender">Male</label>
            <br>
            <input type="radio" id="gender" name="gender" value="Male" required>
            <label for="gender">Female</label>
            <input type="radio" id="gender" name="gender" value="Female" required>
            <label for="gender">Not Prefered</label>
            <input type="radio" id="gender" name="gender" value="Not Prefered" required>
        </div>
        <br>
        <button>Register</button>
    </form>
    <%
		}
    %>
</div>

</body>
</html>