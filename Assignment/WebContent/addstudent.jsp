<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="ViweAllS.jsp">View All Students</a>
	<form action="StudentController" method="get">
		<input type="text" name="sname"> <input type="text"
			name="department"> <input type="submit" name="btn">
	</form>
</body>
</html>