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
	<%@ include file="../parts/header.jspf"%>
	<h4>Show All Users</h4>
	<table class="table table-hover">
		<tr class="table-info">
			<th scope="col">ID</th>
			<th scope="col">First Name</th>
			<th scope="col">Last Name</th>
			<th scope="col">Email</th>
			<th scope="col">Role</th>
			<th scope="col">Actions</th>
			<th scope="col">Orders</th>
		</tr>
		<c:forEach items="${user}" var="var">
			<tr class="table-light">
				<td>${var.id}</td>
				<td>${var.firstName}</td>
				<td>${var.lastName}</td>
				<td>${var.email}</td>
				<td>${var.role.roleName}</td>
				<td><a href="<c:url   value="/user/edit/${var.id}"/>">Edit</a>
					<a href="<c:url   value="/user/delete/${var.id}"/>">Delete</a></td>
				<td><a href="<c:url   value="/order/allByUser/${var.id}"/>">User
						Orders</a></td>
			</tr>
		</c:forEach>
	</table>

	<h4>
		<a class="btn btn-primary btn-lg" href="/RFFapp/user/add"
			role="button">Add New User </a>
	</h4>

</body>
</html>