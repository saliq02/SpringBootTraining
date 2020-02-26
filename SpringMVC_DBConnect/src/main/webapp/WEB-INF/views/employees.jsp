<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table align="center" border="1">

<tr>
	<th>Employee Id</th>
	<th>Employee Name</th>
	<th>Salary</th>
	<th>Date of Birth</th>

</tr>

<c:forEach items="${employees }"  var="emp">
	<tr>
		<td>${emp.empId }</td>
		<td>${emp.empName }</td>
		<td>${emp.salary}</td>
		<td>${emp.dob}</td>

	</tr>
</c:forEach>





</table>


</body>
</html>