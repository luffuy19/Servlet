<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Student Registration</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f7f7f7;
        margin: 0;
        padding: 0;
    }
    .container {
        max-width: 400px;
        margin: 50px auto;
        background-color: #ffffff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    h2 {
        text-align: center;
        color: #333333;
    }

    input[type="text"],
    input[type="email"],
    input[type="password"] {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #cccccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        width: 100%;
        background-color: #8a2be2;
        color: #ffffff;
        border: none;
        padding: 10px;
        border-radius: 4px;
        cursor: pointer;
        font-size: 16px;
    }

    input[type="submit"]:hover {
        background-color: #6c1c9e;
    }
</style>
</head>
<body>

<div class="container">
	
    <h2>Student Registration</h2>
    <form action="InsertServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required>

        <label for="attendance">Attendance:</label>
        <input type="text" id="attendance" name="attendance" required>

        <label for="standard">Standard:</label>
        <input type="text" id="standard" name="standard" required>

        <input type="submit" value="Register">
    </form>
</div>

</body>
</html>
