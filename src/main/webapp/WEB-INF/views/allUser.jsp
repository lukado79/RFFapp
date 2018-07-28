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

	<h4>Show All Users</h4>
	<table>
		<tr class="table-info">
			<th scope="row">ID</th>
			<th scope="row">First Name</th>
			<th scope="row">Last Name</th>
			<th scope="row">Email</th>
			<th scope="row">Role</th>
			<th scope="row">Actions</th>
		</tr>
		<c:forEach items="${user}" var="var">
			<tr>
				<td>${var.id}</td>
				<td>${var.firstName}</td>
				<td>${var.lastName}</td>
				<td>${var.email}</td>
				<td>${var.role.roleName}</td>
				<td><a href="<c:url   value="/user/edit/${var.id}"/>">Edit</a>
					<a href="<c:url   value="/user/delete/${var.id}"/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<h4>
		<a href="/RFFapp/user/add">Add New User</a>
	</h4>

</body>
</html>