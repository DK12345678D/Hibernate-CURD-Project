<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%--  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Page</title>

<!-- CSS Styling -->
<style>
    body {
        background-color: #f0f4f8;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        margin: 0;
        padding: 0;
    }

    h1 {
        background-color: #ffd700;
        color: #333;
        padding: 20px;
        margin-bottom: 10px;
        border-radius: 10px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    form {
        background-color: #ffffff;
        padding: 30px;
        border-radius: 12px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        width: 400px;
        margin-top: 30px;
    }

    table {
        width: 100%;
    }

    td {
        padding: 10px 5px;
    }

    input[type="text"] {
        width: 95%;
        padding: 8px;
        border: 1px solid #ccc;
        border-radius: 6px;
    }

    input[type="submit"],
    input[type="reset"] {
        padding: 10px 20px;
        background-color: #4CAF50;
        color: white;
        border: none;
        border-radius: 6px;
        cursor: pointer;
        margin-right: 10px;
    }

    input[type="submit"]:hover,
    input[type="reset"]:hover {
        background-color: #45a049;
    }

    a {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        color: #007BFF;
        font-weight: bold;
    }

    a:hover {
        color: #0056b3;
    }
</style>
</head>

<body>
<center>
    <h1>WELCOME TO STUDENT PAGE!!</h1>

    <form action="insertStud" method="post">
        <table>
            <tr>
                <td><label>STUDENT ID</label></td>
                <td><input type="text" name="sid" ></td>
            </tr>
            <tr>
                <td><label>STUDENT NAME</label></td>
                <td><input type="text" name="sname" ></td>
            </tr>
            <tr>
                <td><label>STUDENT FEE</label></td>
                <td><input type="text" name="sfee" ></td>
            </tr>
            <tr>
                <td><label>AGE</label></td>
                <td><input type="text" name="age" ></td>
            </tr>
            <tr>
                <td><label>MOBILE</label></td>
                <td><input type="text" name="mob" ></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Insert">
                    <input type="reset" value="Reset">
                </td>
            </tr>
        </table>
    </form>

    <div>${message}</div>
     <br>
    <a href="StudData">Show Record</a>
</center>
</body>
</html>
