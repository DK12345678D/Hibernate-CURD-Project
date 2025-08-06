<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="com.app.model.student.Student"%>
<!DOCTYPE html>
<html>
<head>
<title>Student Data</title>
</head>
<body>

	<h1>Welcome to Student Data</h1>
	<table border="1">
		<tr>
			<th>STUDENT-ID</th>
			<th>STUDENT NAME</th>
			<th>STUDENT-FEE</th>
			<th>AGE</th>
			<th>MOBILE</th>
		</tr>

		<%
                List<Student> list = (List<Student>) request.getAttribute("list");
                for (Student s : list) {
            %>
		<tr>
			<td><%= s.getStdId() %></td>
			<td><%= s.getStdName() %></td>
			<td><%= s.getStdFee() %></td>
			<td><%= s.getAge() %></td>
			<td><%= s.getMob() %></td>
		</tr>
		<% } %>
	</table>
	<br />
	<c:forEach begin="1" end="${np}" var="i">
		<a href="StudData?pn=${i}"> <c:out value="${i}" />
		</a>&nbsp;&nbsp; </c:forEach>

</body>
</html>