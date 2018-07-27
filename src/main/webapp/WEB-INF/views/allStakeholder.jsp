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
	<h4>Stakeholders List</h4>

	<table>
		<tr class="table-info">
			<th>ID</th>
			<th>Company Name</th>
			<th>Street</th>
			<th>City</th>
			<th>Post</th>
			<th>Country</th>
			<th>Email</th>
			<th>Role</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${stakeholder}" var="var">
			<tr>
				<td>${var.id}</td>
				<td>${var.name}</td>
				<td>${var.street}</td>
				<td>${var.city}</td>
				<td>${var.post}</td>
				<td>${var.country}</td>
				<td>${var.email}</td>
				<td>${var.stakeRole.roleName}</td>
				<td><a href="<c:url   value="/stakeholder/edit/${var.id}"/>">Edit</a>
					<a href="<c:url   value="/stakeholder/delete/${var.id}"/>">Delete</a></td>
			</tr>

		</c:forEach>

	</table>
	<h4>
		<a href="/RFFapp/stakeholder/add">Add New Stakeholder</a>
	</h4>

	<h4>
		<a href="/RFFapp/admin">Back to Admin Page</a>
	</h4>
</body>
</html>