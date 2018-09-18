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
	<h4>Trucks List</h4>
	<table class="table table-hover">
		<tr class="table-info">
			<th scope="col">ID</th>
			<th scope="col">Truck Number</th>
			<th scope="col">Actions</th>
		</tr>
		<c:forEach items="${truck}" var="var">
			<tr class="table-light">
				<td>${var.id}</td>
				<td>${var.plateNumber}</td>
				<td><a href="<c:url   value="/truck/edit/${var.id}"/>">Edit</a>
					<a href="<c:url   value="/truck/delete/${var.id}"/>">Delete</a></td>
			</tr>
		</c:forEach>
		<tr>
	</table>
	<h4>
		<a class="btn btn-primary btn-lg" href="/RFFapp/truck/add"
			role="button">Add New Truck</a>
	</h4>


</body>
</html>