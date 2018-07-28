<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://bootswatch.com/4/flatly/bootstrap.min.css">
</head>
<body>
	<h4>All User Role</h4>

	<table>
		<tr class="table-info">
			<th scope="row">ID</th>
			<th scope="row">Role Name</th>
		</tr>
		<c:forEach items="${userRole}" var="var">
			<tr>
				<td>${var.id}</td>
				<td>${var.roleName}</td>
				<td><a href="<c:url   value="/userRole/edit/${var.id}"/>">Edit</a>
					<a href="<c:url   value="/userRole/delete/${var.id}"/>">Delete</a>
				</td>
			</tr>
		</c:forEach>


	</table>

	<h4>
		<a href="/RFFapp/userRole/add">Add New User Role</a>
	</h4>


</body>
</html>