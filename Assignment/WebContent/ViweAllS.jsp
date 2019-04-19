<%@page import="com.traininigbasket.assignment.beans.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.traininigbasket.assignment.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table>

<a href="addstudent.jsp">Add Students</a>
<thead><tr><th>Student ID </th> <th>Full Name</th> <th>Department</th> </tr> </thead>
	<%
		List<Student> students = new StudentDAO().getAllStudent();
		if (students != null) {
			for (Student s : students) {
				%>
				<tr><td><%=s.getStudentId() %></td><td><%=s.getStudentName() %></td><td><%=s.getDepartment() %></td></tr>
				<%
			}
		}
	%>
</table>

</body>
</html>